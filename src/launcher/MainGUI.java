package launcher;

import java.awt.Insets;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.DefaultCaret;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainGUI extends JFrame {

	private static final long serialVersionUID = -956648331843558969L;
	public static final String TITLE = "Star Commander";
	
	private JTextArea commsTextArea;
	
	public MainGUI() {
		initComponents();
	}
	
	private void initComponents(){
		setTitle(TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel commsLabel = new JLabel("Comms:");
		commsTextArea = new JTextArea(20, 40);
		commsTextArea.setEditable(false);
		commsTextArea.setMargin(new Insets(10,10,10,10));
		DefaultCaret caret = (DefaultCaret)commsTextArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		JScrollPane commsScroll = new JScrollPane(commsTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		commsScroll.createVerticalScrollBar();
		
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(commsLabel))
								.addGroup(layout.createSequentialGroup()
										.addComponent(commsScroll)))
						.addContainerGap(27, Short.MAX_VALUE))
		);
		
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(commsLabel))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(commsScroll))
						.addContainerGap(27, Short.MAX_VALUE))
				);
		
		pack();
	}
	
	public JTextArea getCommsTextArea(){
		return commsTextArea;
	}
	
	public void setCommsTextArea(JTextArea commsTextArea){
		this.commsTextArea = commsTextArea;
	}
	
}
