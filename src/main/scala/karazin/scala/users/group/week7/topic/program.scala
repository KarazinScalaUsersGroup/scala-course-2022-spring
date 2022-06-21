package karazin.scala.users.group.week7.topic

import karazin.scala.users.group.week7.topic.semigroups.{given, _}
import karazin.scala.users.group.week7.topic.monoids.{given, _}
import karazin.scala.users.group.week7.topic.functors.{given, _}

object program extends App:

  object semigroups:

    assert(Semigroup[Int].combine(41)(1) == 42)

    assert(("Hello" combine " " combine "world") == "Hello world")

    assert((("Hello" :: " " :: Nil) combine ("world" :: Nil)) == "Hello" :: " " :: "world" :: Nil)

  end semigroups

  object monoids:

    def sum[T: Monoid](vs: List[T]): T =
      vs.foldLeft(Monoid[T].unit) { _ combine _ }

    assert(sum((1 to 99).toList) == 4950)

    assert(sum("Hello" :: " " :: "world" :: "!" :: Nil ) == "Hello world!")

  end monoids

  object functors:

    assert(
      summon[Functor[List]].map((1 to 99).toList) { int ⇒
        int * 2
      } == (2 to 198 by 2).toList
    )

  end functors

  semigroups
  monoids
  functors

end program