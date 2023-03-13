package u02

object Indentation:

  // idiomatic Scala 3 significant indentation
  val res = 5 match
    case n if n > 0 => "pos"
    case 0 => "zero"

  // indentation with end marker (useful in complicated cases)
  val res2 = 5 match
    case n if n > 0 => "pos"
    case 0 => "zero"
  end res2

  // Java-style curly braces (Scala 2 style)
  val res3 = 5 match {
    case n if n > 0 => "pos"
    case 0 => "zero"
  }

  // Single line curly braces with semi-colon
  val res4 = 5 match { case n if n > 0 => "pos"; case 0 => "zero" }

end Indentation // showcasing end marker for object
