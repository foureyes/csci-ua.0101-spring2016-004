---
layout: slides
title: "Immutable Classes, Class Relationships, Primitives as Objects, BigInteger, BigDecimal"
---

<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>
<section markdown="block">
## Immutable Classes

</section>

<section markdown="block">
## _Things_ Never Seem to Change

__Are there any classes (that are part of the core Java API) that we've seen that cannot be changed (that is... immutable?__ &rarr;

<span class="fragment">Yes, of course. __Strings__!</span>

<span class="fragment">So... __have the objects that we've created so far been immutable or mutable?__ &rarr;</span>

<span class="fragment">_Usually_ mutable, right?  __Let's see.__ &rarr;</span>

</section>

<section markdown="block">
## Let's Take a Look

Here's a tiny implementation of a tiny <code>String</code>-like class. __Is it mutable?__ &rarr; 

<pre><code data-trim contenteditable>
public class MyString {
  public char[] chars;
  
  MyString(char[] chars) {
    this.chars = chars;
  }
  void setChars(char[] chars) {
    this.chars = chars;
  }
  char[] getChars() {
    return this.chars;
  }
}
</code></pre>

<span class="fragment">Why... YES! __Let's see how__ &rarr;</span>

</section>

<section markdown="block">
## Mutating MyString Objects

Ok. After we create a <code>MyString</code> object, __what are the ways we can mess with it! How do we change it?__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
// makin' the String
char[] chars1 = {'h', 'e', 'l', 'l', 'o'};
MyString ms = new MyString(chars1);
System.out.println(ms.getChars());
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
// #1, just use the setter! (obvs)
char[] newChars = {'h', 'i'};
ms.setChars(newChars);
System.out.println(ms.getChars());
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
// #2, access the chars Array directly!!
char[] newerChars = {'b', 'y', 'e', '!'};
ms.chars = newerChars;
System.out.println(ms.getChars());
</code></pre>

</section>


<section markdown="block">
## Mutating MyString Objects Continued

So... those were easy ones... __are there any other ways to change our MyString object?__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
// reset
char[] chars2 = {'h', 'e', 'l', 'l', 'o'};
ms = new MyString(chars2);
System.out.println(ms.getChars());pre
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
// #1, change the ref we passed in!!!
chars2[0] = 'c';
System.out.println(ms.getChars());
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
// #2, get a ref back, change that!!!!
char[] charsFromMyString = ms.getChars();
charsFromMyString[4] = 's';
System.out.println(ms.getChars());
</code></pre>

</section>
<section markdown="block">
## Making an Object Immutable

Let's seal up our <code>MyString</code> class so that an instance  __can't be changed after it's created__ &rarr;

* {:.fragment} get rid of the setter!
* {:.fragment} make chars <code>private</code> and <code>final</code> (__what?__ &rarr;)
	* {:.fragment} once a value has been assigned to a <code>final</code> variable, it can't be changed!
* {:.fragment} change the constructor so that it copies the incoming <code>Array</code>
	* {:.fragment} watch out for <code>Arrays</code> of objects! __why?__ &rarr;
	* {:.fragment} we'll take a look at this in a bit... but copying Arrays copies the references over!
* {:.fragment} don't return any references
* {:.fragment} __let's try coding it up...__ &rarr;
</section>

<section markdown="block">
## An Immutable Version of MyString

<pre><code data-trim contenteditable>
// make this private and final
private final char[] chars;
</code></pre>

<pre><code data-trim contenteditable>
// don't allow a reference to sneak in, copy it
MyString(char[] chars) {
  this.chars = new char[chars.length];
  System.arraycopy(chars, 0, this.chars, 0, this.chars.length);
}
</code></pre>

<pre><code data-trim contenteditable>
// get rid of that setter
</code></pre>

<pre><code data-trim contenteditable>
// don't allow a reference to leak out, copy it
char[] getChars() {
  char[] ret = new char[this.chars.length];
  System.arraycopy(this.chars, 0, ret, 0, this.chars.length);
  return ret;
}
</code></pre>

</section>

<section markdown="block">
## Testing Immutable MyString Part 1


