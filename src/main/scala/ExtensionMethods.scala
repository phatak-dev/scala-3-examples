package com.madhukaraphatak

object ExtensionMethods {
   case class Circle(x:Double, y:Double, radius:Double)

  def main(args: Array[String]): Unit = {
    //scala 2
    class Extensions(circle: Circle) {
      def circumference:Double = circle.radius * math.Pi *2
    }
    object Extensions {
      implicit def addExtension(c: Circle):Extensions = new Extensions(c)
    }
    import Extensions._

    val circle = Circle(0,0,50)
    println(circle.circumference)

    //scala 3
    extension (circle:Circle) {
      def circumferenceExtension: Double = circle.radius * math.Pi * 2
    }
    val secondCircle = Circle(0, 0, 50)
    println(secondCircle.circumferenceExtension)

  }

}
