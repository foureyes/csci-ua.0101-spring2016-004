// import PApplet
import processing.core.PApplet;

// extend PApplet so that your class has access to all of the built-in
// methods in the Processing library
public class ProcessingDemo extends PApplet{
	
	// declaring variables within a class, but outside of methods, creates
	// *instance variables*... these variables are available to all methods 
	// that are *not* declared static
	int faceX = 125, faceY = 125, faceSize = 150;
	int squareX = 0, squareY = 0, squareSize = 70;
	
	// declare a setup method for code that you want to run exactly once
	// at the beginning of your program
	public void setup() {
		
		// the built-in method, size, specifies the dimensions of your window
		size(400, 400);
		
		// the built-in method, noStroke, removes the border for any subsequent
		// shapes drawn with ellipse, rect, triangle, etc.
		noStroke();
		
		// the built-in width and height variables can be used to access the
		// the window's width and height
		squareX = width / 2;
		squareY = height / 2;
	}
	
	// declare a draw method for code that you want to run repeatedly; if this
	// method is found, it will automatically be invoked repeatedly after
	// setup is called
	public void draw() {
		// the built-in method, background, fills the background with the color
		// provided... the parameters are red, green and blue, from 0 to 255 
		// (all 0's are black, all 255's are white)
		background(0, 0, 0);
		
		// the built-in method, fill, causes all subsequent shapes to be filled
		// with the specified color; the three parameters are red, green and
		// blue
		fill(150, 150, 150);
		
		// the built-in method, triangle, draws a triangle with the parameters
		// specifying the coordinates of the 3 points that the triangle consists
		// of... the parameters are:
		// x left base, y left base, x right base, y right base, x top, y top
		triangle(0, height, width, height, height / 2, 0);
		
		// you can call another method from draw, as long as it is *not* 
		// declared static!
		drawFace(faceX, faceY, faceSize);
		
		fill(250, 210, 20);
		
		// the built-in method, rect, draws a rectangle... the parameters are:
		// x coordinate, y coordinate, width, and height
		rect(squareX - squareSize / 2, squareY, squareSize, squareSize);
		
		// this last bit animates the square... every time draw is called, the
		// square is moved
		if(squareY <= height) {
			// move square 5 pixels down
			squareY += 5;
		} else {
			// move square back up to top of window
			squareY = -squareSize;
		}
		
	}
	
	// note that this method also has access to the instance variables above,
	// but in this implementation, the x and y are passed in as arguments
	// to the method instead
	public void drawFace(int x, int y, int s) {
		// draw base (green circle)
		fill(10, 200, 100);
		
		// the built-in method, ellipse, allows you to draw a circle at the
		// specified coordinates; the parameters are:
		// x, y, width, height
		ellipse(x, y, s, s);
		
		// draw eyes (white circles)
		fill(255, 255, 255);
		ellipse(x - s / 4, y, s / 4, s / 4);
		ellipse(x + s / 8, y, s / 4, s / 4);
		
		// draw eyes (black circles)
		fill(0, 0, 0);
		ellipse(x - s * 5 / 16, y, s / 8, s / 8);
		ellipse(x + s / 16, y, s / 8, s / 8);
		
		// draw mouth (black ellipse)
		ellipse(x - s / 16, y + s / 4, s / 4, s / 8);
	}
	
	// if you declare a method called mousePressed, it will be called anytime
	// the your trackpad or mouse button is pressed
	public void mousePressed() {
		
		// the built-in variables, mouseX and mouseY, contain the current
		// location of the mouse
		faceX = mouseX;
		faceY = mouseY;
	}
}
