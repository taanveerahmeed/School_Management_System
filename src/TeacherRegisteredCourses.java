
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Taanveer Ahmeed
 */
public class TeacherRegisteredCourses extends JPanel{
    
    JComboBox course;
    JTextArea output;
     TeacherRegisteredCourses ref = this;
    String [] coursesName = new String [15];
    Course [] courses = new Course [15];
         
     int count = 1;
    TeacherRegisteredCourses (Gui g){
        
         coursesName[0] = "Select Course";
         String query = " SELECT * FROM `course` WHERE teacherId =  '" +g.loggedInTeacher +"'";
          try {
                                                           
                 g.rs = g.st.executeQuery(query);
                 while (g.rs.next()){
                     
                    coursesName[count] = g.rs.getString("courseName");
                    //output.setText("Course Name : " + g.rs.getString("courseName")+ "\nCourse ID : " +g.rs.getString("courseID")+ "\nTiming : " + g.rs.getString("day") + g.rs.getString("roomAndTime") + "\nCourse Teacher : " + g.rs.getString("teacherName"));
                    courses[count++] = new Course (g.rs.getString("courseName"),Integer.parseInt(g.rs.getString("courseID")),Integer.parseInt(g.rs.getString("classID")),g.rs.getString("day"),g.rs.getString("roomAndTime"),g.rs.getString("teacherId"));
                   //  courses[count-1].showInfoInGui(ref);
                    }
               }catch (Exception ex){
                        
                   JOptionPane.showMessageDialog(null, ex);
               }
          
          
          add(course = new JComboBox (coursesName));
          
          course.addItemListener(
          
                  new ItemListener (){
                      
                      public void itemStateChanged (ItemEvent ev){
                          
                          if (course.getSelectedIndex() == 0){
                              
                              output.setText("");
                          
                          }
                          
                         else if (ev.getStateChange () == ItemEvent.SELECTED)
                              
                          {
                              courses[course.getSelectedIndex()].showInfoInGui(ref);
                             
                          }
                      
                      }
                  }
          );
          
          JPanel p = new JPanel ();
          p.add(output = new JTextArea (20,30));
          
          output.setEditable(false);
          Font f = new Font ("Serif",Font.BOLD+Font.ITALIC,18);
          output.setFont(f);
          add(p);
          
    
    }
}
