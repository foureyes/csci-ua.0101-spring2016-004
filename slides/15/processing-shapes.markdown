---
layout: slides
title: "Processing - Drawing, Animation, Images"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
## Built-In Java Classes

__What are some built-in Classes that we know?__ &rarr;

* {:.fragment} String
* {:.fragment} Character
* {:.fragment} Scanner
* {:.fragment} etc.

<span class="fragment">They're all part of Java's API. They're all available in our programs (though perhaps with an import statement).</span>
</section>
<section markdown="block">
## External / 3rd Party Libraries

Sometimes, we need more than just Java's _core libraries_. Although Java's API is pretty comprehensive, it doesn't cover _everything_. For example, we may find Java's core libraries aren't quite adequate for: 

* {:.fragment} building dynamic, data-driven web sites
* {:.fragment} an android app
* {:.fragment} ...or a tiny desktop game
</section>

<section markdown="block">
## External / 3rd Party Libraries

That's where __3rd Party__ or __external__ libraries come in! They're a bunch of pre-written code that provides us with tools and solutions for some specific programming tasks (that are either not present in the core Java API, or may be tedious or difficult to implement from scratch).

__Processing__ is an example of a useful external library. It gives us an easy way to integrate graphics and interaction into our programs!

The steps for adding an external library are generally the same:

1. download the library and include it in your Java project
2. make sure it's available in your __build-path__ (that is, when you compile your program, javac knows where to find it)
3. add any necessary imports to your code
</section>

<section markdown="block">
# Please Follow Along!

### (Start a new Eclipse Project)
</section>

<section markdown="block">
## (Some Things You May Want to Download)

* [core.jar](../../resources/jars/core.jar)
* [wallaby](../../resources/img/wallaby.jpg)
* [apples](../../resources/img/apples-small.jpg)
</section>

<section markdown="block">
## Including External Libraries

If you're using Eclipse (which we are!), then the _actual_ process __is something like this (let's try it together)...__ &rarr;

* {:.fragment} download the library (of course)
* {:.fragment} select a project in your project navigator
* {:.fragment} go to File &rarr; Import, 
* {:.fragment} then choose File System... then Browse to search for the folder containing the library
* {:.fragment} check the appropriate boxes to import
* {:.fragment} ... when finished, right click on the library in the project navigator
* {:.fragment} ... and Build &rarr; Add to Build Path
* {:.fragment} finally, use <code>import</code> statements in your program to use the library

</section>

<section markdown="block">
## Java Archive

__What was the extension of the library that we imported?__ &rarr;

<span class="fragment">It was a <code>.jar</code> file.</span>

<span class="fragment">A __jar__ file is:</span> 

* {:.fragment} a compressed file that...
* {:.fragment} includes all of the classes (actual <code>.class</code> files) 
* {:.fragment} and resources (such as images, fonts) that are part of a program or library

<span class="fragment"><code>.jar</code> files are typically used to package and distribute Java programs in a convenient, single file
</span>

