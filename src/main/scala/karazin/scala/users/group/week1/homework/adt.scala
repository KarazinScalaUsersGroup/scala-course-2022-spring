package karazin.scala.users.group.week1.homework

object adt:

  enum ErrorOr[+V]:

    case Success(x: V) extends ErrorOr[V]

    case Fail extends Error("Something went wrong...")

    def flatMap[Q](f: V ⇒ ErrorOr[Q]): ErrorOr[Q] =
      this match
        case ErrorOr.Fail   ⇒ ErrorOr.Fail
        case ErrorOr.Success ⇒ f(v)

    def map[Q](f: V ⇒ Q) : ErrorOr[Q] =
      this match
        case ErrorOr.Fail   ⇒ ErrorOr.Fail
        case ErrorOr.Success ⇒ ErrorOr.Success(f(v))

  object ErrorOr:
    def apply[V](v: V): ErrorOr[V] =
      if v == null then ErrorOr.Fail else ErrorOr.Success
