---
layout: slides
title: "Methods"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
## Topics

* definitions
* the call stack
* defining and calling a method
* returning values
* arguments
* modularizing code

</section>


<section markdown="block">
## Summing a Range of Numbers

__Write a program that outputs the sum of the numbers 1 through 10, 10 through 30, and 35 through 45 (inclusive).__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
int sum = 0;
for (int i = 1; i <= 10; i++) {
   sum += i;
}
System.out.println("Sum from 1 to 10 is " + sum);

sum = 0;
for (int i = 10; i <= 30; i++) {
   sum += i;
}
System.out.println("Sum from 10 to 30 is " + sum);

sum = 0;
for (int i = 35; i <= 45; i++) {
   sum += i;
}
System.out.println("Sum from 35 to 45 is " + sum);
</code></pre>
</section>

<section markdown="block">
## Summing a Range of Numbers Continued

Ooof. __What wasn't that great about writing that program?__ &rarr;

<span class="fragment">A little tedious, no? __Don't you wish we had a function that let us just do this?__ &rarr;</span>

<span class="fragment">__Let's pretend that a method called sumRange exists.__ &rarr;</span>

<pre class="fragment"><code data-trim contenteditable>
String format = "Sum from %d to %d is %d\n";
System.out.printf(format, 1, 10, sumRange(1, 10));
System.out.printf(format, 10, 30, sumRange(10, 30));
System.out.printf(format, 35, 45, sumRange(35, 45));
</code></pre>

<span class="fragment">Whew. Much nicer!</span>
</section>

<section markdown="block">
# METHODS FTW!!!

</section>
<section markdown="block">
## Let's Talk Definitions

__What's a method?__ &rarr;

<span class="fragment">A __method__ is a named group of statements that can be executed by name. It can have inputs (parameters) and outputs (return values)</span>

<span class="fragment">__What's does it mean to call or _invoke_ a method?__ &rarr;</span>

<span class="fragment">__Calling__ or __invoking__ a method means to execute or _run_ it.</span>

<span class="fragment">__What do mean when we say that a method returns a value?__ &rarr;</span>

<span class="fragment">__Returning__ a value means that a method will give back a value to your program after you call it!</span>


</section>
<section markdown="block">
## And More Definitions

__What's a parameter?__ &rarr;

<span class="fragment">A __parameter__ is a variable in a method definition that receives an argument.</span>

<span class="fragment">__What's an argument?__ &rarr;</span>

<span class="fragment">An __argument__ is a value passed in to a function in a function call.</span>
</section>

<section markdown="block">
## No. Really. Methods.

What's a method really?

* it's just a __function__
* ... that's used within the context of an object (or class!)
* __methods are useful for__ &rarr;
   * {:.fragment} defining reusable code
   * {:.fragment} organizing and simplifying code
   * {:.fragment} breaking down a problem into more manageable tasks
</section>

<section markdown="block">
## Methods We've Seen...

__What are some methods we've seen? What types of arguments do they take, if any? What type of value do they return, if they return a value?__ &rarr;

* {:.fragment} some examples include...
* {:.fragment} a Scanner object's __<code>nextInt</code>__ method &rarr; <span class="fragment">it takes no arguments, and returns an int</span>
* {:.fragment} a String object's __<code>substring</code>__ method &rarr;  <span class="fragment">one version takes on argument, another takes two, and it always returns a string</span>
* {:.fragment} a String object's __<code>charAt</code>__ method &rarr; <span class="fragment">takes one argument, an int index, and returns a char</span>
* {:.fragment} the Math class's __<code>floor</code>__ (this one is actually unexpected) method &rarr; <span class="fragment">takes one argument, a double, and returns a double</span>

</section>
<section markdown="block">
## Return Types, Input Types

Again...

* methods can have __inputs__ (parameters)
* methods can have an __output__ (return value)

__Why do we care about what type of arguments a method takes and what type of values are returned?__ &rarr;

<span class="fragment">We can get compile-time or run-time errors from type mismatches for:</span>

