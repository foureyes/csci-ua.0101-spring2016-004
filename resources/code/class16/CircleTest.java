
public class CircleTest {

public static void main(String[] args) {
	Circle circle1 = new Circle();
	System.out.println("The area of the circle of radius"
			+ circle1.radius + " is " + circle1.getArea());
	
	Circle circle2 = new Circle(25); System.out.println("The area of the circle of radius "
			+ circle2.radius + " is " + circle2.getArea());
	
	Circle circle3 = new Circle(125); System.out.println("The area of the circle of radius "
			+ circle3.radius + " is " + circle3.getArea());
	
	// Modify circle radius
	circle2.radius = 100; 
	
	System.out.println("The area of the circle of radius " + circle2.radius + " is " + circle2.getArea());

	Circle myCircle = new Circle(4);
	Circle yourCircle = myCircle;
	System.out.println(myCircle.radius);
	System.out.println(yourCircle.radius);
	myCircle.radius = 2;
	System.out.println(myCircle.radius);
	System.out.println(yourCircle.radius);
	Circle[] circles = new Circle[3];
	for(int i = 0; i < circles.length; i++) {
		circles[i] = new Circle(i + 1);
	}
	System.out.println(circles[2].radius);

}
}
		/*
		Circle circle1 = new Circle(); 
		

		*/
//	￼￼￼￼￼￼￼￼}
//}
