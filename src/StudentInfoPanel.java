import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class StudentInfoPanel extends JPanel{
	JTextField studentId;
	JButton search,back;
	JTextArea details;
	
	JLabel name = new JLabel();
	JLabel fathername = new JLabel();
	JLabel mothername = new JLabel();
	JLabel dob = new JLabel();
	JLabel gender = new JLabel();
	JLabel presentaddress = new JLabel();
	JLabel permanntadrs = new JLabel();
	JLabel phone = new JLabel();
	JLabel email = new JLabel();
	JLabel religion = new JLabel();
	JLabel maratial = new JLabel();
	JLabel nation = new JLabel();
	JLabel clas = new JLabel();
	JLabel admission = new JLabel();
	JLabel classroll = new JLabel();
	JLabel oid = new JLabel();
	StudentInfoPanel (){
		
		setLayout (new GridLayout (0,1));
		JPanel p1 = new JPanel ();
		p1.add(new JLabel ("Enter Student Id"));
		p1.add(studentId = new JTextField (10));
		p1.add(search = new JButton("Search"));
		p1.add(back = new JButton("Back"));
		add(p1);
		
		
		
		JPanel p2 = new JPanel ();
		p2.add(name);
		add (p2);
		
		JPanel p3 = new JPanel ();
		p3.add(fathername);
		add (p3);
		
		JPanel p4 = new JPanel ();
		p4.add(mothername);
		add (p4);
		
		JPanel p5 = new JPanel ();
		p5.add(dob);
		add (p5);
		
		JPanel p6 = new JPanel ();
		p6.add(gender);
		add (p6);
		
		JPanel p7 = new JPanel ();
		p7.add(presentaddress);
		add (p7);
		
		JPanel p8 = new JPanel ();
		p8.add(permanntadrs);
		add (p8);
		
		JPanel p9 = new JPanel ();
		p9.add(phone);
		add (p9);
		
		JPanel p10 = new JPanel ();
		p10.add(email);
		add (p10);
		
		JPanel p11 = new JPanel ();
		p11.add(religion);
		add (p11);
		
		JPanel p12 = new JPanel ();
		p12.add(maratial);
		add (p12);
		
		JPanel p13 = new JPanel ();
		p13.add(nation);
		add (p13);
		
		JPanel p14 = new JPanel ();
		p14.add(clas);
		add (p14);
		
		JPanel p15 = new JPanel ();
		p15.add(admission);
		add (p15);
		
		JPanel p16 = new JPanel ();
		p16.add(classroll);
		add (p16);
		
		JPanel p17 = new JPanel ();
		p17.add(oid);
		add (p17);
		
		
	}
	
}