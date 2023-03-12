package u02

object ProductTypes extends App:

  // Product types, aka, records
  case class Point2D(x: Double, y: Double)

  println(Point2D(10, 20)) // Point2D(10.0,20.0)

  // using matching to declaratively create method body
  def rotate(p: Point2D): Point2D = p match
    case Point2D(x, y) => Point2D(y, -x)

  // matching over couples
  def sum(p1: Point2D, p2: Point2D): Point2D = (p1, p2) match
    case (Point2D(x1, y1), Point2D(x2, y2)) => Point2D(x1 + x2, y1 + y2)

  // partial matching
  def getX(p: Point2D): Double = p match
    case (Point2D(x, _)) => x

  // a fluent setter that creates a new record..
  def chgX(p: Point2D, x: Double): Point2D = p match
    case (Point2D(_, y)) => Point2D(x, y)

  println(rotate(Point2D(10, 20))) // Point2D(20.0,-10.0)
  println(sum(Point2D(10, 20), Point2D(3, 4))) // Point2D(13.0,24.0)
  println(getX(Point2D(10, 20))) // 10
  println(chgX(Point2D(10, 20), 11)) // Point2D(11,20)
