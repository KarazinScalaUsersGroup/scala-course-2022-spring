package karazin.scala.users.group.week3.homework

import scala.util.Success
import scala.util.Failure

import karazin.scala.users.group.week3.homework.model._
import karazin.scala.users.group.week3.homework.services._

object program:

  def getPostView(post: Post): PostView = {
    
    val getCommentsService  = getComments(post.postId)
    val getLikesService     = getLikes(post.postId)
    val getSharesService    = getShares(post.postId)
    
    for (
      comments  ← getCommentsService
      likes     ← getLikesService
      shares    ← getSharesService
    ) {
      yield PostView(post, comments, likes, shares)
    }
  }