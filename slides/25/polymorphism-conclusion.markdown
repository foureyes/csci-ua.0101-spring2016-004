---
layout: slides
title: "Polymorphism Conclusion"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
## Fundamental Features of Object Oriented Programming

Our book mentions that there are three main features of (_the pillars_ of) object oriented programming? __We've learned all three -- what are they, and give a definition for each?__ &rarr;

* {:.fragment} __encapsulation__ - controlling access to data and keeping implementation details _hidden_
* {:.fragment} __inheritance__ - defining a class based on an existing class
* {:.fragment} __polymorphism__ - a variable of a supertype (a type defined by a super class) can refer to a subtype (a type defined by a sub class) object
</section>

<section markdown="block">
## Polymorphism

A __class__ defines a type (when we create our own classes, we're creating custom types)

* a __subtype__ is a type defined by a subclass
* a __supertype__ is a type defined by a superclass

Sooo... __polymorphism__ means:

* a variable of type, supertype, can refer to a subtype  
* or, put another way, an instance of a subclass can also be considered an instance of that subclass's parent
* you can think of a subclass object as the same as a superclass object, but with additional (and possibly more specialized) features!
</section>

<section markdown="block">
## Polymorphism Examples


Consider the following classes...

<pre><code data-trim contenteditable>
class Animal {}
class Primate extends Animal {}
</code></pre>

__Will the code below compile? Will there be a runtime error? Or, will it work fine?__ &rarr;

<pre><code data-trim contenteditable>
public class PolymorphismDemo {
  public static void main(String[] args) {
    // hm... we have a variable of type Animal
	// we're setting it to an object of type Primate
    Animal animal1 = new Primate();
    Primate primate1 = new Primate();
    
    // Here's an array of animals, and we're putting 
	// Primates in it!
    Animal[] animals = {animal1, primate1};
  }
  
}
</code></pre>

<span class="fragment">Runs just fine! We can have a reference to a subtype even if a variable is declared as a supertype (even with Arrays!)</span>
</section>
<section markdown="block">
## Polymorphism Demo Continued

__What happens with methods - compile error, runtime error, or runs fine?__  &rarr;

<pre><code data-trim contenteditable>
public static void printAnimal(Animal a) {
    System.out.println(a);
}

// in our previous main method, call printAnimal.
// hey, primate1 is of type Primate, but the signature of
// printAnimal expects type Animal!
printAnimal(primate1);
</code></pre>

<span class="fragment">This also works without a problem! Polymorphism FTW!</span>
</section>

<section markdown="block">
## The Other Way Around?

Let's check out this code:

<pre><code data-trim contenteditable>
Primate primate2 = new Animal()
</code></pre>

__What do you think happense here? Compile error, runtime error, or runs just fine?__ &rarr;

* {:.fragment} we get: <code> cannot convert from Animal to Primate</code>
* {:.fragment} in this case, declaring a subtype (a more specialized type) variable and assigning it a supertype causes a compile error!
</section>

<section markdown="block">
## instanceof

Java offers a few ways to _introspect_ an object.  One way to check if a subclass really is an instance of itself and _its superclasses_ is to use the __<code>instanceof</code>__ operator.

* syntax: <code>obj instanceof classname</code>
* it will return true if the object is an instance of the class
* note that __it's an operator__, not a method!
* it only works if the object is cast-able to the class on the right

</section>

<section markdown="block">
## instanceof Continued

Based on the <code>Animal</code> and <code>Primate</code> classes that we've seen, __what's the output of this code?__ &rarr;

<pre><code data-trim contenteditable>
Primate primate1 = new Primate();
Animal justAnimal1 = new Animal();
System.out.println(primate1 instanceof Animal);
System.out.println(primate1 instanceof Primate);
System.out.println(primate1 instanceof Object);
System.out.println(justAnimal1 instanceof Primate);
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
true
true
true
false
</code></pre>
</section>

<section markdown="block">
## So Many Methods, Which One?

A method can be defined multiple times throughout the inheritance chain:

* (that is a method in a subclass may _override_ a superclass method)
* __How does Java know which one to execute?__ 
* __Based on the behavior that you've seen so far, what can you conclude?__ &rarr;
* {:.fragment} Java looks in the class itself first, then it travels up the inheritance chain
* {:.fragment} (until it gets to the <code>Object</code> class, which we talked about last class, and we'll discuss again today)


</section>

<section markdown="block">
## Dynamic Binding

So, Java _doesn't actually know_ at compile time:

* which version of a method in the inheritance chain will be called!
* (this is specifically for overridden methods)

__Dynamic binding__ is a programming language mechanism that allows a method being called to be looked up by name during runtime!

* in Java, overridden methods are looked up at run time
* (however, overloaded and static methods are looked up at compile time, so the compiler can complain about those)
</section>

<section markdown="block">
## An Example of Dynamic Binding

__Check out these classes...__ &rarr;

<pre><code data-trim contenteditable>
class  Nonsense {
  public void sayNonsense() {
    System.out.println("NONSENSE!");
  }
}
</code></pre>

<pre><code data-trim contenteditable>
class Bar extends Nonsense { }
</code></pre>

<pre><code data-trim contenteditable>
class Qux extends Bar {
  public void sayNonsense() {
    System.out.println("QUX!");
  }
}
</code></pre>
</section>

<section markdown="block">
## Dynamic Binding Continued

Based on the classes in the previous slide, __what is the output of this code__? &rarr;

<pre><code data-trim contenteditable>
Bar b = new Bar();
Qux q = new Qux();
b.sayNonsense();
q.sayNonsense();
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
NONSENSE!
QUX!
</code></pre>
</section>


<section markdown="block">
## A Little Test

__Let's create a bare bones class called <code>Simple</code>.__ &rarr;

<pre><code data-trim contenteditable>
class Simple { }
</code></pre>

We haven't declared any methods, but let's see if we can call some. __Let's create an instance of our class in a main method... and let's try printing out the results of calling these methods:__ &rarr;

* <code>hashCode()</code>
* <code>equals()</code>
* <code>toString()</code>

</section>

<section markdown="block">
## A Mystery!

Whoah. If we didn't declare theses methods, __where did they come from and how did they get into our object?__ &rarr;

(we saw this in our previous class, last week...)

* {:.fragment} it turns out that all objects inherit from a common superclass
* {:.fragment} this superclass defines methods, such as <code>hashCode</code>, <code>equals</code>, and <code>toString</code>
</section>

<section markdown="block">
## java.lang.Object

__Every class in Java descends from a class called <code>Object</code>!__

* {:.fragment} the classes we make are also subclasses of <code>Object</code>
* {:.fragment} even if we never explicitly <code>extend</code> <code>Object</code>
* {:.fragment} when we define a class like this:

<pre class="fragment"><code data-trim contenteditable>
class Simple {
}
</code></pre>

<span class="fragment">It's the same as this:</span>

<pre class="fragment"><code data-trim contenteditable>
class Simple extends Object {
}
</code></pre>
</section>

<section markdown="block">
## And What If We Already Have a Parent

If our class already extends another class, we can just follow the inheritance chain.

Eventually, we'll get to <code>Object</code>.

Consequently, every class that we make will have several methods already defined. __Let's take a look at...__ &rarr;

* <code>getClass</code>
* <code>hashCode</code>
* <code>equals</code>
* <code>toString</code>

__You can actually override most of these methods to suit your class!__ ....
</section>

<section markdown="block">
## Oh Yeah, Java Documentation

We checked out the Java API docs in class a while ago. __How many people have actually looked at the Java API online documentation?__ &rarr;

You can find the docs here:

[https://docs.oracle.com/javase/6/docs/api/](https://docs.oracle.com/javase/6/docs/api/)

__Let's take a look at what it says about [Object](http://docs.oracle.com/javase/6/docs/api/java/lang/Object.html)__ &rarr;

</section>

<section markdown="block">
## First, getClass

__<code>getClass</code>__:

* returns the _run time_ class of an object:
* this is the object's _actual_ class (which may not match its declared type!)

We can print it out the result of calling it to see what the class of an object is...

__Let's see.__ &rarr;

</section>

<section markdown="block">
## Using getClass

__What's the output of this code?__ &rarr;

<pre><code data-trim contenteditable>
class Simple {}
class Simpler extends Simple {}
</code></pre>

<pre><code data-trim contenteditable>
public class SimpleTest {
	public static void main(String[] args) {
		Simple s1 = new Simple();
		Simpler s2 = new Simpler();
		Integer i = new Integer(5);
		System.out.println(s1.getClass());
		System.out.println(s2.getClass());
		System.out.println(i.getClass());
	}
}
</code></pre>
<pre class="fragment"><code data-trim contenteditable>
class Simple
class Simpler
class java.lang.Integer
</code></pre>
</section>

<section markdown="block">
## A Tricky getClass Example

Using these two classes...

<pre><code data-trim contenteditable>
class Animal {}
class Primate extends Animal {}
</code></pre>

__What's the output of this code?__ &rarr;

<pre><code data-trim contenteditable>
Animal animal1 = new Primate();
System.out.println(animal1.getClass());
</code></pre>

<span class="fragment">In this case, we get <code>class Primate</code></span>
</section>

<section markdown="block">
## HashCode

<code>hashCode</code> gives back an integer value representing an object. 

Whenever it is called on the same object during the execution of a program it should return the same value! __Let's see a demo.__ &rarr;

<pre><code data-trim contenteditable>
Simple simple1 = new Simple();

// setting reference to same object
Simple simple2 = simple1;

// print out the hash code of each...
System.out.println(simple1.hashCode());
System.out.println(simple2.hashCode());
</code></pre>

<pre><code data-trim contenteditable>
The two numbers printed out should be the same.
</code></pre>
</section>

<section markdown="block">
## toString

The <code>Object</code> class's __<code>toString</code>__ method returns a <code>String</code> representation of an object. The default contents of the <code>String</code> is.... 

* {:.fragment} the name of the class of which the object is an instance
* {:.fragment} the at-sign character '@'
* {:.fragment} the unsigned hexadecimal representation of the hash code of the object

<pre class="fragment"><code data-trim contenteditable>
getClass().getName() + '@' + Integer.toHexString(hashCode())
</code></pre>

<span class="fragment">__Let's try it out.__ &rarr;</span>


<pre class="fragment"><code data-trim contenteditable>
System.out.println(simple1);
System.out.println(simple1.getClass());
System.out.println(simple1.hashCode());
System.out.println(Integer.toHexString(simple1.hashCode()));
</code></pre>
</section>

<section markdown="block">
## toString Continued

Soooo... <code>toString</code> doesn't seem that useful. We can always override it so that it does something more meaningful. __To override toString:__ &rarr;

* in your class, implement a method with the following signature:
* <code>public String toString()</code>
* __NOTE THAT THIS METHOD IS CALLED__ on the object that's passed to <code>System.out.println</code>
	* that is, <code>System.out.println(someObj)</code>
	* is essentially <code>System.out.println(someObj.toString())</code>
</section>

<section markdown="block">
## toString Example

__What's the output of the code below?__ &rarr;

<pre><code data-trim contenteditable>
public class Point2D {
	int x, y;
	Point2D(int x, int y) { this.x = x; this.y = y;}
	public String toString() {
		System.out.println("In toString!");
		return String.format("(%s, %s)", x, y);
	}
	
	public static void main(String[] args) {
		Point2D origin = new Point2D(0, 0);
		System.out.println(origin);
	}
}
</code></pre>
</section>

<section markdown="block">
## Equals

The __<code>equals</code>__ method (as the name implies) indicates whether some object, the parameter is "equal to" the object that the <code>equals</code> method is being called on.

* for any non-null reference values x and y, this returns true if and only if x and y __refer to the same object__ (x == y has the value true).
* you can think of the default implementation as this:

<pre><code data-trim contenteditable>
public boolean equals(Object obj) { return (this == obj); }
</code></pre>

* the version above checks whether two reference variables point to the same object using the == operator
</section>

<section markdown="block">
## Equals Example

__What's the output of this code?__ &rarr;

<pre><code data-trim contenteditable>
Simple simple1 = new Simple();
Simple simple2 = simple1;
Simple simple3 = new Simple();

System.out.println(simple1.equals(simple2));
System.out.println(simple1.equals(simple3));
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
true
false
</code></pre>
</section>


<section markdown="block">
## Overriding Equals

Just like <code>toString</code>, __the <code>equals</code> method can be overridden__! We can override this method in our custom classes to test whether two distinct objects have the same content.

* {:.fragment} the required signature for overriding equals is: __<code>public boolean equals(Object obj)</code>__
* {:.fragment} note that the argument passed in is of type <code>Object</code>!
* {:.fragment} in the body of this method, you dictate what makes another object equal to the object that the method is being called on.
* {:.fragment} for <code>String</code>, __this method is overridden__ so that it checks characters (that is, both objects represent the same sequence of characters)
</section>

<section markdown="block">
## Overriding Equals Example

__Create a Circle class that contains radius as a member variable.__ &rarr;

* try creating two different <code>Circle</code> objects with the same radius to check if they're equal
* __what will this print out?__ &rarr;


<pre class="fragment"><code data-trim contenteditable>
Circle c1 = new Circle(5);
Circle c2 = new Circle(5);
System.out.println(c1.equals(c2));
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
class Circle{
	double radius;
	Circle(double radius) { this.radius = radius; }
}
</code></pre>

<pre><code data-trim contenteditable>
false
</code></pre>
</section>

<section markdown="block">
## Overriding Equals Continued

* __now, override the <code>equals</code> method (don't forget the annotation) so that the <code>Circle</code> object's with the same radius are considered equal__ &rarr;
* our initial version of this (revealed below) __won't quite work__.  __Why?__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
class Circle{
	double radius;
	Circle(double radius) { this.radius = radius; }
	public boolean equals(Object obj) {
		return this.radius == obj.radius;
	}
}
</code></pre>
</section>

<section markdown="block">
## Overriding Equals Continued

It looks like it can't find radius! Hm. But isn't that a <code>Circle</code> object that we passed in? __What can we do to let the compiler know that we have a <code>Circle</code> object?__ &rarr;

* {:.fragment} cast it to a <code>Circle</code>
* {:.fragment} <code>(Circle) obj</code>

<pre class="fragment"><code data-trim contenteditable>
class Circle{
	double radius;
	Circle(double radius) { this.radius = radius; }
	public boolean equals(Object obj) {
		return this.radius == ((Circle) obj).radius;
	}
}
</code></pre>
</section>

<section markdown="block">
## Casting Objects

Wait, what was that all about? __What's casting (implicit and explicit) again, and what's the syntax?__ &rarr;

* {:.fragment} casting is converting from one type to another
* {:.fragment} explicit casting: type enclosed in parentheses, followed by value
* {:.fragment} (Type) myVariable
* {:.fragment} implicit casting: Java just does it for you!
</section>

<section markdown="block">
## Casting Objects Continued

__Is there casting here?__ &rarr;

<pre><code data-trim contenteditable>
Object o = new Circle()
</code></pre>

<span class="fragment">Yes! __Explicit casting!__ __What is the declared type of the variable, o?__ &rarr;</span>

<span class="fragment">It's an <code>Object</code>! __What's its actual type?__ &rarr;</span>

<span class="fragment">It's a <code>Circle</code> (but the compiler thinks it's an <code>Object</code> because of how it's declared</span>





</section>

<section markdown="block">
## Back the Other Way

Now... what if we tried to assign that variable, o, to another variable that's of type <code>Circle</code>? __Let's see what happens__ &rarr;

<pre><code data-trim contenteditable>
Circle c = o;
</code></pre>

<span class="fragment">We get a compilation error</span>.

* {:.fragment} a <code>Circle</code> is always an instance of an <code>Object</code>
* {:.fragment} but an <code>Object</code> isn't necessarily a <code>Student</code>
* {:.fragment} in this case, we have to explicitly cast: <code>Circle c = (Circle) o;</code>
</section>

<section markdown="block">
## Explicit Casting

Some rules regarding casting objects.

* it is always possible to cast an instance of a subclass to a variable of a superclass (known as __upcasting__)
* again, this is because an instance of a subclass is always an instance of its superclass 
* when casting an instance of a superclass to a variable of its subclass (known as downcasting), __explicit casting is necessary__ (this is also called __downcasting__)
* if the superclass object is not an instance of the subclass, a runtime ClassCastException occurs


</section>

<section markdown="block">
## Casting Example

__What's the output of this code? Compile Error? Runtime Error? Object hashcodes?__ &rarr;

<pre><code data-trim contenteditable>
Object o1 = new Object();
Object o2 = new Circle();

Circle c1 = (Circle) o1;
Circle c2 = (Circle) o2;

System.out.println(c1);
System.out.println(c2);
</code></pre>

<span class="fragment">We actually get a runtime error... <code>ClassCastException</code> </span>
</section>

<section markdown="block">
## Arrays and Sad Faces :( :( :(

So... if there were one thing that you could change about Java <code>Array</code>s, what would it be?

<span class="fragment">(I bet you'd want to make it so they're not fixed size!)</span>

</section>

<section markdown="block">
## ArrayLists

So... there's a class that does this for us -- the __<code>ArrayList</code>__ class!  &rarr;

* {:.fragment} the ArrayList class stores objects 
* {:.fragment} but its size can change dynamically!
* {:.fragment} (Hold on, is this for real? [Is it Christmas?](https://isitchristmas.com/))
</section>

<section markdown="block">
## 	The ArrayList Class

An <code>ArrayList</code> is a generic class with a generic type. 

The <code>ArrayList</code> works a little bit differently from other types. Because it's a collection of objects, you have to specify what kind of objects go into it by using a syntax we haven't seen yet:


<pre><code data-trim contenteditable>
ArrayList&lt;ObjectName&gt; variableName = new ArrayList&lt;ObjectName&gt;();
</code></pre>

This creates an <code>ArrayList</code> that stores Circles...

<pre><code data-trim contenteditable>
ArrayList&lt;Circle&gt; circles = new ArrayList&lt;Circle&gt;();
</code></pre>
</section>

<section markdown="block">
## ArrayList Methods

* <code>add</code>
* <code>remove</code>
* <code>indexOf</code>
* <code>get</code>
* <code>contains</code>
* <code>isEmpty</code>
* <code>lastIndexOf</code>
* <code>size</code>

</section>

<section markdown="block">
## An ArrayList Example

<pre><code data-trim contenteditable>
import java.util.ArrayList;

public class UsingArrayList {
  public static void main(String[] args) {
    // the type that your array list will contain goes in the "angle brackets"
    ArrayList&lt;String&gt; cities = new ArrayList&lt;String&gt;();
    cities.add("Albany");
    cities.add("Ithaca");
    cities.add("Rochester");
    for(String city: cities) {
      System.out.println(city);
    }
  }
}
</code></pre>

</section>
{% comment %}
## ArrayList
## Protected Again
## Preventing Extending
## this and super
## object and print
{% endcomment %}
