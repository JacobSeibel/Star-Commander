package mechanics.ships;

import mechanics.CentralBrain;

public class Python extends AbstractSpacecraft {
	
	public Python(CentralBrain centralBrain) {
		super(centralBrain);
		setHitpoints(SpacecraftConstants.PYTHON_BASE_HITPOINTS);
		setMaxHitpoints(SpacecraftConstants.PYTHON_BASE_HITPOINTS);
		setDamage(SpacecraftConstants.PYTHON_DAMAGE);
		setRange(SpacecraftConstants.PYTHON_RANGE);
		setSpeed(SpacecraftConstants.PYTHON_SPEED);
		
		int xcoord = (int)Math.random()*20;
		int ycoord = (int)Math.random()*20;
		int zcoord = (int)Math.random()*20;
		setXcoord(xcoord);
		setYcoord(ycoord);
		setZcoord(zcoord);
	}
	
}
