---
layout: homework
title: "Robot Factory"
---
# Robot Factory 

<pre><code data-trim contenteditable>                                    _________ 
                                   /        /|
                              .   /________/ |     
                               \  | _   _  | |   .
                                \_|   ‿    | __./
                                  |________| |
                                  |===   . | |
                                  | +  o  0| /
                                  |________|/
                                    ||   ||
                                    -     -
</code></pre>

## Activity

* Check out the <code>RobotFactory</code> code below
* It makes a couple of objects, but the class that specifies those objects is not defined
* Soooo...
* __Create a class...__ &rarr;
	* That's a appropriately named
	* And has the methods and variables (both static and instance) that are used in the code below

## Code

<a>Reveal</a>

<pre><code data-trim contenteditable>public class RobotFactory {
  public static void main(String[] args) {
    // make our first robot, BMO
    Robot bmo = new Robot("BMO");
    System.out.println(bmo.counter); // prints out 1
    System.out.println(bmo.getId()); // prints out 1
    System.out.println(bmo.getName()); // prints out "BMO"
    System.out.println(Robot.defaultRobotSound); // prints out "Beep"
    Robot.makeSound(); // prints out "Beep"
    
    // make our second robot, N.E.P.T.R.
    Robot neptr = new Robot("N.E.P.T.R.");
    System.out.println(neptr.counter); // prints out 2
    System.out.println(neptr.getId()); // prints out 2
    System.out.println(neptr.getName()); // prints out "N.E.P.T.R"
    System.out.println(Robot.defaultRobotSound); // prints out "Beep"
    Robot.makeSound(); // prints out "Beep"  
    
    // print out some stuff about BMO again to see what changed
    // counter has increased!
    System.out.println(bmo.counter); // prints out 2
    // note that id stays the same
    System.out.println(bmo.getId()); // prints out 1
    // name also stays the same
    System.out.println(bmo.getName()); // prints out "BMO"
  }
}
</code></pre>

## Solution

<a href="#" id="solution-button">Toggle solution</a>

<pre id="robot-solution" class="hidden"><code data-trim contenteditable>public class Robot {
	public static int counter = 0;
	public static String defaultRobotSound = "Beep";
	private int id;
	private String name;
	
	public Robot(String name) {
		this.name = name;
		id = ++counter;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public static void makeSound() {
		System.out.println(defaultRobotSound);
	}
}
</code></pre>

<script>
document.addEventListener("DOMContentLoaded", init);

function init() {
	console.log("loaded");
	document.getElementById('solution-button').addEventListener('click', function(evt) {
	console.log("toggled");
		var solution = document.getElementById('robot-solution')
		solution.classList.toggle("hidden");
		solution.scrollIntoView();
		evt.preventDefault();
	});
}
</script>
