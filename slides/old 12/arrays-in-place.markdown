---
layout: slides
title: "Arrays in Place"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
## Doubling Every Element

__Write a method called doubleEveryElement:__ &rarr;


<pre><code data-trim contenteditable>
/**
 * Doubles every int in the incoming Array. 
 * ([10, 15] --> [20, 30])
 *
 * @param arr an Array of integers
 * @return an entirely NEW Array with every value 
 *         doubled
 */
</code></pre>
{%comment%}*{%endcomment%}
</section>
<section markdown="block">
## Doubling Every Element Version 1

__Easy, eh?__ &rarr;
<pre><code data-trim contenteditable>
public static int[] doubleEveryElement(int[] arr) {
  int[] newArr = new int[arr.length];
  for(int i = 0; i < arr.length; i++) {
    newArr[i] = arr[i] * 2;
  }
  return newArr;
}	
</code></pre>
</section>

<section markdown="block">
## Doubling Every Element Version 1

Here's another version (that doesn't actually adhere to the Javadoc comment, but... let's see what it does). __What's the output of this program?__ &rarr;

<pre><code data-trim contenteditable>
public static void main(String[] args) {
  int[] numbers = {2, 3, 4};
  System.out.println(Arrays.toString(numbers));
  doubleEveryElement(numbers);
  System.out.println(Arrays.toString(numbers));
}
public static void doubleEveryElement(int[] arr) {
  for(int i = 0; i < arr.length; i++) {
    arr[i] = arr[i] * 2;
  }
}
</code></pre>


</section>
<section markdown="block">
## Output of Version 2

The output looks like this... (__why?__ &rarr;)

<pre><code data-trim contenteditable>
[2, 3, 4]
[4, 6, 8]
</code></pre>

* {:.fragment} you're actually passing a reference to the Array
* {:.fragment} (Arrays are reference types, remember? Their variable stores a reference to an area in memory, the __heap__, that stores the actual Array)
* {:.fragment} that means that whatever you do to the argument within the method affects the variable outside of the method 
* {:.fragment} (the variables are pointing to the same Array)
</section>
<section markdown="block">
## Let's See How That Works

__We have a few options for seeing how our code executes__ &rarr;

