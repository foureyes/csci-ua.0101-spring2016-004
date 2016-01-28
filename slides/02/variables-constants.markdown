---
layout: slides
title: "Variables and Constants"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
## statically typed vs dynamically typed

When we describe various languages, sometimes we use the terms __statically typed__ and __dynamically typed__

* __statically typed__ means that the type of the variable is known at compile time 
	* this usually means that you must specify what type each variable is
	* (which is true of Java)
* __dynamically typed__ means that the type of a variable is determined when the program is running
	* this usually means that you don't have to specify type beforehand
	* (which is what you're used to in Python!)
</section>

<section markdown="block">
## declaring a variable


Creating a new variable name:

<pre><code data-trim contenteditable>
type variableName;
</code></pre>

For example... creating a variable that's an int (which reserves that amount of space in memory)

<pre><code data-trim contenteditable>
int foo;
</code></pre>

Creating a variable and initializing to a value

<pre><code data-trim contenteditable>
int foo = 200;
</code></pre>

</section>

<section markdown="block">
## Uninitialized Variables

If you leave a variable uninitialized (that is you don't immediately assign to a value or do so later)...

<pre><code data-trim contenteditable>
int foo;
System.out.println(foo);
</code></pre>

Your program won't even compile!
</section>

<section markdown="block">
## multiple declarations

You can also declare multiple variables on a single line:

<pre><code data-trim contenteditable>
type variableName1 = value1, variableName2 = value2 ...;
</code></pre>

<pre><code data-trim contenteditable>
int a = 1, b = 2, c = 3;
</code></pre>
</section>

<section markdown="block">
## Assignments are Expressions

Assignments are actually expressions that result in a value.

For example, you can do this:

<pre><code data-trim contenteditable>
int a = 1, b = 2, c = 3;
System.out.println(a = 4);
</code></pre>

(gives us 4!)
</section>

<section markdown="block">
## Constants

If you want a value that doesn't change... a __constant__, use the <code>final</code> keyword:

<pre><code data-trim contenteditable>
final typeOfVariable VARIABLENAME = value;
</code></pre>

It's common convention to have constants named in all uppercase. Here's an example:

<pre><code data-trim contenteditable>
final double PI = 3.14;
</code></pre>

</section>
<section markdown="block">
## Casting

__Casting__ is converting a value from one type to another. To cast, use the type you'd like to convert, surrounded by parentheses, and place before the value.

<pre><code data-trim contenteditable>
double res = 5 / 2.0;
int newRes = (int) res;
</code></pre>
</section>
