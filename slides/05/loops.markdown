---
layout: slides
title: "Loops"
---

<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
## Loops

__YOU KNOW THIS.__

Loops allow you to repeat a block of code.

* that "Welcome to Java" x 5 thing in the first assignment was silly
* programmers are lazy - why would you ever type that out 5 times?
* so. loops.

</section>

<section markdown="block">
## While

A __while__ loop executes statements within its body (within curly braces) __as long as the condition, the boolean expression, is true__.

<pre><code data-trim contenteditable>
while (boolean_expression) {
	// block of code to repeat
}
</code></pre>
</section>

<section markdown="block">
## While Example

__Print out the numbers 1 through 10 using a while loop.__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
int currentValue = 1, endValue = 10;
while(currentValue <= endValue) {
	System.out.println(currentValue);
	currentValue++;
}
</code></pre>

</section>

<section markdown="block">
## Do While

A __do while__ loop executes the body first... then checks the condition. 

<pre><code data-trim contenteditable>
do {
	// block of code to repeat
} while (boolean_expression);

</code></pre>


</section>
<section markdown="block">
## Do While Example

__Try counting from 1 to 10 with a do-while loop.__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
int currentValue = 1, endValue = 10;

do {
	System.out.println(currentValue);
	currentValue++;
} while (currentValue <= endValue);
</code></pre>

</section>

<section markdown="block">
## Why. Even. ???.

__When would you use a do-while loop?__ &rarr;

<span class="fragment">When you want to ensure that the body of the loop gets executed __at least once__.</span>

</section>


<section markdown="block">
## For

<pre><code data-trim contenteditable>
for(initial-action; loop-continuation-condition; action-after-each-iteration) {
	// block of code to repeat
}
</code></pre>

* initial-action ... executed before loop body
* loop-continuation-condition ... the condition for the loop to end
* action-after-each-iteration ... executed after each iteration of loop

__WHAT???__

</section>

<section markdown="block">
## Back to Our Counting Example

__Counting from 1 through 10 with a for loop.__ &rarr;

<pre><code data-trim contenteditable>
for(int i = 1; i <= 10; i++) {
	System.out.println(i);
}
</code></pre>

* a new variable, <code>i</code> is initialized to 1
* the loop keeps going as long as i is less than or equal to 10
* after each iteration, add 1 to i
</section>

<section markdown="block">
## Counting Backwards from 10 to 1

__Ok... so now, let's count down from 10 to 1__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
for(int i = 10; i >= 0; i--) {
	System.out.println(i);
}
</code></pre>
</section>

<section markdown="block">
## break and continue

Java allows you to control the flow of your loop using __break__ and __continue__...

* (again... should be familiar; same as Python)
* you can use __break__ to immediately end the loop
* ...or __continue__ to go on to the next iteration of the loop
</section>

<section markdown="block">
## break and continue example

__What's the output of the following code?__ &rarr;
<pre><code data-trim contenteditable>
for(int i = 1; i <= 3; i++) {
	if (i == 2) {
		break;
	}
	System.out.println(i);
}

for(int i = 1; i <= 3; i++) {
	if (i == 2) {
		continue;
	}
	System.out.println(i);
}
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
1
1
3
</code></pre>

</section>

<section markdown="block">
## How to Design Loops

__What are some questions that we might consider when designing a loop?__ &rarr;

* {:.fragment} do I even have to repeat any code? 
* {:.fragment} ok... figure out exactly what needs to be repeated and use a loop!
* {:.fragment} is it count based or condition based?
* {:.fragment} condition based
	* {:.fragment} what condition must be true in order for the loop to repeat?
	* {:.fragment} what supporting code will we have to add in order for the loop to eventually end (to eventually make the condition false)?
* {:.fragment} count based
	* {:.fragment} um. how many times?
</section>

<section markdown="block">
## Password Lock!

__Write a program that continually asks for a password.__ &rarr;

* if the password equals "gurkin"... say "OK!" and stop asking for a password
* if the user doesn't enter in the correct password after three attempts
	* stop asking...
	* and output... "LOCKED OUT!"


</section>

<section markdown="block">
## Password Lock Output

<pre><code data-trim contenteditable>
Password PLZ!
> blah
Password PLZ!
> gurkin
OK!
</code></pre>

<pre><code data-trim contenteditable>
Password PLZ!
> one
Password PLZ!
> two
Password PLZ!
> three
LOCKED OUT!
</code></pre>

</section>

<section markdown="block">
## Password Lock Implementation

Yes. Maybe?

<pre><code data-trim contenteditable>
final String PASSWORD = "gurkin";
Scanner input = new Scanner(System.in);
String response = "";
int attempts = 0;
while(!response.equals(PASSWORD) && attempts < 3) {
	System.out.print("Password PLZ!\n> ");
	response = input.next();
	attempts++;
}
if(response.equals(PASSWORD)) {
	System.out.println("OK!");
} else if(attempts >= 3) {
	System.out.println("LOCKED OUT!");
}
input.close();
</code></pre>

</section>
