---
layout: slides
title: Values, Types, and Operators
---

<section markdown="block" class="intro-slide">
# Values, Types, and Operators 

### {{ site.course_number}}-{{ site.course_section }}

<p><small> 
</small></p>
</section>

<section markdown="block">
## Some Definitions

* __value__ <span class="fragment"> - data</span>
* __type__ <span class="fragment"> - a category or classification of values</span>
* __operator__ <span class="fragment"> - a language construct that allows the manipulation or combination of a value or values to yield another value</span>
* __operand__ <span class="fragment"> - a value that an operator works on; the subject of an operator</span>
* __unary operator__ <span class="fragment"> - an operator that only has one operand</span>
* __binary operator__ <span class="fragment"> - an operator that has two operands</span>
* __prefix operator__ <span class="fragment"> - an operator that goes before (to the left) of its operand(s)</span>
* __infix operator__ <span class="fragment"> - an operator that goes between its operands</span>
</section>

<section markdown="block">
## Oh - And Comments

Similar to comments in C or Java...

<pre><code data-trim contenteditable>
// a comment

/*
a long
comment
*/
</code></pre>
</section>

<section markdown="block">
## Values

* __What's a value?__ &rarr;
	* __values__ are just data
	* they're _pieces of information_.  
	{:.fragment}
* {:.fragment} Some examples of __literal values__ in JavaScript:
<pre><code data-trim contenteditable>
317.0
"oh, hello"
true
{'name': 'Joe'}
function() {console.log("in here!")};
undefined
</code></pre>
{:.fragment}
</section>

<section markdown="block">
## Types of Values

So, there are 6 basic types in JavaScript...

__Based on the values in the previous slides, guess what types JavaScript supports?__ &rarr;

1. number
2. string
3. boolean
4. object
5. function
6. undefined 
{:.fragment}

</section>

<section markdown="block">
## typeof

Before we delve into these data types, let's check out a __unary__, __prefix__ __operator__:

<pre><code data-trim contenteditable>
typeof
</code></pre>
{:.fragment}

