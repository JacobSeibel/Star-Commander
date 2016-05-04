package mechanics.comms;

import javax.swing.JTextArea;

import launcher.MainGUI;

public class CommsBrain {

	private MainGUI mainGUI;
	private JTextArea commsTextArea;
	
	public CommsBrain(MainGUI mainGUI) {
		this.mainGUI = mainGUI;
		this.commsTextArea = mainGUI.getCommsTextArea();
	}
	
	//Change message to an object with properties soon
	public void addMessage(Message message){
		String commsLog = commsTextArea.getText();
		commsLog += message.getConstructedMessage()+"\n";
		commsTextArea.setText(commsLog);
		mainGUI.setCommsTextArea(commsTextArea);
	}
}
