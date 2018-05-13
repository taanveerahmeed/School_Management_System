
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.*;
import javax.swing.*;

class Gui extends JFrame{
	
	Connection con;
	Statement st;
	ResultSet rs;
	
	String query;
	Student tempStudent;
	String loggedInStudent;
        String loggedInTeacher;
	
	
	LoginPanel loginPanel;
	AdminLoginPanel adminLogin;
	AdminMainPanel adminMain;
	StudentMainPanel studentMain;
	StudentRegistrationForm studentRegistrationform;
	TeacherRegistrationForm teacherRegistrationForm;
	JOptionPane option;
        AddCourseForm addCourseForm;
        AdminProfilePanel adminPro = new AdminProfilePanel ();
        RegisteredCourses registeredCourses;
        BookRegistrationForm bookRegistration;
        BookBorrowPanel bookBorrow;
	BookReturnForm bookReturn;
	StudentInfoPanel studentInfo;
        TeacherMainPanel teacherProfile;
        TeacherRegisteredCourses teacherCourses;
	Gui g = this;
	
	
	
	
	Gui ()
	{
		
		
		super ("School Management System");
		
		try 
		{
			Class.forName ("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school management system","root","");
			st = con.createStatement();
			System.out.println("sucess");
			//st.executeUpdate("create table person (name varchar(90),dob varchar(15))");
			
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
		
		add(loginPanel = new LoginPanel ());
		
		adminLogin = new AdminLoginPanel ();
		adminMain = new AdminMainPanel ();
		studentMain = new StudentMainPanel();
		studentRegistrationform = new StudentRegistrationForm ();
		teacherRegistrationForm = new TeacherRegistrationForm ();
                addCourseForm = new AddCourseForm ();
		studentInfo = new StudentInfoPanel ();
                registeredCourses = new RegisteredCourses (g);
                bookRegistration = new BookRegistrationForm (g);
                bookBorrow = new BookBorrowPanel (g);
                bookReturn = new BookReturnForm (g);
                teacherProfile = new TeacherMainPanel ();
                teacherCourses = new TeacherRegisteredCourses (g);
                
		loginPanel.admin.addActionListener(
				new ActionListener (){
					public void actionPerformed (ActionEvent ev){
						 JPanel p = (JPanel) getContentPane();
						 p.removeAll();
						 adminLogin.username.setText("");
						 adminLogin.password.setText("");
						 p.add(adminLogin);
						 repaint();
						 revalidate();
					}
				}
		);
                
                
                
                adminMain.addCourse.addActionListener(
                     new ActionListener (){
                         
                         public void actionPerformed (ActionEvent ev){
                             JPanel p = (JPanel) getContentPane ();
                             p.removeAll();
                             p.add(addCourseForm );
                             revalidate();
                             repaint ();
                         }
                     }
                        /*String query = "insert into course values (123,'Bangla','001','Sunday','10-12')";
                        public void actionPerformed (ActionEvent ev){
                            
                           try {
                               st.executeUpdate(query);
                           }catch (Exception ex){
                               System.out.println (ex);
                           }
                          }
                        }*/
                     
                );
                
                teacherProfile.signout.addActionListener(
                        new ActionListener (){
                            
                            public void actionPerformed (ActionEvent e){
                                JPanel p = (JPanel) getContentPane ();
                                p.removeAll();
                                p.add(loginPanel);
                                revalidate();
                                repaint();
                                teacherProfile.home.doClick();
                                loginPanel.username.setText("");
                                loginPanel.password.setText("");
                                
                            
                            }
                        
                        }
                
                );
                
                
                
                teacherProfile.profile.addActionListener(
                        new ActionListener (){
                            public void actionPerformed (ActionEvent e){
                                String query = "select * from teacher where teacherID = '" +loggedInTeacher +"'";
                                try {
                                    
                                    rs = st.executeQuery(query);
                                    while (rs.next()){
								
								String result = "                          PERSONAL DETAILS\n\n     Name : " +rs.getString("firstName") +" " + rs.getString("lastName")
								+"\n     Father's Name : " + rs.getString("fatherName")+
								"\n     Mother's Name : " +rs.getString("motherName") +
								"\n     Date of Birth : " + rs.getString("DOB") +
								"\n     Gender : " + rs.getString("gender") +
								"\n     Present Address : " + rs.getString("presentAddress")+
								"\n     Permanent Address : " + rs.getString("permanentAddress") +
								"\n     Phone Number : "+rs.getString("phoneNumber")+
								"\n     Email Address : " + rs.getString("email") +
								"\n     Religion : " + rs.getString("religion") +
								"\n     Maratial Status : " + rs.getString("maritalStatus") +
								"\n     Nationality :" + rs.getString("nationality") +
								"\n     Joining Date : " +rs.getString("joiningDate") +
								"\n     Educational Background : " +  rs.getString("education") +
								"\n     Department : " + rs.getString("department") +
								"\n     Post :" + rs.getString("post")
				;
								
								
								 teacherProfile.centerPanel.removeAll();
								// loginPanel.username.setText("");
								// loginPanel.password.setText("");
								(teacherProfile.centerPanel).add(teacherProfile.profileShow);
								teacherProfile.centerPanel.repaint();
								//studentMain.centerPanel.revalidate();
								teacherProfile.profileShow.output.setText(result);
                                    }
                                    
                                
                                }catch (Exception ex){
                                    
                                    System.out.println (ex);
                                
                                }
                            
                            }
                        
                        }
                
                
                );
                
                teacherProfile.registration.addActionListener(
                
                        new ActionListener (){
                        
                            public void actionPerformed (ActionEvent ev){
                                
                                teacherProfile.centerPanel.removeAll();
                                teacherProfile.centerPanel.add(new TeacherRegisteredCourses (g));
                                teacherProfile.centerPanel.repaint();
				teacherProfile.centerPanel.revalidate();
                            }
                        }
                );
                
                
                teacherProfile.searchBook.addActionListener(
                        
                        new ActionListener (){
                            
                            public void actionPerformed (ActionEvent e){
                            
                                teacherProfile.centerPanel.removeAll();
                                teacherProfile.centerPanel.add(new SearchBookPanel (g));
                                teacherProfile.centerPanel.repaint();
                                teacherProfile.centerPanel.revalidate();
                            }
                        
                        }
                
                
                );
                
                teacherProfile.home.addActionListener(
                        new ActionListener (){
                            public void actionPerformed (ActionEvent e){
                                teacherProfile.centerPanel.removeAll();
							
				(teacherProfile.centerPanel).add(teacherProfile.profileShow);
				teacherProfile.centerPanel.repaint();
				teacherProfile.centerPanel.revalidate();
				teacherProfile.profileShow.output.setText("Class Routine");
                                
                                String query = " SELECT * FROM `course` WHERE teacherId = '" +loggedInTeacher +"'";
                                try {
                                                           
                                        rs = st.executeQuery(query);
                                        while (rs.next()){
                                            
                                            teacherProfile.profileShow.output.append("\n" + rs.getString("courseName") +"\t"+ rs.getString("day") +"\t"+ rs.getString("roomAndTime"));
                                            
                                        }
                                        
                                    }catch (Exception ex){
                                                       
                                     }
                            
                                    }
                        
                        }
                
                );
                
                teacherProfile.send.addActionListener(
                        new ActionListener (){
                        
                            public void actionPerformed (ActionEvent e){
                                /*JPanel p = (JPanel) getContentPane ();
                                p.removeAll();
                                p.add(new TeacherCoursesResults (g));
                                revalidate();
                                repaint();*/
                                teacherProfile.centerPanel.removeAll();
                                teacherProfile.centerPanel.add(new SendMail(g));
                                teacherProfile.centerPanel.repaint();
				teacherProfile.centerPanel.revalidate();
                                
                            
                            }
                        }
                
                        
                
                );
                
                teacherProfile.studentInfo.addActionListener(
                
                          new ActionListener (){
                        
                            public void actionPerformed (ActionEvent e){
                                /*JPanel p = (JPanel) getContentPane ();
                                p.removeAll();
                                p.add(new TeacherCoursesResults (g));
                                revalidate();
                                repaint();*/
                                teacherProfile.centerPanel.removeAll();
                                teacherProfile.centerPanel.add(new StudentInformationTeacher (g));
                                teacherProfile.centerPanel.repaint();
				teacherProfile.centerPanel.revalidate();
                                
                            
                            }
                        }
                
                );
                
                
                teacherProfile.courseResult.addActionListener(
                
                        new ActionListener (){
                        
                            public void actionPerformed (ActionEvent e){
                                /*JPanel p = (JPanel) getContentPane ();
                                p.removeAll();
                                p.add(new TeacherCoursesResults (g));
                                revalidate();
                                repaint();*/
                                teacherProfile.centerPanel.removeAll();
                                teacherProfile.centerPanel.add(new TeacherCoursesResults (g));
                                teacherProfile.centerPanel.repaint();
				teacherProfile.centerPanel.revalidate();
                                
                            
                            }
                        }
                
                );
                        
                
                
                
                  addCourseForm.submit.addActionListener(
                        
                        new ActionListener (){
                        
                            public void actionPerformed (ActionEvent e){
                                int cID = Integer.parseInt(addCourseForm.courseID.getText());
                                String cName = addCourseForm.courseName.getText();
                                int classID = Integer.parseInt(addCourseForm.classId.getText());
                              //  String day = (String) addCourseForm.day.getSelectedItem();
                              String day = "ss";
                                String timeAndRoom = "Room No :"+addCourseForm.roomNo.getText() + " Time :"+addCourseForm.time.getText();
                                String tID = (String) addCourseForm.teacherID.getText();
                                
                                
                                String query = "insert into course values (" + cID +",'"+cName +"',"+classID+",'"+day+"','"+timeAndRoom+"','"+tID+"')";
                               // System.out.println (query);
                               
                               try {
                                   
                                   st.executeUpdate(query);
                               
                               }catch (Exception ex){
                                   
                                   System.out.println (ex);
                               }
                            }
                        }
                
                );
                  
                addCourseForm.Back.addActionListener(
                        
                        new ActionListener (){
                        
                            public void actionPerformed (ActionEvent e){
                                
                                JPanel p = (JPanel) getContentPane ();
                                p.removeAll();
                                p.add(adminMain);
                                revalidate ();
                                repaint ();
                            }
                        }
                
                );
		
		teacherRegistrationForm.back.addActionListener(
				
				new ActionListener (){
					
				public	void actionPerformed (ActionEvent ev){
						
						JPanel p = (JPanel) getContentPane();
						p.removeAll();
						p.add(adminMain);
						repaint();
						revalidate();
					}
				}
				
		);
		
		
	/*	studentMain.option.addActionListener(
				
				
				new ActionListener (){
					
				public	void actionPerformed (ActionEvent ev){
						
						JPanel p = (JPanel) getContentPane();
						p.removeAll();
						p.add(adminMain);
						repaint();
						revalidate();
					}
				}
		);*/
		studentRegistrationform.back.addActionListener(
				
				new ActionListener (){
					
					public void actionPerformed (ActionEvent ev){
						
						JPanel p = (JPanel) getContentPane ();
						p.removeAll();
						p.add(adminMain);
						repaint ();
						revalidate ();
					}
				}
				
		);
		
		teacherRegistrationForm.submit.addActionListener(
				
				new ActionListener () {
					
					public void actionPerformed (ActionEvent ev){
						
						String sex;
						if (teacherRegistrationForm.male.isSelected()) sex = "Male";
						else sex = "Female";
						String bg,fn, ln, fthrname, mthrname, dobdt, dobmn, dobyr, gndr, prsntadrs, prmnntadrs, phn, mail, religion, mat, nation,  joindt, joinmn, joinyr,  oid, pass,dept,post,eb;
                                                int sal;
						fn = teacherRegistrationForm.firstName.getText();
						ln = teacherRegistrationForm.lastName.getText();
						fthrname = teacherRegistrationForm.fatherName.getText();
						mthrname = teacherRegistrationForm.motherName.getText();
						dobdt =(String) teacherRegistrationForm.dobdate.getSelectedItem();
						dobmn = (String) teacherRegistrationForm.dobmonth.getSelectedItem();
						dobyr = (String) teacherRegistrationForm.dobyear.getSelectedItem();
						gndr = sex;
						//bg = studentRegistrationform.bloodGroup.getText();
						prsntadrs = teacherRegistrationForm.presentAddress.getText();
						prmnntadrs = teacherRegistrationForm.permanentAddress.getText();
						phn = teacherRegistrationForm.phoneNumber.getText();
						mail =teacherRegistrationForm.email.getText();
						religion = teacherRegistrationForm.religion.getText();
						mat = (teacherRegistrationForm.married.isSelected()?"Married":"Unmarried");
						nation = teacherRegistrationForm.nationality.getText();
						//clas =(String) studentRegistrationform.classes.getSelectedItem();
						joindt = (String) teacherRegistrationForm.joinDt.getSelectedItem();
						joinmn = (String) teacherRegistrationForm.joinMn.getSelectedItem();
						joinyr = (String) teacherRegistrationForm.joinYr.getSelectedItem();
						//roll = (String) studentRegistrationform.rolls.getSelectedItem();
						oid = (String) teacherRegistrationForm.oid.getText();
						pass = (String) teacherRegistrationForm.password.getText();
						
						dept = (String) teacherRegistrationForm.department.getText();
						post = (String) teacherRegistrationForm.post.getText();
						eb = (String) teacherRegistrationForm.educationalBackground.getText();
						sal =Integer.parseInt( (String)teacherRegistrationForm.salary.getText());
                    //String bg,fn, ln, fthrname, mthrname, dobdt, dobmn, dobyr, gndr, prsntadrs, prmnntadrs, phn, mail, religion, mat, nation,  joindt, joinmn, joinyr,  oid, pass,dept,post,eb;
                   //                             int sal;                            
                                                Teacher t = new Teacher (fn,ln,dobyr,dobmn,dobdt,fthrname,mthrname,prsntadrs,prmnntadrs,phn,mail,sex,religion,mat,nation,oid,pass,joindt,joinmn,joinyr,dept,post,eb,sal);
						t.insert (g);
                                                teacherRegistrationForm.refresh();
					/*	System.out.println(fn);
						System.out.println(ln);
						System.out.println(fthrname);
						System.out.println(mthrname);
						//System.out.println(studentRegistrationform.classes.getSelectedItem());
						System.out.println(dobmn);
						System.out.println(dobyr);
						System.out.println(gndr);
						System.out.println(prsntadrs);
						System.out.println(prmnntadrs);
						System.out.println(phn);
						System.out.println(mail);
						System.out.println(religion);
						System.out.println(mat);
						System.out.println(nation);
						System.out.println(dept);
						System.out.println(joindt);
						System.out.println(joinmn);
						System.out.println(joinyr);
						System.out.println(post);
						System.out.println(oid);
						System.out.println(pass);
						System.out.println(eb);
						System.out.println(sal);*/
					}
				}
				
		);
		
                adminMain.addBook.addActionListener (
                        new ActionListener (){
                            public void actionPerformed (ActionEvent ev){
                                
                                JPanel p = (JPanel) getContentPane ();
                                p.removeAll();
                                p.add(bookRegistration);
                                revalidate ();
                                repaint();
                            
                            }
                        
                        }
                
                
                );
                
                adminMain.returnHistory.addActionListener(
                
                        new ActionListener (){
                            public void actionPerformed (ActionEvent ev){
                                
                                JPanel p = (JPanel) getContentPane ();
                                p.removeAll();
                                p.add(bookReturn);
                                revalidate ();
                                repaint();
                            
                            }
                        
                        }
                );
                
                bookReturn.Back.addActionListener(
                
                         new ActionListener (){
                            public void actionPerformed (ActionEvent ev){
                                
                                JPanel p = (JPanel) getContentPane ();
                                p.removeAll();
                                p.add(adminMain);
                                bookReturn.refresh();
                                revalidate ();
                                repaint();
                            
                            }
                        
                        }
                );
                
                /*bookRegistration.submit.addActionListener(
                        new ActionListener (){
                        
                            public void actionPerformed (ActionEvent ev){
                            
                                 String query = "insert into library values (1,'Java','Herbert',100,'CS',10,0)";
                                    try {
            
                                             g.st.executeUpdate(query);
            
                                        }catch (Exception ex){
            
                                        }
                            }
                        }
                
                );*/
                
                bookRegistration.back.addActionListener(
                        new ActionListener (){
                        
                            public void actionPerformed (ActionEvent ev){
                            
                                 JPanel p = (JPanel) getContentPane ();
                                p.removeAll();
                                p.add(adminMain);
                                revalidate ();
                                repaint();
                            }
                        }
                
                );
		
		adminMain.teacherReg.addActionListener(
				new ActionListener (){
					public void actionPerformed (ActionEvent ev){
						JPanel p = (JPanel) getContentPane ();
						p.removeAll();
						
						p.add(new JScrollPane(teacherRegistrationForm));//p.add(teacherRegistrationForm);
						repaint();
						revalidate();
					}
				}
		);
                
                adminMain.addLibraryBorrow.addActionListener(
                        new ActionListener (){
                            
                            public void actionPerformed (ActionEvent ev){
                                JPanel p = (JPanel) getContentPane ();
                                p.removeAll ();
                                p.add(bookBorrow);
                                revalidate ();
                                repaint();
                            
                            }
                        
                        }
                
                );
                
                bookBorrow.Back.addActionListener(
                        
                         new ActionListener (){
                            
                            public void actionPerformed (ActionEvent ev){
                                JPanel p = (JPanel) getContentPane ();
                                p.removeAll ();
                                p.add(adminMain);
                                bookBorrow.refresh();
                                revalidate ();
                                repaint();
                            
                            }
                        
                        }
                
                );
		
		loginPanel.login.addActionListener(
				new ActionListener (){
					public void actionPerformed (ActionEvent ev){
                                            
                                            String id = loginPanel.username.getText();
                                            String []check = id.split("-");
                                            if (check.length == 3){
						
						try{
							
							query = "select * from student where oid = '"+id+"'";
							rs = st.executeQuery(query);
							String givenPass = String.valueOf(loginPanel.password.getPassword());
							//System.out.println(givenPass);
							String actualPass = null ;
							
								while (rs.next()){
								
									actualPass = (String)rs.getString("pass");
								}
							//	rs = st.executeQuery(query);
							
								if (givenPass.equals(actualPass)){
									
									loggedInStudent = id;
									JPanel p = (JPanel) getContentPane();
									 p.removeAll();
									 p.add(new JScrollPane (studentMain ));
									 repaint();
									 revalidate();
								         (studentMain.centerPanel).add(studentMain.profileShow);
									 studentMain.centerPanel.repaint();
									 studentMain.centerPanel.revalidate();
									 studentMain.profileShow.output.setText("Class Routine");
                                                                         String query = " SELECT * FROM `course` WHERE classID = (select classID from studentrelationtoclass where studentID = '" +loggedInStudent +"')";
                                                                            try {
                                                           
                                                                                       rs = st.executeQuery(query);
                                                                              while (rs.next()){
                                                               
                                                                                   studentMain.profileShow.output.append("\n" + rs.getString("courseName") +"\t"+ rs.getString("day") +"\t"+ rs.getString("roomAndTime"));
                                                       
                                                                                         }
                                                                                }catch (Exception ex){
                                                       
                                                                               }
								}
								else {
									JOptionPane.showMessageDialog(null, "Wrong Password");
									//JOptionPane.showOptionDialog(null,"Are you sure you want to exit?","JAVA GUI LAB",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
									
								}
							
							
						}catch (Exception ex){
							
						}
                                            }
                                            
                                            else if (check.length == 2){
                                                
                                              /*  JPanel p = (JPanel) getContentPane();
				                p.removeAll();
						p.add(new JScrollPane (teacherProfile ));
						repaint();
						revalidate();*/
                                              
                                              try{
							
							query = "select * from teacher where teacherID = '"+id+"'";
							rs = st.executeQuery(query);
							String givenPass = String.valueOf(loginPanel.password.getPassword());
							//System.out.println(givenPass);
							String actualPass = null ;
							
								while (rs.next()){
								
									actualPass = (String)rs.getString("password");
								}
							//	rs = st.executeQuery(query);
							
								if (givenPass.equals(actualPass)){
									
									loggedInTeacher = id;
									JPanel p = (JPanel) getContentPane();
									 p.removeAll();
									 p.add(new JScrollPane (teacherProfile ));
									 repaint();
									 revalidate();
                                                                         (teacherProfile.centerPanel).add(teacherProfile.profileShow);
									 teacherProfile.centerPanel.repaint();
									 teacherProfile.centerPanel.revalidate();
									 teacherProfile.profileShow.output.setText("Class Routine");
									 
                                                                         String query = " SELECT * FROM `course` WHERE teacherId = '" +loggedInTeacher +"'";
                                                                            try {
                                                           
                                                                                       rs = st.executeQuery(query);
                                                                              while (rs.next()){
                                                               
                                                                                   teacherProfile.profileShow.output.append("\n" + rs.getString("courseName") +"\t"+ rs.getString("day") +"\t"+ rs.getString("roomAndTime"));
                                                       
                                                                                         }
                                                                                }catch (Exception ex){
                                                       
                                                                               }
								}
								else {
									JOptionPane.showMessageDialog(null, "Wrong Password");
									//JOptionPane.showOptionDialog(null,"Are you sure you want to exit?","JAVA GUI LAB",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
									
								}
							
							
						}catch (Exception ex){
							
						}
                                                
                                            
                                            }
                                            
                                            else{
                                                JOptionPane.showMessageDialog(null, "wrong combination!!\n username must follow  'XX-XXXX-XX'  or  'XXXX-XX'  format");
                                            
                                            }
						 
					}
				}
		);
                
                studentMain.courseResult.addActionListener (
                
                        new ActionListener (){
                        
                            public void actionPerformed (ActionEvent ev){
                                
                                studentMain.centerPanel.removeAll();
                                studentMain.centerPanel.add(new StudentCoursesAndResults (g));
                                studentMain.centerPanel.repaint();
				studentMain.centerPanel.revalidate();
                            }
                        }
                );
                
                studentMain.inbox.addActionListener(
                
                        new ActionListener (){
                        
                            public void actionPerformed (ActionEvent ev){
                                
                                studentMain.centerPanel.removeAll();
                                studentMain.centerPanel.add(new StudentInbox (g));
                                studentMain.centerPanel.repaint();
				studentMain.centerPanel.revalidate();
                            }
                        }
                );
                
                studentMain.registration.addActionListener(
                
                        new ActionListener (){
                        
                            public void actionPerformed (ActionEvent ev){
                                
                                studentMain.centerPanel.removeAll();
                                studentMain.centerPanel.add(new RegisteredCourses (g));
                                studentMain.centerPanel.repaint();
				studentMain.centerPanel.revalidate();
                            }
                        }
                );
                
                studentMain.searchBook.addActionListener(
                
                        new ActionListener (){
                        
                            public void actionPerformed (ActionEvent ev){
                                
                                studentMain.centerPanel.removeAll();
                                studentMain.centerPanel.add(new SearchBookPanel (g));
                                studentMain.centerPanel.repaint();
				studentMain.centerPanel.revalidate();
                            }
                        }
                );
		
		studentMain.home.addActionListener(
				
				new ActionListener (){
					public void actionPerformed (ActionEvent ev){
						 studentMain.centerPanel.removeAll();
							// loginPanel.username.setText("");
							// loginPanel.password.setText("");
							(studentMain.centerPanel).add(studentMain.profileShow);
							studentMain.centerPanel.repaint();
							studentMain.centerPanel.revalidate();
							studentMain.profileShow.output.setText("Class Routine");
                                                       String query = " SELECT * FROM `course` WHERE classID = (select classID from studentrelationtoclass where studentID = '" +loggedInStudent +"')";
                                                       try {
                                                           
                                                           rs = st.executeQuery(query);
                                                           while (rs.next()){
                                                               
                                                              studentMain.profileShow.output.append("\n" + rs.getString("courseName") +"\t"+ rs.getString("day") +"\t"+ rs.getString("roomAndTime"));
                                                       
                                                            }
                                                       }catch (Exception ex){
                                                       
                                                       }
					}
				}
		);
                
                studentMain.borrows.addActionListener(
				
				new ActionListener (){
					public void actionPerformed (ActionEvent ev){
						 studentMain.centerPanel.removeAll();
							// loginPanel.username.setText("");
							// loginPanel.password.setText("");
							(studentMain.centerPanel).add(studentMain.profileShow);
							studentMain.centerPanel.repaint();
							studentMain.centerPanel.revalidate();
							studentMain.profileShow.output.setText("Current Borrows\nBorrowID\tBookID\tBorrowed on\tAReturn Date");
                                                        
                                                       String query = " SELECT * FROM currentborrows WHERE studentID = '" +loggedInStudent +"'";
                                                       try {
                                                           
                                                           rs = st.executeQuery(query);
                                                           while (rs.next()){
                                                               
                                                              studentMain.profileShow.output.append("\n" + rs.getString("borrowID") +"\t"+ rs.getString("bookID") +"\t"+ rs.getString("borrowDate")+"\t"+rs.getString("assignedReturnDate"));
                                                       
                                                            }
                                                       }catch (Exception ex){
                                                       
                                                       }
					}
				}
		);
                
                 studentMain.allBorrows.addActionListener(
				
				new ActionListener (){
					public void actionPerformed (ActionEvent ev){
						 studentMain.centerPanel.removeAll();
							// loginPanel.username.setText("");
							// loginPanel.password.setText("");
							(studentMain.centerPanel).add(studentMain.profileShow);
							studentMain.centerPanel.repaint();
							studentMain.centerPanel.revalidate();
							studentMain.profileShow.output.setText("Borrows\nBorrowID  BookID  Borrowed  Estimated Return  Returned ON");
                                                        
                                                       String query = " SELECT * FROM allborrowhistory WHERE borrowedBy = '" +loggedInStudent +"'";
                                                       try {
                                                           
                                                           System.out.println (query);
                                                           
                                                           rs = st.executeQuery(query);
                                                           while (rs.next()){
                                                               
                                                              studentMain.profileShow.output.append("\n" + rs.getString("borrwID") +"\t"+ rs.getString("bookID") +"    "+ rs.getString("borrowDate")+"    "+rs.getString("assignedReturn")+"\t      "+rs.getString("actualReturn"));
                                                       
                                                            }
                                                       }catch (Exception ex){
                                                       
                                                       }
					}
				}
		);
		
		studentMain.signout.addActionListener(
				new ActionListener (){
					
					public void actionPerformed (ActionEvent ev){
						 JPanel p = (JPanel) getContentPane();
						 p.removeAll();
						 loginPanel.username.setText("");
						 loginPanel.password.setText("");
						 p.add(loginPanel);
						 repaint();
						 revalidate();
						 studentMain.output.setText("");
                                                studentMain.home.doClick();
					}
				}
				
		);
		
		studentMain.profile.addActionListener(
			
				new ActionListener (){
					public void actionPerformed (ActionEvent ev){
						try {
							query = "select * from student where oid = '"+loggedInStudent+"'";
							rs = st.executeQuery(query);
								//rs = st.executeQuery("select * from student where oid = '01-1993-03'");
							while (rs.next()){
								
								String result = "                          PERSONAL DETAILS\n\n     Name : " +rs.getString("firstname") +" " + rs.getString("lastname")
								+"\n     Father's Name : " + rs.getString("fathername")+
								"\n     Mother's Name : " +rs.getString("mothername") +
								"\n     Date of Birth : " + rs.getString("dob") +
								"\n     Gender : " + rs.getString("gender") +
								"\n     Present Address : " + rs.getString("presentaddress")+
								"\n     Permanent Address : " + rs.getString("permanent") +
								"\n     Phone Number : "+rs.getString("phone")+
								"\n     Email Address : " + rs.getString("email") +
								"\n     Religion : " + rs.getString("religion") +
								"\n     Maratial Status : " + rs.getString("maratialstatus") +
								"\n     Nationality :" + rs.getString("nationality") +
								"\n     Class : " +rs.getString("class") +
								"\n     Admission Date : " +  rs.getString("admissiondate") +
								"\n     Class Roll : " + rs.getString("classroll") +
								"\n     Organizational Id :" + rs.getString("oid")
				;
								
								
								 studentMain.centerPanel.removeAll();
								// loginPanel.username.setText("");
								// loginPanel.password.setText("");
								(studentMain.centerPanel).add(studentMain.profileShow);
								studentMain.centerPanel.repaint();
								studentMain.centerPanel.revalidate();
								studentMain.profileShow.output.setText(result);
								//JPanel p = (JPanel) getContentPane();
								//p.add(studentMain.scrl,BorderLayout.CENTER);
								
								
								
								
							
								
								//studentMain.output.setText(result);
								
								
							}
							// rs = st.executeQuery(query);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
		);
		
		adminLogin.back.addActionListener(
				new ActionListener (){
					public void actionPerformed (ActionEvent ev){
						 JPanel p = (JPanel) getContentPane();
						 p.removeAll();
						 loginPanel.username.setText("");
						 loginPanel.password.setText("");
						 p.add(loginPanel);
						 repaint();
						 revalidate();
					}
				}
		);
		
		adminLogin.login.addActionListener(
				new ActionListener (){
					public void actionPerformed (ActionEvent ev){
						try {
						query = "select * from admin where id = '"+adminLogin.username.getText()+"'";
						rs = st.executeQuery(query);
						String givenPass = String.valueOf(adminLogin.password.getPassword());
						System.out.println(givenPass);
						String actualPass = null;
						
							while (rs.next()){
							
								actualPass = (String)rs.getString("pass");
							}
							System.out.println(actualPass);
						
							if (givenPass.equals(actualPass)  ){
							
								JPanel p = (JPanel) getContentPane();
								p.removeAll();
								p.add(adminMain);
								repaint();
								revalidate();
							}
							else System.out.println("Error");
						}
						catch (Exception ex){
							
						}
						 
					}
				}
		);
		
		adminMain.logOut.addActionListener(
				new ActionListener (){
					public void actionPerformed (ActionEvent ev){
						 JPanel p = (JPanel) getContentPane();
						 p.removeAll();
						 loginPanel.username.setText("");
						 loginPanel.password.setText("");
						 p.add(loginPanel);
						 repaint();
						 revalidate();
					}
				}
		);
		
		adminMain.studentReg.addActionListener(
				new ActionListener (){
					public void actionPerformed (ActionEvent ev){
						 JPanel p = (JPanel) getContentPane();
						 p.removeAll();
						 p.add(new JScrollPane(studentRegistrationform));
						 repaint();
						 revalidate();
					}
				}
		);
		
		studentRegistrationform.submit.addActionListener(
				new ActionListener (){
					public void actionPerformed (ActionEvent ev){
						//System.out.println(studentRegistrationform.firstName.getText() + " " +studentRegistrationform.lastName.getText());
                                        if (studentRegistrationform.dobdate.getSelectedIndex() == 0 || studentRegistrationform.dobmonth.getSelectedIndex() == 0 || studentRegistrationform.dobyear.getSelectedIndex() == 0 || studentRegistrationform.addates.getSelectedIndex() == 0 || studentRegistrationform.admonths.getSelectedIndex() == 0 || studentRegistrationform.adyears.getSelectedIndex() == 0){
                                            
                                                JOptionPane.showMessageDialog(null,"Dates must be selected");
                                                
                                            }
                                                
                                         else{	
                                                    
                                                String sex;
						if (studentRegistrationform.male.isSelected()) sex = "Male";
						else sex = "Female";
						//System.out.println (sex);
					//	System.out.println (studentRegistrationform.classes.getSelectedItem());
						
						String bg,fn, ln, fthrname, mthrname, dobdt, dobmn, dobyr, gndr, prsntadrs, prmnntadrs, phn, mail, religion, mat, nation, clas, addate, admn, adyr, roll, oid, pass;
						
                                                int classId;
                                                
                                                fn = studentRegistrationform.firstName.getText();
						ln = studentRegistrationform.lastName.getText();
						fthrname = studentRegistrationform.fatherName.getText();
						mthrname = studentRegistrationform.motherName.getText();
						dobdt =(String) studentRegistrationform.dobdate.getSelectedItem();
						dobmn = (String) studentRegistrationform.dobmonth.getSelectedItem();
						dobyr = (String) studentRegistrationform.dobyear.getSelectedItem();
						gndr = sex;
						//bg = studentRegistrationform.bloodGroup.getText();
						prsntadrs = studentRegistrationform.presentAddress.getText();
						prmnntadrs = studentRegistrationform.permanentAddress.getText();
						phn = studentRegistrationform.phoneNumber.getText();
						mail =studentRegistrationform.email.getText();
						religion = studentRegistrationform.religion.getText();
						mat = (studentRegistrationform.married.isSelected()?"Married":"Unmarried");
						nation = studentRegistrationform.nationality.getText();
						clas =(String) studentRegistrationform.classes.getSelectedItem();
						addate = (String) studentRegistrationform.addates.getSelectedItem();
						admn = (String) studentRegistrationform.admonths.getSelectedItem();
						adyr = (String) studentRegistrationform.adyears.getSelectedItem();
						roll = (String) studentRegistrationform.rolls.getSelectedItem();
						oid = (String) studentRegistrationform.oid.getText();
						pass = (String) studentRegistrationform.password.getText();
                                                classId = Integer.parseInt(studentRegistrationform.classId.getText());
						
						/*System.out.println(fn);
						System.out.println(ln);
						System.out.println(fthrname);
						System.out.println(mthrname);
						System.out.println(studentRegistrationform.classes.getSelectedItem());
						System.out.println(dobmn);
						System.out.println(dobyr);
						System.out.println(gndr);
						System.out.println(prsntadrs);
						System.out.println(prmnntadrs);
						System.out.println(phn);
						System.out.println(mail);
						System.out.println(religion);
						System.out.println(mat);
						System.out.println(nation);
						System.out.println(clas);
						System.out.println(addate);
						System.out.println(admn);
						System.out.println(adyr);
						System.out.println(roll);
						System.out.println(oid);
						System.out.println(pass);*/
						/*String query = "insert into student values ('" + fn +"','"+ln+"','"+fthrname+"','"+mthrname+"','"+dobyr+"-"+dobmn+"-"+dobdt+"','"+gndr+"','"+prsntadrs+"','"+prmnntadrs+"','"+phn+"','"+mail+"','"+religion+"','"+mat+"','"+nation+"','"+clas+"','"+adyr+"-"+admn+"-"+addate+"','"+roll+"','"+oid+"','"+pass+"')";
						//	"insert into person values ('"+name+"','"+dob+"')";
							try 
							{
								st.executeUpdate(query);
							}
							catch (Exception ex)
							{
								System.out.println(ex);
							}*/
						
						//inputDataToStudentDataBase("Ahmed", "Tanvir","Nazim", "samsun","14","01","1994","male","ghtl", "tngl", "01671","gm"," religion", "mat", "nation", "cl", "01", "02","1545", "40", "456", "546");
						//inputDataToStudentDataBase(fn, ln, fthrname, mthrname, dobdt, dobmn, dobyr, gndr, prsntadrs, prmnntadrs, phn, mail, religion, mat, nation, clas, addate, admn, adyr, roll, oid, pass);
													//String fn,String ln, String dobyr,String dobmn,String dobdt, String bg, String fathr, String mthr, String prnadrs,String prmnadrs, String phn, String email, String sex, String rlg,String ms, String nation, String id,String pass,String adyr,String admn,String addt,String clas,String roll
						tempStudent = new Student (fn, ln, dobyr, dobmn, dobdt, fthrname,mthrname, prsntadrs, prmnntadrs, phn, mail,gndr, religion, mat, nation,oid,pass,adyr,admn,addate, clas, roll,classId);
						tempStudent.inputToDatabase(g);
                                                JOptionPane.showMessageDialog(null,"Success");
						
						//JPanel p = (JPanel) getContentPane();
						 //p.removeAll();
						 //p.add(adminMain);
                                                 studentRegistrationform.refresh();
						 repaint();
						 revalidate();
                                           }
					}
				}
				
		);
		
		
		
		adminMain.searchStudent.addActionListener(
				
				new ActionListener (){
					public void actionPerformed (ActionEvent ev){
						JPanel p = (JPanel) getContentPane();
						 p.removeAll();
						 p.add(studentInfo);
						 repaint();
						 revalidate();
					}

					
				}
				
		);
		
		studentInfo.back.addActionListener(
				
				new ActionListener (){
					public void actionPerformed (ActionEvent ev){
						JPanel p = (JPanel) getContentPane();
						 p.removeAll();
						 p.add(adminMain);
						 repaint();
						 revalidate();
					}

					
				}
				
		);
		
		studentInfo.search.addActionListener(
				
				new ActionListener (){
					public void actionPerformed (ActionEvent ev){
						try 
						{
							String query = "select * from student where oid = '"+studentInfo.studentId.getText()+"'";
							rs = st.executeQuery(query);
							
							while (rs.next())
							{
							System.out.println ( rs.getString("firstname") +"\t" + rs.getString("lastname"));
							System.out.println(rs.getString("fathername"));
							System.out.println(rs.getString("mothername"));
							System.out.println(rs.getString("dob"));
							System.out.println(rs.getString("gender"));
							System.out.println(rs.getString("presentaddress"));
							System.out.println(rs.getString("permanent"));
							System.out.println(rs.getString("phone"));
							System.out.println(rs.getString("email"));
							System.out.println(rs.getString("religion"));
							System.out.println(rs.getString("maratialstatus"));
							System.out.println(rs.getString("nationality"));
							System.out.println(rs.getString("class"));
							System.out.println(rs.getString("admissiondate"));
							System.out.println(rs.getString("classroll"));
							System.out.println(rs.getString("oid"));
							
								String result = "Name : " +rs.getString("firstname") +"\t" + rs.getString("lastname")
												+"\nFather's Name : " + rs.getString("fathername")+
												"\nMother's Name : " +rs.getString("mothername") +
												"\nDate of Birth : " + rs.getString("dob") +
												"\nGender : " + rs.getString("gender") +
												"\nPresent Address : " + rs.getString("presentaddress")+
												"\nPermanent Address : " + rs.getString("permanent") +
												"\nPhone Number : "+rs.getString("phone")+
												"\nEmail Address : " + rs.getString("email") +
												"\nReligion : " + rs.getString("religion") +
												"\nMaratial Status : " + rs.getString("maratialstatus") +
												"\nNationality :" + rs.getString("nationality") +
												"\nClass : " +rs.getString("class") +
												"\nAdmission Date : " +  rs.getString("admissiondate") +
												"\nClass Roll : " + rs.getString("classroll") +
												"\nOrganizational Id :" + rs.getString("oid")
								;
							
								//studentInfo.details.setText(result);
								studentInfo.name.setText("Name : "+rs.getString("firstname") +" " + rs.getString("lastname"));
								studentInfo.fathername.setText("Father's Name : " + rs.getString("fathername"));
								studentInfo.mothername.setText("Mother's Name : " +rs.getString("mothername"));
								studentInfo.dob.setText("Date of Birth : " + rs.getString("dob"));
								studentInfo.gender.setText("Gender : " + rs.getString("gender"));
								studentInfo.presentaddress.setText("Present Address : " + rs.getString("presentaddress"));
								studentInfo.permanntadrs.setText("Permanent Address : " + rs.getString("permanent"));
								studentInfo.phone.setText("Phone Number : "+rs.getString("phone"));
								studentInfo.email.setText("Email Address : " + rs.getString("email"));
								studentInfo.religion.setText("Religion : " + rs.getString("religion"));
								studentInfo.maratial.setText("Maratial Status : " + rs.getString("maratialstatus"));
								studentInfo.nation.setText("Nationality :" + rs.getString("nationality"));
								studentInfo.clas.setText("Class : " +rs.getString("class"));
								studentInfo.admission.setText("Admission Date : " +  rs.getString("admissiondate"));
								studentInfo.classroll.setText("Class Roll : " + rs.getString("classroll"));
								studentInfo.oid.setText("Organizational Id :" + rs.getString("oid"));
							}
							
						
							
						}
						catch (Exception ex)
						{
							System.out.println(ex);
						}
					}

					
				}
				
		);
			
	}
	
	public void inputDataToStudentDataBase (String fn ,String ln,String fthrname,String mthrname,String dobdt,String dobmn,String dobyr,String gndr, String prsntadrs, String prmnntadrs, String phn, String mail, String religion, String mat,String nation,String clas, String addate, String admn,String adyr, String roll,String oid, String pass){
		//insert into student values ('Tanvir','Ahmed','Md.Nazim Uddin','Samsun Naher','1994-01-14','male','ghtl','tngl','01671572537','gmail','muslim','unmarried','bd','15','2000-12-05','01','01-2005-15','5245')
		String query = "insert into student values ('" + fn +"','"+ln+"','"+fthrname+"','"+mthrname+"','"+dobyr+"-"+dobmn+"-"+dobdt+"','"+gndr+"','"+prsntadrs+"','"+prmnntadrs+"','"+phn+"','"+mail+"','"+religion+"','"+mat+"','"+nation+"','"+clas+"','"+adyr+"-"+admn+"-"+addate+"','"+roll+"','"+oid+"','"+pass+"')";
	//	"insert into person values ('"+name+"','"+dob+"')";
		try 
		{
			st.executeUpdate(query);
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
	
/*	public static void main (String [] args){
		
		Gui g = new Gui();
		g.setSize(700,600);
		g.setVisible(true);
		g.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//g.inputDataToStudentDataBase("Ahmed", "Tanvir","Nazim", "samsun","14","01","1994","male","ghtl", "tngl", "01671","gm"," religion", "mat", "nation", "cl", "01", "02","1545", "40", "456", "546");
	}*/
	
	
	
	
}
