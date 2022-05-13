package karazin.scala.users.group.week5.homework

import scala.concurrent.Future

/*
  Write test for all programs in karazin.scala.users.group.week4.homework.givens

  Make sure that the following cases are tested:
    • json string representation for integers works
    • json string representation for booleans works
    • json string representation for strings works
    • json string representation for lists for integers, booleans and strings works
    • json string representation for maps fails on compile time

  Review:
    • https://www.json.org/json-en.html
    • https://scalameta.org/munit/docs/tests.html
    • https://scalameta.org/munit/docs/assertions.html
    • https://scalameta.org/munit/docs/assertions.html#compileerrors
    
  NB: Do not use sync, this homework does not belong async stuff
    
 */
class GivensSuite extends munit.FunSuite:
  
  test("successful test example") {
    assertEquals(42, 42)
  }