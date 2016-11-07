import static org.junit.Assert.*;

import org.junit.Test;

public class RobotTest {

	@Test
	public void testConvertOrientation() {
		Robot a = new Robot("Jim", 0, 0, 0, 90);
		assertTrue("Problem setting orientation in constructor", a.getOrientation()== 90);
		assertTrue("problem rotating 90 degrees", a.convertOrientation() == "East");

	}

	@Test
	public void testMove(){
		Robot b = new Robot("Alice", 0, 0, 5, 90);
		b.move();
		assertTrue(b.getX() == 5);
		assertTrue(b.getY() == 0);


	}
}