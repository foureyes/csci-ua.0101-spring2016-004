import processing.core.PApplet;


public class TruchetMethod extends PApplet{
	public void setup() {
		background(255, 255, 255);
		size(400, 400);
	}
	public void draw() {
		int size = 40;
		for(int x = 0; x <= 150; x += 50) {
			int rot = x / 50;
			drawTile(x, 0, size, rot);
		}
		for(int x = 0; x <= 150; x += 50) {
			int rot = x / 50;
			fill(255, 255, 255);
			rect(x, 100, size, size);		
			drawTile(x, 100, size, rot);
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
