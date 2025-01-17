package com.madhukaraphatak

import ImplicitParameters.Comparator

object SummonExample {
  def main(args: Array[String]): Unit = {
    trait Ord[T] {
      def compare(x: T, y: T): Int
    }
    class IntOrdering extends Ord[Int] {
      override def compare(x: Int, y: Int): Int = x.compare(y)
    }
    given intOrdering:Ord[Int] = new IntOrdering()

    def maxWithUsing(x:Int,y:Int):Int ={
      //summon the implicit context using surrounding context
      val intOrdering = summon[Ord[Int]]
      if intOrdering.compare(x,y) < 0 then y else x
    }
  }
}
