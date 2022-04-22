package karazin.scala.users.group.week2.and.three.quarters.homework

/* 
  Custom implementation of Option (Maybe monad in Haskell)
  Implemented via Scala 3 way for Algebraic Data Types (ADT)
  
  Optional task:
  In addition to 
  ```
    ErrorOr.fromTry(
      Try {
        bla-bla-bla
      }
    )
  ```
  Make 
  ```
    Try {
      bla-bla-bla
    }.toErrorOr
  ```
  also available.
  NB: Don't forget about type parameters.

  
  Resources:
  * https://en.wikipedia.org/wiki/Algebraic_data_type
  * https://docs.scala-lang.org/scala3/book/types-adts-gadts.html
*/

object adt:
  
  enum ErrorOr[+V]:
    
    // Added to make it compilable. Remove it.
    case DummyCase
    
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
    def flatMap = ???

    /* 
      The method is used for changing the internal object
      Provide a type parameter, an argument and a result type
      
      Make sure that in case of failing the method with exception
      no exception is thrown but the case for an error is returned
     */
    def map = ???
  
    /* 
      The method is used for filtering
      Provide a type parameter, an argument and a result type
      
      Make sure that in case of failing the method with exception
      no exception is thrown but the case for an error is returned
     */
    def withFilter = ???
  
    /* 
      The method is used for getting rid of internal box
      Provide a type parameter, an argument and a result type
    */
    def flatten = ???
    
    /* 
      The method is used for applying side effects without returning any result
      Provide a type parameter, an argument and a result type
    */
    def foreach = ???
      
  // Companion object to define constructor
  object ErrorOr:
    /* 
      Provide a type parameter, an argument and a result type
      
      Make sure that in case of failing the method with exception
      no exception is thrown but the case for an error is returned
    */
    def apply = ???

    /*
      The method is used for creating `ErroOr` instance from `Try`
      Provide a type parameter, an argument and a result type
    */
    def fromTry = ???
      
  