package com.utd

/**
  * Created by argoncalves on 12/2/15.
  */
object Detector {

  def apply(a: Long, b: Long, c: Long) = {
    require(a <= b + c && b <= a + c && c <= a + b, s"$a, $b and $c are not valid triangle sides")
  }
}
