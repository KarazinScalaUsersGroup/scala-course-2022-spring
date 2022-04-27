package karazin.scala.users.group.week3.topic

import java.util.UUID
import scala.concurrent.Future
import scala.util.Success
import scala.util.Failure

import scala.concurrent.ExecutionContext.Implicits.global

import model._

/*
  Dummy services
  
  The services need to be implemented in case of running the code
 */
object services:
   
  def getUserProfile(): Future[UserProfile] =
    Future {
      UserProfile(UUID.randomUUID())
    }
  
  def getPosts(userId: UUID): Future[List[Post]] =
    Future {
      Post(userId = UUID.randomUUID(), postId = UUID.randomUUID()) :: Nil
    }
  
  def getComments(postId: UUID): Future[List[Comment]] = 
    Future {
      /* 
       We are using `println` for simplicity.
       Don't do this in a production ready code.
      */
      println("Start getting comments...")
      /* 
       We are using `println` for simplicity.
       Don't do this in a production ready code.
      */      
      println(s"Current thread comments: ${Thread.currentThread().getName}")
      Thread.sleep(5000)
      /* 
       We are using `println` for simplicity.
       Don't do this in a production ready code.
      */      
      println("Got comments...")
      Comment(userId = UUID.randomUUID(), postId = UUID.randomUUID()) :: Nil
    }
  
  def getLikes(postId: UUID): Future[List[Like]] = 
    Future {
      /* 
       We are using `println` for simplicity.
       Don't do this in a production ready code.
      */      
      println("Start getting likes...")
      /* 
       We are using `println` for simplicity.
       Don't do this in a production ready code.
      */      
      println(s"Current thread for likes: ${Thread.currentThread().getName}")
      Thread.sleep(2000)
      /* 
       We are using `println` for simplicity.
       Don't do this in a production ready code.
      */      
      println("Got likes...")
      Like(userId = UUID.randomUUID(), postId = UUID.randomUUID()) :: Nil
    }
  
  def getShares(postId: UUID): Future[List[Share]] = 
    Future {
      /* 
       We are using `println` for simplicity.
       Have you fed off with this comment? Read the next.
      */      
      println("Start getting shares...")
      /* 
       We are using `println` for simplicity.
       Don't do this in a production ready code.
      */   
      println(s"Current thread for shares: ${Thread.currentThread().getName}")
      Thread.sleep(500)
      /* 
       We are using `println` for simplicity.
       Don't do this in a production ready code.
      */   
      println("Got shares...")
      Share(userId = UUID.randomUUID(), postId = UUID.randomUUID()) :: Nil
    }