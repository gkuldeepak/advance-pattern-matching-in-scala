package com.knoldus

object AdvancedPatternMatching extends App {

  /***
   * In this Section we'll discuss some advanced concept of Pattern Matching.
   * In case if we have to match an expression against a Class, then we can do it as follows by instantiating an object of class.
   */

  class Employees (val name : String, val age : Int, val Id : Int)
  object Employee{
    def unapply(employees: Employees) : Option[(String, Int, Int)] = Some((employees.name, employees.age, employees.Id))
    def unapply(age : Int) : Option[String] = if(age<18) Some("minor") else Some("major")
  }

  val Employee1 = new Employees("Knolder", 22, 1471)
  Employee1 match {
    case Employee(n, a, i) => println(s"name is ${n} age is $a id is $i")
  }

  Employee1.age match {
    case Employee(status) => println(s"Status is $status")
  }

  val number = 15
  number match {
    case value : Int if(value%2 ==0) => println("EVEN number")
    case value : Int if (value%5 ==0) => println("Multiple of 5")
    case _ => println("Try Again")
  }

  object Even {
    def unapply (arg : Int) : Boolean  = if(arg % 2 ==0) true else false
  }

  number match {
    case Even() => println("EVEN NUMBER")
    case _ => println("CHECK your number")
  }

  /**
   * Infix Patterns
   */
  case class KNOLX[A, B](a : A, b: B)
  val knolx = KNOLX("knolder", 1)
  val description = knolx match {
    case "Knolder" KNOLX 1 => println("EXCELLENT")
    case KNOLX(name, rank) => println(s"name is $name and rank is $rank")
  }

  /**
   * Custom return type for unapply method
   */
  abstract class Wrapper[A] {
    def isEmpty : Boolean
    def get : A
  }

  object WrapEmployee {
    def unapply(employees: Employees) : Wrapper[String] = new Wrapper[String] {
      def isEmpty = false
      def get = employees.name
    }
  }

  Employee1 match {
    case WrapEmployee(emp) => println(s"The person name is $emp")
  }
}
