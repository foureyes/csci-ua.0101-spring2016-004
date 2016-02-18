---
layout: slides
title: "Nested Loops, Loops Odds and Ends"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
## Patterns

Let's try to use nested loops to generate the following patterns.

[This format string specifier guide may come in handy](http://alvinalexander.com/programming/printf-format-cheat-sheet)
</section>

<section markdown="block">
## Triangle 1

<pre><code data-trim contenteditable>
1
1 2
1 2 3
1 2 3 4
1 2 3 4 5
1 2 3 4 5 6	  
</code></pre>
</section>

<section markdown="block">
## Triangle 1

<pre><code data-trim contenteditable>

public class Patterns {
	public static void main(String[] args) {
		int size = 6;
		System.out.println("pattern 1");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.printf("%2d", j + 1);
			}
			System.out.println();
		}
	}
}
</code></pre>
</section>

<section markdown="block">
## Triangle 2

<pre><code data-trim contenteditable>
1 2 3 4 5 6
1 2 3 4 5
1 2 3 4
1 2 3
1 2
1
</code></pre>
</section>

<section markdown="block">
## Triangle 2

<pre><code data-trim contenteditable>
System.out.println("\npattern 2, v1");
for (int i = 1; i <= size; i++) {
	for (int j = 1; j <= size - i + 1; j++) {
		System.out.printf("%2d", j);
	}
	System.out.println();
}

System.out.println("\npattern 2, v2");
for (int i = size; i >= 1; i--) {
	for (int j = 1; j <= i; j++) {
		System.out.printf("%2d", j);
	}
	System.out.println();
}
</code></pre>
</section>


<section markdown="block">
## Triangle 3

<pre><code data-trim contenteditable>       
Triangle 3...
          1 
        2 1 
      3 2 1 
    4 3 2 1 
  5 4 3 2 1 
6 5 4 3 2 1 	
</code></pre>
</section>

<section markdown="block">
## Triangle 3

<pre><code data-trim contenteditable>
System.out.println("\npattern 3");
for (int i = 1; i <= size; i++) {
	for (int j = size; j > 0; j--) {
		if (j <= i) {
			System.out.printf("%-2d", j);
		} else {
			System.out.print("  ");
		}
	}
	System.out.println();
}

/*
// or two inner for loops, one after the other
// print spaces first, then print numbers
for (int i = size; i > 0; i--) {
	for (int j = i ; j < size; j++) {
		System.out.printf("  ");
	}
	for (int j = 1; j <= i; j++) {
		System.out.print(" " + j);
	}
	System.out.println();
}
*/
</code></pre>
</section>
