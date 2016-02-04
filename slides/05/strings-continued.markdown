---
layout: slides
title: "Strings Continued"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>




<section markdown="block">
## String Methods

What are some String methods that we looked at?

* {:.fragment} __<code>length()</code>__ -  Returns the number of characters in this string.
* {:.fragment} __<code>charAt(index)</code>__ -  Returns the character at the specified index from this string.
* {:.fragment} __<code>concat(s1)</code>__ -  Returns a new string that concatenates this string with string s1.
* {:.fragment} __<code>toUpperCase()</code>__ -  Returns a new string with all letters in uppercase.
* {:.fragment} __<code>toLowerCase()</code>__ -  Returns a new string with all letters in lowercase
* {:.fragment} __<code>trim()</code>__ -  Returns a new string with whitespace characters trimmed on both sides.
</section>

<section markdown="block">
## About String Methods

The String methods from the previous slides:

* are called from String objects 

<pre><code data-trim contenteditable>
String s = "hello";
System.out.println(s.toUpperCase());
</code></pre>

* __always return a new string, and does not modify the original__
* __what is the output of the code below?__ &rarr;

<pre><code data-trim contenteditable>
String s = "hello";
System.out.println(s.toUpperCase());
System.out.println(s);
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
HELLO
hello
</code></pre>
</section>

<section markdown="block">
## length and charAt

A __string__ is a sequence of characters.

* use the <code>length()</code> method on a string object to get the number of characters
* a character's __index__ is that character's position in a string
	* __what index is the left most, or 1st, character?__ &rarr; <span class="fragment">0</span>
	* __what index is the right most, or last, character?__ &rarr; <span class="fragment">s.length() - 1</span>
</section>

<section markdown="block">
## Concatenation

__What are the two ways that we can put together strings... and what's the difference between the two?__ &rarr;

* {:.fragment} __+__ ... will convert other operand to String if either operand is a String
* {:.fragment} <code>concat(otherString)</code> ... error if argument passed in is not a String
* {:.fragment} __Let's see this in action...__ &rarr;
</section>

<section markdown="block">
## Upper, Lower, Trim

__What's the output of this code?__ &rarr;

<pre><code data-trim contenteditable>
String s1 = "    SPACES!    ";
String s2 = s.toLowerCase();
String s2 = s.trim();
System.out.println(s);
System.out.println(t);
System.out.println(u);
</code></pre>

</section>

<section markdown="block">
## A Quick Exercise - Next Letter

__Write a program that:__ &rarr;

* asks for a single character
* ...and prints out the next letter 
* (if the input is <code>"n"</code>, it would print out <code>"o"</code>)
* however, if the input is more than one character
* ... say <code>"Hey... that wasn't a single letter"</code>

<pre><code data-trim contenteditable>
Give me a character, I'll give you the next one
> A
The next character is B
</code></pre>

<pre><code data-trim contenteditable>
Give me a character, I'll give you the next one
> abba
Hey... that wasn't a single letter
</code></pre>
</section>

<section markdown="block">
## Pseudocode for Next Letter

* ask for input
* check if it's only one character
* if it's one character
	* convert input to a character
	* add 1
	* convert back to character
* otherwise... print error message
</section>

<section markdown="block">
## Next Letter

A potential solution ...

<pre><code data-trim contenteditable>
Scanner input = new Scanner(System.in);
System.out.print("Give me a character, I'll give you the next one\n> ");
String userInput = input.next();
if (userInput.length() == 1) {
	char ch = userInput.charAt(0);
	System.out.println("The next character is " + (char) (ch + 1));
} else {
	System.out.println("Hey... that wasn't a single letter");
}
input.close();
</code></pre>
</section>

<section markdown="block">
## Reading Strings from the Console Revisited

__What method do we use for reading in a String from a Scanner object (we just used it)?__ &rarr;

* {:.fragment} use <code>next()</code>
* {:.fragment} again, the default delimiter is whitespace
* {:.fragment} the user can enter in two strings on the same line... or press <code>&lt;ENTER&gt;></code> after each

<pre class="fragment"><code data-trim contenteditable>
// an example