Oh... so we don't even have a setter or direct access, so __the first two couple of tests aren't even valid!__ &rarr;
<pre><code data-trim contenteditable>
// makin' the String
char[] chars1 = {'h', 'e', 'l', 'l', 'o'};
MyString2 ms = new MyString2(chars1);
System.out.println(ms.getChars());

// #1, just use the setter! (obvs)
//char[] newChars = {'h', 'i'};
//ms.setChars(newChars);
//System.out.println(ms.getChars());

// #2, access the chars Array directly!!
//char[] newerChars = {'b', 'y', 'e', '!'};
//ms.chars = newerChars;
//System.out.println(ms.getChars());

</code></pre>

</section>

<section markdown="block">
## Testing Immutable MyString Part 2

Hey. Well, look at that. Our original <code>MyString</code> object, <code>ms</code>, __stays the same!__ &rarr;

<pre><code data-trim contenteditable>
// reset
char[] chars2 = {'h', 'e', 'l', 'l', 'o'};
ms = new MyString2(chars2);
System.out.println(ms.getChars());pre

// #1, change the ref we passed in!!!
chars2[0] = 'c';
System.out.println(ms.getChars());

// #2, get a ref back, change that!!!!
char[] charsFromMyString = ms.getChars();
charsFromMyString[4] = 's';
System.out.println(ms.getChars());
</code></pre>

</section>


<section markdown="block">
## Immutable Class Summary

That was a _fun_ adventure. __How do you think we can make an immutable object then? What did we just do?__ &rarr;

* {:.fragment} all data fields are <code>private</code> and <code>final</code>
* {:.fragment} no setters
* {:.fragment} no getters return a reference
* {:.fragment} watch out for references sneaking in!
	* {:.fragment} copy incoming reference types
	* {:.fragment} or design constructors and methods in such a way that they create a new object rather than accept a reference type
</section>

<section markdown="block">
## Why Bother, I Like Change!?

Hm... this is a tough one. Immutable objects seem to just make things more _difficult_. They do have their place, though! __Why would we want to make immutable objects?__ &rarr;

* {:.fragment} Immutable objects are, arguable, easier to maintain, as there are never any accidental side effects
	* {:.fragment} for example, it's sometimes unexpected when an Array's value is changed
	* {:.fragment} ... especially when there are many references to it!
* {:.fragment} the design of your program calls for objects that don't (or shouldn't) need to be changed (__um... examples?__ &rarr;)
	* {:.fragment} Coin (do coins ever change once you create one?)
	* {:.fragment} Playing Cards
