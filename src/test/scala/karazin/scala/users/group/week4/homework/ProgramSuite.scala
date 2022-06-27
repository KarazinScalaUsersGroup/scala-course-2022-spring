package karazin.scala.users.group.week4.homework

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

import karazin.scala.users.group.week4.homework.model._
import karazin.scala.users.group.week4.homework.program._
import karazin.scala.users.group.week4.homework.services._

import java.util.UUID
import java.util.concurrent.Executors
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ExecutionContext, ExecutionContextExecutorService, Future}
import scala.util.{Try,Success,Failure}

/*
  Write test for all programs in karazin.scala.users.group.week4.homework.program
  Make sure you control custom execution contexts in tests using `before` and `after` logic
  Review:
    • https://scalameta.org/munit/docs/tests.html
    • https://scalameta.org/munit/docs/assertions.html
    • https://scalameta.org/munit/docs/fixtures.html#ad-hoc-test-local-fixtures
 */

class ProgramSuite extends munit.FunSuite:

  def assertTestList[V](list: List[V])(f: V => Unit) =
    list foreach f

  val sigleThreadPoolContext =
    new Fixture[ExecutionContext]("files") {
      var threadpool: ExecutionContextExecutorService = null
      def apply() = threadpool
      override def beforeEach(context: BeforeEach): Unit = {
        threadpool = ExecutionContext.fromExecutorService(Executors.newSingleThreadExecutor)
      }
      override def afterEach(context: AfterEach): Unit = {
        // Always gets called, even if test failed.
        threadpool.shutdown()
      }
    }
  override def munitFixtures = List(sigleThreadPoolContext)

  test("getPostView test") {
    val post = Post(UUID.randomUUID(), UUID.randomUUID())
    val getPostViewService  = getPostView(post)(using sigleThreadPoolContext())
    getPostViewService map { res => res match
      case PostView(post_, _, _, _) => assertEquals(post_.postId, post.postId); assertEquals(post_.userId, post.userId);
    } recover {
      case error => fail("Exception")
    }
  }

  test("getPostViews test") {
    val getPostsViewService  = getPostsViews()(using sigleThreadPoolContext())
    getPostsViewService map { list =>
      assertTestList[PostView](list) { p => assert(true)}
    } recover {
      case error => fail("Exception")
    }
  }