* {:.fragment} assignment &rarr; <strike><code>short i = 2.4;</code></strike>
* {:.fragment} arguments to method calls &rarr; <strike><code>Math.sqrt("oops!")</code></strike>
* {:.fragment} operators &rarr; <strike><code>"hello" * 2</code></strike>
* {:.fragment} (etc.)

</section>

<section markdown="block">
## Defining a Method

When we design and define a method in Java, we have to specify a few things about that method. __What might we specify in a method definition?__ &rarr;

* {:.fragment} the method's name!
* {:.fragment} the names and __types__, if any, of its parameters
* {:.fragment} the __type__, if any, that it returns
* {:.fragment} any additional __modifiers__
* {:.fragment} the statements that will get executed when this method is called
</section>

<section markdown="block">
## Defining a Method Continued

The syntax for a method is:

<pre><code data-trim contenteditable>
modifier returnValueType methodName(list of parameters) {
   // Method body;
￼￼￼}
</code></pre>

It consists of:

1. {:.fragment} a __modifier__ that specifies _how_ this method is accessed (we'll go over this after the 1st midterm)
2. {:.fragment} the __type__ that this method __returns__ (or specify that it does not return a value!)
3. {:.fragment} the method's __name__
4. {:.fragment} within parentheses, an optional list of parameters (and their types)
5. {:.fragment} a block of code within curly braces
</section>

<section markdown="block">
## An Example Method

This method returns the max integer between two integers. Appropriately called max!

<pre><code data-trim contenteditable>
// THIS WHOLE THING GOES IN YOUR CLASS!
//  modifier        method name
//    |      return |       parameters
//    |      type   |       | 
// |------|   |     |  |--------------|
public static int max(int num1, int num2) {
   int result;
   if (num1 > num2) {
      result = num1;
   } else {
      result = num2; 
   }
   return result;
}
</code></pre>

</section>

<section markdown="block">
## Method Header

A method's __header__ is the first line of a method definition:

<pre><code data-trim contenteditable>
public static int max(int num1, int num2)
</code></pre>

__Let's break this down. Name each part and what it means.__ &rarr;

* {:.fragment} the modifiers are <code>public static</code> 
* {:.fragment} this method returns an <code>int</code> - it gives back a value of type int
* {:.fragment} the method's name is <code>max</code>
* {:.fragment} it has two parameters, both ints, <code>int num1, int num2</code>
</section>

<section markdown="block">
## modifiers

All of the methods that we'll create for the first part of the semester will be __public static__.

* these _modifiers_ specify how the method can be accessed 
* (in broad strokes, it's accessible by other code, even outside of the class...)
* (...and it can be accessed by the class rather than the object/instance)

<pre><code data-trim contenteditable>
// calling a method on a *class* named Integer <-- this is static!
Integer.parseInt("5");

// calling a method on an object
Scanner input = new Scanner(System.in);
int result = input.nextInt();
</code></pre>
</section>

<section markdown="block">
## return value

__Methods may or may not give back a value.__ &rarr;

* use the keyword, __<code>return</code>__  in the functions body to give back a value (just like Python!)
* if a method gives back a value, it must be specified before the method name
   * any possible type will work
   * <code>double</code>, <code>String</code>, <code>bool</code>, etc.
* if a method does not give back a value, its name must be preceded by the keyword, __void__
   * __void__ methods do not return a value!
   * hey - our main method does not return a value!
   * <code>public static void main(String[] args)</code>
* a __value returning method__ is a method that __gives back a value__
* a __void method__ is a method that __does not return a value__
</section>

<section markdown="block">
## _Formal_ Parameters

__When you specify parameters, you dictate the order of the method's arguments and their types.__ &rarr;

* the book refers to these parameters as __formal parameters__
* you can think of a parameter as a placeholder that gets filled in with different values every type it is called/invoked
* if a function has parameters, add parentheses after the function name:
   * within the parentheses, specify each parameter __type__ followed by its __name__
   * if there's more than one parameter, each type/name specification is separated by commas
* if a method has no parameters, just have an open and close parentheses: <code>methodName()</code>
</section>

<section markdown="block">
## Method Signature

A __method signature__ is the method's name and parameter list. __You can use a method signature to:__

* as a way to _sketch_ out your method definition
* or... use the signature of an existing method to determine how to call that method
</section>


<section markdown="block">
## Method Body

Finally, within curly braces, and after the method header, you have the __method body__. The __method body__:

* contains the statements that will be executed when a function is caleed
* can use parameter names to access the values passed in to the function
* you can optionally have a __return__ statement to give back a value (though your method definition should match what you're actually doing... otherwise compile error!)

</section>

<section markdown="block">
## return

Within the body of your method, you can tell your method to give back a value by using the keyword, __<code>return</code>__:

* use <code>return</code>, followed by a value
* return immediately stops the execution of the method body
* ...and gives back the value that follows it

<pre><code data-trim contenteditable>
public static String gimmeHello() {
   return "hello";
}
</code></pre>
</section>

<section markdown="block">
## Um. Where?

Finally... __where should this go, and where can you call it?__ &rarr; 

* {:.fragment} methods are defined within your class
* {:.fragment} they can be called from other methods in your class, including main!

<pre class="fragment"><code data-trim contenteditable>
class Foo {
   // methods go here!
   public static double calculateSomeValue(int bar, int baz) {
      return 1.11111;
   }
}
</code></pre>

</section>

<section markdown="block">
## Quiz

__What type does each method return?__ &rarr;
__How many parameters do they expect, and what are their types?__ &rarr;

<pre><code data-trim contenteditable>
public static double avgThree(int n1, int n2, int n3)
</code></pre>
<span class="fragment">returns a double, 3 parameters, all ints</span>
<pre><code data-trim contenteditable>
public static boolean authenticate(String password)
</code></pre>
<span class="fragment">returns a boolean, 1 parameter, a String</span>
<pre><code data-trim contenteditable>
public static void printUnicodeTable(char ch)
</code></pre>
<span class="fragment">does not return a value, 1 parameter, a character</span>
<pre><code data-trim contenteditable>
public static char generateRandomCharacter()
</code></pre>
<span class="fragment">returns a char, no parameters</span>
</section>

<section markdown="block">
## Let's Revisit Main

Hey. So now we can sort of figure out what all of that _gibberish_ is at the beginning of our programs. __What's the template for starting a Java program?__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
public class Foo {
   public static void main(String[] args) {
   }
}
</code></pre>


</section>

<section markdown="block">
## Main Continued

It turns out that the __main method__ is the __entry point__ to a Java program (at least the ones we know so far). The JVM runs this method when it runs your program. __So... what does all of the stuff in main's definition mean?__ &rarr;

<pre><code data-trim contenteditable>
public static void main(String[] args) {
}
</code></pre>

* {:.fragment} we're defining a method called __main__
* {:.fragment} it's accessible by other code, it can be called from the class
* {:.fragment} it has exactly one parameter, with a type of <code>String[]</code> (we'll talk about that funny notation in the next class)
</section>


<section markdown="block">
## A Full Example

__Create a method that calculates the area of a triangle.__ &rarr;

* __what do you think it should return, if anything?__ &rarr; <span class="fragment">maybe a double makes sense</span>
* __should it have any parameters? if so, what type?__ &rarr; <span class="fragment">maybe the base and height, both doubles?</span>

<span class="fragment">__Let's try to write this together!__ &arr;</span>
<span class="fragment">(again, this should be placed in your class, within the curly braces)</span>
</section>

<section markdown="block">
## Area of Triangle

__Here's a super quick implementation.__ &rarr;

<pre><code data-trim contenteditable>
/* 
 * return the area of a triangle based on supplied 
 * base and height
 */
public static double areaTri(double base, double height) {
   return 0.5 * base * height;
}
</code></pre>
</section>

<section markdown="block">
## Let's Try Calling Our Function (Woo Autocomplete)

Ok... so we can now that we have a method, __we can call it__. &rarr;

* call it __within your main method__
* use the values __10 for base__ and __4 for height__
* __print__ out the __result__
* (start typing out your function and press <code>CTRL + SPACE</code> to autocomplete!)
</section>

<section markdown="block">
## Everything Together

<pre><code data-trim contenteditable>

public class Triangle {
   public static void main(String[] args) {
      System.out.println(areaTri(10, 4));
   }

   /* return the area of a triangle based on supplied 
    * base and height
    */
   public static double areaOfTriangle(double base, double height) {
      return 0.5 * base * height;
   }
}

</code></pre>
</section>

<section markdown="block">
## I've Made a Huge Mistake

__What are some errors in the following code?__ &rarr;

<pre><code data-trim contenteditable>
public static void main(String[] args) {
   foo();
   bar();
   baz(1.2);
}

public static int foo() {
}

public static int bar() {
   return "";
}

public static void baz(float qux) {
}
</code></pre>
</section>

<section markdown="block">
## Mistakes Continued

In the previous slide... __some mistakes were made!__ &rarr;

First, let's look at __return values__.

* {:.fragment} the method, <code>foo</code>, is missing a return statement, even though the function header says that it returns an <code>int</code>
* {:.fragment} the method, <code>bar</code>, is not returning the correct type; the header specifies that it should return an <code>int</code>, but it returns a <code>String</code>

<span class="fragment">Let's also check out __parameters__</span>

* {:.fragment} the method, <code>baz</code>, was called with a <code>double</code> instead of a <code>float</code>

</section>
<section markdown="block">
## You Try... Sum Range

Let's go back to our first slide. We asked...

__Write a program that outputs the sum of the numbers 1 through 10, 10 through 30, and 35 through 45 (inclusive).__ &rarr;

* write the above program, but __use a method to calculate the sum of a range of numbers__
* assume that we're only interested in working with <code>int</code>s
* you should be able to just drop the following code in <code>main</code>, and it should _just work_ (because of the sumRange method that you've defined):

<pre><code data-trim contenteditable>
String format = "Sum from %d to %d is %d\n";
System.out.printf(format, 1, 10, sumRange(1, 10));
System.out.printf(format, 10, 30, sumRange(10, 30));
System.out.printf(format, 35, 45, sumRange(35, 45));
</code></pre>
</section>

<section markdown="block">
## A Possible Solution for sumRange

__This looks like it may work!__ &rarr;

<pre><code data-trim contenteditable>
public static int sumRange(int start, int end) {
   int sum = 0;
   for (int i = start; i <= end; i++) {
      sum += i;
   }
   return sum;
}
</code></pre>

</section>
<section markdown="block">
## Making Methods are Fun, But...

They're kind of useless if we don't call them. __How do we call a method?__ &rarr;

* {:.fragment} method name
* {:.fragment} parentheses
* {:.fragment} within the parentheses, 0 or more arguments separated by commas

</section>

<section markdown="block">
# a closer look at method invocation

(let's take a look at our max method again...)

</section>

<section markdown="block">
## Revisiting Max

__Here it is__, in all of it's glory!

* we know it returns an int
* and it has two parameters

<pre><code data-trim contenteditable>
public static int max(int num1, int num2) {
   int result;
   if (num1 > num2) {
      result = num1;
   } else {
      result = num2; 
   }
   return result;
}
</code></pre>
</section>

<section markdown="block">
## Using the Max Function

__Great... so How do we use the max function?__ &rarr;

* let's use it in <code>main</code>
* create two variables, <code>i</code> and <code>j</code>
* set them to 5 and 2 respectively
* call the function by passing in <code>i</code> and <code>j</code>

<pre class="fragment"><code data-trim contenteditable>
public static void main(String[] args) {
   int i = 5;
   int j = 2;
   int k = max(i, j);
   System.out.println("The maximum of " + i + " and " + j + " is " + k);
}
</code></pre>
</section>

<section markdown="block">
## The Max Program

__What are the methods that are run in the previous program? What order are they executed in?__ &rarr;

* {:.fragment} <code>main</code>
   * {:.fragment} note that main is automatically called by the JVM!
   * {:.fragment} consequently, __main is the first method called__
* {:.fragment} <code>max</code>

</section>

<section markdown="block">
## Pause. Where's Everything Stored?

Ok. Before we move on...

<span class="fragment">Where is our program and all of the data that it works on stored?</span>

* {:.fragment} it's stored in main memory, in RAM!
* {:.fragment} we'll see where exactly in a minute...
</section>

<section markdown="block">
## Activation Records

__Each time a method is invoked:__ &rarr; 

1. the system creates an __activation record__ (or __activation frame__) that stores parameters and variables for the method 
2. the __activation record__ is placed in an area of memory known as the __call stack__
   * the __call stack__ is also called the __execution stack__, __runtime stack__, __machine stack__
   * (or just __the stack__)

__When a method calls another method:__ &rarr;

* {:.fragment} the __caller's activation record is kept intact__
* {:.fragment} a __new activation record__ is created for the new method called
* {:.fragment} when the __new method finishes__ and returns to its caller, __its activation record is removed__ from the call stack

</section>
<section markdown="block">
## Call Stack

A __call stack__ stores the activation records as last-in, first-out: 

* the __activation record__ for the method that is __invoked last__ is is the __first removed from the stack__
* let's check out an example with three nested method calls...
* <code>method1</code> calls <code>method2</code>, which in turn calls <code>method3</code>. __What happens when <code>method1</code> is called?__ &rarr;


</section>
<section markdown="block">
## Call Stack Example

<pre><code data-trim contenteditable>
public static void method1() {
   method2();
}
public static void method2() {
   method3();
}
</code></pre>

1. {:.fragment} <code>method1's</code> activation record is pushed on the stack first (assuming it's called)
2. {:.fragment} then <code>method2's</code> activation record would be pushed on top of that when it is called
3. {:.fragment} and finally, method3's activation record would be added... 
4. {:.fragment} (method1's activation record would be at the bottom of the stack, while method3's would be at the top) 
5. {:.fragment} as each method finishes executing, their activation record would be popped off the stack (starting with <code>method3</code> down to 1)
</section>

<section markdown="block">
## Yet Another Call Stack Example

__Let's check out the max program again.__ &rarr;

* <code>main</code> contains the variables <code>i</code>, <code>j</code>, and <code>k</code>. 
* the variables defined in <code>max</code> are <code>num1</code>, <code>num2</code>, and <code>result </code>
* <code>num1</code> and <code>num2</code> are defined in the method signature and receive their values during the method call
* __let's try drawing out how this works, specifying activation recrods, the variables present, and their values__ &rarr;
</section>

<section markdown="block">
## Calling Main and Max

So... __this is what should happen when main is called, which in turn... calls max__ &rarr;

<div markdown="block" class="img fragment">
![stack1](../../resources/img/stack1.png)
</div>
</section>

<section markdown="block">
## Returning from Main and Max

__Let's see what happens as the methods finish.__ &rarr;

<div markdown="block" class="img fragment">
![stack1](../../resources/img/stack2.png)
</div>
</section>

<section markdown="block">
## Pass by Value

So far... all of the arguments that we're passing to our methods are passed by value. That means __manipulating the arguments in the body of the method won't change the original values passed in!__ &rarr;

(this won't always be the case, as we'll see later in the semester).

<pre><code data-trim contenteditable>
public static void main(String[] args) {
   int x = 1;
   System.out.println("Before the call, x is " + x); increment(x);
   // x remains 1 even though it's incremented in the method
   System.out.println("After the call, x is " + x);
}

public static void increment(int n) { 
   n++;
   System.out.println("n inside the method is " + n);
}
</code></pre>
</section>

<section markdown="block">
## Modularizing Code

__Let's see how we can use methods to:__ &rarr;

* make code easier to read
* promote code reuse
* eliminate redundant code
</section>

<section markdown="block">
## Decimal to Hex

To convert a decimal to hexadecimal:

1. calculate the remainder of the number divided by the base, 16... 
2. the remainder will represent the next significant digit (on the left)
3. take the integer result of the division, the quotient... and go back to step 1, but replace the number with the quotient
4. (continue process until quotient is 0... )
</section>

<section markdown="block">
## Let's see an example

__What's 172 in hex?__ &rarr;

* {:.fragment} <code>172 % 16 = 12</code> &rarr; hex is <code>'C'</code>
* {:.fragment} <code>172 / 16 = 10</code> &rarr; new quotient is <code>10</code>
* {:.fragment} <code>10 % 16 = 10</code> &rarr; hex is <code>'AC'</code>
* {:.fragment} <code>10 % 16 = 10</code> &rarr; new quotient is <code>0</code>
* {:.fragment} STOP
</section>

<section markdown="block">
## toHex

__Write and test a method that converts an integer in decimal format... to a String representation of if the same number in hex.__ &rarr;

* takes an int (decimal)
* gives back a string (hex)

</section>
<section markdown="block">
## toHex Pseudocode

* {:.fragment} as long as the quotient isn't 0
* {:.fragment} calculate the remainder
* {:.fragment} add the remainder to our new hex string
* {:.fragment} if the remainder is 10 through 15
* {:.fragment} use the appropriate character ... __how?__ &rarr;
   * {:.fragment} maybe a series of condtionals
   * {:.fragment} or get the number of characters away from 'A' (remainder - 10)... __why?__ &rarr;
      * {:.fragment} we don't need 0-9..., -9 (gives us 1 through 5)
      * {:.fragment} don't include 'A', -1
* {:.fragment} calculate the new quotient
</section>
<section markdown="block">
## toHex Potential Solution

<pre><code data-trim contenteditable>
public static String toHex(int n) {
   final int BASE = 16;
   int quotient = n, remainder;
   String result = "";
         
   while (quotient > 0) {
      remainder = quotient % BASE;
      quotient = (int) (quotient / BASE);
      
      // remainder is next most significant digit in result
      if (remainder < 10) {
         result = remainder + result;
      } else {
         // subtract 10... -1 to account for 'A'
         // -9 to account for 0 - 9
         char digit = (char) ('A' + (remainder - 10));
         result = digit + result;
      }
   }
   return result;      
}
</code></pre>
</section>


<section markdown="block">
## How About To Binary?

__Hm. That's great! How about we make another function to convert to binary?__ &rarr;


<pre class="fragment"><code data-trim contenteditable>
public static String toBin(int n) {
   final int BASE = 2;
   int quotient = n, remainder;
   String result = "";
   while (quotient > 0) {
      remainder = quotient % BASE;
      quotient = (int) (quotient / BASE);
      
      // remainder is next most significant digit in result
      result = remainder + result;
      
   }
   return result;         
}
</code></pre>
</section>


<section markdown="block">
## Any Improvements?

Whew. That was a lot of coding. __Can we make our code more concise?__ &rarr;

* {:.fragment} maybe we can consolidate both methods!
* {:.fragment} ...and make a general method that handles an arbitrary base (well, up to 15)

</section>

<section markdown="block">
## toBase

<pre><code data-trim contenteditable>
public static String toBase(int n, int base) {
   int quotient = n, remainder;
   String result = "";
         
   while (quotient > 0) {
      remainder = quotient % base;
      quotient = (int) (quotient / base);
      
      // remainder is next most significant digit in result
      if (remainder < 10) {
         result = remainder + result;
      } else {
         // subtract 10... -1 to account for 'A'
         // -9 to account for 0 - 9
         char digit = (char) ('A' + (remainder - 10));
         result = digit + result;
      }
   }
   return result;
}
</code></pre>
</section>
