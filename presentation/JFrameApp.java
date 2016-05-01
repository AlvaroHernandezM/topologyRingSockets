package presentation;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.BorderLayout;

public class JFrameApp extends JFrame{

	private static final long serialVersionUID = 1L;

	private JPanelConfigurationTopology jPanelConfigurationTopology;
	private JPanelShowInformation showInformation;
	private ActionListenerApp actionListenerApp;

	public JFrameApp(ActionListenerApp actionListenerApp){
		this.setTitle("201311554 - Álvaro Ramiro Hernández Millán");
		this.setSize(950, 650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.getContentPane().setBackground(Color.WHITE);

		this.actionListenerApp = actionListenerApp;
		this.jPanelConfigurationTopology = new JPanelConfigurationTopology();
		this.jPanelConfigurationTopology.setActionListener(this.actionListenerApp);
		this.actionListenerApp.setJFrameApp(this);
		this.actionListenerApp.setJPanelConfigurationTopology(this.jPanelConfigurationTopology);
		this.add(this.jPanelConfigurationTopology, BorderLayout.CENTER);

		this.setVisible(true);
	}

	public void addJPanelShowInformation(String host1,String user1, String host2,String user2, String host3,String user3, String host4,String user4, String serverData){
		this.showInformation = new JPanelShowInformation(host1,user1,host2,user2,host3,user3,host4,user4,serverData);
		Thread thread = new Thread(this.showInformation);
		thread.start();
		this.add(this.showInformation, BorderLayout.CENTER);
	}
}
