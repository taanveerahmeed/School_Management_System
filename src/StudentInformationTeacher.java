
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Taanveer Ahmeed
 */
public class StudentInformationTeacher extends javax.swing.JPanel {

    /**
     * Creates new form StudentInformationTeacher
     */
    public StudentInformationTeacher(Gui g) {
        initComponents();
        id.setText("");
        details.setEnabled(false);
        search.addActionListener(
                new ActionListener (){
                    public void actionPerformed (ActionEvent ev){
                        
                        output.setText("");
                        details.setEnabled(false);
                        
                        if (id.getText().equals("") || id.getText().length() > 10 || id.getText().length()<10 ||id.getText().charAt(2) != '-'||id.getText().charAt(7) != '-'){
                            JOptionPane.showMessageDialog(null,"Enter a valid ID");
   
                        }
                        
                        else{
                           
                            
                            try {
                                
                                g.rs = g.st.executeQuery("select * from student where oid = '"+id.getText()+"'");
                                
                                if (g.rs.next() == false){
                                    
                                    JOptionPane.showMessageDialog(null, "Student doesnt exist");
                                }
                                
                                else{
                                //System.out.print("Else");
                                try {
                                    g.rs = g.st.executeQuery("select * from student where oid = '"+id.getText()+"'");
                                }
                                catch (Exception ex){
                                    
                                    JOptionPane.showMessageDialog(null, ex);
                                
                                
                                }
                                while (g.rs.next()){
                                    
                                    output.setText(g.rs.getString("firstname")+" "+g.rs.getString ("lastname")+"\nClass : " + g.rs.getString("class") + "\nClass Roll :" +g.rs.getString("classroll"));
                                    details.setEnabled(true);
                                    details.addActionListener(
                                            
                                            new ActionListener (){
                                                public void actionPerformed (ActionEvent ev){
                                                    output.setText("");
                                                    output.setText("Course Name\tCourse ID\tTerm\tMarks\tGrade");
                                                    String query = "select course.courseID,course.courseName,grades.term,grades.total,grades.grade from course,grades where grades.studentID = '"+id.getText()+"' and course.courseID = grades.courseID ";
                                                    //System.out.print(query);
                                                    try {
                                                        
                                                        g.rs= g.st.executeQuery(query);
                                                        while (g.rs.next()){
                                                            output.append("\n"+g.rs.getString("courseName")+"\t"+g.rs.getString("courseID")+"\t"+g.rs.getString("term")+"\t"+g.rs.getString("total")+"\t"+g.rs.getString("grade"));
                                                            details.setEnabled(false);
                                                        }
                                                    }catch (Exception ex){
                                                    
                                                    }
                                                
                                                }
                                            
                                            }
                                            
                                    
                                    );
                                    
                                
                                }
                            }
                            } catch (SQLException ex) {
                                
                                JOptionPane.showMessageDialog(null,ex);
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

        jLabel1 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();
        search = new javax.swing.JButton();
        details = new javax.swing.JButton();

        jLabel1.setText("Enter ID");

        output.setColumns(20);
        output.setRows(5);
        jScrollPane1.setViewportView(output);

        search.setText("Search");

        details.setText("Details Result");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(details))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(search)))))
                .addContainerGap(330, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(search)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(details)
                .addContainerGap(103, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton details;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea output;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
