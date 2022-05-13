package karazin.scala.users.group.week6.topic

import scala.util.Try

import karazin.scala.users.group.week6.topic.givens.Order
import karazin.scala.users.group.week6.topic.givens.Order.{given, _}

import karazin.scala.users.group.week6.topic.givens.Codec
import karazin.scala.users.group.week6.topic.givens.Codec.{given, _}

object program extends App:
  
  def max[T: Order](left: T, right: T): T =
    if left > right then left
    else right
    
  def min[T: Order](left: T, right: T): T =
    if summon[Order[T]].compare(left, right) < 0 then left
    else right
    
  def same[T](left: T, right: T)(using order: Order[T]): Option[T] =
    if order.compare(left, right) == 0 then Option(left)
    else None
    
  assert(max(41, 42) == 42, "41 < 42")
  assert(max('Z', 'A') == 'Z', "'A' < 'Z'")
  assert(max("Hello", "world") == "world", "\"Hello\" < \"world\"")
  
  assert(
    Try(
      summon[Codec[Option[Int]]].write(Some(42))
    ).isFailure,
    "Should fail with runtime exception"  
  )

  assert(
    Try(
      summon[Codec[Option[Int]]].write(None)
    ).isSuccess,
    "Should succeed"  
  ) 