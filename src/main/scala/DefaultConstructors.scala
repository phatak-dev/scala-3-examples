package com.madhukaraphatak

object DefaultConstructors {

  case class PersonCaseClass(name:String, age:Int)
  class PersonClass(name:String, age:Int) {
    def getName = name
  }

  def main(args: Array[String]): Unit = {
   //scala 2
   val person1 = PersonCaseClass("Raj",25)
   val person2 = new PersonClass("Raj",25)

   //scala3
   val person3 = PersonCaseClass("Raj",25)
   val person4 = PersonClass("Raj",25)

   println(person4.getName)

  }

}
