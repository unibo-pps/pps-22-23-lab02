package u02

object AnonymousFunctions extends App:

  // first-class, anonymous functions (lambdas) with various syntax
  val f1 = (x: Int, y: Int) => x + y
  val f2: (Int, Int) => Int = (x: Int, y: Int) => x + y
  val f3: (Int, Int) => Int = (x, y) => x + y
  val f4: (Int, Int) => Int = _ + _
  val f5: (Int, Int) => Int = f4
  // val f6 = _ + _ // won't type-check

  println(s"${f1(10, 5)}, ${f4(10, 5)}") // (15,15)

  val g: Int => Int =
    (x: Int) => // a lambda with an imperative body
      println("hello") // note "significant indentation"
      x + 1 // last statement is a return

  println(g(10)) // hello \n 11

  // higher-order functions are smoothly handled
  val h: (Int, Int, (Int, Int) => Int) => Int =
    (a, b, f) => f(a, b)

  println(h(10, 5, _ * _)) // 50
  println(h(10, 5, (a, b) => a + b)) // 15
  println(h(10, 5, f1)) // 15

  val i: (Int, Int => Int, Int => Int) => Int =
    (n, f1, f2) => f1(f2(n))

  println(i(10, _ + 1, _ * 2)) // 21

  val l: (Int => Int) => (Int => Int) =
    f => (i => f(f(i))) // f => i => f(f(i))

  println(l(_ + 1)(10)) // 12, see currying next..
