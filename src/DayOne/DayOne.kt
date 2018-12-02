import kotlin.browser.*
import org.w3c.fetch.*

fun main(args: Array<String>) {
  window.fetch(Request("src/DayOne/input.txt"))
    .then({ res: Response -> res.text() })
    .then({ input: String ->
      val lines = input.lines()
      var total: Int = 0
      val seen: MutableList<Int> = ArrayList()
      lines.forEach {
        val sign = it.substring(0, 1)
        if (sign == "") {
          return@forEach
        } else if (sign == "-") {
          total = total.minus(it.substring(1).toInt(10))
        } else {
          total = total.plus(it.substring(1).toInt(10))
        }
        /*
        // Meh. Doesnt work for some reason.
        val before = seen.find { it == total }
        println("before: " + before)
        */
        seen.add(total)
      }
      println("total: " + total)
    })
}
