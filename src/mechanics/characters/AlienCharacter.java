package mechanics.characters;

import mechanics.CentralBrain;
import mechanics.ships.AbstractSpacecraft;

public class AlienCharacter extends AbstractCharacter {

	public AlienCharacter(CentralBrain centralBrain, AbstractSpacecraft spacecraft, TeamEnum team) {
		super(spacecraft, team);
		//Temporarily hard coding the flee percent
		setBrain(new AlienCharacterBrain(centralBrain, this, .75));
	}

}
