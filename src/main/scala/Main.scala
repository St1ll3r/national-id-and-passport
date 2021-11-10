import scala.annotation.tailrec

object Main extends App {
  class NationalIDCard(var cardID: Int, var firstname: String, var lastname: String, var dob: String, var address: String)
  class Passport(var cardID: Int, var firstname: String, var lastname: String, var dob: String, var address: String)

  var nationalIDCard = new NationalIDCard(0, "John", "Doe", "20/04/2020", "Atlantic Avenue")
  var nationalIDCards = Array(nationalIDCard)

  @tailrec
  def createNewNationalIDCard(): Unit = {
    try {
      val firstname = scala.io.StdIn.readLine("What's the citizen's first name?")
      val lastname = scala.io.StdIn.readLine("What's the citizen's last name?")
      val dob = scala.io.StdIn.readLine("What's the citizen's date of birth?")
      val address = scala.io.StdIn.readLine("What's the citizen's address?")
      nationalIDCard = new NationalIDCard(nationalIDCards.length+1, firstname, lastname, dob, address)
      nationalIDCards = nationalIDCards :+ nationalIDCard
      println(nationalIDCard.cardID, nationalIDCard.firstname, nationalIDCard.lastname, nationalIDCard.dob, nationalIDCard.address)
    } catch {
      case _: NumberFormatException =>
        println("That's not a valid value for this field, try again")
        createNewNationalIDCard()
    }
  }
  createNewNationalIDCard()
}