---
layout: slides
title: "Formatting Output"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>
<section markdown="block">
## Formatting Console Output

Use __printf__!:

<pre><code data-trim contenteditable>
System.out.printf(formatString, thingToPrint1, thingToPrint2, ... thingToPrintN);
</code></pre>

* it will allow you to use a format string to specify the output format of what you're printing
* and it allows for the printing of multiple arguments... that are placed in to the formatString
* think of formatString as a template, and the remaining values as the items that are put into the template

</section>

<section markdown="block">
## Format String

Ok... so what's this format string about?

A __format string__ is essentially a template with placeholders for values, with each placeholder specifying how an item should be displayed - as a numeric value, a character, a Boolean value, or a string.

* consists of a percent sign (%) 
* followed by a conversion code
	* __<code>%b</code>__ - boolean
	* __<code>%c</code>__ - character
	* __<code>%d</code>__ - decimal integer
	* __<code>%e</code>__ - scientific notation
	* __<code>%s</code>__ - a string
</section>

<section markdown="block">
## Um. Easier to Show Than Tell

<pre><code data-trim contenteditable>
System.out.printf("$%d", 1);
</code></pre>

* 1 is placed into the format string where %d is
* this should look familiar if you remember string formatting in Python

</section>

<section markdown="block">
## Another More Familiar Example

<pre><code data-trim contenteditable>
int room = 423;
String name = "Joe";
System.out.printf("I'm %s, and my office is in WWH %s", name, room);
</code></pre>

* the variables <code>name</code> and <code>room</code> are put in the placeholders in order
* they are both converted to a string
</section>

<section markdown="block">
## A Few Notes

* the type of a value must match its corresponding specifier 
* (with the exception of %s ....which will convert to a string)
</section>

<section markdown="block">
## Specifying Width


* you can specify the width of the output by placing numbers between the % and the character
* %10s - pad string so that width is 10
* %10.2f - width of 10 on the left of the decimal, 2 on the right

__What's the output of the following code?__ &rarr;

<pre><code data-trim contenteditable>
System.out.printf("%10s\n", "hi");
System.out.printf("%10.2f\n", 2.4);
System.out.printf("%4s\n", "bye");
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
// notice the padding!
        hi
      2.40
 bye
</code></pre>
</section>

<section markdown="block">
## Robot Shop

You own a robot shop (of course). Write a program that sells robots for $100 (what a deal!). 

* ask the user for how much money they have
* only accept their input if they prefix their amount with a dollar sign ($) ... 
* say <code>That's not a dollar amount</code> if they don't include the dollar sign
* otherwise...
	* if the amount they put in is more than $100, say <code>Here's your robot</code>
	* ...but if the amount they put in is less than $100, output the difference with 2 decimal places
* (example output on next slide)

</section>
<section markdown="block">
## Example Output


<pre><code data-trim contenteditable>
Welcome to HAL's robot shop.
A robot will cost you $100
</code></pre>

__You bought it!__

<pre><code data-trim contenteditable>
How much money do you have (please enter $X)?
> $110
Ok ... here's your robot
</code></pre>

__Not enough money!__

<pre><code data-trim contenteditable>
How much money do you have (please enter $X)?
> $2
You need $98.00 more to buy that robot!
</code></pre>

__Didn't prefix with a dollar__

<pre><code data-trim contenteditable>
How much money do you have (please enter $X)?
> 12
That's not a dollar amount!
</code></pre>
</section>


<section markdown="block">
## Pseudocode

* ask for input
* if it starts with a dollar
	* figure out what the dollar amount is...
	* subtract from 100
	* if result is positive
		* they need MOAR MONIEZ
	* otherwise... give 'em the 'bot
* otherwise... don't even do business with the foolish individual

</section>

<section markdown="block">
## Robot Shop Program!

__Adequate, eh?__ &rarr;

<pre><code data-trim contenteditable>
Scanner input = new Scanner(System.in);
System.out.println("Welcome to HAL's robot shop.");
System.out.println("A robot will cost you $100");
System.out.print("How much money do you have (please enter $X)?\n> ");
String answer = input.next();
if (answer.startsWith("$")) {
	int amount = Integer.parseInt(answer.substring(1));
	float difference = 100 - amount;
	if (difference > 0) {
		System.out.printf("You need $%.2f more to buy that robot!", difference);
	} else {
		System.out.println("Ok ... here's your robot");
	}
} else {
	System.out.println("That's not a dollar amount!");
}
input.close();
</code></pre>

</section>
