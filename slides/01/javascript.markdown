---
layout: slides
title: Introducing JavaScript
---
<section markdown="block" class="intro-slide">
# Introducing JavaScript

### {{ site.course_number}}-{{ site.course_section }}

<p><small> 
</small></p>
</section>

<section markdown="block">

## Let's Talk About

* What is __JavaScript__ _anyway_, and where have you seen it?
* Why are _we_ using JavaScript?

</section>

<section markdown="block">

## Books (JavaScript Specific)

* __required__
	* [{{ site.book_js }}]({{ site.book_js_link }}) &rarr;
		* great JavaScript / intro to programming book (may be too basic for some, though!)
		* the [online version]({{ site.book_js_link }}) is free
* __alternative/optional__
	* [{{ site.book_js_2 }}]({{ site.book_js_2_link }}) &rarr;
		* if you've seen JavaScript before / feel like you have this _programming thing_ down, this is for you
	* [{{ site.book_js_2_author }}](http://en.wikipedia.org/wiki/Douglas_Crockford) is a well known figure in the JavaScript community (wrote [JSLint](http://www.jslint.com/), specified [JSON](http://en.wikipedia.org/wiki/JSON)(!))
	
</section>

<section markdown="block">
## What's JavaScript?

### Perhaps you've used it before!

* __JavaScript__ is a __widely used__, __high-level__ programming language that is __available on many platforms__
* __JavaScript__ and __Java__ are two entirely different programming languages
{:.fragment}
</section>

<section markdown="block">
##  Some History

Originally created in 1995 as a way to add interactivity (through programming) to web pages in __Netscape Navigator__!

<div markdown="block" class="img">
![Netscape!](../../resources/img/netscape.gif)
</div>

</section>

<section markdown="block">
## More History

* Microsoft also implemented a compatible dialect of JavaScript for Internet Explorer called [JScript](http://en.wikipedia.org/wiki/JScript)
* formally standardized in the late 90's (under the name [ECMAScript](http://en.wikipedia.org/wiki/ECMAScript))
	* implementations include the JavaScript engines in various browsers 
	* as well as [ActionScript](http://en.wikipedia.org/wiki/ActionScript) (remember Flash?) 
	* and, of course, various server side implementations, such as Node.js and Rhino
* (did I mention that it's __not Java__?)

</section>

<section markdown="block">
## Where is it Now?

### JavaScript is now a widely used programming language!

* ubiquitous on the web
* __JavaScript__ is an integral part of creating modern, single-page/hybrid web apps
* it's usage has gone beyond web page interactivity:
	* server side language (__Node.js__)
	* database query language (__MongoDB__)
	* creative programming (__processing.js__)
	* embedded scripting language (__Max/MSP__)

</section>

<section markdown="block">
## Where You've Seen It

* __as a server side language, JavaScript can be found on:__
	* (as mentioned before) [PayPal](https://www.paypal-engineering.com/2013/11/22/node-js-at-paypal/), [New York Times](https://source.opennews.org/en-US/articles/nyt-redesigns-mobile/), and  [LinkedIn](http://queue.acm.org/detail.cfm?id=2567673)
	* [even](http://jobs.netflix.com/jobs.php?id=NFX01209) [NetFlix](http://techblog.netflix.com/2014/08/scaling-ab-testing-on-netflixcom-with_18.html) and [Walmart](http://codewinds.com/podcast/002.html)!?
	* [and others, of course](http://www.nearform.com/nodecrunch/node-js-becoming-go-technology-enterprise#.VAUUIWSwLPY)
* __here are some particularly _awesome_ uses of JavaScript on the front-end:__
	* [Khan Academy uses JavaScript/Process.js to teach computer science](https://www.khanacademy.org/cs/programming/variables/p/challenge-bucktooth-bunny)
	* [Creative programming, user interface experimentation (hakim.se)](http://hakim.se/experiments)
	* [Skifree.js!](http://basicallydan.github.io/skifree.js/)

\* (we're going to start off a little less ambitious, though)

</section>

<section markdown="block">
## A Quick Rundown of its Features

* __multi paradigm__ - __Object Oriented__ (through prototypes), __Functional__, etc.
* __dynamically typed__
* __weakly typed__ (maybe not a great feature?)
* most implementations are __interpreted__ rather than compiled
* __C-like syntax__ - so you should be pretty familiar with all of the curly braces
</section>

<section markdown="block">
## It's Available!

* you can install server-side JavaScript on multiple platforms (Node.js has __Windows__, __Linux__, and __OSX__ installers)
* it's available on every major browser (such as Chrome, Safari or Internet Explorer)
* not only are you able to run JavaScript, but... if you have a web browser and a text editor, you will be able to write JavaScript programs as well!
* __check out the JavaScript _console_ in Chrome__ &rarr;
* In Chrome: View &rarr; Developer &rarr; JavaScript Console
</section>

<section markdown="block" data-background="#440000">
##  (And Again) JavaScript is not Java!
</section>

<section markdown="block">
## Running JavaScript

We'll be running JavaScript on both the server and the client... so we'll rely on:

* {:.fragment} the __Node.js__ commandline interpreter / [REPL](http://nodejs.org/api/repl.html), which is really just [V8](http://en.wikipedia.org/wiki/V8_(JavaScript_engine)) (what's v8? &rarr;)
<pre><code data-trim contenteditable>
node myfile.js
</code></pre>
{:.fragment}
<pre><code data-trim contenteditable>
pines:~ joe$ node
> console.log('REPL time!')
</code></pre>
{:.fragment}
* {:.fragment} and Chrome for running JavaScript in browser (which is, coincidentally, also __v8__)

</section>

<section markdown="block" data-background="#440000">
## For the first few classes, it would be good to use __node__, but your browser's developer tools will work in a pinch.

### Let's see both in action &rarr;

</section>

<section markdown="block">
## JavaScript Basics

### OK! Now About the _Actual_ Language

* From the book, {{ site.book_js }}:
	* [Values](http://eloquentjavascript.net/01_values.html)
	* [Program Structure](http://eloquentjavascript.net/02_program_structure.html)
* ...And the slides (based on the above readings)
	* [Values, Types, and Operators](values-types-operators.html)
	* [Variables and Control Structures](variables-control-structures.html)
* And a valuable reference:
	* [Mozilla Developer Network, Reintroduction to JavaScript](https://developer.mozilla.org/en-US/docs/Web/JavaScript/A_re-introduction_to_JavaScript)
* __And a [quick survey](../../resources/handouts/class01/survey.pdf)__


</section>