<span class="fragment">__Let's prove this is true by uncompressing a jar file.__ &rarr;</span>
<span class="fragment">__(Oh, also, what are all of those <code>.class</code> files for again?__ &rarr;</span>
</section>

<section markdown="block">
## Processing

Now, back to __Processing__.  

* __core.jar__ contains all of the Processing related classes that use in our actual program
* when we add it to our program, we can use all of those classes (such as <code>PApplet</code>)
* Processing was originally intended for creating __applets__, which are basically small Java programs that are run from your web browser
* (that's why we add <code>extends PApplet</code> to our code to create a Processing application)

</section>
<section markdown="block">
## Applets

Again, an __applet__ is __small Java application__:

* it's different from regular Java programs in that it does not need a __main__ method to run
* instead, there are different special methods that you can implement that are invoked/called automatically when a Java applet is loaded (for example, by a plugin in your browser):
	* <code>init</code> - called when an applet is initially loaded
	* <code>start</code> - the first method called after the applet is loaded
	* ...and others, such as <code>stop</code>, <code>destroy</code>, etc.
* we don't have to run applets from the browser (in fact, finding an applet on the web is kind of rare these days!)
* we can run (and, of course, compile) them directly from Eclipse
</section>

<section markdown="block">
## Hey Wait

If Processing programs are applets, __why don't we have to implement <code>init</code>, <code>init</code>, or any of those other methods (what does it imply about the processing library)?__ &rarr;

* {:.fragment} Processing implements those methods for us, and instead, gives us a different API to work with.</span>
* {:.fragment} How can we tell? We can just check out the [source code for PApplet](https://github.com/processing/processing/blob/master/core/src/processing/core/PApplet.java#L749)
* {:.fragment} (__Why couldn't we just uncompress <code>core.jar</code> to see the source code?__ &rarr;)

</section>

<section markdown="block">
## Setting Up a Processing Sketch

After importing <code>core.jar</code> to a project and adding it to the __build path__, __what are the steps for starting a Processing application?__ &rarr;

1. {:.fragment} <code>import processing.core.PApplet;</code>
2. {:.fragment} extend your class definition by adding <code>extends PApplet</code>
3. {:.fragment} optionally implement either of the two methods (both methods are automatically called - __when are they called and how frequently?)__ &rarr;
	* {:.fragment} <code>public void setup</code> <span class="fragment">(called once when the program starts)</span>
	* {:.fragment} <code>public void draw</code> <span class="fragment">(called repeatedly)</span>

</section>

<section markdown="block">
## Was There Something Missing?

__Let's try dropping those methods in a program. Do you see anything there that's different from how we usually declare methods?__  &rarr;

<pre><code data-trim contenteditable>
public void setup() {
}
public void draw() {
}
</code></pre>

<span class="fragment">They're not <code>static</code>! ... We'll see why in next week's class. For now, however, drop the keyword <code>static</code> for these methods</span>

<span class="fragment">In fact, you shouldn't use <code>static</code> in __any__ of your method definitions for our first processing programs.</span>

</section>

<section markdown="block" data-background="#440000">
# In our first Processing sketches, don't use static in any of your method definitions. (We'll see why next week).

</section>

<section markdown="block">
## Processing Documentation

For a full reference, check out the Processing site:

[Processing Reference](https://processing.org/reference/)

* however, the reference was designed for use in a simplified IDE 
* the Processing IDE hides away and simplifies Java through its interface
* consequently, in the docs, you may see some things missing (for example, <code>public</code> is missing from setup)
* additionally, some types may not actually exist (for example, <code>color</code> is not actually a type, it's just an <code>int</code>)

</section>

<section markdown="block">
## Your Canvas!

You can modify and access attributes of your applet's window by using the following Processing methods and variables:

* <code>background(r, g, b) // or just background(n) for grayscale</code>
* <code>size(width, height) // window dimensions</code>
* <code>width // width of window</code>
* <code>height // height of window</code>

Note that...

* size is usually only called once in the setup method
* background can be called in setup...
* but, if you want to "repaint" the background each time draw is called, you can use it there as well
* __why would you want to do that?__ &rarr;

__Let's try these.__ &rarr;
</section>

<section markdown="block">
## Drawing Shapes

Some methods for drawing shapes:

* <code>ellipse(x, y, width, height)</code>
* <code>triangle(x1, y1, x2, y2, x3, y3)</code>
* <code>stroke() // all subsequent shapes have an outline</code>
* <code>noStroke() // all subsequent shapes don't have an outline</code>
* <code>strokeWeight(width) // set line and outline width</code>
* <code>line(x1, y1, x2, y2)</code>
* <code>fill(r, g, b) // or fill(n) ... all subsequent shapes are filled in with color</code>

__Let's try a few of these.__ &rarr;
</section>

<section markdown="block">
## How About Shapes That Occupy the Same Space?

What happens if we draw two shapes over each other (can they overlap)? __Let's try it out. Describe what happens.__ &rarr;

* {:.fragment} shapes can overlap
* {:.fragment} however, the last shape drawn is rendered over all of the other previous shapes
</section>

<section markdown="block">
## Fill, Background

Both fill and background have 1, 3, and 4 parameter versions:

* with 3 parameters, the colors represent red, green, and blue, each with a value from 0 through 255
	* red: 255, 0, 0
	* yellow: 255, 255, 0
	* want dark blue: 10, 10, 70
* the 4 parameter version's last parameter is alpha (or opacity):
	* also 0-255
	* example: <code>fill(40, 200, 40, 180);</code>
* with 1 parameter, it represents grayscale
</section>

<section markdown="block">
## Instance Variables

You can create variables within your class, but outside of your main (or other) methods. When defined without the keyword <code>static</code>, these variables are called __instance variables__.

* they're available to all of your methods
* they're kind of like _globals_ but for you class
* __let's try an example__ &rarr;

</section>


<section markdown="block">
## Drawing a Crescent Moon

__Draw this:__ &rarr;

<div markdown="block" class="img">
![alt](../../resources/img/crescent.png)
</div>
</section>

<section markdown="block">
## Animated... and Loop Back

__Now try animating it:__ &rarr;

<div markdown="block" class="img">
![alt](../../resources/img/crescent-animation.gif)
</div>
</section>

<section markdown="block">
## Perhaps a Method?

Starting with a <code>drawCrescent</code> method would be good!

<pre><code data-trim contenteditable>
public void drawCrescent(int x, int y, int offset, int size) {
  fill(255);
  ellipse(x, y, size, size);
  fill(0, 0, 0);
  ellipse(x + offset, y - offset, size, size);
}
</code></pre>
</section>

<section markdown="block">
## And Using drawCrescent

<pre><code data-trim contenteditable>
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
</code></pre>
</section>

<section markdown="block">
## A Minor Change...

__In our drawCrescent method, what if we changed:__ &rarr;

<pre><code data-trim contenteditable>
  fill(0, 0, 0);
</code></pre>

to 

<pre><code data-trim contenteditable>
  fill(0, 0, 0, 180);
</code></pre>

<span class="fragment">The second circle would not be entirely black, as it's partially transparent.</span>
</section>

<section markdown="block">
## Mouse Stuffs

A quick aside on interaction:

* <code>mouseX</code> represents the current x coordinate of the mouse cursor
* <code>mouseY</code> represents the current y coordinate of the mouse cursor
* create a method called <code>mousePressed</code> if you want a method to be called everytime the user presses a button



</section>
<section markdown="block">
## Try This Simple Mouse Exercise

__Let's do this together.__ &rarr;

* clicking on left side of screen draws rectangles where the cursor is
* clicking on right side of screen draws ellipses where the cursor is
</section>

<section markdown="block">
## Truchet Tiles

Tiles that are decorated with patterns that are not symmetric when rotated.

[Check out the wikipedia article](http://en.wikipedia.org/wiki/Truchet_tiles)

* the black triangle version... has four distinct possible rotations
* you can create various patterns by mixing rotations
</section>

<section markdown="block">
## A Method to Draw a Tile

__Write a method to draw a Truchet tile:__ &rarr;

* it should have x and y as parameters (where the upper left corner of the tile is)
* it should have a size parameter (the width of the tile)
* it should have a rotation parameter (to determine which permutation of the tile to draw)
* it will draw a single black triangle

Call the method a few times to try it out.
</section>


<section markdown="block">
## Example Truchet Tile Method Calls

(note, the second row is to show the upper corner, there shouldn't be any outlines in the actual method)

<div markdown="block" class="img">
![alt](../../resources/img/truchet-method.png)
</div>
</section>

<section markdown="block">
## drawTile

<pre><code data-trim contenteditable>
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
</code></pre>


</section>

<section markdown="block">
## How About Tiling the Tiles

Now... __use your drawTile method to create any of these patterns!__ &rarr;

<div markdown="block" class="img">
![alt](../../resources/img/truchet.gif)
</div>
</section>


<section markdown="block">
## A Possible Implementation

Sooo... this one lets us cycle through the patterns (though counter may overflow!).

<pre><code data-trim contenteditable>
int cols = 20, rows = 20, counter = 0;
public void setup() {
  background(255, 255, 255);
  size(400, 400);
  drawPattern();
}
public void drawPattern() {
  background(255, 255, 255);
  for(int y = 0; y < height; y += height / rows) {
    for(int x = 0; x < width; x += width / cols) {
      drawTile(x, y, height / rows, counter % 4);
    }
  }    
}

public void mousePressed() {
  counter++;
  drawPattern();    
}
</code></pre>
</section>

<section markdown="block">
## And Finally... Random

(again, you don't have to implement click - just make sure to get the random pattern first!)

<div markdown="block" class="img">
![alt](../../resources/img/truchet-random.gif)
</div>
</section>

<section markdown="block">
## Another Truchet Tile

You can create Truchet tiles with a single line diagonal on a tile. __How many unique rotations would there be for this kind of tyle?__ &rarr;

<span class="fragment">Only 2!</span>

</section>

<section markdown="block">
## A Maze

Modify your previous random Truchet Tiling program to create the following:

<div markdown="block" class="img">
![alt](../../resources/img/maze-1.png)
</div>

</section>

<section markdown="block">
## Maybe Another Maze?

<div markdown="block" class="img">
![alt](../../resources/img/maze-2.png)
</div>
</section>

<section markdown="block">
## Working With Pixels

You can actually edit each pixel of the window!

(these methods and variables are all part of processing)

1. <code>loadPixels()</code>
2. use <code>pixels[] // an int array of colors </code>
3. <code>color(r, g, b) // gives back an int representation of a color</code>
4. <code>updatePixels();</code>
</section>

<section markdown="block">
## Um. An Array of Pixels?

Wait... how does a single array of pixels represent a two-dimensional window?

* {:.fragment} each row is represented end-to-end in the single array
* {:.fragment} sooo... pixels / height = rows

</section>

<section markdown="block">
## Lines From Pixels

__Let's try drawing this.__ &rarr;

<div markdown="block" class="img">
![alt](../../resources/img/pixels.png)
</div>

</section>
<section markdown="block">
## Lines from Pixels

<pre><code data-trim contenteditable>

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

</code></pre>

</section>

{% comment %}
<section markdown="block">
## 

<div markdown="block" class="img">
![alt](../../resources/img/black-and-white.png)
</div>
<div markdown="block" class="img">
![alt](../../resources/img/edge.png)
</div>
<div markdown="block" class="img">
![alt](../../resources/img/processing-image.png)
</div>
<div markdown="block" class="img">
![alt](../../resources/img/red.png)
</div>
<div markdown="block" class="img">
![alt](../../resources/img/static-color.gif)
</div>
<div markdown="block" class="img">
![alt](../../resources/img/static-gray.gif)
</div>
<div markdown="block" class="img">
![alt](../../resources/img/truchet-rotate.gif)
</div>
</section>


<section markdown="block">
## 

* create new class file
* import <code>PApplet</code>
* extend you class as usual
* import <code>PImage</code>
* create a global <code>PImage</code> variable
* load in setup by using <code>loadImage</code>


</section>
<section markdown="block">
## 

what is it? /data folder?
eclipse wants to manage all your jamz.

So, just let it. Life will be easier.

But just so you know
1. right click source folder &rarr; new &rarr; other ... choose folder
2. in finder or in explorer, copy image to data folder
3. right click on data folder... refresh
4. build
5. if build doesn't work, clean
If you copy stuff in through the finder, eclipse doesn't "realize" you did so. The data/ folder should be created throught the eclipse "Package Explorer" under the src/ folder. Eclipse will then create bin/data/. 

If you want to add and image you will have to make sure it can be seen in the src folder. Add it through eclipse or refresh the folder. If it still does not appear select project->clean in the menu. This will delete your bin/ directory and recreate it from src/.

</section>

<section markdown="block">
## 
Data structure that represents images

</section>

<section markdown="block">
## 

* window pixels represented as a single array
* __how__ &rarr;
loadPixels
* represents pixels in window
updatePixels
* updates the pixels in window
pixels[]
color

</section>
{% endcomment %}
