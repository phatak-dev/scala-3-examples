package com.madhukaraphatak


object SummonExample {
  trait Ord[T] {
    def compare(x: T, y: T): Int
  }

  class IntOrdering extends Ord[Int] {
    override def compare(x: Int, y: Int): Int = x.compare(y)
  }

  def main(args: Array[String]): Unit = {
    given intOrdering: Ord[Int] = new IntOrdering()

    def maxWithImplicitParameter(x: Int, y: Int)(implicit intOrdering: Ord[Int]): Int = {
      if (intOrdering.compare(x, y) < 0)   y else x
    }
    println(maxWithImplicitParameter(10,20))
    //Scala 3.x
    def maxWithSummon(x: Int, y: Int): Int = {
      //summon the implicit context using surrounding context
      val intOrdering = summon[Ord[Int]]
      if intOrdering.compare(x, y) < 0 then y else x
    }
    println(maxWithSummon(10,20))
  }
}
