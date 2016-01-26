---
layout: slides
title: A Tiny Review (Types, Operators, Control Structures, etc.)
---

<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
## A Tiny Review

### Previously on ...

* we talked about __types__, __operators__, and __variables__
* oh, and some __built-in functions__
* ....and __control structures__
	* <code>if</code> and <code>if</code>-<code>else</code>
	* <code>for</code>
* __let's do a quick recap__ &rarr;

</section>

<section markdown="block">
## Types

__Name 6 types that we know in JavaScript and a literal example of each.__ &rarr;

* number - <code>317</code>
* string - <code>"yup, a string"</code>
* boolean - <code>true</code>
* function - <code>function f(x) {return x * 2}</code>
* object - <code>{'classSection': '002'}</code>
* undefined - <code>undefined</code> (of course!)
{:.fragment}
</section>

<section markdown="block">
## Operators

We talked about a bunch of operators:

* __arithmetic__: <code class="fragment">+&nbsp;&nbsp;-&nbsp;&nbsp;*&nbsp;&nbsp;/&nbsp;&nbsp;%</code> <!--* -->
* __bitwise__: <code class="fragment">&&nbsp;&nbsp;|&nbsp;&nbsp;^&nbsp;&nbsp; ~&nbsp;&nbsp; &lt;&nbsp;&nbsp;>&nbsp;&nbsp;&gt;&gt;</code>
* __logical operators__: <code class="fragment">&&&nbsp;&nbsp;||&nbsp;&nbsp;!</code>
* __comparison operators__: <code class="fragment">==&nbsp;&nbsp;!=&nbsp;&nbsp;===&nbsp;&nbsp;!==&nbsp;&nbsp;&gt;&nbsp;&nbsp;&lt;&nbsp;&nbsp;&gt;=&nbsp;&nbsp;&lt;=</code>
* __miscellaneous__: 
	* unary <code>+</code> and <code>-</code> ... convert to positive or negative number
	* <code>typeof</code> ... obvs, returns string representation of type of operand
	* unary and postfix <code>++</code> and <code>--</code> ... increment and decrement
	{:.fragment}

</section>

<section markdown="block">
## And and Or

Some details about <code>&&</code> and <code>||</code>:

* if operands are not actually boolean, convert the value on the left side to a boolean
	* <code>||</code> 
		* will return the __left operand__'s value if it's __true__
		* otherwise, return the value on the right
		* can be used as a way to fall back to a default value <code>potentially_falsey || default_value</code>
	* <code>&&</code> 
		* will return the __left operand__'s value if it's __false__
		* otherwise, return the value on the right
* also... __short-circuit__ evaluation applies
		
</section>
	

<section markdown="block">
## Inherent Truthiness

__Some quick rules on automatic conversion of strings and numbers to booleans__ &rarr;

* <code>0</code>, <code>NaN</code>, empty string (<code>""</code>), and <code>undefined/null</code> are false
* other values are true-ish

<br>

__What's the result of the following boolean expressions?__ &rarr;

<pre><code data-trim contenteditable>
0 || 5
"hello" || 5
</code></pre>

<code>0</code> and <code>"hello"</code>
</section>



<section markdown="block">
## Equality

__What's the difference between__ <code>==</code> __and__ <code>===</code>__?__ &rarr;

* {:.fragment}<code>==</code> - allows coercion when testing if both values are equal
<pre><code data-trim contenteditable>
>"5" == 5
true
</code></pre>
{:.fragment}
* {:.fragment} <code>===</code> - checks both type and value
<pre><code data-trim contenteditable>
>"5" === 5
false
</code></pre>
{:.fragment}

__Always use__ <code>===</code> (and its friend, <code>!==</code>)!
{:.fragment}

</section>

<section markdown="block">
## Variables

__How is a variable declared in JavaScript?__ &rarr;

(create a variable called officeHoursRoom and set it equal to the number 423)

<pre><code data-trim contenteditable>
var officeHoursRoom = 423;
</code></pre>
{:.fragment}

* notice the keyword <code>var</code>? __Use it! All. The. Times. Really!__  
* does anyone remember what happens if you don't declare with <code>var</code>? <span class="fragment">__... you get a global variable ಠ_ಠ__</span>
{:.fragment}

<!--_ -->
</section>

<section markdown="block">
## And Speaking of a Look of Disapproval

### (Variable Names)

__What are the rules for a valid identifier (variable name) again?__ &rarr;

* start with a __letter__, __underscore__ ( <code>_</code> ), or __dollar__ ( <code>$</code> )
* following characters can be any of above, and/or __digits (0-9)__
* can't use reserved words / keywords
* {:.fragment} also... I did some research... __are Unicode characters allowed in variable names?__ &rarr;

<!--_ -->
<pre><code data-trim contenteditable>
var ಠ_ಠ = "disapproval";
console.log(ಠ_ಠ);
// totally works (O_o !?)
</code></pre>
{:.fragment}

