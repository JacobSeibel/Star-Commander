package launcher;

import javax.swing.SwingUtilities;

import mechanics.CentralBrain;
import mechanics.characters.AlienCharacter;
import mechanics.characters.AllianceCharacter;
import mechanics.characters.TeamEnum;
import mechanics.comms.CommsBrain;
import mechanics.comms.MessageMoodEnum;
import mechanics.ships.Interceptor;
import mechanics.ships.Python;

public class Launcher {
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
	
	private static void createAndShowGUI(){
		MainGUI mainGUI = new MainGUI();
		mainGUI.setVisible(true);
		
		CommsBrain commsBrain = new CommsBrain(mainGUI);
		CentralBrain centralBrain = new CentralBrain(commsBrain);
		
		centralBrain.addAllianceCharacter(new AllianceCharacter(centralBrain, "Starbuck", MessageMoodEnum.HAPPY, new Python(centralBrain), TeamEnum.ALLIANCE));
		centralBrain.addAllianceCharacter(new AllianceCharacter(centralBrain, "Apollo", MessageMoodEnum.ANGRY, new Python(centralBrain), TeamEnum.ALLIANCE));
		centralBrain.addAllianceCharacter(new AllianceCharacter(centralBrain, "Helo", MessageMoodEnum.SCARED, new Python(centralBrain), TeamEnum.ALLIANCE));
		centralBrain.addAllianceCharacter(new AllianceCharacter(centralBrain, "Hotdog", MessageMoodEnum.HAPPY, new Python(centralBrain), TeamEnum.ALLIANCE));
		centralBrain.addAllianceCharacter(new AllianceCharacter(centralBrain, "Racetrack", MessageMoodEnum.ANGRY, new Python(centralBrain), TeamEnum.ALLIANCE));
		centralBrain.addAllianceCharacter(new AllianceCharacter(centralBrain, "Boomer", MessageMoodEnum.SCARED, new Python(centralBrain), TeamEnum.ALLIANCE));
		
		centralBrain.addAlienCharacter(new AlienCharacter(centralBrain, new Interceptor(centralBrain), TeamEnum.ALIENS));
		centralBrain.addAlienCharacter(new AlienCharacter(centralBrain, new Interceptor(centralBrain), TeamEnum.ALIENS));
		centralBrain.addAlienCharacter(new AlienCharacter(centralBrain, new Interceptor(centralBrain), TeamEnum.ALIENS));
		centralBrain.addAlienCharacter(new AlienCharacter(centralBrain, new Interceptor(centralBrain), TeamEnum.ALIENS));
		centralBrain.addAlienCharacter(new AlienCharacter(centralBrain, new Interceptor(centralBrain), TeamEnum.ALIENS));
		centralBrain.addAlienCharacter(new AlienCharacter(centralBrain, new Interceptor(centralBrain), TeamEnum.ALIENS));
//		centralBrain.addAlienCharacter(new AlienCharacter(centralBrain, new Interceptor(centralBrain), TeamEnum.ALIENS));
//		centralBrain.addAlienCharacter(new AlienCharacter(centralBrain, new Interceptor(centralBrain), TeamEnum.ALIENS));
//		centralBrain.addAlienCharacter(new AlienCharacter(centralBrain, new Interceptor(centralBrain), TeamEnum.ALIENS));
//		centralBrain.addAlienCharacter(new AlienCharacter(centralBrain, new Interceptor(centralBrain), TeamEnum.ALIENS));
//		centralBrain.addAlienCharacter(new AlienCharacter(centralBrain, new Interceptor(centralBrain), TeamEnum.ALIENS));
//		centralBrain.addAlienCharacter(new AlienCharacter(centralBrain, new Interceptor(centralBrain), TeamEnum.ALIENS));
//		centralBrain.addAlienCharacter(new AlienCharacter(centralBrain, new Interceptor(centralBrain), TeamEnum.ALIENS));
	}
	
}
