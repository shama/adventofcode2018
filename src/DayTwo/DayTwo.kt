import kotlin.browser.*
import org.w3c.fetch.*

fun main(args: Array<String>) {
  window.fetch(Request("src/DayTwo/input.txt"))
    .then({ res: Response -> res.text() })
    .then({ input: String ->
      val lines = input.lines()
      var twos = 0
      var threes = 0
      lines.forEach { line ->
        val chars = line.split("")
        var hasTwo = false
        var hasThree = false
        chars.forEach { c ->
          if (c == "") return@forEach
          val count = chars.filter { it == c }.count()
          if (count == 2) hasTwo = true
          if (count == 3) hasThree = true
        }
        if (hasTwo) twos++
        if (hasThree) threes++
      }
      println("twos: " + twos)
      println("threes: " + threes)
      println("checksum: " + twos * threes)
    })
}
