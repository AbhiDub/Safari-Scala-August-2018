package datestuff

import java.sql.SQLException

import scala.util.{Failure, Success, Try}

object DateStuff {
  def zellers(tuple: (Int, Int, Int)): Int =
    zellers(tuple._1, tuple._2, tuple._3)

  @throws(classOf[SQLException])
  def zellers(day: Int, month: Int, year: Int = 2018): Int = {
    if (day == 99) throw new SQLException("DB crashed!")
    if (day < 1 || day > 31) throw new IllegalArgumentException("Bad day")

//    val m = if (month < 3) month + 12 else month
//    val y = if (month < 3) year - 1 else year

//    val t = if (month < 3) (month + 12, year - 1) else (month, year)
//    val m = t._1
//    val y = t._2

    val (m, y) = if (month < 3) (month + 12, year - 1) else (month, year)
    (day + 13 * (m + 1) / 5 + y + y / 4 - y / 100 + y / 400) % 7
  }

  object DaysOfWeek extends Enumeration {
    val SATURDAY, SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY = Value;
  }

//  def namedDayOfWeek(day: Int, month: Int, year: Int): String =
//    DaysOfWeek(zellers(day, month, year)).toString

  def namedDayOfWeek(d: Int, m: Int, y: Int): String = {
    val dow = zellers(d, m, y)
    dow match {
      case 0 => "Saturday"
      case 1 => "Sunday"
      case 2 => "Monday"
      case 3 => "Tuesday"
      case 4 => "Wednesday"
      case 5 => "Thursday"
      case 6 => "Friday"
//      case _ => "Bad value"
      case x => s"Bad value $x"
    }
  }

  def main(args: Array[String]): Unit = {
//    val today = zellers(15, 8, 2018)
//    val today = zellers(month = 8, day = 15, year = 2018)
    val today = zellers(month = 8, day = 15)
    println(s"today is number $today")
    println(s"Start of 2000 is number ${zellers(1, 1, 2000)}")
    println(s"Start of 2000 is number ${zellers((28, 2, 1999))}")

    val someDates = new Array[(Int, Int, Int)](10)

//    val dates = Array((1, 1, 2000), (3, 1, 2000), (19, 1, 1999))
    val dates = Array.apply((1, 1, 2000), (3, 1, 2000), (19, 1, 1999))
    println(s"There are ${dates.length}")
    println(s"The array is $dates")
    for (d <- dates) println(d)
    var idx = 0;
    while (idx < dates.length) {
//      println(s"> ${dates(idx)}")// shorthand
      println(s"> ${dates.apply(idx)}")  // expanded form
      idx += 1
    }
//    dates(0) = (9, 9, 9999) // shorthand
    dates.update(0, (9, 9, 9999)) // longhand

    println(s"Start of 2000 is number ${namedDayOfWeek(1, 1, 2000)}")

    try {
      val strange = zellers(99, 1, 1000)
      println(s"Day is $strange")
    } catch {
      case x: IllegalArgumentException =>
        println(s"got a problem: ${x.getMessage}")
      case x: SQLException => println("Wait, who opened a database!")
      case x: Throwable => println("Random problem")
    }
    println("Still going...")

    // argument to Try.apply is "pass by name"
    // not evaluated until INSIDE the method.
    val td = Try(zellers(99, 1, 1))
    td match {
      case Success(d) => println(s"The day of week is number $d")
      case Failure(e) => println(s"Got an exception, message is ${e.getMessage}")
    }

  }
}
