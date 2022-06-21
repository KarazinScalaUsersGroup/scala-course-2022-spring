package karazin.scala.users.group.week8.topic

import java.util.UUID

/*
  Consider the way to implement blog structure (getting rid of details):
  * each user has unique id
  * each post belongs to one user and has unique id
  * each comment belongs to one user (author of the comment) and commented post
  * each share belongs to one user (who shares the post) and shared post
  
  View represents gathered information due to each service could be responsible only
  for one domain 
 */
object model:

  case class UserProfile(userId: UUID)
  case class Post(userId: UUID, postId: UUID)
  case class Comment(userId: UUID, postId: UUID)
  case class Like(userId: UUID, postId: UUID)
  case class Share(userId: UUID, postId: UUID)
  case class PostView(post: Post, comments: List[Comment], likes: List[Like], shares: List[Share])
