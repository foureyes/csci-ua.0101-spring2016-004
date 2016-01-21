---
layout: slides
title: "Arrays"
---

<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>


<section markdown="block">
## Arrays

What's an __Array__? __An Array is a collection of data__:

* the data must be __all the same type__
* the data is __ordered__ (that is, an Array's elements are sequential)
* you can access an element in an Array by using its position, its __index__
* the __size__ (length) of an Array is __fixed__ 
* ... though, the elements (parts) of an Array can be changed (__Arrays are mutable__)
</section>

<section markdown="block">
## How is an Array Different from a Python List?

You might be tempted to use Arrays like Python lists, which makes sense in some cases.

But __WATCH OUT!__ __How are Java Arrays different from Python lists?__ &rarr;

* {:.fragment} Java Arrays have a fixed length; Python lists can change in size (you can add and remove elements, consequently changing the length)
* {:.fragment} Java Arrays have to contain data that's all the same type; Python lists can contain any value!

</section>

<section markdown="block">
## Declaring an Array Variable

__An array variable is declared using the following syntax:__ &rarr;

<pre><code data-trim contenteditable>
elementType[] variableName
</code></pre>

* {:.fragment} declare the type of the elements that your Array will hold
* {:.fragment} open and close brackets to specify it's an Array
* {:.fragment} lastly, your variable name...

<pre class="fragment"><code data-trim contenteditable>
// declares an Array of integers
int[] numbers;
</code></pre>

<span class="fragment">Note that... <code>elementType arrayRefVar[]</code> is also syntactically valid, but rarely used.</span>
</section>

<section markdown="block">
## An Aside: Types O' Types

(You must be tired of hearing this same question over and over again).

__What are the two broad categories of types in Java?__ &rarr;

* {:.fragment} primitive
* {:.fragment} reference

</section>

<section markdown="block">
# Our First Reference Type

(Yay)
</section>

<section markdown="block">
## Arrays, Reference Type

An __array__ is a __reference type__. It's an object.

Unlike primitive types, when an Array variable is declared, memory is not allocated for the Array itself... rather, only enough memory to store a _reference_ to another location in memory is allocated.

* room for the Array not allocated on declaration
* however, storage for reference is allocated on declaration
</section>

<section markdown="block">
## Creating Arrays

To actually create an Array, use the following syntax:

<pre><code data-trim contenteditable>
variableName = new elementType[sizeOfArray];
</code></pre>

* {:.fragment} use the keyword, <code>new</code>
* {:.fragment} followed by the type of elements that an Array will hold
* {:.fragment} then square brackets... and within brackets, the size of the Array
* {:.fragment} this does two things:
	* {:.fragment} creates an Array with  <code>elementType[sizeOfArray];</code>
	* {:.fragment} points reference to newly created array for variableName

<pre class="fragment"><code data-trim contenteditable>
// here's our variable declaration from the previous slide:
int[] numbers;
// the Array will contain 5 ints
numbers = new int[5];
</code></pre>
</section>

<section markdown="block">
## A Shortcut

We can declare, create and assign all in one step:

<pre><code data-trim contenteditable>
elementType[] arrayRefVar = new elementType[sizeOfArray];
</code></pre>

</section>

<section markdown="block">
## Indexing, Assigning Individual Elements

Just like Python Lists, you can use an Array's __index__ to assign a value to a position in the Array, or to read from a specific index from the Array. __What is the output of the following program?__ &rarr;

<pre><code data-trim contenteditable>double[] myList = new double[10];
myList[0] = 5.6;
myList[1] = 4.5;
myList[2] = 3.3;
myList[3] = 13.2;
myList[4] = 4.0;
myList[5] = 34.33;
myList[6] = 34.0;
myList[7] = 45.45;
myList[8] = 99.993;
myList[9] = 11123;
System.out.println(myList[6]);
</code></pre>


</section>


<section markdown="block">
## Default Values

__So... you actually default values when you create an Array, you have default values.__ &rarr;

* its elements are assigned the default value of 0 for the numeric primitive data types
* \u0000 for char types
* false for boolean types.

__Let's try it out.__ &rarr;

Create an Array of 10 elements of each... and print out the first element of each:

* ints
* chars
* booleans

</section>

<section markdown="block">
## Finding the Size of an Array

* use the <code>.length</code> _property_ / variable
* note... it's not a method call!

<pre><code data-trim contenteditable>
int numbers[] = new int[5];
System.out.println(numbers.length);
</code></pre>

</section>


<section markdown="block">
## Going Over Every Element in an Array

__How would we print out every element in an Array?__ &rarr;

<span class="fragment">Hint: maybe we could use a for loop... and get at each index...</span>


<pre class="fragment"><code data-trim contenteditable>
int numbers[] = new int[5];
for (int i = 0; i < numbers.length; i++) {
	System.out.println(numbers[i]);
}
</code></pre>

<span class="fragment">By the way, what's the output?</span>

<span class="fragment">Just a bunch of 0's!</span>

</section>

<section markdown="block">
## Some Exercises

* create an Array of 10 ints
* generate a random integer for each element 
	* should only be negative numbers starting at -100 to 0
* print out the array of ints
* find the largest int
* find the smallest int
* (don't use any built in Array methods)
</section>

<section markdown="block">
## Part 1, Array of 10 Random Negative Integers

* create an Array of 10 ints
* generate a random integer for each element

<pre><code data-trim contenteditable>
int[] randomNumbers = new int[10];
for(int i = 0; i < randomNumbers.length; i++) {
	randomNumbers[i] = (int) (Math.random() * 100 - 101);
}
</code></pre>
</section>


<section markdown="block">
## Largest, Smallest

<pre><code data-trim contenteditable>
int largest = randomNumbers[0];
int smallest = randomNumbers[0];

for(int i = 0; i < randomNumbers.length; i++) {
	if (randomNumbers[i] > largest) {
		largest = randomNumbers[i];
	}
	if (randomNumbers[i] < smallest) {
		smallest = randomNumbers[i];
	}section
}
</code></pre>
</section>
