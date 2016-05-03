---
layout: slides
title: "Abstract Classes and Interfaces"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
## About Superclasses, Subclasses

__What's a superclass, and what's a subclass?__ &rarr;

* {:.fragment} a superclass is a class that another class or classes inherits members from
* {:.fragment} a subclass is a class that inherits properties from another class

</section>

<section markdown="block">
## A Common Pattern

__Given these two classes, can we create a superclass that both inherit from?__ &rarr;

<pre><code data-trim contenteditable>
class ValueSeparatedFile {
	String fileName;
	String delimiter = ",";
	public void load() { 
		// read file into memory
	}
}
</code></pre>
<pre><code data-trim contenteditable>
class FixedWidthFile {
	String fileName;
	int columnWidth = 20;
	public void load() { 
		// read file into memory
	}
}
</code></pre>

</section>

<section markdown="block">
## A Common Pattern Continued

Of course - we can extract fields and methods that are the same, and __put them into a superclass__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
class DataFile {
	String fileName;
	public void load() {
		// ....
	}
}
</code></pre>
<pre class="fragment"><code data-trim contenteditable>
class ValueSeparatedFile extends DataFile {
	String delimiter = ",";
}
class FixedWidthfile extends DataFile {
	int columnWidth = 20;
}
</code></pre>
</section>

<section markdown="block">
## A Common Pattern Summary

__So... here's what we did:__ &rarr;

* {:.fragment} we looked for common fields and methods
* {:.fragment} moved them from our classes into a parent class
* {:.fragment} extended the base class
</section>

<section markdown="block">
## More Specific / More Abstract

__In a class hierarchy (that is, classes that inherit from each other), which are more specific, subclasses or superclasses?__ &rarr;

* {:.fragment} as you descend down the inheritance chain, classes (that is, _subclasses_) become more and more __specific__
* {:.fragment} as you go up the inheritance chain, classes (that is, _superclasses_) become more and more __abstract__
* {:.fragment} in fact, we reach a point where we get to a class called <code>Object</code>, which is _pretty abstract_ / generic, right?

</section>

<section markdown="block">
## Too Abstract

Sometimes, the superclass becomes so abstract that __it does not make sense to make a _new_ instance of it__. Let's take a look at the [solution for homework #9](../../resources/code/homework09-solution/MyAnimation.java).

* everything inherits from the <code>Sprite</code> class
* but... __do we ever _actually_ create an instance of sprite__?
* __would it even make sense to__?

</section>

<section markdown="block">
## Abstract Classes

If we want to ensure that a superclass is never instantiated with __new__ because it's _too abstract_, we make it an abstract class!

* __abstract__ classes behave just like regular classes, _except_
* you can't create instances of an abstract class with the keyword, <code>new</code>
* an abstract class can contain abstract methods...
* __abstract methods__ are methods without an implementation
	* (that is, they have no method body!)
* abstract classes can have constructors, but they're <code>protected</code>
	* (only subclasses or same package can access them)

</section>
<section markdown="block">
## Abstract Class Syntax

* use the keyword, <code>abstract</code>
* abstract classes can have:
	* member variables
	* methods
	* method definitions without bodies! ... these are <code>abstract</code> methods

<pre><code data-trim contenteditable>
abstract class Foo {
	// look ma, no method body!?
	public abstract int Bar();
}
</code></pre>
</section>

<section markdown="block">
## Extending Abstract Classes

When a class extends an abstract class, it may __implement__ the abstract methods:

* use the keyword, <code>extends</code> like usual
* the superclass constructor is still called
* the _concrete_ subclass provides the bodies of any methods that don't have an implementation yet (again, __abstract methods__)


<pre><code data-trim contenteditable>
public class Concrete extends MyAbstractClass {
	//... implement some abstract methods! yeah!
}
</code></pre>
</section>

<section markdown="block">
## Why Define Abstract Methods?

__Let's refactor our car animation a little bit.__ &rarr;

<span class="fragment">If you have a declared type of superclass, but you want to call a method only defined in subclasses</span>
</section>

<section markdown="block">
## Details

* if a class contains an abstract method, __the class must be abstract as well__
* all abstract methods must be non-static
* an abstract class cannot be instantiated using new (but you can still declare a variable of that type)

</section>
<section markdown="block">
## More Details

* you can create an abstract class that doesn't have any abstract methods
* rare... but you can override an inherited method and make it abstract!
* a subclass can be abstract even if its superclass is _concrete_
* again, you can use an abstract class as a data type when declaring a variable
</section>

<section markdown="block">
## Interfaces

An interface is a class-like construct that only contains constants and abstract methods. 

* it only defines constants
* if it has methods, they must be abstract
* a class that _implements_ an interface defines the interface's abstract methods
* a class can implement _multiple_ interfaces
* on the other hand, it can only inherit from one class, abstract or not (using extends)

</section>

<section markdown="block">
## Interfaces Continued

An __interface__ is used to specify common behaviors/actions among classes, related or not related. Some examples include:

* comparable
* editable
* cloneable

For example... you can have two totally different classes, but if they implement the comparable interface, then you know that you can call <code>compareTo</code> on both, regardless of the class.
</section>

<section markdown="block">
## Interface Syntax

* to _create_ an interface, use the keyword, <code>interface</code>, followed by the name of the interface... and the body
* to _use_ an interface, you class will use the keyword, <code>implements</code> in your class definition

<pre><code data-trim contenteditable>
modifier interface InterfaceName {
}

modifier class MyClass implements InterfaceName {
	// provide body for interface abstract methods
}
</code></pre>
</section>



<section markdown="block">
## An Aside on Sorting

__We know some ways of sorting Arrays. What are they?__ &rarr;

* {:.fragment} bubble sort
* {:.fragment} selection sort
* {:.fragment} ...there's also <code>Arrays.sort
	* {:.fragment} __let's see if it works__
	* {:.fragment} __what about objects?__
	* {:.fragment} __meh...not so much__

</section>

<section markdown="block">
## Comparable Interface

If you implement the comparable interface, your object can be sorted if it's in an <code>Array</code> using <code>Arrays.sort()</code>.

<pre><code data-trim contenteditable>
public class MyClass implements Comparable&lt;MyClass&gt; {
	public int compareTo(MyClass other) {
		// return negative int if this is less than other	
		// return zero if this is equal to other
		// return positive int if this is equal to other
	}
}
</code></pre>
</section>

<section markdown="block">
## Why Use Interfaces?

* when you want similar behavior for unrelated classes
* if you want to mimic _multiple inheritance_

</section>
