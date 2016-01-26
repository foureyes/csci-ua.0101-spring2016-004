---
layout: slides
title: "Values, Classes, Objects, Types"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
## Values

__What's a value?__ &rarr;

<span class="fragment">__Values__ are just data. </span>

* {:.fragment} we'll use the two words, values and data, synonymously
* {:.fragment} we'll be dealing with two kinds of data in Java:
	* {:.fragment} primitives
	* {:.fragment} objects
* {:.fragment} ...let's talk about objects first

</section>

<section markdown="block">
## Objects

We encountered objects in 0002, Introduction to Computer Programming. __What are objects again?__ &rarr;

* {:.fragment} objects are data
* {:.fragment} and actions or behaviors related to that data
	* {:.fragment} (__what are these actions/behaviors called__?)
	* {:.fragment} methods
* {:.fragment} all bundled into one _thing_
* {:.fragment} perhaps you have a pen object (turtle)
	* {:.fragment} it has coordinates (data) on a 2d plane
	* {:.fragment} it has actions / behaviors, such as _pick the pen up_
</section>

<section markdown="block">
## Objects, Primitives and Java

In Java, _almost_ everything is an object (OTOH, in Python, _Everything_ is an object).

* The data that we'll deal with initially is going to be mostly __primitives__, like numbers and booleans.
* There are actually 8 primitive data types (we'll see a few today). Of course, this begs the question...

</section>

<section markdown="block">
## Types

__What's a type?__ &rarr;

* {:.fragment} a type is just a category of data (or a kind of value)
* {:.fragment} ...in Python, some types that we had were str, float, int... there are similar types in Java
* {:.fragment} we'll take a look at some primitive types in Java shortly...
* {:.fragment} every data type has a range of possible values
* {:.fragment} the compiler allocates memory space for each value of a specific type

</section>

<section markdown="block">
## Classes?

Ok... great, we know there are some primitive data types. 

It turns out that there are different _kinds_ of objects as well.

* the type of an object is called a __class__
* sometimes we refer to a __class__ as a _blueprint_ for making objects
	* it specifies the data (or attributes)...
	* and __methods__
	* ... that a newly created object has!
* __type__ and __class__ can be used interchangeably 


</section>

<section markdown="block">
## Back to Our HelloWorld Code

Now... we can make some sense of our HelloWorld.java boilerplate code

* if you recall the boilerplate code that we use, you see that we're actually creating our own class!
* and within that class, we're defining a method called <code>main</code>


<pre><code data-trim contenteditable>
public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
}
</code></pre>
</section>

<section markdown="block">
## A Summary

* {:.fragment} what's a __value__? &rarr;
* {:.fragment} a __value__ is just data
* {:.fragment} there are two categorizations of data in Java __what are they?__ &rarr;
* {:.fragment} objects and primitive types
* {:.fragment} what's a __type__? &rarr;
* {:.fragment} a __type__ is a kind of value

</section>
<section markdown="block">
## Summary Continued

* {:.fragment} what's an __object__ &rarr;
* {:.fragment} an __object__ is a bunch of data bundled together with its behaviors / actions
* {:.fragment} what's a __method__ &rarr;
* {:.fragment} a __method__ is an action that an object can perform (think of it as a function in the context of an object)
* {:.fragment} what's a __class__? &rarr;
* {:.fragment} a __class__ is a blueprint for an object 

</section>
