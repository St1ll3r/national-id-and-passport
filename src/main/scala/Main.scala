import scala.annotation.tailrec

object Main extends App {
  class NationalIDCard(var cardID: Int, var firstname: String, var lastname: String, var dob: String, var address: String)
  class Passport(var cardID: Int, var firstname: String, var lastname: String, var dob: String, var address: String)

  var nationalIDCards = Array.empty[NationalIDCard]

  @tailrec
  def createNewNationalIDCard(): Unit = {
    try {
      val firstname = scala.io.StdIn.readLine("What's the citizen's first name?\n")
      val lastname = scala.io.StdIn.readLine("What's the citizen's last name?\n")
      val dob = scala.io.StdIn.readLine("What's the citizen's date of birth?\n")
      val address = scala.io.StdIn.readLine("What's the citizen's address?\n")
      val newNationalIDCard = new NationalIDCard(nationalIDCards.length+1, firstname, lastname, dob, address) //create new citizen
      nationalIDCards = nationalIDCards :+ newNationalIDCard //add to array
      //show result
      println("\nHere's what has been registered:\n\n" +
        "Citizen ID: " + newNationalIDCard.cardID + "\n" +
        "Citizen's First Name: " + newNationalIDCard.firstname + "\n" +
        "Citizen's Last Name: " + newNationalIDCard.lastname + "\n" +
        "Citizen's Date of Birth: " + newNationalIDCard.dob + "\n" +
        "Citizen's Address: " + newNationalIDCard.address + "\n")
      init()
    } catch {
      case _: NumberFormatException =>
        println("That's not a valid value for this field, try again")
        createNewNationalIDCard()
    }
  }

  def serveUserOption(option: Int): Unit = {
    option match {
      case 1 =>
        createNewNationalIDCard()
        init()
      case 10 =>
        println("Thanks for using the program")
      case _ => println("Please type a number from 1 to 10")
    }
  }

  @tailrec
  def getUserMenuInput(): Unit = {
    try {
      val answer = scala.io.StdIn.readInt()
      serveUserOption(answer)
    } catch {
      case _: NumberFormatException =>
        println("That's not a number, try again")
        getUserMenuInput()
    }
  }

  def showMenu(): Unit = {
    println("Hello, welcome to the national ID card and passport department. What would you like to do today\n" +
      "1 - Create a new citizen National ID Card\n" +
      "2 - Create a new citizen Passport\n" +
      "3 - Get a list of all the citizens with a National ID Card\n" +
      "4 - Get a list of all the citizens with a Passport\n" +
      "5 - Edit citizen National ID Card details\n" +
      "6 - Edit citizen Passport details\n" +
      "7 - Remove a National ID Card from the system\n" +
      "8 - Remove a Passport from the system\n" +
      "10 - Quit")
  }
  def init(): Unit = {
    showMenu()
    getUserMenuInput()
  }
  init()
}