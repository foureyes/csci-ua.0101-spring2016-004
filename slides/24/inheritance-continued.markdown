---
layout: slides
title: "Inheritance and Polymorphism"
---

<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
# Review-ish Stuff First!

</section>
<section markdown="block">
## What's the Output and why?

<pre><code data-trim contenteditable>
class Beverage {
  String size = "Medium";
}
</code></pre>
<pre><code data-trim contenteditable>
class Soda extends Beverage {
  String flavor;
  Soda(String flavor) {this.flavor = flavor;}
  public String toString() {
    return String.format("%s %s Soda", size, flavor);
  }
}
</code></pre>
<pre><code data-trim contenteditable>
public class BeverageDemo {
  public static void main(String[] args) {
    Soda grape = new Soda("Grape");
    System.out.println(grape);
  }
}
</code></pre>
</section>

<section markdown="block">
## Inheritance, Extends

In the previous slide, the output is:

<pre><code data-trim contenteditable>
Medium Grape Soda
</code></pre>

* <code>size</code> is accessible to the <code>Soda</code>'s <code>toString()</code> method because it inherits it from <code>Beverage</code>
* __what code specifies that Soda inherits from Beverage?__ &rarr;
* {:.fragment} <code>extends</code> specifies inheritance in the class definition
* {:.fragment} __which class is the superclass (also called super class or base class) and which is the subclass__ &rarr;
* {:.fragment} the superclass is <code>Beverage</code>, the subclass is <code>Soda</code>


</section>

<section markdown="block">
## Output?

Let's make one minor change... add a toString() method to Beverage as well. __What will be the output if we made this change: stay the same ("Medium Grape Soda"), different ("Medium Beverage"), or error... and why?__ &rarr;

<pre><code data-trim contenteditable>
class Beverage {
  String size = "Medium";
  public String toString() {
    return size + " Beverage";
  }
}
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
// same!
Medium Grape Soda

</code></pre>
<span class="fragment">
subclasses can __override__ superclass methods if they have the same signature!
</span>

</section>

<section markdown="block">
## Override vs Overload

We've heard of both __overloading__ (in the past), and we just talked about __overriding__. __What's the difference between the two?__ &rarr;

* {:.fragment} __overloading__ means to define multiple methods with the same name but different signatures
* {:.fragment} __overriding__ means to provide a new implementation for a method in the subclass
</section>

<section markdown="block">
## Java Likes to Protect You From Yourself

If your intention is to override, use an __override annotation__ to signify to the compiler that you mean to override rather than overload. The compiler will give you an error if you don't match the signature:

<pre><code data-trim contenteditable>
@Override
void myMethod() {
}
</code></pre>

* the compiler will complain...
* if myMethod's signature doesn't match a signature from an inherited method
</section>

<section markdown="block">
## @Override

__Let's see another example.__ &rarr; ...__Try changing the singature on sayHello for the <code>Baby</code> class__ &rarr;
<pre><code data-trim contenteditable>
class Parent {
  public void sayHello() {
    System.out.println("hello!");
  }
}
</code></pre>

<pre><code data-trim contenteditable>
class Baby extends Parent {
  @Override
    public void sayHello() {
      System.out.println("Waaaahhhhh!");
    }
}
</code></pre>
</section>

<section markdown="block">
## What's the Output?

<pre><code data-trim contenteditable>
public class Nonsense {
  public static void main(String[] args) {
    Baz b = new Baz();
  }
}
</code></pre>
<pre><code data-trim contenteditable>
class Foo { 
  Foo() {System.out.println("FOO");}
}
class Bar extends Foo { 
  Bar() {System.out.println("BAR");} 
}
class Baz extends Bar { 
  Baz() {System.out.println("BAZ");} 
}
</code></pre>

</section>

<section markdown="block">
## Constructor Chaining

The output from the previous code is:

<pre><code data-trim contenteditable>
FOO
BAR
BAZ
</code></pre>

__If you don't explicitly call your superclass constructor (using super), a call to <code>super()</code> is inserted as the first line to the constructor!__
</section>

<section markdown="block">
## Protected

Clarification on __protected__:

* __protected__ allows access to:
* every class in the same package
* or __every class__ that's:
	* __in a different package__, 
	* ...__but is a subclass of the class that contains the protected member__

</section>

<section markdown="block">
## An Example (No, Really This Time)

Here we have a class inside a package called <code>in</code>

<pre><code data-trim contenteditable>
package in;

public class C1 {
	protected int x = 423;
}
</code></pre>
</section>

<section markdown="block">
## Access Protected

Now we have two classes outside of the package in (both in default):