* {:.fragment} Eclipse debugger (we'll look at this later)
	* {:.fragment} allows set _break points_ that stop your program's execution so that you can resume execution line by line
* {:.fragment} Check out [java visualizer](http://cscircles.cemc.uwaterloo.ca/java_visualize/) or [pythotutor in java mode](http://www.pythontutor.com/visualize.html#mode=edit) (select Java from dropdown)
	* {:.fragment} allows step-by-step execution
	* {:.fragment} shows references and call stack (with activation records/frames)

<span class="fragment"> So... let's check out [doubling every variable](http://cscircles.cemc.uwaterloo.ca/java_visualize/#code=import+java.util.Arrays%3B%0Apublic+class+DoubleEvery+%7B%0A++public+static+void+main(String%5B%5D+args)+%7B%0A++++int%5B%5D+numbers+%3D+%7B2,+3,+4%7D%3B%0A++++System.out.println(Arrays.toString(numbers))%3B%0A++++doubleEveryElement(numbers)%3B%0A++++System.out.println(Arrays.toString(numbers))%3B%0A++%7D%0A+++%0A++public+static+void+doubleEveryElement(int%5B%5D+arr)+%7B%0A++++for(int+i+%3D+0%3B+i+%3C+arr.length%3B+i%2B%2B)+%7B%0A++++++arr%5Bi%5D+%3D+arr%5Bi%5D+*+2%3B%0A++++%7D%0A++%7D%0A%7D&mode=edit).)</span>
{%comment%}__* {%endcomment%}
</section>

<section markdown="block">
## References, Changing in Place

Methods that work on Arrays have two options:

* returning an entirely new Array
* or changing the elements in place
	* doesn't return anything (void)
	* just changes the elements in the argument that's passed in
</section>

<section markdown="block">
## Swap the First and Last Elements

__Let's try a quick exercise. Implement the following:__ &rarr;

<code>swapFirstLastNew</code>

<pre><code data-trim contenteditable>
/**
 * Give back a new Array with the first and last 
 * element of the incoming Array swapped
 * @param arr the source Array 
 * @return a new array that's the same as the source, 
 *         but first and last switched
 */
</code></pre>

<code>swapFirstLast</code>

<pre><code data-trim contenteditable>
/**
 * Swap the first and last element of the incoming 
 * Array in place (no return!)
 * @param arr the Array that will have its first 
 *        and last element swapped
 */
</code></pre>

{%comment%}*{%endcomment%}
</section>

<section markdown="block">
## swapFirstLast (In Place)

<pre><code data-trim contenteditable>
public static void swapFirstLast(int[] arr) {
  int temp = arr[0];
  arr[0] = arr[arr.length - 1];
  arr[arr.length - 1] = temp;
}
</code></pre>


</section>
<section markdown="block">
## swapFirstLastNew

Aaaand. Two versions that return a new Array.

<pre><code data-trim contenteditable>
public static int[] swapFirstLastNew1(int[] arr) {
  int[] newArr = new int[arr.length];
  newArr[0] = arr[arr.length - 1];
  newArr[arr.length - 1] = arr[0];
  if(arr.length > 2) {
    for(int i = 1; i < arr.length - 1; i++) {
      newArr[i] = arr[i];
    }
  }
  return newArr;
}

public static int[] swapFirstLastNew2(int[] arr) {
  int[] newArr = new int[arr.length];
  System.arraycopy(arr, 0, newArr, 0, arr.length);
  newArr[0] = arr[arr.length - 1];
  newArr[arr.length - 1] = arr[0];
  return newArr;
}
</code></pre>

</section>
<section markdown="block">
## Changing in Place Continued

With our new found super powers of changing an Array _in place_, __let's try writing some _classic_ algorithms__ &rarr;

* sorting... __anyone know any sorting algorithms?__ &rarr;
* searching... __we can probably all do a naive version of search__ &rarr;

</section>	

<section markdown="block">
## Sorting (with Selection Sort)

One algorithm for sorting is __Selection Sort__:

* start with the first element
* swap it with the smallest value in the remainder of the elements
* now the first element is sorted...
* ... so swap the next element, with the smallest value in the elements remaining

<pre><code data-trim contenteditable>
// [3, 5, 2, 1] // start with 3, swap it with 1
// [1, 5, 2, 3] // start with 5, swap it with 2
// [1, 2, 5, 3] // start with 5, swap it with 3
// [1, 2, 3, 5] // done
</code></pre>
</section>

<section markdown="block">
## Selection Sort

Here's an [animation](http://upload.wikimedia.org/wikipedia/commons/9/94/Selection-Sort-Animation.gif) (thanks wikipedia):

<div markdown="block" class="img">

![alt](http://upload.wikimedia.org/wikipedia/commons/9/94/Selection-Sort-Animation.gif)

</div>
</section>

<section markdown="block">
## Pseudocode

<pre><code data-trim contenteditable>
selectionSort(arr)

for every starting point from 0 to arr length
   
  // search the remainder of the array for smallest
  smallest = arr[start]
  indexSmallest = start

  for every element from start + 1 to arr length
    if element <  smallest
      smallest = element
  
  swap the smallest with start
</code></pre>

</section>
<section markdown="block">
## A Driver for Main

<pre><code data-trim contenteditable>
public static void main(String[] args) {
  int[] numbers1 = {2, 4, 7, 8, 9};
  int[] numbers2 = {8, 3, 3, 8, 9, 5};
  selectionSort(numbers1);
  System.out.println(Arrays.toString(numbers1));
  selectionSort(numbers2);
  System.out.println(Arrays.toString(numbers2));
}
</code></pre>

</section>

<section markdown="block">
## selectionSort Implementation

<pre><code data-trim contenteditable>
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
</section>

<section markdown="block">
## Search

__What's the simplest way to search.__ &rarr;

<span class="fragment">Loop through every element, see if it matches what you're looking for. This is __Linear Search__. __Let's implement quickly.__</span>

<span class="fragment">__Worst case scenario, how many elements do you have to look through?__</span>

<span class="fragment">The number of elements in the Array (in case it's not found!)</span>
</section>

<section markdown="block">
## Binary Search

Another search algorithm is __Binary Search__:

* the Array is sorted
* find the midpoint index (round down... __why?__)
* if the element at the midpoint is:
	* greater than what you're looking for, do the same search but in the half of the array before the midpoint
	* less than, search after the midpoint array
	* equal... just return!
* continue to do this until you have an empty (or negative!) sub array
</section>

<section markdown="block">
## Woo. Another Animation!

[Binary search example](http://www.cs.armstrong.edu/liang/animation/web/BinarySearch.html)

Aaaand. Some pseudocode:

<pre><code data-trim contenteditable>
start = 0
end = arr.length - 1
mid = arr.length / 2 
while end >= start
	 if arr[mid] == search 
    return mid
  else if search < arr[mid]
    end = mid
  else 
    start = mid
  mid = start + (end - start) / 2
return -1
</code></pre>

</section>

<section markdown="block">
## Binary Search Implementation

<pre><code data-trim contenteditable>
int start = 0;
int end = arr.length - 1;
int mid = arr.length / 2;
while (end >= start) {
	if (search == arr[mid]) {
		return mid;
	} else if (search < arr[mid]) {
		// lower half
		end = mid - 1;
	} else {
		// higher half
		start = mid + 1;
	}
	mid = start + (end - start) / 2;
}
return -1;
</code></pre>

</section>
<section markdown="block">
## Shuffling

__Can anyone think of an algorithm for shuffling in place?__ &rarr;

* {:.fragment} take the first element, swap it with a random element after it
* {:.fragment} go to the next element, swap it with a random element after it
* {:.fragment} do this until no more elements!
</section>

<section markdown="block">
## Variable Length Arguments


<pre><code data-trim contenteditable>
public static void f(type... nameOfVariable)
// shows up as type[] in body of function
</code></pre>

</section>
{% comment %}
<section markdown="block">
## Arrays Class

</section>
<section markdown="block">
## Shuffling

In place
</section>
{% endcomment %}
