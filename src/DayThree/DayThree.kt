import kotlin.browser.*
import org.w3c.fetch.*

fun main(args: Array<String>) {
  window.fetch(Request("src/DayThree/input.txt"))
    .then({ res: Response -> res.text() })
    .then({ input: String ->
      val lines = input.lines()
      val rects: MutableList<Rect> = ArrayList()
      lines.forEach { line ->
        val rgx = "([0-9]+),([0-9]+)".toRegex()
        val match = rgx.find(line)
        val xy = match?.groupValues
        val x = xy?.get(1)?.toInt(10)
        val y = xy?.get(2)?.toInt(10)

        val rgx2 = "([0-9]+)x([0-9]+)".toRegex()
        val match2 = rgx2.find(line)
        val wh = match2?.groupValues
        val w = wh?.get(1)?.toInt(10)
        val h = wh?.get(2)?.toInt(10)

        var rect = Rect()
        if (x != null) rect.x = x
        if (y != null) rect.y = y
        if (w != null) rect.w = w
        if (h != null) rect.h = h

        rects.add(rect)
      }

      // WOW. SO INEFFICIENT.
      var overlap: Int = 0
      rects.forEach { a ->
        rects.forEach { b ->
          overlap = overlap.plus(a.intersect(b))
        }
      }
      console.log("diff: " + overlap)
    })
}

class Rect {
  var x: Int = 0
  var y: Int = 0
  var w: Int = 0
  var h: Int = 0

  fun intersect(b: Rect): Int {
    return maxOf(0, minOf((this.w + this.x), (b.w + b.x)) - maxOf(this.x, b.x)) * maxOf(0, minOf((this.h + this.y), (b.h + b.y)) - maxOf(this.y, b.y))
  }
}
