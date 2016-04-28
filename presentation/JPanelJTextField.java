package presentation;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPanelJTextField extends JPanel{

	private JTextField jTextField, jTextFieldUser;
	private JLabel lbtitle;

	public JPanelJTextField(int position_x, int position_y, int size, String title, String text){
		super();
		this.lbtitle = new JLabel(title);
		this.lbtitle.setBounds(position_x, position_y-30, size + 20, 55);
		this.setBackground(Color.WHITE);
		this.setBounds(position_x, position_y, size + 20, 55);
		this.jTextField = new JTextField(text);
		this.jTextField.setPreferredSize(new Dimension(size, 25));
		this.add(lbtitle);
		this.add(this.jTextField);
	}

	public String getValue(){
		return this.jTextField.getText();
	}
}

