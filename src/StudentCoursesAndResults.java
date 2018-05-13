
import java.awt.Font;
import java.awt.PopupMenu;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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
public class StudentCoursesAndResults extends JPanel {

    /**
     * Creates new form StudentCoursesAndResults
     */
    
    JComboBox courses,terms;
    JTextArea output;
    public StudentCoursesAndResults(Gui g) {
        
         
         String [] coursesName = new String [15];
         coursesName [0]="Select Course";
         int count = 1;
         String query = " SELECT * FROM `course` WHERE classID = (select classID from studentrelationtoclass where studentID = '" +g.loggedInStudent +"')";
        // String query = " SELECT * FROM `course` WHERE teacherId =  '1508-25'"; 
         try {
                                                           
                 g.rs = g.st.executeQuery(query);
                 while (g.rs.next()){
                     
                     coursesName[count++] = g.rs.getString("courseName") + "-" + g.rs.getString("courseID");
                    
                    }
               }catch (Exception ex){
                                                       
                      }
         
         JPanel p = new JPanel ();
         add (p);
          p.add (new JLabel ("Courses   "));
          p.add(courses = new JComboBox (coursesName));
          
          p.add (new JLabel ("Term  "));
          
          String [] term = {"Select Term","First","Second","Final"}; 
          p.add (terms = new JComboBox (term));
          
          JPanel p2 = new JPanel ();
          add (p2);
          p2.add(output = new JTextArea (5,10) );
          
          Font f = new Font ("Serif",Font.BOLD+Font.ITALIC,25);
          output.setFont(f);
          output.setEditable(false);
          
          courses.addItemListener(
                  new ItemListener (){
                      public void itemStateChanged (ItemEvent ev){
                          
                          if (courses.getSelectedIndex() != 0 && terms.getSelectedIndex() !=0){
                             String [] courseDetails = courses.getSelectedItem().toString().split("-");
                              
                              if (ev.getStateChange () == ItemEvent.SELECTED){
                                  
                                  String query = "select * from grades where studentID = '"+g.loggedInStudent+"' and courseID = "+Integer.parseInt(courseDetails[1])+" and term = '"+terms.getSelectedItem ()+"'";
                                 // System.out.println (query);
                                  
                                  try {
                                      
                                      System.out.print(query);
                                      g.rs = g.st.executeQuery(query);
                                      //String thry,obj,prac;
                                      while (g.rs.next()){
                                          
                                      
                                    
                                      output.setText("Term : "+g.rs.getString("term")+"\nTheory : "+g.rs.getString("theory")+"\nObjective : "+g.rs.getString("objective")+"\nPractical : "+g.rs.getString("practical")+"\nTotal : "+g.rs.getString("total")+"\nGrade : "+g.rs.getString("grade"));
                                      
                                   }
                                  
                                  }catch (Exception ex){
                                  
                                      JOptionPane.showMessageDialog(null,ex);
                                      System.out.println(ex);
                                  }
                              
                              }
                          
                          }
                      
                      }
                  
                  }
          
          );
          
          terms.addItemListener(
                  new ItemListener (){
                      public void itemStateChanged (ItemEvent ev){
                          
                          if (courses.getSelectedIndex() != 0 && terms.getSelectedIndex() !=0){
                             String [] courseDetails = courses.getSelectedItem().toString().split("-");
                              
                              if (ev.getStateChange () == ItemEvent.SELECTED){
                                  
                                  String query = "select * from grades where studentID = '"+g.loggedInStudent+"' and courseID = "+Integer.parseInt(courseDetails[1])+" and term = '"+terms.getSelectedItem ()+"'";
                                 // System.out.println (query);
                                 
                                 
                                  try {
                                      
                                      System.out.print(query);
                                      g.rs = g.st.executeQuery(query);
                                      //String thry,obj,prac;
                                      while (g.rs.next()){
                                          
                                      
                                    
                                      output.setText("Term : "+g.rs.getString("term")+"\nTheory : "+g.rs.getString("theory")+"\nObjective : "+g.rs.getString("objective")+"\nPractical : "+g.rs.getString("practical")+"\nTotal : "+g.rs.getString("total")+"\nGrade : "+g.rs.getString("grade"));
                                      
                                   }
                                  
                                  }catch (Exception ex){
                                  
                                      JOptionPane.showMessageDialog(null,ex);
                                      System.out.println(ex);
                                  }
                              
                              }
                          
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
    }// </editor-fold>//GEN-END:initComponents

  


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