Thanks [Stackoverflow](http://stackoverflow.com/questions/1661197/valid-characters-for-javascript-variable-names/9337047#9337047)! Also, here's more [about that look](http://knowyourmeme.com/memes/%E0%B2%A0_%E0%B2%A0-look-of-disapproval).
{:.fragment}

<!--_ -->
</section>

<section markdown="block">
## Another Note on Variables

Because JavaScript is dynamically typed... __variable reassignment, even of different types, is ok__ &rarr;

<pre><code data-trim contenteditable>
var x = 25;
x = "foo";
</code></pre>

Lastly, a quick aside...
{:.fragment}

* {:.fragment} [foo, bar, and baz are metasyntactic variables](http://en.wikipedia.org/wiki/Metasyntactic_variable)
* {:.fragment} apparently there are different metasyntactic variables for different natural languages!
</section>

<section markdown="block">
## Definition Time

### (What time is it?)

From {{ site.book_js }}: 

* the __environment__ is the collection of variables and their values that exist at a given time
* when a program starts up, __this environment is not empty__
* it always __contains variables that are part of the language standard__
* for example: 
	* the <code>console</code> object is an available variable from the start of your program!
	* same with _built-in_ functions!
</section>


<section markdown="block">
## Speaking of Built-In Functions

We saw 2~3 built-in functions. __What were they (just mentioned one in last slide).__ &rarr;

* <code>isNaN(obj)</code>
* <code>parseInt(string,radix)</code> 
* <code>console.log(obj1, [obj2, obj3, ... objN])</code>
{:.fragment}
</section>

<section markdown="block">
## On to the Next Thing: Control Structures

* as you might expect, JavaScript programs are generally executed line-by-line from top to bottom
* __but there are ways to _control_ that flow of execution (_of course_)!__ &rarr;
	* {:.fragment} conditionals
	* {:.fragment} repetition
	* {:.fragment} (we'll see others as well)


</section>

<section markdown="block">
## Conditionals and Loops

### We briefly saw <code>if</code> and <code>for</code> in the last class; let's take a closer look...


* we'll go through the following material quickly
* you probably already know this stuff, since it looks a lot like Java/C/C++
</section>

<section markdown="block">
## Again With the Definitions

* __boolean expression__ - an expression that results in a boolean value
	* <code>423 === 423</code> &rarr;
		* JavaScript &#10084;s coercing values for you; a value will be coaxed into boolean when the need arises
	* <code>!!5</code> &rarr;
		* logical not, logical not, number 5 ... <code>¯\_(ツ)_/¯</code>
* __block__ - a sequence of grouped statements bound by curly braces - <code>{</code>'s and <code>}</code>'s
* __iteration__ - repeated execution of a set of programming statements
* __loop__ - the construct that allows allows us to repeatedly execute a statement or a group of statements until a terminating condition is satisfied
</section>

<section markdown="block">
## If and Else

Conditionally execute a __block__ of code (should look _familiar_):

* __keyword__ <code>if</code> followed by a __boolean expression__ enclosed in parentheses
* __block__ of code to be executed if expression is true
* optional additional <code>else if</code>'s to chain conditionals, with corresponding __block__ of code to execute
* optional <code>else</code>, with corresponding __block__ of code to execute

<pre><code data-trim contenteditable>
if (some_boolean_expression) {
	// do stuff here if expression is true
}

if (some_boolean_expression) {
	// do stuff 
} else if (another_boolean_expression) {
	// do other stuff
} else {
	// do other other stuff
}
</code></pre>

</section>

<section markdown="block">
## A For Loop


Again, should look familiar... repeatedly execute a __block__ of code:

<pre><code data-trim contenteditable>
//    initialization
//    |        condition
//    |        |       afterthought/increment
//    |        |       |
for(var i = 0; i <= 5; i = i + 1) {
	console.log(i);
}

// (i++ works too, of course)
</code></pre>

{{ site.book_js }} calls the three parts: initialization, check and update.

__Hey - notice that <code>var</code> in front of the loop variable declaration?  Do that.__
{:.fragment}
</section>


<section markdown="block">
## A Few More Control Structures That We Didn't Talk About

### While loops, break/continue, and switch-case

</section>

<section markdown="block">
## A While Loop

Conditionally repeat a __block__ of code:
<pre><code data-trim contenteditable>
while (boolean_expression) {
	// repeat this stuff as long as boolean expression is true
}
</code></pre>
<br>

Conditionally repeat a __block__ of code __and__ ensure that code is executed at least once:
<pre><code data-trim contenteditable>
do {
	// repeat this stuff at least once
} while (boolean_expression)
</code></pre>
</section>

<section markdown="block">
## Break and Continue

The __keyword__ <code>break</code> immediately stops the execution of a loop:

<pre><code data-trim contenteditable>
for (var num = 1; num < 30; num++) { 
	if (num % 7 == 0 && num % 3 == 0)
		break; 
	console.log(num);
}
</code></pre>

The __keyword__ <code>continue</code> stops the current iteration and immediately skips to the next one:
<pre><code data-trim contenteditable>
for(var num = 1; num < 30; num++) { 
	if (num % 7 == 0 && num % 3 == 0)
		continue; 
	console.log(num);
}
</code></pre>

__What is the output of the above programs?__ &rarr; 

<span class="fragment">__1 through 20__ and __1 through 29 skipping 21__ respectively</span>
</section>

<section markdown="block">
## Switch-Case

Execute code based on value of switch.

<pre><code data-trim contenteditable>
var day = "thu";
switch (day) { 
	case "fri":
		console.log("Friday");
		break;
	case "thu":
		console.log("Thursday");
		break;
	case "wed":
		console.log("Wednesday");
		break;
}
</code></pre>

__What is the output of the above programs?__ &rarr; 

<span class="fragment">Thursday</span>

</section>

<section markdown="block">
## An Exercise

### (We didn't get to do this during the last class, so let's try it now)
</section>

<section markdown="block">
## FizzBuzz

__From Eloquent JavaScript__:

* write a program that uses console.log to print all the numbers from 1 to 100
* for numbers divisible by 3, print "Fizz" instead of the number
* for numbers divisible by 5 (and not 3), print "Buzz" instead
* for numbers divisible by __both__ 3 and 5, print "FizzBuzz" instead
</section>
