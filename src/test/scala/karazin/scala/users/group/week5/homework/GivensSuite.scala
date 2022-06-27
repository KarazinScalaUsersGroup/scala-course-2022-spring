package karazin.scala.users.group.week5.homework

import scala.concurrent.Future

import karazin.scala.users.group.week5.homework.givens.{given, _}

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

  test("Int even") {
    assertEquals(
      JsonStringEncoder[Int]
        .encode(200), "200"
    )
  }

  test("Int odd") {
    assertEquals(
      JsonStringEncoder[Int]
        .encode(117), "117"
    )
  }

  test("Int zero") {
    assertEquals(
      JsonStringEncoder[Int]
        .encode(0), "0"
    )
  }

  test("Int negative") {
    assertEquals(
      JsonStringEncoder[Int]
        .encode(-7), "-7"
    )
  }

  test("Bool false") {
    assertEquals(
      JsonStringEncoder[Boolean]
        .encode(false), "false"
    )
  }

  test("Bool JSON true") {
    assertEquals(
      JsonStringEncoder[Boolean]
        .encode(true), "true"
    )
  }

  test("String") {
    assertEquals(
      JsonStringEncoder[String]
        .encode("Lorem ipsum dolor"), "\"Lorem ipsum dolor\""
    )
  }

  test("String Empty") {
    assertEquals(
      JsonStringEncoder[String]
        .encode(""), "\"\""
    )
  }

  test("List String") {
    assertEquals(
      JsonStringEncoder[List[String]]
        .encode("Lorem" :: "ipsum" :: "dolor" :: Nil), "[\"Lorem\", \"ipsum\", \"dolor\"]"
    )
  }

  test("List Booleans") {
    assertEquals(
      JsonStringEncoder[List[Boolean]]
        .encode(true :: false :: true :: Nil), "[true, false, true]"
    )
  }

  test("List Integers") {
    assertEquals(
      JsonStringEncoder[List[Int]]
        .encode(90 :: -119 :: 0 :: Nil), "[90, -119, 0]"
    )
  }

  test("List Empty") {
    assertEquals(
      JsonStringEncoder[List[Int]]
        .encode(Nil), "[]"
    )
  }

  test("Map fails") {
    compileErrors("JsonStringEncoder[Map[String, Int]].encode(Map(\"x\" -> 100, \"y\" -> -2, \"z\" -> 0))")
  }