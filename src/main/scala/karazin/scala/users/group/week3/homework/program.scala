/*

Fix the code to make it compilable
Write tests
 */

package karazin.scala.users.group.week3.homework

import java.util.UUID
import scala.concurrent.Future
import scala.util.Success
import scala.util.Failure

import karazin.scala.users.group.week3.homework.model._
import services._;
import concurrent.ExecutionContext.Implicits.global

object program:

  def getPostView(post: Post): Future[PostView] = 
    for
      comments  <- getComments(post.postId)
      likes     <- getLikes(post.postId)
      shares    <- getShares(post.postId)
    yield PostView(post, comments, likes, shares)
    
