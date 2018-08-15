package datestuff

object DateStuff {
  def zellers(tuple: (Int, Int, Int)): Int =
    zellers(tuple._1, tuple._2, tuple._3)

  def zellers(day: Int, month: Int, year: Int = 2018): Int = {
//    val m = if (month < 3) month + 12 else month
//    val y = if (month < 3) year - 1 else year

//    val t = if (month < 3) (month + 12, year - 1) else (month, year)
//    val m = t._1
//    val y = t._2

    val (m, y) = if (month < 3) (month + 12, year - 1) else (month, year)
    (day + 13 * (m + 1) / 5 + y + y / 4 - y / 100 + y / 400) % 7
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
    }
//    dates(0) = (9, 9, 9999) // shorthand
    dates.update(0, (9, 9, 9999)) // longhand
  }
}
