package karazin.scala.users.group.week2.topic

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
    Both `map`-, `flatMap` and `withFilter`-required case
    Pipeline execution, the one service is called after another
    Then internal object is changed (from `List[Post]` to `Post`)
   */
  def getUserFirstPosts: Option[Post] =
   for
     profile ← getUserProfile()
     posts   ← getPosts(profile.userId)
     if posts.nonEmpty
   yield posts.head
   
  def getUserFirstPostsDesugared: Option[Post] = 
    getUserProfile() flatMap { profile ⇒
      getPosts(profile.userId)
    } withFilter { posts ⇒
      posts.nonEmpty
    } map { posts ⇒
      posts.head
    }
