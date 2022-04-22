package karazin.scala.users.group.week1.topic

import java.util.UUID

// Do not forget to import custom implementation
import adt._
import model._
import services._

/*
  Desugaring examples
 */
object desugaring:
  
  /*
    Only `map`-required case
    The only internal object is changed (from `Profile` to `UUID`)
   */
  def getUserId: Option[UUID] =
   for
     profile ← getUserProfile()
   yield profile.userId
   
  def getUserIdDesugared: Option[UUID] =
    getUserProfile() map { profile ⇒
      profile.userId
    }
    
   /*
    Only `flatMap`-required case
    Pipeline execution, the one service is called after another
   */
  def getUserPosts: Option[List[Post]] =
   for
     profile ← getUserProfile()
     posts   ← getPosts(profile.userId)
   yield posts 

  def getUserPostsDesugared: Option[List[Post]] =
    getUserProfile() flatMap { profile ⇒
      getPosts(profile.userId)
    }

   /*
    Both `map`- and `flatMap`-required case
    Pipeline execution, the one service is called after another
    Then internal object is changed (from `List[Post]` to `Post`)
   */
  def getUserFirstPosts: Option[Post] =
   for
     profile ← getUserProfile()
     posts   ← getPosts(profile.userId)
   yield posts.head
   
  def getUserFirstPostsDesugared: Option[Post] = 
    getUserProfile() flatMap { profile ⇒
      getPosts(profile.userId)
    } map { posts ⇒
      posts.head
    }
