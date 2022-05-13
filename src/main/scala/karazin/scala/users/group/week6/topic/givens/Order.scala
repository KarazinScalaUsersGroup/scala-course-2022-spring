package karazin.scala.users.group.week6.topic.givens

trait Order[T]:
  def compare(left: T, right: T): Int
  
  extension (x: T) def <(y: T) = compare(x, y) < 0
  extension (x: T) def >(y: T) = compare(x, y) > 0

end Order

object Order:

  given IntOrder: Order[Int] with
    def compare(left: Int, right: Int): Int = 
      if left < right       then -1
      else if left > right  then +1
      else                        0
      
  given CharOrder: Order[Char] with
    def compare(left: Char, right: Char): Int =
      if left < right       then -1
      else if left > right  then +1
      else                        0

  given ListOrder[T](using order: Order[T]): Order[List[T]] with 
    def compare(left: List[T], right: List[T]): Int = (left, right) match
     case (Nil, Nil)  => 0
     case (Nil, _)    => -1
     case (_, Nil)    => +1
     case (leftHead :: leftTail, rightHead :: rightTail) =>
       val compareHeads = order.compare(leftHead, rightHead)
       if compareHeads != 0 then compareHeads else compare(leftTail, rightTail)

  given StringOrder(using order: Order[List[Char]]): Order[String] with
    def compare(left: String, right: String): Int = 
      order.compare(left.toList, right.toList)

end Order