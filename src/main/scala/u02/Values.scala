package u02

object Values extends App:

  // values can be associated to names
  // namely, non modifiable variables (of course, there's no side-effects)
  val v = 1

  val w: Int = 1   // types are optional, they are typically always inferred

  println(v) // a procedure to print on console (a hack, not pure FP)

  println("result is " + v) // Java-style concatenation
  println(s"result is $v") // string interpolation, with variable evaluation
  println(s"result is ${v+1}") // string interpolation, with expr. eval.

  // primitive types as expected over the JVM
  val i: Int = 10 + 5 // as in Java, to be read +(10,5)
  val l: Long = 100000000000L // as in Java
  val d: Double = 5.4 * 1.3 // as in Java
  val f: Float = 3.0f // as in Java
  val b: Boolean = true && false // as in Java
  val s: String = "hello" concat " to all" // String methods as operators
  val n: String = null // null can be passed to "objects", sorry

  println(s"$i, $l, $d, $f, $b, $s, $n")
