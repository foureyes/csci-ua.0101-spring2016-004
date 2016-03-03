---
layout: slides
title: "Nested Arrays"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>


<section markdown="block">
## Back to Storing Data

We just saw a pretty basic example of storing a single student's homework grades in an Array. Useful(ish).

__What if we want to store grades and calculate averages, highest and lowest for an entire class?__ &rarr;

For example...

<pre><code data-trim contenteditable>
&nbsp;            hw1 hw2 hw3 hw4 hw5
            +---+---+---+---+---+
  student 0 |85 |79 |81 |89 |90 |
            +---+---+---+---+---+
  student 1 |95 |88 |80 |92 |84 |
            +---+---+---+---+---+
  student 2 |72 |78 |71 |74 |77 |
            +---+---+---+---+---+
  student 3 |91 |99 |94 |95 |93 |
            +---+---+---+---+---+
  student 4 |80 |85 |84 |82 |88 |
            +---+---+---+---+---+
</code></pre>
</section>

<section markdown="block">
## Just Like Before

Well, we could: 

* assign each Array of scores to a variable
* and find the average, highest, lowest for each individual variable

<pre class="fragment"><code data-trim contenteditable>
// initialize arrays
int[] student0 = {85, 79, 81, 89, 90}
// etc...
int[] student4 ={80, 85, 84, 82, 88}

// average of each (assuming an average method
syso(average(student0))
// etc...
syso(average(student4))
</code></pre>
</section>

<section markdown="block">
## Also Tedious, But Maybe - a Solution!

So, that didn't seem very fun.

* again, we'd like to group together all of the data
* (so that we can do things like loop over every student, then loop over every score)

<span class="fragment">__Why don't we just take the Array's of scores and put that into another Array!?__</span>

</section>

<section markdown="block">
## Multi-Dimensional Arrays

A __multi-dimensional__ Array is an Array that consists of other Arrays!

You can define a multidimensional Array as follows:

<pre><code data-trim contenteditable>
eleType[][] varNAme = new eleType[size][size]
</code></pre>

You can also initialize...

<pre><code data-trim contenteditable>
int[][] pairs = {
	{1, 1}, 
	{2, 2},
	{3, 3}
}; 
</code></pre>
</section>

<section markdown="block">
## Some Samples

<pre><code data-trim contenteditable>
public static void main(String[] args) {
  // declare and create a 2D Array of ints
  int[][] matrix = new int[5][5];

  // here... we're also initializing
  int[][] pad = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
  };
}
</code></pre>
</section>

<section markdown="block">
## Printing 2D Arrays