* {:.fragment} Want more info? [Check out Oracle's page on immutable objects.](https://docs.oracle.com/javase/tutorial/essential/concurrency/imstrat.html)

</section>

<section markdown="block">
# Copying an Array of Objects is Tricky 

</section>

<section markdown="block">
## An Example

__What are two ways of copying this <code>Array</code> of objects?__ &rarr;

<pre><code data-trim contenteditable>
public class Foo {
  int n;
  
  Foo(int n) {
    this.n = n;
  }
}
</code></pre>

<pre><code data-trim contenteditable>
Foo[] foos1 = {new Foo(1), new Foo(2), new Foo(3)};
// LET'S GET COPYING!
</code></pre>

* {:.fragment} loop and assign...
* {:.fragment} arraycopy
</section>


<section markdown="block">
## OMG References!

We _could_ do this... but it's references all the way down.

<pre><code data-trim contenteditable>
Foo[] foos1 = {new Foo(1), new Foo(2), new Foo(3)};
Foo[] foos2 = new Foo[foos1.length];
Foo[] foos3 = new Foo[foos1.length];
</code></pre>

<pre><code data-trim contenteditable>
// foos1 and foos2 elements point to the same objects
for(int i = 0; i < foos1.length; i++) {
  foos2[i] = foos1[i];
}
</code></pre>

<pre><code data-trim contenteditable>
// same w/ arraycopy...
// foos1 and foos3 elements point to the same objects
System.arraycopy(foos1, 0, foos3, 0, foos1.length);
</code></pre>
[It's easier to see that these are all the same references... in Python tutor's Java mode (lots of arrows!)](http://www.pythontutor.com/visualize.html#code=public+class+Foo+%7B%0A%09int+n%3B%0A%09%0A%09Foo(int+n)+%7B%0A%09%09this.n+%3D+n%3B%0A%09%7D%0A%09%0A++++public+static+void+main(String%5B%5D+args)+%7B%0A++++++++Foo%5B%5D+foos1+%3D+%7Bnew+Foo(1),+new+Foo(2),+new+Foo(3)%7D%3B%0A++++++++Foo%5B%5D+foos2+%3D+new+Foo%5Bfoos1.length%5D%3B%0A++++++++Foo%5B%5D+foos3+%3D+new+Foo%5Bfoos1.length%5D%3B%0A++++++++%0A++++++++//+foos1+and+foos2+elements+point+to+the+same+objects%0A++++++++for(int+i+%3D+0%3B+i+%3C+foos1.length%3B+i%2B%2B)+%7B%0A++++++++%09%09foos2%5Bi%5D+%3D+foos1%5Bi%5D%3B%0A++++++++%7D%0A++++++++%0A++++++++//+same+w/+arraycopy...%0A++++++++//+foos1+and+foos3+elements+point+to+the+same+objects%0A++++++++System.arraycopy(foos1,+0,+foos3,+0,+foos1.length)%3B%0A++++%7D%0A%7D&mode=display&origin=opt-frontend.js&cumulative=false&heapPrimitives=true&textReferences=false&py=java&rawInputLstJSON=%5B%5D&curInstr=35)
</section>
<section markdown="block">
## Um. Ok. How?

If we actually want a __deepcopy__ of an <code>Array</code> of objects...

* {:.fragment} we could just create new objects based on the original objects? 
	* {:.fragment} <code>MyClass newObj = newObj();</code>
	* {:.fragment} <code>newObj.setField1(oldObj.field1);</code>
	* {:.fragment} <code>newObj.setField2(oldObj.field2);</code>
* {:.fragment} we could _clone()_ ... but we'll have to talk about interfaces first (we'll do that soon!)

</section>
<section markdown="block">
# Class Relationships 
</section>

<section markdown="block">
## Designing Classes

So far, all of the assignments, class activities and exam questions have dictated the classes that you've created.

Those __classes__ were usually __related together__ in some manner. __For example, in the Library assignment, what were the relationships between <code>Library</code>, <code>Book</code>, and <code>Person</code>?__ &rarr;

* {:.fragment} a <code>Library</code> has books, a bunch of <code>Book</code> objects
* {:.fragment} each <code>Book</code> has an author, a <code>Person</code>
* {:.fragment} __let's examine these relationships a little bit further__ &rarr;
</section>

<section markdown="block">
## Common Relationships

__There are three common relationships between classes:__ &rarr;

1. {:.fragment} Association
2. {:.fragment} Aggregation
3. {:.fragment} Composition

<span class="fragment">(The last two are just subsets of association)</span>

</section>
<section markdown="block">
## Association

An __association__ is a generic relationship type between classes that describes some link or activity between those classes. The book mentions that this is usually a _binary_ relationship (it describes how two classes are related), though three (ternary) or more classes may be involved as well. 

Associations consist of a description of the activity / link, as well as _multiplicity_: a bike __has__ __two__ wheels

Other examples of association include:

* {:.fragment} a <code>Student</code> takes many <code>Course</code>s
* {:.fragment} a <code>Course</code> is taught by one instructor, a <code>Person</code>
* {:.fragment} a <code>Library</code> contains many <code>Book</code>s

</section>


<section markdown="block">
## Aggregation

__Aggregation__ is a specific type of __assocation__ that represents a part of a whole relationship

* that is, one object has another object / objects (an object is made up of other component object(s))
* the container is the __aggregating__ class, while the component as the __aggregated__ class
* this is sometimes called a _weak_ __has a__ relationship
* other objects may have a references to the component
* if the __aggregating object is removed__, __its component (aggregated) objects may still exist__ (because of references from other objects)
* must be binary - between two classes
* ...though the classes can be the same! A <code>Person</code> object can hold another <code>Person</code> object (__when would this be useful__ &rarr; <span class="fragment">maybe an employee / supervisor relationship</span>)

</section>
<section markdown="block">
## Composition

__Composition__ also represents a part-of-a-whole relationship...

* however, __composition__ specifies that that the component object __fully depends__ on the containing object
* that is, the component is fully encapsulated / exclusively owned (no other objects have a reference to it)
* this is sometimes called a _strong_ __has a__ relationship
* __when containing class is removed, the component is also removed!__
</section>


<section markdown="block">
## When?

Using aggregation or composition is solely a design decision. What relationship best fits the objects in your program? __Let's discuss.__ &rarr;

Maybe you're writing an application that has a <code>Car</code> class and an <code>Engine</code> class. __What is the relationship if...__ &rarr;

* {:.fragment} the application is an inventory tracking program, where you sell car parts
	* {:.fragment} aggregation probably makes sense here, as each individual engine may exist even when a car doesn't
* {:.fragment} the application is a racing game where engines are not swappable
	* {:.fragment} composition seems like the best candidate, as the engine would not exist without the car, and is not referenced by any other cars

</section>

<section markdown="block">
## How to Implement

Hopefully that made _some_ sense conceptually. How would we implement these relationships?

__First, let's talk about the general case of implementing a generic association__ &rarr;

* {:.fragment} __has one__ - as a member variable
* {:.fragment} __has many__ - an <code>Array</code> of objects member variable
</section>

<section markdown="block">
## Implementing Aggregation vs Composition

We know that these will both be member variables (and in fact, the book stops there). __However, how do you think we'd model aggregation vs composition?__ &rarr; Some things to remember:

* Aggregation:
	* other objects may reference component
	* if container is removed, component may still exist
* Composition:
	* component is fully owned / encapsulated by container
	* when container is removed, component will no longer exist
</section>

<section markdown="block">
## A Car Example

Assume we have three classes:

* <code>Car</code>
* <code>AirConditioner</code>
* <code>Person</code> (passenger)

__Let's see their implementation... and from there, you can figure out what their relationships are__ &rarr;
</section>

<section markdown="block">
## Person and AirConditioner

<pre><code data-trim contenteditable>
public class Person {
  String firstName;
  String lastName;

  Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
</code></pre>

<pre><code data-trim contenteditable>
public class AirConditioner {
  boolean on = false;
}
</code></pre>
</section>

<section markdown="block">
## Car

<pre><code data-trim contenteditable>
public class Car {
  private AirConditioner ac;
  private Person[] passengers;
  private int numPassengers = 0;
  
  Car(int seats) {
    passengers = new Person[seats];
    ac = new AirConditioner();
  }
  
  boolean addPassenger(Person p) {
    if(numPassengers < passengers.length) {
      passengers[numPassengers] = p;
      numPassengers++;
      return true;
    }
    return false;
  }
</code></pre>
</section>

<section markdown="block">
## All Together Now!

__And... some example usage.__ &rarr;

<pre><code data-trim contenteditable>
public static void main(String[] args) {
  Car c = new Car(2);
  Person p1 = new Person("Alice", "Alvarez");
  Person p2 = new Person("Bob", "Bennett");
  Person p3 = new Person("Carol", "Chin");

  System.out.println(c.addPassenger(p1));
  System.out.println(c.addPassenger(p2));
}
</code></pre>
</section>

<section markdown="block">
## What are The Class Relationships?

We just saw the implementations for a <code>Person</code>, <code>AirConditioner</code>, and <code>Car</code> class. __What are their relationships, and why?__ &rarr;

* {:.fragment} __composition__ between <code>Car</code> and <code>AirConditioner</code> (note that adding a person passes in a reference, rather than creating a new one)
* {:.fragment} __aggregation__ between <code>Car</code> and <code>Person</code> (AirConditioner is completely contained; it's not accessible, it's created in the class itself)

</section>
  

 
<section markdown="block">
## Composition, Aggregation Implementation

__Sooo... based on what we just saw, what are some strategies for implementing composition and aggregation?__ &rarr;


<span class="fragment">__Aggregation__</span>

* {:.fragment} pass references in to set components rather than create new objects within the class
* {:.fragment} allow references to be accessible 

<span class="fragment">__Composition__</span>

* {:.fragment} make the member variable <code>private</code>
* {:.fragment} don't allow access to it by reference (don't return a reference to it, the constructor should copy or create new, etc.)

</section>

<section markdown="block">
# Primitives as Objects

</section>
<section markdown="block">
# Primitives vs Objects

So... there are two kinds of types in Java. __Primitives__ and __reference__ types. __Why do you think Java was designed in this way?__ &rarr;

* {:.fragment} processing / working with objects actually require a lot of overhead; primitives are faster to work with!
* {:.fragment} ... so, make the most often used types primitives

<span class="fragment">__How are primitives and references types different?__ &rarr;</span>

* {:.fragment} primitives are fixed size and contain the actual value
* {:.fragment} reference types also contain a value, but their value is a reference... that points to an object in memory
* {:.fragment} objects have fields and methods, primitives do not!
</section>

<section markdown="block">
## But What if I Don't Want a Primitive?


Some Java methods actually require an objects (we'll see some when we discuss Inheritance). __So, Java provides a method for wrapping up a primitive type in an object.__ &rarr;

* for example, an <code>int</code> can be wrapped up in an <code>Integer class</code>, a <code>double</code> in the <code>Double</code> class, etc.
* __all of these wrapper classes are immutable!__ (we know how to do this too)
* (these classes might be familiar to you... remember <code>Integer.parseInt(...)</code>?
</section>

<section markdown="block">
## All the Wrapper Classes

Wrapper classes and their corresponding primitive type:

* <code>Boolean</code> - <code>boolean</code>
* <code>Character</code> - <code>char</code>
* <code>Double</code> - <code>double</code>
* <code>Float</code> - <code>float</code>
* <code>Byte</code> - <code>byte</code>
* <code>Short</code> - <code>short</code>
* <code>Integer</code> - <code>int</code>
* <code>Long</code> - <code>long</code>
</section>
<section markdown="block">
## Integer

__Let's try using some of these__ &rarr;

Constants (they're static):

* <code>MAX_VALUE</code> - max integer value
* <code>MIN_VALUE</code> - min integer value

Constructors

* <code>Integer(int val)</code> - create from int 
* <code>Integer(String s)</code> - create from <code>String</code> (has to be all digits)


</section>

<section markdown="block">
## Integer Continued

__Let's try out some methods.__ &rarr;

Instance Methods

* <code>xxxxxValue()</code> - where x is a type, convert to that type
* <code>compareTo(Integer o)</code> - compares to another <code>Integer</code> (+1 if argument is less, 0 if equal, -1 if argument is greater)


Static Methods

* <code>parseInt(String s)</code> - creates an <code>Integer</code> object from a <code>String</code>
* (note that there's a corresponding <code>parseDouble(String s)</code> method in the <code>Double</code> class)
</section>

<section markdown="block">
# Miscellaneous (Boxing, BigInteger, BigDecimal)

</section>

<section markdown="block">
## Boxing and Unboxing

__Boxing__ is the term used for converting from a primitive type to its corresponding wrapper object.

Going the other way is called __unboxing__ ... converting from an object to a primitive.


</section>
<section markdown="block">
## Autoboxing

The java compiler will gladly convert from primitives to wrapper objects and back for you!

__All you have to do is use the primitive in a context where an object is needed... and magic!__ &rarr;

<pre><code data-trim contenteditable>
Character ch = 'c'
</code></pre>

(The [rules](http://docs.oracle.com/javase/tutorial/java/data/autoboxing.html) are a little more complex than that, but that's as far as we'll need to go)

</section>
<section markdown="block">
## BigInteger, BigDecimal

Remember when we talked about floating point arithmetic being imprecise? Wellll.... I mentioned <code>BigInteger</code> and <code>BigDecimal</code> as ways around it...

<code>BigInteger</code> and <code>BigDecimal</code> represent:

* _very_ large integers and highly precise floating point numbers respectively
* (you'd use these for your _financial_ applications!)

Examples

<pre><code data-trim contenteditable>
BigInteger a = new BigInteger("9223372036854775807")
BigInteger b = new BigInteger("9191923148242942432")
a.multiply(b)
</code></pre>
</section>
