---
layout: slides
title: "Modelling Data With Arrays"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
## Calculating Homework Grades

So... you have a bunch of homework grades (let's pretend that I've _actually_ gotten to homework 5!).

You'd like to do some analysis on how you're doing, such as:

* your average homework score 
* your lowest score
* your highest score

Perhaps the grades that you've received are <code>87, 92, 71, 90, and 95</code>. __What are some options for storing this data so that you can run various calculations on it?__ &rarr;

</section>

<section markdown="block">
## Separate Variables.

Hey. Why over-think things. Can't we just save these values in variables, __and do something like this?__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
int grade1 = 87, grade2 = 92, grade3 = 71, grade4 = 90, grade5 = 95;
System.out.println((grade1 + grade2 + grade3 + grade4 + grade5) / 6);
</code></pre>

<span class="fragment">That's well and good, but __how do you find the highest and lowest scores?__ &rar;</span>

<span class="fragment">(Ugh. Maybe a crazy conditional? Extend our max method?).</span>
</section>

<section markdown="block">
## Using Arrays

It's actually pretty difficult to work on that data as a group when they're single variables. However, __we can group the homework scores into a single data structure. What could we use to store the homework scores?__ &rarr;

* {:.fragment} a single-dimensional <code>Array</code> is probably the best bet <span class="fragment">(also, we don't know any other compound data structures)</span>
* {:.fragment} each score is an item in the <code>Array</code>

<pre class="fragment"><code data-trim contenteditable>
int[] homeworkGrades = {87, 92, 71, 90, 95};

int total = 0;
for(int grade: homeworkGrades) {
	total += grade;
}
System.out.println(total / homeworkGrades.length);
</code></pre>
</section>


<section markdown="block">
## Using Arrays to Model Data

That was a pretty straightforward mapping. Makes total sense. __Let's try something a little more challenging.__ &rarr;

__How would you use Arrays to model a deck of 52 playing cards.__ &rarr;

* like a regular set of playing cards, there are for suits
* each suit has 13 cards: A, 2 - 10, and J, Q, K
* the duck should be shuffle-able (that is, they can be placed in random order)
* ... so that we can _get the first five_ shuffled cards
* __without duplicates__:

<pre class="fragment"><code data-trim contenteditable>
Q♥
2♥
7♦
7♥
6♠
</code></pre>
</section>

<section markdown="block">
## (Maybe) Solution #1

__We don't need no Arrays, right!?__ &rarr;

* {:.fragment} we can just generate a random number for the suit
* {:.fragment} ...and a random number for the rank
* {:.fragment} __but wait, what requirement might be difficult to fulfill using this strategy?__ &rarr;
* {:.fragment} not allowing duplicate cards to be picked (we'd probably have to write yet another complex conditional, eh?)
* {:.fragment} __how about we try using Arrays?__ &rarr;
</section>

<section markdown="block">
## Using an Array of Strings

The most straightforward way of doing this is to just have an __Array of Strings__. Let's try creating a few methods to: &rarr;

* generate the deck
* shuffle it

</section>

<section markdown="block">
## generateDeck

Create a method called <code>generateDeck</code> that:

* returns an Array of Strings
* with each string following the format: <code>RankSuit</code> (for example, 2♠).
* there should be 52 cards in the deck (4 suits, with 13 ranks each)

<pre class="fragment"><code data-trim contenteditable>
public static String[] generateDeck1() {
	String[] deck = new String[52];
	String[] suits = {"♠", "♥", "♦", "♣"};
	String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	int index = 0;
	for(String suit: suits) {
		for(String rank: ranks) {
			deck[index] = rank + suit;
			index++;
		}
	}
	return deck;
}
	
</code></pre>

</section>
<section markdown="block">
## shuffle

Create a method called <code>shuffle</code> that shuffles an Array of Strings. It __should shuffle in place (it does not reutnr a value)__. __What algorithm might we use to shuffle an Array in place?__ &rarr;

1. {:.fragment} for every element starting from the left
2. {:.fragment} swap with a random element (generate a random index)
3. {:.fragment}  // any drawbacks?
4. {:.fragment} there may be duplicate swaps, so some combinations more likely than others

<pre class="fragment"><code data-trim contenteditable>
public static void shuffle1(String[] deck) {
	for(int i = 0; i < deck.length; i++) {
		String temp = deck[i];
		int swapIndex = (int) (Math.random() * deck.length);
		deck[i] = deck[swapIndex];
		deck[swapIndex] = temp;
	}
}
</code></pre>
</section>


<section markdown="block">
## Finally, Putting it All Together

Let's use the methods we created to:

1. generate a deck
2. shuffle it...
3. reveal the _top five_ cards of the deck

<pre class="fragment"><code data-trim contenteditable>
String[] d1 = generateDeck1();
shuffle1(d1);
for(int i = 0; i < 5; i++) {
	System.out.println(d1[i]);
}
</code></pre>
</section>

<section markdown="block">
## Using an Array of ints

Another way to represent a deck of cards is to use integers to __encode__ a card's rank and suit. __How might we do this?__ &rarr;

* {:.fragment} have the numbers 1 - 52 represent the playing cards
* {:.fragment} order the cards by suit and rank...
	* {:.fragment} the first set of 13 cards represent one suit, the next another, etc.
	* {:.fragment} (so we can use integer division by 13 to get an index for suit)
	* {:.fragment} ranks are sequential as well, and every rank repeats every 13 cards, so 1 is an ace, 2 is 2, 15 is an ace, 16 is 2... etc.
	* {:.fragment} (so we can use modulo 13 to get an index for rank)
* {:.fragment} shuffle
* {:.fragment} create methods to decode a number into a suit and rank

</section>

<section markdown="block">
## generateDeck

__Create a method called <code>generateDeck</code> that:__ &rarr;

* returns an Array of ints, from 1 through 52 inclusive
* there should be 52 ints in the deck 

<pre class="fragment"><code data-trim contenteditable>
public static int[] generateDeck2() {
	int[] deck = new int[52];
	for(int i = 0; i < deck.length; i++ ) {
		deck[i] = i + 1;
	}
	return deck;
}
</code></pre>

</section>
<section markdown="block">
## shuffle

As with the previous version of <code>shuffle</code>, this should use the following naive shuffling algorithm:

1. for every element starting from the left
2. swap with a random element (generate a random index)

<pre><code data-trim contenteditable>
public static void shuffle2(int[] deck) {
	for(int i = 0; i < deck.length; i++) {
		int temp = deck[i];
		int swapIndex = (int) (Math.random() * deck.length);
		deck[i] = deck[swapIndex];
		deck[swapIndex] = temp;
	}
}	

</code></pre>

</section>
<section markdown="block">
## Generate, Shuffle and Print

__Hm... there's something off about what's printed out?__ &rarr;

<pre><code data-trim contenteditable>
int[] d2 = generateDeck2();
shuffle2(d2);
for(int i = 0; i < 5; i++) {
	System.out.printf(d2[i]);
}
</code></pre>

<span class="fragment">We have to decode the card...</span>
</section>


<section markdown="block">
## Utility Methods

__Let's decode the int stored in the shuffled deck into a suit (/ 13) and a rank (% 13)__ &rarr;

<pre><code data-trim contenteditable>
public static String getCard(int n) {
	return getRank(n) + getSuit(n);
}
</code></pre>

<pre><code data-trim contenteditable>
public static String getSuit(int n) {
	// 13 cards per suit
	String[] suits = {"♠", "♥", "♦", "♣"};
	// assume int
	return suits[n / 13];
}
</code></pre>

<pre><code data-trim contenteditable>
public static String getRank(int n) {
	String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	return ranks[n % 13];
}
</code></pre>

<pre><code data-trim contenteditable>
// replace our print in the previous slide:
System.out.printf("%s, %s\n", d2[i], getCard(d2[i]));
</code></pre>

</section>
