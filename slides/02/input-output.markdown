---
layout: slides
title: "Input and Output"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
## Topics

* import
	* wildcard or specific class/object
* Scanner object
	* creating a new object
		* Scanner takes System.in!
	* using methods 
		* nextDouble
</section>

<section markdown="block">
## ComputeChange Case Study

__Write a program that determines how many dollars, quarters, dimes, etc. are needed to add up to a given amount.__ &rarr;

<pre><code data-trim contenteditable>
ComputeChange.java

Enter an amount, for example, 11.56
> 7.82
Your amount 7.82 consists of:
	7 dollars
	2 quarters
	3 dimes
	0 nickels
	2 pennies
</code></pre>

</section>

<section markdown="block">
## Defining Variables, Getting Input

__Let's start off by defining some variables__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
import java.util.Scanner;
public class ComputeChange {
	public static void main(String[] args) {
		final int DOLLAR = 100, QUARTER = 25, DIME = 10, NICKEL = 5, PENNY = 1;
		
		double amount; 
		int remaining;
		int dollars, quarters, dimes, nickels, pennies;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter an amount");
		amount = input.nextDouble();
		
		// add calculations here
	}
}

</code></pre>

</section>
<section markdown="block">
## Running Some Calculations

__Now... let's use a combination of division and modulo to calculate change.__ &rarr;
<pre class="fragment"><code data-trim contenteditable>
		remaining = (int) (amount * 100);
				
		dollars = remaining / 100;
		remaining = remaining % DOLLAR;
		
		quarters = remaining / QUARTER;
		remaining = remaining % QUARTER;
		
		dimes = remaining / DIME;
		remaining = remaining % DIME;
		
		nickels = remaining / NICKEL;
		remaining = remaining % NICKEL;
		
		pennies = remaining;
		
		// print everything out here....
</code></pre>

</section>

<section markdown="block">
## Finally, Printing...

Simply...

<pre><code data-trim contenteditable>
		System.out.println(dollars + " Dollars");
		System.out.println(quarters + " Quarters");
		System.out.println(dimes + " Dimes");
		System.out.println(nickels + " Nickels");
		System.out.println(pennies + " Pennies");
</code></pre>

</section>
