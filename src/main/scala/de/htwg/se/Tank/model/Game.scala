package de.htwg.se.Tank.model

case class Game(partyname :String, map: Int, name1: String,name2: String){
  override def toString: String = {
    var name = "\n" + "partyname: " + partyname + "\n"
    name += mapObject.toString
    name
  }
  final val MAP_X = 100
  final val MAP_Y = 20

  var mapObject = Map((0,0), (MAP_X,MAP_Y), map, name1, name2)

//  def setMap(map :Map)  : Game = {
//    null tests
//  }
}
