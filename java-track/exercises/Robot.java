public class Robot {

	//fields
	private String name;
	private int speed;
	private int x;
	private int y;
	private int orientation;

	public Robot(String name, int x, int y, int speed, int orientation){

		this.name = name;
		this.speed = speed;
		this.x = x;
		this.y = y;
		this.orientation = orientation;
	}
	public String getName(){
		return this.name;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public int getSpeed(){
		return this.getSpeed();
	}
	public int getOrientation(){
		return this.orientation;

	}
	public String convertOrientation()
	{
		if((this.orientation == 360) || (this.orientation == -360))
		{
			this.orientation = 0;
		}
		if((this.orientation==0))
		{
			return "North";
		}
		else if((this.orientation==90) || (this.orientation ==-270 ))
		{
			return "East";
		}
		else if((this.orientation==180) || (this.orientation == -180))
		{
			return "South";
		}
		else if((this.orientation==270) || (this.orientation == -90))
		{
			return "West";
		}
		else
			return "Invalid direction";

	}
	public void move()
	{
		if(this.convertOrientation()=="North")
		{
			this.y = this.y+this.speed;

		}
		else if(this.convertOrientation()=="East")
		{
			this.x = this.x+this.speed;
		}
		else if(this.convertOrientation()=="South")
		{
			this.y = this.y-this.speed;
		}
		else if(this.convertOrientation()=="West")
		{
			this.x = this.x-this.speed;
		}

	}
	public void Position(String direction)
	{
		if(direction=="left")
		{
			this.orientation = orientation - 90;
		}
		if(direction=="right")
		{
			this.orientation = orientation + 90;
		}
	}
	public double distance(Robot r)
	{
		double dist = Math.sqrt((Math.pow((this.x-r.x), 2))+(Math.pow((this.y-r.y), 2)));
		return dist;
	}
	public String toString() 
	{
		return "Robot [Name=" + this.name + ", Position= [" + this.x+", " +this.y+"], Speed=" + this.speed + ", Orientation="
				+ this.convertOrientation() + "]";
	}


	public static void main(String[] args)
	{
		Robot a = new Robot("Sam", 1, 9, 9, 90);

		Robot b = new Robot("Zac", -4, 3, 1,  180);

		Robot c = new Robot("Fred", -4, -4, 5,  0);

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);

	}
}	

