package karazin.scala.users.group.week6.homework

object givens:
  
  /* 
    The trait is used for converting instances to a json string representation
    Provide a type parameter(s) for the trait and the method 
    and argument(s) and a result type
  */ 
  
  trait DummyType
  
  trait JsonStringEncoder:
    def encode: DummyType

  /* 
    Enrich the previous solution and
    * make Map[String, V] convertable to json
    * make sure that all previous converions and a new one
      could be done by calling methos `toJsonString` directly 
      on the target object
      
    Add tests for all cases  
  */ 