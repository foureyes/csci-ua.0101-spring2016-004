---
layout: homework
title: "Sorting"
---
# Sorting

### Resources

Download the code below to try in Eclipse:

* [An annotated implementation of sorting objects with Bubble sort (Sort.java)](../resources/code/Sort.java)

### Sorting Algorithms

#### [Selection Sort](http://en.wikipedia.org/wiki/Selection_sort)

* See chapter 7.11 our book {{ site.book }}
* Or... check out [the example on Wikipedia's Selection Sort page](http://en.wikipedia.org/wiki/Selection_sort#Example)

#### [Bubble Sort](http://en.wikipedia.org/wiki/Bubble_sort)

* Bubble sort algorithm:
	1. Go through every element in the <code>Array</code> (except the last)
	2. Compare it with the element next to it
	3. If the element is greater than the adjacent element, swap the two elements
	4. If no swaps have occurred after the last comparison, stop... otherwise, repeat the process again
* See the [step-by-step example](http://en.wikipedia.org/wiki/Bubble_sort#Step-by-step_example) on Wikipedia.
* As well as the [pseudocode](http://en.wikipedia.org/wiki/Bubble_sort#Pseudocode_implementation).

#### Sorting Objects

When sorting objects, you must determine what property of the object you will use to sort on (for example, if you have a <code>Book</code> class, you may sort on title, or on author's last name. Use that in your comparison, but when you swap places, you must swap the entire object.

__Swapping__

First, let's see how swapping objects work. In the following example: 

* we swap the element at index 0 (with id 100) 
* ...with the element at index 1 (with id 101)

<pre><code data-trim contenteditable>// we have two objects in an Array (imagine that the string representation of the
// objects gives us the content between the parentheses
// [(key=8,id=100), (key=3,id=101)]
// after the elements are swapped:
// [(key=3,id=101), (key=8,id=100)]
</code></pre>

[An example of swapping objects based on comparing data fields.](http://www.pythontutor.com/visualize.html#code=public+class+Foo+%7B%0A++++int+key%3B%0A++++int+id%3B%0A++++Foo(int+key)+%7B%0A++++++++this.key+%3D+key%3B%0A++++++++this.id+%3D+id%3B%0A++++%7D%0A++++%0A++++public+static+void+main(String%5B%5D+args)+%7B%0A++++++++Foo%5B%5D+foos+%3D+new+Foo%5B2%5D%3B%0A++++++++foos%5B0%5D+%3D+new+Foo(7)%3B%0A++++++++foos%5B1%5D+%3D+new+Foo(3)%3B%0A++++++++if(foos%5B0%5D.key+%3E+foos%5B1%5D.key)+%7B%0A++++++++++++Foo+temp+%3D+foos%5B0%5D%3B%0A++++++++++++foos%5B0%5D+%3D+foos%5B1%5D%3B%0A++++++++++++foos%5B1%5D+%3D+temp%3B%0A++++++++%7D%0A++++++++System.out.println(java.util.Arrays.toString(foos))%3B%0A++++++++StringBuffer+b+%3D+new+StringBuffer()%3B%0A++++++++b.append('c')%3B%0A++++++++System.out.println(b)%3B%0A++++%7D%0A%7D&mode=display&origin=opt-frontend.js&cumulative=false&heapPrimitives=true&textReferences=false&py=java&rawInputLstJSON=%5B%5D&curInstr=18)

__Sorting__

[Step through the example file (sorting objects with bubble sort)  above in pythontutor's Java mode.](http://www.pythontutor.com/visualize.html#code=import+java.util.Arrays%3B%0A%0Apublic+class+Cat+%7B%0A%09%0A%09int+cutenessFactor+%3D+10%3B%0A%09String+name%3B%0A%09%0A%09/**%0A%09+*+Cat+constructor...+%0A%09+*+%40param+name%0A%09+*+%40param+cutenessFactor%0A%09+*/%0A%09public+Cat(String+name,+int+cutenessFactor)+%7B%0A%09%09this.cutenessFactor+%3D+cutenessFactor%3B%0A%09%09this.name+%3D+name%3B%0A%09%7D%0A%09%0A%09public+String+toString()+%7B%0A%09%09return+this.name+%2B+%22,+cuteness+factor+%22+%2B+this.cutenessFactor%3B%0A%09%7D%0A%09%0A%09/**%0A%09+*+We're+dropping+our+main+method+directly+into+the+Cat+class+that+we're+%0A%09+*+using+just+for+ease+of+use.+Normally,+you+would+have+your+Cat+class+%0A%09+*+completely+separate+from+the+class+that+serves+as+the+entry+point+into%0A%09+*+your+program.+(We're+doing+both+in+the+same+file+here).%0A%09+*+%40param+args%0A%09+*/%0A%09public+static+void+main(String%5B%5D+args)+%7B%0A%09%09%0A%09%09Cat%5B%5D+cats+%3D+new+Cat%5B3%5D%3B%0A%09%09cats%5B0%5D+%3D+new+Cat(%22Bill+Furry%22,+8)%3B%0A%09%09cats%5B1%5D+%3D+new+Cat(%22Katie+Purry%22,+6)%3B%0A%09%09cats%5B2%5D+%3D+new+Cat(%22Hunter+S.+Tomcat%22,+7)%3B%0A%09%09System.out.println(%22Before+sorting%3A%22)%3B%0A%09%09System.out.println(Arrays.toString(cats))%3B%0A%09%09bubbleSort(cats)%3B%0A%09%09System.out.println(%22All+sorted!%22)%3B%0A%09%09System.out.println(Arrays.toString(cats))%3B%0A%09%7D%0A%09%0A%09/**%0A%09+*+Sorts+cats+by+cuteness+factor%0A%09+*+%40param+arr+an+Array+of+cute+cats+(er...+Cat+objects)%0A%09+*/%0A%09public+static+void+bubbleSort(Cat%5B%5D+arr)+%7B%0A%09%09//+the+number+of+swaps+that+have+occurred%0A%09%09int+count%3B%0A%09%09do+%7B%0A%09%09%09//+start+with+0+swaps%0A%09%09%09count+%3D+0%3B%0A%09%09%09for(int+i+%3D+0%3B+i+%3C+arr.length+-+1%3B+i%2B%2B)+%7B%0A%09%09%09%09//+compare+by+objects'+cuteness+factor%0A%09%09%09%09if(arr%5Bi%5D.cutenessFactor+%3E+arr%5Bi+%2B+1%5D.cutenessFactor)+%7B%0A%09%09%09%09%09//+swap+object+positions+(make+sure+to+swap+the+entire%0A%09%09%09%09%09//+object)%0A%09%09%09%09%09Cat+temp+%3D+arr%5Bi%5D%3B%0A%09%09%09%09%09arr%5Bi%5D+%3D+arr%5Bi+%2B+1%5D%3B%0A%09%09%09%09%09arr%5Bi+%2B+1%5D+%3D+temp%3B%0A%09%09%09%09%09//+count+this+as+a+swap%0A%09%09%09%09%09count%2B%2B%3B%0A%09%09%09%09%7D%0A%09%09%09%7D%0A%09%09%7D+while(count+%3E+0)%3B%0A%09%7D%0A%7D&mode=display&origin=opt-frontend.js&cumulative=false&heapPrimitives=true&textReferences=false&py=java&rawInputLstJSON=%5B%5D&curInstr=41).
