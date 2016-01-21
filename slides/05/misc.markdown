---
layout: slides
title: "Miscellaneous (Project Setup, Boolean Coercion, Scanner)"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
## Questions from Previous Class

You have questions. Maybe I have answers.

* Can __all homework parts__ be in a __single project__ (more than one class with main method in project)?
* Can a __non-boolean value__ be used in an __if statement condition__; is it automatically coerced to a boolean?
* Why does Eclipse warn you about __closing your Scanner object__?
* Can the __Scanner object__ handle __more than one input in a line__?
* The lottery homework has ambiguous wording... what does __all digits match__ mean?
</section>

<section markdown="block">
## Multiple Homework Parts in Project

If you've been doing your homework (which you have, _right_?), the left panel in Eclipse, the project explorer, may be getting a bit crowded.

Someone asked __"can we store all of our .java files in the same project?__ &rarr;

* {:.fragment} __absolutely__ ... all I end up seeing for these first assignments are the <code>.java</code> files anyway... __let's see how it works__ &rarr;
* {:.fragment} I'll amend future homework instructions to allow this... as this strategy is probably super useful for organizing homework with multiple parts
* {:.fragment} (it's actually common to have more than one class file in a project)
* {:.fragment} (however, outside of homework and for the more complex homework, it's not so common to have multiple disparate programs in a single project) 
</section>

<section markdown="block">
## Converting to Boolean

An if statement's condition __must have a boolean expression__... &rarr;

<pre class="fragment"><code data-trim contenteditable>
// the condition must result in a true or false
if (result == 1) {
	// do stuff
}
</code></pre>

<span class="fragment">A few notes:</span>

* {:.fragment} __there's no automatic conversion__ of other types to boolean... <code>if (1)</code> will not work &rarr;
* {:.fragment} to convert an int or float to a boolean (by treating __non-zero as true__), compare to zero: <code>number != 0</code> &rarr;
* {:.fragment} finally, to convert from a __string to a boolean__: <code>Boolean.valueOf("true")</code> (any string, regardless of case, that's the same as <code>"true"</code> yields true)&rarr;
</section>

<section markdown="block">
## Eclipse Warning - Scanner Object Never Closed

__Hm. What's that little mark in Eclipse next to the code for creating a new Scanner object?__ &rarr;

* <code>Resource leak: 'input' is never closed</code>
* just like the file handle (object) in Python, _resources_ (such as files, keyboard input, etc.) need to be closed
* otherwise it takes up memory, it may _lock_ a resource, etc. 
</section>

<section markdown="block">
## So.. What Do I Do?

__If you want to be a good citizen__ &rarr;

* call <code>myScannerObject.close()</code> to suppress the error
* {:.fragment} __however__, similar to File I/O in Python, close can often be left out without any consequences
* {:.fragment} for our purposes, and for the book, it is __ok not to close the scanner object__ 
* {:.fragment} (it some cases, it may cause issues if you do... like permanently closing System.in for the entirety of your program)
</section>

<section markdown="block">
## The Scanner Object Revealed!

__There's actually a little more to the Scanner object. Let's see the docs__ &rarr;

A simple text scanner which can parse primitive types and strings using regular expressions.

A Scanner __breaks its input into tokens using a delimiter pattern__, which by __default matches whitespace__. The resulting tokens may then be converted into values of different types using the various next methods.

</section>

<section markdown="block">
## Scanner Object Continued

So, as you'll find out in later chapters in the book, the <code>Scanner</code> object:

* __tokenizes__ (or breaks apart) a string (or input, or a file, etc.), 
* based on a __delimiter__ (the default is space)
* and gives you each piece back whenever you call <code>next()</code> (or nextInt, nextDouble, etc.)
* .... sooo .... typing in <code>12 5 7</code> in one line as input here... results in 3 separate values

<pre><code data-trim contenteditable>
Scanner s = new Scanner(System.in);
int n1 = s.nextInt();
int n2 = s.nextInt();
int n3 = s.nextInt();
</code></pre>

__Let's see this code run__ &rarr;
</section>

<section markdown="block">
## Multiple Input

__Now let's try typing in one number at a time...__ &rarr;

* {:.fragment} typing in 12 &lt;enter&gt;, 5 &lt;enter&gt;, 7 &lt;enter&gt; results in 3 separate values
* {:.fragment} note that it waits for each additional one!

<span class="fragment">
Either way works! Though the homework from the book looks like you input 2 values in the same line (__and the same code handles both methods of input__).
</span>
</section>

<section markdown="block">
## Lottery Homework

* if your random lottery number yields repeated digits, such as <code>277</code>...
* it is ok to count the user's digits as matching all if __all unique digits match__, for example <code>272</code>
* (however, feel free to implement matching of each individual digit)

</section>


