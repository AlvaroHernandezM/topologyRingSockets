package presentation;

import logic.*;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.lang.*;


public class JPanelShowInformation extends JPanel implements Runnable{

	private JPanel jPanelConfigurationNode;
	private JPanelJComboBox jPanelJComboBoxNodeShow;
	private String host1,user1,host2,user2,host3,user3,host4,user4,serverData;
	private JTextArea txtArea;
	private JScrollPane scrollPane;
	private JSpinner spinner;
	private Message myIp;
	private RunShell runShell;

	public JPanelShowInformation(String host1,String user1, String host2,String user2, String host3,String user3, String host4,String user4, String serverData){
	super();
	this.myIp = new Message();
	this.host1 = host1;
	this.host2 = host2;
	this.host3 = host3;
	this.host4 = host4;
	this.user1 = user1;
	this.user2 = user2;
	this.user3 = user3;
	this.user4 = user4;	
	this.serverData = serverData;

	this.jPanelConfigurationNode = new JPanel();
	this.jPanelConfigurationNode.setOpaque(false);
	this.jPanelConfigurationNode.setSize(900, 700);
	this.jPanelConfigurationNode.setLayout(new BorderLayout());
	this.jPanelConfigurationNode.setBackground(Color.WHITE);
	this.jPanelConfigurationNode.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	this.setLayout(new GridLayout(1, 1));
	this.setBackground(Color.WHITE);

	this.jPanelJComboBoxNodeShow = new JPanelJComboBox(250,30,"Mostrando información desde:");
	this.jPanelJComboBoxNodeShow.setOpaque(false);
	this.jPanelConfigurationNode.add(this.jPanelJComboBoxNodeShow, BorderLayout.NORTH);

	this.txtArea = new JTextArea(20,1);
	this.txtArea.setEditable(false);
	this.scrollPane = new JScrollPane(this.txtArea);
	this.jPanelConfigurationNode.add(this.scrollPane, BorderLayout.CENTER);

	this.spinner = new JSpinner();
	this.spinner.setValue(new Integer(4000));
	this.jPanelConfigurationNode.add(this.spinner, BorderLayout.SOUTH);

    this.add(this.jPanelConfigurationNode);
	}
	public String getNodeShow(){
		String command =this.jPanelJComboBoxNodeShow.getValue();
		switch(command){
			case "1":
				return this.host1;
			case "2":
				return this.host2;			
			case "3":
				return this.host3;
			case "4":
				return this.host4;
			default:
			break;
		}
		return null;
	}

	@Override
	public void run(){
	while(true){
		try{
		Thread.sleep( (Integer) this.spinner.getValue());
		} catch (InterruptedException e){
			System.out.println(e.getMessage());
		}
		if(this.myIp.getMyIp().equals(this.serverData)){
			this.runShell = new RunShell("cat serverData.txt");
			String[] aux = new String[200];
			aux = this.runShell.getInformation(this.getNodeShow());
			int size = aux.length;
			this.txtArea.setText(null);
			for (int i=0; i<size; i++){
				if(aux[i] != null){
					this.txtArea.append(aux[i]+"\n");					
				}
			}
	//		this.txtArea.append("Se debe mostrar la información de :"+this.getNodeShow()+" y el servidor soy yo. \n");
		} else {
			//debe hacerse la lectura remota (pendiente)			
			this.txtArea.append("Se debe mostrar la información de :"+this.getNodeShow()+" y debo conectarme al servidor: "+this.serverData+"\n");
		}
	}
	}
}
