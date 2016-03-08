import processing.core.PApplet;


public class Pixels extends PApplet{
	public void setup() {
		size(300, 400);
	}
	public void draw() {
		loadPixels();
		for(int row = 0; row < height; row++) {
			for(int col = 0; col < width; col++) {
				int i = row * width + col;
				if (row % 10 == 0) {
					pixels[i] = color(255, 255, 255);
				} else {
					pixels[i] = color(0, 0, 0);
				}
			}
		}
		updatePixels();
	}
}
