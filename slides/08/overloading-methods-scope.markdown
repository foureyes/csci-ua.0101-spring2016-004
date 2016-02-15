---
layout: slides
title: "Overloading Methods, Type Conversion Revisited"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
# A Tiny Review

</section>

<section markdown="block">
## Review - Defining a Method

Create a method called __<code>isOdd</code>__; it should have a single parameter, an int, and it should return the appropriate boolean value, <code>true</code> or <code>false</code>.

<pre><code data-trim contenteditable>
boolean anOddity = isOdd(5); // variable is set to true
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
public static boolean isOdd(int n) { 
	return n % 2 == 1;
}
</code></pre>


<span class="fragment">__Label the following:__</span> &rarr;

* {:.fragment} __method header__ &rarr; <code class="fragment">public static boolean isOdd(int n)</code>
* {:.fragment} __method body__ &rarr; <code class="fragment">return n % 2 == 1;</code>
* {:.fragment} __method signature__ &rarr; <code class="fragment">isOdd(int n)</code>

</section>


<section markdown="block">
# Method Overloading

</section>
<section markdown="block">
## Same Name, Different Signatures?

__How many - and what type - of arguments can we pass in to the <code>substring</code> method on a String object? What does it return for each set of arguments?__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
String substring(int beginningIndex)
String substring(int beginningIndex, int endIndex)
</code></pre>

<span class="fragment">__How many and what type of arguments can we pass in to the <code>abs</code> method in the Math class? What does it return for each set of arguments?__ &rarr;</span>

<pre class="fragment"><code data-trim contenteditable>
double abs(double a)
float abs(float a)
int abs(int a)
long abs(long a)
</code></pre>
</section>

<section markdown="block">
# FLASHBACK... TYPE CONVERSIONS!?

</section>
<section markdown="block">
## A Quick Word on Type Conversion

__Way back in the second chapter of the textbook:__ &rarr; 

"_You can always assign a value to a numeric variable whose type supports a larger __range__ of values_" 

* for example, you can assign a long value to a float variable
	* range for __<code>long</code>__:  <code>-2^63</code> to <code>2^63 - 1</code> (around 9.2E +18)
	* range for __<code>float</code>__:  
		* negative... <code>-3.4028235E + 38</code> to <code>-1.4E - 45</code>
		* positive... <code>1.4E - 45</code> to <code>3.4028235E + 38</code>
* <code>float f = 12345678910L; // L as a suffix... means literal long</code>
* {:.fragment} why/how? ...__isn't a long 64 bits, but a float 32 bits?__ &rarr;
* {:.fragment} floats are represented differently, and can approximate longs with using less bits (think scientific notation)


</section>
<section markdown="block">
## Type Conversion Continued

__What's the type of the variable d. What type is the literal 6? Does this compile or does it result in an error?__ &rarr;

<pre><code data-trim contenteditable>
double d = 6;
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
// 6 in an int. it's widened to a double. ok, no problem!
</code></pre>

<span class="fragment">__How about we take our new double and assign it to an int? What will happen?__ &rarr;</span>

<pre class="fragment"><code data-trim contenteditable>
int n = d;  // what do we have here? remember, d is a double.
</code></pre>

<span class="fragment">There's an error! __How do we fix it?__ &rarr;</span>

<pre class="fragment"><code data-trim contenteditable>
// explicit type casting!
int n = (int) d // there. fixed it for you
</code></pre>

</section>

<section markdown="block">
## So, a Quick Summary 


