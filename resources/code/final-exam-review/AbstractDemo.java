import java.util.ArrayList;
import processing.core.PApplet;

// an abstract class is a class that you can't instantiate with the keyword new
// an abstract class can define "abstract methods"
// ...which are methods with no bodies (no {}'s)




// create an animation
// creates a face
// and a house
// and a class will represent both
public class AbstractDemo extends PApplet {
	
	ArrayList<Thingy> things = new ArrayList<Thingy>();
	
	public static void main(String[] args) {
		PApplet.main("AbstractDemo");
	}
	
	public void setup() {
		size(500, 500);
		//Thingy t = new Thingy();
		things.add(new MyFace(this, 200, 200, 1));
		things.add(new Square(this, 0, 50, 2));
	}
	public void draw() {
		background(0);
		for(Thingy t: things) {
			t.render();
			t.move();
		}
	}
}

abstract class Thingy {
	int x;
	int y;
	int dx;
	PApplet canvas;
	
	protected Thingy(PApplet canvas, int x, int y, int dx) {
		this.canvas = canvas; // our drawing tools
		this.x = x;
		this.y = y;
		this.dx = dx; // velocity
	}
	
	public abstract void render();
	
	public void move() {
		// changing x value based on velocity
		this.x += this.dx;
		// loop around to other side if beyond right side of canvas
		if(this.x >= this.canvas.width) {
			this.x = 0;
		}
	}
}
/*
class House extends Thingy {
	public House(PApplet canvas, int x, int y, int dx) {
		super(canvas, x, y, dx);
	}
	
}*/

class MyFace extends Thingy {
	int diameter = 100;
	
	public MyFace(PApplet canvas, int x, int y, int dx) {
		super(canvas, x, y, dx);
	}
	
	public void render() {
		// drawing the actual face
		this.canvas.fill(255);
		this.canvas.ellipse(this.x, this.y, this.diameter, this.diameter);
		
		// drawing the eyes
		this.canvas.fill(0);
		this.canvas.ellipse(this.x + 10, this.y - 20, this.diameter / 10, this.diameter / 10);
		this.canvas.ellipse(this.x - 20, this.y - 20, this.diameter / 10, this.diameter / 10);
	}	
}


class Square extends Thingy{

	public Square(PApplet canvas, int x, int y, int dx) {
		super(canvas, x, y, dx);
	}
	
	public void render() {
		// drawing the actual face
		this.canvas.fill(255);
		this.canvas.rect(this.x, this.y, 100, 100);
	}
	
	@Override
	public void move() {
		this.x -= this.dx;
	}
}





