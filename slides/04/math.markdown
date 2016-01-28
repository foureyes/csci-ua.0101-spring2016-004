---
layout: slides
title: "Math Class, Random"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
## Math Class

* Java's <code>Math</code> class contains a collection of math related functions
* the <code>Math</code> class is available without having to import anything
* we already saw one method in the math class... __what was it?__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
Math.pow(base, exponent);
</code></pre>
</section>
<section markdown="block">
## Math Methods and Constants

You can find a list of methods in the first part of chapter for in the book...

Or you can just start typing <code>Math</code> in Eclipse.

__Some examples of methods include:__

* <code>Math.sqrt(x)</code>
* <code>Math.sin(radians)</code>
* <code>Math.cos(radians)</code>
* <code>Math.log(x)</code>
* <code>Math.random()</code>

__Some constants include:__

* <code>Math.E</code>
* <code>Math.PI</code>

</section>

<section markdown="block">
## Let's Check out Math.random

<code>Math.random()</code> will return a positive _double_ greater than or equal to 0... and less than 1.

</section>

<section markdown="block">
## Simulating Dice Rolls

__How might we use random to simulate rolling two six sided dice?__ &rarr;

<pre><code data-trim contenteditable>
double roll1 = (int) (Math.random() * 6 + 1);
double roll2 = (int) (Math.random() * 6 + 1);
System.out.println(roll1 + roll2);
</code></pre>
</section>

