---
layout: slides
title: "Objects and Classes"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>
<section markdown="block">
## Students and Homework Scores Again

Right. So, let's go back to a familiar problem.

* you have a bunch of students 
* you want to be able to store their:
	* first name
	* last name
	* 10 homework grades (all ints)
* you'd like to be able to access each data point above on its own (just pull out first name, for example), or as a group (retrieve a person's _full_ name)
* you'd like to be able to run calculations and access a single student's homework grades (like average homework score)

__How would we store this data in my program? What variable(s) and type(s) of variables would we use?__ &rarr;
</section>

<section markdown="block">
## Some Ideas...

We don't have too many options here. __Arrays__ are the best candidate... __but what kind, and what size__? &rarr;

* {:.fragment} maybe an <code>Array</code> that contains 2-element <code>String</code> <code>Arrays</code> to store names
* {:.fragment} and... to store their scores, we'll need an 2-dimensional <code>int</code> <code>Array</code> to store their scores (of course, it would have to be the same size as the Array that stores the students... and the ordering of each has to be maintained)
</section>

<section markdown="block">
## The Students

Here's an example of how we may store student first and last names. (Apologies for the clearly _poor_ random name generator that I put together!).

<pre><code data-trim contenteditable>
String[][] enrolledStudents = {
  {"Eve", "Lan"},
  {"Faythe", "Ibrahim"},
  {"Faythe", "Kim"},
  {"Eve", "Kim"},
  {"Dan", "Johnson"},
  {"Dan", "Kim"},
  {"Eve", "Ibrahim"},
  {"Carol", "Johnson"},
  {"Carol", "Johnson"},
  {"Carol", "Hernandez"}
};
</code></pre>



</section>

<section markdown="block">
## Homework Scores

Aaaand... their scores. We can't store mixed types in an Array.

So, we store the homework scores in a totally separate array (but we have to __maintain ordering__!). __Let's try it.__ &rarr;

<pre><code data-trim contenteditable>
int[][] studentScores = {
  {91, 56, 51, 62, 75, 91, 97, 66, 51, 67},
  {77, 59, 97, 59, 86, 98, 91, 69, 89, 96},
  {76, 89, 96, 57, 64, 55, 88, 92, 91, 92},
  {94, 64, 51, 51, 73, 98, 71, 96, 66, 67},
  {97, 94, 54, 99, 89, 59, 75, 60, 72, 52},
  {89, 87, 55, 82, 59, 65, 51, 98, 83, 75},
  {63, 91, 93, 57, 54, 64, 87, 59, 87, 66},
  {70, 55, 57, 67, 76, 58, 84, 80, 81, 65},
  {77, 57, 51, 72, 81, 54, 72, 68, 58, 96},
  {72, 81, 71, 69, 90, 61, 60, 51, 57, 93},
};
</code></pre>
{:.fragment}
</section>

<section markdown="block">
## A Small Exercise

So, maybe next school year, because you &hearts; Java so much, you end up grading for my section of 101.

__You have to create a report that has:__ &rarr;

* every student's first and last name separated by a space
* ...then a dash
* and the average homework score for that student 

</section>

<section markdown="block">
## Example Output

Using the two Arrays in the previous slides, how would we __print out a report of all of the students (their first and last name separated by a space) and their average homework score__? __Let's try this together.__ &rarr;

<pre><code data-trim contenteditable>
Eve Lan - 70.7
Faythe Ibrahim - 82.1
Faythe Kim - 80.0
Eve Kim - 73.1
Dan Johnson - 75.1
Dan Kim - 74.4
Eve Ibrahim - 72.1
Carol Johnson - 69.3
Carol Johnson - 68.6
Carol Hernandez - 70.5
</code></pre>
</section>

<section markdown="block">
## A Possible Implementation

We have to do a bunch _iteration_ and _indexing_. __No problem!__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
for(int i = 0; i < enrolledStudents.length; i++) {
    System.out.print(enrolledStudents[i][0] + " " + 
        enrolledStudents[i][1]  + " - ");
    int total = 0;
    for(int j = 0; j < studentScores[i].length; j++) {
        total += studentScores[i][j];
    }
    System.out.println((float)total / studentScores[i].length);
}
</code></pre>
</section>

<section markdown="block">
## What Wasn't Fun About That?

It felt like we were really dealing with programming details, like Array indexes, rather than the _actual_ problem at hand. __What are some issues with that?__ &rarr;

* {:.fragment} we have to remember which index represents what
* {:.fragment} we're maintaining scores and names in different places
* {:.fragment} our calculations were manual (they could have been in a method)
</section>

<section markdown="block">
## Details, Details (Objects, Objects)

We would like a level of abstraction to hide-away the details of our tools... so we can deal with the actual details of our problems.