__What do you think the output will be if I try to print these Arrays?__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
// we haz hashcodez
// (not so useful for our purposes)
[[I@55f96302
[[I@3d4eac69
</code></pre>

<span class="fragment">__Hey, why don't we toString it!?__</span>

<pre class="fragment"><code data-trim contenteditable>
// kind of expected ... of course we'll get this:
[[I@55f96302, [I@3d4eac69, [I@42a57993]
[[I@7852e922, [I@4e25154f, [I@70dea4e, [I@5c647e05, [I@33909752]V
</code></pre>
</section>


<section markdown="block">
## I Just Want to Print Me Some Arrays

That's frustrating. __I guess let's just write a pretty print method that displays a two dimensional Array of ints as:__ &rarr;

<pre><code data-trim contenteditable>
1 2 3 
4 5 6 
7 8 9 
</code></pre>

</section>

<section markdown="block">
## A Pretty Print Method

<pre class="fragment"><code data-trim contenteditable>
public static void pp(int[][] arr) {
  for(int i = 0; i < arr.length; i++) {
    for(int j = 0; j < arr[i].length; j++) {
      System.out.print(arr[i][j] + " ");
    }
    System.out.println();
  }
}

</code></pre>
</section>

<section markdown="block">
## Accessing Elements in a 2D Array

Notice that you can imagine that the: 

* first index is the row number
* the second index is the column number

<pre><code data-trim contenteditable>
int[][] numbers = { {44,45,46}, {47,48,49}, {50,51,52}};
// col:   |0  1  2   
// -------+--------   
// row: 0 |44 45 46
// row: 1 |47 48 49
// rowL 2 |50 51 52
</code></pre>
</section>

<section markdown="block">
## Indexing Practice

__What code would you write to get the following values?__ &rarr;

* 44
* 49

<pre><code data-trim contenteditable>
int[][] numbers = { {44,45,46}, {47,48,49}, {50,51,52}};
// col:   |0  1  2   
// -------+--------   
// row: 0 |44 45 46
// row: 1 |47 48 49
// rowL 2 |50 51 52
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
numbers[0][0]
numbers[1][2]
</code></pre>
</section>

<section markdown="block">
## Neat! Nested Arrays are Pretty Useful

With __multi-dimensional Arrays__ we can model:

* {:.fragment} tabular data
* {:.fragment} a grid
* {:.fragment} even arbitrary data structures 
	* {:.fragment} (well, sort of)
	* {:.fragment} (we'll see that there's a better choice for this later)

<span class="fragment">For example, that table of student homework scores can be represented by a 2D Array...</span>
</section>

<section markdown="block">
## Homework Score Revisited

__Let's try modelling the student scores as a 2d Array... and compute the average for each student.__ &rarr;

<pre><code data-trim contenteditable>
&nbsp;            hw1 hw2 hw3 hw4 hw5
            +---+---+---+---+---+
  student 0 |85 |79 |81 |89 |90 |
            +---+---+---+---+---+
  student 1 |95 |88 |80 |92 |84 |
            +---+---+---+---+---+
  student 2 |72 |78 |71 |74 |77 |
            +---+---+---+---+---+
  student 3 |91 |99 |94 |95 |93 |
            +---+---+---+---+---+
  student 4 |80 |85 |84 |82 |88 |
            +---+---+---+---+---+
</code></pre>

</section>


<section markdown="block">
## We Can Start Off With a 2D Array

<pre class="fragment"><code data-trim contenteditable>
int[][] studentScores = {
	{85, 79, 81, 89, 90},
	{95, 88, 80, 92, 84},
	{72, 78, 71, 74, 77},
	{91, 99, 94, 95, 93},
	{80, 85, 84, 82, 88}
};
</code></pre>
</section>
<section markdown="block">
## Here's One Version

__How many loops will we need to do this?__  __Let's implement it!__ &rarr;

<pre><code data-trim contenteditable>
for(int i = 0; i < scores.length; i++) {
    int total = 0;
    for(int num: scores[i]) {
        total += num;
    }
    System.out.printf(
        "student %s: %s\n", 
        i,
        total / (double) scores[i].length
    );
}
</code></pre>
</section>
<section markdown="block">
## Really Though...

It may have been handy to just create a method that gets the average rather than nesting that for loop, right?

<pre><code data-trim contenteditable>
public static double average(int[] numbers) {
	int total = 0;
	for(int num: numbers) {
		total += num;
	}
	return total / numbers.length;
}
</code></pre>
</section>


<section markdown="block">
## Hidden Treasure Game

Create the following game:

* ask for dimensions, n
* create a grid n x n
* generate a random coordinate in that grid, keep track of it
* print out the grid with o's for every element
* continually ask the user for two numbers
* if the coordinates don't match, display the grid with an x
* if the coordinates match, display the grid with the $ at the coordinates (and stop asking for numbers)
* allow only 5 guesses
</section>

<section markdown="block">
## Example Output

<pre><code data-trim contenteditable>
o o o o o
o o o o o 
o o o o o 
o o o o o 
coords?
> 1, 2
</code></pre>

<pre><code data-trim contenteditable>
o o o o o
o o x o o 
o o o o o 
o o o o o 
coords?
> 2, 2
</code></pre>
</section>

<section markdown="block">
## Additional Exercises

* sum of a diagonal
* autograder 5000! 

</section>
