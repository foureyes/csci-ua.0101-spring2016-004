---
layout: slides
title: "Characters"
---

<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>


<section markdown="block">
## Categories of Types

In Java... there are two broad categories of types. __What are they?__ &rarr;

* {:.fragment} primitive types (primitives)
* {:.fragment} reference types (objects)

<span class="fragment">So far, we've been looking at primitive types.</span>

</section>

<section markdown="block">
## Primitive Types

We know 7 out of 8 primitive types. __What are they?__ &rarr;

* {:.fragment} __byte__ - _8 bit_ signed integer
* {:.fragment} __short__ - _16 bit_ signed integer
* {:.fragment} __int__ - _32 bit_ signed integer
* {:.fragment} __long__ - _64 bit_ signed integer
* {:.fragment} __float__ - _32 bit_ floating point number
* {:.fragment} __double__ - _64 bit_ floating point number
* {:.fragment} __boolean__ - true or false (intuition says this should only be 1-bit, but it's actually __unspecified!__)

<span class="fragment">__Why does the size of a primitive data type matter?__ &rarr;</span>

<span class="fragment">(the size determines the range of values that the type can hold... as well as how much space it will take up in memory!)</span>
</section>

<section markdown="block">
## Woo! Last Primitive Type

A __char__ represents a single character.

* the actual type name is... <code>char</code>
* a char is __16-bits__ <span class="fragment">...2^16, (65,536) possible characters)</span>
* __a literal <code>char</code> is enclosed in single quotes__
* examples:

<pre><code data-trim contenteditable>
// notice that we're using single quotes!

char myLetter = 'J';
char myNumber = '4';
</code></pre>
</section>

<section markdown="block">
## Unicode Characters

Again - __in order to store symbols or characters__ &rarr;

* {:.fragment} a computer can store a number that represents that character or symbol
* {:.fragment} there are various schemes that allow for the encoding of symbols into numbers
* {:.fragment} one of these schemes is __Unicode__
	* {:.fragment} the older, original version of unicode used 16-bits to store characters
	* {:.fragment} though... its current incarnation can support over a million characters!

<span class="fragment">__The characters in the original version of Unicode can be stored in Java's char data type.__</span>

</section>

<section markdown="block">
## Representing 16-Bit Unicode Characters

A 16-bit unicode characters can be represented by 4 hexadecimal digits preceded by a <code>\u</code>:

<pre><code data-trim contenteditable>
\u2602
</code></pre>

