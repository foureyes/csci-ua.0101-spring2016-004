---
layout: slides
title: "File I/O"
---

<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

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
