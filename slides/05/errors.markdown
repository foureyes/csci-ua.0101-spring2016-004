---
layout: slides
title: "Common Errors"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
## A Quick Review on Syntax

What is the syntax for the following?

* a one-way __if__ statement
* a two-way __if-else__ statement
* a multi-way __if-else-if__ statement
</section>

<section markdown="block">
## If, If-Else, If-Else-If

Syntax...

<pre class="fragment"><code data-trim contenteditable>
if (booleanExpression) {
	// do stuff
}
</code></pre>
<pre class="fragment"><code data-trim contenteditable>
if (booleanExpression) {
	// do stuff
} else {
	// do other stuff	
}
</code></pre>
<pre class="fragment"><code data-trim contenteditable>
if (booleanExpression) {
	// do stuff
} else if (booleanExpression) {
	// do other stuff	
} else {
	// do other other stuff	
}

</code></pre>
</section>

<section markdown="block">
# And Mistakes Were Made

</section>
<section markdown="block">
## Common Errors

__Here are a bunch of common errors... the first one is obvious, but let's take a close look at the others__ &rarr;

* unbalanced curly braces
* misplaced semicolon
* redundant testing of boolean values
* dangling else (... hey, just use curly braces, ok?)
* simplifying boolean variable assignment
* avoiding duplicate code in branches
</section>

<section markdown="block">
## Have a Curly Brace? No Semicolon Needed!

Don't do this...

<pre><code data-trim contenteditable>
if (x == 5) {
	print("It's five!");
};

// you don't need the semicolon after the last curl brace!
</code></pre>
</section>

<section markdown="block">
## Redundant Testing of Boolean Values

__How can we make this code more concise (specifically regarding the condition)?__ &rarr;

<pre><code data-trim contenteditable>
boolean go = true;
// some other stuff happens
if (go == true) {
	print("We're going!");
}
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
boolean go = true;
// hey... go is already a boolean; no need to compare if equal to true! 
if (go) {
	print("We're going!");
}

</code></pre>

</section>

<section markdown="block">
## Dangling Else	

So... you can drop curly braces. Totally valid syntax.

__However... this is a bit ambiguous.__

__JUST. USE. CURLY BRACES.__
<pre><code data-trim contenteditable>
if (x == 5) 
	if (x < 20) 
		System.out.println("here");
else		
	System.out.println("not there!");
</code></pre>

</section>

<section markdown="block">
## Simplifying Boolean Variable Assignment 

__There's a one line equivalent to creating the boolean variable below.__ &rarr;

<pre><code data-trim contenteditable>
boolean even;
if (x % 2 == 0) {
	even = true;
} else {
	even = false;
}
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
boolean even = x % 2 == 0;
</code></pre>

</section>

<section markdown="block">
## Duplicate Code

<pre><code data-trim contenteditable>
if (numericGrade > 60) {
	status = "pass"
	System.out.println(status);
} else {
	status = "fail"
	System.out.println(status);
}
</code></pre>

Hm... so. That looks redundant. Probably better to just move that out of the if-else (a bit contrived, yes).

<pre><code data-trim contenteditable>
if (numericGrade > 60) {
	status = "pass"
	System.out.println(status);
} else {
	status = "fail"
}
System.out.println(status);
</code></pre>
</section>

