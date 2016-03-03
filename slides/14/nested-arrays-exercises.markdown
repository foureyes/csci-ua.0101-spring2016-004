---
layout: slides
title: "Nested Array Exercises"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>



<section markdown="block">
## Hidden Treasure Game

Create the following game:

* ask for dimensions, n
* create a grid n x n
* generate a random coordinate in that grid, keep track of it
* print out the grid with o's for every element
* continually ask the user for two numbers
* if the coordinates don't match, display the grid with space (' ')
* if the coordinates match, display the grid with the $ at the coordinates (and stop asking for numbers)
* allow only 5 guesses
</section>

<section markdown="block">
## Example Output

<pre><code data-trim contenteditable>
o   o o o
o o o o o 
o o o o o 
o o o o o 
coords?
> 1, 2
</code></pre>

<pre><code data-trim contenteditable>
o   o o o
o o o o o 
o o $ o o 
o o o o o 
coords?
> 3, 3
</code></pre>
</section>


<section markdown="block">
## Matrix Multiplication


<pre><code data-trim contenteditable>

|a b c|   |u v|
|d e f|   |w x|
          |y z|

</code></pre>

</section>

<section markdown="block">
## Matrix Multiplication

* m1 num cols must be equal to m2 num rows
* resulting matrix is m1 rows, m2 cols
* 2 row, 3 cols * 3 rows, 2 cols 
	* (ok 3 == 3)
	* (resulting matrix is 2 x 2)
</section>

<section markdown="block">
## Matrix Multiplication


<pre><code data-trim contenteditable>

|a b c|   |u v|
|d e f|   |w x|
          |y z|

= | au + bw + by ...|
  | ...          ...|
</code></pre>

* multiply each row in m1 by each col in m2
* row 1 in m1, col 1 in m2 ... gives us number at row 1, col 1 in result

</section>

<section markdown="block">
## An Implementation

<pre><code data-trim contenteditable>
public static int[][] multiply(int[][] m1, int[][] m2) {
    int[][] result = new int[m1.length][m2[0].length];
    // outer loops represent row col in existing matrix
    for(int row = 0; row < result.length; row++) {
        for(int col = 0; col < result.length; col++) {
            // for each one, get every col in m1's row...
            for(int i = 0; i < m1[row].length; i++) {
                // row persists in m1, col persists in m2
                result[row][col] += m1[row][i] * m2[i][col]; 
            }
        }
    }
    return result;
}

</code></pre>
</section>
