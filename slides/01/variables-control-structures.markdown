---
layout: slides
title: Variables and Control Structures (and Built-In Functions)
---

<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

</section>

<section markdown="block">
## Some Definitions

We learned how to produce values from using operators on other values. __We created expressions!__.

* __expression__ - a fragment of code that produces a value
	* not a statement by itself
	* every literal value is an expression - <code>27</code>, <code>"YES!"</code>
* __statement__ - a full instruction for the computer
	* __all statements end in a semicolon__ in JavaScript (you know __;__)
	* the simplest statement is an expression with a semicolon at the end - <code>27;</code>, <code>"YES!";</code>
* __program__ - <span class="fragment"> a sequence of statements that specify to a computer actions to perform</span>
* __function__ - <span class="fragment"> a named sequence of code that can be called by name</span>
* __built-in function__ <span class="fragment"> - a function available in the _global_ namespace that is part of the core language</span>

</section>

<section markdown="block">
## Expressions and Statements Continued

<pre><code data-trim contenteditable>
// Expression (no semicolon)
1 + 5

// Statement
1 + 5;

// Even these are statements:
1;
"hi";
</code></pre>
</section>

<section markdown="block" data-background="#440000">
## All statements end with a semicolon.
</section>

<section markdown="block">
## Functions

__What's a function?__ &rarr;

* a __function__ is a named sequence of statements that perform some useful action.
* it can take inputs, and it can return values, but it doesn't have to do either
* to __call__ (or execute) a function, just call it by name, with parentheses after (with an optional list of commas separated inputs within the parentheses)
* the values passed to a function are called __arguments__
* for example: isNaN(12) is a function call
</section>

<section markdown="block">
## To call a function, use its name followed by parentheses.
</section>

<section markdown="block">
## Built-In Functions

JavaScript comes with a bunch of built in functions (and objects) that are available globally. Here are a couple:

* __parseInt(string, radix)__ - [returns an integer](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/parseInt) based on the string and radix
	* always specify radix
	* <code>parseInt("100", 2)</code>
	* <code>parseInt("100", 10)</code>
* __console.log(obj1 [,obj2 ..., objN])__ - [outputs a message](https://developer.mozilla.org/en-US/docs/Web/API/console.log) (the string representation of obj) to the console (more on objects and methods later)
	* <code>console.log("hi")</code>
	* <code>console.log("hi", "hello")</code>
</section>


<section markdown="block">
## Variables


* __variables__ are symbolic names for values. 
	* you can use a variable's name wherever you want to use that value.
	* to create a variable, use the __keyword__, __var__, followed by =, then the value, and finally a semicolon
	* <code>var x = 23;</code>
	* <code>console.log(x + 7); // using that variable</code>
* we can create __identifiers__, or variable names, based on these rules:
	* start with a __letter__, __underscore (_)__, or __dollar ($)__ 
	* following characters can be any of above, and/or __digits (0-9)__
	* variable names are case sensitive
	* cannot be a reserved word
</section>

<section markdown="block">
## Reserved Words

__Don't use these as variable names__

<pre><code data-trim contenteditable>
abstract
boolean break byte
case catch char class const continue
debugger default delete do double
else enum export extends
false final finally float for function
goto
if implements import in instanceof int interface
</code></pre>
<pre><code data-trim contenteditable>
long
native new null
package private protected public
return
short static super switch synchronized
this throw throws transient true try typeof
var volatile void
while with
</code></pre>
</section>

<section markdown="block" data-background="#440000">

## Always use <code>var</code> when declaring variable names!

Otherwise, you get global variables!
</section>

<section markdown="block">
## A Quick Preview of Conditionals, Loops and Arrays

### You probably already know this stuff, since it looks a lot like Java/C/C++

<small>So... let's breeze through it</small>
</section>
<section markdown="block">
## If Statement

Conditionally execute a branch of code.

<pre><code data-trim contenteditable>
if (some_boolean_expression) {
	// do stuff here if expression is true
}
</code></pre>

</section>

<section markdown="block">
## If / Else Statement

Execute one branch if condition is true, another branch if condition is false.  An else must have a preceding if!

<pre><code data-trim contenteditable>
if (some_boolean_expression) {
	// do stuff here if expression is true
} else {
	// do stuff here if expression is false
}
</code></pre>

</section>

<section markdown="block">
## If / Else If

chain multiple conditions  

* you can add else at the __end__ as well
* conditions are evaluated until the first true condition
* at the first true condition, the if statement finishes immediately
* (following else-if statements are not executed)

<pre><code data-trim contenteditable>
if (boolean_expression_1) {
	// do stuff here if expression 1 is true
} else if (boolean_expression_2) {
	// do stuff here if expression 2 is true
} else if (boolean_expression_3) {
	// do stuff here if expression 3 is true
} else {

}
</code></pre>
</section>

<section markdown="block">
## Boolean Expression

Note that within the parentheses is some expression that produces a boolean values (true or false). This is a __boolean expression__.

<pre><code data-trim contenteditable>
if (boolean_expression_1) {
	// do stuff here if expression 1 is true
} 
</code></pre>
</section>

<section markdown="block">
## Blocks of Code

Curly braces denote statements of code that are grouped together.  Everything within the curly braces below is considered part of the if statement.

<pre><code data-trim contenteditable>
if (boolean_expression_1) {
	// do stuff here if expression 1 is true
} 

</code></pre>

</section>

<section markdown="block">
## Iteration and Loops

Some formal definitions:

* __iteration__ - repeated execution of a set of programming statements.
* __loop__ - the construct that allows allows us to repeatedly execute a statement or a group of statements until a terminating condition is satisfied.
* sometimes I use these words interchangeably!
</section>


<section markdown="block">
## A For Loop

<pre><code data-trim contenteditable>
for(var i = 0; i <= 5; i = i + 1) {
	console.log(i);
}
</code></pre>
</section>

<section markdown="block">
## For Loop Parts

__Just like C and Java...__ &rarr;

<pre><code data-trim contenteditable>
//    initialization
//    |        condition
//    |        |       afterthought/increment
//    |        |       |
for(var i = 0; i <= 5; i = i + 1) {
	console.log(i);
}
</code></pre>
</section>

<section markdown="block">
## Post Increment, Post Decrement

You'll find your usual post increment and decrement operators
<pre><code data-trim contenteditable>
// increment and assign to i
i++

// decrement and assign to i
i--
</code></pre>
</section>

<section markdown="block">
## A Quick Aside on Arrays

An __array__ literal, assignment and the __length__ property

<pre><code data-trim contenteditable>
[1, 2, 3]
var numbers = [1, 2, 3]
console.log(numbers.length)
</code></pre>
</section>

<section markdown="block">
## Some Quick Exercises
### Some silly practice programs to get you warmed up
</section>

<section markdown="block">
## FizzBuzz

__From Eloquent JavaScript__:

* write a program that uses console.log to print all the numbers from 1 to 100
* for numbers divisible by 3, print "Fizz" instead of the number
* for numbers divisible by 5 (and not 3), print "Buzz" instead
* for numbers divisible by __both__ 3 and 5, print "FizzBuzz" instead
</section>

<section markdown="block">
## Function Definition

<pre><code data-trim contenteditable>
var f = function(x) {
	return x
}

</code></pre>
</section>

<section markdown="block">
## Max Number

* write a function that takes one parameter, an array - assume that it will only have 0 or more numbers
* the function should return the largest number in the array
</section>

<section markdown="block">
## ...Aaaand We're Done with the Preview

</section>
