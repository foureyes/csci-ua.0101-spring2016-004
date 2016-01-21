---
layout: homework
title: "Stacks"
---
# Stacks

### Resources

* Section 10.6 in {{ site.book }}
* Download the code below to try in Eclipse:
	* [An annotated partial implementation of stack of ints (Stack.java)](../resources/code/Stack.java)


### Background

#### Description

A __stack__ is an [abstract data type](http://en.wikipedia.org/wiki/Abstract_data_type) that stores a sequential collection of elements. The last element added is the first one that can be removed (last in, first out ... or __LIFO__). You can think of a stack as an _actual physical stack_ of items piled on top of one another! You can add items to the top of it, or you can remove items from the top one-at-a-time.

Stacks have many practical applications. You may be familiar with using them to implement parentheses validation, postfix expression evaluation... or within the context of method calls and their activation records (the _call stack_). 

<br>

#### Operations

Stacks support two main operations:

1. __push__ - add an element to the top of a stack
2. __pop__ - return and remove the top element off of a stack

Additional operations that stacks may support include:

1. __peek__ - view the top element (without removing it)
2. __getSize__ - retrieve the number of elements in a stack
3. __empty__ determine whether or not a stack has elements in it

<pre><code data-trim contenteditable>operation:    empty       push 5          push 72             
return value: true                                         

                                          | 72 |              
stack:        |   |       | 5 |           |  5 |             
              +---+       +---+           +----+                  
</code></pre>

<pre><code data-trim contenteditable>operation:    pop              peek         getSize    
return value: 5                5            1
                                                       
                                                       
stack:        |  5 |           |  5 |       |  5 |     
              +----+           +----+       +----+     
</code></pre>

<br><a name="implementation"></a>

### Implementation

#### Overview
Section 10.6 in {{ site.book }} has a sample stack implementation for integers. The code in [Stack.java](../resources/code/Stack.java) follows a similar implementation, with the addition of methods to show the internal state of the stack.

This implementation uses a combination of an <code>Array</code> and an <code>int</code> to emulate a stack that can grow and shrink as elements are popped and pushed. Of course, there's extra overhead, as <code>Array</code>s in Java cannot change in size. Consequently, we'll maintain a size variable to keep track of the _actual_ number of elements in the Stack (anything beyond that should be considered unused/junk data).

Declare a couple of member variables for our _internal_ representation. Let's make both of them private so that they can't be manipulated directly.

<pre><code data-trim contenteditable>private int[] elements;
private int size = 0;
</code></pre>

<br><a name="constructor"></a>

#### Constructor

Our constructor will initialize our Stack with a fixed capacity. In the example implementation, we start with a small capacity to demonstrate how to _grow_ the stack when the capacity is reached.

<pre><code data-trim contenteditable>public final int DEFAULT_CAPACITY = 3;

public Stack() {
	elements = new int[DEFAULT_CAPACITY];
}
</code></pre>

<br><a name="visualizations"></a>

#### Push and Pop Visualizations

For <code>push</code> and <code>pop</code>... we won't actually remove or add to the Array. Instead, we index into the array and set values based on size. This may be a bit unintuitive, since from the perspective of the Stack class user, items are look like they're being added and removed. As an illustration, here's what the stack looks like from the application programmer's perspective:
<pre><code data-trim contenteditable>push(5)         push(72)         pop()            peek()  
no return val   no return val    returns 72       returns 5
                                                                 
                | 72 |                                           
| 5 |           |  5 |           |  5 |           |  5 |        
+---+           +----+           +----+           +----+        
</code></pre>

However, if we show what the internal representation looks like (which is just a fixed size Array), we see that there's invalid/junk data located above the stack size... while all of the actual data is at the bottom of the stack (indexes below the stack size). The following illustrates how size controls the _visible_ stack

<pre><code data-trim contenteditable>
push(5)         push(72)         pop()            peek()  
no return val   no return val    returns 72       returns 5
                                                
|/0̸/|           |//0̸/|___size=2  |//0̸/|           |//0̸/|         
|/0̸/|___size=1  | 72 |           |/72̸/|___size=1  |/72̸/|___size=1
| 5 |           |  5 |           |  5 |           |  5 |        
+---+           +----+           +----+           +----+        
</code></pre>

But how does growing the stack work? Let's start from the application programmer's perspective. It looks like the stack is growing dynamically whenever we push elements...

<pre><code data-trim contenteditable>
push(2)          push(3)             push(4)           push(5)        
no return val    no return val       no return val     no return val                 

                                                       | 5 |              
                                     | 4 |             | 4 |              
                 | 3 |               | 3 |             | 3 |              
| 2 |            | 2 |               | 2 |             | 2 |         
+---+            +---+               +---+             +---+         
</code></pre>

However, internally, once the stack goes over capacity, you'll see that the <code>Array</code> has to be resized. In the example below, the capacity of the internal <code>Array</code> is doubled once 5 is pushed (which causes the number of elements, <code>size</code>, to go over the length of the original <code>Array</code>).

<pre><code data-trim contenteditable>
push(2)          push(3)             push(4)           push(5)        
no return val    no return val       no return val     no return val                 
                                          ___size=3                   
|/0̸/|            |/0̸/|___size=2      | 4 |             |/0̸/|          
|/0̸/|___size=1   | 3 |               | 3 |             |/0̸/|___size=4 
| 2 |            | 2 |               | 2 |             | 5 |          
+---+            +---+               +---+             | 4 |          
                                                       | 3 |          
                                                       | 2 |          
                                                       +---+          
</code></pre>

<br><a name="push"></a>

#### Push

So, for <code>push</code>, we'll have to check if we've gone beyond capacity... if we have, then grow the internal <code>Array</code>:

1. check if pushing an element will cause overflow
2. if it does, grow the <code>Array</code>
	1. create a new <code>Array</code> that's twice the size of the original
	2. copy the contents of the original <code>Array</code> into the new one
	3. set the internal representation of the stack equal to the new <code>Array</code>
3. set the value at the appropriate index equal to the incoming pushed element
	
<pre><code data-trim contenteditable>public void push(int item) {
	if (size >= elements.length) {
		int[] newElements = new int[elements.length * 2];
		System.arraycopy(elements, 0, newElements, 0, elements.length);
		elements = newElements;
	}
	elements[size] = item;
	size++;
}
</code></pre>

<br><a name="pop"></a>

#### Pop

And, of course, an implementation of <code>pop</code>. The other methods, <code>peek</code>, <code>empty</code>, and <code>getSize</code> are pretty straightforward once you have <code>push</code> and <code>pop</code> done (see {site.book} for full details):

<pre><code data-trim contenteditable>public int pop() {
	size--;
	return elements[size];
}
</code></pre>
