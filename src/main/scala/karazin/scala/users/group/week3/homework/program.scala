/*

Fix the code to make it compilable
Write tests

package karazin.scala.users.group.week3.homework

import java.util.UUID
import scala.concurrent.Future
import scala.util.Success
import scala.util.Failure

import karazin.scala.users.group.week3.homework.model._


object program:

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