---
layout: slides
title: "Objects and Classes, Last Bits"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
## A Quick Review

__Let's start with a mystery!__ &rarr;

Check out [this <code>main</code> method, in a class called, <code>RobotFactory</code>](../../activities/robot-factory.html)

* if we try to run it on its own, it won't work!
* what file is missing?
* __what code do we need in the missing file in order to get the <code>RobotFactory</code> code to work?__ &rarr;
</section>

<section markdown="block">
## A Closer Look at Robot.java

Variables

<pre><code data-trim contenteditable>
public class Robot {
	public static int counter = 0;
	public static String defaultRobotSound = "Beep";
	private int id;
	private String name;
	
}
</code></pre>
</section>

<section markdown="block">
## Robot.java Continued

Aaaand some methods:

<pre><code data-trim contenteditable>
	// continued from previous slide
	public Robot(String name) {
		this.name = name;
		id = ++counter;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public static void makeSound() {
		System.out.println(defaultRobotSound);
	}
</code></pre>
</section>

<section markdown="block">
## Static vs Instance

We saw both __static__ and __instance__ variables and methods. __What effect does putting the keyword <code>static</code> have if you put it in front of a variable or method?__ &rarr; 

* {:.fragment} there is only one variable or method in memory that is shared across all objects
* {:.fragment} they can be accessed via instance (<code>bmo.makeSound()</code>) or class name (<code>Robot.makeSound()</code>)
* {:.fragment} changing a static variable in one object means that all objects see the change

<span class="fragment"> __Compare and contrast that with instance variables and methods__ &rarr; </span>

* {:.fragment} instance variables and methods are per object / instance
* {:.fragment} they can only be accessed via the instance



</section>

<section markdown="block">
## Static Methods

__When writing static methods, what are the rules for accessing static and instance variables and invoking static and instance methods from the static method?__ &rarr;

* {:.fragment} they can access or invoke static variables or methods
* {:.fragment} they __cannot__ access or invoke their own instance variables or methods
</section>

<section markdown="block">
## Visibility Modifiers

We also saw some __visibility modifiers__ in the <code>Robot.java</code> code. __What are the visibility modifiers that we know, and what effect do they have?__ &rarr;

* {:.fragment} __no modifier or default__ - only accessible by classes in package (for us this means no package declared, and in same directory)
* {:.fragment} __public__ - accessible by any other class
* {:.fragment} __private__ - only accessible by class defined in
* {:.fragment} __protected__ (we haven't really seen this yet) - only accessible by class and _subclasses_

</section>

<section markdown="block">
## Visibility Modifiers

__Why use visibility modifiers?__ &rarr;

* {:.fragment} to control access to methods and variables
* {:.fragment} you may also hear the term __access modifiers__ as a synonym for visibility modifiers
* {:.fragment} to _hide implementation details_ that the programmer using the class does not need to concern themselves with
* {:.fragment} (that is, they promote encapsulation)
</section>

<section markdown="block">
## Encapsulation?

Yeah... so, __what do we mean by encapsulation?__ &rarr;

1. {:.fragment} data encapsulation - controlling / restricting access to data
2. {:.fragment} class encapsulation
	* {:.fragment} keeping related data and actions / operations bundled together
	* {:.fragment} hiding the details of a class's actual implementation
</section>

<section markdown="block">
## Data Encapsulation

* perhaps we don't want direct access to static and instance variables
* ...because there's logic or rules surrounding retrieving or setting those values
* consequently, we use methods called __getters__ and __setters__ (also called __accessors__ and __mutators__)

</section>


<section markdown="block">
## Class Encapsulation

Ok... so to talk about class encapsulation, we'll go over:

1. abstractions
2. method abstractions
3. class abstractions
4. ...and finally class encapsulation

</section>
<section markdown="block">
## Abstractions

Programming languages provide __abstractions__: 

* __abstractions__ are mechanisms for: 
	* {:.fragment} hiding away complex, but required, details that aren't directly related to a particular task 
	* {:.fragment} so that the actual task itself can be focused on
	* {:.fragment} for example, rather than spending time dealing with machine code instructions...
	* {:.fragment} we use a high level language, like Java, to abstract away the details of programming for a particular processor
* {:.fragment} we've already seen __method abstraction__ ...
	* {:.fragment} we can call/define a method to have it perform some useful action, 
	* {:.fragment} without knowing its implementation (the code that's in the method body)
* {:.fragment} we'll check out __class abstraction__ as well

</section>

<section markdown="block">
## Method Abstraction

__Method abstraction__ separates the use of a method and its implementation

* the details of the implementation are encapsulated in the method 
* the caller doesn't have to know about those details
* if the implementation of the method changes, the caller would not be affected as long as the method signature stays the same
* a method can be treated like a black box; you know the inputs and outputs, but you don't know the implementation details

</section>

<section markdown="block">
## Class Abstraction

__Class abstraction__ separates the use of a class from the implementation of a class:

* a __class's contract__ is a description of how a programmer can use it
* it outlines the collection of methods and fields that can be accessed from outside of the class (that are visible)
* it specifies how these methods and fields are expected to behave 
* it's basically a programmer's high level interface of a class's usage
* however, the programmer using the class does not have to know how the class is implemented in order to use it

</section>

<section markdown="block">
## Class Encapsulation

__Class encapsulation__ - a class's implementation is hidden or _encapsulated_ from the user of the class.

* this is essentially the _other side_ of abstraction
* a class's implementation can change behind the scenes, but as a programmer using the class, you should not be affected
* we talked about the example of the Matrix class... 
	* where the internal representation of a Matrix is a 2-D <code>Array</code>
	* but it could have been a single-dimensional <code>Array</code>
	* __does the Matrix class user have to be aware of that implementation detail?__ &rarr;
	* {:.fragment} no... as long as its designed in such a way that the __class contract__ remains unchanged if the implementation is unchanged

</section>

<section markdown="block">
## Ok... Before the Example, Class Diagrams

Before we can use class abstraction and encapsulation, we'll need to define a __class contract__. One way we can do this is to create a __UML (Unified Modeling Language) class diagram__.

A __class diagram__ is a box labelled with the class's name containing a list of variables followed by a list of methods. They are specified using the following notation:

* __data field__ - <code>dataFieldName: dataFieldType</code>
* __constructor__ - <code>ClassName(parameterName: parameterType)</code>
* __method__ - <code>methodName(parameterName: parameterType): returnType</code>
* __private__ - <code>-</code> before method or field
* __public__ - <code>+</code> before method or field
* __static__ - underline a method or field

</section>


<section markdown="block">
## A Class Diagram Example

Here's a class diagram for a simplified version of <code>Matrix</code>. A programmer using this class only cares about the public methods and variables, so as long as they don't change, the __class contract__ remains intact!

<pre><code data-trim contenteditable>
+--------------------------------------+
| Matrix                               |
+--------------------------------------+
| -m: int[][]                          |
+--------------------------------------+
| +Matrix(arr: int[][])                |
| +toString(): String                  |
| +getElement(row: int, col: int): int |
+--------------------------------------+
</code></pre>
</section>

<section markdown="block">
## Class Contract 

__Or, we can just list out the public methods and data fiels:__ &rarr;

<pre><code data-trim contenteditable>
// constructor
public Matrix(int arr)

// returns a string representation of the matrix
public String toString()

// gets the int at the specified row and column
public int getElement(int row, int col)

</code></pre>


</section>

<section markdown="block">
## A Program Using the Matrix Class

So... let's say we implemented this <code>Matrix</code> class (we'll see it in a second). __We can write a program that uses it in the following manner, based on the class contract__ &rarr;

(we know we can use the following constructors and methods, because they're specified in the UML diagram)

<pre><code data-trim contenteditable>
// create an int array to represent an original matrix
int[][] arr = {
	{1, 2, 3}, {4, 5, 6}, {7, 8, 9}
};

// create a new matrix from array
Matrix m1 = new Matrix(arr);

// print out the matrix itself, and pick out a specific element
System.out.println(m1.toString());
System.out.println(m1.getElement(0, 2));
</code></pre>

</section>
<section markdown="block">
## A Sample Implementation

The <code>Matrix</code> class constructors and data fields

<pre><code data-trim contenteditable>
private int[][] m;

public Matrix(int[][] arr) {
  m = new int[arr.length][arr[0].length];
  for (int i = 0; i < arr.length; i++) {
      System.arraycopy(arr[i], 0, m[i], 0, arr[0].length);
  }
}

</code></pre>
</section>


<section markdown="block">
## Sample Implementation Continued

The <code>Matrix</code> class methods

<pre><code data-trim contenteditable>
public String toString() {
  String s = "";
  for(int[] row: m) {
    s += Arrays.toString(row) + "\n";
  }
  return s;
}

public int getElement(int row, int col) {
  return m[row][col];
}
</code></pre>
</section>

<section markdown="block">
## Let's Change the Implementation

Now... let's say we decide we want to change the implementation of the <code>Matrix</code> class. __We can do it in such a way that the original code that utilizes the <code>Matrix</code> class doesn't break__ &rarr;

* instead of using a 2-d array, let's store everything in a single dimensional array
* ... of course, we'll have to change a lot of the implementation
* (but our use of the class won't change. niiiiice!)

__Let's see what we'd need to do to change our <code>Matrix</code> class.__ &rarr;

(by the way, changing and restructuring existing code without altering its external behavior is called __refactoring__)
</section>


<section markdown="block">
## Wait, How do We?

__How is a two dimensional <code>Array</code> represented as a single dimensional <code>Array</code>?__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
twoDim [[2,   4,   6], [8,  10,  12], [14,  16,  18]]
index  0,0  0,1  0,2  1,0  1,1  1,2   2,0  2,1  2,2

oneDim [2,  4,  6,  8, 10, 12, 14, 16, 18]
index  0   1   2   3   4   5   6   7   8

twoDim[2][1] = 16
oneDim[7]    = 16

index ... is row * length of row + column 
7 = 2 * 3 + 1
</code></pre>

</section>
<section markdown="block">
## Refactoring Part 1

__Instance and/or static variables... and a utility method__ &rarr;


<pre class="fragment"><code data-trim contenteditable>
private int[] m;
private int rows;
private int cols;
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
private int calculateIndex(int row, int col) {
    return row * rows + col;
}
</code></pre>

__Why do you think calculate Index is private?__ &rarr;

<span class="fragment">It's only important for the implementation; it's not a method that a programmer that uses the <code>Matrix</code> class should use / care about.
</span>

</section>

<section markdown="block">
## Refactoring Part 2

__Aaaand... our new constructor:__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
public Matrix(int[][] arr) {
    rows = arr.length;
    cols = arr[0].length;
    m = new int[rows * cols];
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr[0].length; j++) {
            // row number types num rows plus column
            m[calculateIndex(i, j)] = arr[i][j];
        }
    }
}
</code></pre>
</section>


<section markdown="block">
## Refactoring Part 3

__Lastly, let's reimplement the methods.__ &rarr;


<pre class="fragment"><code data-trim contenteditable>
public int getElement(int row, int col) {
    return m[calculateIndex(row, col)];
}
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
public String toString() {
    String s = "";
    for(int i = 0; i < rows; i++) {
        s += "[";
        for(int j = 0; j < cols; j++) {
            s += m[i * rows + j];
            if (j != cols - 1) { 
                s += ", ";
            }
        }
        s += "]\n";
    }
    return s;
}
</code></pre>
</section>

<section markdown="block">
## Scope

__Instance and static variables__ in a class are available within the entire class, regardless of where they are declared. __How does this differ from variables in a method?__ &rarr;

* {:.fragment} public static variables are essentially globals!
* {:.fragment} variables in a method are local to that method... and can only be used in that method
* {:.fragment} __what do you think happens if local variable in a method is the same name as an instance or static variable?__ &rarr;
* {:.fragment} the local variable takes precedence

<pre class="fragment"><code data-trim contenteditable>
class Greeter {
  String greet = "hello";
  void sayHi() {
    String greet = "hi";
    System.out.println(greet);
  }
}
</code></pre>

</section>
<section markdown="block">
## this

The __this__ keyword is used to refer to the class that it is in. Use __this__:

* to distinguish between member variables and parameters that are the same name
* when calling constructors in the same class (instead of using the actual constructor name)

<pre><code data-trim contenteditable>
class Foo {
    int x, y;

    Foo() {
        this(100, 100);
    }

    Foo(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
</code></pre>
</section>

<section markdown="block">
## toString Method

You can define a <code>toString</code> method in your class:

* this method should have no arguments
* it should return a String
* it is automatically called when you print out to the screen!

__Let's see this in action.__ &rarr;

</section>


<section markdown="block">
## Objects and Mutability

So... __have the objects that we've created so far been immutable or mutable?__ &rarr;

<span class="fragment">mutable</span>


<span class="fragment">__How do you think we can make an immutable object?__ &rarr;</span>

* {:.fragment} all data fields are private
* {:.fragment} no setters
* {:.fragment} no getters return a reference!
</section>


<section markdown="block">
## Arrays and Swapping

Of course, we can have <code>Arrays</code> of objects:

<pre><code data-trim contenteditable>
ClassName[] variableName = new ClassName[length];
</code></pre>

Also, check out [this sample of storing objects in an Array and swapping objects in Pythontutor's Java mode](http://www.pythontutor.com/visualize.html#code=public+class+Foo+%7B%0A++++public+static+void+main(String%5B%5D+args)+%7B%0A++++++++Foo%5B%5D+arr+%3D+new+Foo%5B3%5D%3B%0A++++++++for(int+i+%3D+0%3B+i+%3C+arr.length%3B+i%2B%2B)+%7B%0A++++++++++++arr%5Bi%5D+%3D+new+Foo(i)%3B%0A++++++++%7D%0A++++++++Foo+temp+%3D+arr%5B0%5D%3B%0A++++++++arr%5B0%5D+%3D+arr%5Barr.length+-+1%5D%3B%0A++++++++arr%5Barr.length+-+1%5D+%3D+temp%3B%0A++++%7D%0A++++%0A++++public+int+id%3B%0A++++public+Foo(int+id)+%7B%0A++++++++this.id+%3D+id%3B%0A++++%7D%0A%7D&mode=display&origin=opt-frontend.js&cumulative=false&heapPrimitives=true&textReferences=false&py=java&rawInputLstJSON=%5B%5D&curInstr=31)
</section>

<section markdown="block">
## Testing for null

{% comment %} TODO: null review {% endcomment %}

If you'd like to know if the object that you have is __null__ vs an _actual_ object...

<pre><code data-trim contenteditable>
varName == null
</code></pre>
</section>


<section markdown="block">
## Sorting

{% comment %} TODO: pseudocode for selection sort {% endcomment %}


__A quick reminder... how does selection sort work?__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
public static void selectionSort(int[] arr) {
    // incrementally set the start point of the array
    // to beginning of unsorted region
    for(int start = 0; start < arr.length - 1; start++) {
        int smallest = arr[start];
        int indexSmallest = start;

        // search remainder of array for smallest
        for(int i = start + 1; i < arr.length; i++) {
            if (arr[i] <  smallest) {
                smallest = arr[i];
                indexSmallest = i;
            }
        }
        // swap with next smallest (which is already in 
        // variable smallest, no need for temp variable
        arr[indexSmallest] = arr[start];
        arr[start] = smallest;
    }
}
</code></pre>

<span class="fragment">__Let's try sorting a bunch of objects.__ &rarr;</span>

</section>

{% comment %}  

<section markdown="block">
## TODO: bubble sort on objects

</section>
{% endcomment %}


{% comment %} 
* in arrays
* test equals null
* sorting algos, sorting objects, show demo
* swapping
{% endcomment %}
