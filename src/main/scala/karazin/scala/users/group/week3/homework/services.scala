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

object services:
  
  def getUserProfile(): Future[UserProfile] =
    Future {
      UserProfile(UUID.randomUUID())
    }

  def getPosts(userId: UUID): Future[List[Post]] =
    Future {
      Post(
        userId = usedId,
        postId = UUID.randomUUID()
      ) :: Nil
    }

  def getComments(postId: UUID): Future[List[Comment]] = 
    Future {
      // Emulating time consumed operation
      Thread.sleep(5000)
      Comment(userId = UUID.randomUUID(), postId = postId) :: Nil
    }
  
  def getLikes(postId: UUID): Future[List[Like] =
    Future {
      // Emulating time consumed operation
      Thread.sleep(2000)
      Like(userId = UUID.randomUUID(), postId = postId) :: Nil
    }
  
  def getShares(postId: UUID): Future[List[Share]] = 
    Future {
      // Emulating time consumed operation
      Thread.sleep(500)
      Share(
        userId = UUID.randomUUID(),
        postId = postId
      ) :: Nil
    }