package presentation;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class JPanelConfigurationTopology extends JPanel{

	private	JPanel jPanelConfigurationNode;
	private JPanelJTextField textFieldNode1, textFieldNode2, textFieldNode3, textFieldNode4, textFieldUser1, textFieldUser2, textFieldUser3, textFieldUser4;
	private JPanelJComboBox jPanelJComboBoxNode; //,jPanelJComboBoxNodeShow;
	private JButton btnAccept;
	private ActionListenerApp actionListenerApp;

	public JPanelConfigurationTopology(){
	super();

	this.jPanelConfigurationNode = new JPanel();
	this.jPanelConfigurationNode.setOpaque(false);
	this.jPanelConfigurationNode.setSize(900, 700);
	this.jPanelConfigurationNode.setLayout(null);
	this.jPanelConfigurationNode.setBackground(Color.WHITE);
	this.jPanelConfigurationNode.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	this.setLayout(new GridLayout(1, 1));
	this.setBackground(Color.WHITE);

	this.textFieldNode1 = new JPanelJTextField(300,50,100,"IP NODO 1","192.168.0.26");
	this.textFieldNode1.setOpaque(false);
	this.jPanelConfigurationNode.add(this.textFieldNode1);

	this.textFieldUser1 = new JPanelJTextField(420,50,100,"USER NODO 1", "arhm-server");
	this.textFieldUser1.setOpaque(false);
	this.jPanelConfigurationNode.add(this.textFieldUser1);

	this.textFieldNode2 = new JPanelJTextField(470,150,100,"IP NODO 2","192.168.0.27");
    this.textFieldNode2.setOpaque(false);
    this.jPanelConfigurationNode.add(this.textFieldNode2);

    this.textFieldUser2 = new JPanelJTextField(590,150,100,"USER NODO 2", "arhm-server-2");
	this.textFieldUser2.setOpaque(false);
	this.jPanelConfigurationNode.add(this.textFieldUser2);


	this.textFieldNode3 = new JPanelJTextField(300,250,100,"IP NODO 3","192.168.0.28");
    this.textFieldNode3.setOpaque(false);
    this.jPanelConfigurationNode.add(this.textFieldNode3);

    this.textFieldUser3 = new JPanelJTextField(420,250,100,"USER NODO 3", "arhm-server-3");
	this.textFieldUser3.setOpaque(false);
	this.jPanelConfigurationNode.add(this.textFieldUser3);


	this.textFieldNode4 = new JPanelJTextField(120,150,100,"IP NODO 4","192.168.0.21");
    this.textFieldNode4.setOpaque(false);
    this.jPanelConfigurationNode.add(this.textFieldNode4);

    this.textFieldUser4 = new JPanelJTextField(240,150,100,"USER NODO 4", "arhm-server-4");
	this.textFieldUser4.setOpaque(false);
	this.jPanelConfigurationNode.add(this.textFieldUser4);

	this.jPanelJComboBoxNode = new JPanelJComboBox(250,400,"Servidor de datos");
	this.jPanelJComboBoxNode.setOpaque(false);
	this.jPanelConfigurationNode.add(this.jPanelJComboBoxNode);
/*
	this.jPanelJComboBoxNodeShow = new JPanelJComboBox(500,400,"Mostrar información inicialmente");
	this.jPanelJComboBoxNodeShow.setOpaque(false);
	this.jPanelConfigurationNode.add(this.jPanelJComboBoxNodeShow);
*/
	this.btnAccept = new JButton("CONTINUAR");
	this.btnAccept.setBackground(Color.WHITE);
	this.btnAccept.setBounds(350, 550, 150, 50);
	this.jPanelConfigurationNode.add(this.btnAccept);

    this.add(this.jPanelConfigurationNode);
	}

	public void setActionListener(ActionListenerApp actionListenerApp){
		this.actionListenerApp = actionListenerApp;
		this.btnAccept.setActionCommand(this.actionListenerApp.COMMAND_ACCEPT_CONFIGURATION);
		this.btnAccept.addActionListener(this.actionListenerApp);
	}

	public String getHostNode1(){
		return this.textFieldNode1.getValue();
	}
	public String getHostNode2(){
		return this.textFieldNode2.getValue();
	}
	public String getHostNode3(){
		return this.textFieldNode3.getValue();
	}
	public String getHostNode4(){
		return this.textFieldNode4.getValue();
	}
	public String getUserNode1(){
		return this.textFieldUser1.getValue();
	}
	public String getUserNode2(){
		return this.textFieldUser2.getValue();
	}
	public String getUserNode3(){
		return this.textFieldUser3.getValue();
	}
	public String getUserNode4(){
		return this.textFieldUser4.getValue();
	}
	public String getServerData(){
		String command =this.jPanelJComboBoxNode.getValue();
		switch(command){
			case "1":
				return this.textFieldNode1.getValue();
			case "2":
				return this.textFieldNode2.getValue();
			
			case "3":
				return this.textFieldNode3.getValue();
			
			case "4":
				return this.textFieldNode4.getValue();
			
			default:
			break;
		}
		return null;
	}
	/*
	public String getNodeShow(){
		String command =this.jPanelJComboBoxNodeShow.getValue();
		switch(command){
			case "1":
				return this.textFieldNode1.getValue();
			case "2":
				return this.textFieldNode2.getValue();
			
			case "3":
				return this.textFieldNode3.getValue();
			case "4":
				return this.textFieldNode4.getValue();
			
			default:
			break;
		}
		return null;
	}*/
}
