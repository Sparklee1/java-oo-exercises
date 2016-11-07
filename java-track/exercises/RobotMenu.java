import java.util.ArrayList;
import java.util.Scanner;

public class RobotMenu {

	private ArrayList <Robot> robots;
	private Scanner s;

	public static void main (String[]args){
		int x = 0;
		RobotMenu rm = new RobotMenu();
		do {
			x=rm.StartMenu();
		}while (x !=6);
	}
	public RobotMenu()
	{
		s = new Scanner(System.in);
		robots = new ArrayList<Robot>();
	}
	public int StartMenu()
	{
		System.out.println("Welcome to the robot menu!");
		System.out.println("1. Create a robot");
		System.out.println("2. Display the list of available robots");
		System.out.println("3. Move a robot");
		System.out.println("4. Rotate a robot");
		System.out.println("5. Compute the distance between two robots");
		System.out.println("6. Exit");
		System.out.println("Please select an option:");
		int selection = s.nextInt();
		while (selection < 0 || selection > 6)
		{
			System.out.println("Invalid selection, please try again:");
			selection = s.nextInt();
		}
		return selection;
	}
	public void processInput (int selection)
	{
		if (selection == 1)
		{
			createRobot();
		}
		else if (selection == 2)
		{
			displayRobots();
		}
		else if (selection == 3)
		{
			displayRobot();
			Robot r = selectRobot();
			
		}
		System.out.println("Enter the name of the Robot ");
		String n = s.nextLine();
		System.out.println("Enter the x postion of the Robot ");
		int x = s.nextInt();
		System.out.println("Enter the y postion of the Robot ");
		int y = s.nextInt();
		System.out.println("Enter the speed of the Robot ");
		int speed = s.nextInt();
		System.out.println("Enter the orientation of the robot(1 = North, 2 = East, 3 = South, 4 = West)");
		int ori = s.nextInt();
		Robot a1 = new Robot(n,x,y,speed,ori);
		System.out.println("Your robot details are " + a1);
		System.out.println(a.name + " is at a distance of "+ a.distance(a1)+" from " + a1.name);
		System.out.println("Enter the direction (left or right) for the Robot to turn ");
		String dir = s.nextLine();
		System.out.println(dir);
		System.out.println(a1.Position(dir));

	}
}

