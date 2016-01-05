
object OptionScala {

  case class User(email: String, password: String, address: Option[String])

  def main(args: Array[String]) {

    val presentSay: Option[String] = Some("Hello world")
    val absentSay: Option[String] = None

    println(presentSay)
    println(absentSay)

    def say: Option[String] = Option("Hello world") // Some("Hello world")
    def nothingToSay: Option[String] = Option(null) // None

    println(say)
    println(nothingToSay)

    val user1 = User("example1@email.com", "password1", None)
    val user2 = User("example2@email.com", "password2", Some("address information"))

    println(user1.address.getOrElse("not specified"))
    println(user2.address.get)

    val user3: Option[User] = Some(User("email", "password", Some("address")))
    user3 match  {
      case Some(user) => println(user)
      case None => println("Not specified")
    }

    // use Map
    println("use Map:")
    user3.map(println(_))

    // Use Flat Map
    println("use flat map:")
    List(Some(user1), Some(user2), None, None).flatMap(u => u.map(println(_)))

    // user for
    println("user for:")
    val address = for {
      user <- user3
      address <- user.address
    } yield address
    println(address)

    // User filter
    println("filter:")
    val userFilter = List(user1, user2).filter(_.password == "password1")
    println(userFilter)
  }
}

