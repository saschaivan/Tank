package de.htwg.se.Tank.controller.controllerComponent.controllerBaseImpl

import de.htwg.se.Tank.controller.controllerComponent.controllerBaseImpl.controller.Controller
import de.htwg.se.Tank.model.gameComponent.gameBase
import de.htwg.se.Tank.model.gameComponent.gameBase.{Game, Map}
import de.htwg.se.Tank.util.{Observer, UndoManager}
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Matchers, WordSpec}

@RunWith(classOf[JUnitRunner])
class ControllerSpec extends WordSpec with Matchers {
  "A Controller" when {
    "observed by an Observer" should {
      val game = Game("Standard", 2,"small", "Flo", "Sasch")
      val controller = new Controller(game)
      val undoManager = new UndoManager
      val leftCommand = new LeftCommand(controller)
      val rightCommand = new RightCommand(controller)
      val power = Map.getActivePlayer.power
      val observer = new Observer {
        var updated: Boolean = false
        def isUpdated: Boolean = updated
        override def update: Boolean = {updated = true; updated}
      }


      "notify its Observer after creation" in {
        controller.setGame("Standard", 2,"small", "Flo", "Sasch")
        gameBase.Map.p1.name should be ("Flo")
        gameBase.Map.p2.name should be ("Sasch")
      }
      val str : String = controller.gametoString
      "to String" in {
         str should be (str)
      }
      controller.moveLeft()
      "notify its Observer after move left" in {
        undoManager.doStep(leftCommand) should be (undoManager.doStep(leftCommand))
      }
      controller.moveRight()
      "notify its Observer after move right" in {
        undoManager.doStep(rightCommand) should be (undoManager.doStep(rightCommand))
      }
      controller.game.moveAngleUp()
      "have Angled Up" in {
        controller.moveAngleUp() should be (controller.moveAngleUp())
      }
      "have Angled down" in {
        controller.moveAngleDown() should be (controller.moveAngleDown())
      }
      controller.shoot(20)
      "have shot " in {
        controller.game.shoot(20) should be (controller.game.shoot(20))
      }
      "have toString" in {
        controller.toString() should be (controller.toString())
      }
      controller.undo
      "have undo" in {
        controller.undo should be (controller.redo)
      }
      controller.changePlayer()
      "change Player" in {
        controller.changePlayer() should be (controller.changePlayer())
      }

      controller.powerUp()
      "power up" in {
        controller.powerUp()
        Map.getActivePlayer.power should be (power + 1)
      }

      controller.powerUp()
      "power down" in {
        controller.powerDown()
        Map.getActivePlayer.power should be (power)
      }
      "save" in {
        controller.save
        true should be (true)
      }
      "load " in {
        controller.load
        true should be (true)
      }
    }
  }
}
