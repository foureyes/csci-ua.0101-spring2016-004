---
layout: slides
title: "Strings"
---

<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
## Strings

A __string__ is a __sequence__ of characters

* __Strings__ are not a primitive type!
* __Strings__ are a reference type - they're actually objects
* that means you can call methods on an actual String object...
* (we'll discuss that in a little bit)
</section>

<section markdown="block">
## Strings Continued

__A string literal is represented by double quotes.__ &rarr;

* you can specify a variable of type String by using the class name, String... <code>String s = "";</code>
* __what's the difference between a string literal and a char literal?__ &rarr; <span class="fragment">chars use single quotes</span>
* you can use the same escape sequences in strings (\n for newline, \u for unicode character, etc.)
* a character's position within a string is called its index
	* the left most index is 0
	* the right most index is the number of characters in a string - 1
</section>

<section markdown="block">
## String Methods

So... you can call methods on __String objects__:

* <code>length()</code> - returns the number of characters in a string
* <code>charAt()</code> - returns the character at that index (will give an error if index does not exist)
* <code>concat(anotherString)</code> - returns a new string with original string and anotherString put together
* <code>toUpperCase()</code> - returns a new string converted to uppercase
* <code>toLowerCase()</code> - returns a new string converted to lowercase
* <code>trim()</code> - returns a new string with leading and trailing white space removed

</section>

<section markdown="block">
## About String Methods

A few things to note about String methods:

* they're called on the string object itself, not the class
* they return a new string... __they don't change the original string__

</section>
<section markdown="block">
## String Methods Continued

__What's the output of this code?__ &rarr;

<pre><code data-trim contenteditable>
String s = "OH NO!";
System.out.println(s.length());
System.out.println(s.charAt(0));
System.out.println(s.charAt(s.length() - 1));
System.out.println(s.toLowerCase());
System.out.println(s.concat("OK"));

</code></pre>

<pre class="fragment"><code data-trim contenteditable>
6
O
!
oh no!
OH NO!OK
</code></pre>
</section>

<section markdown="block">
## Concatenation / Adding Strings

__There are actually two ways to put strings together:__ &rarr;

* {:.fragment} the .concat(anotherString) method
* {:.fragment} using the + sign (concatenation

<span class="fragment">Note that if one operand is a String, __the + automatically converts the second operand to a String if it isn't already a String!__</span>


</section>
<section markdown="block">
## Reading a String from a Scanner Object

In addition to numeric types, you can read strings from a Scanner object.

Simply call <code>.next()</code>!

For example:

<pre><code data-trim contenteditable>
Scanner input = new Scanner(System.in); 
System.out.print("Enter two words separated by a space: "); 
String s1 = input.next();
String s2 = input.next();
System.out.println("s1 is " + s1);
System.out.println("s2 is " + s2);
</code></pre>
</section>
<section markdown="block">
## Comparing Strings

Unfortunately, you can't use regular comparison operators to compare strings. __Instead, you'll have to rely on the following methods:__ &rarr;

* <code>equals(s1)</code> - returns true if this string is equal to string s1.
* <code>equalsIgnoreCase(s1)</code> - returns true if this string is equal to string s1; it is case insensitive.
* <code>compareTo(s1)</code> - returns an integer greater than 0, equal to 0, or less than 0 to indicate whether this string is greater than, equal to, or less than s1
* <code>compareToIgnoreCase(s1)</code> - same as compareTo except that the comparison is case insensitive.

</section>

<section markdown="block">
## Aaaaand More Methods

* <code>startsWith(prefix)</code> - returns true if this string starts with the specified prefix.
* <code>endsWith(suffix)</code> - returns true if this string ends with the specified suffix.
* <code>contains(s1)</code> - returns true if s1 is a substring in this string.
</section>

<section markdown="block">
## Converting to and From Strings

To convert to a string... you can add an empty string to an int!

<pre><code data-trim contenteditable>
String s = 5 + "";
System.out.println(s);
</code></pre>

You can also use Integer.toString(someInt)

<pre><code data-trim contenteditable>
Integer.toString(5)

</code></pre>
</section>

<section markdown="block">
## Password

__Write a program that asks the user to create and confirm a passowrd__ &rarr;

* the password must begin and start with the same letter (terrible requirements)
* if it doesn't, the program ends immediately - <code>Sorry, your password did not meet the requirements!</code>
* if it meets the requirements... then ask them to confirm the password
* if the confirmation doesn't match - <code>Oops, your passwords do not match!</code>
* if the confirmation and password to match - <code>Your password is set</code>
* example output in next slide

</section>

<section markdown="block">
## Password Example Output

<pre><code data-trim contenteditable>
Enter a password
> toot
Please confirm your password...
> toot
Your password is set
</code></pre>

<pre><code data-trim contenteditable>
Enter a password
> food
Sorry, your password did not meet the requirements!
</code></pre>
</section>

<section markdown="block">
## Potential Implementation Part 1

<pre><code data-trim contenteditable>
Scanner input = new Scanner(System.in);
String password = "", confirmation = "";
System.out.println("Create a password that begins and ends with same letter");
System.out.println("(These are terrible requirements)");
System.out.print("Enter a password\n> ");

</code></pre>

</section>

<section markdown="block">
## Potential Implementation Part 2

<pre><code data-trim contenteditable>
password = input.next();
if (password.charAt(0) == password.charAt(password.length() - 1)) {
	System.out.print("Please confirm your password...\n> ");
	confirmation = input.next();
	if(confirmation.equals(password)) {
		System.out.println("Your password is set");
	} else {
		System.out.println("Oops, your passwords do not match!");
	}
} else {
	System.out.println("Sorry, your password did not meet the requirements!");
}
input.close();

</code></pre>
</section>

<section markdown="block">
## Random Card

Generate a random card from a regular 52 card deck:

* the face can be A, 2 - 9, J, Q, K
* the suit can be hearts, diamonds, clubs and spades
* you can use the following unicode symbols if you want to be fancy...
	* <code>\u2660</code>
	* <code>\u2665</code>
	* <code>\u2666</code>
	* <code>\u2663</code>

Example output:

<pre><code data-trim contenteditable>
Shuffling the deck!
Your card is... 6♦
</code></pre>
</section>

<section markdown="block">
## Some Solutions

One of these is clearly better than the others...

* use 52 else-ifs(!)
* use switch with 52 cases
* generate a random face, then generate  a random suit

__[Do this for homework #3!](../../assignments/hw03.html)__

</section>
