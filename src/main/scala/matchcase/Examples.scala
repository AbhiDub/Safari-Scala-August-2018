package matchcase

case class MyDate(day: Int, month: Int, year: Int)

object Examples {
  def main(args: Array[String]): Unit = {
    val v: Any = MyDate(1, 2, 2000)

    val res = v match {
      case "hello" => {println("matched hello"); "Bonjour"}
      // type-constrained matches avoid "instanceof / casting"
      case x: String => {println(s"No idea what $x is!"); "UNKNOWN"}
      case 99 => "NINETY NINE, my favorite ice cream"
      case x: Int if x < 99 => "BORING number..."
      case x: Int => "BIG Exciting number"
      case MyDate(d, m, y) if y > 2000 => s"It's a date in a new millenium $d / $m / $y"
      case MyDate(d, 1, y)=> s"It's a january in old millenium"
      case MyDate(d, m, _) => s"It's a date in old millenium $d / $m"
      case x => {println(s"what type is $x??"); "No clue!"}
    }

    println(res)
  }
}
