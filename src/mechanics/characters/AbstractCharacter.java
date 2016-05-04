package mechanics.characters;

import mechanics.ships.AbstractSpacecraft;

public abstract class AbstractCharacter {
	private AbstractCharacterBrain brain;
	private AbstractSpacecraft spacecraft;
	private TeamEnum team;
	private boolean isDead;

	public AbstractCharacter(AbstractSpacecraft spacecraft, TeamEnum team) {
		this.spacecraft = spacecraft;
		this.spacecraft.setPilot(this);
		this.team = team;
	}
	
	public AbstractCharacterBrain getBrain() {
		return brain;
	}

	public void setBrain(AbstractCharacterBrain brain) {
		this.brain = brain;
	}

	public AbstractSpacecraft getSpacecraft() {
		return spacecraft;
	}

	public void setSpacecraft(AbstractSpacecraft spacecraft) {
		this.spacecraft = spacecraft;
	}
	
	public void kill(){
		if(getBrain() instanceof AllianceCharacterBrain){
			((AllianceCharacterBrain)getBrain()).queueForDeathMessage();
			getBrain().getCentralBrain().removeAllianceCharacter(this);
		}else{
			getBrain().getCentralBrain().removeAlienCharacter(this);
		}
	}
	
	public boolean isDead(){
		return isDead;
	}
	
	public void setDead(){
		isDead = true;
	}

	public TeamEnum getTeam() {
		return team;
	}

	public void setTeam(TeamEnum team) {
		this.team = team;
	}

}
