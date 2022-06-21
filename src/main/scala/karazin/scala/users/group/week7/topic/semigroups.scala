package karazin.scala.users.group.week7.topic

object semigroups:

  trait Semigroup[T]:
    extension (left: T) def combine(right: T): T

  object Semigroup:
    def apply[T](using semigroup: Semigroup[T]): Semigroup[T] = semigroup

  given Semigroup[Int] with
    extension (left: Int) def combine(right: Int): Int = left + right

  given Semigroup[String] with
    extension (left: String) def combine(right: String): String = left concat right

  given [T]: Semigroup[List[T]] with
    extension (left: List[T]) def combine(right: List[T]): List[T] = left ::: right



