package karazin.scala.users.group.week2.topic

import scala.util.Try
import scala.util.Success
import scala.util.Failure

object monadic extends App:

  /* 
    Option(_) constructor should be used by default
   */
  val option1: Option[Int] = Option(42)
  
  /* 
    Some(_) constructor could be used in case of 
    a full assurance that the value cannot be null 
   */
  val option2: Option[Int] = Some(42)

  /*
    Option(_) constructor should be used while working with Java code
    to avoid NPE
   */
  assert(Option(null) == None) 
  assert(Some(null) == Some(null)) 
  
  assert(Try { 0 / 1 } == Success(0))
  
  Try { 1 / 0 } match {
    case Success(_)     ⇒ assert(false)
    case Failure(error) ⇒ assert(error.getMessage == "divide by zero")
  }
  
  assert(List(Nil, 1 :: Nil, 2 :: 3 :: Nil).flatten == 1 :: 2 :: 3 :: Nil)