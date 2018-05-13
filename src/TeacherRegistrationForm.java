import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class TeacherRegistrationForm extends RegistrationForm {
	
	JComboBox joinDt,joinMn,joinYr;
	JTextField department,post;
	JTextArea educationalBackground;
	JScrollPane scrl;
	JTextField salary;
        JTextArea output;

	TeacherRegistrationForm (){
                
		JPanel p10= new JPanel ();
		JLabel ai;
		p10.add(ai = new JLabel ("Academic Information"));
		ai.setFont(fontTitle);
		add(p10);
		
		JPanel p11 = new JPanel ();
		
		p11.add(new JLabel("Joining Date"));
		String [] dateArray = {"Date","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		p11.add(joinDt = new JComboBox(dateArray));
		p11.add(new JLabel("/"));
		String [] monthArray = {"Month","01","02","03","04","05","06","07","08","09","10","11","12"};
		p11.add(joinMn = new JComboBox(monthArray));
		p11.add(new JLabel("/"));
		String [] yearArray = {"Year","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010"};
		p11.add(joinYr = new JComboBox(yearArray));
		p11.add(new JLabel ("   Department "));
		p11.add(department = new JTextField(15));
		p11.add(new JLabel (" Post "));
		p11.add(post = new JTextField (15));
		p11.add(new JLabel ("  Salary  "));
		p11.add(salary = new JTextField (10));
		add(p11);
		
		JPanel p12 = new JPanel ();
		p12.add(new JLabel ("Educational Background  "));
		educationalBackground = new JTextArea(3,30);
		scrl = new JScrollPane(educationalBackground);
		p12.add(scrl);
		add(p12);
		
		JPanel p13= new JPanel ();
		p13.add(new JLabel("Organizational ID (Auto Generated)"));
		
		p13.add (oid = new JTextField(10));
		oid.setEditable(true);
		/*JButton generate = new JButton("Generate");
		p13.add(generate);
		generate.addActionListener(
				new ActionListener (){
					public void actionPerformed (ActionEvent ev){
					//	String id = classes.getSelectedItem() + "-" +adyears.getSelectedItem()+ "-"+rolls.getSelectedItem();
						//oid.setText(id);
						
					}
				}
		
		);*/
		p13.add(new JLabel ("Password"));
		p13.add(password = new JTextField (10));
		add(p13);
		
                
		
		JPanel p14 = new JPanel ();
		p14.add(submit = new JButton("Submit"));
		p14.add(back = new JButton ("Back"));
               // p14.add(output = new JTextArea (3,30));
		add(p14);
                refresh();
	
		
	}
        
        public void refresh (){
            
            super.refresh();
            department.setText("");
            educationalBackground.setText("");
            post.setText("");
            salary.setText("");
            joinDt.setSelectedIndex(0);
            joinMn.setSelectedIndex(0);
            joinYr.setSelectedIndex(0);
        
        }
}
