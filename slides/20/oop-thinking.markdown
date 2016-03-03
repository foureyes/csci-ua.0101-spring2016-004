---
layout: slides
title: "Objects in Arrays, Object Oriented Thinking"
---

<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
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
* sorting algos, sorting objects, show demo
* swapping
* composing, and is a / has a relationship
* Farm and Animals
* aggregation vs composition
* stacks
* growing a stack

</section>
{% endcomment %}
