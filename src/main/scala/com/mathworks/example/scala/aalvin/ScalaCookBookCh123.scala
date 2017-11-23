package com.mathworks.example.scala.aalvin

import scala.util.matching.Regex.Match

object ScalaCookBookCh123 extends App {
  val zippedList = List(1, 3, 1, 3)

  zippedList.zipWithIndex

  println(zippedList)

  val result = List(1, 3, 1, 3).zipWithIndex.filter(_._2 % 2 == 0).map(_._1).sum

  println(result)

  /* Strings - split */

  val s = "eggs, milk, butter, cocopuffs"

  val split = s.split(",")

  split foreach println

  /* Strings - interpolation */

  val name = "Fred"
  val age = 33
  val weight = 200.0

  println(s"$name is $age years old and weighs $weight pounds")

  case class Student(name: String, score: Int)

  val Paul = Student("Paul", 10)

  println(s"${Paul.name} has received the score ${Paul.score}")

  println(f"$name weights $weight%.2f pounds")

  /* Processing a string one character at a time */
  val upper = "hello, world".map(c => c.toUpper)
  val upper2 = "hello, world".map(_.toUpper)
  val upper3 = for (c <- "hello, world") yield c.toUpper

  println(upper)
  println(upper2)
  println(upper3)

  val removeLetters = "hello, world".filter(_ != 'l').map(_.toUpper)

  println(removeLetters)

  val removeLettersYield = for {
    c <- "hello, world"
    if c != 'l'} yield c.toUpper

  println(removeLettersYield)


  /* Finding patterns in strings */
  val numPattern = "[0-9]+".r
  val address = "123 Main Street Suite 101"

  val match1 = numPattern.findFirstIn(address)

  println(match1)

  val matches = numPattern.findAllIn(address)

  matches foreach println

  /* Replacing patterns in strings */
  val address2 = "123 Main Street"

  val newAddress = address2.replaceFirst("[0-9]", "x")
  val newAddress2 = address2.replaceAll("[0-9]", "x")

  println(newAddress)
  println(newAddress2)

  println("hello".charAt(0))
  println("hello" (2))
  println("hello".apply(1))

  /* Numbers */

  val a: String = "apple"
  val b: String = "6"
  val bb: Int = 66
  val c: Short = 30
  val d: Float = 35f
  val e: Double = 5.8

  val bbb = b + bb

  val bbbString = bbb.toString
  val bInt = b.toInt

  println(bbbString)

  val sum = bInt + bb

  println(sum)

  /* very large numbers */
  val n = BigInt(1234567890)

  /* Generating random numbers */
  val r = scala.util.Random
  val random = r.nextInt(10)
  val range = 0 to r.nextInt(100)

  println(random)
  range take 5 foreach (println)

  /* Range, List, Array */
  val r1 = 1 to 10
  val by2 = r1 by 2

  r1 foreach (println)
  by2 foreach println

  for (i <- 1 until 5) {
    println(i)
  }

  val x = 1 to 10 toArray
  val y = 1 to 10 toList

  val fruits = Array("apple", "banana", "orange")

  for (e <- fruits) {
    println(e)
  }

  val newArray = for (e <- fruits)
    yield e.toUpperCase

  newArray foreach println

  for (i <- 0 until fruits.length) {
    println(s"$i is ${fruits(i)}")
  }

  for ((e, count) <- fruits.zipWithIndex) {
    println(s"$count is $e")
  }

  /* Looping Over A Map */
  val names = Map("fname" -> "Robert",
    "lname" -> "Goren")

  for ((k, v) <- names)
    println(s"key: $k, value: $v")

  names.foreach(println)

  /* For loops with multiple counters */
  for (i <- 1 to 2; j <- 1 to 2) println(s"i = $i, j = $j")

  /* Multi dim array */
  val array = Array.ofDim[Int](2,2)

  array(0)(0) = 0
  array(0)(0) = 1
  array(0)(0) = 2
  array(0)(0) = 3

  for {
    i <- 0 to 1
    j <- 0 to 1
  } println(s"($i)($j) = ${array(i)(j)}")

  /* Creating a For Comprehension */
  val names2 = Array("chris", "ed", "maurice")

  val capNames = for(e <- names2) yield e.capitalize

  capNames foreach println

  var fruits2 = scala.collection.mutable.ArrayBuffer[String]()

  fruits2 += "apple"
  fruits2 += "banana"
  fruits2 += "kiwi"

  fruits2 foreach println

  println(fruits2)

  val out = for (e <- fruits2) yield e.toUpperCase()
  println(out)

  val fruits3 = "apple" :: "banana" :: "kiwi" :: Nil
  val out2 = for (e <- fruits3) yield e.toUpperCase()

  println(s"List Before: $fruits3, List After: $out2" )

  //###################################################
  /* Using break and continue */
  import util.control.Breaks._

  println("\n=== BREAK EXAMPLE ===")
  breakable {
    for (i <- 1 to 10) {
      println(i)
      if (i > 4) break
    }
  }

  println("\n=== CONTINUE EXAMPLE ===")
  val searchMe = "peter piper picked a peck of pickled peppers"
  var numPs = 0
  for(i <- 0 until searchMe.length) {
    breakable {
      if (searchMe.charAt(i) != 'p') {
        break
      } else {
        numPs += 1
      }
    }
  }
  println("Found " + numPs + " p's in the string. ")

  /* Nested loops and labelled breaks */
  println("\n=== NESTED LOOPS/LABELLED BREAKS EXAMPLE ===")

