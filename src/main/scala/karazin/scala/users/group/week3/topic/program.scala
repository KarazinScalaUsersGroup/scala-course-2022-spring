package karazin.scala.users.group.week3.topic

import java.util.UUID
import scala.concurrent.Future
import scala.util.Success
import scala.util.Failure

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Await
import scala.concurrent.duration._

import scala.language.postfixOps

import model._
import services._

object program extends App:

  // Getting view for a particular user's post
  def getPostViewWrongWay(post: Post): Future[PostView] = 
    
    /* 
      We are using `println` for simplicity.
      Don't do this in a production ready code.
     */
    println(s"Main thread: ${Thread.currentThread().getName}")
    
    /*
      Calling methods inside the for comprehension
      leads to running all futures sequntially in one thread.
      
      Don't do this.
     */
    for
      comments  ← getComments(post.postId)
      likes     ← getLikes(post.postId)
      shares    ← getShares(post.postId)
    yield PostView(post, comments, likes, shares)
  
  Await.result(getPostViewWrongWay(Post(userId = UUID.randomUUID(), postId = UUID.randomUUID())), 20 seconds)

  // Getting view for a particular user's post
  def getPostView(post: Post): Future[PostView] = 
    /* 
      We are using `println` for simplicity.
      Don't do this in a production ready code.
     */
    println(s"Main thread: ${Thread.currentThread().getName}")
    
    val getCommentsService  = getComments(post.postId)
    val getLikesService     = getLikes(post.postId)
    val getSharesService    = getShares(post.postId)
    
    for
      comments  ← getCommentsService
      likes     ← getLikesService
      shares    ← getSharesService
    yield PostView(post, comments, likes, shares)
  
  println(Await.result(getPostView(Post(userId = UUID.randomUUID(), postId = UUID.randomUUID())), 20 seconds))
  