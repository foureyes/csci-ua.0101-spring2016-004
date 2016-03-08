import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import processing.core.PApplet;

/**
 * This program reads in a file, and then draws
 * ellipses based on the data in the file.
 * 
 * Note that the default path for files in Processing 
 * programs is projectDirectory/bin (rather than 
 * just projectDirectory)
 */
public class DrawFromFile extends PApplet {
	public void setup() {
		size(500,500);
		File f = new File("snowman.txt");
		System.out.println(f.getAbsolutePath());
		try {
			Scanner in = new Scanner(f);
			while(in.hasNext()) {
				String line = in.nextLine();
				String[] parts = line.split(":");
				String[] coords = parts[1].split(",");
				try {
					Circle c = new Circle(this,
							Integer.parseInt(coords[0]), 
							Integer.parseInt(coords[1]),
							Integer.parseInt(parts[0]));
					c.render();
				} catch (Exception e) {
					System.out.println("Error, skipping line");
				}
			}
		} catch (IOException ioe) {
			System.out.println("Couldn't load file");
		}
	}
}

class Circle {
	float x;
	float y;
	float radius;
	PApplet _p;
	Circle(PApplet p, float x, float y, float radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this._p = p;
	}
	public void render() {
		_p.fill(0);
		_p.noStroke();
		_p.ellipse(x, y, radius * 2, radius * 2);
	}
}