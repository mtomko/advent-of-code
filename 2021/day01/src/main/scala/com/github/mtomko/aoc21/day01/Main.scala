package com.github.mtomko.aoc21.day01

import cats.effect.{IO, IOApp}
import fs2.text
import fs2.io.stdin

object Main extends IOApp.Simple {

  def run: IO[Unit] = {
    stdin[IO](4096)
      .through(text.utf8.decode)
      .through(text.lines)
      .map(_.toIntOption)
      .unNone
      // comment out the sliding(3) and subsequent map for the first part
      .sliding(3)
      .map { 
        _.toList match {
          case a :: b :: c :: Nil => a + b + c
          case _ => 0
        }
      }
      .sliding(2)
      .foldMap {
        _.toList match {
          case a :: b :: Nil if a < b => 1
          case _ => 0
        }
      }
      .evalMap(IO.println)
      .compile
      .drain
  }

}
