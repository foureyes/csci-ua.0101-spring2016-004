---
layout: slides
title: "Object Oriented Programming Continued"
---

<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
# Picking Up Where We Left Off

</section>
<section markdown="block">
## A Student Class

<pre><code data-trim contenteditable>
class Student {
  String firstName;
  String lastName;
  int[] homeworkGrades;

  Student(String fn, String ln, int[] arr) {
    this.firstName = fn;
    this.lastName = ln;
    this.homeworkGrades = arr;
  }

  double getAverageHomeworkGrade() {
    int total = 0;
    for(int grade: this.homeworkGrades) {
      total += grade;
    }
    return (double) total / 
      this.homeworkGrades.length;
  }

  String getFullName() {
    return this.firstName + " " + this.lastName;
  }
}
</code></pre>
</section>

<section markdown="block">
## Creating Student Objects

__What's the output of this code?__ &rarr;

<pre><code data-trim contenteditable>
public static void main(String[] args) {
  int[] grades = {90, 85, 95};
  Student s = new Student("Foo", "Bar", grades);
  System.out.println(s.getFullName());
  System.out.println(s.getAverageHomeworkGrade());
}
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
Foo Bar
90.0
</code></pre>
</section>

<section markdown="block">
## Oh Yeah, Arrays are Reference Types

In the previous class, someone asked the question... is the reference that's in the variable <code>grades</code> pointing the same <code>Array</code> that the reference in the member variable, <code>homeworkGrades</code>, is pointing to?

* {:.fragment} yes, they're pointing to the same <code>Array</code> in memory
* {:.fragment} __let's check out an example in the next slide__ &rarr;


</section>

<section markdown="block">
## Arrays are Reference Types

__Based on your answer to the previous question, what would the output of this code be?__ &rarr;

<pre><code data-trim contenteditable>
public static void main(String[] args) {
  int[] grades = {90, 85, 95};
  Student s = new Student("Foo", "Bar", grades);
  System.out.println(s.getFullName());
  System.out.println(s.getAverageHomeworkGrade());

  grades[0] = 60;
  System.out.println(s.getAverageHomeworkGrade());
}
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
Foo Bar
90.0
60.0
</code></pre>

</section>



<section markdown="block">
## Wait? What? Why? 

Again, Arrays are references... 

* in this case the reference was passed in to the constructor
* consquently, the member variable references the same Array as the local variable in <code>main</code>

