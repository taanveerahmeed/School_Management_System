
import javax.swing.JOptionPane;


public class Teacher extends Person {
	
	String joinDt,joinMn,joinYr,department,post,educationalBackground;
	int salary;
	
	Teacher (){}
	
	Teacher (String fn,String ln, String dobyr,String dobmn,String dobdt,  String fathr, String mthr, String prnadrs,String prmnadrs, String phn, String email, String sex, String rlg,String ms, String nation, String id,String pass,String joindt,String joinmn,String joinyr,String dept,String post,String eb,int sal){
		
		super (fn,ln,dobyr,dobmn,dobdt,fathr,mthr,prnadrs,prmnadrs,phn,email,sex,rlg,ms,nation,id,pass);
		joinDt = joindt;
		joinMn = joinmn;
		joinYr = joinyr;
		department = dept;
		this.post = post;
		educationalBackground = eb;
		salary = sal;
		
	}
	
        public void insert (Gui g){
            
            String query = "insert into teacher values ('"+this.getFirstName()+"','"+this.getLastName()+"','"+this.getFatherName()+"','"+this.getMotherName()+"','"+this.getDobYr()+"-"+this.getDobMn()+"-"+this.getDobDt()+"','"+this.getSex()+"','"+this.getPresentAddress()+"','"+this.getPermanentAddress()+"','"+this.getPhoneNumber()+"','"+this.getEmail()+"','"+this.getReligion()+"','"+this.getMaratialStatus()+"','"+this.getNationality()+"','"+this.joinYr+"-"+this.joinMn+"-"+this.joinDt+"','"+this.educationalBackground+"','"+this.department+"',"+this.salary+",'"+this.getID()+"','"+this.getPassword()+"','"+this.post+"')";
            System.out.print(query);
            
            try {
                
                g.st.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Success");
               // g.teacherRegistrationForm.output.setText("Success");
            
            }catch (Exception ex){
               
                JOptionPane.showMessageDialog(null, ex);
               // g.teacherRegistrationForm.output.setText(ex.toString());
            
            }
        }
	

}
