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
    ErrorOr(UserProfile(UUID.randomUUID()))
  def getPosts(userId: UUID): ErrorOr[List[Post]] = 
    ErrorOr(Post(userId = UUID.randomUUID(), postId = UUID.randomUUID()) :: Nil)
  def getComments(postId: UUID): ErrorOr[List[Comment]] = 
    ErrorOr(Comment(userId = UUID.randomUUID(), postId = UUID.randomUUID()) :: Nil)
  def getLikes(postId: UUID): ErrorOr[List[Like]] = 
    ErrorOr(Like(userId = UUID.randomUUID(), postId = UUID.randomUUID()) :: Nil)
  def getShares(postId: UUID): ErrorOr[List[Share]] =
    ErrorOr(Share(userId = UUID.randomUUID(), postId = UUID.randomUUID()) :: Nil)
