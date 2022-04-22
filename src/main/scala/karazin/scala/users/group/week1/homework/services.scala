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
  
  def getUserProfile(): ErrorOr[UserProfile] = ???
  def getPosts(userId: UUID): ErrorOr[List[Post]] = ???
  def getComments(postId: UUID): ErrorOr[List[Comment]] = ??? 
  def getLikes(postId: UUID): ErrorOr[List[Like]] = ???
  def getShares(postId: UUID): ErrorOr[List[Share]] = ???
