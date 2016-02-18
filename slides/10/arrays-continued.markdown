---
layout: slides
title: "Arrays Continued"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
## A Quick Review

__Write the code that does the following:__ &rarr;

* create an Array of 10 boolean values called <code>switches</code>
* print out the last value of the Array, <code>switches</code>
* (__what will the output be?__ &rarr;)
* create an Array of 4 ints called <code>odds</code>
* set the elements to 1, 3, 5 and 7
* iterate through every element in the Array -- print out twice the value of each element


</section>

<section markdown="block">
## A Quick Review - Sample Code

__Create a couple of Arrays!__ 

<pre><code data-trim contenteditable>
boolean[] switches = new boolean[10];

// last element is at index length - 1!
System.out.println(switches[switches.length - 1]);

int[] odds = new int[4];
odds[0] = 1;
odds[1] = 3;
odds[2] = 5;
odds[3] = 7;

for(int i = 0; i < odds.length; i++) {
	// twice the value...
	System.out.println(odds[i] * 2);
}
</code></pre>
</section>

<section markdown="block">
# Wow. That. Was. Tedious.

### (We can make things easier.)

### (What was annoying about that?)

</section>
<section markdown="block">
## Some Tedious Parts

__That was a bit verbose!__ &rarr;

* {:.fragment} initializing every value manually
	* {:.fragment} index each value!
	* {:.fragment} such boring!
* {:.fragment} iterating with indexes
	* {:.fragment} easy to forget to index into original Array (sad face)
	* {:.fragment} boo!

</section>

<section markdown="block">
## Array Initializers

Ok. First off, let's take care of setting the values of an Array one-by-one. That's _nonsense_.

We can use an __array initializer__ to declare, create and initialize the values in an Array:

<pre><code data-trim contenteditable>
elementType[] arrayRefVar = {val1, val2, ..., valkla;}
</code></pre>

__How would we create our Array of 4 odd numbers starting from 1?__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
int[] odds = {1, 3, 5, 7};
</code></pre>

<span class="fragment"> A few things you should note, though: </span>

* {:.fragment} you don't have to use <code>new</code>!
* {:.fragment} __try separating the declaration from the assignment__ &rarr;
* {:.fragment} you __must__ declare, create, and initialize the array all in one statement
</section>

<section markdown="block">
## Array Initializers Continued and Empty Arrays!

Additionally, if you want an __empty__ Array, use the following syntax:

<pre><code data-trim contenteditable>
int[] nums1= new int[0];
int[] nums2= [];
</code></pre>
</section>

<section markdown="block">
## Foreach

__What were some things we needed to keep track of in order to loop over every element in the odds list?__ &rarr;

* {:.fragment} the index (and remembering to use it to fish out a value)
* {:.fragment} the length of the Array to figure out when to stop
* {:.fragment} how to increment the index

<span class="fragment">All of that seems like laborious overhead, when we really just want each number... which is why there the __foreach__ loop in Java. Want to iterate over every element? Don't care about the index? Try this:</span>

<pre class="fragment"><code data-trim contenteditable>
for (elementType loopVar: arrayRefVar) {
	// loopVar represents the current element
	// do stuff with loopVar here!
}
</code></pre>




</section>

<section markdown="block">
## Foreach Continued

__How would we rewrite our previous loop using foreach?__ &rarr;

<pre><code data-trim contenteditable>
for(int i = 0; i < odds.length; i++) {
	// twice the value...
	System.out.println(odds[i] * 2);
}
</code></pre>

<pre><code data-trim contenteditable>
for(int num: odds) {
	System.out.println(num);
}
</code></pre>
</section>

<section markdown="block">
## Printing Arrays?

__What happens when we print an Array? How do we _actually_ see the entire contents of an Array?__ &rarr;

* {:.fragment} depending on the type, we'll get something different
	* {:.fragment} let's try an Array of ints
	* {:.fragment} we get a bunch _gibberish_ numbers (er, it's a hashCode -- think of it as a number that identifies your object) 
	* {:.fragment} and chars?
	* {:.fragment} ooh... nice
* {:.fragment} We have to loop to get the actual conents

</section>

<section markdown="block">
## Printing Arrays Continued

Ah. For an easier life... maybe we could __find something that doesn't require us to write a loop!__ &rarr;

<span class="fragment">The __Arrays__ class (from java.util) allows you to get useful String representation of Array's actual contents! __Let's see.__ &rarr;</span>

* {:.fragment} <code>Arrays.toString(); </code>
* {:.fragment} <code>Arrays.deepToString(); // we won't use this so much yet </code>
</section>

<section markdown="block">
## Arrays as Method Parameters

__Is an Array a reference type or a primtive?__ &rarr;

<span class="fragment">It's a reference type. __What does that mean? ... What happens when we first declare an Array?__ &rarr;</span>

<span class="fragment">Enough space for a reference is created. ...When an Array is actually created in memory, that reference points to that location in memory1</span>

<span class="fragment">__Arrays are references!__</span>

</section>

<section markdown="block">
## Arrays as Method Parameters Continued

__That has some interesting side effects! What do you think the output of this code is?__ &rarr;

<pre><code data-trim contenteditable>
public static void main(String[] args) {
    int[] numbers = {1, 2, 3};
    System.out.println(Arrays.toString(numbers));
    changeFirstToFive(numbers);
    System.out.println(Arrays.toString(numbers));
}

public static void changeFirstToFive(int[] arr) {
    arr[0] = 5;
}
</code></pre>
<pre class="fragment"><code data-trim contenteditable>
[1, 2, 3]
[5, 2, 3]
</code></pre>
</section>

<section markdown="block">
## Let's Compare

__Now... what happens with primitives?__ &rarr;

		
</section>
<section markdown="block">
## Passing Arrays as Parameters Continued

<pre><code data-trim contenteditable>
public static void main(String[] args) {
    int myNum = 1;
    System.out.println(myNum);
    addFive(myNum);
    System.out.println(myNum);
}

public static void addFive(int n) {
    n += 5;
}
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
1
1
</code></pre>

</section>
<section markdown="block">
## Passing Arrays as Parameters Finale

Sooo... when we call a method with an Array as a parameter... we're _passing by value_, and the value that we're passing is a reference (sometimes this is also called _passing by sharing_ in other languages, such as Python and JavaScript). 

* the body of the method gets a __reference__ to the _actual_ Array
* any modifications we do to it will be on the Array itself!
* (so the effects can be seen outside of the method!)

</section>
<section markdown="block">
## Copying an Array 

__So... this also means some weird stuff happens in assignment.__ &rarr;

<pre><code data-trim contenteditable>
arr1 = arr2; // won't do what you think
</code></pre>


<pre class="fragment"><code data-trim contenteditable>
int[] arr1 = {1, 2, 3};
int[] arr2;
arr2 = arr1;
arr1[0] = 5;
System.out.println(Arrays.toString(arr1));
System.out.println(Arrays.toString(arr2));
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
[5, 2, 3]
[5, 2, 3]
</code></pre>


</section>

<section markdown="block">
## Copying Continued

So the previous is not actually a copy - __now both names are pointing to the same Array!__

Hm... to _actually_ copy, use <code>arraycopy</code> in the System class... or clone:

<pre><code data-trim contenteditable>
arr2 = arr1.clone();

// or
int[] arr2 = new int[3];
// source, start, dest, start, length
System.arraycopy(arr1, 0, arr2, 0, arr1.length);
</code></pre>
</section>
