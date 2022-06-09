package karazin.scala.users.group.week1.homework

import java.util.UUID

// Do not forget to import custom implementation
import adt._
import model._

/*
  Dummy services
  
  The services need to be implemented in case of running the code
 */
object services:
  def getUserProfile(): ErrorOr[UserProfile] = 
    UserProfile(UUID.randomUUID())
  def getPosts(userId: UUID): ErrorOr[List[Post]] = 
      Post(userId = UUID.randomUUID(), postId = UUID.randomUUID()) :: Nil
  def getComments(postId: UUID): ErrorOr[List[Comment]] = 
      Comment(userId = UUID.randomUUID(), postId = UUID.randomUUID()) :: Nil
  def getLikes(postId: UUID): ErrorOr[List[Like]] = 
      Like(userId = UUID.randomUUID(), postId = UUID.randomUUID()) :: Nil
  def getShares(postId: UUID): ErrorOr[List[Share]] =
      Share(userId = UUID.randomUUID(), postId = UUID.randomUUID()) :: Nil
