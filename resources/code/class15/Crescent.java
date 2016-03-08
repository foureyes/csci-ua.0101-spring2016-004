import processing.core.PApplet;

public class Crescent extends PApplet{
int moonX, moonY, moonSize;
public void setup() {
	size(400, 400);
	moonX = width / 2;
	moonY = height / 2;
	moonSize = 100;
}

public void draw() {
	background(0);
	drawCrescent(moonX, moonY, 20, moonSize);
	moonY += 2;
	if (moonY > height + moonSize / 2) {
		moonY = 0 - moonSize / 2;
	}
}

public void drawCrescent(int x, int y, int offset, int size) {
	fill(255);
	ellipse(x, y, size, size);
	fill(0, 0, 0);
	ellipse(x + offset, y - offset, size, size);
}
	
}
