package karazin.scala.users.group.week5.homework

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
    Make sure that integers, booleans, strings and lists 
    are convertable to a json string representation 
  */ 