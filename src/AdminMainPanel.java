import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class AdminMainPanel extends JPanel {
	JButton logOut;
	
	JButton studentReg;
	JButton teacherReg;
	JButton staffReg;
	
	JButton searchStudent;
	JButton searchTeacher;
	JButton searchStaff;
	
	JButton editStudent;
	JButton editTeacher;
	JButton editStaff;
	
	JButton deleteStudent;
	JButton deleteTeacher;
	JButton deleteStaff;
        
        JButton addCourse;
	JButton addBook;
        JButton addLibraryBorrow;
        JButton returnHistory;
	AdminMainPanel (){
		
		setLayout (new GridLayout(0,1));
		
		JPanel p1 = new JPanel ();
		p1.add(new JLabel ("Registration"));
		add(p1);
		
		JPanel p2 = new JPanel ();
		p2.add(studentReg = new JButton ("Student"));
		p2.add(teacherReg = new JButton ("Teacher"));
		//p2.add(staffReg = new JButton ("Staff"));
                p2.add (addCourse = new JButton ("Add Course"));
                p2.add(addBook = new JButton ("Add Book"));
                p2.add(addLibraryBorrow = new JButton ("Borrow Book History"));
                p2.add(returnHistory = new JButton ("Book Return History"));
		add(p2);
		
		JPanel p8 = new JPanel ();
		p8.add(new JLabel ("Show Information"));
		add(p8);
		
		JPanel p9 = new JPanel ();
		p9.add(searchStudent = new JButton ("Student"));
		p9.add(searchTeacher= new JButton ("Teacher"));
		p9.add(searchStaff = new JButton ("Staff"));
		add(p9);
		
		JPanel p3 = new JPanel ();
		p3.add(new JLabel ("Manipulation"));
		add(p3);
		
		JPanel p4 = new JPanel ();
		p4.add(editStudent= new JButton ("Student"));
		p4.add(editTeacher = new JButton ("Teacher"));
		p4.add(editStaff = new JButton ("Staff"));
		add(p4);
		
		JPanel p5 = new JPanel ();
		p5.add(new JLabel ("Deletion"));
		add(p5);
		
		JPanel p6 = new JPanel ();
		p6.add(deleteStudent = new JButton ("Student"));
		p6.add(deleteTeacher = new JButton ("Teacher"));
		p6.add(deleteStaff = new JButton ("Staff"));
		add(p6);
		
		JPanel p7 = new JPanel ();
		p7.add(logOut = new JButton ("Logout"));
		add(p7);
		
	}
	
}
