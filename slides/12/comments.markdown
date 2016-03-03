---
layout: slides
title: "Java API Documentation / Comments"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
# Writing Comments

</section>
<section markdown="block">
## Commenting

Ok so... what makes a good comment?

* {:.fragment} first - make sure that your code speaks for itself - use good variable names
* {:.fragment} anything that isn't self explanatory, or contains _magic_, should be commented
* {:.fragment} if there's some domain specific information that would help (not too much), add that as well
* {:.fragment} finally, you can use specially formatted comments to build Java documentation
</section>

<section markdown="block">
## Um. What Does This Code Do, and How?


<pre><code data-trim contenteditable>
public static String computerMove(int a, int b, int c, int d) {
  if (b >= c - d || a < 20) {
    return "r";
  } else {
    return "h";
  }
}
</code></pre>

* {:.fragment} Computer move... yeah. 
* {:.fragment} But... what's <code>a</code>, <code>b</code>, <code>c</code>, and <code>d</code>. 
* {:.fragment} Before we even start adding comments, it might be nice to give this some __meaningful variable names__ &rarr;
</section>


<section markdown="block">
## Right. So Let's Try Meaningful Variable Names.

Using single letter variable names was nice and terse, but it was pretty difficult to _grok_ / understand what was going on. This is a little bit easier, right? __Describe what the method does now?__ &rarr;

<pre><code data-trim contenteditable>
public static String getComputerMove1( int rollTotal, int opponentScore, int winningScore, int threshold) {
  if (opponentScore >= winningScore - threshold || rollTotal < 20) {
    return "r";
  } else {
    return "h";
  }
}
</code></pre>

<span class="fragment">only roll if the opponent is close to winning, or if comp doesn't have a 20 for the round yet</span>
</section>

<section markdown="block">
## One Minor Issue. Long Lines.

Because Java is __not whitespace significant__, you can break up that long line like so:
<pre><code data-trim contenteditable>
public static String getComputerMove1(
    int rollTotal, int opponentScore, 
    int winningScore, int threshold) {

  if (opponentScore >= winningScore - threshold || rollTotal < 20) {
    return "r";
  } else {
    return "h";
  }
}
</code></pre>
</section>

<section markdown="block">
## Maybe Still a Little Difficult. How About Comments?

That was pretty good, but that boolean expression does look intimidating, doesn't it? __Let's add a comment.__ &rarr;

<pre><code data-trim contenteditable>
public static String getComputerMove2(int rollTotal, int opponentScore, 
    int winningScore, int threshold) {

  // only roll if the opponent is close to winning, or if comp 
  // doesn't have a 20 for the round yet
  if (opponentScore >= winningScore - threshold || rollTotal < 20) {
    return "r";
  } else {
    return "h";
  }
}
</code></pre>
</section>

<section markdown="block">
## Another Version (Not Necessarily Better) 

Or you can let your variable names do all of the talking for you. It's contrived, so the variable usage is a bit heavy. __You kind of don't need comments for this.__ &rarr;

<pre><code data-trim contenteditable>
public static String getComputerMove(int rollTotal, int opponentScore, 
    int winningScore, int threshold) {
  final String HOLD = "h";
  final String ROLL = "r";

  String move = HOLD;

  int opponentScoreThreshold = winningScore - threshold;
  boolean opponentCloseToWinning = opponentScore >= opponentScoreThreshold;

  if (opponentCloseToWinning || rollTotal < 20) {
    move = ROLL;
  } 
  return move;
}
</code></pre>
</section>

<section markdown="block">
## Finally, Add a JavaDoc Comment

A Javadoc comment is a specially formatted comment that allows automated generation of html documentation for code that you write.

Javadoc comments consists of:

* a multi-line comment (<code>/** ... */</code>)
* Javadoc tags embedded in the comment (start with <code>@</code> symbol)

For example:

<pre><code data-trim contenteditable>
/**
 * @version 1.0
 */
</code></pre>

</section>

<section markdown="block">
## Javadoc Comments for Methods

A sample javadoc comment for a method can consist of the following parts:

1. a short description
2. parameters (<code>@param</code>)
3. return value (<code>@return</code>)

__It looks like this:__ &rarr;

<pre><code data-trim contenteditable>
/**
 * A description... 
 * <p>
 * html allowed
 * </p>
 *
 * @param  parameterName describe the parameter
 * @return describe what the method returns
 */
</code></pre>
</section>

<section markdown="block">
## Sample Javadoc 

<pre><code data-trim contenteditable>
/**
 * Determine if the computer should roll or hold during its turn
 * for a game of Pig. It should return one of the following two values:
 * <ul>
 * <li>"r" for roll</li>
 * <li>"h" for hold</li>
 * </ul>
 * 
 * @param rollTotal current total of all the rolls for this round
 * @param opponentScore oppenent's current score
 * @param winningScore the score required to win the game
 * @param threshold if opponent is this many points away from winning, go 
 *        for broke!
 * @return a String that represents computer move/play ("r", "h")
 */
</code></pre>

</section>
<section markdown="block">
# The Java API (and documentation) 

</section>

<section markdown="block">
## Methods, What Methods?

So... we know a bunch of String methods. __What are some that we know?__ &rarr;

* {:.fragment} <code>equals</code>, <code>length</code>, <code>startsWith</code>, <code>toUpperCase, </code><code>substring</code>, <code>indexOf</code>, etc.
* {:.fragment} __do we know _all_ String methods?__ &rarr;
* {:.fragment} nah... not yet, and probably not ever? __How can we find out what all of the methods are, what they do, and how they're called?__ &rarr;
* {:.fragment} ... you can use the dot operator in Eclipse __but that's kind of not that great__

{%comment%}*{%endcomment%}
</section>

<section markdown="block">
## API

You might hear the term __API__ here and there. __Does anyone know what it stands for, and what it means?__ &rarr;

* {:.fragment} __API__ stands for __A__ pplication __P__ rogramming __I__ nterface
* {:.fragment} an __API__ is a set of tools (like classes, methods, etc.) for building software applications
* {:.fragment} Java has an API... that, is a set of classes, methods and other tools to help you write software. We're familiar with some of Java's API:
	* {:.fragment} Character
	* {:.fragment} String
	* {:.fragment} Scanner
</section>

<section markdown="block">
## Java API Documentation

__So where can I find all of this API info?__ &rarr;

Oracle hosts the Java API documentation on their site:

[http://docs.oracle.com/javase/8/docs/api/](http://docs.oracle.com/javase/8/docs/api/)

It includes documentation on:

* classes
* the class and instance methods you can call on those classes
	* a description of the method
	* the signature and return type
* etc.

__Let's [take a look](http://docs.oracle.com/javase/8/docs/api/), shall we?__ &rarr;

</section>

<section markdown="block">
## Javadoc Comments Revisited 

Hey. So you know those Javadoc comments that we created? __What did we say we could use them for?__ &rarr;

<span class="fragment">A Javadoc comment is a specially formatted comment that allows automated generation of html documentation for code that you write.</span>

<span class="fragment">__Ok... let's generate some documentation.__</span>

</section>

<section markdown="block">
## Generating Documentation

To generate documentation, you use (surprise) a tool called <code>javadoc</code>.

* it can be run on the commandline
* or via Eclipse 
	* project &rarr;
	* generate javadoc
	* check the <code>doc</code> directory in your workspace/project folder
* __let's try it!__ &rarr;

Hey. That format looks really familiar. __Where did we see it before, and what does that imply?__ &rarr;

* {:.fragment} Java API documentation looks pretty similar
* {:.fragment} it's also generated with Javadoc!
</section>
