package com.utd

/**
  * Created by argoncalves on 12/2/15.
  */

object TriangleType extends Enumeration {
  type TriangleType = Value
  val Equilateral, Isosceles,  Scalene = Value
}

object Detector {

  import TriangleType._

  def apply(a: Long, b: Long, c: Long): TriangleType = {
    assertValid(a, b, c)
    if(a == b && b == c) return Equilateral
    if(a == b || b == c || a == c) return Isosceles
    Scalene
  }

  private def assertValid(a: Long, b: Long, c: Long) = {
    require(
      a > 0 && b > 0 && c > 0 && (a <= b + c && b <= a + c && c <= a + b),
      s"$a, $b and $c are not valid triangle sides"
    )
  }
}