As you might expect, <code>typeof</code> [returns a string that represents the operand's type](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/typeof):
{:.fragment}

<pre><code data-trim contenteditable>
> typeof 317.0
'number'
</code></pre>
{:.fragment}

We'll be using <code>typeof</code> extensively for the next few slides....
{:.fragment}
</section>

<section markdown="block">
## Numbers

* unurpsingly, numbers are just _numbers_
	* __all numbers in Javascript are 64bit (8 bytes) floating point numbers__ 
	* JavaScript does not distinguish between ints, floats, longs, doubles, etc.
* numbers represent...
	* positive and negative whole numbers: 23, 42, -10
	* floating point numbers (with a dot): 2.3, 4.2
* __number literals consist of digits, an optional decimal point, and an optional exponent__ &rarr;
<pre><code data-trim contenteditable>
123 // an integer - just digits
12.3 // a floating point number - decimal point
12e3 // (12 times 10 to the 3rd) exponent
</code></pre>
</section>


<section markdown="block">
## More About Numbers

* __So how many values can 64 bits hold?__ (Um... a lot?) &rarr;
* {:.fragment} 2 to the power of 64!  About 18 with 18 0's after it. __However, this doesn't exactly indicate what numbers can be stored. Why?__ &rarr;
* {:.fragment} This just means that number of possible values.  This has to include negative numbers, decimals, etc...
	* __52 bits__ for the value or _fraction_ ([er really](http://www.2ality.com/2012/04/number-encoding.html) [53](http://www.jibbering.com/faq/#FAQ4_7))
	* used to represent both integers and real numbers
	* __11 bits__ for the exponent
	* __1 bit__ for the sign
	{:.fragment}
</section>

<section markdown="block">
## And Why Does That Matter?

* __integers__ are considered to be reliable up to about 15~16 digits &rarr;
<pre><code data-trim contenteditable>
> Math.pow(2,53)
> 9007199254740992
9007199254740992
> 9007199254740993
9007199254740992
</code></pre>
* for __floating point numbers__ ([which are _difficult_ to represent!](http://floating-point-gui.de/))
	* if you need precise floating point / decimal point behavior, use a special data type, like [BigDecimal](https://github.com/dtrebbien/BigDecimal.js), otherwise <code>0.1 + 0.2 // ????</code>&rarr; 
	* use rounding and number formatting if you're just concerned about display - maybe [toPrecision](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Number/toPrecision)
	* use integers!
* apparently, [numbers](http://www.hunlock.com/blogs/The_Complete_Javascript_Number_Reference) are [tricky](http://stackoverflow.com/questions/1458633/elegant-workaround-for-javascript-floating-point-number-problem)
</section>

<section markdown="block" data-background="#440000">
## Floating Point Operations May Yield Unexpected Results!
</section>

<section markdown="block">
## Operators

* Using operators with values as operands yields values!
* We've learned one operator so far... __what was it?__ &rarr;
* We're familiar with some numeric operators (just because we've seen them in other languages, and - _you know_, math) ... __what are they?__ &rarr;
</section>


<section markdown="block">
## Numeric Operators

A quick list of __binary__, __infix__ arithmetic operators (they take two operands, one on each side of the operator):

* __+__ - addition
* __-__ - subtraction
* __\*__ - multiplication
* __/__ - division
* __%__ - modulo (__what does this do?__)
* {:.fragment} (remainder) &rarr;
* {:.fragment} __check out these operations in the node REPL__ &rarr;
</section>

<section markdown="block">
## Numeric Operators, Precedence

__What order would I evaluate this in?  What is the resulting value?__ &rarr;

<pre><code data-trim contenteditable>
4 + 1 * 5
</code></pre>

* remember _PEMDAS_? (modulo is the same precedence as multiplication)
* multiplication first
* then addition
* result is 9
* you can find more about [operator precedence here](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Operator_Precedence#Table)
{:.fragment}

</section>

<section markdown="block">
## Use Parentheses Liberally

* parentheses allow grouping
* [grouping operation](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Grouping) has highest precedence (always goes first)

<pre><code data-trim contenteditable>
// force addition first
(4 + 1) * 5
</code></pre>
</section>

<section markdown="block">
## More Number Operators

A couple more operators - these are __prefix__, __unary__ operators that yield numbers:

* __+__ - convert to positive number
* __-__ - convert to negative number
* __let's try them out__ &rarr;

<pre><code data-trim contenteditable>
+12
-12
-"12"
+"12"
-true
</code></pre>

Note that they work on non-number types as well! __These operators can be used to convert strings to numbers.__
{:.fragment}
</section>

<section markdown="block">
## Bitwise Operators

__What do you think the following operators do?__ &rarr;

<pre><code data-trim contenteditable>
2 & 3 // 10 & 11
7 ^ 3 // 111 ^ 011
</code></pre>


* __bitwise AND__ - a __&__ b - returns a one in each bit position for which the corresponding bits of both operands are ones
* __bitwise OR__ - a __\|__ b - returns a one in each bit position for which the corresponding bits of either or both operands are ones
* __bitwise XOR__ - a __^__ b returns a one in each bit position for which the corresponding bits of either but not both operands are ones
* __bitwise NOT__ - __~__ a - inverts the bits of its operand
{:.fragment}


<br>Note... bitwise operators work in 32 bits (even though numbers are stored in 64)
{:.fragment}
</section>

<section markdown="block">
## More Bitwise Operators

__What do you think the following operators do?__ &rarr;
<pre><code data-trim contenteditable>
2 << 3 // 10 << 11
</code></pre>

* __left shift__ - a __&lt;&lt;__ b - shifts a in binary representation b (< 32) bits to the left, shifting in zeros from the right.
* __sign-propagating right shift__ - a __&gt;&gt;__ b - shifts a in binary representation b (< 32) bits to the right, discarding bits shifted off.
* __zero-fill right shift__ a __&gt;&gt;&gt;__ b - shifts a in binary representation b (< 32) bits to the right, discarding bits shifted off, and shifting in zeros from the left. 
{:.fragment}
</section>

<section markdown="block" data-background="#440000">
## Bitwise operators treat their operands as a sequence of 32 bits!

</section>

<section markdown="block">
## Some Special Numbers...

__Try the following operations...__ &rarr;
<pre><code data-trim contenteditable>
0/0
9e300 * 25874481
</code></pre>

* {:.fragment} JavaScript has some special number values:
	* __NaN__ (_Not a Number_) - this results from any numeric operation that doesn't give back a meaningful result...
	* __Infinity, -Infintity__ - positive and negative infinities 
	{:.fragment}
</section>

<section markdown="block">
## About NaN and Infinity

__Both Nan and Positive/Negative Infinity are of type number!__ &rarr;

* __NaN__ stands for _not a number_
	* <code>NaN</code> is _toxic_ 
	* using it in any other numeric operations __always results in NaN__ &rarr;
	* <code>NaN + 1</code> &rarr;
* __Infinity, -Infinity__
	* __Infinity__ <code> + 1</code> or __Infinity__ <code>+</code> __Infinity__&rarr; is still <code>Infinity</code>
	* <code>Infinity</code> represents all values greater than 1.79769313486231570e+308
</section>

<section markdown="block">
## Strings

A __string__ is an ordered sequence of [Unicode](http://unicodesnowmanforyou.com/) characters (__what's Unicode?__ &rarr;).  You can tell that a value is a string if it is surrounded by single or double quotes:

<pre><code data-trim contenteditable>
'I am a string'
"I'm a string too!"
</code></pre>

</section>

<section markdown="block" data-background="#440000">
## Quoted text is a string!
</section>


<section markdown="block">
## Strings Continued

A __string__ can be composed of _any_ characters: numbers, letters, punctuation, spaces, etc.

The following is a string with nothing in it... or an _empty string_:

<pre><code data-trim contenteditable>
""
</code></pre>

</section>

<section markdown="block">
## Escape Characters

If there is a backslash in a string (\\), that means:

* the next character has a special meaning
* the initial backslash will not be printed out

For example, __\\n__ is a newline
<pre><code data-trim contenteditable>
"\n"
</code></pre>

For example, __\\t__ is a tab
<pre><code data-trim contenteditable>
"\t" 
</code></pre>

</section>


<section markdown="block">
## I Heard You Like Backslashes

__How would we put a double quote in a double quoted string?__ &rarr;

<pre><code data-trim contenteditable>
"\""
</code></pre>
{:.fragment}

__And what about an _actual_ backslash?__ &rarr;
{:.fragment}

<pre><code data-trim contenteditable>
"\\"
</code></pre>
{:.fragment}

</section>

<section markdown="block">
## String Operators

__string concatenation__, or __+__, is an operator that takes two strings and joins them:

<pre><code data-trim contenteditable>
"hello " + "there"
</code></pre>
</section>

<section markdown="block">
## Booleans

A __boolean__ is a data type that has two possible values: <code>true</code> or <code>false</code>.

As one would expect, the literals for these values are (all lowercase):

<pre><code data-trim contenteditable>
true
false
</code></pre>
</section>

<section markdown="block">
## Logical Operators

__Boolean__ values can be combined and manipulated using logical operators.  __What are some logical operators, and what do they do?__ &rarr;

* {:.fragment} __and__ - __&&__ - returns true if and only if both operands are true, otherwise, returns false
* {:.fragment} __or__ - __\|\|__ - returns false if and only if both operands are false, otherwise, returns true
* {:.fragment} __not__ - __!__ - returns the opposite boolean value of its single operand to the right
</section>

<section markdown="block">
## Logical Operators Continued, Precedence

__What do the following boolean expressions return?__

<pre><code data-trim contenteditable>
false && true
false || true
false || !true
</code></pre>
{:.fragment}

<pre><code data-trim contenteditable>
false
true
false
</code></pre>
{:.fragment}

<br> The operator precedence for logical operators is __not__, __and__, and __or__.
{:.fragment}

</section>

<section markdown="block">
## Ternary Operator

__What will this code return?__

<pre><code data-trim contenteditable>
true ? "ok" : "not ok!"
</code></pre>

* {:.fragment} "ok"
* {:.fragment} format is <code>test</code> (boolean expression) __?__ <code>value</code> to return if true __:__ <code>value</code> to return if false


</section>
<section markdown="block">
## Comparison Operators

__Booleans__ can be produced from comparison operators. Without knowing anything about JavaScript, __what do you think are some available comparison operators?__ &rarr;

* {:.fragment} __<__, __>__, __<=__, __>=__ - greater than, less than, etc.
* {:.fragment} __===__ - equals, checks both type and value
* {:.fragment} __==__ - equals, coerces operands to appropriate types
* {:.fragment} __!=__ - not equals
</section>

<section markdown="block">
## Comparison Operators Continued

__Comparison Operators__ are __binary__ , __infix__ operators that can be used to compare two operands:

* __numbers__ are obvious: <code>5 > 2</code> &rarr;
* __strings__ are compared from left to right (by character code): <code>"aardvark" > "bison"</code> (more or less, _alphabetic_) &rarr;
* __NaN__ is the only value not equal to itself &rarr;
* __You'll probably always want to use ===__ &rarr;

</section>


<section markdown="block">
## undefined and null

* __undefined__ is the value given when there's no meaningful value to give back 
	* think of a function that doesn't return a value
	* or the value of an initialized variable (a variable is declared, but has no value)
	* undefined itself is a type &rarr;
* __null__ is a value that can be assigned to a variable to represent no value
* __undefined__ and __null__ are essentially interchangeable (their subtle difference is an accident of language design!) 
</section>

<section markdown="block">
## Type Coercion

__What values would you expect from the following lines of code?__ &rarr;

<pre><code data-trim contenteditable>
5 + 5
"5" + 5
"five" + 5
5 == "5"
5 === "5"
5 * undefined
5 * null
</code></pre>

<pre><code data-trim contenteditable>
10
'55'
'five5'
true
false
NaN
0
</code></pre>
{:.fragment}
</section>

<section markdown="block">
## Type Coercion Continued

* __JavaScript__ is a __dynamic__ and __weakly__ typed language.
* It often goes out of its way to make sure that operators and functions work, regardless of what types are given as operands or arguments.
* It will try to __coerce__ types into other types to make operators and functions _work_.
</section>

<section markdown="block">
## Type Coercion With Numeric Operators

* for __addition__:
	* when one operand is a string and the other is not, the other operand is converted into a string, and the two strings are concatenated
	* for all other cases, the operands are converted to numbers
		* true &rarr; 1
		* false &rarr; 0
		* null &rarr; 0
		* undefined is still undefined, and result gives back __NaN__
* for other numeric operators, such as __subtraction__:
	* will usually try to convert to number (similar to above)
	* if something cannot be converted easily (like the string, "hello"), NaN is given
</section>

<section markdown="block">
## Type Coercion With Equality Operators

* JavaScript will do its best to convert types so that they can be checked for equality - __these all return true__ &rarr;
	* <code>"10" == 10</code>
	* <code>0 == false</code>
	* <code>"" == false</code>
* Usually an unwanted behavior; __to avoid this, use: === and !==__
	* these operators check __type__ and __value__ 
	* use these three-character comparison operators to prevent unexpected type conversions 
</section>


<section markdown="block" data-background="#440000">
## Use === Instead of ==

</section>


<section markdown="block">
## Order of Operations

All of those operators! What goes first again!?  ([Check out operators precedence here.](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Operator_Precedence#Table))

A quick summary:

* __parentheses__
* __unary operators__ like logical NOT, typeof and negative
* the rest of P<strong>EMDAS</strong> (number, string operators) - left to right if same precedence
* __bitwise shift__ operators
* __comparison operators__ - left to right
* __equality operators__ - left to right
* __remaining logical operators__ - and, or - left to right
* __other bitwise operators__ - bitwise and, bitwise or - left to right

<br>
</section>

