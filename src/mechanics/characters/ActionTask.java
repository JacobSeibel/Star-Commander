package mechanics.characters;

import mechanics.AbstractTask;
import mechanics.CentralBrain;
import mechanics.ships.AbstractAlienSpacecraft;
import mechanics.ships.AbstractSpacecraft;
import mechanics.ships.FacingEnum;

public class ActionTask extends AbstractTask {

	private AbstractCharacterBrain characterBrain;
	private int exitAfter = 12;
	
	public ActionTask(AbstractCharacterBrain characterBrain) {
		super();
		this.characterBrain = characterBrain;
	}

	@Override
	protected int getPeriod() {
		return 4;
	}

	@Override
	protected void doTask() {
		CentralBrain centralBrain = characterBrain.getCentralBrain();
		
		if(centralBrain.getAlienCharacters().isEmpty()){
			exitAfter--;
			if(exitAfter <= 0){
				System.exit(0);
			}
		}
		
		AbstractSpacecraft ship = characterBrain.getCharacter().getSpacecraft();
		
		if(ship instanceof AbstractAlienSpacecraft){
			ship.heal(1);
		}
		
		AbstractSpacecraft targetShip = centralBrain.determineNearestTarget(ship);
		
		//If no target was found, set pilot to idle mode and do nothing
		if(targetShip == null){
			ship.getPilot().getBrain().setIdle(true);
			return;
		}else{
			ship.getPilot().getBrain().setIdle(false);
			ship.getPilot().getBrain().setTarget(targetShip);
		}
		
		//Distance in each coord
		int x = targetShip.getXcoord() - ship.getXcoord();
		int y = targetShip.getYcoord() - ship.getYcoord();
		int z = targetShip.getZcoord() - ship.getZcoord();
		
		//If the ship is below the run away threshold, it will move in the opposite direction
		if(ship.isRunningAway()){
			x = -x;
			y = -y;
			z = -z;
		}
		
		//Need to reduce the distance down to fit in ship speed
		double speed = (double)ship.getSpeed();
		
		double largestDist = Math.abs(x);
		if(largestDist < Math.abs(y)) largestDist = Math.abs(y);
		if(largestDist < Math.abs(z)) largestDist = Math.abs(z);
		
		//Whichever direction the ship moves the most in is now the direction it is facing.
		FacingEnum oldDirection = ship.getFacingDirection();
		if(largestDist == Math.abs(x)){
			if(x >= 0){
				ship.setFacingDirection(FacingEnum.POSITIVE_X);
			}else{
				ship.setFacingDirection(FacingEnum.NEGATIVE_X);
			}
		}else if(largestDist == Math.abs(y)){
			if(y >= 0){
				ship.setFacingDirection(FacingEnum.POSITIVE_Y);
			}else{
				ship.setFacingDirection(FacingEnum.NEGATIVE_Y);
			}
		}else if(largestDist == Math.abs(z)){
			if(z >= 0){
				ship.setFacingDirection(FacingEnum.POSITIVE_Z);
			}else{
				ship.setFacingDirection(FacingEnum.NEGATIVE_Z);
			}
		}
		
		//If it flips directions, -1 to speed.
		if(oldDirection != null && oldDirection.isOppositeOf(ship.getFacingDirection())){
			speed -= 1;
			if(speed < 0){
				speed = 0;
			}
		}
			
		//If the ship is close enough, attack and take a penalty to move
		if(largestDist < ship.getRange()){
			//If the target is destroyed, queue appropriate response from pilot
			if(ship.fireOn(targetShip)){
				if(ship.getPilot() instanceof AllianceCharacter){
					((AllianceCharacterBrain)ship.getPilot().getBrain()).queueForCelebration();
				}
			}
			speed -= 1;
			if(speed <0){
				speed = 0;
			}
		}

		double reduceProportion = speed/largestDist;
		x = (int)(((double)x)*reduceProportion);
		y = (int)(((double)y)*reduceProportion);
		z = (int)(((double)z)*reduceProportion);
		
		ship.move(x, y, z);
	}

}
