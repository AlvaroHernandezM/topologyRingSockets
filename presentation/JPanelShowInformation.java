package presentation;

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
	private String host1,host2,host3,host4;
	private JTextArea txtArea;
	private JScrollPane scrollPane;
	private JSpinner spinner;

	public JPanelShowInformation(String host1, String host2, String host3, String host4){
	super();
	this.host1 = host1;
	this.host2 = host2;
	this.host3 = host3;
	this.host4 = host4;
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

	public String getHostNode1(){
		return this.host1;
	}
	public String getHostNode2(){
		return this.host2;
	}
	public String getHostNode3(){
		return this.host3;
	}
	public String getHostNode4(){
		return this.host4;
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
		this.txtArea.append("Se debe mostrar la informaciónde :"+this.getNodeShow()+"\n");
	}
	}
}