The book gives us a few definitions and describes general behavior for type casting. [A nice, more comprehensive, summary](http://docs.oracle.com/javase/specs/jls/se8/html/jls-5.html#jls-5.2) can also be found in the Java Language Specification. 

* __widening__ is converting a type with a small range to a type with a larger range
* __narrowing__ is converting a type with a large range to a type with a smaller range 
* __java will automatically widen a type...__ 

<pre><code data-trim contenteditable>
int i = 100;
// what? an int in a long. ok. let me widen that for you.
long l = i;
</code></pre>
</section>

<section markdown="block">
## Summary Continued

But __you _usually_ have to narrow a type explicitly__, otherwise an error will occur.

<pre><code data-trim contenteditable>
long l = 100;
int i = l; // nope!
int i = (int) l; cast explicitly to make this work
</code></pre>

* (the book said _must_, but that's not entirely true)
* __what would you expect for... <code>byte b = 2;</code> (ok or error)?__ &rarr;
* {:.fragment} <code>// turns out it's ok!</code>
* {:.fragment} "a narrowing primitive conversion may be used if the type of the variable is <code>byte</code>, <code>short</code>, or <code>char</code>, and the value of the constant expression is representable in the type of the variable"
</section>

<section markdown="block">
# Aaaand. We're back!
</section>

<section markdown="block">
## Max Again

Here's our version of __<code>max</code>__ again:

<pre><code data-trim contenteditable>
public static int max(int num1, int num2) {
	int result;
	if (num1 > num2) {
		result = num1;
	} else {
		result = num2; 
	}
	return result;
}

</code></pre>

__What's its signature?__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
int max(int num1, int num2)
</code></pre>
</section>

<section markdown="block">
## Calling Max

__What's the output of the following code?__ &rarr;

<pre><code data-trim contenteditable>
System.out.println(max(1, 8));
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
// two ints; matches the signature!
8
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
System.out.println(max(1.0, 8.0));
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
// two doubles... um. no.
ERROR: incompatible types: possible lossy conversion from double to int
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
byte x = 1;
byte y = 8;
System.out.println(max(x, y));
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
// two bytes. widening is ok.
8
</code></pre>

</section>

<section markdown="block">
## Calling Max Continued

__And... what will the output of this code be?__ (based on our previous definition of max) &rarr;

<pre><code data-trim contenteditable>
System.out.println(max(1, 8, 4));
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
// hm. signature was 2 ints, not 3!
ERROR: method max in class Evaluation cannot be applied to given types;
  required: int,int
    found: int,int,int
</code></pre>
</section>
<section markdown="block">
## Method Overloading

Clearly, our method is built to handle two ints. __How can we deal with other types as parameters?__ &rarr;

We can use __method overloading__.

* we can create more than one max method, but just have a different set of parameters for each
* this is called __method overloading__ - the creation of methods with the __same name__ (in the same class), but each with a different parameter list 
* the java compiler figures out which one should be called based on what arguments the method is called with
* overloaded methods __must have different parameter lists__
* they _can_ have different return types
* __you cannot overload methods based on different modifiers or return types__
	* __let's see what happens__ &rarr;
	* compile error, of course!
</section>

<section markdown="block">
## Overloaded Method Example

Here's <code>max</code> with a few different signatures...

<pre><code data-trim contenteditable>
public static int max(int num1, int num2) {
	if (num1 > num2) {
		return num1;
	} else {
		return num2;
	}
}

public static double max( double num1, double num2) {
	if (num1 > num2) {
		return num1;
	} else {
		return num2;
	}
}

public static double max(double num1, double num2, double num3) {
	return max(max(num1, num2), num3);
}
</code></pre>
</section>

<section markdown="block">
## Determining Which Overloaded Method is Called 

__Which version of max is invoked for the following method calls?__  &rarr;

<pre><code data-trim contenteditable>
max(1, 8);
max(1.0, 8.0);
max(1, 8.0);
max(1.0, 8.0, 3.0);
</code></pre>

* {:.fragment} <code>max(1, 8);</code> &rarr; <span class="fragment">the two int version</span>
* {:.fragment} <code>max(1.0, 8.0);</code> &rarr; <span class="fragment">the two double version</span>
* {:.fragment} <code>max(1, 8.0);</code> &rarr; <span class="fragment">the two double version</span>
* {:.fragment} <code>max(1.0, 8.0, 3.0);</code> &rarr; <span class="fragment">the three double version</span>


</section>

<section markdown="block">
## Who's Calling? Let's See if That's True

__Let's try using the following code to call max... and to see which methods are being called, we can simply print a message out in each method__.

<pre><code data-trim contenteditable>
// in main...
System.out.println(max(1, 8));
System.out.println(max(1.0, 8.0));
System.out.println(max(1, 8.0));
System.out.println(max(1.0, 8.0, 3.0));
</code></pre>
</section>

<section markdown="block">
## What, How?

What happens for <code>max(1, 8.0)</code>? 

* the two double version is called
* the argument, 1, is automatically converted to a double
* __then why doesn't <code>max(1, 8)</code> result in the two double version being called?__ &rarr;
	* both <code>max(double, double)</code> and <code>max(int, int)</code> are possible!
	* however, the compiler finds the best match

</section>

<section markdown="block">
## Review

__What is method overloading?__

<span class="fragment">__method overloading__ is the creation of methods with the __same name__ (in the same class), but each with a different parameter list </span>

<span class="fragment">__Find the error in the following pair of overloaded methods.__ &rarr;</span>

<pre><code data-trim contenteditable>
public static int calculateValue(int arg1) {
}
public static void calculateValue(int arg1) {
}
</code></pre>

<span class="fragment">They only vary by return type!</span>
</section>

<section markdown="block">
# Scope

</section>
<section markdown="block">
## Scope

__In the context of variables, define scope.__ &rarr;

<span class="fragment">The __scope__ of a variable is the area of a program where a variable can be referenced.  </span>

<span class="fragment">__What's a local variable?__ &rarr;</span>


* {:.fragment} a __local variable__ is a variable defined within a method. __what is the scope of a local variable?__ &rarr;
	* {:.fragment} a local variable is only available in the method it is defined in; it is __local to__ that method
	* {:.fragment} (its scope starts from its declaration and continues to the end of the block that contains it)
	* {:.fragment} a local variable __must be declared and assigned a value before it can be used__
* {:.fragment} parameters are actually local variables as well 
* 

</section>

<section markdown="block">
# A Method is Not the Only Structure That Creates Scope!

(let's see)

</section>

<section markdown="block">
## First an Experiment

__What's the output of this code?__ &rarr;

<pre><code data-trim contenteditable>
for(int i = 0; i <= 3; i++) {
	// twiddle thumbs, do nuthin'	
}
System.out.println(i);
</code></pre>

<span class="fragment">We actual get a compile-time error. The compiler thinks that <code>i</code> hasn't been defined yet.</span>


<pre class="fragment"><code data-trim contenteditable>
for(int i = 0; i <= 3; i++) {
	System.out.println("stuff...");
	System.out.println(i);
}
</code></pre>
<span class="fragment">Ok... that works. Counts from 0 through 3, with stuff before each number.</span>

<span class="fragment">__Variables declared in the initial action of a for loop are available throughout that for-loop__, but not outside of it. </span>
</section>

<section markdown="block">
## Another for loop Experiment

__What's the output of this code?__ &rarr;

<pre><code data-trim contenteditable>
for(int i = 0; i <= 3; i++) {
	int foo = 333;
}
System.out.println(foo);
</code></pre>

<span class="fragment">You guessed it! (I think). Also a compile-time error. The compiler thinks that <code>foo</code> hasn't been defined yet.</span>

<pre class="fragment"><code data-trim contenteditable>// (this may be obvious... but, let's figure it out anyway)
for(int i = 0; i <= 3; i++) {
	System.out.println(foo);
	int foo = 333;
}
</code></pre>

<span class="fragment">Still an error. (OF COURSE) __Variables declared in the loop are only available from the declaration to the end of its containing block.__ </span>
</section>

<section markdown="block">
## I'm Sure You Can't Wait to Find Out About Loops in Loops!

__What's the output of this code?__ &rarr;

<pre><code data-trim contenteditable>
for(int i = 0; i <= 1; i++) {
	for(int j = 0; j <= 1; j++) {
		System.out.println(i);
	}
}
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
0
0
1
1
</code></pre>

<span class="fragment">Works fine. Again, a variable declared in the initial action can be used throughout the for-loop, even within a nested for loop.</span>
</section>

<section markdown="block">
## for Loops and Local Variables

__Based on what we saw above, what do you think happens here?__ &rarr;

<pre><code data-trim contenteditable>
for(int i = 0; i <= 1; i++) {
	for(int i = 0; i <= 1; i++) {
		System.out.println(i);
	}
}
</code></pre>
<pre><code data-trim contenteditable>
public static void foo() {
	int i = 0;
	for(int i = 0; i <= 3; i++) {
		System.out.println(i);
	}
}
</code></pre>

<span class="fragment">Both compile-time errors.</span>

<span class="fragment">You can't duplicate a local variable in nested blocks of code!</span>
</section>
<section markdown="block">
## (Last One, I Swear)

__So... is this ok?__ &rarr;

<pre><code data-trim contenteditable>
for(int i = 0; i <= 3; i++) {
	System.out.println(i);
}
for(int i = 0; i <= 3; i++) {
	System.out.println(i);
}
</code></pre>

<span class="fragment">Totes. Ok.</span>
</section>

<section markdown="block">
## What Was That All About?

__Some rules on scope.__ &rarr;

* when you declare a local variable inside __any block__ (methods, for loops, even if statements), the variable will only be accessible within that block
* a variable can be re-declared in non-nested blocks
* however, you cannot have duplicate variable names in nested blocks
* a variable declared in the initial-action of a for-loop is accessible in the entire loop
</section>

