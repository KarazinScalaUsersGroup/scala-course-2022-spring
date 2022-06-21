package karazin.scala.users.group.week8.topic

import java.util.UUID
import cats.data.Kleisli
import cats.FlatMap
import cats.implicits._


// Do not forget to import custom implementation
import karazin.scala.users.group.week8.topic.model._

/*
  Dummy services
  
  The services need to be implemented in case of running the code
 */
object services:
  
  object GetComments:

    type Result[F[_]] = Kleisli[F, UUID, List[Comment]]

    def apply[F[_]: FlatMap]: Result[F] = ???

  end GetComments

  object GetLikes:

    type Result[F[_]] = Kleisli[F, UUID, List[Like]]

    def apply[F[_]: FlatMap]: Result[F] = ???

  end GetLikes

  object GetShares:

    type Result[F[_]] = Kleisli[F, UUID, List[Share]]

    def apply[F[_]: FlatMap]: Result[F] = ???

  end GetShares