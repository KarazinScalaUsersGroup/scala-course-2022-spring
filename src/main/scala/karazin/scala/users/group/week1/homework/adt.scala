package karazin.scala.users.group.week1.homework

/* 
  Custom implementation of Option (Maybe monad in Haskell)
  Implemented via Scala 3 way for Algebraic Data Types (ADT)
  
  Resources:
  * https://en.wikipedia.org/wiki/Algebraic_data_type
  * https://docs.scala-lang.org/scala3/book/types-adts-gadts.html
*/

object adt:
  
  enum ErrorOr[+V]:
    
    /*
      Two case must be defined:
      * a case for a regular value
      * a case for an error (it should contain an actual throwable)
     */
    case Some(x: V) extends ErrorOr[V]

    case Error(ex: Throwable) extends ErrorOr[V]

    /*
      The method is used for defining execution pipelines
      Provide a type parameter, an argument and a result type

      Make sure that in case of failing the method with exception
      no exception is thrown but the case for an error is returned
    */
    def flatMap[Q](target_func: V => ErrorOr[Q]): ErrorOr[Q] = this match {

        // if already is an error
        case ErrorOr.Error(exception) => ErrorOr.Error(exception)

        // if contains value -> try to apply function
        case ErrorOr.Some(value) => try target_func(value) catch {
          case exception: Throwable => ErrorOr.Error(exception)
       }
     }
    /*
      The method is used for changing the internal object
      Provide a type parameter, an argument and a result type

      Make sure that in case of failing the method with exception
      no exception is thrown but the case for an error is returned
     */
    def map[Q](f: V => Q): ErrorOr[Q] = this match {

      // if already is an error
      case ErrorOr.Error(ex) => ErrorOr.Error(ex)

      // try to wrap function result
      case ErrorOr.Some(value) => try ErrorOr.Some(f(value)) catch {
        case exception: Throwable => ErrorOr.Error(exception)
      }
    }

  // Companion object to define constructor
  object ErrorOr:
    /*
      Provide a type parameter, an argument and a result type

      Make sure that in case of failing the method with exception
      no exception is thrown but the case for an error is returned
    */
    def apply[V](v: V): ErrorOr[V] = v match {
      // can not wrap null object
      case null => ErrorOr.Error(NullPointerException("Null Argument"))

      // return wrapped value
      case _ => ErrorOr.Some(v)
    }