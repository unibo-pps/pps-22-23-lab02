package u02

object DefinedFunctions extends App:

  // defined function
  def square(d: Double): Double = d * d

  println(square(3.0)) // 9.0

  // mostly equivalent code with a val
  val square2: Double => Double = d => d * d
  println(square2(3.0)) // 9.0

  // defined function, using pattern matching, with recursion
  def factorial(n: Int): Int = n match
    case 0 | 1 => 1 // 0 or 1 gets mapped to 1
    case _ => n * factorial(n - 1) // otherwise

  println(factorial(6)) // 720

  // nested function, note indentation
  def abs(n: Int): Int =
    def sign(m: Int): Int = m match
      case i if i > 0 => 1
      case 0 => 0;
      case _ => -1

    n * sign(n)

  println(s"${abs(-2)}, ${abs(2)}, ${abs(0)}") // 2,2,0

  // tail recursion check, as a nested function
  def factorial2(n: Int): Int =
    @annotation.tailrec // checks only if optimisation is possible
    def _fact(n: Int, acc: Int): Int = n match
      case 0 | 1 => acc
      case _ => _fact(n - 1, n * acc)

    _fact(n, 1)

  println(factorial2(6)) // 720
