import java.util.Arrays;


public class InterfaceDemo {
	public static void main(String[] args) {
		//int[] numbers = {7, 1, 5, 2, 99, 30};
		//Arrays.sort(numbers);
		//System.out.println(Arrays.toString(numbers));
		Rectangle[] rs = {new Rectangle(2, 10), new Rectangle(3, 3), new Rectangle(1, 2)};
		Arrays.sort(rs);
		System.out.println(Arrays.toString(rs));
	}
}
/*
public interface Comparable {
	abstract compareTo(Object o);
}*/


class Rectangle implements Comparable {
	int w;
	int h;
	
	public Rectangle(int w, int h) {
		this.w = w;
		this.h = h;
	}
	
	public int getArea() {
		return this.w * this.h;
	}
	
	public String toString() {
		return this.w + " x " + this.h;
	}
	
	
	// we have implement compareTo because
	// we said we would (implements Comparable)
	// the signature is
	// it returns an int (less than 0 if this object is less than the other object)
	// ...greater than 0 if this object is greater than other object
	// if both are equal return 0
	public int compareTo(Object other) {
		Rectangle o = (Rectangle) other;
		if(this.getArea() > o.getArea()) {
			return 1;
		} else if (this.getArea() < o.getArea()) {
			return -1;
		} else {
			return 0;
		}
	}
}



