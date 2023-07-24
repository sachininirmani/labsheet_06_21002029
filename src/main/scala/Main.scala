import scala.io.StdIn
object Main {
  val Letters = 26

  def main(args: Array[String]): Unit = {
    println("Hello user!")
    print("Enter a string to encrypt : ")
    val str = scala.io.StdIn.readLine()
    print("Enter the shift number  : ")
    var key = scala.io.StdIn.readInt()

    if (key < 0 || key > 26) key = key % 26
    else cipher(str, key)

  }

  def encrypt(ch: Char, key: Int): Char = {
    if (ch.isLower) {
      return ((ch - 'a' + (Letters - key)) % Letters + 'a').toChar
    } else {
      return ((ch - 'A' + (Letters - key)) % Letters + 'A').toChar
    }
  }

  def decrypt(ch: Char, key: Int): Char = {
    if (ch.isLower) {
      return ((ch - 'a' + key) % Letters + 'a').toChar
    } else {
      return ((ch - 'A' + key) % Letters + 'A').toChar
    }
  }

  def cipher(str: String, key: Int): Unit = {
    val encrypted = str.map(ch => if (ch.isLetter) encrypt(ch, key) else ch)
    println("Encrypted text : " + encrypted)
    println("Decrypted text : " + encrypted.map(ch => if (ch.isLetter) decrypt(ch, key) else ch))
  }

}