Class <code>Out</code> can't get to it as it's in a different package... but C2 can since it's a subclass (even though it's also in a different package)

<pre><code data-trim contenteditable>
import in.C1;
public class Out {
  public static void main(String[] args) {
    C1 c = new C1();
    // won't work!
    // c.x;
  }
}
</code></pre>
<pre><code data-trim contenteditable>
import in.C1;
class C2 extends C1 {
  // works fine
  int getX() {
    return x;
  }
}
</code></pre>

</section>
<section markdown="block">
## Output, Error or Nothing


<pre><code data-trim contenteditable>
public class Test {
  public static void main(String[] args) {
    Person p = new Author("Foo", "Bar", "Baz");
    System.out.println(p.first);
  }
}
</code></pre>

<pre><code data-trim contenteditable>
class Person {
  String first;
  String last;
}
</code></pre>


<pre><code data-trim contenteditable>
class Author extends Person {
  String pseudonym;
  Author(String first, String last, String pseudonym) {
    this.first = first; 
    this.last = last; 
    this.pseudonym = pseudonym;
  }
}
</code></pre>

</section>

<section markdown="block">
## Polymorphism

It turns out... everything's ok with the previous example.

Even though it looks like p is declared as a different type than the object that's created, __it totally works__! The output is:

<pre><code data-trim contenteditable>
Foo
</code></pre>

</section>

<section markdown="block">
## Polymorphism

In the past, we've mentioned that classes were like defining __custom types__.

If we have the classes, <code>C1</code>, a parent class, and <code>C2</code>, a subclass of <code>C1</code>... __what type are instances created from using the <code>C2</code> constructor?__ &rarr;

* {:.fragment} _both_ <code>C1</code> and <code>C2</code>!!!???
* {:.fragment} every instance of a subclass is also an instance of its superclass
* {:.fragment} (but not the other way around)

</section>
<section markdown="block">
## Polymorphism Demo

Again, __every instance of a subclass is also an instance of its superclass__ &rarr;

This means that this is totally valid...

<pre><code data-trim contenteditable>
// using the classes below
ProudParent[] foo = new ProudParent[2]
foo[0] = new ProudParent();
foo[1] = new ChattyChild();
</code></pre>

<pre><code data-trim contenteditable>
class ProudParent {
}

class ChattyChild extends ProudParent {
}
</code></pre>
</section>

<section markdown="block">
## Some Additional Concepts to Discuss

* Object 
	* toString
	* equals
* instanceOf
* casting
* ArrayList<String> cities = new ArrayList<String>();
	* add
	* get

</section>

<section markdown="block">
## Clothing Store Inventory 

__Let's try creating a class hierarchy for an inventory of shirts:__ &rarr;

T-Shirt

* item id (int, incremental based on item instance)
* size (XS, S, M, L, XL)
* short sleeved (true or false)
* price ($12.50)

Dress Shirt

* item id (int, incremental based on item instance)
* size (XS, S, M, L, XL)
* chest sleeved (true or false)
* price ($12.50)

They should both have a toString method...

</section>

<section markdown="block">
## Inventory Continued

Now let's try to use polymorphism... to:

* create two instances, one dress shirt and one t-shirt
* create a method that takes either (how?)
* and marks down the price by half

</section>


<section markdown="block">
# Because we never finished... back to...

</section>


<section markdown="block">
## Encapsulating Drawing Summary

If we want drawing to be the responsibility if each individual class... we'll use this pattern:

<pre><code data-trim contenteditable>
public class Thing {
	PApplet _p;
	public Thing(PApplet drawingContext) {
		_p = drawingContext
	}
	public void render() {
		_p.ellipse(20, 20, 100, 100);
	}
}
</code></pre>

</section>

<section markdown="block">
## The PApplet Instance?

Sooo... usually our _actual main line of program execution_ is through some class that extends PApplet. 

* {:.fragment} it orchestrates the initialization (defining the setup and void)
* {:.fragment} and it could also pass along itself as the drawing context!
* {:.fragment} so what don't we just pass the contructor __this__!?

<pre class="fragment"><code data-trim contenteditable>
class Sketch extends PApplet {
	public void setup() {
		// we're an instance of PApplet
		// (since we inherit from it)
		Thing t = new Thing(this);	
	}
}
</code></pre>
</section>
<section markdown="block">
## Some Exercises

__Let's try rewriting our program a little bit!__ &rarr;

* add a bunch of squares (using a Square class, of course)
* make the Circles move, each in a random direction
* make the Squares move, each in a random direction
* hmmmm... there's a lot of repeated code... __what should we do?__ &rarr;
</section>
