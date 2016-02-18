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
## Multi-Dimensional Arrays

A __multi-dimensional__ array that consists of other Arrays!

You can define a multidimensional Array as follows:

<pre><code data-trim contenteditable>
eleType[][] varNAme = new eleType[size][size]
</code></pre>

You can also initialize...

<pre><code data-trim contenteditable>
{
	{1, 1}, 
	{2, 2}
} 
</code></pre>
</section>

<section markdown="block">
## Some Samples

<pre><code data-trim contenteditable>
public static void main(String[] args) {
  int[][] matrix = new int[5][5];
  System.out.println(Arrays.toString(matrix));
  pp(matrix);
  int[][] pad = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
  };
  // let's write a method that prints out a nested array
  pp(pad);
}
</code></pre>
</section>

<section markdown="block">
## A Pretty Print Method

<pre><code data-trim contenteditable>
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

