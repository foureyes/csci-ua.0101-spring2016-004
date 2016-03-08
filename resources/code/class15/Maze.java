import processing.core.PApplet;


public class Maze extends PApplet{
	int cols = 20, rows = 20;
	public void setup() {
		background(255, 255, 255);
		size(400, 400);
		drawPattern();
	}
	public void draw() {

	}
	public void drawPattern() {
		background(255, 255, 255);
		for(int y = 0; y < height; y += height / rows) {
			for(int x = 0; x < width; x += width / cols) {
				drawTile(x, y, height / rows, (int) (Math.random() * 2));
			}
		}		
	}
	public void drawTile(int x, int y, int size, int rotation) {
		fill(0, 0, 0);
		strokeWeight(10);
		switch(rotation) {
		case 0:
			line(x, y + size, x + size, y);
			break;
		case 1:
			line(x, y, x + size, y + size);
			break;
		}
	}
	
	public void mousePressed() {
		drawPattern();		
	}
}
