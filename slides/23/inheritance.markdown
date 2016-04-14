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
##  Let's Start off With a Quick Review

* __create a <code>Circle</code> class that represents a (you guessed it!) circle__ &rarr;
* __create another class, <code>Sketch</code>, that uses the <code>Circle</code> class to draw 10 circles in random positions in processing__ &rarr;
</section>

<section markdown="block">
## Who Does the Drawing?

__In our previous example, which class was responsible for doing the drawing?__ &rarr;

* {:.fragment} the <code>Sketch</code> class
* {:.fragment} hm... maybe we can try a different design, where the <code>Circle</code> object can draw itself
* {:.fragment} but first ... where do you think all of those drawing methods come from? __why can we just call them?__ &rarr;
	* {:.fragment} they're inherited from PApplet!

</section>

<section markdown="block">
# Um What?

</section>

<section markdown="block">
## Inheritance

__Inheritance__ is a mechanism / language feature for reusing code. 

* {:.fragment} ...specifically for basing one class off of another
* {:.fragment} allows the definition of a general class, from which other more specialized classes can be built on top of


</section>

<section markdown="block">
## Inheritance Continued

__So what does inheritance actually let us do?__ &rarr;

* {:.fragment} common data fields / properties (member variables) and behaviors (methods) that are shared among classes can be extracted out to single _parent class_
* {:.fragment} this __parent class__ is called the __super class__ or __base class__ (the class inherited from)
* {:.fragment} the class that is inheriting properties and behaviors is called the __subclass__
* {:.fragment} all of the parent class' _accessible_ behaviors and properties that are inherited

</section>

<section markdown="block">
## How?

To create a __subclass__ from a __parent class__, use the keyword __<code>extends</code>__:

<pre><code data-trim contenteditable>
public class C1 {
}

public class C2 extends C1 {
 # yuh huh... inherited me some stuffs!
}

</code></pre>

BTW, __what's the superclass and subclass above?__ &rarr;

<span class="fragment">C1 is the superclass, C2 is the subclass</span>

<span class="fragment">So... now, C2 gets all of C1's __accessible__ methods and member variables (of which there aren't any explicitly declared yet).</span>
</section>

<section markdown="block">
## Accessible?

What does _accessible_ actually mean in this case? __How do we know what gets inherited?__ &rarr;

* {:.fragment} all member variables and methods based on ... __???__ &rarr;
* {:.fragment} __visibility modifiers__ &rarr;
	* {:.fragment} default
	* {:.fragment} public
	* {:.fragment} protected
	* {:.fragment} (private methods and member variables are not inherited)
* {:.fragment} __let's try a quick example with one of each kind, for variables and methods__ &rarr;
</section>

<section markdown="block">
## Pesky Private Variables

If we _needed_ to modify a private variable in the superclass, besides making it public, what could we do ?

* {:.fragment} use getters and setters
* {:.fragment} make it __protected__!
	* {:.fragment} pretty close to private...
	* {:.fragment} only accessible by subclasses

</section>



<section markdown="block">
## A Flashback

What kind of relationships were __aggregation__ and __composition__?

<span class="fragment">They were __has-a__ relationships</span>

<span class="fragment">Inheritance is a __is-a__ relationship between two classes!</span>

</section>

<section markdown="block">
## Some Technical Things

* again, inheritance is a __is-a__ relationship between two classes
* a subclass can only __extend__ one superclass 
	* this is __single inheritance__
	* (only one parent class allowed!)
* you may hear of __multiple inheritance__, where you can inherit from more than one class... and we'll see a feature of Java that _sort of_ does this
</section>

<section markdown="block">
## Suuuuuper

Remember __this__? __What does <code>this</code> refer to again?__ &rarr;

