/*Task:
  • fix the code to make it compilable
  • use at least 2 execution contexts:
    • one for a `for comprehension`
    • at least one for `getComments`, `getLikes`, `getShares`
  • write tests
*/

package karazin.scala.users.group.week4.homework

import java.util.UUID
import scala.concurrent.Future
import scala.util.Success
import scala.util.Failure

import scala.concurrent.{ExecutionContext, ExecutionContextExecutorService}
import java.util.concurrent.Executors

import karazin.scala.users.group.week4.homework.model._
import  karazin.scala.users.group.week4.homework.services._


object program:

  given ExecutionContext = ExecutionContext.global

  def getPostsViews()(using ec: ExecutionContext): Future[List[PostView]] =
    val fixedThreadPoolContext = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(2))

    val getUserProfileService = getUserProfile()(using fixedThreadPoolContext)

    for (
      profile <- getUserProfileService
      posts <- getPosts(profile.userId)(using fixedThreadPoolContext)
      postsView = posts map {post => getPostView(post)}
      postsViews <- Future.foldLeft(postsView)(List[PostView]()) { (acc, elem) => elem :: acc}
    )
    yield {
      fixedThreadPoolContext.shutdown()
      postsViews
    }


  def getPostView(post: Post)(using ec: ExecutionContext): Future[PostView] =

    val fixedThreadPoolContext = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(2))
    val getCommentsService = getComments(post.postId)(using fixedThreadPoolContext)
    val getLikesService = getLikes(post.postId)(using fixedThreadPoolContext)
    val getSharesService = getShares(post.postId)(using fixedThreadPoolContext)

    for (
      comments  ← getCommentsService
      likes     ← getLikesService
      shares    ← getSharesService
    )
    yield {
      fixedThreadPoolContext.shutdown()
      PostView(post, comments, likes, shares)
    }