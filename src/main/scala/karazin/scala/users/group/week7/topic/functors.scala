package karazin.scala.users.group.week7.topic

import scala.annotation.tailrec

object functors:
  
  trait Functor[F[_]]:
    def map[A, B](list: F[A])(f: A => B): F[B]

  given Functor[List] with
    def map[A, B](list: List[A])(f: A => B): List[B] =
      def mapReq[A, B](acc: List[B])(list: List[A], f: A => B): List[B] =
        list match
          case Nil          ⇒ acc
          case head :: tail ⇒ mapReq[A, B](acc :+ f(head))(tail, f)

      mapReq[A, B](Nil)(list, f)
  