* {:.fragment} __this__ is the instance itself, the instance that the method is being called on (or the instance that's doing the calling)
* {:.fragment} what if we want to refer to the superclass?
* {:.fragment} use __super__, of course

</section>

<section markdown="block">
## Suuuuuper Continued

Again, __super__ refers to the superclass. __It can be used to:__ &rarr;

* {:.fragment} call a superclass constructor
	* {:.fragment} calling super() invokes the _no arg_ constructor of the superclass
	* {:.fragment} calling super(args) invokes the constructor with the matching signature
* {:.fragment} call a superclass method

__Let's try out some examples.__ &rarr;

</section>

<section markdown="block">
## Super-er

__Check out this base class, <code>ClsParent</code>__ &rarr;

<pre><code data-trim contenteditable>
public class ClsParent {
	ClsParent() {
		System.out.println("ClsParent");
	}
	ClsParent(int x) {
		System.out.println("ClsParent(int x) called with " + x);
	}
	protected void foo() {
		System.out.println("Foo!");
	}
}
</code></pre>

(Continued on next slides)
</section>

<section markdown="block">
## Super-er Continued

__What's the output of the code below if a new ClsChild instance is created?__ &rarr;
<pre><code data-trim contenteditable>
public class ClsChild extends ClsParent{
	public ClsChild() {
		super(5);
		super.foo();
	}
}
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
ClsParent(int x) called with 5
Foo!
</code></pre>
</section>


<section markdown="block">
## Constructor Chaining

If you create a subclass __and you don't invoke a superclass constructor__, __super()__ will automatically be called for you (it'll be the first statement in the constructor)!!!!

<pre><code data-trim contenteditable>
public className() {
}
// is actually 
public clasName() {
	super();
}
</code></pre>

__Let's try to make a chain of constructor calls!__ &rarr;
</section>


<section markdown="block">
## Chaining Constructors

<pre><code data-trim contenteditable>

public class Chainy {
	public static void main(String[] args) {
		C3 chainedCallz = new C3();
	}
}
</code></pre>
<pre><code data-trim contenteditable>
class C1 {
	C1() {System.out.println("in C1");}
}
class C2 extends C1 {
	C2() {System.out.println("in C2");}
}
class C3 extends C2{
	C3() {System.out.println("in C3");}
}
</code></pre>

</section>

<section markdown="block">
## Overriding Methods

If you want a method in a subclass to __override__ a method in the superclass:

* create a method in the subclass...
* with the same signature
* __let's try a quick example__ &rarr;

<pre><code data-trim contenteditable>
class C1 {
	public String toString() {return "C1"}
}

class C2 extends C1 {
	public String toString() {return "GOTCHA!"}
}
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
## Back to Our Circles

Ok... so in our program, __are there any superclasses or subclasses?__ &rarr;

* {:.fragment} yeah, sure... 
	* {:.fragment} PApplet
	* {:.fragment} Sketch
* {:.fragment} So, I'll ask this again: __where do you think all of those magical methods, like <code>ellipse</code> and <code>rect</code> come from?__ &rarr;
	* {:.fragment} they're methods that are defined in <code>PApplet</code>
	* {:.fragment} really, [check out the code](https://github.com/processing/processing/blob/master/core%2Fsrc%2Fprocessing%2Fcore%2FPApplet.java)

</section>

<section markdown="block">
## Circles Drawing Circles

__....And we're back.__ Now that we know where all of those drawing things are coming from, let's get back to having our circle class draw itself.

* {:.fragment} based on what we saw, __are the methods <code>ellipse</code>, <code>rect</code>, etc. instance methods or static methods?__ &rarr;
* {:.fragment} they're instance methods!  ...that means that we have an instance of our <code>Sketch class</code> somewhere
* {:.fragment} soooo... if we want to have our Circle draw stuff, it should have instance that it could draw on

</section>

<section markdown="block">
## Encapsulating Drawing

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

BTW, __what kind of class relationship is going on between _p and Thing?__ &rarr;

<span class="fragment">has-a.... likely aggregation, as the PApplet object will likely be used by other classes.</span>
</section>

<section markdown="block">
## Where will get a PApplet Instance?

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
