package karazin.scala.users.group.week4.homework

import java.util.UUID

object model:
  case class UserProfile(userId: UUID)
  case class Post(userId: UUID, postId: UUID)
  case class Comment(userId: UUID, postId: UUID)
  case class Like(userId: UUID, postId: UUID)
  case class Share(userId: UUID, postId: UUID)
  case class PostView(post: Post, comments: List[Comment], likes: List[Like], shares: List[Share])

