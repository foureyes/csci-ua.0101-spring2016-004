---
layout: slides
title: "Review - Writing Your First Java Program"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
# Let's Write Hello World _Again_

(the simplest program we can write; it'll just print "Hello World" to the screen)
</section>

<section markdown="block">
## Setting Up a Java Program

__What's some boilerplate code that we have to use when writing any Java program?__ &rarr;

* {:.fragment} we have to define a _class_
* {:.fragment} we have to create a _method_ called main
* {:.fragment} __(oh, also, the class name and the file name should be the same!)__

<span class="fragment">We'll talk about classes and methods in a little bit...</span>

<span class="fragment">Oh, and there are also a few syntactical things to remember:</span>
</section>

<section markdown="block">
## The End of the Line

__In Java, almost every statement in your program must end with what character?__ &rarr;

<span class="fragment">A semicolon</span>

<span class="fragment">You know...</span>

<pre class="fragment"><code data-trim contenteditable>;</code></pre>
</section>

<section markdown="block">
## Statements, Expressions, and Values

__Wait a second. What's a value, expression and statement?__ &rarr;

* {:.fragment} a __value__ is just data!
* {:.fragment} an __expression__ represents a computation involving values, variables, and operators that evaluates to a value
a __statement__ is a single instruction (in a high level language)
	* {:.fragment} we can think of a statement as a single line in your program
	* {:.fragment} statements can be made up of expressions, which in turn, are made up of values and operators!

</section>


<section markdown="block">
## Blocks of Code

__In Java, what syntax is used to chunk together a block of related _statements_ (that is, what's analagous to indentation in Python)?__ &rarr;

<span class="fragment">Use curly braces!</span>

<pre class="fragment"><code data-trim contenteditable>{}'s</code></pre>

</section>

<section markdown="block">
## Back to That Pesky Semicolon

So... again, we use semicolons to terminate statements.

A good general rule of thumb might be:

* if something ends in a curly brace, you don't need a semicolon
* for pretty much everything else, add a semicolon at the end!
</section>

<section markdown="block">
## Boilerplate Code

__With all of that out of the way then... what does the code for creating a class with a method called main look like?__ &rarr;

(maybe let's name the class HelloWorld)

<pre class="fragment"><code data-trim contenteditable>
public class HelloWorld {
	public static void main(String[] args) {

	}
}
</code></pre>

</section>

<section markdown="block">
## Oops, That's Missing One Very Important Piece

What's the _magical incantation_ that we use to print something out to the screen?

<pre class="fragment"><code data-trim contenteditable>
System.out.println("Hello World");
</code></pre>

<span class="fragment">Note the lovely semicolon at the end.</span>
</section>
<section markdown="block">
## Everything Together

<pre><code data-trim contenteditable>

public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
}
</code></pre>
</section>

<section markdown="block">
# Running a Java Program

</section>

<section markdown="block">
## First... Computers Understand 0's and 1's

__What's the only language that computers can execute directly?__ &rarr;

* {:.fragment} computers can really only directly execute __machine code__
* {:.fragment} ...maps to a particular processor's instructions set
* {:.fragment} for example, <code>000000 00001 00010 00110 00000 100000</code>

</section>
<section markdown="block">
## High-Level Languages

High-level languages like C, Java, and Python aren't just 0's and 1's. __How does a high level language get executed?__ &rarr;

<span class="fragment">It's __compiled__ and/or __interpreted__. Um. But what does __compile__ and __intepret__ mean?</span>

* {:.fragment} __compilation__ is the translation of all of your high-level language source code (in its entirety) into a low-level language
* {:.fragment} __interpretation__, on the other hand is the immediate execution of each individual line of your source code
</section>


<section markdown="block">
## So... How is Java Program is Executed?

We have our <code>HelloWorld.java</code> example above. __How is that source code actually executed?__ &rarr;

* {:.fragment} your source code has to be compiled into __bytecode__
* {:.fragment} then... the bytecode is itself is executed by an interpreter

</section>

<section markdown="block">
## Byte What!?

So, __bytecode__ is similar to machine code, but it's not tied to a specific processor. Instead, it runs on a __virtual machine__!

Whoah... wait... virtual...

<div markdown="block" class="img fragment">
![virutal machine](http://s.hswstatic.com/gif/vr-therapy-1.jpg)
</div>
</section>

<section markdown="block">
## JVM

The JVM, or __Java Virtual Machine__ ...

* is a software representation of a computer (_machine_).
* it interprets (that is, it runs/_executes_) bytecode!
* it can run on multiple platforms (on Linux, Windows, iOS, etc)

</section>

<section markdown="block">
## Why Bother?

Um. That sounds like a lot of hoops to jump through just to run a program. __What do you think the advantage is of having a _virtual machine_ run _bytecode_ rather than compiling directly to machine code?__ &rarr;

* {:.fragment} theoretically, this would allow you to _write once, run anywhere_
* {:.fragment} when you compile to machine code, you're compiling for a specific processor, so you can only run on that processor _architechture_
* {:.fragment} however, with Java... you can compile to bytecode, which can be run anywhere where the JVM is installed!

</section>

<section markdown="block">
## JDK

It turns out that the tools you downloaded, the Java Development Kit, has two super useful programs:

* __javac__ - a compiler
* __java__ - an interpreter

Your workflow with Java goes something like this:

* {:.fragment} write code
* {:.fragment} compile with __javac__
* {:.fragment} run with __java__
* {:.fragment} (thankfully, Eclipse simplifies this for us)
</section>

<section markdown="block">
## File Extensions

You'll mainly be dealing with two kinds of files when working with Java:

* <code>.java</code> files contain your source code
	* this has your actual program
	* it can be _compiled_ to Java bytecode
* <code>.class</code> files are your compiled files 
	* this contains Java bytecode 
	* it can be executed using the JVM
	
</section>

<section markdown="block">
## A Demo

__Let's see this in action by running HelloWorld.java.__ &rarr;

* you won't be using this _actual_ workflow, but it shows you what's going on behind the scenes
* all of this is run in the commandline (cmd.exe on Windows or Terminal.app on OSX ... or your terminal of choice on Linux)

1. list the files (we only have one .java file)
2. compile: <code>java HelloWorld.java</code>
3. list the files (notice that we now have a .class file)
4. run: <code>javac HelloWorld</code>
5. voila! just like magic 

</section>
<section markdown="block">
# MAGIC!!!!
<div markdown="block" class="img">
![java magic](http://www.troll.me/images/installation-wizard/stand-back-im-a-java-wizard.jpg)
</div>	
</section>

<section markdown="block">
## Using an IDE

That was fun and all, but kind of tedious. __How do we really run our programs? What program do you use to write and run your Java programs?__ &rarr;

* {:.fragment} we use __Eclipse__, an Integrated Development Environment (IDE)
* {:.fragment} you can use it to write and run Java programs
* {:.fragment} (it's configured behind the scenes to use the JDK that you installed!)
* {:.fragment} note that Eclipse is actually a general purpose IDE; you can use it with _any_ language, even Python
* {:.fragment} (it's actually much nicer than IDLE!)
</section>

<section markdown="block">
## Ugh

Eclipse is kind of cumbersome at times. __Here's some help:__ &rarr;

* you know we have access to lynda.com, right? it has some [tutorials](http://www.lynda.com/Eclipse-tutorials/Up-Running-Eclipse/111243-2.html)
	* home.nyu.edu
	* "Academics"
	* "lynda.com" Login
	* check out a video, like [Creating a project in Eclipse](http://www.lynda.com/Eclipse-tutorials/Creating-new-project/111243/118387-4.html)
* the actual [Eclipse docs](http://help.eclipse.org/luna/index.jsp?nav=%2F1)
* [a video from the previous version of your book](http://www.cs.armstrong.edu/liang/intro9e/VideoNote/Eclipse/EclipseTutorial.htm)
* see Chapter 1

</section>
<section markdown="block">
## Working With Eclipse

__The general workflow when writing and running programs with Eclipse is__ &rarr;


1. create a new project
2. create a new .java file (called class in Eclipse-land)
3. run (this compiles and runs the bytecode for you in a single step!)

</section>

<section markdown="block">
## A Quick Tour

* __project explorer__ on the left
* source code editor on the right (for each individual file)
* __console__ on the bottom (that's where errors and output show up)

</section>
<section markdown="block">
## Projects vs Files

Eclipse likes to help you out. Maybe too much. It really likes organizing your files for you! __Here's a quick demo.__ &rarr;

* when you create a project, __you're creating a new folder in your workspace__ &rarr;
	* go to finder / explorer and look for your project folder
	* it should be empty
* when you create a new file in your project, __you're just adding files in that folder__ &rarr;
	* add a new class (File &rarr; New &rarr; Class)
	* go to finder / explorer again, and check out your project folder
	* notice the new .java file
</section>

<section markdown="block">
##  Projects vs Files Continued

Let's see what happens when you __run your project__ &rarr;

* {:.fragment} hey ... it created a .class file for us
* {:.fragment} __by the way, what's a .class file?__ &rarr;
* {:.fragment} it's the compiled bytecode that can be executed by the JVM

</section>

<section markdown="block">
## Troubleshooting

* my program isn't running!
	* however over the little red x's next to your code to find the error
	* (or view the output in the lower panel, the __console__)
* I don't see the project explorer or the console!
	* go to Window &rarr; Show View
	* choose Project Explorer and/or Console

</section>

<section markdown="block">
## Submitting Homework

* only submit __.java__ files found in your project folder
* don't submit __.class__ files

</section>


