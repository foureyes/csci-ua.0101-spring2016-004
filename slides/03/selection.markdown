---
layout: slides
title: "Selection"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
## Topics

* single selection
* dual selection
* multiple
* nested
* switch 
* common pitfalls
</section>

<section markdown="block">
# Boolean Values and Operators

</section>

<section markdown="block">
## Booleans

We've already learned 6 primitive numeric types. Another primitive type is a __boolean__. __What's a boolean - what are its possible values?__ &rarr;

<span class="fragment">A boolean can be either true or false. In Java, literal boolean values are:</span>

* {:.fragment} __true__ - all lowercase
* {:.fragment} __false__ - all lowercase
</section>

<section markdown="block">
## Boolean Expressions and Comparison Operators

__What's a boolean expression?__ &rarr;

<span class="fragment">It's an _expression_ - a combination of values, operators, functions/methods, etc. ... that returns either __true__ or __false__</span>


</section>
<section markdown="block">
## Operators

__There are two kinds of operators that yield boolean values.__ &rarr;

* __comparison__ operators - allow you to compare two values (obvs!)
* __logical__ operators - allow you to combine boolean values

</section>

<section markdown="block">
## Comparison Operators 

__Name 6 comparison operators (their syntax should be familiar!)__ &rarr;

* {:.fragment} __==__ - equals
* {:.fragment} __!=__ - not equals
* {:.fragment} __&gt;__ - greater than
* {:.fragment} __&gt;=__ - greater than or equal to
* {:.fragment} __&lt;__ - less than
* {:.fragment} __&lt;=__ - less than or equal to

</section>

<section markdown="block">
## Logical Operators

