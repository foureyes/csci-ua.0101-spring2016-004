---
layout: slides
title: "Loops Continued"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
## Topics

* review while and for
* sentinal values
* braces
* break, continue
* nested loops

</section>

<section markdown="block">
## Loops, Java

There are a few different ways to repeat a block of code in Java. __What are they?__ &rarr;

1. {:.fragment} while
2. {:.fragment} do-while
3. {:.fragment} for
</section>

<section markdown="block">
## While Loops

__What's the syntax for a while loop? What does it do?__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
while (boolean_expression) {
	// do stuff
}
</code></pre>

<span class="fragment">A __while__ loop executes statements within its body (within curly braces) __as long as the condition, the boolean expression, is true__.</span>


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

__What's the syntax for a do-while loop? What does it do?__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
do {
	// block of code to repeat
} while (boolean_expression);
</code></pre>

<span class="fragment">A __do while__ loop __executes the body first__... then checks the condition. </span>
</section>

<section markdown="block">
##  Do While Example

__Print out the numbers 1 through 10 using a do-while loop.__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
int currentValue = 1, endValue = 10;

// body gets evaluated first before condition!
do {
	System.out.println(currentValue);
	currentValue++;
} while (currentValue <= endValue);
</code></pre>
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
## Counting by 2's from through to 10

__Ok... so now, let's count down from 10 to 1__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
for(int i = 2; i <= 10; i+=2) {
	System.out.println(i);
}
</code></pre>
</section>

<section markdown="block">
## break and continue

Java allows you to control the flow of your loop using __break__ and __continue__...

Based on your experience with Python... what does break and continue do?

* {:.fragment} you can use __break__ to immediately end a loop
* {:.fragment} or __continue__ to go on to the next iteration of the loop
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
* {:.fragment} condition based... __what loop would we use?__ &rarr; <span class="fragment">use while</span>
	* {:.fragment} what condition must be true in order for the loop to repeat?
	* {:.fragment} what supporting code will we have to add in order for the loop to eventually end (to eventually make the condition false)?
	* {:.fragment} __does the body need to be executed first?__ &rarr; <span class="fragment">use a do while</span>
* {:.fragment} count based... for loop
	* {:.fragment} um. how many times?
</section>

<section markdown="block">
## Multiplication Quiz

__Write a multiplication quiz game.__ &rarr;

Continually do the following:

* generate two random numbers from 1 through 12
* ask the user what the product of both numbers is
* if they have it right, add 1 to a running total
	* print out "RIGHT!"
	* then go back to the first step
	* (generate random numbers again)
* if they have it wrong
	* stop the quiz immediately
	* print out "WRONG!"
* output the number answered correctly at the end
* example on next slide

</section>

<section markdown="block">
## Example Output

<pre><code data-trim contenteditable>
What is 10 * 11?
> 110
RIGHT!
What is 9 * 1?
> 8
WRONG!
Thanks for quizzin'. You got 1 right.
</code></pre>


</section>

<section markdown="block">
## Solution 1

__How about with do-while?.__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
Scanner input = new Scanner(System.in);
int response, correctAnswer, num1, num2, total = 0;
do {
	num1 = (int) (Math.random() * 12 + 1);
	num2 = (int) (Math.random() * 12 + 1);
	System.out.printf("What is %s * %s?\n> ", num1, num2);
	response = input.nextInt();
	correctAnswer = num1 * num2;
	if (response == correctAnswer) {
		total += 1;
		System.out.println("RIGHT!");
	} else {
		System.out.println("WRONG!");markdown
	}
} while (response == correctAnswer);
System.out.printf("Thanks for quizzin'. You got %s right.", total);
</code></pre>
</section>

<section markdown="block">
## Solution 2

__Let's try one with break.__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
while (true) {
	num1 = (int) (Math.random() * 12 + 1);
	num2 = (int) (Math.random() * 12 + 1);
	System.out.printf("What is %s * %s?\n> ", num1, num2);
	response = input.nextInt();
	correctAnswer = num1 * num2;
	if (response == correctAnswer) {
		total += 1;
		System.out.println("RIGHT!");
	} else {
		System.out.println("WRONG!");
		break;
	}
} 
System.out.printf("Thanks for quizzin'. You got %s right.", total);
</code></pre>
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

