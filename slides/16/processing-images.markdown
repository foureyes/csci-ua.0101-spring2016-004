---
layout: slides
title: "Processing and Images"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>


{% comment %}
<section markdown="block">
## 

<div markdown="block" class="img">
![alt](../../resources/img/black-and-white.png)
</div>
<div markdown="block" class="img">
![alt](../../resources/img/edge.png)
</div>
<div markdown="block" class="img">
![alt](../../resources/img/processing-image.png)
</div>
<div markdown="block" class="img">
![alt](../../resources/img/red.png)
</div>
<div markdown="block" class="img">
![alt](../../resources/img/static-color.gif)
</div>
<div markdown="block" class="img">
![alt](../../resources/img/static-gray.gif)
</div>
<div markdown="block" class="img">
![alt](../../resources/img/truchet-rotate.gif)
</div>
</section>
{% endcomment %}


<section markdown="block">
## 

* create new class file
* import <code>PApplet</code>
* extend you class as usual
* import <code>PImage</code>
* create a global <code>PImage</code> variable
* load in setup by using <code>loadImage</code>


</section>
<section markdown="block">
## 

what is it? /data folder?
eclipse wants to manage all your jamz.

So, just let it. Life will be easier.

But just so you know
1. right click source folder &rarr; new &rarr; other ... choose folder
2. in finder or in explorer, copy image to data folder
3. right click on data folder... refresh
4. build
5. if build doesn't work, clean
If you copy stuff in through the finder, eclipse doesn't "realize" you did so. The data/ folder should be created throught the eclipse "Package Explorer" under the src/ folder. Eclipse will then create bin/data/. 

If you want to add and image you will have to make sure it can be seen in the src folder. Add it through eclipse or refresh the folder. If it still does not appear select project->clean in the menu. This will delete your bin/ directory and recreate it from src/.

</section>

<section markdown="block">
## 
Data structure that represents images

</section>

<section markdown="block">
## 

* window pixels represented as a single array
* __how__ &rarr;
loadPixels
* represents pixels in window
updatePixels
* updates the pixels in window
pixels[]
color

</section>
