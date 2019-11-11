package cosc4353.as6;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DecimalFormat;

import org.junit.Test;

public class PointTest {
	@Test
	public void getCoordination() throws AssertionError{
		Point O=new Point();
		O.setX(1);
		O.setY(1);
		assertEquals(O.getX(),1);
	}
	@Test
	public void distanceOfTwoPoints_Test1() throws AssertionError{
		Point p1= new Point(4,3);
		Point p2 = new Point( 3, -2);
		DecimalFormat df = new DecimalFormat("0.0000");
		double compareResult=Double.parseDouble(df.format(p1.getDistance(p2)));//System.out.println(Double.parseDouble(df.format(p1.getDistance(p2))));
		assertEquals(compareResult,5.0990);
	}
	
	@Test
	public void distanceOfTwoPoints_Test2() throws AssertionError{
		Point p1= new Point(1,2);
		Point p2 = new Point( 5, 5);
		DecimalFormat df = new DecimalFormat("0.0000");
		double compareResult=Double.parseDouble(df.format(p1.getDistance(p2)));
		assertEquals(compareResult,5.0000);
	}
	
	@Test
	public void createTriangleByPoints_Test1() throws IllegalArgumentException {
		Point A= new Point(1,2);
		Point B = new Point(2,2);
		Point C = new Point(6,3);
		Triangle ta = new Triangle(A,B,C);
		assertTrue(ta.getTriangleTypes().toLowerCase().contains("scalene"));
	}
	
	@Test
	public void createTriangleByPoints_Test2() throws IllegalArgumentException {
		Point A= new Point(-1,5);
		Point B = new Point(4,0);
		Point C = new Point(6,6);
		Triangle ta = new Triangle(A,B,C);
		assertTrue(ta.getTriangleTypes().toLowerCase().contains("isosceles"));
	}
	
	@Test
	public void createTriangleByPoints_Test3() throws IllegalArgumentException {
		Point A= new Point(0,0);
		Point B = new Point(0,10);
		Point C = new Point(10,0);
		Triangle ta = new Triangle(A,B,C);
		assertTrue(ta.getTriangleTypes().toLowerCase().contains("right"));
	}
	
	@Test
	public void createTriangleByPoints_Test4() throws IllegalArgumentException {
		Point A= new Point(-3,0);
		Point B = new Point(3,0);
		Point C = new Point(0,3*Math.sqrt(3));
		Triangle ta = new Triangle(A,B,C);
		assertTrue(ta.getTriangleTypes().toLowerCase().contains("equilateral"));
	}
	@Test
	public void createTriangleByPoints_Test5() throws IllegalArgumentException {
		Point A= new Point(0,0);
		Point B = new Point(0,3);
		Point C = new Point(4,0);
		Triangle ta = new Triangle(A,B,C);
		assertTrue(ta.getTriangleTypes().toLowerCase().contains("right"));
	}
	
	@Test
	public void createTriangleByPoints_Test6() throws IllegalArgumentException {
		Point A= new Point(2,2);
		Point B = new Point(6,2);
		Point C = new Point(4,8);
		Triangle ta = new Triangle(A,B,C);
		assertTrue(ta.getTriangleTypes().toLowerCase().contains("isosceles"));
	}
	


	
	@Test
	public void triangleAreaByPoints_Test1() throws IllegalArgumentException {
		Point A= new Point(-1,5);
		Point B = new Point(4,0);
		Point C = new Point(6,6);
		Triangle ta = new Triangle(A,B,C);
		DecimalFormat df = new DecimalFormat("0.000");
		double commpareResult=Double.parseDouble(df.format(ta.getArea()));
		assertEquals(commpareResult,20.000);
		
	}
	
	@Test
	public void triangleAreaByPoints_Test2() throws IllegalArgumentException {
		Point A= new Point(-3,0);
		Point B = new Point(3,0);
		Point C = new Point(0,3*Math.sqrt(3));
		Triangle ta = new Triangle(A,B,C);
		DecimalFormat df = new DecimalFormat("0.000");
		double commpareResult=Double.parseDouble(df.format(ta.getArea()));
		assertEquals(commpareResult,15.588);
	}
	


}
