---
layout: slides
title: Coercion (Revisited), Casting, Undefined, and Some Style
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

</section>

<section markdown="block">
## Coercion Rules

__What are the values that result from the following expressions?__&rarr;

<pre><code data-trim contenteditable>
"5" + 5
false + 5
undefined + 5
"10" > 5
NaN > 5
undefined > 5
</code></pre>

The results: 
{:.fragment}

* <code>"55"</code>
* <code>6</code>
* <code>NaN</code>
* <code>true</code>
* <code>false</code>
* <code>false</code>.
{:.fragment}

<br>
How do we know? We can read the [ECMA](http://es5.github.io/#x11.6.1) [Script](http://es5.github.io/#x9.3) [Specifications](http://es5.github.io/#x11.8)!
{:.fragment}

</section>

<section markdown="block">
## Ugh That's Kind of Crazy

### A quick summary of all of that automatic conversion business.

* __when adding values__
	* if either of the values is a string, coerce the other to perform string concatenation
	* otherwise convert both sides to numbers (if they aren't already) and perform addition
* __when comparing values with &lt;__
	* try to convert both sides to numbers first, so that comparison can be easily performed
	* if either operand is NaN, the result is False
* __when it doubt, check the spec__ (or, of course [SO](http://stackoverflow.com/questions/14687876/how-do-the-javascript-relational-comparison-operators-coerce-types) it)
</section>

<section markdown="block">
## Equality

As you know, this automatic type conversion continues on with <code>==</code>...

__How do we get out of this mess? (without having to remember a series of obscure rules)__ &rarr;

<div markdown="block" class="img">
![yarn tangle](http://yarnob1.yarnobsession.netdna-cdn.com/wp-content/uploads/2013/04/iStock_000003616881XSmall.jpg)
</div>	


* one way is to use triple equals - <code>===</code> (we've gone over this before!)
* another way is to just explicitly _cast_ your operand(s) to minimize surprises
{:.fragment}
</section>

<section markdown="block">
## Casting

We can use __object contructors__ to cast from one type to another: 

* constructors wrap their primitive types in an object (we'll discuss objects later)
* when asked for a value, these objects usually yield the value of their primitive type
* however, we should probably avoid these for the time being; they're a bit complicated
* for example... try this!

<pre><code data-trim contenteditable>
Boolean(false)
new Boolean(false)
Boolean(new Boolean(false))
new Boolean(new Boolean(false))

// WHAT!? (sad face)
</code></pre>

__Let's not deal with the intricacies of using new, not using new, objects vs primitives, etc. ... for now__
</section>

<section markdown="block">
## Casting Continued

Another option is to use some of the __operators__ that we learned to coax JavaScript into doing a predictable automatic conversion for us:

* __convert to a boolean__
	* use _not_ twice (negate the not, but preserve the type conversion)
	* <code>!!"hello"</code>
* __convert to a number__
	* use unary <code>+</code>
	* <code>+"5"</code>
	* <code>+"hello"</code>
* __convert to a string__
	* just add an empty string to it
	*  <code>5 + ""</code>

<br>
See [this page](http://bonsaiden.github.io/JavaScript-Garden/#types.casting) on type casting.
</section>

<section markdown="block">
## Checking for undefined 

Undefined (and also null) means __the absence of a _meaningful_ value__.

How would you check if a value is __undefined__? __The two ways to do this are__: &rarr;

* {:.fragment} <code>if (typeof myVar == 'undefined')</code>
	* {:.fragment} preferred, handles undeclared variables
* {:.fragment} <code>if (myVar == null)</code>

<br>
(this may be the only time that <code>==</code> would come in handy)
{:.fragment}


</section>
<section markdown="block">
## Checking for NaN

Use the isNaN function to determine if a value is __not a number__.

__(comparing NaN to itself always yields false)__ &rarr;

<pre><code data-trim contenteditable>
NaN == NaN
NaN === NaN

// false
// false
// weird, eh?
</code></pre>
</section>
<section markdown="block">
## Some Style

The previous material in this set of slides are about general best practices. Not adhering to them may:

* result in your code yielding unexpected results
* difficult to understand / non-standard code

<br>
__The next few suggestions, however, are purely stylistic - just about how code is formatted:__ &rarr;

<div markdown="block" class="img">
![poochie](http://i.kinja-img.com/gawker-media/image/upload/s--ZbZrlXcj--/xnfzofkxpckzxbkqxnbq.jpg)
</div>

</section>
<section markdown="block">
## Style Continued

* use 1TBS, __One True Brace Style__: open curly brace on same line of code as last line preceding the current block of code / statement header (not on a new line)
<pre><code data-trim contenteditable>
if (some_boolean_expression) { // <-- curly brace here!
	// do stuff
}
</code></pre>
* use camel case to separate words in identifiers / variables names: <code>myVerboseVariableName</code>
* remember to indent blocks of code!
</section>

<section markdown="block">
## Summary

* __automatic type conversion is tricky__; sometimes it's helpful to check the specks or stackoverflow
* you can get around automatic type conversion (if that's desirable) by __casting__ - use operators like <code>!!</code>, <code>+</code>, <code>+ ""</code>
* to __check for undefined__: <code>if(typeof myVar == 'undefined')</code>
* to __check for NaN__: <code>isNan(myVar)</code>
</section>
