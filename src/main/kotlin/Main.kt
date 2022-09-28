import io.neowise.rpgengine.RPGEngine
import io.neowise.rpgengine.engine.FrameRate
import javax.swing.JFrame

fun main() {

    val game = RPGEngine(800, 600)
    val frameRate = FrameRate(game)

    val frame = JFrame()
    frame.setSize(800, 600)
    frame.add(game)
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.isVisible = true

    frameRate.start()
}