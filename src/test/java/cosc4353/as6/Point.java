package cosc4353.as6;


import java.lang.Math;
public class Point {
		private double x;
		private double y;
		
		
		/**
		 * Default constructor 
		 */
		public Point(){
			x=0;
			y=0;
		}
		public Point(double x, double y){
			this.x=x;
			this.y=y;
		}
		public double getX(){
			return this.x;
		}
		public double getY(){
			return this.y;
		}
		public void setX(double x){
			this.x=x;
		}
		public void setY(double y){
			this.y=y;
		}
		
		
		/**
		 * This function return a the distance from this Point to point P
		 * @param P
		 * @return
		 */
		public double getDistance(Point P){
			double d;
			
			d=Math.sqrt(Math.pow(this.x-P.getX(), 2)+
					Math.pow(this.y-P.getY(), 2));
			return d;
		}
}//end class Point

