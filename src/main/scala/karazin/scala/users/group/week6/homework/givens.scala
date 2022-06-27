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
    def encode(src: Int): String = src.toString

  given BoolEncoder: JsonStringEncoder[Boolean] with
    def encode(src: Boolean): String = src.toString

  given StringEncoder: JsonStringEncoder[String] with
    def encode(src: String): String = "\"" + src + "\""

  given ListEncoder[T](using encoder: => JsonStringEncoder[T]): JsonStringEncoder[List[T]] with
    def encode(src: List[T]): String = src.map { element => element.toJsonString()}.mkString("[", ",", "]")

  given MapEncoder[V](using encoderValue: => JsonStringEncoder[V])(using encoderKey: => JsonStringEncoder[String]): JsonStringEncoder[Map[String, V]] with
    def encode(src: Map[String, V]): String =
      src.foldLeft(List[String]()) {
        case (acc, (key, value)) => acc :+ (key.toJsonString() + ": " + value.toJsonString())}.mkString("{", ",", "}")

  object JsonStringEncoder:
    def apply[V](using encoder: => JsonStringEncoder[V]): JsonStringEncoder[V] =
      encoder


/*
  Enrich the previous solution and
  * make Map[String, V] convertable to json
  * make sure that all previous converions and a new one
    could be done by calling methos `toJsonString` directly
    on the target object

  Add tests for all cases
*/