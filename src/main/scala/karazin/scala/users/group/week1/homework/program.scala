package karazin.scala.users.group.week1.homework

// Do not forget to import custom implementation
import adt._

import model._
import services._

object program:

  def getPostsViews() = ErrorOr[List[ErrorOr[PostView]]] = {
    for
      profile   ← getUserProfile()
      posts     ← getPosts(profile.userId)
      postsView ← ErrorOr(posts map { post ⇒ getPostView(post) })
    yield postsView
  }

  def getPostView(post: Post): ErrorOr[PostView] = {
    for
      comments  ← getComments(post.postId)
      likes     ← getLikes(post.postId)
      shares    ← getShares(post.postId)
    yield PostView(post, comments, likes, shares)
  }

  def getPostsViewDesugared(): ErrorOr[List[Option[PostView]]] =
    getUserProfile() flatMap { profile ⇒
      getPosts(profile.userId)
    } map { posts ⇒
      posts map { post ⇒
        getComments(post.postId) flatMap { comments ⇒
          getLikes(post.postId) flatMap { likes ⇒
            getShares(post.postId) map { shares ⇒
              PostView(post, comments, likes, shares)
            }
          }
        }
      }
    }
  