import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Taanveer Ahmeed
 */
public class TeacherCoursesResults extends JPanel {

    /**
     * Creates new form StudentCoursesAndResults
     */
    
    JComboBox courses,term;
    JComboBox studentList;
    JTextArea output;
    JTextField theory,objective,practical,grade,totalTxt;
    JButton submit;
    TeacherCoursesResults ref = this;
    JPanel p;
    public TeacherCoursesResults(Gui g) {
        
         setLayout(new GridLayout(10,1));
         String [] coursesName = new String [15];
         
         coursesName[0]= "Courses";
         
         int count = 1;
         //String query = " SELECT * FROM `course` WHERE classID = (select classID from studentrelationtoclass where studentID = '" +g.loggedInStudent +"')";
         
       
         String query = " SELECT * FROM `course` WHERE teacherId =  '"+g.loggedInTeacher+"'"; 
         try {
                                                           
                 g.rs = g.st.executeQuery(query);
                 
                 while (g.rs.next()){
                     
                     coursesName[count++] = g.rs.getString("courseID")+"-"+g.rs.getString("courseName")+"-"+g.rs.getString("classID");
                    
                    }
               }catch (Exception ex){
                                
                   JOptionPane.showMessageDialog(null, ex);
                      }
          
         // add(p = new JPanel ());
         JPanel p2 = new JPanel ();
          p2.setLayout(new FlowLayout ());
          p2.add(new JLabel ("Courese Name ")); 
          p2.add(courses = new JComboBox (coursesName));
          
        /*  courses.addActionListener(
                  new ActionListener (){
                      public void actionPerformed (ActionEvent ev){
                      
                      }
                  
                  }
          
          );*/
          
          courses.addItemListener(
                  
                  new ItemListener (){
                      public void itemStateChanged (ItemEvent ev){
                        
                          if (courses.getSelectedIndex() != 0){
                          
                          if (ev.getStateChange () == ItemEvent.SELECTED){
                              
                              String [] namesAndClasses = courses.getSelectedItem().toString().split("-");
                              //System.out.println (namesAndClasses [1]);
                              try {
                                  studentList.removeAllItems();
                                  studentList.addItem("Student ID");
                                  g.rs = g.st.executeQuery("select * from studentrelationtoclass where classID = " + Integer.parseInt(namesAndClasses [2]));
                                  while (g.rs.next()){
                                      
                                      
                                      studentList.addItem(g.rs.getString("studentID"));
                                      
                                      
                                      //System.out.println(g.rs.getString("studentID"));
                                      
                                    //  p.add(new JTextField (g.rs.getString("studentID")));
                                  }
                              } catch (SQLException ex) {
                                  JOptionPane.showMessageDialog(null, ex);
                              }
                          
                          }
                     }
                      
                      }
                  
                  }
          
          
          );
          p2.add(new JLabel ("Term"));
          String [] name= {"First","Second","Final"};
          p2.add(term = new JComboBox (name));
          p2. add (new JLabel ("Student ID"));
          p2.add(studentList = new JComboBox ());
          studentList.addItem("Student ID");
          
          p2.add(output = new JTextArea (3,19));
          Font f = new Font ("Serif",Font.BOLD,20);
          output.setFont(f);
          output.setEditable(false);
          add(p2);
          JPanel p3 = new JPanel ();
          add(p3);
          p3.add (new JLabel ("Marks                 "));
          p3.add(new JLabel ("Theory"));
          p3.add (theory = new JTextField (3));
          theory.setText("");
          p3.add(new JLabel ("Objective"));
          p3.add (objective = new JTextField (3));
          objective.setText("");
          p3.add(new JLabel ("Practical"));
          p3.add (practical = new JTextField (3));
          practical.setText("");
          p3.add(new JLabel ("Total "));
          p3.add(totalTxt = new JTextField (3));
          totalTxt.setEditable(false);
          
          p3.add(new JLabel ("Grade"));
          p3.add(grade = new JTextField (3));
         
          p3.add(submit = new JButton ("Submit"));
          
          studentList.addItemListener(
                  new ItemListener (){
                      public void itemStateChanged (ItemEvent ev){
                          
                          if (studentList.getSelectedIndex() != 0){
                              
                              if (ev.getStateChange () == ItemEvent.SELECTED){
                                  
                                 try {
                                     
                                     g.rs = g.st.executeQuery("select * from student where oid = '"+studentList.getSelectedItem()+"'");
                                     while (g.rs.next()){
                                         
                                         String rslt = "Name : "+g.rs.getString("firstname")+" "+g.rs.getString ("lastname") +"\nClass Roll : "+ g.rs.getString("classroll"); 
                                         output.setText(rslt);
                                     
                                     }
                                 
                                 }catch (Exception ex){
                                 
                                 }
                              
                              }
                          }
                      
                      }
                  
                  }
          );
          
          submit.addActionListener(
                  new ActionListener (){
                      public void actionPerformed (ActionEvent ev){
                          String thry,prac,objc;
                          double total=0;
                          
                          String [] courseDet = courses.getSelectedItem().toString().split("-");
                          
                          if (theory.getText().equals("")){
                              
                              thry = "null";
                              total = total + 0;
                          }
                          
                          else {
                             thry =  "'"+theory.getText()+"'";
                             total = total + Double.parseDouble(theory.getText());
                          }
                          
                          if (objective.getText().equals("")){
                              objc = "null";
                              total = total+0;
                          }
                          
                          else{
                              objc = "'"+objective.getText()+"'";
                              total = total + Double.parseDouble(objective.getText());
                          }
                          
                          if (practical.getText().equals("")){
                              
                              prac = "null";
                              total = total+0;
                          
                          }
                          
                          else {
                              
                              prac = "'"+practical.getText()+"'";
                              total = total + Double.parseDouble(practical.getText());
                          
                          }
                          
                          totalTxt.setText(""+total);
                          String query = "insert into grades values ("+Integer.parseInt(courseDet[0])+",'"+studentList.getSelectedItem()+"','"+term.getSelectedItem()+"',"+thry+","+objc+","+prac+",'"+totalTxt.getText()+"','"+grade.getText()+"')";
                          //System.out.println (query);
                          try {
                              g.st.executeUpdate(query);
                              JOptionPane.showMessageDialog(null, "Success");
                          }catch (Exception ex){
                              
                              JOptionPane.showMessageDialog(null, ex);
                          
                          }
                      
                      }
                  
                  }
          
          );
          
      
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    // End of variables declaration                   
}
