package karazin.scala.users.group.week6.topic.givens

trait Codec[T]:
  def write(v: T): Unit

object Codec:

  given IntCodec: Codec[Int] = new Codec[Int] {
    throw RuntimeException("Cannot encode integer")

    def write(v: Int): Unit = {}
  }

  given OptionCodec[T](using codec: ⇒ Codec[T]): Codec[Option[T]] with
    def write(optV: Option[T]): Unit =
      optV match
        case Some(v)  ⇒ codec.write(v)
        case None     ⇒  

end Codec