[Let's check out an abbreviated version of this in Python tutor's Java mode](http://www.pythontutor.com/visualize.html#code=%0Apublic+class+Student+%7B%0A%09String+firstName%3B%0A%09String+lastName%3B%0A%09int%5B%5D+homeworkGrades%3B%0A%09%0A%09public+static+void+main(String%5B%5D+args)+%7B%0A%09++++int%5B%5D+grades+%3D+%7B1,+2,+3%7D%3B%0A%09++++Student+s+%3D+new+Student(%22Foo%22,+%22Bar%22,+grades)%3B%0A%09%7D%0A%09Student(String+fn,+String+ln,+int%5B%5D+arr)+%7B%0A%09%09this.firstName+%3D+fn%3B%0A%09%09this.lastName+%3D+ln%3B%0A%09%09this.homeworkGrades+%3D+arr%3B%0A%09%7D%0A%09%0A%09double+getAverageHomeworkGrade()+%7B%0A%09%09int+total+%3D+0%3B%0A%09%09for(int+grade%3A+this.homeworkGrades)+%7B%0A%09%09%09total+%2B%3D+grade%3B%0A%09%09%7D%0A%09%09return+(double)+total+/+%0A%09%09%09%09this.homeworkGrades.length%3B%0A%09%7D%0A%09%0A%09String+getFullName()+%7B%0A%09%09return+this.firstName+%2B+%22+%22+%2B+this.lastName%3B%0A%09%7D%0A%7D%0A&mode=display&origin=opt-frontend.js&cumulative=false&heapPrimitives=true&textReferences=false&py=java&rawInputLstJSON=%5B%5D&curInstr=3)
</section>

<section markdown="block">
# References!

</section>

<section markdown="block">
## Let's Use the Circle Class from the Book...

<pre><code data-trim contenteditable>

class Circle {
  double radius = 1;

  Circle() { }

  Circle(double newRadius) {
    radius = newRadius;
  }

  double getArea() {
    return radius * radius * Math.PI; 
  }
  
  double getPerimeter() {
    return 2 * radius * Math.PI; 
  }

  void setRadius(double newRadius) {
    radius = newRadius;
  }
}
</code></pre>
</section>

<section markdown="block">
## References Illustrated

When we create an object....

<pre><code data-trim contenteditable>
// we're creating a reference variable, c
// we're creating a new circle object in memory
// and pointing the reference in c to it
Circle c = new Circle();
</code></pre>

<div markdown="block" class="img">
![alt](../../resources/img/object-reference-1.png)
</div>
</section>

<section markdown="block">
## References Continued

<pre><code data-trim contenteditable>
Circle c1 = new Circle(5);
Circle c2 = new Circle(9);
System.out.println(c2.radius);
c1 = c2;
System.out.println(c1.radius);
System.out.println(c2.radius);
</code></pre>

<div markdown="block" class="img">
![alt](../../resources/img/object-reference-2.png)
</div>
</section>

<section markdown="block">
## References

__What's the output of this code?__ &rarr;

<pre><code data-trim contenteditable>
Circle c1 = new Circle(5);
c1 = c2;
System.out.println(c1.radius);
System.out.println(c2.radius);

c2.setRadius(1);
System.out.println(c1.radius);
System.out.println(c2.radius);
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
1.0
1.0
</code></pre>

<span class="fragment">__Let's see this in python tutor's Java mode.__</span>
</section>

<section markdown="block">
## Pass-by-Value

In Java, when we pass arguments to a method, we actually pass __values__. __How is this possible when Arrays and Objects are references?__ &rarr;

* {:.fragment} the value of an Array or Object is _actually_ a __reference__!
* {:.fragment} the difference is a bit subtle... but... the value that is being passed into the method is the reference itself
* {:.fragment} consequently, "Java uses exactly one mode of passing arguments: pass-by-value."
* {:.fragment} (note that the book actually uses a less used, but more accurate, term in an earlier chapter... this is actually _pass-by-sharing_)
* {:.fragment} not explained so well in the book, [but wikipedia has a nice summary](http://en.wikipedia.org/wiki/Evaluation_strategy#Call_by_sharing)
</section>

<section markdown="block">
## Pass by Reference Examples


Create a class in <code>Widget.java</code>:

<pre><code data-trim contenteditable>
// in Widget.java
public class Widget {
  int x;
}

</code></pre>

__Using this class...__ &rarr;
</section>

<section markdown="block">
## Reference Example Continued 

__What's the output of this code?__ &rarr;

<pre><code data-trim contenteditable>
// in WidgetTest.java
public class WidgetTest {
  public static void main(String[] args) {
  	Widget w = new Widget();
  	w.x = 12;
  	System.out.println(w.x);
  	zero(w);
  	System.out.println(w.x);
  }
  public static void zero(Widget myWidget) {
  	myWidget.x = 0;
  }
}
</code></pre>
<pre class="fragment"><code data-trim contenteditable>
12
0
</code></pre>
</section>

<section markdown="block">
## And More About Passing Reference Types

(Just so you know) __when you reassign a value to the parameter name, you're not actually affecting the original value passed in__ &rarr;

<pre><code data-trim contenteditable>
// add to WidgetTest.java main method
createNewWidget(w);
// still 0! (not 423)
System.out.println(w.x);

// add this contrived method to demonstrate that w is
// unchanged
public static void createNewWidget(Widget myWidget) {
  myWidget = new Widget();
  myWidget.x = 423;
}
</code></pre>
</section>
  

<section markdown="block">
# Using Some Built in Java Classes

</section>

<section markdown="block">
## java.util.Date

Instantiating a <code>Date</code> object creates an object that represents (as you might expect) the current date and time.

* you can print out the date object (or use the toString method to get a string representation)
* you can use the getTime method to convert the date into a long that represents the number of milliseconds since 1/1/1970
<pre><code data-trim contenteditable>
import java.util.Date
....
Date d = new Date();
System.out.println(d);
System.out.println(d.getTime());
</code></pre>

</section>


<section markdown="block">
## java.util.Date Continued

There's also a constructor for <code>Date</code> that takes a <code>long</code>, the number of milliseconds, and turns it into a date object.

<pre><code data-trim contenteditable>
Date d = new Date(1425820093508l);
System.out.println(d);
// prints out Sun Mar 08 09:08:13 EDT 2015
</code></pre>
</section>

<section markdown="block">
## java.util.Random

A better way of generating random values is using Java's <code>Random</code> class. When you create a Random object, you have the following methods available:

<pre><code data-trim contenteditable>
nextInt()  // any of the possible 2^32 integers
nextInt(n) // from 0 up to (but not including) n
nextLong()
nextDouble()
nextFloat()
nextBoolean() // either true or false!
</code></pre>

__Let's try a few out.__ &rarr;
</section>

<section markdown="block">
# Static vs Instance

</section>
<section markdown="block">
## Instance Variables

In the following code, we print out the radius variable of both <code>c1</code> and <code>c2</code>.

<pre><code data-trim contenteditable>
Circle c1 = new Circle(5);
Circle c2 = new Circle(9);
System.out.println(c1.radius);
System.out.println(c2.radius);
</code></pre>

* __<code>radius</code>__ is an instance variable... 
* that is, it's a variable that each instance (or object) created from the Circle class has its own version of
* it is not shared among instances of the same class
* in fact, the two circles and their radii are stored in different parts of memory
</section>

<section markdown="block">
## Static Variables

__Static variables__ or __class variables__ are variables that are __shared among all instances of a class__!

* static variables store values for the variables in a common memory location
* if one object changes the value of a static variable, all objects of the same class are affected
* use the keyword, <code>static</code> to make a variable static (of course!)

<pre><code data-trim contenteditable>
static int countObjects = 0;
</code></pre>
</section>

<section markdown="block">
## Static Variables Example

__What's the output of the following code and why?__ &rarr;

<pre><code data-trim contenteditable>
public class Foo {
  static int countObjects;
  Foo() {
    countObjects++;
  }
}
</code></pre>

<pre><code data-trim contenteditable>
// in main of another class
Foo f1 = new Foo();
System.out.println(f1.countObjects);
Foo f2 = new Foo();
System.out.println(f1.countObjects);
System.out.println(f2.countObjects);
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
1
2
2
// countObjects is shared among all Foo objects
</code></pre>
</section>

<section markdown="block">
## Static Methods

When we define a method as static: 

* that means we can call the method without an instance an object to call it on
* ...we can call it:
	* on the class itself: ClassName.staticMethod();
	* or on an object: obj.staticMethod();

__Let's modify our Foo class to add a static method, addFive... all it does is take the argument that's passed in, and it adds five to it.__ &rarr;

</section>

<section markdown="block">
## Static Method Example

<pre><code data-trim contenteditable>
// new method
static int addFive(int x) {
  return x + 5;
}

// in main
System.out.println(Foo.addFive(10));
// or
Foo f = new Foo();
System.out.println(f.addFive(10));
</code></pre>

__Let's compare this to regular instance methods.__ &rarr;
</section>

<section markdown="block">
## Rules! 

There are rules regarding what fields and methods a method can access based on whether the method is an instance or static method.

<div markdown="block" class="img">
![alt](../../resources/img/static-instance.png)
</div>

</section>
<section markdown="block">
## A Summary

* __instance__ variables and methods:
	* can only be accessed through an instance (an object)
	* are not shared across objects (that is, each object has its own version of an instance variable)
	* instance methods can invoke and access both instance and static methods and fields
* __static__ variables and methods:
	* can be accessed through the actual class name or an object
	* are shared across all objects of the same class
	* static methods can only invoke and access static methods and fields

</section>

<section markdown="block">
## Hey... These Seem Familiar

__Where have we seen static methods before?__ &rarr;

* {:.fragment} public static void main ....
* {:.fragment} Integer.toString()
* {:.fragment} Character.isLetter()
* {:.fragment} Character.isDigit()
* {:.fragment} Math.sqrt(num)
</section>

<section markdown="block">
## When Do We Create Static vs Instance?

__This may seem obvious... but when do we make a method or variable static vs instance?__ &rarr;

* {:.fragment} if a variable must be unique per instance/object, then make it an instance variable
* {:.fragment} if a method must act on instance variables, make it an instance method
</section>

<section markdown="block">
# About Packages

</section>

<section markdown="block">
## A Quick Note on Packages

We had briefly mentioned packages in the previous class...

* I mentioned packages in relation to visibility
* ...and that classes in the same package can see each other
* ...and that essentially meant, if they're in the same _directory_, they can see each other
* __let's discuss that a little bit more to get an accurate picture of what's going on__ &rarr;
* (this isn't covered in the textbook)

</section>
<section markdown="block">
## No, Really... What's a Package?

A __package__ is a label or _namespace_ that can be applied to a class:

* __packages__ are used to __organize related classes__
* packages can also be used to provide namespaces... that is prevent __naming collisions__ between two different classes of the same name
* finally, they can also be used to control visibility...
* some examples of packages that we've seen include <code>java.util</code> and <code>processing.core</code>... __what are some classes that we've used that are in these packages__ &rarr;
	* {:.fragment} in <code>java.util</code>: <code>Scanner</code>, <code>Date</code>, <code>Arrays</code>, and <code>Random</code>
	* {:.fragment} in <code>processing.core</code>: <code>PApplet</code>
* {:.fragment} for example, all of [Processing's basic functionality is in a package called <code>processing.core</code>](https://github.com/processing/processing/blob/master/core/src/processing/core/PApplet.java) (and the source code is organized in a folder called <code>processing/core</code>)
	
</section>

<section markdown="block">
## Creating a Package

To specify that a class is in a particular package:

* use the keyword __<code>package</code>__, followed by the package name
	* the package name usually consists of one or more lowercase words separated by dots (periods)
	* for example, <code>package my.cool.stuff</code>
* the dot separated words _usually_ correspond to nested folders that your java file is in
* ([let's see... that means we should be able to find <code>Scanner.java</code> in <code>java.util</code> in java's source code](https://github.com/openjdk-mirror/jdk7u-jdk/tree/f4d80957e89a19a29bb9f9807d2a28351ed7f7df/src/share/classes))
* a package declaration is _usually_ placed at the beginning of your file, before your class definition and imports
* in eclipse, declaring a package an placing in a folder is done for you if you specify a package name in the class creation screen __let's see__ &rarr;
</section>

<section markdown="block">
## Using a Class in a Package

If you want to use a class that's in a package (such as <code>Date</code> or <code>Scanner</code>), __what code is required?__  __There are a few ways to do it (we know at least 1!):__ &rarr;

* {:.fragment} use __<code>import</code>__
	* {:.fragment} <code>import java.util.Scanner</code>
* {:.fragment} use <code>*</code> at the end of a package to denote all classes in the package
	* {:.fragment} <code>import java.util.*</code>
* {:.fragment} or use the _fully qualified_ (name of class and package that it's in) name in your code
	* {:.fragment} (you may have seen this in some of the book's examples)
	* {:.fragment} <code>java.util.Scanner input = new java.util.Scanner(System.in);</code>
	* {:.fragment} (this really helps illustrate namespacing!)

</section>

<section markdown="block">
## Default Package

* a class without a package specified is in the __default package__
* notice... when you __create a new file in Eclipse, it's placed in the default package__ if you don't specify a package name. __let's see__ &rarr;
* generally, placing something in the _default_ package / namespace is discouraged for all classes except for small programs (such as our homework assignments or the examples in the book!)...
</section>

<section markdown="block">
## Um. Why? Packages???

This seems to make things a little complicated. __Why would we ever need to use packages... and why is using the default package not recommended?__ &rarr;

* {:.fragment} prevent namespace collisions... for example: 
	* {:.fragment} what if there were two different class called <code>Account</code>:
	* {:.fragment} (yes, I know, terrible name to begin with)...  
	* {:.fragment} one that represents a savings account... 
	* {:.fragment} and another a web site user account?
* {:.fragment} organize / group packages with related functionality
* {:.fragment} control access to variables and methods in a class
</section>

<section markdown="block">
# Visibility Modifiers

</section>
<section markdown="block">
## Visibility Modifiers

__Visibility modifiers__ determine where a class and its members can be accessed. There are three modifiers that we'll look at (I guess there's also really a fourth). __What are they (we talked about two of them in the previous class?__ &rarr;

* {:.fragment} no modifier specified (default)
* {:.fragment} <code>private</code>
* {:.fragment} <code>public</code>
* {:.fragment} <code>protected</code>
</section>

<section markdown="block">
## Default Visibility Modifier

By __default__, the __variables__ and __methods__ of a class can be accessed by __any another class in the same package__. 

* we've been able to use member variables and methods in a class that exists in the same project in the examples and homework that we've done. __why is that?__ &rarr;
	* {:.fragment} they're all in the same package, default
	* {:.fragment} consequently they can see each other's member variables and methods
	* {:.fragment} __let's check it out__ &rarr;
* {:.fragment} __what would happen if we created one class, FooTest, in a default package, and another, Foo, in a package called mystuff?__ &rarr;
	* {:.fragment} __let's try it__ &rarr; (example in next slide)


</section>

<section markdown="block">
## Example Class

In <code>mystuff/Foo.java</code> (notice, no modifiers, so it's default):

<pre><code data-trim contenteditable>
package mystuff;

class Foo {
  int x;
}
</code></pre>

In the default package, <code>FooTest.java</code>:

<pre><code data-trim contenteditable>
import mystuff.Foo
</code></pre>

__What happens?__ &rarr; <span class="fragment">Oh... um... can't even see that class</span>

<span class="fragment">Let's fix it. __How?__ &rarr;</span>

<span class="fragment">Make the class public...</span>

</section>

<section markdown="block">
## Visibility Modifiers Continued

You can prefix a variable or class with:

* __<code>public</code>__ - <span class="fragment">visible to any other class</span>
* __<code>private</code>__ - <span class="fragment">only visible within the current class!</span>
* __<code>protected</code>__ - <span class="fragment">visible by subclasses (classes that extend this class - we'll see more about this later)</span>
</section>

<section markdown="block">
## Making the Foo Class Available

So... no problem if you're using everything in the default package... but __if you want to use a class that you defined in a separate package, you have to make it <code>public</code>__ &rarr;

<pre><code data-trim contenteditable>
package mystuff;

public class Foo {
  int x;
}
</code></pre>

<span class="fragment">Voila! (Now the import works!)</span>

</section>

<section markdown="block">
## Member Variables in Classes in Other Packages 

Ok... the import works in our FooTest.java file... great!

<pre><code data-trim contenteditable>
import mystuff.Foo;
</code></pre>

__Let's write a main method that creates a new Foo object and prints out it's data field, x.__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
class FooTest {
	public static void main(String[] args) {
		Foo f = new Foo();
		System.out.println(f.x);
	}
}
</code></pre>
</section>

<section markdown="block">
## Member Variables in Classes in Other Packages 

Seems like something is wrong. __What's the error?__ &rarr;

* {:.fragment} <code>x</code> is not visible! __how do we fix it?__ &rarr;
* {:.fragment} make that field public

<pre class="fragment"><code data-trim contenteditable>
package mystuff;

public class Foo {
  public int x;
}
</code></pre>
</section>

<section markdown="block">
## Recap 

__What just happened there? What's the visibility of a class and its members (variables and methnods)  by default?__ &rarr;

* {:.fragment} if there's no visibility modifier, a class and its members are only visible to other classes in the same package, and __not visible to classes outside of the package__ ...
* {:.fragment} __how do we fix this?__ &rarr;
* {:.fragment} make the class, data field or method __public__

<span class="fragment">__Soooooo... that's why you use the <code>public</code> visibility modifier.__</span>
</section>

<section markdown="block">
## Restricting Access with Private

If you want to do the opposite; that is make it so that no other classes can use the data field or method, make your class __private__.

* the private visibility modifier makes a data field or method only accessible from within the class that it's defined in!
* __let's see this in action reusing our bank account program__ &rarr;
	* create a bank account class
	* make a __private__ variable called balance


</section>

<section markdown="block">
## Bank Account Example

__What will happen if try to run this code? Some output, no output, or error?__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
// in BankAccount.java
class  BankAccount{
	private double balance = 0;
}
// in BankAccountTest.java
class BankAccountTest {
	public static void main(String[] args) {
		BankAccount acc = new BankAccount();
		System.out.println(acc.balance);
	}
}
</code></pre>

<span class="fragment">Oops... compile error! ... can't see balance</span>
</section>

<section markdown="block">
## Private Methods

__What happens for private methods?__ &rarr;

<pre><code data-trim contenteditable>
// in BankAccount.java
private boolean hasEnoughMoney(double amt) {
  return amt <= balance;
}
</code></pre>

<pre><code data-trim contenteditable>
// in BankAccountTest.java
System.out.println(acc.hasEnoughMoney(10.0));
</code></pre>

<span class="fragment">Same thing! __Compile error... hasEnoughMoney isn't visible.__</span>
</section>

<section markdown="block">
## Using Private Methods 

__So... who can use private methods?__ &rarr;

* {:.fragment} the class that it's in...
* {:.fragment} for example, within <code>BankAccount.java</code>, we can use <code>hasEnoughMoney</code>... __let's define our withdraw method again, and use hasEnoughMoney__ &rarr;


<pre class="fragment"><code data-trim contenteditable>
// in BankAccount.java
// (hasEnoughMoney is visible, we're in the class that the method is defined in)
public double withdraw(double amt) {
  if (hasEnoughMoney(amt)) {
    balance -= amt;
    return amt;
  } else {
    return 0;
  }
}
</code></pre>
</section>

<section markdown="block">
## Using the Private Visibility Modifier

__We know how <code>private</code> works mechanically, but in what situations would we use it? Why is it useful _at all_?__ &rarr;

* {:.fragment} the cheap answer is: when you don't want other classes tampering with data in another class or an object that's of a different class
* {:.fragment} maybe you want to prevent yourself from directly accessing data and bypassing any _rules_ around retrieving or setting that data
* {:.fragment} in our previous class / previous example... balance should be private, because you don't want to inadvertently write a program that overdraws the account

</section>

<section markdown="block">
## Controlling Access to Private Members

Soooo.... __if a variable is declared as private, how do we get access to it?__ &rarr;

* we'll use methods
* a method can return the value of the private variable
* and it can set the value of the private variable
</section>
<section markdown="block">
## Data Encapsulation

__Encapsulation__ is restricting access to data and methods of a class. Sometimes it's referred to as __information hiding__ as well.

* declare member variables as private... and only allow access to them via methods
* you can use __getters__ to retrieve values:
	* <code>public returnType getPropertyName()</code>
	* <code>public double getBalance()</code>
</section>

<section markdown="block">
## Data Encapsulation

* you can use __setters__ to change / set values:
	* <code>public void setPropertyName(dataType newPropertyValue)</code>
	* <code>public void setBalance(double amt)</code>
	* of course, if you have more appropriate actions, you can use those in place of __getters and setters__
	* for example, instead of <code>setBalance</code>, we wrote <code>deposit</code> and <code>withdraw</code>
* in the simplest case, these just return a value, and write a value... but you can insert logic / validation into each as well (such as checking if <code>hasEnoughMoney</code>)!

</section>

<section markdown="block">
## Encapsulation Recap

* make member variables <code>private</code> to prevent tampering
* you can use getters and setters to read and write to the member variable
	* __getters__ are methods that retrieve the value of a private variable
	* __setters__ are methods that change the value of a private variable
* sometimes these methods are also referred to as __accessors__ and __mutators__

</section>

<section markdown="block">
## Another Example of Data Encapsulation

...When creating our matrix class for the homework:

* we don't really want direct access to the internal representation of the matrix
	* (whoever is using the class shouldn't care if the matrix is contained in a 2d Array... or in some other structure)
	* __(oh wait, what other structure can we use to store a matrix?)__ &rarr; <span class="fragment">a 1d array?</span>
* so... we control access to it by 
	* {:.fragment} only allowing it to be set by the constructors
	* {:.fragment} ... then after that, we can access it by using methods
	* {:.fragment} so feel free to make the internal 2D array in your matrix private!

</section>

{% comment %}
* this
* toString
* Objects as references
* Java classes
	* Date
	* Random
* Static variables constants and methods
* Visibility
* Data field encapsulation / getters and setters
* Objects to methods
* Arrays of Objects
* Immutable objects and classes
* Scope
* this
{% endcomment %}
	
