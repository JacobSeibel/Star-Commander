package mechanics.characters;

import mechanics.AbstractBrain;
import mechanics.CentralBrain;
import mechanics.ships.AbstractSpacecraft;

public abstract class AbstractCharacterBrain extends AbstractBrain{

	private AbstractCharacter character;
	private double fleePercent;
	private boolean isIdle = true;
	private AbstractSpacecraft target;

	public AbstractCharacterBrain(CentralBrain centralBrain, AbstractCharacter character, double fleePercent) {
		super(centralBrain);
		this.character = character;
		this.fleePercent = fleePercent;
		centralBrain.schedule(new ActionTask(this));
	}

	public AbstractCharacter getCharacter() {
		return character;
	}

	public void setCharacter(AbstractCharacter character) {
		this.character = character;
	}

	public double getFleePercent() {
		return fleePercent;
	}

	public void setFleePercent(double fleePercent) {
		this.fleePercent = fleePercent;
	}

	public boolean isIdle() {
		return isIdle;
	}

	public void setIdle(boolean isIdle) {
		this.isIdle = isIdle;
	}

	public AbstractSpacecraft getTarget() {
		return target;
	}

	public void setTarget(AbstractSpacecraft target) {
		this.target = target;
	}
	
}
