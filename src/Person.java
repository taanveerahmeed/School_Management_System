
public abstract class Person {
	private String firstName;
	private String lastName;
	private String dobYr;
	private String dobMn;
	private String dobDt;
	private String bloodGroup;
	private String fatherName;
	private String motherName;
	private String presentAddress;
	private String permanentAddress;
	private String phoneNumber;
	private String email;
	private String sex;
	private String religion;
	private String maratialStatus;
	private String nationality;
	private String id;
	private String password;
	
	Person (){
		
	}
	
	Person (String fn,String ln, String dobyr,String dobmn,String dobdt,  String fathr, String mthr, String prnadrs,String prmnadrs, String phn, String email, String sex, String rlg,String ms, String nation, String id,String pass)
	{
		firstName = fn;
		lastName = ln;
		dobYr = dobyr;
		dobMn = dobmn;
		dobDt = dobdt;
		//bloodGroup = bg;
		fatherName = fathr;
		motherName = mthr;
		presentAddress = prnadrs;
		permanentAddress = prmnadrs;
		phoneNumber = phn;
		this.email =email;
		this.sex = sex;
		religion = rlg;
		maratialStatus = ms;
		nationality = nation;
		this.id = id;
		password = pass;
		
	}
	
	public void setFirstName (String n) {
		firstName = n;
	}
	
	public String getFirstName  (){
		return firstName;
		
	}
	
	public void setLastName (String n) {
		lastName = n;
	}
	
	public String getLastName  (){
		return lastName;
		
	}
	
	public void setDobDt (String n) {
		dobDt = n;
	}
	
	public void setDobMn (String n){
		dobMn = n;
	}
	
	public void setDobYr (String n){
		dobYr = n;
	}
	
	public String getDobDt () {
		return dobDt ;
	}
	
	public String getDobMn (){
		return dobMn;
	}
	
	public String getDobYr (){
		return dobYr;
	}
	
	/*public void setBloodGroup (String n) {
		bloodGroup = n;
	}
	
	public String getBloodGroup  (){
		return bloodGroup;
		
	}*/
	
	public void setFatherName (String n) {
		fatherName = n;
	}
	
	public String getFatherName  (){
		return fatherName;
		
	}
	
	public void setMotherName (String n) {
		motherName = n;
	}
	
	public String getMotherName  (){
		return motherName;
		
	}
	
	public void setPresentAddress (String n) {
		presentAddress = n;
	}
	
	public String getPresentAddress  (){
		return presentAddress;
		
	}
	
	public void setPermanentAddress (String n) {
		permanentAddress = n;
	}
	
	public String getPermanentAddress  (){
		return permanentAddress;
		
	}
	
	public void setPhoneNumber (String n) {
		phoneNumber = n;
	}
	
	public String getPhoneNumber  (){
		return phoneNumber;
		
	}
	
	public void setEmail (String n) {
		email = n;
	}
	
	public String getEmail  (){
		return email;
		
	}
	
	public void setSex (String n) {
		sex = n;
	}
	
	public String getSex  (){
		return sex;
		
	}
	
	public void setReligion(String n) {
		religion = n;
	}
	
	public String getReligion  (){
		return religion;
		
	}
	
	public void setMaratialStatus (String n) {
		maratialStatus = n;
	}
	
	public String getMaratialStatus (){
		return maratialStatus;
		
	}
	
	public void setNationality (String n) {
		nationality = n;
	}
	
	public String getNationality  (){
		return nationality;
		
	}
	
	public void setID (String n) {
		id = n;
	}
	
	public String getID  (){
		return id;
		
	}
	
	public void setPassword (String n) {
		password = n;
	}
	
	public String getPassword  (){
		return password;
		
	}
	
	public void showInfo (){
		System.out.println ("Name : " + firstName + " " +lastName );
		System.out.println ("Father's Name : " + fatherName);
		System.out.println ("Mother's Name : " + motherName);
		//System.out.println ("Date of Birth : " + dateOfBirth);
		//System.out.println ("Blood Group : " + bloodGroup);
		System.out.println ("Present Address : " + presentAddress);
		System.out.println ("Permanent Address: " + permanentAddress);
		System.out.println ("Phone Number : " + phoneNumber);
		System.out.println ("Email : " + email);
		System.out.println ("Sex : " + sex);
		System.out.println ("Religion : " + religion);
		System.out.println ("Maratial Status : " + maratialStatus);
		System.out.println ("Nationality : " + nationality);
		System.out.println ("ID : " + id);
	}
	

}
