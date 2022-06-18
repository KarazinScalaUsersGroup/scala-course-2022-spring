package karazin.scala.users.group.week3.homework

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import java.util.UUID

import program._
import model._
/*
  Write test for all programs in karazin.scala.users.group.week3.homework.program

  Review:
    • https://scalameta.org/munit/docs/tests.html
    • https://scalameta.org/munit/docs/assertions.html
 */

class ProgramSuite extends munit.FunSuite:
  
  test("successful async test example") {
    val id = UUID.randomUUID;
    getPostView(Post(id,id)) map {view => assertEquals(view.post, Post(id, id))}
    
  }
