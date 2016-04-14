---
layout: slides
title: "Exceptions"
---

<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
## Pizza, Pizza, Pizza!


You love throwing pizza parties! (Of course, who doesn't!?). You want to write a program that __calculates the number of slices per person, if a pie has multiple slices__ &rarr;


Example Output Below:

<pre><code data-trim contenteditable>
🍕 PARTY 🍕
How much many ppl are eating???
> 4
Each person gets 2 slice(s)
</code></pre>

</section>

<section markdown="block">
## Pizza Party Solution 

<pre><code data-trim contenteditable>
Scanner input = new Scanner(System.in);
System.out.println("🍕 PARTY 🍕");
System.out.print("How much many ppl are eating???\n> ");
int people = input.nextInt();
int slicesPerPerson = 8 / people;
System.out.printf("Each person gets %s slice(s)", slicesPerPerson);
</code></pre>
</section>


<section markdown="block">
## Breaking the Program

Now, let's pretend you're a _malicious_ hacker (maybe Mallory is your name). You find this pizza program. __How do you break it? ... that is, is there input that you can put in to make it crash?__ &rarr;

* {:.fragment} something that's not an int
* {:.fragment} a zero
* {:.fragment} __let's see what happens when we try both of these__ &rarr;

</section>

<section markdown="block">
## Uh, Oh. Errors!

So it looks like it was pretty easy for us to generate an error. Let's talk about errors...

__What's the difference between a runtime error and a compile time error__? &rarr;

* {:.fragment} __Runtime errors__ happen while a program is running (if the JVM detects an operation that is impossible to carry out)
* {:.fragment} __Compile-time errors__ are errors that the compiler uncovers before your program even runs!
* {:.fragment} if a compile-time error occurs, a new <code>.class</code> file will not be created
* {:.fragment} __so, what kind of errors did we produce in our pizza program?__ &rarr;
* {:.fragment} runtime errors
</section>

<section markdown="block">
## Examining Runtime Errors

Let's take a closer look at the runtime errors that we caused. __What information is contained there?__ &rarr;

<pre><code data-trim contenteditable>
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at PizzaCalculator.main(PizzaCalculator.java:11)
</code></pre>

* {:.fragment} the kind of error that occurred
* {:.fragment} where it happened
</section>

<section markdown="block">
## Exceptions


Hm... what was that <code>java.lang.ArithmeticException:</code> thing about?

In Java, __runtime errors__ are known as __exceptions__. 

* An __exception__ is an __object that represents an error__ or a condition that prevents execution from proceeding normally. 
* If the exception is not handled, the program will terminate abnormally.
* (So, in our pizza program, we did not deal with division by zero or a type mismatch error)
</section>

<section markdown="block">
## Exception Types

Again, exceptions __are objects__ that represent errors.

* the exceptions caused from our program are represented by objects that descend the <code>Exception</code> class
* the Exception class itself inherits from <code>java.lang.Throwable</code> (__btw, does <code>Throwable</code> have a parent class?__)
* __this means that we can distinguish between one kind of error and another__
* __we can also create our own exception objects!__
</section>

<section markdown="block">
## Exception Types Continued

The following exception types inherit from <code>Exception</code> (these are just a few):

* {:.fragment} __<code>ClassNotFoundException</code>__ - program uses a class that doesn't exist
* {:.fragment} __<code>IOException</code>__ - opening a file that doesn't exist
* {:.fragment} __<code>RuntimeException</code>__ - a parent class of additional excpetions

<span class="fragment"> __Note that all of these can occur during runtime (even though only one is explicitly named RuntimeException)__.  </span>
</section>

<section markdown="block">
## Subclasses of RuntimeException


__We might have seen some of these before...__ &rarr;

* {:.fragment} __<code>ArithmeticException</code>__ - dividing by 0
* {:.fragment} __<code>NullPointerException</code>__ - attempt to access methods/properties on a null reference
* {:.fragment} __<code>IndexOutOfBoundsException</code>__ - index of Array is out of bounds
* {:.fragment} __<code>StringIndexOutOfBoundsException</code>__ - index of String is out of bounds
* {:.fragment} __<code>ClassCastException</code>__ - attempted to cast an object to a subclass of which it is not an instance 
</section>

<section markdown="block">
## Guessing Game

__Outputs something? Nothing? Or error?__ &rarr;

<pre><code data-trim contenteditable>
System.out.println(1 / 0); 
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
ArithmeticException (divide by 0)
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
int[] list = new int[5];
System.out.println(list[5]);
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
ArrayIndexOutOfBoundsException (index 5 out of bounds!)
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
String s = "abc";
System.out.println(s.charAt(3));
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
StringIndexOutOfBoundsException (no index 3 in "abc")
</code></pre>

</section>

<section markdown="block">
## Guessing Game Continued

__Outputs something? Nothing? Or error?__ &rarr;

<pre><code data-trim contenteditable>
Object o = new Object();
String d = (String)o;
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
ClassCastException (o is not an instance of <code>String</code>)
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
Object o = null;
System.out.println(o.toString());
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
NullPointerException
</code></pre>

</section>

<section markdown="block">
## Handling Exceptions

Ok, great. But what can we do about all of those exceptions? Java offers the following syntax for __catching an exception__ and executing code to recover from it:

<pre><code data-trim contenteditable>
try {
	// stuff that may cause an exception
} catch (TypeOfException variableName) {
	// do something about this error
} catch (AnotherTypeOfException variableName) {
	// do something about this error
} catch .... {
	/// and so on for any runtime error you want to recover from
}
</code></pre>
</section>

<section markdown="block">
## Handling Exceptions Explained

* the code in the __try__ block may cause an error
* if it causes an error: 
	* then the code in the __catch__ block will be executed
	* (and, the operations in the __try__ block __will not be executed successfully__)
* note that the catch block has an exception type and a variable name (this object contains info about the error)
* if there's no error:
	* proceed __without executing__ the code in the __catch__ block

</section>

<section markdown="block">
## Let's See Try/Catch in Action

__What's the error that happens here?__ &rarr;

<pre><code data-trim contenteditable>
public class Thing {
  Object obj;
}
</code></pre>

<pre><code data-trim contenteditable>
public class ThingTest {
  public static void main(String[] args) {
    Thing thing = new Thing();
    String s = thing.obj.toString();
    System.out.println(s);
  }
}
</code></pre>
</section>

<section markdown="block">
## Catching Exceptions

<pre><code data-trim contenteditable>
public class ThingTest {
  public static void main(String[] args) {
    Thing thing = new Thing();
    String s = "";
    try {
      s = thing.obj.toString();
    } catch (Exception NullPointerException){
      System.out.println("Oops, that's null!");
    }
    System.out.println(s);
  }
}
</code></pre>
</section>

<section markdown="block">
## Fixing Our Pizza Program

Fix our pizza program so that:

* if the user doesn't input an integer, it'll say: <code>Hey, enter a number, DUH!</code>
* if the user enters 0, it'll say: <code>WHUT!? More pizza 4 me!</code>
* __use exception handling to do this!__ &rarr;

</section>

<section markdown="block">
## Pizza with Exceptions on Top

A potential solution...

<pre><code data-trim contenteditable>
Scanner input = new Scanner(System.in);
System.out.println("🍕 PARTY 🍕");
System.out.print("How much many ppl are eating???\n> ");

try {
  int people = input.nextInt();
  int slicesPerPerson = 8 / people;
  System.out.printf("Each person gets %s slice(s)", slicesPerPerson);
} catch (InputMismatchException e) {
  System.out.println("Need a number, DUH!");
} catch (ArithmeticException e) {
  System.out.println("WHUT!? More pizza 4 me!");
}
</code></pre>
</section>

<section markdown="block">
## One Last Example, A Stack of Strings


Imagine that we have this suuuper simple implementation of a stack of <code>String</code>s:

<pre><code data-trim contenteditable>
import java.util.Arrays;

class StackOfStrings {
  String[] elements = new String[2];
  int size = 0;
  
  public void push(String s) {
    elements[size] = s;
    size++;
  }
  
  @Override
  public String toString() { return Arrays.toString(
      Arrays.copyOfRange(elements, 0, size));
  }
}
</code></pre>
</section>

<section markdown="block">
## Using the Stack

Imagine we use the stack in the following manner. __Will an error occur, will something be printed out, or will nothing be printed out?__ &rarr;

<pre><code data-trim contenteditable>
public class StackTest {
  public static void main(String[] args) {
    StackOfStrings stack = new StackOfStrings();
    System.out.println(stack);
    stack.push("foo");
    stack.push("bar");
    stack.push("baz");
    System.out.println(stack);
  }
}
</code></pre>
</section>

<section markdown="block">
## Fixing Stack

__What are some ways that we can gracefully recover from the error?__ &rarr;

* {:.fragment} just don't add the element
* {:.fragment} increase the <code>Array</code> capacity, of course
* {:.fragment} __let's see how that would work?__ &rarr;

</section>

<section markdown="block">
## Fixing Stack Continued

__We can use <code>try/catch</code>!__ &rarr;
<pre class="fragment"><code data-trim contenteditable>
try {
  elements[size] = s;
} catch (ArrayIndexOutOfBoundsException e)  {
  String[] newElements = new String[size * 2];
  System.arraycopy(
      elements, 0, newElements, 0, elements.length);
  elements = newElements;
  elements[size] = s;
}
size++;
</code></pre>
</section>

<section markdown="block">
## RuntimeExceptions vs Other Exceptions

__Note that all of the Exceptions we talked about can occur during runtime (even though only one is explicitly named RuntimeException)__.  

However, <code>RuntimeExceptions</code> are different from other exceptions, such as <code>IOError</code> in that:

* all exceptions that descend from <code>RuntimeException</code> are __unchecked exceptions__
* __unchecked exceptions__ are exceptions that you are not required to catch
* other exceptions... __must be handled__ with a try catch or the method that it's in must declare that it throws an Exception (__or the compiler will complain!__) 
	* <code>public void myMethod() throws ExceptionType</code>
</section>

<section markdown="block">
## finally

You can also add a __<code>finally</code>__ clause to your <code>try/catch</code>.

__finally__ is executed regardless of whether or not an exception occurs:

<pre><code data-trim contenteditable>
try {
	// do stuff that causes errors
} catch(Exception e) {
	// do stuff to recover from an error
} finally {
	// do stuff regardless of whether or not an error happens
}
</code></pre>
</section>

<section markdown="block">
## finally continued

__What is the output of this code?__ &rarr;

<pre><code data-trim contenteditable>
int x = 3;
try {
	x = 5 + 5;
} catch(Exception e) {
	System.out.println("oops");
} finally {
	System.out.println(x);
}
</code></pre>
<span class="fragment">10</span>
</section>

<section markdown="block">
## finally continued

And ... __what would this print out?__ &rarr;

<pre><code data-trim contenteditable>
int x = 3;
try {
	x = 5 / 0;
} catch(Exception e) {
	System.out.println("oops");
} finally {
	System.out.println(x);
}
</code></pre>

<pre><code data-trim contenteditable>
oops
3
</code></pre>
</section>

<section markdown="block">
## throw

You can also use the keyword, __<code>throw</code>__ to actually generate an error!

__Let's try running this code... what do you think will happen?__ &rarr;

<pre><code data-trim contenteditable>
public static void main(String[] args) {
	throw new NullPointerException("foo");
}
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
Exception in thread "main" java.lang.NullPointerException: foo
	at Test.main(Test.java:3)
</code></pre>
</section>

<section markdown="block">
## throw continued

What about this code?

<pre><code data-trim contenteditable>
public static void main(String[] args) {
	throw new Exception("hi there!");
}
</code></pre>

<span class="fragment">This is a compile error! ... it's not an __unchecked__ exception, so we either have to deal with it or have our main method declare that it throws exceptions.</span>
</section>

<section markdown="block">
## declaring exceptions

We can fix the previous example by putting our throw in a try catch or... __telling Java that our method can generate an exception__:

* use the keyword, <code>throws</code> as part of the method header
* follow it by the type of Exception that is thrown (can be comma separated for example, <code>throws ArithmeticException, NullPointerException</code>)

<pre><code data-trim contenteditable>
public static void main(String[] args) throws Exception{
	throw new Exception("hi there!");
}
</code></pre>
</section>

<section markdown="block">
## Back to the Stack

Let's try implementing pop in our previous stack of Strings class.

__However, let's throw an exception if we try to pop from an empty list...__ &rarr;

</section>

