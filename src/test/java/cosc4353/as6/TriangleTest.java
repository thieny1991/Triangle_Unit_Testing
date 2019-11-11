package cosc4353.as6;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Test;

public class TriangleTest {
	
	@Test
	public void createTriangleBySides_Tests1() throws Exception{
		Triangle ta = new Triangle(3,4,5);
		assertTrue(ta.getTriangleTypes().toLowerCase().contains("scalene"));
	}
	
	@Test
	public void createTriangleBySides_Test2() throws Exception{
		Triangle ta = new Triangle(7,4,7);
		assertTrue(ta.isIsoscelesTriangle());
	}
	
	@Test
	public void createTriangleBySides_Test3() throws Exception{
		Triangle ta = new Triangle(6,6,6);
		assertTrue(ta.getTriangleTypes().toLowerCase().contains("equilateral"));
	}
	
	@Test
	public void createTriangleBySides_Test4() throws Exception{
		Triangle ta = new Triangle(3,4,5);
		assertTrue(ta.getTriangleTypes().toLowerCase().contains("right"));
	}
	 
	@Test
	public void createTriangleBySides_Test5() throws Exception{
		Triangle ta = new Triangle(1,1,Math.sqrt(2));
		assertTrue(ta.getTriangleTypes().toLowerCase().contains("right"));
	}
	
	
	@Test
	public void createTriangleBySides_Test6() throws Exception{
		Triangle ta = new Triangle(4.2,4.6,6.1);
		assertTrue(ta.getTriangleTypes().toLowerCase().contains("scalene"));
	} 
	@Test
	public void createTriangleBySides_Test7() throws Exception{
		Triangle ta = new Triangle(4,7,7);
		assertTrue(ta.isIsoscelesTriangle());
	}
	
	@Test
	public void createTriangleBySides_Test8() throws Exception{
		Triangle ta = new Triangle(7,7,4);
		assertTrue(ta.isIsoscelesTriangle());
	}
	
	
	
	@Test
	public void createTriangleBySides_Test9() throws Exception{
		Triangle ta = new Triangle(1,Math.sqrt(2),1);
		assertTrue(ta.getTriangleTypes().toLowerCase().contains("right"));
	}
	@Test
	public void createTriangleBySides_Test10() throws Exception{
		Triangle ta = new Triangle(Math.sqrt(2),1,1);
		assertTrue(ta.getTriangleTypes().toLowerCase().contains("right"));
	}
	@Test
	public void createTriangleBySides_Test11() throws Exception{
		Triangle ta = new Triangle(4.2,4.6,6.1);
		assertFalse(ta.isIsoscelesTriangle());
	} 
	@Test
	public void createTriangleBySides_Test12() throws Exception{
		Triangle ta = new Triangle(7,7,7);
		assertFalse(ta.isIsoscelesTriangle());
	}
	@Test
	public void createTriangleBySides_Test13() throws Exception{
		Triangle ta = new Triangle(3,7,6);
		assertFalse(ta.isIsoscelesTriangle());
	}
	@Test
	public void followPythegorean_Test1() {
		
		assertTrue(Triangle.followPythagorean(3,4,5)==true);
	}
	
	@Test
	public void getTriangleSides_Test1() throws AssertionError{
		Triangle ta = new Triangle(7,7,4);
		double testingSides[]= {7,7,4};
		double sides[]=ta.getTriangleSides();
		assertArrayEquals(testingSides,sides);
		
	}
	
	@Test
	public void setTriangleSides_Test1(){
		Triangle ta = new Triangle(3,4,5);
		assertTrue(ta.setTriangleSides(6,8,10));
	}
	@Test
	public void setTriangleSides_Test2(){
		Triangle ta = new Triangle(3,4,5);
		assertFalse(ta.setTriangleSides(-2,8,10));
	}
	
	@Test
	public void isValidTriangleSides_Test1(){
		assertTrue(Triangle.isValidTriangleSides(2,3,2));
	}
	
	@Test
	public void isValidTriangleSides_Test2(){
			assertFalse(Triangle.isValidTriangleSides(-2,3,2));
	
	}
	
	@Test
	public void isValidTriangleSides_Test3(){
			assertFalse(Triangle.isValidTriangleSides(2,-3,2));
	
	}
	@Test
	public void isValidTriangleSides_Test4(){
			assertFalse(Triangle.isValidTriangleSides(2,3,-2));
	
	}
	@Test
	public void isValidTriangleSides_Test5(){
			assertFalse(Triangle.isValidTriangleSides(2,4,6));
	
	}
	@Test
	public void isValidTriangleSides_Test6(){
			assertFalse(Triangle.isValidTriangleSides(2,6,4));
	
	}
	@Test
	public void isValidTriangleSides_Test7(){
			assertFalse(Triangle.isValidTriangleSides(6,3,1));
	
	}
	
	
	
	
	

	
}
