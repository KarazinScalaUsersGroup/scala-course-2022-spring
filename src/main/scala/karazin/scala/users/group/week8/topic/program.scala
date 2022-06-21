package karazin.scala.users.group.week8.topic

// Do not forget to import custom implementation
import java.util.UUID

import cats.data.Kleisli
import cats.FlatMap
import cats.implicits._

import karazin.scala.users.group.week8.topic.model._
import karazin.scala.users.group.week8.topic.services._

object program:

  object GetPostView:

    type Result[F[_]] = Kleisli[F, Post, PostView]

    def apply[F[_]: FlatMap]:
    GetComments.Result[F] ⇒ GetLikes.Result[F] ⇒ GetShares.Result[F] ⇒ Result[F] =
      getComments ⇒ getLikes ⇒ getShares ⇒ Kleisli { case post ⇒
        for
          comments  ← getComments(post.postId)
          likes     ← getLikes(post.postId)
          shares    ← getShares(post.postId)
        yield PostView(post, comments, likes, shares)
      }

  end GetPostView

  object initialization:
    //             : ~ UUID => Option[List[Comment]]
    val getComments: Kleisli[Option, UUID, List[Comment]] = GetComments[Option]

    //          : ~ UUID => Option[List[Like]]
    val getLikes: Kleisli[Option, UUID, List[Like]] = GetLikes[Option]

    //           : UUID => Option[List[Share]]
    val getShares: Kleisli[Option, UUID, List[Share]] = GetShares[Option]

    //             : ~ Post => Option[PostView]
    val getPostView: Kleisli[Option, Post, PostView] =
      GetPostView[Option].apply(getComments)(getLikes)(getShares)

  end initialization

  import initialization._

  // Usage example
  val post: Post = ???

  val postView: Option[PostView] = getPostView(post)
