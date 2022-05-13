/*

Task:
  • fix the code to make it compilable
  • use at least 2 execution contexts:
    • one for a `for comprehension`
    • at least one for `getComments`, `getLikes`, `getShares`
  • write tests

package karazin.scala.users.group.week4.homework

import java.util.UUID
import scala.concurrent.Future
import scala.util.Success
import scala.util.Failure

import karazin.scala.users.group.week4.homework.model._


object program:
  // Make sure that the result type is exactly `Future[List[PostView]]`
  // not `Future[List[Future[PostView]]]`
  def getPostsViews(): Future[List[PostView]] = ???

  def getPostView(post: Post): Future[PostView] = 
    
    val getCommentsService  = getComments(post.postId)
    val getLikesService     = getLikes(post.postId)
    val getSharesService    = getShares(post.postId)
    
    for
      comments  ← getCommentsService
      likes     ← getLikesService
      shares    ← getSharesService
    yield PostView(post, comments, likes, shares)
    
 */