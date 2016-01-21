---
layout: slides
title: "Introduction to Computers, Programs and Java"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
# What's a Computer?

(seriously)

This stuff should be mostly review for you.

</section>


<section markdown="block">
## Hardware

__What are the major components of a computer?__ &rarr;

* {:.fragment} CPU
* {:.fragment} RAM / Memory
* {:.fragment} Secondary Storage
* {:.fragment} Input and Output Devices
* {:.fragment} (book mentions communication devices)

</section>

<section markdown="block">
## CPU

__What is it again?__ &rarr;

<span class="fragment">
The part of the computer responsible for _actually_ running your program.
</span>

* {:.fragment} retrieves instructions from memory and executes them
* {:.fragment} computers have a __clock__ that emits electronic pulses at a constant rate
* {:.fragment} pulses use to control and synchronize the pace of operations
* {:.fragment} generally, higher clock speed, _faster_ computer
* {:.fragment} a CPU's __core__ is the part of the processor that actually performs the reading and execution of instructions
* {:.fragment} CPU's can have more than one core
</section>

<section markdown="block">
## Information Storage

__How do computers store data - what format?__ &rarr;

* {:.fragment} computers store data as a series/sequence of __bits__ (what's a bit!?)
* {:.fragment} __bits__ are binary digits; they represent either 0 or 1
* {:.fragment} __why are 0's and 1's easy for computers to use?__ &rarr;
* {:.fragment} easy to represent 0's and 1's as on or off with electronics!
* {:.fragment} 8 bits are a __byte__

</section>

<section markdown="block">
## Numbers and Text

__How are numbers and text respresented by bits and bytes?__ &rarr;

* {:.fragment} numbers are encoded using binary 
* {:.fragment} characters use some encoding scheme that maps integers to characters / symbols
	* {:.fragment} __Unicode__
	* {:.fragment} __ASCII__

</section>

<section markdown="block">
## Storage Continued

Storage is usually measured in __bytes__ (again, 8 bits) or multiples of bytes. __What are some typical units of measurement for storage?__ &rarr;

* {:.fragment} a __kilobyte__ (KB) is _about_ 1 thousand bytes
* {:.fragment} a __megabyte__ (MB) is _about_ 1 million bytes
* {:.fragment} a __gigabyte__ (GB) is _about_ 1 billion bytes
* {:.fragment} a __terabyte__ (TB) is _about_ 1 trillion bytes
* {:.fragment} The download size of the syllabus page is only around 7KB
* {:.fragment} An HD movie might be about 8GB

</section>

<section markdown="block">
## Memory

__What's RAM?__ &rarr;

* {:.fragment} RAM is where your computer stores your running program and the data that it uses
* {:.fragment} a program and its data must be moved into memory before the CPU can run the program
* {:.fragment} __how long does RAM hold data?__ &rarr;
* {:.fragment} RAM is _volatile_; it needs a continuous power supply to persist data
* {:.fragment} every byte in memory has a _unique address_ 
* {:.fragment} (hence RAM - __Random Access Memory__ - the address can be used to locate the byte of data for retrieval or storage) 
* {:.fragment} note that a memory byte is never empty! it may just have data from a previous (or even _other_ running) program!

</section>

<section markdown="block">
## Secondary Storage / Storage Devices

__What are some examples of secondary storage?__ &rarr;

* {:.fragment} SSD's and hard drives
* {:.fragment} CDs and DVDs
* {:.fragment} [floppy disks](https://www.google.com/search?q=floppy+disks&espv=2&biw=1408&bih=981&source=lnms&tbm=isch&sa=X&ei=TGfKVPn6CYKvggTr7YD4Aw&ved=0CAcQ_AUoAg) (!?)
* {:.fragment} [magnetic tape](https://www.google.com/search?q=magnetic+tape+storage&espv=2&biw=1408&bih=981&source=lnms&tbm=isch&sa=X&ei=ZWfKVJDwEIH0ggT7rIMI&ved=0CAcQ_AUoAg) (!!??)
* {:.fragment} [punch cards](https://www.google.com/search?q=punch+cards&espv=2&biw=1408&bih=981&source=lnms&tbm=isch&sa=X&ei=fGfKVNCXF8fSggSNp4LYBg&ved=0CAYQ_AUoAQ#tbm=isch&q=punch+cards+computer) (!!!???)
* {:.fragment} (thanks for taking the time machine with me)


</section>
<section markdown="block">
## Input and Output Devices

__Um. Self explanatory.__

Well... the only thing interesting in the book regarding output devices is some definitions related to monitors / displays:

* __screen resuloution__ - number of pixels in horizontal and vertical dimensions
* __dot pitch__ - amount of space between pixels, in millimeters

</section>

<section markdown="block">
## Communication Devices

The book mentions communication devices as another hardware component (though, I guess you could consider them as input/output devices as well). Some examples include:

* network card
* wifi card
* bluetooth module
* etc.
</section>

<section markdown="block">
# Programming Languages 
</section>

<section markdown="block">
## Low Level Languages

__What's the language that a computer can _directly_ execute?__ &rarr;

* {:.fragment} __machine language__ (or machine code) ... __what is it?__ &rarr;
* {:.fragment} a pattern of bits that represent an instruction for the CPU (add this number to that number; move number from one location to another)
* {:.fragment} for example, adding two values may be this 32 bit sequence: 
* {:.fragment} <code>000000 00001 00010 00110 00000 100000</code>

<span class="fragment">There's also __assembly language__:</span>

* {:.fragment} instead of using bit sequences, short descriptive words are used to represent instructions... for example:
* {:.fragment} <code>add     esp, 8  </code>
* {:.fragment} an __assembler__ converts assembly language to __machine code__

</section>


<section markdown="block">
## High Level Languages

__What's a high-level programming language?__ &rarr;

* {:.fragment} it's a programming language that's designed to be easy for people to read and write 
* {:.fragment} they generally have to be __compiled__ or __interpreted__ in order to be executed
* {:.fragment} check out [githut.info](http://githut.info/) or [TIOBE for popular languages](http://www.tiobe.com/index.php/content/paperinfo/tpci/index.html)

</section>

<section markdown="block">
## Compilers and Interpreters

__What's as compiler? What's an intpreter?__ &rarr;

* {:.fragment} first -- note that the text of a program written in a high-level language is usually referred to as __source code__
* {:.fragment} a __compiler__ is a program that translates the entirety of your source code to machine code so that it can be executed
* {:.fragment} on the other hand, an __interpreter__ is a program that reads one statement from the source code and translates it to machine code (or virtual machine code) and executes it immediately 
* {:.fragment} for us... that usually means that compiled languages require an explicit compilation step before executing, interpreted languages do not


</section>

<section markdown="block">
## Compilers and Interpreters Continued

Interpreter flow:

<pre><code data-trim contenteditable>
source --> interpreter --> output
</code></pre>

Compiler flow: 

<pre><code data-trim contenteditable>
source --> compiler --> 

machine code --> executor --> output
</code></pre>
</section>

<section markdown="block">
## Operating Systems

__What are operating systems responsible for?__ &rarr;

* {:.fragment} an __operating system__ is software that gives you access to the underlying hardware that it is running on, as well as manages/controls your computer's activities
* {:.fragment} controlling and monitoring system activities (managing files and folders, user authentication and authorization, etc.)
* {:.fragment} managing system resources (giving access to CPU and RAM)
* {:.fragment} scheduling operations:
	* {:.fragment} __multiprogramming__ - allows multiple programs to run simultaneously by sharing same CPU
	* {:.fragment} __multithreading__ - allow a single program to run multiple tasks at the same time
	* {:.fragment} __multiprocessing / parallel processing__ - allows two or more processors to perform two subtasks concurrently and combine solutions
</section>

<section markdown="block">
# Java

</section>

<section markdown="block">
## Java

* it's a __high level programming language__
* originally developed by James Gosling at __Sun Microsystems__
* it's now owned by __Oracle__
* it's a general purpose, object-oriented, programming language
* it's a __compiled__ language that gets __interpreted__ by a __virtual machine__ (more on this later)

</section>

<section markdown="block">
## Where You've Seen it Before

__Any ideas?__ &rarr;

* {:.fragment} primary language for developing Android applications!
* {:.fragment} application software (like Eclipse, the IDE that we're using)
* {:.fragment} middleware - data transfers, batch data processing, etc.
* {:.fragment} note that the book claims that it's a common language for developing web applications - but that's not really so true anymore


</section>

<section markdown="block">
## Java Versions

__There are several versions of Java Available__

* __Java Standard Edition (Java SE)__ - client applications (like Desktop apps)
* __Java Enterprise Edition (Java EE)__ - server applications
* __Java Micro Edition (Java ME)__ - applications for mobile devices

We'll be useing Java Standard Edition - __Specifically Java SE 8__.

</section>

<section markdown="block">
## Some Terminology Regarding Java

* __Java language specification__ - the formal specifications that define Java's syntax and semantics - you can find them on [Oracle's Java SE docs site](http://docs.oracle.com/javase/specs/)
* __API or Application Program Interface__ - a bunch of predefined classes/interfaces/libraries/modules for developing Java programs (they take care of common programming tasks, such as reading files or retrieving user input) - you can find the api docs at [java.net](http://download.java.net/jdk8/docs/api)
* __JDK or Java Developer Toolkit__ - a set of programs for creating, running and testing Java programs
* __IDE or Integrated Developer Environment__ - software that allows you to write programs; not necessarily language specific
</section>

<section markdown="block">
## A Java Program

Every java program

* must have a __class__
	* class names are <code>CamelCase</code> (all words together with no spaces, first letters of words are uppercase) 
	* the class name will match the file name exactly
* must have a method called in <code>main</code> in a class

__Let's see this in action__ &rarr;
</section>

<section markdown="block">
## Eclipse

First... we'll open Eclipse, the IDE that we'll use to create our Java programs. It has a ton of great features:

* syntax highlighting
* inline error reporting
* code generation
* code completion
* integrated debugger

We'll see all of this in action.
</section>

<section markdown="block">
## So, Our First Program

__Hello World, of course__ &rarr;

<pre><code data-trim contenteditable>

public class HelloWorld {
    public static void main(String[] args) {
       // prints out hello world
       System.out.println("Hello World");
   	}
}

</code></pre>

</section>

<section markdown="block">
## Some Things to Take Note Of:

1. file name and class name match
2. class name is camel case
3. there must be a main method (which is a essentially a _function_)
4. a class may have several methods
5. there are __reserved words__ or __keywords__ that have special meaning, like <code>public static void</code>
6. you can have comments in your code
7. curly braces, <code>{}</code>'s denote a _block_ of code
8. statements end with a semicolon!
</section>

<section markdown="block">
## Let's Try a Few Things

1. Print more lines
2. Cause a syntax error (leave off a quotation mark)
3. Cause a runtime error (print zero division)

</section>

<section markdown="block">
## Common Errors

* unbalanced curly braces
* missing semicolons
* unbalanced quotation marks
* misspelled names or _identifiers_
</section>

<section markdown="block">
## Style and Documentation

* appropriate comments
* indentation / spacing
* block styles
</section>

<section markdown="block">
## A Preview

Getting Input

<pre><code data-trim contenteditable>
import java.util.Scanner;
public class Test {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      double width, height;
      
      // retrieve a width from user
      System.out.println("Please enter a width");
      width = input.nextDouble();
      
      // retrieve a height from user
      System.out.println("Please enter a height");
      height = input.nextDouble();      
      
      // calculate area
      System.out.println(width * height);
   }
   // and we're done!
}

</code></pre>

</section>
