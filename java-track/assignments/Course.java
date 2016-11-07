
public class Course {
	private String name;
	private int credits;
	private int seats;
	private int remainingSeats;
	private Student roster[];



	public Course(String name, int credits, int seats) {
		this.name = name;
		this.credits = credits;
		this.seats = seats;
		this.remainingSeats = this.seats;
		this.roster = new Student[this.seats];
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getCredits() {
		return credits;
	}



	public void setCredits(int credits) {
		this.credits = credits;
	}

	public int getRemainingSeats() {
		return remainingSeats;
	}



	public void setRemainingSeats(int remainingSeats) {
		this.remainingSeats = remainingSeats;
	}



	public boolean addStudent (Student s){
		if (this.remainingSeats > 0){
			for (int i = 0; i < (this.seats - this.remainingSeats); i++){
				if (roster[i].getName().equals(s.getName())){
					return false;
				}
			}
			this.roster[this.seats - this.remainingSeats] = s;
			this.remainingSeats = this.remainingSeats -1;
			return true;
		}
		return false;
	}
	public String generateRoster(){
		String st = "";
		for (int i = 0; i < (this.seats - this.remainingSeats); i++){
			st += roster[i].getName();
		}
		return st;
	}
	public double averageGPA(){
		double gpaSum = 0;
		for (int i = 0; i < (this.seats - this.remainingSeats); i++){
			gpaSum = gpaSum + roster[i].getGPA();
		}
		double avg = gpaSum/(this.seats - this.remainingSeats);
		return avg;
	}

	public String toString() {
		return "name=" + name + ", credits=" + credits;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

