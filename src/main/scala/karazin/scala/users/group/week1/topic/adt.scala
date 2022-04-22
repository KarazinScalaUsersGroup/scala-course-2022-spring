package karazin.scala.users.group.week1.topic

object adt:

  enum Option[+V]:

    case Some(x: V) extends Option[V]

    case None extends Option[Nothing]

    // The method is used for defining execution pipelines
    def flatMap[Q](f: V ⇒ Option[Q]): Option[Q] =
      this match
        case Option.None     ⇒ Option.None
        case Option.Some(v)  ⇒ f(v)

    // The method is used for changing the internal object
    def map[Q](f: V ⇒ Q): Option[Q] =
      this match
        case Option.None     ⇒ Option.None
        case Option.Some(v)  ⇒ Option.Some(f(v))

  // Companion object to define constructor
  object Option:
    def apply[V](v: V): Option[V] =
      if v == null then Option.None else Option.Some(v)
