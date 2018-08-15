package usinglists

object Example {
  def printAll(l: List[_]): Unit = l match {
//    case List(a, b) => println(s"List with two elements $a and $b")
//    case List() => println("End of list")
    case Nil => println("End of list")
    case head :: tail => println(s"Element is $head"); printAll(tail)
  }

  def ex2(l: List[_]): Unit = l match {
    case x: List[_] if x.length > 3 => println("It's a long List")
    case x => println(s"It's a short List $x")
  }
  def main(args: Array[String]): Unit = {
    val names = List[String]("Fred", "Jim", "Sheila"/*, 99*/)
    println(s"head is ${names.head}")
    println(s"tail is ${names.tail}")
    println(s"head of tail is ${names.tail.head}")
    println(s"tail of tail of tail is ${names.tail.tail.tail}")

//    val moreNames = names.::("Alan") // "prepend Alan, create new list"
    val moreNames = "Joe" :: "Alan" :: names// "prepend Alan, create new list"
    println(moreNames)
    println("------------------------------")
    println(names)

    for (name <- moreNames) println(s"Dear $name please buy my product")

    printAll(names)
    ex2(names)
    ex2(moreNames)

//    val xl = "Fred" :: "Jim" :: Nil // this works
//    val xl = "Fred" :: "Jim"        // this doesn't because it's equivalent to
//             "Jim".::("Fred")       // :: is a List method, NOT a String method
//    Identifiers that have a colon on the RIGHT are RIGHT-ASSOCIATIVE when
//    used in "infix" format
  }
}
