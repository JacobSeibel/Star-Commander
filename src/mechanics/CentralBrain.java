package mechanics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;

import mechanics.characters.AbstractCharacter;
import mechanics.characters.AlienCharacter;
import mechanics.characters.AllianceCharacter;
import mechanics.comms.CommsBrain;
import mechanics.ships.AbstractSpacecraft;
import mechanics.ships.FacingEnum;
import mechanics.ships.RelativeDirectionEnum;

public class CentralBrain extends Timer{
	
	private CommsBrain commsBrain;
	private List<AllianceCharacter> allianceCharacters;
	private List<AlienCharacter> alienCharacters;
	private List<AbstractSpacecraft> space;
	
	public CentralBrain(CommsBrain commsBrain) {
		this.commsBrain = commsBrain;
		allianceCharacters = new ArrayList<>();
		alienCharacters = new ArrayList<>();
		space = new ArrayList<AbstractSpacecraft>();
	}

	public void schedule(AbstractTask task){
		this.schedule(task, 0, 250);
	}

	public CommsBrain getCommsBrain() {
		return commsBrain;
	}

	public List<AllianceCharacter> getAllianceCharacters() {
		return allianceCharacters;
	}

	public void addAllianceCharacter(AllianceCharacter allianceCharacter) {
		this.allianceCharacters.add(allianceCharacter);
	}
	
	public void removeAllianceCharacter(AbstractCharacter allianceCharacter){
		this.allianceCharacters.remove(allianceCharacter);
	}
	
	public AllianceCharacter getRandomAllianceCharacter(List<AllianceCharacter> excludeList){
		List<AllianceCharacter> characters = new ArrayList<>(allianceCharacters);
		characters.removeAll(excludeList);
		
		if(characters.isEmpty()){
			return null;
		}
		
		int randIndex = (int)(Math.random()*characters.size());
		return characters.get(randIndex);
	}
	
	public void addShipToSpace(AbstractSpacecraft ship){
		space.add(ship);
	}
	
	public void removeShipFromSpace(AbstractSpacecraft ship){
		space.remove(ship);
	}
	
	/**
	 * Returns null if no target found
	 * @param source
	 * @return
	 */
	public AbstractSpacecraft determineNearestTarget(AbstractSpacecraft source){
		HashMap<AbstractSpacecraft, Integer> distMap = new HashMap<>();
		for(AbstractSpacecraft ship : space){
			if(ship.getPilot().getTeam().equals(source.getPilot().getTeam())){
				continue;
			}
			
			int distance = getDistanceToTarget(source, ship);
			
			distMap.put(ship, Integer.valueOf(distance));
		}
		
		if(distMap.isEmpty()){
			return null;
		}
		
		int lowestDistance = Integer.MAX_VALUE;
		AbstractSpacecraft nearestShip = null;
		for(AbstractSpacecraft ship : distMap.keySet()){
			if(lowestDistance > distMap.get(ship).intValue()){
				lowestDistance = distMap.get(ship).intValue();
				nearestShip = ship;
			}
		}
		return nearestShip;
	}
	
	public static int getDistanceToTarget(AbstractSpacecraft source, AbstractSpacecraft target){
		int distance = (int)(
				Math.sqrt(
						Math.pow(
								(target.getXcoord() - source.getXcoord()), 2)
						+ Math.pow(
								(target.getYcoord() - source.getYcoord()), 2)
						+ Math.pow(
								(target.getZcoord() - source.getZcoord()), 2)));
		
		return distance;
	}

	public List<AlienCharacter> getAlienCharacters() {
		return alienCharacters;
	}

	public void addAlienCharacter(AlienCharacter alienCharacter) {
		this.alienCharacters.add(alienCharacter);
	}
	
	public void removeAlienCharacter(AbstractCharacter alienCharacter){
		this.alienCharacters.remove(alienCharacter);
	}

	public static RelativeDirectionEnum determineRelativeDirection(FacingEnum facingDirection, FacingEnum direction) {
		if(direction.equals(FacingEnum.POSITIVE_Z)){
			return RelativeDirectionEnum.ABOVE;
		}
		if(direction.equals(FacingEnum.NEGATIVE_Z)){
			return RelativeDirectionEnum.BELOW;
		}
		if(facingDirection.equals(direction)){
			return RelativeDirectionEnum.AHEAD;
		}
		if(facingDirection.isOppositeOf(direction)){
			return RelativeDirectionEnum.BEHIND;
		}

		if(facingDirection.equals(FacingEnum.POSITIVE_X)){
			if(direction.equals(FacingEnum.POSITIVE_Y)){
				return RelativeDirectionEnum.LEFT;
			}
			if(direction.equals(FacingEnum.NEGATIVE_Y)){
				return RelativeDirectionEnum.RIGHT;
			}
		}
		if(facingDirection.equals(FacingEnum.NEGATIVE_X)){
			if(direction.equals(FacingEnum.POSITIVE_Y)){
				return RelativeDirectionEnum.RIGHT;
			}
			if(direction.equals(FacingEnum.NEGATIVE_Y)){
				return RelativeDirectionEnum.LEFT;
			}
		}
		if(facingDirection.equals(FacingEnum.POSITIVE_Y)){
			if(direction.equals(FacingEnum.POSITIVE_X)){
				return RelativeDirectionEnum.RIGHT;
			}
			if(direction.equals(FacingEnum.NEGATIVE_X)){
				return RelativeDirectionEnum.LEFT;
			}
		}
		if(facingDirection.equals(FacingEnum.NEGATIVE_Y)){
			if(direction.equals(FacingEnum.POSITIVE_X)){
				return RelativeDirectionEnum.LEFT;
			}
			if(direction.equals(FacingEnum.NEGATIVE_X)){
				return RelativeDirectionEnum.RIGHT;
			}
		}
		
		return null;
	}
}
