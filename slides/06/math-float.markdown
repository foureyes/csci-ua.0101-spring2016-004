---
layout: slides
title: "Math Package Reviewed, Floating Point Arithmetic"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
## Topics

* review Math class functions
* rounding
* max, min and abs
* more about floating point numbers
* "minimizing numeric errors"

</section>

<section markdown="block">
# Name as Many Math Class Functions as You Can &rarr;
</section>

<section markdown="block">
## Generating Random Numbers

__Of course, the one that we probably use the most is the one that we use to generate random numbers.__ &rarr;

* {:.fragment} <code>random()</code> - Generates a random double greater than or equal to 0, but less than 1: <code>0 <= Math.random() < 1</code>
* {:.fragment} __Ok... so how do we generate a random number between a and b (inclusive)... for example, a random number from 1 through 10__ &rarr;
* {:.fragment} <code>(int) (Math.random() * 10 + 1)</code>
* {:.fragment} or... <code>1 + (int) (Math.random() * 10)</code>
* {:.fragment} __in general__, to generate a random number from __a__ to __b__, inclusive, you can use this formula:  <code>a + (int) (Math.random() * b)</code>
* {:.fragment} generates a random number from __a__ to __b__, __without including b__: <code>a + (int)(Math.random() * (b - a))</code>
</section>

<section markdown="block">
## Exponent Functions

__Aaaaand... there's are also a few functions for dealing with exponents.__ &rarr;

* {:.fragment}<code>exp(x)</code> - Returns e raised to power of x.
* {:.fragment}<code>log(x)</code> - Returns the natural logarithm of x. 
* {:.fragment}<code>log10(x)</code> - Returns the base 10 logarithm of x. 
* {:.fragment}<code>sqrt(x)</code> - Returns the square root of x for x > = 0.
* {:.fragment}<code>pow(a, b)</code> - Returns the value of the first argument raised to the power of the second argument.  

</section>

<section markdown="block">
## Trigonometric Functions

