---
layout: slides
title: "Objects and Classes Continued"
---
<section markdown="block" class="intro-slide">
# {{ page.title }}

### {{ site.course_number}}-{{ site.course_section }}

<p><small></small></p>
</section>

<section markdown="block">
# Review Classes and Objects Basics

</section>
<section markdown="block">
## A Quick Recap

Let's start off by:

* talking about a few definitions... 
* and building classes and objects as we go along 
</section>

<section markdown="block">
## Classes and Objects

__Describe what an object is...__ &rarr;

* {:.fragment} an __object__ is data and the actions that you can perform on that data
* {:.fragment} an object in Java is a reference type
* {:.fragment} objects are created from classes
* {:.fragment} objects created from a class are __instances__ of that class 
* {:.fragment} objects are often used to model _real_ world entities

<span class="fragment">__What's a class?__ &rarr;</span>

* {:.fragment} a class is a blueprint for creating objects of the same type
* {:.fragment} you can think of a class as a _custom type_
* {:.fragment} it specifies the data and actions that an object can have
</section>

<section markdown="block">
## Designing Classes and Objects

Let's create classes and objects that represent bank accounts. __What kind of data does a bank account have (and what's the type of each)... and what actions would you be able to perform on that data?__ &rarr;

* {:.fragment} data
	* {:.fragment} account number
	* {:.fragment} balance
* {:.fragment} actions
	* {:.fragment} withdraw
	* {:.fragment} deposit
</section>

<section markdown="block">
## Creating a Class

When we create a __class__: 

