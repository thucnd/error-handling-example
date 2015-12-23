import scala.util.{Failure, Success, Try}

object ErrorHandlingExample {
  def stringToInt(str: String): Try[Int] = Try(str.toInt)

  def main(args: Array[String]) = {

    // Return Success
    println(stringToInt("120"))
    // Return Failure
    println(stringToInt("12a"))

    // use Match
    stringToInt("10") match {
      case Success(number) => println(number)
      case Failure(e) => println(e.getMessage)
    }

    // Use map
    stringToInt("100").map(println(_))
    Try(stringToInt("100")).map {
      number =>
        number.map(println(_))
    }

    // Use flat map
    val number = Try(stringToInt("5")).flatMap(Try(_))
    println(number)

    //use for
    val numFor = for {
      num <- stringToInt("13")
    } yield num
    println(numFor)
  }
}

