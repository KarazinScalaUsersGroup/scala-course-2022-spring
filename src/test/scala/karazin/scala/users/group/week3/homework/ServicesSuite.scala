package karazin.scala.users.group.week3.homework

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/*
  Write test for all service in karazin.scala.users.group.week3.homework.services

  Review:
    • https://scalameta.org/munit/docs/tests.html
    • https://scalameta.org/munit/docs/assertions.html
 */

class ServicesSuite extends munit.FunSuite:
  
  test("failed async test example") {
    Future {
      assertEquals(42, 43)
    }
  }

  