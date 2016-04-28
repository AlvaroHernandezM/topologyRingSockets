package presentation;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class JPanelJComboBox extends JPanel{


	private ButtonGroup buttonGroupNodes;
	private JRadioButton jRadioButtonNode1,jRadioButtonNode2,jRadioButtonNode3,jRadioButtonNode4;
	
	/**
	 * 
	 * @param position_y
	 * @param position_x
	 */
	public JPanelJComboBox(int position_x, int position_y, String title){
		super();
		this.setBounds(position_x, position_y, 430, 70);
		this.setBorder(BorderFactory.createTitledBorder(title));
		this.setBackground(Color.WHITE);
		
		this.jRadioButtonNode1 = new JRadioButton("Nodo 1");
		this.jRadioButtonNode1.setBackground(Color.WHITE);
		this.jRadioButtonNode1.setSelected(true);

		this.jRadioButtonNode2 = new JRadioButton("Nodo 2");
		this.jRadioButtonNode2.setBackground(Color.WHITE);

		this.jRadioButtonNode3 = new JRadioButton("Nodo 3");
		this.jRadioButtonNode3.setBackground(Color.WHITE);

		this.jRadioButtonNode4 = new JRadioButton("Nodo 4");
		this.jRadioButtonNode4.setBackground(Color.WHITE);		
		
		this.buttonGroupNodes = new ButtonGroup();
		this.buttonGroupNodes.add(this.jRadioButtonNode1);
		this.buttonGroupNodes.add(this.jRadioButtonNode2);
		this.buttonGroupNodes.add(this.jRadioButtonNode3);
		this.buttonGroupNodes.add(this.jRadioButtonNode4);
		
		this.add(this.jRadioButtonNode1);
		this.add(this.jRadioButtonNode2);
		this.add(this.jRadioButtonNode3);
		this.add(this.jRadioButtonNode4);	
	}

	public String getValue(){
		if(this.jRadioButtonNode1.isSelected()){
			return "1";
		} else{
			if(this.jRadioButtonNode2.isSelected()){
				return "2";
			} else{
				if(this.jRadioButtonNode3.isSelected()){
					return "3";
				} else {
					return "4";
				}
			}
		}
	}

}