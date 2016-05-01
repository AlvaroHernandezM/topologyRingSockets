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

	public void addJPanelShowInformation(String host1, String host2, String host3, String host4){
		this.showInformation = new JPanelShowInformation(host1,host2,host3,host4);
		Thread thread = new Thread(this.showInformation);
		thread.start();
		this.add(this.showInformation, BorderLayout.CENTER);
	}
}
