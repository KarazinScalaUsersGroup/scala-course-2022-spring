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
    
    // Added to make it compilable. Remove it.
    case Value(x: V) extends ErrorOr[V]
    case Error extends ErrorOr[Nothing]

    /* 
      Two case must be defined: 
      * a case for a regular value
      * a case for an error (it should contain an actual throwable)
     */
  
    /* 
      The method is used for defining execution pipelines
      Provide a type parameter, an argument and a result type
      
      Make sure that in case of failing the method with exception
      no exception is thrown but the case for an error is returned
    */ 
    def flatMap[Q](f: V ⇒ ErrorOr[Q]): ErrorOr[Q] =
      this match
        case ErrorOr.Error ⇒ ErrorOr.Error
        case ErrorOr.Value(v)  ⇒ f(v)

    /* 
      The method is used for changing the internal object
      Provide a type parameter, an argument and a result type
      
      Make sure that in case of failing the method with exception
      no exception is thrown but the case for an error is returned
     */
    def map[Q](f: V ⇒ Q): ErrorOr[Q] =
      this match
        case ErrorOr.Error ⇒ ErrorOr.Error
        case ErrorOr.Value(v)  ⇒ ErrorOr.Value(f(v))
      
  // Companion object to define constructor
  object ErrorOr:
    /* 
      Provide a type parameter, an argument and a result type
      
      Make sure that in case of failing the method with exception
      no exception is thrown but the case for an error is returned
    */
    def apply[V](v: V): ErrorOr[V] =
      println(v)
      if v == null then ErrorOr.Error else ErrorOr.Value(v)
      
  
