package karazin.scala.users.group.week2.topic

import java.util.UUID

// Do not forget to import custom implementation
import adt._

import model._

/*
  Dummy services
  
  The services need to be implemented in case of running the code
 */
object services:
  
  def getUserProfile(): Option[UserProfile] = ???
  def getPosts(userId: UUID): Option[List[Post]] = ???
  def getComments(postId: UUID): Option[List[Comment]] = ???
  def getLikes(postId: UUID): Option[List[Like]] = ???
  def getShares(postId: UUID): Option[List[Share]] = ???
