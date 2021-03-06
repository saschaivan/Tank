package de.htwg.se.Tank.model.gameComponent.gameBase

import de.htwg.se.Tank.controller.controllerComponent.controllerBaseImpl.controller.Controller
import de.htwg.se.Tank.model.gameComponent.gameBase
import de.htwg.se.Tank.model.gameComponent.gameBase.{Game, GameInit,Map}
import de.htwg.se.Tank.model.playerComponent.playerBase.Position
import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MapSpec extends WordSpec with Matchers {
  private val x = 100
  private val y = 100
  private val x1 = 20
  private val y1 = 10
  var fx: Double => Double = (x:Double) => 5*x
  val game = Game("Standard", 2,"small", "Flo", "Sasch")
  val controller = new Controller(game)
  
  "A Map" when { "new" should {
      Map.StateContext.P2State().setPlayer()
      "set Player2" in {
        Map.activePlayer should be (Map.activePlayer)
        Map.StateContext.state should be (Map.StateContext.P1State())
      }
      "have beginOfMap x" in {
        Map.beginOfMap._1 should be(GameInit.MAP_X1)
      }
      "have beginOfMap y" in {
        Map.beginOfMap._2 should be(GameInit.MAP_Y1)
      }
      "have endOfMap x" in {
        Map.endOfMap._1 should be(100)
      }
      "have endOfMap y" in {
        Map.endOfMap._2 should be(Map.endOfMap._2)
      }
      "have f(x)" in {
        fx(2) should be (10)
      }
    Map.setFX(Option(0))
    "have no Pos in Map" in {
      Map.posInMap(Position(-1,0)) should be (false)
    }
    "have Number of moves" in {
      Map.moves should be (Map.moves)
    }
    }
  }
}



