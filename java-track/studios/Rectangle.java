
public class Rectangle {
	//fields

	private double length;
	private double width;

	//behavior
	public Rectangle (double length, double width){

		this.length = length;
		this.width = width;
	}

	public double getLength(){
		return this.length;
	}
	public double getWidth(){
		return this.width;
	}
	public boolean isSquare(){
		if (this.length == this.width){
			return true;
		}else{
			return false;
		}
	}
	public double getPerimeter(){
		return (this.length * 2) + (this.width * 2);		
	}
	public double getArea(){
		return this.length * this.width;
	}
	public boolean isSmaller(Rectangle rectangle){
		if (this.getArea() < rectangle.getArea()){
			return true;
		}else{
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle ericasRectangle = new Rectangle(2.5, 3);
		System.out.println("Erica's Rectangle " + ericasRectangle);
		System.out.println("Erica's Rectangle " +  ericasRectangle.getArea() + " area" );
		Rectangle krutiesRectangle = new Rectangle (1.0, 1.0);
		System.out.println("Krutie's Rectangle " +  krutiesRectangle.getArea() + " area" );
		System.out.println(ericasRectangle.isSmaller(krutiesRectangle));
	}

	@Override
	public String toString() {
		return "[length=" + length + ", width=" + width + ", getLength()=" + getLength() + ", getWidth()="
				+ getWidth() + ", isSquare()=" + isSquare() + ", getPerimeter()=" + getPerimeter() + ", getArea()="
				+ getArea() + "]";
	}




}