  import scala.util.control._

  val Inner = new Breaks
  val Outer = new Breaks

  Outer.breakable {
    for(i <- 1 to 5) {
      Inner.breakable {
        for(j <- 'a' to 'e') {
          if (i == 1 && j == 'c') Inner.break else println(s"i: $i, j: $j");
          if (i == 2 && j == 'b') Outer.break
        }
      }
    }
  }

  /* calculate a sum of numbers, but limit it to a 'max' value */
  println("\n === Calculate sum of numbers, limit to a 'max' value ===")

  def sumToMax(arr: Array[Int], limit: Int): Int = {
    var sum = 0
    for (i <- arr) {
      sum += i
      if (sum > limit) return limit
    }
    sum
  }
  val a1 = Array.range(0,10)
  println(sumToMax(a1,10))

  ///////////////////////////////////////
  def factorial(n:Int):Int = {
    if (n == 1) 1
    else n * factorial(n - 1)
  }

  println(factorial(5))

  /* Using a Match Expression Like a switch Statement */
 def returnMonth(month: Int) = month match {
   case 1 => println("January")
   case 2 => println("February")
   case 3 => println("March")
   case 4 => println("April")
   case 5 => println("May")
   case 6 => println("June")
   case 7 => println("July")
   case 8 => println("August")
   case 9 => println("September")
   case 10 => println("October")
   case 11 => println("November")
   case 12 => println("December")
   case _ => println("Unexpected case!")
 }

  println(returnMonth(6))

  /* Alternative to a switch */
  val monthNumberToName = Map(
    1 -> "January",
    2 -> "February",
    3 -> "March",
    4 -> "April",
    5 -> "May",
    6 -> "June",
    7 -> "July",
    8 -> "August",
    9 -> "September",
    10 -> "October",
    11 -> "November",
    12 -> "December"
  )

  val monthName = monthNumberToName(5)

  println(monthName)

  /* Matching Multiple Conditions with One Case Statement */
  val i1 = 5

  i1 match {
    case 1 | 3 | 5 | 7 | 9 => println("odd")
    case 2 | 4 | 6 | 8 | 10 => println("even")
  }

  println(i1)

  /* Matching Strings with One Case Statement */
  val cmd = "stop"

  cmd match {
    case "start" | "go" => println ("starting")
    case "stop" | "quit" => println("stopping")
    case _ => println("doing nothing")
  }

  /* Using Pattern Matching in Match Expressions */

  case class Person(firstName: String, lastName: String)
  case class Dog(name: String)

  def echoWhatYouGaveMe(x: Any): String = x match {
    // constant patterns
    case 0 => "zero"
    case true => "true"
    case "hello" => "you said hello"
    case Nil => "an empty list"

    // sequence patterns
    case List(0, _, _) => "a three-element list with 0 as the first element"
    case List(1, _*) => "a list beginning with 1, having any number of elements"
    case Vector(1, _*) => "a vector starting with 1, having any number of elements"

    // tuples
    case (a, b) => s"got $a and $b"
    case (a, b, c) => s"got $a, $b and $c"

    // constructor patterns
    case Person(first, "Alexander") => s"found an Alexander, first name = $first"
    case Dog("Suka") => "found a dog named Suka"

    // typed patterns
    case s: String => s"you gave me this string: $s"
    case i: Int => s"thanks for the int: $i"
    case f: Float => s"thanks for the float: $f"
    case a: Array[Int] => s"an array of int: ${a.mkString(",")}"
    case as: Array[String] => s"an array of strings: ${as.mkString(",")}"
    case d: Dog => s"dog: ${d.name}"
    case list: List[_] => s"thanks for the List: $list"
    case m: Map[_, _] => m.toString

    // the default wildcard pattern
    case _ => "Unknown"
  }

  println("\n === Match expression like a Switch example ===")

  println(echoWhatYouGaveMe(0))
  println(echoWhatYouGaveMe(true))
  println(echoWhatYouGaveMe("hello"))
  println(echoWhatYouGaveMe(Nil))

  println(echoWhatYouGaveMe(List(0,1,2)))
  println(echoWhatYouGaveMe(List(1,2)))
  println(echoWhatYouGaveMe(List(1,2,3)))
  println(echoWhatYouGaveMe(Vector(1,2,3)))

  println(echoWhatYouGaveMe((1,2)))
  println(echoWhatYouGaveMe((1,2,3)))

  println(echoWhatYouGaveMe(Person("Melissa", "Alexander")))
  println(echoWhatYouGaveMe(Dog("Suka")))

  println(echoWhatYouGaveMe("Hello, world"))
  println(echoWhatYouGaveMe(42))
  println(echoWhatYouGaveMe(42F))
  println(echoWhatYouGaveMe(Array(1,2,3)))
  println(echoWhatYouGaveMe(Array("coffee", "apple pie")))
  println(echoWhatYouGaveMe(Dog("Fido")))
  println(echoWhatYouGaveMe(List("apple", "banana")))
  println(echoWhatYouGaveMe(Map(1->"Al", 2->"Alexander")))

  println(echoWhatYouGaveMe("33d"))
  println(echoWhatYouGaveMe(4))

  /* List in match expression */
  val myList1 = List(1,2,3)
  val myList2 = 1 :: 2:: 3 :: Nil

  def listToString(list: List[String]): String = list match {
    case s :: rest => s + " " + listToString(rest)
    case Nil => ""
  }

  println(listToString(List("a", "b", "c", "d")))
  println(listToString(List()))
}