__It'd be nice if we could write code like this, right?__ &rarr;

<pre><code data-trim contenteditable>
for(Student student: enrolledStudents) {
  System.out.println(student.getFullName() + 
      " - " + student.getAverageHomeworkScore());
}
</code></pre>

* we have an Array of _Student objects_
* Student objects can give back their full name, and their average homework score
</section>

<section markdown="block">
## Object Oriented Programming



Nice. The previous version was much easier on the eyes... 

__Object Oriented Programming__ is a programming paradigm that involves modelling your programming task as interactions between __objects__. The __objects__ (usually) represent some real world entity... and they include data about that entity and the behaviors or actions of that entity.

__Let's take a step back for a second.__ &rarr;
</section>

<section markdown="block">
## Categories of Types?

__What are the two broad categories of types that we know?__ &rarr;

* {:.fragment} primitive
* {:.fragment} reference

<span class="fragment">__What are the reference type(s) that we know?__ &rarr;</span>

* {:.fragment} Arrays (of various types!)
* {:.fragment} Strings
* {:.fragment} Scanner objects
</section>

<section markdown="block">
## Another Reference Type!

We've talked about object's _a lot_, but we've never really explained them. An __Object__ is a reference type.

* it represents a bunch of data... 
* and actions or behaviors that can be performed with/on that data.

For example, if we have the <code>String</code> object, <code>"howdy"</code>, __what data do you think it contains?__ &rarr;

1. {:.fragment} probably each character, of course!

<span class="fragment">What can a String object do? What are some of its actions or behaviors?</span>

1. {:.fragment} test if it's equal to another string
2. {:.fragment} give back a substring of itself
3. {:.fragment} give back its length
4. {:.fragment} etc.
</section>

<section markdown="block">
## More Objects!

Let's consider some fictional objects: Create a fraction object. __Name some data that might be associated with it. Name some actions that can be performed on that data__: &rarr;

1. {:.fragment} data - numerator
2. {:.fragment} data - denominator
3. {:.fragment} action - multiplication
4. {:.fragment} action - addition

<span class="fragment"> __...How about a Car object?__ &rarr; </span>

1. {:.fragment} data - make and model
2. {:.fragment} data - license plate
3. {:.fragment} data - current speed
4. {:.fragment} action - steer left 
5. {:.fragment} action - accelerate (gas) 
6. {:.fragment} action - change gears
</section>
	
<section markdown="block">
## Objects

Again, an object:

* is a reference type (a reference to a location in memory).
* can have data/state... 
	* (also called __attributes__, __properties__, or __data fields__)
	* these are __instance variables__ 
* it can have __actions__ 
	* (also called __behaviors__)
	* these are essentially __methods__
</section>

<section markdown="block">
## Where do Objects Come From?

That's great and all, but _there's no such thing_ as a <code>Student</code> object in the Java API.  We have to make our own <code>Student</code> objects.

__Objects of the same type are created by using a <code>class</code>__ &rarr;

