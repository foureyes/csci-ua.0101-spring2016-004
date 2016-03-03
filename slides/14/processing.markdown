---
layout: slides
title: "Processing"
---

<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
## Processing

* graphics / drawing library
* [https://processing.org/](https://processing.org/)
* _actually_ an _Applet_

</section>
<section markdown="block">
## Starting Out

"Extend PApplet".

<pre><code data-trim contenteditable>
import processing.core.*; 

public class ProcessingDemo extends PApplet {
	// some methods go here
}
</code></pre>


{% comment %}*{% endcomment %}
</section>

<section markdown="block">
## Main Methods

<pre><code data-trim contenteditable>
public void setup() {
	// run once
}

public void draw() {
	// loops forever after setup!
}
</code></pre>
</section>

<section markdown="block">
## A Whole Example

<pre><code data-trim contenteditable>
import processing.core.*;
public class ProcessingAgain extends PApplet {

		public void setup() {
				System.out.println("once");
		}

		public void draw() {
				System.out.println("multiple times");
		}
}
</code></pre>

{% comment %}*{% endcomment %}
</section>

<section markdown="block">
## Drawing Environment

<pre><code data-trim contenteditable>
// set background color
background(255, 0, 0);

// dimensions
size(200, 100);

// width and height
width
height
</code></pre>
</section>

<section markdown="block">
##  Shapes / Lines

<pre><code data-trim contenteditable>
// x, y, width, height
rect(30, 20, 55, 55);

// x, y, width, height
ellipse(56, 46, 55, 55);

// x1, y1, x2, y2
line(30, 20, 85, 75);
</code></pre>
</section>

<section markdown="block">
## Mouse

<pre><code data-trim contenteditable>
// define this to trigger a callback / event handler
void mouseClicked()

// x and y coordinates of the mouse
mouseX
mouseY
</code></pre>

</section>

<section markdown="block">
##  Keyboard

<pre><code data-trim contenteditable>
// define this function to be called on key press
// keyCode is a built in variable that you can use 
// to see what key was pressed
// there are constants for arrow keys...
void keyPressed() {
    if (keyCode == UP) {
        System.out.println("up!");
    }
}
</code></pre>
</section>


<section markdown="block">
## An Aside on Instance Variables

__Has anyone tried defining variables outside of main?__ &rarr;
<pre><code data-trim contenteditable>

class Foo() {
	int bar;
}
</code></pre>

Your methods can access that variable. We'll talk more about those kinds of variables (instance variables) after break.

</section>
<section markdown="block">
## Some Exercises

* animation?
* move with keyboard?
* a grid of squares (clicking and maintaining state)?
</section>