__Finally, trig functions (we haven't used these quite yet).__ &rarr;

* {:.fragment}<code>sin(radians)</code> - Returns the trigonometric sine of an angle in radians.
* {:.fragment}<code>cos(radians)</code> - Returns the trigonometric cosine of an angle in radians.
* {:.fragment}<code>tan(radians)</code> - Returns the trigonometric tangent of an angle in radians.
* {:.fragment}<code>toRadians(degree)</code> - Returns the angle in radians for the angle in degree.
* {:.fragment}<code>toDegrees(radians)</code> - Returns the angle in degrees for the angle in radians.
* {:.fragment}<code>asin(a)</code> - Returns the angle in radians for the inverse of sine.
* {:.fragment}<code>acos(a)</code> - Returns the angle in radians for the inverse of cosine.
* {:.fragment}<code>atan(a)</code> - Returns the angle in radians for the inverse of tangent.
</section>

<section markdown="block">
## Rounding Functions

In addition to random number generation, exponent and trig related functions... there are also a few functions that can be used for rounding:

* <code>ceil(x)</code> - x is rounded up to its nearest integer. This integer is returned as a double value.
* <code>floor(x)</code> - x is rounded down to its nearest integer. This integer is returned as a double value. __What is this similar in behavior to?__ &rarr; <span class="fragment">Explicitly casting to an int.</span>
* <code>rint(x)</code> - x is rounded up to its nearest integer. If x is equally close to two integers, the even one is returned as a double value.
* <code>round(x)</code> - Returns (int)Math.floor(x + 0.5) if x is a float and returns (long)Math.floor(x + 0.5) if x is a double.
</section>

<section markdown="block">
## Rounding Functions Examples

__What is the output of this code?__ &rarr;

<pre><code data-trim contenteditable>
System.out.println(Math.floor(2.5));
System.out.println(Math.ceil(2.5));
System.out.println((int) 1.9);
System.out.println(Math.round(10.5));
System.out.println(Math.round(9.5));
System.out.println(Math.rint(2.5));
System.out.println(Math.rint(3.5));
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
2.0
3.0
1
11
10
2.0
4.0
</code></pre>
</section>

<section markdown="block">
## Min, Max and Abs

__And our last batch of methods...__ &rarr;

* __<code>min(a, b)</code>__ - Returns the minimum of two numbers (int, long, float, or double).
* __<code>max(a, b)</code>__ - Returns the maximum of two numbers (int, long, float, or double).
* __<code>abs(a)</code>__ - Returns the absolute value of the number (int, long, float, or double)
</section>

<section markdown="block">
## Min, Max and Abs Examples

__What's the output of the following code?__ &rarr;

<pre><code data-trim contenteditable>
System.out.println(Math.min(2, 3));
System.out.println(Math.min(2, 3.0));
System.out.println(Math.max(2, 3.0));
System.out.println(Math.abs(-1));
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
2
2.0
3.0
1
</code></pre>
</section>

<section markdown="block">
## Floating Point Arithmetic

__What's the output of the following code?__ &rarr;

* <code>System.out.println(0.4 + 0.1);</code> &rarr; <span class="fragment"><code>0.5</code></span>
* <code>System.out.println(0.2 + 0.1);</code> &rarr; <span class="fragment"><code>0.30000000000000004</code></span>
* {:.fragment} __!!!?????__
</section>

<section markdown="block">
## Binary and Floating Point Numbers

From {{site.book}} - __"Calculations involving floating-point numbers are approximated because these numbers are not stored with complete accuracy."__

* __what is 1/3 in decimal__ &rarr;
* {:.fragment} 0.3 repeating  (can't quite be expressed completely... since the three repeats)
* {:.fragment} there are similar numbers for binary ... so there are occasionally rounding errors
* {:.fragment} [More info here](http://floating-point-gui.de/formats/binary/)


{% comment %}
* {:.fragment} __binary can only represent numbers as a finite fraction if the denominator is a power of 2__
	* {:.fragment} 0.5 ... ok!
	* {:.fragment} 0.3 ... uhhhh?
{% endcomment %}

</section>

<section markdown="block">
## Representing Floating Point Literals

__There are actually two different primitive types that represent floating point numbers. What are they?__ &rarr;

* {:.fragment} __float__
* {:.fragment} __double__

<span class="fragment">Hmmmm... so what happens when we have a literal value, like <code>2.3</code> -- is it a float or a double? __Can we run a quick experiment?__ &rarr;</span>

* {:.fragment} <code>double n = 1.2;</code>
* {:.fragment} <code>float n = 1.2;</code>
* {:.fragment} __floating point literals are double by default__
</section>

<section markdown="block">
## float literal

__Ok. So... what if I want an actual float?__ &rarr;

Add an __f__ to the end of your floating point number:

<pre><code data-trim contenteditable>
// I'm a floating point literal!
float n = 1.2f;
</code></pre>

</section>

<section markdown="block">
## Adding Floating Point Numbers With a Loop

__This program adds the numbers from 0.01 to 1 by 0.01.__ __What do you think the result should be... and how does it compare to the actual output?__&rarr;

(Notice we're explicitly using floats)

<pre><code data-trim contenteditable>
// Initialize sum
float sum = 0;

// Add 0.01, 0.02, ..., 0.99, 1 to sum
for (float i = 0.01f; i <= 1.0f; i = i + 0.01f) { 
	sum += i;
}
System.out.println("The sum is " + sum);
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
// (Sum should be 50.50)
The sum is 50.499985 
</code></pre>
</section>

<section markdown="block">
## And Slightly More Accurate

__Is there a way to marginally increase accuracy by playing with types?__ &rarr;

<span class="fragment">Maybe we'll use doubles instead of floats. __What would you expect in terms of accuracy... more or less than using floats?__ &rarr;</span>

<pre class="fragment"><code data-trim contenteditable>
// Initialize sum
double sum = 0;

// Add 0.01, 0.02, ..., 0.99, 1 to sum
for (double i = 0.01; i <= 1.0; i = i + 0.01) { 
	sum += i;
}
// Sum should be 50.50
System.out.println("The sum is " + sum);
</code></pre>


<pre class="fragment"><code data-trim contenteditable>
// yikes! way off!?
The sum is 49.50000000000003
</code></pre>
</section>

<section markdown="block">
## Troubleshooting 

__Why do you think that happened. How could we troubleshoot?__ &rarr;


<span class="fragment">Let's print out the values that it's trying to add. __All the values of i__.</span>

<pre class="fragment"><code data-trim contenteditable>
double sum = 0, i;
for (i = 0.01; i <= 1.0; i = i + 0.01) { 
	sum += i;
	System.out.println(i);
}
// make sure we get that last one!
System.out.println(i);
// should be 50.50
System.out.println("The sum is " + sum);
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
0.9900000000000007
1.0000000000000007
The sum is 49.50000000000003
</code></pre>

<span class="fragment">__What's wrong there?__ &rarr;</span>

</section>

<section markdown="block">
## Counting, Testing

In our previous version, because of a rounding error, the last number actually does not meet the condition for the loop to continue, so 1 is not added!

__We can't rely on adding floating point numbers for our loop increment and condition... how should we change our loop?__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
// let's use ints for the loop
double sum = 0;
double currentValue = 0.01;
for (int count = 0; count < 100; count++) {
	sum += currentValue;
	currentValue += 0.01;
}
System.out.println("The sum is " + sum);
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
// much better
The sum is 50.50000000000003
</code></pre>
</section>

<section markdown="block">
## Biggest to Smallest

Another thing to note... what if we started by adding larger numbers first? __Will the result be more or less accurate than adding smaller numbers first?__ &rarr;

<pre><code data-trim contenteditable>
double sum = 0;
double currentValue = 1.0; // largest value
for (int count = 0; count < 100; count++) { 
	sum += currentValue;
	currentValue -= 0.01; // decrement
}
System.out.println(sum);
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
// maybe less accurate
50.49999999999995
</code></pre>

<span class="fragment">Adding a very small number to a very big number can have no effect if the result requires more precision than the variable can store. __Try this__... &rarr; <code>100000000.0 + 0.000000001</code></span>
</section>

<section markdown="block">
## Dealing with Floating Point Arithmetic

__Numeric errors involving floating-point numbers are inevitable__, because floating-point numbers are represented in approximation in computers by nature.

When working with loops and floating point numbers:

* use doubles for greater accuracy
* use ints for counting and testing conditions to prevent rounding errors that may cause unexpected conditions (such as skipping the last iteration in a loop because of a test that does not pass)
* add small numbers first
</section>

<section markdown="block">
## Want Accuracy?

This behavior is ok for the programs that we write in class. __However...__ &rarr;

* you'll have to use a separate package/class if accuracy is a concern
* [check out BigDecimal](http://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html) for example
* (and [this article on SO as well](http://stackoverflow.com/questions/5257166/java-floats-and-doubles-how-to-avoid-that-0-0-0-1-0-1-0-9000001))
* (which is outside the scope of the material that we cover)
</section>
