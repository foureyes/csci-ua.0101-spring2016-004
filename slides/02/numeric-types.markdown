---
layout: slides
title: "Numeric Types and Operators"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
## Numeric Data Types

There are six primitive types that are numeric:

* __byte__: from -2^7 to 2^7 - 1 (-128 to 127), _8 bits_
* __short__: from -2^15 to 2^15 - 1 (-32768 to 32767), _16 bits_
* __int__: from -2^31 to 2^31 - 1, _32 bits_
* __long__: from -2^63 to 2^63, _64 bits_
* __float__: _32 bit_ floating point number
* __double__: _64 bit_ floating point number

Note their range and storage size! When a variable is created with a specific type, it takes up that much memory!

</section>

<section markdown="block">
## Integers

__What's an integer?__ &rarr;

* {:.fragment} a negative or positive whole number
* {:.fragment} __what are four primitive types in Java that represent an integer?__ &rarr;
	* {:.fragment} byte, short, int, long
	* {:.fragment} __explain why a byte (8 bits) only goes up to 127 rather than 255__ 
	* {:.fragment} it's a _signed_ integer (positive and negative)

</section>

<section markdown="block">
## Floating Point Numbers

__What's a floating point number?__ &rarr;

* {:.fragment} a _real_ number or just a number with a decimal point!
* {:.fragment} there are two primitive types for floating point numbers... __what are they?__ &rarr;
	* {:.fragment} float
	* {:.fragment} double
	* {:.fragment} we'll generally use double

</section>

<section markdown="block">
## Numeric Operators

Numeric data types can be used with the following operators:

* __+__ - addition
* __-__ - subtraction
* __*__ - multiplication
* __/__ - division
* __%__ - modulo

</section>

<section markdown="block">
## Mixing Numeric Types and Operators

* when both operands are integers, the result of the division is an integer with the fractional part truncated (__not rounded__)
* for floating point division, one of the operands must be a floating point number
* modulo works with floating point numbers! (you can get a floating point remainder)

</section>

<section markdown="block">
## Numeric Operators

__What's the output of the following program?__ &rarr;

<pre><code data-trim contenteditable>
System.out.println(5 / 2);
System.out.println(5 / -2);
System.out.println(5 / 2.0);
System.out.println(5 % 2);
System.out.println(5.5 % 2);
</code></pre>
<pre class="fragment"><code data-trim contenteditable>
2
-2
2.5
1
1.5
</code></pre>

</section>

<section markdown="block">
## For Exponents...

<pre><code data-trim contenteditable>
Math.pow(base, exponent)
</code></pre>

<pre><code data-trim contenteditable>
Math.pow(2, 8) // gives us 256
</code></pre>
</section>

<section markdown="block">
## Area of a Circle

__Write a program that prints out the area of a circle that has a radius of 4__ &rarr;

* try using <code>Math.pow</code>
* you don't have to use variables

<pre class="fragment"><code data-trim contenteditable>
public class AreaCircle {
	public static void main(String[] args) {
		System.out.println(3.14 * Math.pow(4, 2));
	}
}
</code></pre>
</section>

<section markdown="block">
## Integer Literals

Besides our usual base-10 whole numbers, integer literals can be written as binary, octal, or hexadecimal...

* prefix with __0b__ for binary (base 2)
* prefix with __0__ for octal (base 8)
* prefix with __0x__ for hexadecimal (base 16)

__By the way, how do these numbering systems work__ &rarr;

* {:.fragment} each place represents that base to a power, with the 0th power as the least significant digit, and incrementing to the left
* {:.fragment} example binary 0010 is 1 * 2^1 = 2
* {:.fragment} for base 16, a-f represents 10-16

</section>

<section markdown="block">
## Integer Literals Continued

__What's the output of the following code?__ &rarr;

<pre><code data-trim contenteditable>
System.out.println(0b0101);
System.out.println(00107);
System.out.println(0x002a);
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
5
71
42
</code></pre>

</section>

<section markdown="block">
## Scientific Notation

Scientific notation can be expressed as:

<pre><code data-trim contenteditable>
12.3e+2
// 12.3 * 10^2
12.3e-2
// 12.3 * 10^-2
</code></pre>

__What values do the above lines represent?__


<pre class="fragment"><code data-trim contenteditable>
1230.0
0.123
</code></pre>

</section>

<section markdown="block">
## Operator Precedence

Similar to PEMDAS:

* parentheses first
* multiplication, division, modulo next (from left to right)
* addition and subtraction last (from left to right)

__What will the following print out?__ &rarr;

<pre><code data-trim contenteditable>
System.out.println(5 + 2 * 6 / 4);
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
8
</code></pre>
</section>

