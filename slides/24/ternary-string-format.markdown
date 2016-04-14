---
layout: slides
title: "Ternary Operator and String Formatting"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
## For Your Convenience...

Java's pretty verbose, and it's really starting to manifest itself when we write <code>toString()</code> methods for our classes. __Let's take a look at some constructs/methods that ease the amount of typing we have to do!__ &rarr;

* ternary operator
* String.format

</section>

<section markdown="block">
## Ternary Operator

Ternawhat? Use the __ternary operator__ to choose between two values:

<pre><code data-trim contenteditable>
condition ? value1 : value2
</code></pre>

...where condition is some boolean expression, and value1 and value2 are any value.

The ternary operator expression:

* evaluates to value1 if condition is true
* evaluates to value2 if condition is false
</section>

<section markdown="block">
## Ternary Operator Continued

__What's the output of this code?__ &rarr;

<pre><code data-trim contenteditable>
int a = 5;
int b = 12;
int minVal = (a < b) ? a : b;
System.out.println(minVal);


a = 100;
b = 33;
minVal = (a < b) ? a : b;
System.out.println(minVal);
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
5
33
</code></pre>

</section>
<section markdown="block">
## Ternary Operator Tri-tinued? 

__Rewrite the following code using a ternary operator__ &rarr;
<pre><code data-trim contenteditable>
boolean extraCheese = false;
String s = "Pizza with ";
if(extraCheese) {
  s += "extra cheese";
} else {
  s += "cheese";
}
</code></pre>


<pre class="fragment"><code data-trim contenteditable>
boolean extraCheese = false;
String s = "Pizza with ";
s += extraCheese ? "extra cheese" : "cheese";
</code></pre>
</section>

<section markdown="block">
## printf Method Review

Does anyone remember what <code>printf</code> does? __What parameters does it have, and what does it do?__ &rarr;

<span class="fragment">A format string, and a variable number of arguments afterwards that populate the format string</span>

<span class="fragment">Great, __so what's the output of the following?__ &rarr;</span>

<pre class="fragment"><code data-trim contenteditable>
System.out.printf("I want my %.2f %s!!!", 2.0, "dollars");
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
I want my 2.00 dollars!!!
</code></pre>


</section>

<section markdown="block">
## String Format Method

Maybe you don't actually want to print anything out yet, though. Maybe you just want the <code>String</code> that _would_ have been printed out.

In this case, use the <code>String.format()</code> method:


<pre><code data-trim contenteditable>
String s = String.format("I want my %.2f %s!!!", 2.0, "dollars");
System.out.println(s);
</code></pre>

</section>
