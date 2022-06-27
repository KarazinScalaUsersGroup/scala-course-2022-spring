package karazin.scala.users.group.week4.homework

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ExecutionContext, ExecutionContextExecutorService, Future}
import karazin.scala.users.group.week4.homework.services._
import karazin.scala.users.group.week4.homework.model._
import java.util.UUID
import java.util.concurrent.Executors
import scala.util.{Try,Success,Failure}
/*
  Write test for all service in karazin.scala.users.group.week4.homework.services
  Make sure you control custom execution contexts in tests using `before` and `after` logic
  Review:
    • https://scalameta.org/munit/docs/tests.html
    • https://scalameta.org/munit/docs/assertions.html
    • https://scalameta.org/munit/docs/fixtures.html#ad-hoc-test-local-fixtures
 */

class ServicesSuite extends munit.FunSuite:

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
        threadpool.shutdown()
      }
    }
  override def munitFixtures = List(sigleThreadPoolContext)

  test("getUserProfile test") {
    val getUserProfileService  = getUserProfile()(using sigleThreadPoolContext())
    getUserProfileService map {
      case UserProfile(_) => assert(true)
    } recover {
      case error => fail("Exception")
    }
  }

  test("getPosts test") {
    val userId = UUID.randomUUID()
    val getPostsService = getPosts(userId)(using sigleThreadPoolContext())
    getPostsService map { listPost =>
      assertTestList[Post](listPost) { p =>
        assertEquals(userId, p.userId)
      }
    } recover {
      case error => fail("Exception")
    }
  }

  test("getComments test") {
    val postId = UUID.randomUUID()
    val getCommentsService = getComments(postId)(using sigleThreadPoolContext())
    getCommentsService map { listComments =>
      assertTestList[Comment](listComments) { c =>
        assertEquals(postId, c.postId)
      }
    } recover {
      case error => fail("Exception")
    }
  }

  test("getLikes test") {
    val postId = UUID.randomUUID()
    val getLikesService = getLikes(postId)(using sigleThreadPoolContext())
    getLikesService map { listLikes =>
      assertTestList[Like](listLikes) { l =>
        assertEquals(postId, l.postId)
      }
    } recover {
      case error => fail("Exception")
    }
  }

  test("getShares test") {
    val postId = UUID.randomUUID()
    val getSharesService = getShares(postId)(using sigleThreadPoolContext())
    getSharesService map { listShares  =>
      assertTestList[Share](listShares) { s =>
        assertEquals(postId, s.postId)
      }
    } recover {
      case error => fail("Exception")
    }
  }