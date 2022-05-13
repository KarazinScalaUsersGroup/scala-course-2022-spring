package karazin.scala.users.group.week5.topic

object givens:

  trait Order[T]:
    def compare(left: T, right: T): Int

  given IntOrder: Order[Int] with
    def compare(left: Int, right: Int): Int = 
      if left < right       then -1
      else if left > right  then +1
      else 0
      
  given CharOrder: Order[Char] with
    def compare(left: Char, right: Char): Int = 
      if left < right       then -1
      else if left > right  then +1
      else 0

  