<span class="fragment">(By the way... that's an umbrella - <code>System.out.println('\u2602')</code>)</span>

<span class="fragment">(And its decimal value is 9,730)</span>

</section>

<section markdown="block">
## Hexadecimal Numbers

__Wait. How do hexadecimal numbers work again?__ &rarr;

* {:.fragment} base 16
* {:.fragment} numbers 10-15 are represented by A-F
* {:.fragment} least significant is number of 16^0... then 16^1, etc.
* {:.fragment} so ... 4 hexadecimals numbers: 4096's, 256's, 16's, 1's 
* {:.fragment} <code>\u2602</code> = 2 * 4096 + 6 * 256 + 0 * 16 + 2 * 1 = 9730

</section>

<section markdown="block">
## Alphanumeric Characters

Unicode representation of alphanumeric characters (in __decimal__ and as __unicode__):

* __numbers__ ('0' to '9'): 48 to 57 or \u0030 to \u0039
* __uppercase letters__ ('A' to 'Z'): 65 to 90 or \u0041 to \u005A
* __lowercase letters__ ('a' to 'z'): 97 to 122 or \u0061 to \u007A

</section>

<section markdown="block">
## A Short Quiz

__What's character does the following decimal number represent?__ &rarr;

* 65 <span class="fragment">&rarr; A</span>
* 66 <span class="fragment">&rarr; B</span>
* 90 <span class="fragment">&rarr; Z</span>
* 97 <span class="fragment">&rarr; a</span>

</section>

<section markdown="block">
## What's that Backslash About?

__Does anyone remember what the backslash character is for?__ &rarr;

* {:.fragment} it's used to signify the start of an __escape sequence__
* {:.fragment} an __escape sequence__ is a sequence of characters beginning with a backslash... that represents _some special character_
* {:.fragment} (usually, that character has a special meaning, like double quote, or backslash... so it should be escaped if you want that literal character)
* {:.fragment} symbols in an escape sequence are interpreted as a whole rather than individually
* {:.fragment} an escape sequence is considered as a single character
</section>

<section markdown="block">
## Common Escape Sequences

__Let's try a few of these out (do you know any?).__ &rarr;

* {:.fragment} __\u0000__ - a unicode character (we just saw this)
* {:.fragment} __\n__ - newline
* {:.fragment} __\t__ - tab
* {:.fragment} __\"__ - double quote
* {:.fragment} __\\__ - backslash

</section>

<section markdown="block">
## Casting an Int to Char

* uses int to map to corresponding unicode character
* __only lower 16-bits are used!__
* <code>char ch = (char) 0xAB0041;</code>
* (only uses 0041, which is 65)
* __let's see this at work__ &rarr;
</section>	

<section markdown="block">
## Casting a Float to Char

* converts __float__ to __int__ first (truncates)
* then converts int to char
* __what character would be in ch... <code>char ch = (char) 65.9;</code>__ &rarr;
* {:.fragment} 65 &rarr; 'A'

</section>

<section markdown="block">
## Char to Numeric Type

__Explictly casting a char to a numeric type yields the unicode code point of that character!__ &rarr;

__What is the output of the following code?__ &rarr;

<pre><code data-trim contenteditable>
int i = (int) 'C';
System.out.println(i);
</code></pre>

<span class="fragment">67</span>

</section>

<section markdown="block">
## Implicit Casting

__You can also just set a character equal to an int, if it _fits_ ...__ &rarr;

<pre><code data-trim contenteditable>
// totally fine to drop the int
int i = 'C';
System.out.println(i);
</code></pre>

</section>

<section markdown="block">
## Implicit Casting Continued

__Can you think of a situation where implicit casting may not work?__ &rarr;

<span class="fragment">__What's the size of a char?__ &rarr;</span>

<span class="fragment">16-bits... __Are there numeric types smaller than 16 bits?__ &rarr;</span>

<span class="fragment">bytes! &rarr;</span>

<pre class="fragment"><code data-trim contenteditable>
// let's try this odd character (it corresponds to 65524, which can't fit in 8 bits, right?)
System.out.println('\uFFF4'); // weird character
int i = '\uFFF4' // ok!
byte b = '\uFFF4' // nooooope
</code></pre>

<span class="fragment">__You get an error!__</span>

<span class="fragment">(You can force this by casting explicitly, but you have to deal with some [narrowing](http://stackoverflow.com/a/9085666))</span>
</section>

<section markdown="block">
## Notes on Casting and Operators

* any positive integer between 0 and FFFF in hexadecimal can be cast into a character implicitly
* all numeric operators can be applied to char operands
	* a char operand is automatically cast into a number if the other operand is a number or a character
	* if the other operand is a string, the character is concatenated with the string
	* __let's try a few of these...__ &rarr;

<pre><code data-trim contenteditable>
int i = 'Z' * 'Z'; // Z is 90 --> 8100
int j = 'b' / 2; // b is 98 --> 49
System.out.println(i);
System.out.println(j);
</code></pre>
</section>

<section markdown="block">
## A Quick Quiz

* <code>System.out.println('A' + 'Z') </code> <span class="fragment"><code>// 155</code></span>
* __What's the type of the above expression?__ &rarr; <span class="fragment">int</span>
* <code>System.out.println(0x0042) </code> <span class="fragment"><code>// 66</code></span>
* <code>System.out.println('\u0042') </code> <span class="fragment"><code>// B</code></span>
</section>

<section markdown="block">
## Comparison Operators

__You can use comparison operators to order characters!__ &rarr;

* first, convert both to unicode code points
* then compare integers!
* <code>'a' < 'b'</code> ... yields true because 'a' is 97 and b is 98
* ...and 97 is less than 98
* <code>'a' == 'a'</code> ... yields true 97 is equal to 97
</section>

<section markdown="block">
## Is it Numeric?

__How would you determine if a character is a number 0 through 9?__ &rarr;

* {:.fragment} '0' to '9' are 48 to 57 
* {:.fragment} so... use a conditional:

<pre class="fragment"><code data-trim contenteditable>
if(ch >= 48 and ch <= 57) {

}
</code></pre>

<span class="fragment">Eh... but that seems like _a lot_ of work. I have to remember _stuff_.</span>


</section>
<section markdown="block">
## The Character Class

Another built-in class (similar to Math) that's available is the __Character__ class:

The character class provides convenience methods for determining casing, whether a character or a digit, etc.

* <code>isDigit(ch)</code>
* <code>isLetter(ch)</code>
* <code>isLetterOrDigit(ch)</code>
* <code>isUpperCase(ch)</code>
* <code>isLowerCase(ch)</code>
* <code>toUpperCase(ch)</code>
* <code>toLowerCase(ch)</code>

All of these are methods called from the __Character__ class. Let's see them in action...


</section>
<section markdown="block">
## Character Methods

__What's the output of the following code?__ &rarr;

<pre><code data-trim contenteditable>
System.out.println(Character.isUpperCase('\u0041'));
System.out.println(Character.isDigit('Z'));
System.out.println(Character.isLetterOrDigit('A'));
System.out.println(Character.toLowerCase('\u0041'));
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
true
false
true
a
</code></pre>
</section>

<section markdown="block">
## And Some More Questions

__What is the output of the following code?__ &rarr;

<pre><code data-trim contenteditable>
char ch = 'g'
System.out.println(ch++);
System.out.println(ch);
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
g // post increment... so g first
h // then h
</code></pre>

<pre><code data-trim contenteditable>
System.out.println('a' <= 'A');
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
false // 'a' is 97... 'A' is 65
</code></pre>
</section>

<section markdown="block">
## Letter of Alphabet

__Write a program that prints out a lowercase character based on input from the user:__ &rarr;

* 1 corresponds to lowercase a
* 26 corresponds to lowercase z
* ignore any other input

<pre><code data-trim contenteditable>
Give me a number; I'll give ya a letter!
> 3
c
Give me a number; I'll give ya a letter!
> 26
z
Give me a number; I'll give ya a letter!
> 100
Whoah - I don't know that letter!
</code></pre>
</section>

<section markdown="block">
## A Potential Solution

<pre><code data-trim contenteditable>
// in main...

// lowercase a starts at 97... so user can enter 1 through 26
final int START = 96;
char ch;
Scanner input = new Scanner(System.in);
System.out.println("Give me a number; I'll give ya a letter!");
int number = input.nextInt();
if(number >= 1 && number <= 26) {
	ch = (char) (START + number);
	System.out.println(ch);
} else {
	System.out.println("Whoah - I don't know that letter!");
}
</code></pre>
</section>
