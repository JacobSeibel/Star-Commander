package mechanics.characters;

import mechanics.CentralBrain;
import mechanics.comms.MessageMoodEnum;
import mechanics.ships.AbstractSpacecraft;

public class AllianceCharacter extends AbstractCharacter {
	private String callsign;
	
	public AllianceCharacter(CentralBrain centralBrain, String callsign, MessageMoodEnum mood, AbstractSpacecraft spacecraft, TeamEnum team) {
		super(spacecraft, team);
		this.callsign = callsign;
		//Temporarily hard coding the flee percent
		setBrain(new AllianceCharacterBrain(centralBrain, this, mood, .5));
	}

	public String getCallsign() {
		return callsign;
	}
	
}
