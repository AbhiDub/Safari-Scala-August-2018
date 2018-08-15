package mydatepackage

object Date {
  def apply(d: Int, m: Int, y: Int): Date =
    new Date(d, m, y)
}

class Date private (/*private */val day: Int, val month: Int, val year: Int) {
  println("constructor finished")
  def this(d: Int, m: Int) = this(d, m, 2018)
  override def toString: String = s"Date with $day, $month, ${this.year}"
}

class Holiday(day: Int, month: Int, val name: String)
  extends Date(day, month) {
  override def toString: String = super.toString + " a holiday called " + name
}

//class Date(d: Int, m: Int, y: Int) {
////  var day: Int = _
//  println(s"In constructor d is $d")
//  val day = d
//  val month = m
//  val year = y
//
//  println("constructor finished")
//
//  override def toString: String = s"Date with $day, $month, ${this.year}"
//}
//
object TryMyDate {
  def main(args: Array[String]): Unit = {
//    val d1 = new Date(3, 4, 1995)
    val d1: Date = new Holiday(3, 4, "May the forth be with you")
    println(s"Day is ${d1.day}")
    println(s" day represents as $d1")

    val d2 = new Date(1, 1)
    println(d2)

    val d3 = Date(1, 1, 1999)
  }
}
