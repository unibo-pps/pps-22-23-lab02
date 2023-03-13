package u02

object CaseMatch extends App:
  // matching against patterns
  val v = 5
  val res = v match
    case n if n > 0 => "pos"
    case 0 => "zero"
    case _ => "neg" // default case, makes it a total function
  println(res) // "pos"

  // case-based function (a partial function in this case)
  val f: Int => String = _ match
    case n if n > 0 => "pos"
    case 0 => "zero"

  println(f(1)) // pos
  println(f(0)) // zero
  // f(-1) raises a scala.MatchError

  val g: Int => String = { case n if n > 0 => "pos" } // 1-liner
  println(g(1)) // pos
// g(0) raises a scala.MatchError
