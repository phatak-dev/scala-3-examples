package com.madhukaraphatak

object ImplicitParameters {
   //scala 2
   trait Comparator[T] {
     def compare(x:T,y:T):Int
   }
   def max[T](x:T, y:T)(implicit comparator: Comparator[T]):T ={
     if comparator.compare(x,y) <0 then y else x
   }
   //scala 3
   def maxWithUsing[T](x:T,y:T)(using comparator: Comparator[T]):T = {
    if comparator.compare(x,y) <0 then y else x
  }

  def main(args: Array[String]): Unit = {
      //scala 2
      class IntComparator extends Comparator[Int] {
        override def compare(x: Int, y: Int): Int = x.compare(y)
      }
      implicit val intComparator = new IntComparator()
      println(max(10,20))

    //scala3
    given intComparatorWithGiven:Comparator[Int] = IntComparator()
    println(maxWithUsing(10,20))
  }

}
