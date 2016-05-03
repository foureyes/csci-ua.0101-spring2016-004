import processing.core.PApplet;
import java.util.ArrayList;
import java.util.Random;

public class MyAnimation extends PApplet{
	float mountain_x = 0, mountain_vx = 1, mountain_width = 250;
	float tree_vx = 2, tree_w = 80, tree_h = 140, tree_offset = 70;
	float stripes_x = 0, stripes_dx = 4, stripe_w = 17, stripe_space = 3;
	float sun_vx = 0.04f;
	float horizon;
	Random rng;
	ArrayList<Tree> trees = new ArrayList<Tree>();
	ArrayList<Mountain> mountains = new ArrayList<Mountain>();
	Stripes stripes;
	Car car;
	Sun sun;
	
	public void setup() {
		size(400, 400);
		horizon = height * 2 / 3;
		noStroke();
		rng = new Random();
		stripes = new Stripes(this, 0, horizon + 10, width, 5, stripes_dx, stripe_w, stripe_space);
		car = new Car(this, 0, horizon + 10, width, 5, stripes_dx);
		sun = new Sun(this, width / 8, height / 8, 50, 50, sun_vx);
	}

	public Mountain createMountain() {
		int mountainHeight = randInt(200, 250);
		float mountainY = horizon - mountainHeight;
		int shade = randInt(-20, 20);
		return new Mountain(this, rng.nextInt(width), mountainY, randInt(200, 250), mountainHeight, mountain_vx, shade);
	}
	
	public Tree createTree() {
		int w = randInt(tree_w - 40, tree_w), h = randInt(tree_h - 40, tree_h);
		float x = rng.nextInt(width), y = horizon - h;
		int shade = randInt(-60, 20);
		float vx = tree_vx + rng.nextFloat() / 2;
		return new Tree(this, x, y, w, h, vx, shade);
	}
	
	public int randInt(float a, float b) {
		int range = (int) (b - a);
		return (int) (rng.nextInt(range) + a); 
	}
	
	public void draw() {
		drawBackground(0, 50, horizon);

		sun.render();
		for(Mountain mountain: mountains) {
			mountain.move();
			mountain.render();
		}	
		for(Tree tree: trees) {
			tree.move();
			tree.render();
		}
		stripes.move();
		stripes.render();
		car.move();
		car.render();
		sun.move();
	}
	
	public void drawBackground(int roadOffset, int roadWidth, float horizon) {
		background(150, 180, 250);
				
		// grass
		fill(100, 170, 120);
		rect(0, horizon, width, height / 2);
		
		// road
		fill(150, 150, 150);
		rect(0, horizon + roadOffset, width, roadWidth);
	}

	public void keyPressed() {
		if(key == 't') {
			trees.add(createTree());
		} else if (key == 'm') {
			mountains.add(createMountain());
		}
	}
}

class Sprite {
	float x;
	float y;
	float vx;
	float w;
	float h;
	PApplet _p;
	
	public Sprite(PApplet _p, float x, float y, float w, float h, float vx) {
		this._p = _p;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.vx = vx;
	}
	
	public void move() {
		this.x += this.vx;
		this.x = (this.x > _p.width) ? -w : x;
	}
}

class Tree extends Sprite {
	float trunkWidth;
	float trunkHeight;
	float shade;
	public Tree(PApplet _p, float x, float y, int w, int h, float tree_vx, int shade) {
		super(_p, x, y, w, h, tree_vx);
		this.shade = shade;
		trunkWidth = w / 4;
		trunkHeight = h * 2 / 7;
	}

	public void render() {
		float trunkX = x + ((w - trunkWidth) / 2);
		float trunkY = y + h - trunkHeight;
		_p.fill(77 + shade, 48 + shade, 48 + shade);
		_p.rect(trunkX,  trunkY, trunkWidth, trunkHeight);
		_p.fill(2 + shade, 193 + shade, 32 + shade);
		_p.triangle(x, trunkY, x + w, trunkY, x + w / 2, y);		
	}
}

class Mountain extends Sprite {
	int shade;
	
	public Mountain(PApplet _p, int x, float mountainY, int w, int h, float mountain_vx, int shade) {
		super(_p, x, mountainY, w, h, mountain_vx);
		this.shade = shade;
	}

	public void render() {
		_p.fill(200 + shade, 200 + shade, 200 + shade);
		_p.triangle(x, y + h, x + w, y + h, x + w / 2, y);		
	}
}

class Stripes extends Sprite {
	float stripeWidth;
	float stripeSpace;
	
	public Stripes(PApplet _p, int x, float f, int w, int h, float stripes_dx, float stripe_w, float stripe_space) {
		super(_p, x, f, w, h, stripes_dx);
		this.stripeWidth = stripe_w;
		this.stripeSpace = stripe_space;
	}

	public void render() {
		_p.fill(210, 210, 40);
		for(int stripeNum = 0; stripeNum < (w / (stripeWidth + stripeSpace)) * 2; stripeNum++) {
			_p.rect(stripeNum * (stripeWidth + stripeSpace) + (x - w), y, 10, h);
		}
	}
	
	@Override
	public void move() {
		this.x += this.vx;
		this.x = (this.x > _p.width) ? 0 : x;
	}	
}

class Sun extends Sprite {

	public Sun(PApplet _p, float x, float y, float w, float h, float vx) {
		super(_p, x, y, w, h, vx);
	}
	
	public void render() {
		_p.fill(220, 200, 20);
		_p.ellipse(x, y, w, h);
	}
}

class Car extends Sprite {
	public Car(PApplet _p, int x, float f, int w, int h, float stripes_dx) {
		super(_p, x, f, w, h, stripes_dx);
	}

	public void render() {
		int carWidth = 70, carHeight = 25, horizonOffset = 5, wheelSize = 20;
		_p.fill(250, 250, 10);
		// bottom of car
		_p.rect(_p.width / 2 - carWidth / 2, y - carHeight - horizonOffset, 
				carWidth, carHeight);
		
		// top of car
		_p.rect(_p.width / 2 - carWidth / 2 + carWidth / 8, y - carHeight * 2, 
				(int) (carWidth * 0.75), carHeight);
		
		// window
		_p.fill(200, 220, 255);
		_p.rect(_p.width / 2 - carWidth / 2 + carWidth / 8 + 2, 
				y - carHeight * 2 + 2, (int) (carWidth * 0.25), 
				carHeight - horizonOffset - 4);		
		
		// wheels
		_p.fill(0, 0, 0);		
		_p.ellipse(_p.width / 2 - carWidth / 2 + 3 * carWidth / 16, 
				y - horizonOffset, wheelSize, wheelSize);
		_p.ellipse(_p.width / 2 - carWidth / 2 + 13 * carWidth / 16, 
				y - horizonOffset, wheelSize, wheelSize);
	}
	
}




