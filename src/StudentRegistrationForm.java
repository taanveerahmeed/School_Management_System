import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

class StudentRegistrationForm extends JPanel{
	
	JTextField firstName;
	JTextField lastName;
	JComboBox dobdate;
	JComboBox dobmonth;
	JComboBox dobyear;
	JTextField bloodGroup;
	JTextField fatherName;
	JTextField motherName;
	JTextArea presentAddress;
	JTextArea permanentAddress;
	JTextField phoneNumber;
	JTextField email;
	ButtonGroup sex;
	JRadioButton male;
	JRadioButton female;
	JTextField religion;
        JTextField classId;
	ButtonGroup maratialStatus;
	JRadioButton married;
	JRadioButton unmarried;
	
	JTextField nationality;
	JTextField oid;
	JTextField password;
	JComboBox classes;
	JComboBox rolls;
	JComboBox addates;
	JComboBox admonths;
	JComboBox adyears;
	//JTextField admissionDate;
	JButton submit;
        JButton instructions;
	Font fontTitle;
	JButton back;
        String ins = "All the field must be filled. The Admission Date and Birth Date should be selected\nClass IDs\nClass 1: 0101\nClass 2: 0201\nClass 3: 0301\nClass 4: 0401\nClass 5: 0501\nClass 6: 0601\nClass 7: 0701\nClass 8: 0801\nClass 9 (Science): 0901\nClass 9 (Commerce): 0902\nClass 9 (Arts): 0903\nClass 10 (Sceince): 1001\nClass 10 (Commerce): 1002\nClass 10 (Arts): 1003";

