import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ProfileShowPanel extends JPanel {
	
	JTextArea output;
	JScrollPane scrl;
	
	ProfileShowPanel (){
		output = new JTextArea(20,40);
		Font font = new Font ("Serif",Font.BOLD+Font.ITALIC,22);
		scrl = new JScrollPane(output);
		output.setEditable(false);
		add(scrl);
		
		output.setFont(font);
	}

}
