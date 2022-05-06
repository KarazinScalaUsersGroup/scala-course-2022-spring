package karazin.scala.users.group.week4.topic

import java.util.UUID
import java.util.concurrent.Executors
import scala.concurrent.Future
import scala.concurrent.ExecutionContext
import scala.concurrent.ExecutionContextExecutorService
import scala.util.Success
import scala.util.Failure

import scala.concurrent.Await
import scala.concurrent.duration._

import scala.language.postfixOps

import model._
import services._

object program extends App:
  
  val singleThreadPoolContext: ExecutionContextExecutorService =
    ExecutionContext.fromExecutorService(Executors.newSingleThreadExecutor)
    
  val fixedThreadPoolContext: ExecutionContextExecutorService =
    ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(2))
  
  given ExecutionContext = ExecutionContext.global
  
  def getPostView(post: Post)(using ec: ExecutionContext): Future[PostView] = 
    println(s"Main thread: ${Thread.currentThread().getName}")
    
    val getCommentsService  = getComments(post.postId)(singleThreadPoolContext)
    val getLikesService     = getLikes(post.postId)(fixedThreadPoolContext)
    val getSharesService    = getShares(post.postId)(fixedThreadPoolContext)
    
    for
      comments  ← getCommentsService
      likes     ← getLikesService
      shares    ← getSharesService
    yield PostView(post, comments, likes, shares)
  
  end getPostView
  
  singleThreadPoolContext.shutdown()
  fixedThreadPoolContext.shutdown()