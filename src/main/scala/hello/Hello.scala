package hello

object Hello {
  def ==> (v: String): Unit = println(s"That thing is $v")

  def sayHello: String = {
    println("Hello")
    "Really, this is returned"
  }
  def sayHello3: Unit = {
    println("Hello")
    ()
  }
  def sayHello2: Unit = println("Hello")

  def main(args: Array[String]): Unit = {
    println("Hello Scala World!")
    val s: String = { //use control-q in intelliJ to see type...
      println("In the expression")
      sayHello
    }
    val t = "Today"
    println(s)
    //    s = "Nope" // val prohibits reassignment (like final)
    //    s = new StringBuilder() // would be illegal even with var, s is String!!!

    Hello.==>("Hello")

    Hello ==> "Hello"

    ==>("Hello")

    println(2.+(99))
    println(2 + 99)

    Console println "More infix form"

    var thing:Any = 99
    thing = "hello"
  }
}
