package deneme;
import java.util.*;


public class AreaofRectangleTriangleCircle {
	
	public static double AreaofCircle(double radius)
	
	{
		return 3.14*radius*radius;
	}
    public static double AreaofRectangle(double length, double width)
	
	{
		return length*width;
	}
 
    public static double AreaofTriangle(double basewidth, double height )
	
	{
		return (basewidth*height)/2;
	}
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the radius of Circle: ");
		double radius = sc.nextDouble();
		
		System.out.println("Enter the length of Rectangle: ");
		double length = sc.nextDouble();
		System.out.println("Enter the width of Rectangle: ");
		double width = sc.nextDouble();
		
		System.out.println("Enter the basewidth of Triangle: ");
		double basewidth = sc.nextDouble();
		System.out.println("Enter the height of Triangle: ");
		double height = sc.nextDouble();
		
		double areaofcircle = AreaofCircle(radius);
		System.out.println("The area of circle is:" + areaofcircle);
		
		double areaofrectangle = AreaofRectangle(length,width);
		System.out.println("The area of rectangle is:" + areaofrectangle);

		double areaoftriangle = AreaofTriangle(basewidth,height);
		System.out.println("The area of triangle is:" + areaoftriangle);
		
		
		
		

	}

}