	StudentRegistrationForm (){
		fontTitle = new Font ("Serif",Font.BOLD+Font.ITALIC,35);
		setLayout (new GridLayout (0,1));
		JPanel p1 = new JPanel ();
		JLabel pd ;
		p1.add( pd = new JLabel ("Personal Details"));
		pd.setFont(fontTitle);
                p1.add (instructions = new JButton ("Read Instructions"));
                instructions.addActionListener(
                        new ActionListener (){
                        
                            public void actionPerformed (ActionEvent ev){
                                JOptionPane.showMessageDialog(null,ins);
                            
                            }
                        }
                
                );
		add (p1);
		
		JPanel p2 = new JPanel ();
		p2.add(new JLabel ("First Name"));
		p2.add(firstName = new JTextField (20));
		p2.add(new JLabel ("Last Name"));
		p2.add(lastName = new JTextField (20));
		add(p2);
		
		JPanel p3 = new JPanel ();
		p3.add(new JLabel ("Father's Name"));
		p3.add(fatherName = new JTextField (25));
		p3.add(new JLabel ("Mother's Name"));
		p3.add(motherName = new JTextField (25));
		add(p3);
		
		//JPanel p4 = new JPanel ();
		
		//add(p4);
		
		JPanel p5 = new JPanel ();
		p5.add(new JLabel ("Date of Birth"));
		String [] dobdateArray = {"Date","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		p5.add(dobdate = new JComboBox(dobdateArray));
		p5.add(new JLabel("/"));
		String [] dobmonthArray = {"Month","01","02","03","04","05","06","07","08","09","10","11","12"};
		p5.add(dobmonth = new JComboBox(dobmonthArray));
		p5.add(new JLabel("/"));
		String [] dobyearArray = {"Year","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010"};
		p5.add(dobyear = new JComboBox(dobyearArray));
		p5.add(new JLabel ("Gender"));
		p5.add(male = new JRadioButton ("Male",true));
		male.setFont(new Font ("Serif",Font.ITALIC,14));;
		p5.add(female = new JRadioButton ("Female"));
		female.setFont(new Font ("Serif",Font.ITALIC,14));;
		sex = new ButtonGroup ();
		sex.add(male);
		sex.add(female);
		p5.add(new JLabel ("Maratial Status"));
		p5.add(unmarried = new JRadioButton ("Unmarried",true));
		p5.add(married =new JRadioButton ("Married"));
		maratialStatus = new ButtonGroup();
		maratialStatus.add(married);
		maratialStatus.add(unmarried);
		p5.add(new JLabel ("Nationality"));
		p5.add(nationality = new JTextField(15));
		add(p5);
		
		JPanel p6 = new JPanel ();
		p6.add(new JLabel ("Present Address "));
		presentAddress = new JTextArea (3,30);
		p6.add(new JScrollPane (presentAddress));
		presentAddress.setEditable(true);
		p6.add(new JLabel ("Permanent Address"));
		permanentAddress = new JTextArea(3,30);
		p6.add(new JScrollPane (permanentAddress));
		add(p6);
		
		//JPanel p7 = new JPanel ();
		
		//add(p7);
		
		JPanel p8 = new JPanel ();
		p8.add(new JLabel ("Phone"));
		p8.add(phoneNumber = new JTextField(12));
		p8.add(new JLabel ("Email"));
		p8.add(email = new JTextField (20));
		p8.add(new JLabel ("Religion"));
		p8.add(religion = new JTextField(15));
		add(p8);
		
		//JPanel p9 = new JPanel ();
		
		//p9.add(new JLabel ("Blood Group"));
		//p9.add(bloodGroup = new JTextField (15)));
	//	add(p9);
		
		JPanel p10= new JPanel ();
		JLabel ai ;
		p10.add(ai = new JLabel ("Academic Information"));
		ai.setFont(fontTitle);
                //p10.add(new JLabel ("                                              Instructions"));
		add(p10);
		
		JPanel p11 = new JPanel ();
		p11.add(new JLabel ("Class"));
		String [] classArray= {"01","02","03","04","05","06","07","08","09","10"};
		p11.add(classes = new JComboBox(classArray));
                p11.add (new JLabel ("Class ID "));
                p11.add (classId = new JTextField (6));
		
		
		
		p11.add(new JLabel("Admission Date"));
		String [] dateArray = {"Date","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		p11.add(addates = new JComboBox(dateArray));
		p11.add(new JLabel("/"));
		String [] monthArray = {"Month","01","02","03","04","05","06","07","08","09","10","11","12"};
		p11.add(admonths = new JComboBox(monthArray));
		p11.add(new JLabel("/"));
		String [] yearArray = {"Year","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010"};
		p11.add(adyears = new JComboBox(yearArray));
		
		
		String [] rollArray = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40"};
		p11.add(new JLabel ("Class Roll"));
		p11.add(rolls = new JComboBox(rollArray));
		add(p11);
		
		JPanel p12= new JPanel ();
		p12.add(new JLabel("Organizational ID (Auto Generated)"));
		
		p12.add (oid = new JTextField(10));
		oid.setEditable(false);
		JButton generate = new JButton("Generate");
		p12.add(generate);
		generate.addActionListener(
				new ActionListener (){
					public void actionPerformed (ActionEvent ev){
						String id = classes.getSelectedItem() + "-" +adyears.getSelectedItem()+ "-"+rolls.getSelectedItem();
						oid.setText(id);
						
					}
				}
		
		);
		p12.add(new JLabel ("Password"));
		p12.add(password = new JTextField (10));
		add(p12);
		
		
		JPanel p13 = new JPanel ();
		p13.add(submit = new JButton("Submit"));
		p13.add(back = new JButton ("Back"));
		add(p13);
	
		
		
		
	}
        
        public void refresh (){
            
        firstName.setText("");
	lastName.setText("");
	dobdate.setSelectedIndex(0);
	dobmonth.setSelectedIndex(0);
	dobyear.setSelectedIndex(0);
        
        addates.setSelectedIndex(0);
	admonths.setSelectedIndex(0);
	adyears.setSelectedIndex(0);
        
	//bloodGroup.setText("");
	fatherName.setText("");
	motherName.setText("");
	presentAddress.setText("");
	permanentAddress.setText("");
	phoneNumber.setText("");
	email.setText("");
	
	religion.setText("");
        classId.setText("");
	
	nationality.setText("");
	oid.setText("");
	password.setText("");
	

        
        }
	
	
	
	
	
}