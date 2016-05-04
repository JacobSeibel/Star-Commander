package mechanics.ships;

import mechanics.CentralBrain;
import mechanics.characters.AbstractCharacter;

public abstract class AbstractSpacecraft {

	private AbstractCharacter pilot;
	private int hitpoints;
	private int maxHitpoints;
	private int xcoord;
	private int ycoord;
	private int zcoord;
	private int damage;
	private int range;
	private int speed;
	private FacingEnum facingDirection;
	
	public AbstractSpacecraft(CentralBrain centralBrain) {
		centralBrain.addShipToSpace(this);
	}
	
	public AbstractCharacter getPilot() {
		return pilot;
	}
	
	public void setPilot(AbstractCharacter pilot) {
		this.pilot = pilot;
	}
	
	public int getHitpoints() {
		return hitpoints;
	}
	
	public void setHitpoints(int hitpoints) {
		this.hitpoints = hitpoints;
	}
	
	/**
	 * Returns false if ship is destroyed
	 * @param damage
	 * @return isShipDestroyed
	 */
	public boolean takeDamage(int damage){
		hitpoints -= damage; 
		
		//If ship is destroyed, kill the pilot and remove the ship from space
		if(hitpoints <= 0){
			pilot.kill();
			pilot.getBrain().getCentralBrain().removeShipFromSpace(this);
			return false;
		}
		return true;
	}
	
	public void heal(int hp){
		if(hitpoints < maxHitpoints){
			hitpoints += hp;
		}
		
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void move(int x, int y, int z){
		xcoord += x;
		ycoord += y;
		zcoord += z;
	}

	public int getXcoord() {
		return xcoord;
	}

	public void setXcoord(int xcoord) {
		this.xcoord = xcoord;
	}

	public int getYcoord() {
		return ycoord;
	}

	public void setYcoord(int ycoord) {
		this.ycoord = ycoord;
	}

	public int getZcoord() {
		return zcoord;
	}

	public void setZcoord(int zcoord) {
		this.zcoord = zcoord;
	}

	public FacingEnum getFacingDirection() {
		return facingDirection;
	}

	public void setFacingDirection(FacingEnum facingDirection) {
		this.facingDirection = facingDirection;
	}
	
	/**
	 * Returns true if the target was destroyed
	 * @param target
	 * @return
	 */
	public boolean fireOn(AbstractSpacecraft target){
		//Incorporate accuracy based on the pilot
		return !target.takeDamage(damage);
	}

	public int getMaxHitpoints() {
		return maxHitpoints;
	}

	public void setMaxHitpoints(int maxHitpoints) {
		this.maxHitpoints = maxHitpoints;
	}
	
	public boolean isRunningAway(){
		if((double)hitpoints/(double)maxHitpoints < pilot.getBrain().getFleePercent()){
			return true;
		}
		return false;
	}
	
}
