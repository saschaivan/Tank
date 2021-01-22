package de.htwg.se.Tank.model.gameComponent.gameBase

import de.htwg.se.Tank.controller.controllerComponent.controllerBaseImpl.controller.Controller
import de.htwg.se.Tank.model.gameComponent.gameBase.{Calc, Game, GameInit, Map}
import de.htwg.se.Tank.model.playerComponent.playerBase.{Player, Position}
import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CalcSpec extends WordSpec with Matchers {
  private val lp = 100
  val game = Game("Standard", 2,"small", "Flo", "Sasch")
  val controller = new Controller(game)
  "Calculation" when {
    "shootCalc" should {
      "G" in {
        Calc.G should be(9.81)
      }
    }
  }
}
