package mechanics.ships;

import mechanics.CentralBrain;

public class Interceptor extends AbstractAlienSpacecraft{

	public Interceptor(CentralBrain centralBrain) {
		super(centralBrain);

		setHitpoints(SpacecraftConstants.INTERCEPTOR_BASE_HITPOINTS);
		setMaxHitpoints(SpacecraftConstants.INTERCEPTOR_BASE_HITPOINTS);
		setDamage(SpacecraftConstants.INTERCEPTOR_DAMAGE);
		setRange(SpacecraftConstants.INTERCEPTOR_RANGE);
		setSpeed(SpacecraftConstants.INTERCEPTOR_SPEED);
		
		int xcoord = (int)(Math.random()*20) + 50;
		int ycoord = (int)(Math.random()*20);
		int zcoord = (int)(Math.random()*20);
		setXcoord(xcoord);
		setYcoord(ycoord);
		setZcoord(zcoord);
	}

}
