package com.knoldus

object BasicPatternMatching extends App {

  /**
   * In This Section we'll discuss all basic types of Pattern Match being used in SCALA.
   */

  /***
   *  Wildcard Pattern -
   *  This type of Pattern is used to Match any case or any type of Pattern.
   */
  def wildCardPattern(value : Any) =
    value match {
      case _ => println("Yes!!! I'm wildcard pattern and can match anything.")
    }

  wildCardPattern("What is this !!!")

  /**
   * Variable Pattern -
   * This type of pattern is used to bound a parameter to a variable so that we can use that value anywhere required.
   */
  def variablePattern(name : String) =
    name match {
      case n => println(s"My name is $n")
    }
  variablePattern("I'm a Variable")

  /***
   * Typed Pattern -
   * This Pattern Matching is used to bound the match to a particular Data Type.
   */
  def typedPattern(value : Any) = {
    value match{
      case name : String => println(s"String Data type with value $name")
      case int : Int => println(s"Int data type with value $int")
      case _ => println("Unknown Data Type")
    }
  }
  typedPattern(5)
  typedPattern("Typed Pattern")

  /***
   * Constant Pattern -
   * Constant Pattern is used in case we want to match a expression against a constant.
   */
  def constantPattern(any : Any) = {
    any match {
      case "Knolx" => println("yeah it is Knolx")
      case 10 => println("Ohhhh it's 10")
      case _ => println("Offf I'm wildcard pattern !")
    }
  }
  constantPattern("Knolx")

  /***
   * Stable Identifiers -
   * This type of pattern matching is used when expression is matched against a variable being declared in program.
   */
  def stableIdentifiers(name : String) = name match {
    case `clientName` => println(s"[Info] Start working with $clientName")
  }
  val clientName = "3TL"
  stableIdentifiers("3TL")

  /***
   * Tuple Pattern -
   * In case if you want to match an expression against a Tuple, use Tupple Pattern
   */
  def verifyTuplePattern(any: Any) = any match {
    case (_, "KG") => println("Wooowww KG")
    case (1, _ ) => println("Ranked 1")
    case _ => println("Unknown Data")
  }
  verifyTuplePattern(1, "MG")

  /***
   * Constructor Pattern -
   * This type of Pattern is specially used for Case Class Matching.
   */

  case class Knolx(name : String, topic : String, rank : Int)
  def constructorPattern(any: Any) = any match {
    case Knolx(name, "SCALA", _) => println(s"Hi ${name} Department is Scala")
    case Knolx(_, _, 2) => println("Nice Attempt")
    case Knolx("Knolder", "SCALA", 1) => println("yuppss time to celebrate")
    case _ => println("Unformatted data")
  }

  constructorPattern(Knolx("Kuldeepak", "SCALA", 1))
  constructorPattern("verify Me")
  constructorPattern(Knolx("Name", "Topic", 2))

  /***
   * Sequence Pattern -
   * This type of Pattern is used when expression needs to matched against a Sequence with some particular cases.
   */

  def sequencePattern(value : Seq[Any]) = {
    value match {
      case Seq(1, 2, 3) => println("Ooops")
      case x +: Nil => println("One element is stored")
      case _ :+ x => println(s"Last element is ${x}")
      case _ => println("Better Luck next time")
    }
  }
  val seq = Seq(1, 2, 3, 4)
  sequencePattern(seq)

  /***
   * Pattern Alternatives -
   * In case if you have similar actions for different cases, use Pattern Alternatives.
   */
  def patternAlternatives (any: Any) = any match {
    case Seq(1, 2, 3, 4) | Seq(1, 2, 3) => println("Sequence Matched !!")
    case  "Scala" | "SCALA" => println("Language Detected")
    case _ => println("Refer your friend")
  }
  patternAlternatives(Seq(1, 2, 3))

  /***
   * Pattern Binders -
   * Binding a pattern to a variable is done in Pattern Binders.
   */
  def patternBinders(any: Any) = any match {
    case knolx @ Knolx(name, _, 1) => println(s"Data Found $knolx")
    case _ => println("Try next Time")
  }
  patternBinders(Knolx("name", "topic", 1))

}