Scanner input = new Scanner(System.in);
System.out.print("Name two cities... ");
String city1 = input.next();
String city2 = input.next();
System.out.println("You said \"" + city1 + "\" and \"" + city2 + "\"");
</code></pre>

<pre><code data-trim contenteditable>
Name two cities
> Cairo
Manila
You said "Cairo" and "Manila"
</code></pre>
</section>

<section markdown="block">
## But But But Wait

__Is there a city name that you could enter that would prevent you from entering a second city?__ &rarr;

<span class="fragment">What if you want a String with an actual space, like __"New York"__? __What happens and why?__ &rarr;</span> 

* {:.fragment} the input would be split into your two variables!
* {:.fragment} you would not be able to enter in your second word
* {:.fragment} again, the Scanner, by default, __will break apart your input based on whitespace, which includes spaces and newlines (&lt;RETURN&gt;)__
</section>

<section markdown="block">
## Retrieving the Whole Line as Input

In order to get an entire line as input, including spaces... use your Scanner object's __<code>nextLine</code>__ method.

* <code>nextLine</code> will read a line until a newline
* this forces a user to press &lt;RETURN&gt; after each input
* a slight modification of our two cities exercise:

<pre><code data-trim contenteditable>
Scanner input = new Scanner(System.in);
System.out.print("Name two cities\n> ");
String city1 = input.next();
String city2 = input.next();
System.out.println("You said \"" + city1 + "\" and \"" + city2 + "\"");
</code></pre>
</section>

<section markdown="block">
## String Comparisons Revisited

__How can you test if one string is equal to another?__ &rarr;

* {:.fragment} you can use the <code>equals(otherString)</code> method to test if one String is equal to another
* {:.fragment} if you want to test equality regardless of case, use  <code>equalsIgnoreCase(otherString)</code> 
* {:.fragment} __Don't use ==; it doesn't do what you think?__ &rarr;
	* {:.fragment} == compares if the objects are actually equal
	* {:.fragment} .equals (for Strings) compures string values

<pre class="fragment"><code data-trim contenteditable>
s1 = new String("asdf");
s2 = new String("asdf");
System.out.println(s1 == s2);
</code></pre>
</section>

<section markdown="block" data-background="#440000">
# Use .equals(otherString) to check if two strings are equal!

