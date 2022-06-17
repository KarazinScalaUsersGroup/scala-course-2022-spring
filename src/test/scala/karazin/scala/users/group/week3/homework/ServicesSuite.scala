package karazin.scala.users.group.week3.homework

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import java.util.UUID
import munit.Clue.generate
import services._
import model._
/*
  Write test for all service in karazin.scala.users.group.week3.homework.services

  Review:
    • https://scalameta.org/munit/docs/tests.html
    • https://scalameta.org/munit/docs/assertions.html
 */

class ServicesSuite extends munit.FunSuite:
  
  test("getposts test") {
    val id = UUID(1,1)
    val posts = getPosts(id)

    posts map {
      posts => for (post <- posts) assertEquals(post.userId, id)
    }
  }

  test("getposts test") {
    val id = UUID(1,1)
    val comments = getComments(id)

    comments map {
      comments => for ( c<- comments) assertEquals(c.postId, id)
    }
  }