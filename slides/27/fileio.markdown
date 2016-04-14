---
layout: slides
title: "File I/O"
---

<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>
{% comment %}
* draw a star using points ... read points from different files
	* make points file
	* read points from file, color
	* read points from other file using arguments
	* what if file doesn't exist or no arguments
* 
Printwriter
Using split
Commandline arguments
Catching Exceptions
{% endcomment %}

<section markdown="block">
## the File class

The <code>File</code> class represents a file and its information:

<pre><code data-trim contenteditable>
File f = new File(nameOfFile)
</code></pre>


</section>

<section markdown="block">
## Using the File Class

Get information about foo.txt (this will be located in your project folder if you only specify a file name):

<pre><code data-trim contenteditable>
import java.io.File;

public class Filesy {
	public static void main(String[] args) {
		File f = new File("foo.txt");
		System.out.println(f.exists());
		System.out.println(f.getAbsolutePath());
	}
}
</code></pre>
</section>

<section markdown="block">
## Reading from a File

You can use a <code>Scanner</code> object with your <code>File</code> object to read from a file:

* create a <code>File</code> object
* create a <code>Scanner</code> object (using the <code>File</code> object as an argument to the constructor)
* declare an <code>IOException</code> for your method (Scanner may throw a checked exception)
* read each part of a file by "token"
	* <code>next()</code> - by space
	* <code>nextLine()</code> - by new line
* use a while loop and check your <code>Scanner</code> object's <code>hasNext</code> method if there's more data to read

</section>
<section markdown="block">
## Reading from a File

<pre><code data-trim contenteditable>
import java.io.IOException;
import java.util.Scanner;

public class Filesy {
  // scanner may throw a checked exception, so declare it
  public static void main(String[] args) throws IOException {
    // read from foo.txt in project directory
    File f = new File("foo.txt");
    Scanner input = new Scanner(f);
	// as long as there is data to read from the file...
    while(input.hasNext()) {
      // get each "token" separated by space
      System.out.println(input.next());
    }
  }
}
</code></pre>
</section>

<section markdown="block">
## A Few Notes Regarding File Location

* in a regular Java program run through Eclipse, files will be retrieved _relative_ to your project folder.
* in a regular Processing program run through Eclipse, files will be retrieved _relative_ to your project's bin folder.
* you can also pass in an absolute path (for example, <code>/Users/joe/Desktop/myFile.txt</code> to access a specific file outside of your project folder)

</section>

<section markdown="block">
## Commandline Arguments

You can add _parameters_ to your program by specifying _commandline arguments_. These are values that show up in your <code>main</code> method's <code>args</code> parameter.

* go to run &rarr; run configurations
* choose your class on the left hand side
* click on the arguments tab and add space separated values (val1 val2 val3)
* they will show up in <code>args</code>: <code>args[0]</code> will have val, etc.
</section>

<section markdown="block">
## Writing to a File

Use a combination of a <code>File</code> object and a <code>PrintWriter</code> object to write to a file.

__PrintWriter__ allows you to write to a file...

* again, instantiate a <code>File</code> object
* use that file object as the argument in <code>PrintWriter</code>'s  constructor
	* <code>PrintWriter out = new PrintWriter(myFileObject);
* you can call the <code>write</code> method to write out to the file
* you must call <code>close</code> when you're done writing in order to _save_ your writes
* note that you will have to handle a checked exception, <code>IOException</code>, either with <code>try/catch</code> or by declaring 

</section>

<section markdown="block">
## Writing Out to a File Example

<pre><code data-trim contenteditable>
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
</code></pre>
<pre><code data-trim contenteditable>
// throw an IOException... since it's a checked exception
public static void main(String[] args) throws IOException {
    File f = new File("my_output_file.txt");
	PrintWriter out = new PrintWriter(f);
	out.write("hello");
	// hm... what happens if you forget to close?
    out.close();
}
</code></pre>
</section>

