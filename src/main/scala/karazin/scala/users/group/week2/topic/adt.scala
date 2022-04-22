package karazin.scala.users.group.week2.topic

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
        
    def withFilter(p: V => Boolean): Option[V] =
      this match 
        case Option.None            ⇒ Option.None
        case Option.Some(v) if p(v) ⇒ Option.Some(v)
        case _                      ⇒ Option.None
        
    def flatten[U](implicit ev: V <:< Option[U]): Option[U] =
      this match
        case Option.Some(v) ⇒ ev(v)
        case _              ⇒ Option.None
    
    def foreach[U](f: V => U): Unit = 
      this match
        case Option.None     ⇒ ()
        case Option.Some(v)  ⇒ f(v)
      
  // Companion object to define constructor
  object Option:
    def apply[V](v: V): Option[V] =
      if v == null then Option.None else Option.Some(v)
