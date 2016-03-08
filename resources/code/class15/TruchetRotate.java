import processing.core.PApplet;


public class TruchetRotate extends PApplet{
	int cols = 20, rows = 20, counter = 0;
	public void setup() {
		background(255, 255, 255);
		size(400, 400);
		
	}
	public void draw() {
		drawPattern();
	}
	public void drawPattern() {
		background(255, 255, 255);
		for(int y = 0; y < height; y += height / rows) {
			for(int x = 0; x < width; x += width / cols) {
				drawTile(x, y, height / rows, counter % 4);
				counter += 1;	
			}
		
		}		
	}
	public void drawTile(int x, int y, int size, int rotation) {
		fill(0, 0, 0);
		switch(rotation) {
		case 0:
			triangle(x, y + size, x + size, y + size, x + size, y);
			break;
		case 1:
			triangle(x, y + size, x + size, y + size, x, y);
			break;
		case 2:
			triangle(x, y + size, x + size, y, x, y);
			break;
		case 3:
			triangle(x, y, x + size, y + size, x + size, y);
			break;

		}
	}
}
