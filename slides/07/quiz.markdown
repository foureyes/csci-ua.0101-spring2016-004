---
layout: slides
title: "Quiz"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
## Characters

__How many bits are a character?__ &rarr;

<span class="fragment">16-bits</span>

__What is the backslash character used for?__ &rarr;

<span class="fragment">To signify the start of an escape sequence... such as a newline or tab</span>

__How do we create a character literal with a unicode code point (what's the syntax)?__ &rarr;

<span class="fragment">\u0000</span>

__What's the output of the following code?__ &rarr;

<pre><code data-trim contenteditable>
int i = 'A';
System.out.println(i);
</code></pre>

<span class="fragment">65</span>
</section>


<section markdown="block">
## Operators

__What's the output of the following code?__ &rarr;

<pre><code data-trim contenteditable>
// lowercase letters a through z are 97 - 122

char ch = 'x'

System.out.println(ch > 97);
System.out.println(ch + 1);
System.out.println((char) (ch + 1));
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
true
121
y
</code></pre>
</section>

<section markdown="block">
## Character Methods, Hexadecimal

__What's the output of the following code?__ &rarr;

<pre><code data-trim contenteditable>
System.out.println(Character.isLetterOrDigit('a'));
System.out.println(Character.isDigit('\u0062'));
System.out.println(Character.isLowerCase('\u0070'));
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
A
B
C
C
</code></pre>
</section>
<section markdown="block">
## Increment and Decrement

__What's the output of the following code?__ &rarr;

<pre><code data-trim contenteditable>
char ch = 'A'
System.out.println(ch++);
System.out.println(ch);
System.out.println(++ch);
System.out.println(ch);
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
A
B
C
C
</code></pre>
</section>
