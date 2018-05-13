import java.awt.*;

import javax.swing.*;

public class TeacherMainPanel extends JPanel {
	JButton home,profile,signout,courseResult,registration,studentInfo,curriculum;
	JButton gradesBySubject,gradesBySemester;
	JButton searchBook,borrows,allBorrows,lfinalcials;
	JButton application,inbox,send;
	JTextArea output = new JTextArea ();
	JScrollPane scrl = new JScrollPane (output);
	ProfileShowPanel profileShow;
	JPanel centerPanel;
	JComboBox option;
       
	
	JLabel academicInfoLabel,academicResulyLabel,libraryLabel,applicationLabel;
	
	TeacherMainPanel (){
		setLayout (new BorderLayout ());
		Font labelFont = new Font ("Serif",Font.ITALIC + Font.BOLD,16);
		
		JPanel north = new JPanel ();
		north.setLayout (new FlowLayout ());
		north.add(new JLabel ("Name of School                                                                                                                                                                     "));
		home =new JButton ("Home");
		north.add(home);
		profile =new JButton ("Profile");
		north.add(profile);
		String [] opt = {"    Options","Change Password"};
		option =new JComboBox (opt);
		north.add(option);
		signout =new JButton ("Sign Out");
		north.add(signout);
		
		JPanel west = new JPanel ();
		west.setLayout(new GridLayout(20,1));
		west.add(academicInfoLabel = new JLabel ("    Academic Information    "));
		west.add(courseResult = new JButton ("Grades"));
		west.add(registration = new JButton ("Registered Coureses"));
		west.add(studentInfo = new JButton ("Student Information"));
		west.add(curriculum = new JButton ("School Curriculum"));
		//west.add( academicResulyLabel = new JLabel ("      Academic Reports    "));
		//west.add(gradesBySubject = new JButton ("Grades By Subject"));
		//west.add(gradesBySemester = new JButton ("Grades By Semester"));
		west.add(libraryLabel = new JLabel ("      Library Information    "));
		west.add(searchBook = new JButton ("Search Book"));
		//west.add(borrows = new JButton ("Current Borrows"));
		//west.add(allBorrows = new JButton ("All Borrows"));
		//west.add(lfinalcials = new JButton ("Financials"));
		west.add(applicationLabel = new JLabel ("    Mails"));
		//west.add(application= new JButton ("Application"));
		west.add(inbox = new JButton ("Inbox"));
		west.add(send = new JButton ("Send Mail"));
		
		this.academicInfoLabel.setFont(labelFont);
		//this.academicResulyLabel.setFont(labelFont);
		this.libraryLabel.setFont(labelFont);
		this.applicationLabel.setFont(labelFont);
		
		
		

		JPanel east = new JPanel ();
	//	east.add(new JButton ("east"));
		

		JPanel south = new JPanel ();
		south.add(new JButton ("south"));
		

		JPanel center = new JPanel ();
		center.add(new JButton ("center"));
		
		add(north,BorderLayout.NORTH);
		add(new JButton("                                                               "),BorderLayout.SOUTH);
		add(west,BorderLayout.WEST);
		
		
		east.add(new JLabel("                                     "));
		add(east,BorderLayout.EAST);
		
		
		centerPanel = new JPanel ();
		profileShow = new ProfileShowPanel();
		centerPanel.add(profileShow);
		add(centerPanel,BorderLayout.CENTER);
		output = new JTextArea("Routine");
		Font font = new Font ("Serif",Font.BOLD+Font.ITALIC,40);
		scrl = new JScrollPane(output);
		//add(output,BorderLayout.CENTER);
		output.setFont(font);
		output.setEditable(false);
	}

}


