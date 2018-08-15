package functionalstyle

object Example {
  def showAllList(l: List[String]) : Unit = l match {
    case Nil => ()
    case h :: t => println(h.toUpperCase); showAllList(t)
  }

  def forAllInList(l: List[String])(implicit op: String => Unit) : Unit = l match {
    case Nil => ()
//    case h :: t => op(h); forAllInList(t, op)
    case h :: t => op(h); forAllInList(t)
  }

  def printInUpperCase(s: String): Unit = println(s.toUpperCase)

  def main(args: Array[String]): Unit = {
    val l = List("Fred", "Jim", "Sheila")
    forAllInList(l)(printInUpperCase)
    implicit val doStuff: String => Unit =
      (s: String) => {println(s.toLowerCase)}
    forAllInList(l)
    println("-------------")
    forAllInList(l)((s) => {println(s.toLowerCase)})
    println("-------------")
    forAllInList(l)(s => println(s.toLowerCase))
    println("-------------")
    forAllInList(l)(println(_))
    println("-------------")
    l.foreach(println)
    println("-------------")
    l foreach println
    println("-------------")
    l.map(_.toUpperCase).foreach(println)
    println("-------------")
    l
      .filter(_.length < 6)
      .map(_.toLowerCase)
      .foreach(println)

    println("-------------")
    val lt = List(
      (98, List("Fred", "Alan", "Bill")),
      (32, List("Jim", "Joe")),
      (13, List("Sheila", "John", "Mary")))

    lt.foreach(println)
    lt.map(x => (x._2(0), x._1))
      .foreach(x => println(s"${x._1} went to ${x._2} concerts"))

    println("-------------")
    val all = lt.flatMap(x => x._2)
    all.foreach(println)
  }
}
