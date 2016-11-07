public class Student {

	private String firstName;
	private String lastName;
	private String name;
	private int studentID;
	private int credits;
	private double gpa;

	/* 20,000 per semester / 15 credit hours = 1333.33 per credit hour*/
	protected double tuitionPerCredit = 1333.33;

	public Student(String firstName, String lastName, int studentID){
		this.firstName = firstName;
		this.lastName = lastName;		
		this.name = firstName+" "+lastName;
		this.studentID = studentID;
	}

	public Student(String name, int studentID, double gpa, int credits) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.studentID = studentID;
		this.credits = credits;
		this.gpa = gpa;
	}

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getStudentID() {
		return studentID;
	}


	public void setStudentID(int studentId) {
		this.studentID = studentId;
	}


	public int getCredits() {
		return credits;
	}


	public void setCredits(int credits) {
		this.credits = credits;
	}


	public double getGPA() {
		return gpa;
	}


	public void setGPA(double gpa) {
		this.gpa = gpa;
	}

	public String getClassStanding(){
		if (this.credits < 30){
			return "Freshman";
		}else if (this.credits > 29 && this.credits < 60){
			return "Sophomore";
		}else if (this.credits > 59 && this.credits < 90){
			return "Junior";
		}else if (this.credits >= 90){
			return "Senior";
		}
		else return ("Not a student");
	}
	public void submitGrade(double grade, int credits){
		double qualityScore = grade * credits;		
		this.gpa = (qualityScore+(this.gpa*this.credits))/(this.credits+credits); //calculate the gpa
		this.gpa = Math.round(this.gpa*1000d)/1000d; //set the gpa to 3 decimal points
		this.credits += credits;
	}
	public double computeTuition(){
		double tuition = 0;
		//add 20,000.00 for every 15 full credits (one full semester)
		tuition += 20000 * (this.credits / 15);
		//add 1333.33 for every leftover credit after adding full semesters
		tuition += tuitionPerCredit * (this.credits % 15);
		return tuition;

	}

	public Student createLegacy(Student s, Student ss){
		String name = s.getName()+" "+ss.getName();
		int studentID = s.getStudentID() + ss.getStudentID();
		double gpa = ((s.gpa + ss.gpa)/2.0);
		int c = 0;
		if(s.credits>ss.credits) c = s.getCredits();
		else c = ss.getCredits();
		Student sss = new Student(name, studentID, gpa, c);
		return sss;
	}
	public String toString(){
		return (name +" "+ studentID);
	}
}



