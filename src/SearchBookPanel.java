
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Taanveer Ahmeed
 */
public class SearchBookPanel extends JPanel {
    
    JComboBox category;
    JTextArea output;
    JTable table;
     DefaultTableModel model;
    
    SearchBookPanel (Gui g){
        setLayout (new BorderLayout ());
         String [] categoryName = new String [15];
         int count = 0;
        // String query = " SELECT * FROM `course` WHERE classID = (select classID from studentrelationtoclass where studentID = '" +g.loggedInStudent +"')";
         String query = " SELECT * FROM `library` "; 
         try {
                                                           
                 g.rs = g.st.executeQuery(query);
                 while (g.rs.next()){
                     
                     categoryName[count++] = g.rs.getString("bookCategory");
                    
                    }
               }catch (Exception ex){
                   
                   
                                                       
               }
         
          JPanel p = new JPanel ();
          p.add (new JLabel ("Select Category"));
          p.add(category = new JComboBox (categoryName));
          add(p,BorderLayout.NORTH);
          add (new JScrollPane (output = new JTextArea (20,40)),BorderLayout.CENTER);
          
          Font f = new Font ("Serif",Font.BOLD,22);
          output.setFont(f);
          output.setEditable(false);
         
        /* model = new DefaultTableModel(new String[]{"Book Name", "Author Name", "Available", "Shelf No"}, 0);
         add(table = new JTable ());
         table.setModel(model);*/
         
          
           category.addItemListener(
          
                  new ItemListener (){
                      
                      public void itemStateChanged (ItemEvent ev){
                          
                         
                         if (ev.getStateChange () == ItemEvent.SELECTED)
                              
                          {
                             // System.out.println("select * from library where bookCategory = '" + category.getSelectedItem()+"'");
                             try{
                                 
                                 g.rs = g.st.executeQuery("select * from library where bookCategory = '" + category.getSelectedItem()+"'");
                                output.setText("     Book Name         Author Name         Available Copy          Shelf No");
                                 while (g.rs.next()){
                                     output.append("\n     "+g.rs.getString("bookName")+"      "+g.rs.getString("authorName")+"     "+g.rs.getString("bookRemaning")+"     "+g.rs.getString("shelfNo"));
                                 
                                 }
                               /* while (g.rs.next()){
                                    
                                
                                String col1 = g.rs.getString("bookName");
                                String col2 = g.rs.getString("authorName");
                                String col3 = g.rs.getString("bookRemaning");
                                String col4 = g.rs.getString("shelfNo");
                                model.addRow(new Object [] {col1,col2,col3,col4});
                                }*/
                                
                                
                             }catch (Exception ex){
                             
                                 JOptionPane.showMessageDialog(null, ex);
                             }
                             
                          }
                      
                      }
                  }
          );
          

          
      
       
    }
    
    }
   
