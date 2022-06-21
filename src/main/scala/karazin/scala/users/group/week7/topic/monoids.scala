package karazin.scala.users.group.week7.topic

import karazin.scala.users.group.week7.topic.semigroups.{given, _}
import scala.language.postfixOps


object monoids:

  trait Monoid[T] extends Semigroup[T]:
    def unit: T

  object Monoid:
    def apply[T](using monoid: Monoid[T]): Monoid[T] = monoid

  given Monoid[Int] with
    extension (left: Int) def combine(right: Int): Int = left + right
    def unit: Int = 0
    
  given Monoid[String] with
    extension (left: String) def combine(right: String): String = left concat right  
    def unit: String = ""
    