
import java.io.*;
import java.util.Scanner;

/**
 * This is a simple program implement the class Triangle
 * @author nguyen
 * Professor:
 * Date:09-05-2019
 * Course: COSC4353
 */
public class Main {
	
	//ENTRY TO PROGRAM 
	public static void main(String[] args)   {
		
		//start Program
		welcome();
		buildTriangleProgram();
	}
	
	
	//header
	
	private static void welcome(){
		System.out.println("*****************************************************");
		System.out.println("********************** Welcome **********************");
		System.out.printf("*%51s*\n", ' ');
		System.out.println("*	      DETERMINE TRIANGLE'S TYPE	            *");
		System.out.printf("*%51s*\n", ' ');
		System.out.println("*****************************************************");
		System.out.println("*****************************************************\n");
	}
	
	private static int option() {
		int chosenOption;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("\nBuild Triangle:\n");
		System.out.println("Option 1: Build Triangle from 3 points");
		System.out.println("Option 2: Build Triangle from 3 sides");
		System.out.println("Option 3: Quit Program");
		System.out.println("Please choose an option by enter the option number(1, 2 or 3):");
		chosenOption = keyboard.nextInt();
		return chosenOption;
		
	}
	private static void buildTriangleProgram()   {
		int chooseOption;
		String continueProgram="YES";
		Scanner keyboard = new Scanner(System.in);
		Triangle thisTriangle = null;
		while(continueProgram.charAt(0)=='Y'||continueProgram.charAt(0)=='y') {
		chooseOption=option();
		if(chooseOption==2) {
			thisTriangle = buildTriangleBySides();
			System.out.println(thisTriangle.getTriangleTypes());
			System.out.print("Area ="+thisTriangle.getArea());
		}
		else if(chooseOption==1) {
			thisTriangle=buildTriangleByPoints();
			System.out.println(thisTriangle.getTriangleTypes());
			System.out.println("Area ="+thisTriangle.getArea());
		}
		else if(chooseOption==3) {
			System.exit(0);
			break;
		}
		System.out.print("\nDo you want to continue(Y/N)");
		continueProgram=keyboard.next();
		}
		System.out.print("*********************  Thanks for using my program  ************************");
	}
	private static Triangle buildTriangleBySides()   {
		//Declare variables used
				double[] sides ={0.0,0.0,0.0};
				//get  the length of triangle's sides from user
				sides=getSides();
				while(!Triangle.isValidTriangleSides(sides[0],sides[1],sides[2])){
					sides=getSides();
				}
				Triangle ta= new Triangle(sides[0],sides[1],sides[2]);
				
				return ta;
	}
	private static Triangle buildTriangleByPoints()   {
		Point[] points = new Point[3];
		Scanner keyboard = new Scanner(System.in);
		Triangle tria;
		boolean successful=false;
		while(!successful) {
		for(int i=0;i<3;i++) {
			System.out.print("Please enter Point "+(i+1)+" : (x,y)= ");
			points[i]= new Point();
			try {
			points[i].setX(keyboard.nextDouble());
			points[i].setY(keyboard.nextDouble());
			successful=true;
			}catch(NumberFormatException e) {
				System.out.println(e.getMessage()+"is an invalid point coordinate");
				successful = false;
				//return isSuccessful;///
				break;
			}
		}
		}
		tria= new Triangle(points[0],points[1],points[2]);
		//System.out.println(tria.getTriangleTypes());
		//System.out.println("Area ="+tria.getArea());
		return tria;
	}
	/**
	 * This function get the length of 3 sides of the triangle from user, 
	 *and stores the value into an array of size 3 
	 * @return double[]
	 */
	private static double[] getSides(){
		double [] sides={0.0,0.0,0.0};
		// Create Scanner variable keyboard to reference a Scanner object
		Scanner keyboard = new Scanner(System.in);
		
		boolean validSides=false;
		while(!validSides){
			System.out.print("Please enter the length of each side of the triangle:\n");
			System.out.println("(a,b,c)");
			//check if inputFailure occurs
			try{
				for(int i=0;i<3;i++){
					sides[i]=Double.parseDouble(keyboard.next());
					//System.out.println(i+" "+ sides[i]);
					validSides=true;
				}
			}
			catch(NumberFormatException e){
				System.out.println(e.getMessage()+"is an invalid sides's length.");
				validSides=false;
				keyboard.nextLine();//clear the buffer
			}
		}
		return sides;
	}	
}

