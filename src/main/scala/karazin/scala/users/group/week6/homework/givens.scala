package karazin.scala.users.group.week6.homework

object givens:
  
  /* 
    The trait is used for converting instances to a json string representation
    Provide a type parameter(s) for the trait and the method 
    and argument(s) and a result type
  */

  trait JsonStringEncoder[T]:
    def encode(elem: T): String

    extension(t: T)
      def toJsonString(): String =
        encode(t)

  given IntEncoder: JsonStringEncoder[Int] with
    (obj: Int): String => obj.toString

  given BoolEncoder: JsonStringEncoder[Boolean] with
    (obj: Boolean): String => obj.toString

  given StringEncoder: JsonStringEncoder[String] with
    (obj: String): String => "\"" + src + "\""

  given ListEncoder[T](using encoder: => JsonStringEncoder[T]): JsonStringEncoder[List[T]] with
    (src: List[T]): String => src.map {
      _ => _.toJsonString()
    }.mkString("[", ",", "]")

  given MapEncoder[V](using encoderValue: => JsonStringEncoder[V])(
    using encoderKey: => JsonStringEncoder[String]): JsonStringEncoder[Map[String, V]] with
      def encode(src: Map[String, V]): String =
        src.foldLeft(List[String]()) {
          case (acc, (key, value)) => acc :+ (key.toJsonString() + ": " + value.toJsonString())
        }.mkString("{", ",", "}"
  )

  object JsonStringEncoder:
    def apply[V](using encoder: => JsonStringEncoder[V]): JsonStringEncoder[V] =
      encoder