* {:.fragment} __Classes__ are like blueprints for creating a certain type of object
* {:.fragment} every <code>String</code> object can give back its length, give back a specific character, etc.
* {:.fragment} for example, every Car object has a current_velocity and can accelerate
* {:.fragment} an object created from a class is called an __instance__
* {:.fragment} to create an object, special method(s) defined in the class used (they're called __constructor(s)__)
</section>

<section markdown="block">
## Whew! That's a Lot of Definitions

Here's a summary:

* __class__ - a blueprint for creating objects of a particular type (you can think of it as a _custom_ data type!)
* __object__ - a reference type... data and the actions you can perform on it; objects of the same type are created by the same class
* __instance__ - an object created from a class... object and instance are usually used synonymously... or you can say somVariable is an instance of someClass (similar to someVariable is someType)
* __constructor__ - a special method in a class that is used to create actual instances (objects) of that class
</section>


<section markdown="block">
## More Analogies and Examples

It's like...

<pre><code data-trim contenteditable>
Class           |  Object(s)
----------------+------------------
Blueprint       | actual object built from blueprint
Template        | a template copied and filled out
Apple Pie Recipe| each individual apple pie made
                | from recipe
</code></pre>

Some actual examples...

<pre><code data-trim contenteditable>
Class           |  Object(s)
----------------+------------------
String          | "apple", "pie", etc.
                |
Student         | Student object that has 
                | first name: Alice
                | second name: Bob
                | (etc.)
</code></pre>
</section>

<section markdown="block">
## An Example Circle Class

Let's say we have a class that represents a blueprint for making Circle objects:

<pre><code data-trim contenteditable>
Class Name: Circle

Data Fields:
* radius is ______

Methods:
* getArea
* getPerimeter
* setRadius

</code></pre>
</section>

<section markdown="block">
## Example Circle Objects

We can create some circle objects, each with their own radius!

<pre><code data-trim contenteditable>
Circle Object 1    Circle Object 2

Data Fields:       Data Fields:
* radius is 1      *  radius is 25

Methods:           Methods: 
* getArea          * getArea
* getPerimeter     * getPerimeter
* setRadius        * setRadius
</code></pre>

</section>


<section markdown="block">
## Classes

A Java __class__:

* uses variables to define data fields 
* methods to define actions
* has a method (or methods) called constructor(s)
	* which are invoked to create a new object
	* a constructor can perform any action, but they're usually used to initialize values in an new object
</section>


<section markdown="block">
## Where Do These Classes Go?

Generally, each class that you create goes in a separate file, with the same name as your class (you know this).

(you can have multiple classes in one file, as long as the class prefixed with public is the one that matches the file name)

* as you know, you can have multiple files in your project...
* not all of those files have to have main methods
* you can have class files that do not have main
* ...and they can be used by other files in your project
* __Let's see.__ &rarr;

</section>

<section markdown="block">
## Let's Create Our Circle Class


<pre><code data-trim contenteditable>

class Circle {

  // a data field or instance variable, the radius
  // (it has a default value...)
  double radius = 1;

  // constructor - how to create a Circle object
  Circle() { }

  // another Constructor 
  Circle(double newRadius) {
    radius = newRadius;
  }

  // method to calculate the area based on the
  // instance variable, radius
  double getArea() {
    return radius * radius * Math.PI; 
  }
  
  // method to calculate the perimeter...
  double getPerimeter() {
    return 2 * radius * Math.PI; 
  }

  // set new radius for this circle 
  void setRadius(double newRadius) {
    radius = newRadius;
  }
}
</code></pre>
</section>

<section markdown="block">
## Testing Your Class / Creating Actual Circle Objects

We can put our main method in our Circle class, but generally, we'll be reusing our classes in other files.

* let's create a separate file, CircleTest, to create some circle objects
* define a main method in CircleTest 
* create some circle objects and call their methods
	* create 3 circles, with radius 1, 25, 125
	* print out get the area of each
	* modify the second circle's radius
	* print out its area again
* run CircleTest

</section>

<section markdown="block">
## CircleTest Implementation

<pre><code data-trim contenteditable>
public static void main(String[] args) {
    Circle circle1 = new Circle();
    System.out.println("The area of the circle of radius"
        + circle1.radius + " is " + circle1.getArea());

    Circle circle2 = new Circle(25); 
    System.out.println("The area of the circle of radius "
        + circle2.radius + " is " + circle2.getArea());

    Circle circle3 = new Circle(125); 
    System.out.println("The area of the circle of radius "
        + circle3.radius + " is " + circle3.getArea());

    // Modify circle radius
    circle2.radius = 100; 

    System.out.println("The area of the circle of radius " + circle2.radius + " is " + circle2.getArea());
}
</code></pre>

</section>

<section markdown="block">
## Constructors

So... there were a few things that were quirky when we defined and called our __constructors__. __What was unusual about how the constructors were defined and used?__ &rarr;

* {:.fragment} __NO RETURN TYPE__! (it's going to give back an instance of the class, right?)
* {:.fragment} it __must have the same name as the class__ ... <code>Class Circle</code> ... <code>public Circle()</code>
* {:.fragment} you can overload constructors (similar to overloading methods)... __what's overloading again?__ &rarr;
* {:.fragment} that is... you can have constructors with different signatures
* {:.fragment} finally, to call a constructor, use the keyword __<code>new</code>__ first
* {:.fragment} <code>Circle circle1 = new Circle()</code>
</section>

<section markdown="block">
## Constructor Notes

* a method or methods of the same name as the class that it's in
* it does not have a return type
* it can be overloaded - that is, multiple constructors with varying signatures is ok
* if you don't define a constructor, a __no arg__ constructor is implicitly defined for you
* (that is... a constructor that does not have parameters - <code>Circle()</code>)
* __let's try this__ &rarr; 
	* define a class, <code>Foo</code>, without a constructor
	* will we still be able to do <code>new Foo()</code>?
</section>

<section markdown="block">
## An Example

__What's the output of this code?__ &rarr;

<pre><code data-trim contenteditable>
public class DefaultConstructorExample {
  public static void main(String[] args) {
    Foo f = new Foo();
    System.out.println(f.getX());
    f.setX(42);
    System.out.println(f.getX());
  }
}
public class Foo {
  public int x = 20;
  public int getX() {
    return x;
  }
  public void setX(int num) {
    x = num;
  }
}
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
20
42
</code></pre>
</section>

<section markdown="block">
## Objects are Reference Variables

This should seems similar (kind of like Arrays, no?)

<pre><code data-trim contenteditable>
// create a variable of type ClassName
ClassName objectRefVar;

// variable myCircle is of type Circle
// the variable myCircle can reference a Circle object
Circle myCircle;

// creates an object and reference is pointed to that object
myCircle = new Circle();

// you can also do it all at once
ClassName objectRefVar = new ClassName(); 

// using the circle example
Circle myCircle = new Circle();
</code></pre>
</section>

<section markdown="block">
## Accessing Data Fields and Methods (Attributes, Properties, Whatevs)

You can access the data fields and methods of an object by using the dot operator.

<pre><code data-trim contenteditable>
Circle myCircle = new Circle()
myCircle.radius
myCircle.getPerimeter()
</code></pre>
</section>

<section markdown="block">
## Instance Variables and Methods

Looking at the previous code again...

<pre><code data-trim contenteditable>
Circle myCircle = new Circle()
myCircle.radius
myCircle.getPerimeter()
</code></pre>

<code>radius</code> and <code>getPerimeter</code> are __instance variables__ and __instance methods__.

* that is... a circle's radius varies by object!
* every Circle object has its own value for radius
* every Circle object can give back its perimeter

You can only call instance methods (and access instance variables) on objects (or, as the name implies, on instances).
</section>

<section markdown="block">
## References as Data Fields

You can have reference types as attributes/properties/data fields of your object. 

* we're not restricted to just having ints, floats, etc.
* we can also have Arrays, our own custom objects, etc.
* __let's try adding an Array to one of our demo classes__ &rarr;

</section>
<section markdown="block">
## Default Values

__Does anyone remember default values for various types are (if they're left unassigned)?__ &rarr;


* {:.fragment} __boolean__ - <code>False</code>
* {:.fragment} __int__ - <code>0</code>
* {:.fragment} __char__ - <code>\n0000</code> (NULL character)

<span class="fragment">Hmmm... what's the default value for a reference type?</span>


</section>
<section markdown="block">
## null

The default value for a reference type is __<code>null</code>__:

* __null__ is a special Java value
* it's a literal, like <code>true</code> or <code>false</code>

</section>

<section markdown="block">
## Unitialized Member Variables

If you don't assign a value to a data field, you'll get it's default value. __Let's see an example.__ &rarr;

</section>


<section markdown="block">
## Default Values

<pre><code data-trim contenteditable>
// in Test.java
public class Test {
    public static void main(String[] args) {
        Foo f = new Foo();
        f.printAttributes();
    }
}
</code></pre>

<pre><code data-trim contenteditable>
// in Foo.java
public class Foo {
    int x;
    boolean b;
    int[] arr;

    public void printAttributes() {
        System.out.println(x);
        System.out.println(b);
        System.out.println(arr);
    }
}
</code></pre>

<span class="fragment">0, false, null</span>

</section>
<section markdown="block">
## On the Other Hand...

If you leave any variable uninitialized __in a method__, it will not receive a default value.

__Let's try it.__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
public class Test {

    public void foo() {
        int x;
        System.out.println(x);
    }
}
</code></pre>

</section>


<section markdown="block">
## Objects and References Continued

<pre><code data-trim contenteditable>
Circle myCircle = new Circle(4);
Circle yourCircle = myCircle;

// myCircle - reference ------> some circle object 
//                             in memory w/ radius 4
//                              ^
//                              |
// yourCircle - reference ------+
</code></pre>

</section>

<section markdown="block">
## Objects and References Continued

__What's the output of this code?__ &rarr;

<pre><code data-trim contenteditable>
Circle myCircle = new Circle(4);
Circle yourCircle = myCircle;
System.out.println(myCircle.radius);
System.out.println(yourCircle.radius);
myCircle.radius = 2;
System.out.println(myCircle.radius);
System.out.println(yourCircle.radius);
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
4.0
4.0
2.0
2.0
</code></pre>

</section>
<section markdown="block">
## Arrays of Objects

Works just like other types! __What would this print out?__ &rarr;

<pre><code data-trim contenteditable>
Circle[] circles = new Circle[3];
for(int i = 0; i < circles.length; i++) {
  circles[i] = new Circle(i + 1);
}
System.out.println(circles[2].radius);
</code></pre>

<span class="fragment">3</span>
</section>


<section markdown="block">
## Back to Students

* create a Student class that contains first and last name, 10 homework grades, and a method to calculate the average homework grade
* in a another class, create a main method that...
* creates a 3 element Array of student objects 
* populates the array with student objects built from your class
* (you can hard code names and scores)

The following code can be used at the end of main to print the report that we discussed in the beginning of class.

<pre><code data-trim contenteditable>
for(Student student: enrolledStudents) {
  System.out.println(student.getFullName() + 
      " - " + student.getAverageHomeworkScore());
}
</code></pre>
</section>
