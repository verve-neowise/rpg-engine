import io.neowise.rpgengine.JFrameEventEmitter
import io.neowise.rpgengine.RPGEngine
import io.neowise.rpgengine.engine.FrameRate
import javax.swing.JFrame

fun main() {

    val eventEmitter = JFrameEventEmitter()
    val game = RPGEngine(800, 600, eventEmitter)
    val frameRate = FrameRate(game)

    val frame = JFrame()
    frame.setSize(800, 600)
    frame.addKeyListener(eventEmitter)
    frame.add(game)
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.isVisible = true

    frameRate.start()
}