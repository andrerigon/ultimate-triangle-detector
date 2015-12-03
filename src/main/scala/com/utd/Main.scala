package com.utd

import scala.util.Try

/**
  * Created by argoncalves on 12/2/15.
  */
object Main extends App {

  val results = io.Source.stdin.getLines().map(_.split(" ").map(_.toLong).toList match {
      case x :: y :: z :: Nil => Detector(x, y, z)
      case _ => throw new IllegalArgumentException("Missing triangle sides")
    })
  results.foreach(println)
}
