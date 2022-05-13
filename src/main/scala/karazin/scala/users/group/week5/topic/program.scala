package karazin.scala.users.group.week5.topic

import givens.{given, _}

object program:

  def max[T](left: T, right: T)(using order: Order[T]): T =
    if order.compare(left, right) == 1 then left
    else right