__Name 4 logical operators (hm - you may only recognize three of these__ &rarr;

* {:.fragment} __and__
* {:.fragment} __or__
* {:.fragment} __not__
* {:.fragment} __xor (exclusive or)__

</section>

<section markdown="block">
## Logical Operators - Syntax

If you're familiar with languages like C or C++, then the syntax for logical operators should be familiar. However, if you're coming from Python, the syntax is actually quite different...

* <code>&&</code> - __and__
* <code>||</code> - __or__
* <code>!</code> - __not__
* <code>^</code> - __xor (exclusive or)__
</span>
</section>

<section markdown="block">
## Logical Conjunction (And)

__And__ takes two operands... and it only evaluates to true if both operands are true. __What's the truth table for and?__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
 p | q | p && q
----------------
 t | t | t
 t | f | f
 f | t | f
 f | f | f
</code></pre>
</section>

<section markdown="block">
## Logical Disjunction (Or)

__Or__ takes two operands... and it evaluates to true if either operand is true. __What's the truth table for or?__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
 p | q | p || q
----------------
 t | t | t
 t | f | t
 f | t | t
 f | f | f
</code></pre>
</section>

<section markdown="block">
## Logical Negation (Not)

__How many operands does not have?__ &rarr;

<span class="fragment">Not has one operand. It evaluates to the opposite boolean value of the supplied operand. __What's the truth table for not?__ &rarr;</span>


<pre class="fragment"><code data-trim contenteditable>
 p | !p
----------
 t | f
 f | t
</code></pre>
</section>

<section markdown="block">
## Logical Negation (Exclusive Or)

Finally... there's exclusive or. It only evaluates to true of if both operands are different values. __What's the truth table for exclusive or?__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
 p | q | p ^ q
----------------
 t | t | f
 t | f | t
 f | t | t
 f | f | f
</code></pre>

<span class="fragment">
Note that <code>p != q</code> ... is the same as <code>p ^ q</code>
</span>
</section>

<section markdown="block">
## Order of Operations

1. not - <code>!</code>
2. xor - <code>^</code>
3. and - <code>&&</code>
4. or - <code>||</code>

Take a look at the [official Java documentation regarding operator precedence](http://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html).

</section>
<section markdown="block">
## Declaring a Boolean Variable

__What would the syntax be for:__ &rarr;

* {:.fragment} declaring a variable called <code>flag</code> that can hold true or false
	* {:.fragment} and assigning that variable to the value, true
* {:.fragment} declaring a variable, <code>comparison</code>, that can hold true or false
	* {:.fragment} and assigning that to the result of testing whether the integer 1 is equal to the integer 5 (all in one line)
* {:.fragment} declaring a boolean variable, <code>result</code> that holds the result of using logical negation (exclusive or, xor), when both operands are false

<pre class="fragment"><code data-trim contenteditable>
boolean flag = true;
boolean comparison = 1 == 5;
boolean result = false ^ false;
</code></pre>

</section>

<section markdown="block">
## Divisible by Both 3 and 5

__Write the following program__ &rarr;

* ask for a number
* print true if it's divisible by both 3 and 5, false otherwise 
* (you can do this without using if statements... which we'll cover shortly!)

<pre><code data-trim contenteditable>
Please enter a number
> 15
The number 15 is divisible by both 3 and 5:
true
</code></pre>

</section>

<section markdown="block">
## Divisible by Both 3 and 5 Continued

A potential solution...

<pre><code data-trim contenteditable>
Scanner input = new Scanner(System.in);
System.out.print("Please enter a number\n>");
int num = input.nextInt();
System.out.println("The number " +  num + " is divisible by both 3 and 5:");
System.out.println(num % 3 == 0 && num % 5 == 0);
</code></pre>
</section>

<section markdown="block">

# Selections

</section>

<section markdown="block">
## Selection Statements

__selection statements__ are statements that allow you to choose actions with alternative courses. We'll be looking at:

* <code>if</code>
* <code>if-else</code>
* <code>if-else-if</code>
* <code>nested ifs</code>
* <code>switch</code>

</section>
<section markdown="block">
## if statements

An __if statement__ is a construct that enables a program to specify alternative paths of execution. There are 3 kinds of if statements that we can write:

* a one-way if statement
* a two-way if-else statement
* a multi-way if-else-if statement

</section>
<section markdown="block">
## if

* a __one-way if statement__ executes an action if and only if the condition is true
* also called _single alternative decision structure_ 

<pre><code data-trim contenteditable>
if (boolean_expression) {
	// do stuff here only if boolean
	// expression above is true
}
</code></pre>

* {:.fragment} start with the keyword, <code>if</code>
* {:.fragment} followed by a _boolean expression_ within parentheses
* {:.fragment} and finally, a set of statements to execute within curly braces (if the boolean expression is true!)
</section>
<section markdown="block">
# Let's Try Using an if Statement

</section>
<section markdown="block">
## Bounce

__Let's run a program that simulates a ball falling down from the top of the program's window__ &rarr;

Note that... 

* (0, 0) is the upper left corner
* (WIDTH, HEIGHT) is the lower left corner (these are 600 and 400)
* ... and there's actually no bouncing that happens; __it just falls off the screen__ &rarr;


</section>

<section markdown="block">
## Bounce Code

__Let's take a look at the code.__ &rarr;

* {:.fragment} for now, just know that the _method_ that we're going to edit is responsible for calculating the ball's x and y position, as well as horizontal and vertical velocity
* {:.fragment} it gets called for every __frame__ of animation
* {:.fragment} the following variables are available for you to use:
	* {:.fragment} __x__ is the x position of the ball
	* {:.fragment} __y__ is the y position of the ball
	* {:.fragment} __dx__ is the ball's horizontal velocity
	* {:.fragment} __dy__ is the ball's vertical velocity (__dy__ is always increasing acceleration!)
	* {:.fragment} dx and dy are added to the ball's x and y in each frame
	* {:.fragment} __which way will a positive and negative dx and dy go?__
	* {:.fragment} __WIDTH__ (the width of the window) and __HEIGHT__ (the height of the window)
		

</section>
<section markdown="block">
## Let's Modify the Program

The ball starts falling when the program starts...

1. __how would test if the ball is at the bottom of the screen?__ &rarr;
2. __make the ball bounce back up when it hits the bottom of the window__ &rarr;
3. __perhaps "dampen" dy when it bounces...__ &rarr;
4. __make the ball bounce in the opposite direction when it hits the far left or the far right of the screen__ &rarr;
</section>

<section markdown="block">
## A Potential Solution

<pre><code data-trim contenteditable>
// with the context of the sample program...

if (y > HEIGHT) {
	dy *= -1 * dampening;
} 

if (x > WIDTH) {
	dx *= -1;
}

if (x < 0) {
	dx *= -1;
}
</code></pre>

</section>

<section markdown="block">
## Sans Curly Braces (for if statements)

So... there's an alternative syntax to writing if statements if you have only one statement (note that a nested is also considered a single statement) in the body of your if.

__You can drop the curly braces! The previous code could have been rewritten as...__ &rarr;

<pre><code data-trim contenteditable>
if (y > HEIGHT) 
	dy *= -1 * dampening;

if (x > WIDTH) 
	dx *= -1;

if (x < 0) 
	dx *= -1;
</code></pre>
</section>

<section markdown="block">
## Sans Curly Braces Continued

While dropping the curly braces means less typing and more concise code... __what's a downside?__ &rarr;

<span class="fragment">You have to remember to add the braces if you want to add additional statements!</span>

</section>

<section markdown="block">
## if-else

* a __two-way if-else statement__ executes an action based on whether or not the condition is true
* the actions that a two-way if-else statement specifies differ based on whether the condition is true or false.
* (an if-else is also called a _dual alternative decision structure_)

<pre><code data-trim contenteditable>
if (boolean_expression) {
	// do stuff here only if boolean
	// expression above is true
} else {
	// do stuff here only if boolean
	// expression above is false
}
</code></pre>

</section>

<section markdown="block">
## if-else in more detail

* {:.fragment} start with the keyword, <code>if</code>
* {:.fragment} followed by a _boolean expression_ within parentheses
* {:.fragment} a set of statements to execute within curly braces if the boolean expression is <code>true</code>
* {:.fragment} the keyword, <code>else</code>
* {:.fragment} a set of statements to execute within curly braces if the boolean expression is <code>false</code>

</section>

<section markdown="block">
## Number Guessing Game 

__Write a program that:__ &rarr;

* stores a secret number in a variable
* asks the user to guess the number
* prints out a message telling the user that they've guessed correctly or incorrectly

<pre><code data-trim contenteditable>
Guess what number I'm thinking of?
>12
You *don't* got it!
</code></pre>

<pre><code data-trim contenteditable>
Guess what number I'm thinking of?
>5
You got it!
</code></pre>

</section>
<section markdown="block">
##  Number Guessing Game

A potential solution...

<pre><code data-trim contenteditable>
int secret = 5;
Scanner input = new Scanner(System.in);
System.out.print("Guess what number I'm thinking of\n>");
int num = input.nextInt();
if (num == secret) {
	System.out.println("You got it!");
} else {
	System.out.println("You *don't* got it!");
}
</code></pre>
</section>


<section markdown="block">
## More Than 2 Code Paths?

Ok... so if and if-else let us conditionally execute one or two branches of code respectively. What if there are more than 2 code paths.

Here's a contrived example. __Write a program that translates a numeric grade into a letter grade__ &rarr;

* ask for a number
* print out the associated letter grade - 90 or over is an A, 80 or over is a B...
* let's pretend that no one gets under an 80 (nice to be aspirational, right?)
* ...so for any other value, print out "I don't believe you"
* do this without using and (<code>&&</code>)
* only use the constructs that we've learned so far
* example below...

<pre><code data-trim contenteditable>
What's your score?
4
I don't believe it!
</code></pre>
</section>

<section markdown="block">
## Here's a Suspicious Version

__Will this work? What will the output be? It seems to work... ish__ &rarr;

<pre><code data-trim contenteditable>
Scanner input = new Scanner(System.in);
System.out.println("What's your score?");
int score = input.nextInt();
if (score >= 90.0) {
	System.out.print("You got an A");
}  
if (score >= 80.0) {
	System.out.print("You got a B"); 
}
if (score < 80) {
	System.out.println("I don't believe it!");
}
</code></pre>

* {:.fragment} prints both A and B for 90 or over
* {:.fragment} consecutive if statements are independent from each other's conditions!

</section>


<section markdown="block">
## Nested If-Else

__Hmmm... here's one that's a little ugly, but it works!__ &rarr; 

* nested if-else statements allow us to choose one of many code paths
* (good thing we didn't take into account grades under an 80!)

<pre><code data-trim contenteditable>
Scanner input = new Scanner(System.in);
System.out.println("What's your score?");
int score = input.nextInt();
if (score >= 90.0) {
	System.out.print("You got an A");
} else {
	if (score >= 80.0) {
		System.out.print("You got a B"); 
	} else {
		System.out.println("I don't believe it!");
	}
}
</code></pre>

</section>

<section markdown="block">
## If-Else-If

Of course, there's an easier way to do it. Use <code>if</code>... then <code>else if</code>.

You could do something like this:

<pre><code data-trim contenteditable>
if (boolean_expression) {

} else if (another_boolean_expression) {

} else if (yet_another) {

} else {

}

</code></pre>

</section>

<section markdown="block">
## If-Else-If Continued

__And... what would that look like for our grade translation example?__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
if (score >= 90.0) {
	System.out.print("You got an A");
} else if (score >= 80.0) {
	System.out.print("You got a B"); 
} else {
	System.out.println("I don't believe it!");
}
</code></pre>
</section>

<section markdown="block">
## If-Else-If Details

A few things to remember using <code>else if</code>

* conditions will be checked starting from the top
* they will continue to be checked
* until the first true condition
* at which point... the code between the curly braces is executed
* the <code>else</code> at the end is optional
</section>


<section markdown="block">
## Switch 

There's actually one more way to choose from multiple code paths. You can use a __switch__ statement:

<pre><code data-trim contenteditable>
switch (some_existing_variable) {
	case 1: 
		// do some stuff if some_existing_variable equals 1
		break;
	case 2: 
		// do some stuff if some_existing_variable equals 2
		break;
	default:
		// do default stuff
}
</code></pre>
</section>

<section markdown="block">
## How Does Switch Work?

1. use the keyword switch
2. followed by a variable (perhaps an int variable)
3. within curly braces... 
	* one or more of the keyword case... followed by a value... and a colon
	* if that value matches the variable specified, the code below case will be executed
	* and then... __every single case after__ will be executed! 
	* to stop checking the remaining cases, use break in your case
	* finally... an optional default... 
	* the statements under default are executed when nothing is matched
</section>

<section markdown="block">
## An Example

<pre><code data-trim contenteditable>
int userChoice = 2;
switch(userChoice) {
	case 1:
		System.out.println("Pizza");
		break;
	case 2:
		System.out.println("Brussel Sprouts");
		break;
	case 3:
		System.out.println("Ice Cream");
		break;
	case 4:
		System.out.println("Ice Cream Pizza!");
		break;
	default:
		System.out.println("Nope. Nuthin");
}

</code></pre>
</section>

<section markdown="block">
## And Another Example

Let's watch the fall through behavior if we remove break...

<pre><code data-trim contenteditable>

int userChoice = 2;
switch(userChoice) {
	case 1:
		System.out.println("Pizza");
	case 2:
		System.out.println("Brussel Sprouts");
	case 3:
		System.out.println("Ice Cream");
	case 4:
		System.out.println("Ice Cream Pizza!");
	default:
		System.out.println("Nope. Nuthin");
}
</code></pre>
</section>
