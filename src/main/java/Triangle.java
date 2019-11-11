



/*
 * Description: This class provide methods that determine the type of the 
 * triangle based on the triangle sides' length
 * @author nguyen
 * @version 090519
 */
import java.io.IOException;
import java.lang.Math;
public class Triangle {
	//Declare variable
	private double side1;
	private double side2;
	private double side3;
	
	/**
	 * Constructor
	 */
	public Triangle(double s1, double s2, double s3) {
		setTriangleSides(s1,s2,s3);
	}
	public Triangle(Point A, Point B, Point C) {
		double d1=A.getDistance(B);
		double d2=A.getDistance(C);
		double d3=B.getDistance(C);
		setTriangleSides(d1,d2,d3);
	}
	/**
	 * This method get the sides s1,s2,s3 and stores them to side1 field,
	 * side2 field, and side3 field. 
	 * @param s1
	 * @param s2
	 * @param s3
	 * @ 
	 */
	public void setTriangleSides(double s1,double s2, double s3) {
		if(isValidTriangleSides(s1,s2,s3)){
		side1=s1;
		side2=s2;
		side3=s3;
		}
	}
	/**
	 * This method return an array of size 3. This array includes the
	 * value  of side1, side2, side3 field
	 * @return double[]
	 */
	public double[] getTriangleSides(){
		double[] sides={side1,side2,side3};
		return sides;
	}
	
	/**
	 * Description: This function determine the triangle's type.
	 * @return String
	 */
	public String getTriangleTypes(){
		//System.out.print("get triangle");
		String triangleTypes="";
		if(isEquilateralTriangle()) 
			triangleTypes+="Equilateral";
		else if(isScaleneTriangle()){
			triangleTypes+="Scalene";
			if(isRightTriangle())
				triangleTypes+=" "+"Right";
		}
		else{
			triangleTypes+="Isosceles";
			if(isRightTriangle())
				triangleTypes+=" "+"Right";
		}
		return (triangleTypes+" "+"Triangle");
	}
	 
	/**
	 * Description: This function checks whether or not this triangle 
	 * is an Equilateral triangle. A triangle with tree congruent sides.  
	 * @return boolean
	 */
	public boolean isEquilateralTriangle(){
		if(side1==side2&side2==side3){
			return true;
		}
		else return false;
	}
	/**
	 * Description: This function checks if the triangle is an Isosceles triangle.
	 * A triangle with exactly two congruent sides
	 * @return boolean
	 */
	public boolean isIsoscelesTriangle(){
		if((side1==side2&&side2!=side3)||(side1==side3&&side1!=side2)
				||(side2==side3&&side1!=side2)){
			return true;
		}//end if
		else 
			return false;
	}
	
	
	/**
	 * Description: This function check if the triangle is an Scalene triangle
	 * which is a triangle with no congruent sides 
	 * @return
	 */
	public boolean isScaleneTriangle(){
		if(side1!=side2 &&side2!=side3 && side1!=side3){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Description: This function determine if the triangle is a Right Triangle
	 * @return boolean
	 */
	public boolean isRightTriangle(){
		if(followPythagorean(side1,side2,side3)
				|| followPythagorean(side1,side3,side2)
				|| followPythagorean(side2,side3,side1)){
			return true;
		}
		else
			return false;
	}
	
	
	/**
	 * Description: this function return true if a^2+b^2=c^2 with allowed error=0.1
	 * the function will return true if absolute(a^2+b^2-c^2)<0.1
	 * @param a
	 * @param b
	 * @param c
	 * @return boolean
	 */
	public static boolean followPythagorean(double a, double b, double c){
		double error=Math.pow(a,2.0)+Math.pow(b,2.0)-Math.pow(c,2.0);
		return (Math.abs(error)<0.1);
	}
	
	public double getArea(){
		double s=(side1+side2+side3)/2;//semi-primeter
		double area;
		area=Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
		return area;
		
	}
	/**
	 * Description: This function check if the triangle side's lengths are 
	 * positive and  satisfy the Triangle Inequality Theorem and
	 * @return boolean
	 * @ 
	 */
	public static boolean isValidTriangleSides(double side1, double side2, double side3) {
		boolean valid=true;
		if(side1<0||side2<0||side3<0){
			valid=false;
			System.out.println("Error! All the sides' length must be greater than 0.");
			//System.out.println();
		}
		else if((side1+side2)<=side3||(side1+side3)<=side2||(side2+side3)<=side1){
			valid=false;
			System.out.println("Error! Violate the Triangle Inequality Theorem.");
		}
		return valid;
	}
}
	