* __what do we name the file that we put the class in?__ &rarr;
* {:.fragment} the file should be named the same as the class 
* {:.fragment} __is there a convention for naming classes?__ &rarr;
* {:.fragment} (upper) CamelCase ... first letter of every word uppercase, remainder lowercase ([you know, like a camel](http://c2.com/cgi/wiki?CamelCase))
* {:.fragment} __do classes require a main method?__ &rarr;
* {:.fragment} nope! only include <code>main</code> in the class that you want as the entry point to your program
</section>

<section markdown="block">
## A Bank Account Class

__Let's create the bare minimum number of files and code to create a class that can make bank account objects.__ &rarr;

<span class="fragment">In __BankAccount.java__ ...</span>

<pre class="fragment"><code data-trim contenteditable>
public class BankAccount {

}
</code></pre>

<span class="fragment">(oh hey, Eclipse does this for you already)</span>
</section>

<section markdown="block">
## Default Constructors

__What's a constructor?__ &rarr;

* {:.fragment} a __constructor__ is a special method in a class that is responsible for creating / initializing objects of that class
* {:.fragment} __can you still create objects from a class without an explicitly defined constructor? why?__ &rarr;o
* {:.fragment} yes - there is a default constructor that has no parameters (only if no other constructors are defined!)
* {:.fragment} based on our empty BankAccount class, we can start creating BankAccount objects even if a constructor is not yet explicitly defined... __let's try it__ &rarr;


</section>

<section markdown="block">
## Creating BankAccount Objects

Admittedly, our current implementation is a bit bare, but we can create <code>BankAccount</code> objects using the default constructor! __Using a separate file, create a new <code>BankAccount</code> object and set it equal to a variable called <code>myAccount</code>__ &rarr;

* {:.fragment} create a new class (.java) file named <code>BankAccountTest</code> in the same project (directory) as your <code>BankAccount.java</code>
* {:.fragment} within the file, create a <code>class</code> that contains a <code>main</code> method
* {:.fragment} within the <code>main</code> method...
* {:.fragment} declare a variable of type, <code>BankAccount</code> (note that it is available in this file because your <code>BankAccount</code> class is in the same directory)
* {:.fragment} set it equal to __new BankAccount()__ - the keyword, __new__, then the _no arg_ constructor
* {:.fragment} we can try printing out our new bank account... but all we get is the class name / type, and a hash code
</section>


<section markdown="block">
## Creating BankAccount Objects Continued

Here's the _actual_ code for the previous slide:

<pre><code data-trim contenteditable>

public class BankAccountTest {
  public static void main(String[] args) {
    // using the default constructor
    BankAccount myAccount = new BankAccount();

	// we get the type/class and hash code when we print
	System.out.println(myAccount);
  }
}

</code></pre>
</section>

<section markdown="block">
## Remember that Objects are References

Let's rewrite the code from the previous slide..
<pre><code data-trim contenteditable>

// create a reference variable called myAccount
// myAccount can reference a BankAccount object
BankAccount myAccount 

// now the reference in myAccount points to a 
// newly created BankAccount object!
myAccount = new BankAccount();
</code></pre>
</section>

<section markdown="block">
## Data Fields

An object can have data... and we use a class to define the kind of data that an object can have. __What are some names (synonyms for) that we call an object's data?__ &rarr;

* {:.fragment} __data fields__, __attributes__, __properties__, or __instance variables__ 
* {:.fragment} in a class, we define data fields within the class definition and outside of all method definitions
* {:.fragment} __let's add two data fields to our BankAccount class: an account number and a balance, an int and double__ &rarr;


<span class="fragment">(back in __BankAccount__)</span>

<pre class="fragment"><code data-trim contenteditable>
public class BankAccount {
  int accountNumber;
  int balance;
}

</code></pre>

</section>

<section markdown="block">
## Accessing Data in an Object

Now... in <code>BankAccountTest.java</code>, we created an account. Ostensibly that object has some data. Note that an object's data and actions are sometimes referred to as an object's __members__. __How would we access our object's account number and balance?__ &rarr;

* {:.fragment} use the __dot operator__ (just a period - <code>.</code>)... which is also called the __object member access operator__
* {:.fragment} <code>myAccount.accountNumber</code>... and <code>myAccount.balance</code>
</section>

<section markdown="block">
## Default Values

Based on our bare bones definition of our BankAccount class, __what is the output of the following code if it were placed in BankAccountTest.java__ &rarr;

<pre><code data-trim contenteditable>
public class BankAccountTest {
  public static void main(String[] args) {
    BankAccount myAccount = new BankAccount();
    System.out.println(myAccount.accountNumber);
    System.out.println(myAccount.balance);
  }
}
</code></pre>

<span class="fragment">0... and 0.0. The default values for numeric types are (you guessed it!) 0.</span>



</section>
<section markdown="block">
## Back to Constructors

Ok... we see that there's a constructor with no parameters that's automatically created for us. __Let's try making our own constructor__.

* __how is defining a constructor syntatically different from defining a regular method?__ &rarr;
* {:.fragment} __there's NO RETURN TYPE__! 
* {:.fragment} it __must have the same name as the class that it's in__ 
* {:.fragment} __let's create a constructor that has two arguments, an account number and a starting balance__ &rarr;
* {:.fragment} __set the member variables using the Constructor's parameters__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
BankAccount(int accountNum, double startingBalance) {
	accountNumber = accountNum;
	balance = startingBalance;
}
</code></pre>
</section>

<section markdown="block">
## Using Our Constructor

Upon the creation of our constructor, you'll notice that the compiler gets pretty unhappy with the no arg version of the previous constructor that we used (default constructors are created only if no other constructors are explicitly defined). __Let's fix our code so that it uses our newly created constructor__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
BankAccount myAccount = new BankAccount(123, 100.0);
</code></pre>

<span class="fragment">__Now what will the output of our program be?__ &rarr;</span>

<pre class="fragment"><code data-trim contenteditable>
123
100.0
</code></pre>
</section>

<section markdown="block">
## Hey, I Liked That No Arg Constructor

__Can a class have more than one constructor?__ &rarr;

* {:.fragment} yes -- a class can have more than one constructor, as long as the signatures differ (similar to method overloading)
* {:.fragment} __let's add our no arg constructor back... and default the balance to 0, and the account number to a random number from 1 through 999999999(let's keep this simple, duplicates are ok and we don't care about length)__ &rarr;
* {:.fragment} __let's create another account in our main program and print everything out__ &rarr;

<pre class="fragment"><code data-trim contenteditable>
// BankAccount.java
BankAccount() {
  accountNumber = (int) (Math.random() * 1000000000);
  balance = startingBalance = 0;
}
</code></pre>
<pre><code data-trim contenteditable>
// BankAccountTest.java
BankAccount myOtherAccount = new BankAccount();
System.out.println(myOtherAccount.accountNumber);
System.out.println(myOtherAccount.balance);
</code></pre>
</section>

<section markdown="block">
## Actions / Behaviors

Now that we have a bunch of data, __let's define some actions that we can perform on / with that data.__  If data fields are just variables in classes, __what do we use to implement actions?__ &rarr;

* {:.fragment} we use methods (specifically instance methods); these methods have access to the data fields in an object
* {:.fragment} __let's define deposit and withdraw...__ &rarr;
	* {:.fragment} deposit... should have an amount as a parameter, and it should not return a value. it adds the amount to the balance.
	* {:.fragment} withdraw... should have an amount as a parameter, and it should return the value withdrawn. it subtracts the amount from the balance. if the resulting balance is less than 0, don't perform the withdrawal, and return 0 


</section>


<section markdown="block">
## Deposit and Withdraw Methods 

<pre><code data-trim contenteditable>
void deposit(double amount) {
    balance += amount;
}

double withdraw(double amount) {
    if (balance - amount > 0) {
        balance -= amount;
        return amount;
    } else {
        return 0;
    }
}
</code></pre>
</section>

<section markdown="block">
## Using Methods

Let's use <code>deposit</code> and <code>withdraw</code> to:

* deposit $300 to the second account (myOtherAccount) and print out the balance
* withdraw $200... and then withdraw $200 again; print out the balance and result of withdrawal for both

<pre class="fragment"><code data-trim contenteditable>
myOtherAccount.deposit(300);
System.out.println(myOtherAccount.balance);

double result = myOtherAccount.withdraw(200);
System.out.println(myOtherAccount.balance);
System.out.println(result);

result = myOtherAccount.withdraw(200);
System.out.println(myOtherAccount.balance);
System.out.println(result);
</code></pre>
</section>

<section markdown="block">
## Back to Students

__Create a class called <code>Student</code>... it should contain:__ &rarr;

* a first and last name (just strings)
* homework grades (an array)
* a method to calculate the average homework grade 
* a method to give back a student's full name 
* a constructor that creates a student based on two strings (the first and last name) and an int array (the student's grades)
* (see sample usage of the class in the code below)

<pre><code data-trim contenteditable>
student.getFullName(); // --> Alice Alvarez
student.getAverageHomeworkScore() // --> 92.3
</code></pre>

</section>

<section markdown="block">
## A Student Class

__Just the constructor and some data fields...__ &rarr;


<pre class="fragment"><code data-trim contenteditable>
public class Student {
  public String firstName;
  public String lastName;
  public int[] homeworkScores;
  
  public Student(String first, String last, int[] scores) {
    this.firstName = first;
    this.lastName = last;
    this.homeworkScores = scores;
  }
}

</code></pre>
</section>

<section markdown="block">
## Student Class Methods...

The <code>getFullName</code> and <code>getAverageHomeworkScore</code> methods:

<pre class="fragment"><code data-trim contenteditable>
public String getFullName() {
  return firstName + " " + lastName;
}

public float getAverageHomeworkScore() {
  int total = 0;
  for(int score: homeworkScores) {
    total += score;
  }
  return total / homeworkScores.length;
}
</code></pre>
</section>

<section markdown="block">
## Using the Student Class

In a another class, create a <code>main</code> method that...

* creates a 3 element Array of Student objects 
* populates the array with student objects built from your class
* (you can hard code names and scores)
* see next slide for sample code...

</section>

<section markdown="block">
## Some Sample Code...

<pre><code data-trim contenteditable>
Student[] enrolledStudents = new Student[3];
int[] scores1 = {88, 99, 87, 82, 97};
int[] scores2 = {75, 81, 87, 88, 85};
int[] scores3 = {62, 85, 81, 70, 71};

// ============================
// Create student objects here:
// enrolledStudents[0] = ...
// enrolledStudents[1] = ...
// etc.
// ============================

for(Student student: enrolledStudents) {
  System.out.println(student.getFullName() + 
      " - " + student.getAverageHomeworkScore());
}
</code></pre>
</section>

<section markdown="block">
## Default Value of Reference Types

So... what would happen if we created an additional constructor with no arguments:

<pre><code data-trim contenteditable>
public Student() { }
</code></pre>

__What's the output of the code below... and why?__ &rarr;

<pre><code data-trim contenteditable>
Student s = new Student();
System.out.println(s.homeworkScores);
</code></pre>

<pre class="fragment"><code data-trim contenteditable>
null
</code></pre>
</section>

<section markdown="block">
## null

__null__ is a special literal in Java... that signifies that this object does not exist yet.

* __null__ is a literal
* it can be assigned to a variable
* it is the default value of reference types
</section>

<section markdown="block">
# Objects are References

</section>
