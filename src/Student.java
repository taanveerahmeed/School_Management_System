
import javax.swing.JOptionPane;


public class Student extends Person {
	
	private String clas;
	private String adMn;
	private String adYr;
	private String adDt;
	private String classRoll;
        
        private int classId;
        
	
	public Student ()
	{
		super ();
	}
	
	public Student (String fn,String ln, String dobyr,String dobmn,String dobdt, String fathr, String mthr, String prnadrs,String prmnadrs, String phn, String email, String sex, String rlg,String ms, String nation, String id,String pass,String adyr,String admn,String addt,String clas,String roll,int classId)
	{
		super (fn,ln,dobyr,dobmn,dobdt,fathr,mthr,prnadrs,prmnadrs,phn,email,sex,rlg,ms,nation,id,pass);
		adMn = admn;
		adYr = adyr;
		adDt = addt;
		this.clas = clas;
		classRoll = roll;
                this.classId = classId;
	}
	
        public void setClassId (int n){
        
            classId = n;
        }
        
        public int getClassId (){
            
            return classId;
        }
	public void setClass (String cl){
		clas = cl;
	}
	
	public void setClassRoll (String rl){
		classRoll = rl;
	}
	
	public String getClas (){
		return clas;
	}
	public void setAdDt (String n) {
		adDt = n;
	}
	
	public void setAdMn (String n){
		adMn = n;
	}
	
	public void setAdYr (String n){
		adYr = n;
	}
	
	public String getAdDt () {
		return adDt ;
	}
	
	public String getAdMn (){
		return adMn;
	}
	
	public String getAdYr (){
		return adYr;
	}
	public String getClassRoll (){
		return classRoll ;
	}
	
	public void inputToDatabase (Gui g){
		String query = "insert into student values ('" + this.getFirstName() +"','"+this.getLastName()+"','"+this.getFatherName()+"','"+this.getMotherName()+"','"+this.getDobYr()+"-"+this.getDobMn()+"-"+this.getDobDt()+"','"+this.getSex()+"','"+this.getPresentAddress()+"','"+this.getPermanentAddress()+"','"+this.getPhoneNumber()+"','"+this.getEmail()+"','"+this.getReligion()+"','"+this.getMaratialStatus()+"','"+this.getNationality()+"','"+this.getClas()+"','"+this.getAdYr()+"-"+this.getAdMn()+"-"+this.getAdDt()+"','"+this.getClassRoll()+"','"+this.getID()+"','"+this.getPassword()+"')";
		//	"insert into person values ('"+name+"','"+dob+"')";
			try 
			{
				g.st.executeUpdate(query);
			}
			catch (Exception ex)
			{
				System.out.println(ex);
			}
                 query = "insert into studentrelationtoclass values ('" + this.getID()+"',"+this.getClassId()+")";
		//	"insert into person values ('"+name+"','"+dob+"')";
			try 
			{
				g.st.executeUpdate(query);
			}
			catch (Exception ex)
			{
				JOptionPane.showMessageDialog(null,ex);
			}
                 
	}

}