[This stackoverflow article](http://stackoverflow.com/questions/513832/how-do-i-compare-strings-in-java) explains why in more detail...
</section>

<section markdown="block">
## Display a Secret Message

__Write a quick program that asks the user if they want to see a secret message.__ &rarr;

* if they type in yes in any casing ("YES", "yes", etc.), print "SO MUCH SECRET!"
* otherwise, print "THEN IT WILL REMAIN SECRET!"

<pre><code data-trim contenteditable>
Wanna see a secret message? > Yes
SO MUCH SECRET!
</code></pre>
</section>

<section markdown="block">
## A (SECRET) Solution

<pre><code data-trim contenteditable>
Scanner input = new Scanner(System.in);
System.out.println("Wanna see a secret message?");

String answer = input.next();
if (answer.equalsIgnoreCase("yes")) {
		System.out.println("SO MUCH SECRET");
} else {
		System.out.println("THEN IT WILL REMAIN SECRET");
}
</code></pre>

__(by the way... try changing equalsIgnoreCase to ==... and typing in "yes")__ &rarr;
</section>

<section markdown="block">
## There's also CompareTo

* <code>compareTo(s1)</code> - returns an integer greater than 0, equal to 0, or less than 0 to indicate whether this string is greater than, equal to, or less than s1
* <code>compareToIgnoreCase(s1)</code> - same as compareTo except that the comparison is case insensitive.

Ummm... the book is light on docs for these. However:

* the resulting int is calculated by subtracting the unicode values of the first differing characters (object's unicode value - argument's unicode value)
* ...or by subtracting the lengths (object's length - argument's length), if all characters are the same, but lengths differ

</section>
<section markdown="block">
## CompareTo Examples

__What's the output of the following code?__ &rarr;

<pre><code data-trim contenteditable>
String s = "AZ";
System.out.println(s.compareTo("CZ"));
System.out.println(s.compareTo("A"));
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
-2
1
</code></pre>
</section>

<section markdown="block">
## Testing for Substrings

You can test if one string is a substring (that is all characters in one string can be found in order in another string) by using the following methods:

* __<code>startsWith(prefix)</code>__ - Returns true if this string starts with the specified prefix.
* __<code>endsWith(suffix)</code>__ - Returns true if this string ends with the specified suffix.
* __<code>contains(s1)</code>__ - Returns true if s1 is a substring in this string.
</section>

<section markdown="block">
## Testing for Substrings Example

__What's the output of this code?__ &rarr;

<pre><code data-trim contenteditable>
String name = "Mr. Furrington";
System.out.println(name.startsWith("Mr."));
System.out.println(name.endsWith("Mr."));
System.out.println(name.contains("ring"));
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
true
false
true
</code></pre>
</section>

<section markdown="block">
## Extracting a Substring

Great... you know if a substring is another string. What you want to retrieve a substring?

The method, __substring__ can be used! There are two version of it... one with one argument, the other with 2.

* {:.fragment} __<code>substring(beginIndex)</code>__ - Returns this string's substring that begins with the character at the specified beginIndex and extends to the end of the string
* {:.fragment} __<code>substring(beginIndex, endIndex)</code>__ - Returns this string's substring that begins at the specified beginIndex and extends to the character at index endIndex – 1 (up to, but does not include endIndex)

</section>

<section markdown="block">
## Extracting a Substring Examples

__What's the output of this code?__ &rarr;

<pre><code data-trim contenteditable>
city = "Newton";
System.out.println(city.substring(3));
System.out.println(city.substring(1, 3));
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
ton
ew
</code></pre>
</section>
<section markdown="block">
## Finding a Character or Substring

__indexOf__ returns the first occurrence of a character or substring, or -1 if it isn't found

* {:.fragment} there are actually four ways to use index... based on the arguments that you pass to it
* {:.fragment} __<code>indexOF(ch)</code>__ - Returns the index of the first occurrence of ch in the string. Returns -1 if not matched.
* {:.fragment} __<code>indexOf(ch, fromIndex)</code>__ - Returns the index of the first occurrence of ch after fromIndex in the string. Returns -1 if not matched.
* {:.fragment} __<code>indexOf(s)</code>__ - Returns the index of the first occurrence of string s in this string. Returns -1 if not matched.
* {:.fragment} __<code>indexOf(s, fromIndex)</code>__ - Returns the index of the first occurrence of string s in this string after fromIndex. Returns -1 if not matched.
</section>

<section markdown="block">
## index and indexOf Exxamples

__What's the output of the following code?__ &rarr;


<pre><code data-trim contenteditable>
String city = "Newton";
System.out.println(city.indexOf('w'));
System.out.println(city.indexOf('w', 3));
System.out.println(city.indexOf("ew"));
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
2
-1
1
</code></pre>

</section>

<section markdown="block">
## Additional Methods for Finding Characters and Substrings

So... __indexOf__ finds the first occurrence. If you want the last, obvs, you would use __lastIndexOf__. Again, there are 4 ways to call this method:

* {:.fragment} __<code>lastIndexOf(ch)</code>__ - Returns the index of the last occurrence of ch in the string. Returns -1 if not matched.
* {:.fragment} __<code>lastIndexOf(ch, fromIndex)</code>__
Returns the index of the last occurrence of ch before fromIndex in this string. Returns -1 if not matched.
* {:.fragment} __<code>lastIndexOf(s)</code>__ - Returns the index of the last occurrence of string s. Returns -1 if not matched.
* {:.fragment} __<code>lastIndexOf(s, fromIndex)</code>__ - Returns the index of the last occurrence of string s before fromIndex. Returns -1 if not matched.
</section>

<section markdown="block">
## Converting Strings to and From Other Types

* Integer.parseInt(someString); // returns an integer based on the string passed in
* Double.parseDouble(someString); // returns an integer based on the string passed in

<pre><code data-trim contenteditable>
String s = "1";
int i = Integer.parseInt(s);
</code></pre>

<span class="fragment">(There's also a two parameter version, that includes the base - called radix - <code>int i = Integer.parseInt("FFFF", 16);</code>)</span>
</section>

<section markdown="block">
## Password

(from the previous slides, but modified)

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
