package karazin.scala.users.group.week1.homework

/* 
  Custom implementation of Option (Maybe monad in Haskell)
  Implemented via Scala 3 way for Algebraic Data Types (ADT)
  
  Resources:
  * https://en.wikipedia.org/wiki/Algebraic_data_type
  * https://docs.scala-lang.org/scala3/book/types-adts-gadts.html
*/

object adt:

  enum ErrorOr[+V]:

    case Or(x: V) extends ErrorOr[V]
    case Error(ex: Throwable) extends ErrorOr[V]

    //The method is used for defining execution pipelines
    def flatMap [Q](f: V ⇒ ErrorOr[Q]): ErrorOr[Q] =
      this match
        case ErrorOr.Error(ex) ⇒ ErrorOr.Error(ex)
        case ErrorOr.Or(x)     ⇒ f(x : V)

    //The method is used for changing the internal object
    def map [Q](f: V ⇒ Q): ErrorOr[Q] =
      this match
        case ErrorOr.Error(ex)   ⇒ ErrorOr.Error(ex)
        case ErrorOr.Or(x)       ⇒ ErrorOr.Or(f(x))

  // Companion object to define constructor
  object ErrorOr:

    //Provide a type parameter, an argument and a result type
    def apply [V](v: => V): ErrorOr[V] =
      try ErrorOr.Or(v) catch {
        case ex: Throwable => ErrorOr.Error(ex)
      }