package io.neowise.rpgengine.sprites

import io.neowise.rpgengine.Textures
import io.neowise.rpgengine.engine.Configuration
import io.neowise.rpgengine.engine.Context
import io.neowise.rpgengine.engine.components.Bounds
import io.neowise.rpgengine.engine.components.Sprite
import io.neowise.rpgengine.engine.event.KeyState
import java.awt.event.KeyEvent

class Player: Sprite() {

    override var texture = Textures.rocket

    private val width = 100
    private val height = 200

    override val bounds = object : Bounds {
        override val minX get() = x
        override val minY get() = y
        override val maxX get() = x + width
        override val maxY get() = y + height
    }

    private var moveLeft = false
    private var moveRight = false
    private var moveUp = false
    private var moveDown = false

    private lateinit var enemy: Enemy

    override fun init(context: Context, configuration: Configuration) {

        enemy = context.findByName("enemy")

        context.eventEmitter.onKeyEvent {
            val state = it.state == KeyState.PRESSED
            when(it.key) {
                KeyEvent.VK_A -> moveLeft = state
                KeyEvent.VK_D -> moveRight = state
                KeyEvent.VK_W -> moveUp = state
                KeyEvent.VK_S -> moveDown = state
            }
        }
    }

    override fun update(context: Context) {

        if (moveRight) {
            moveWithCheck(5, 0)
        }

        if (moveLeft) {
            moveWithCheck(-5, 0)
        }

        if (moveUp) {
            moveWithCheck(0, -5)
        }

        if (moveDown) {
            moveWithCheck(0, 5)
        }
    }

    private fun moveWithCheck(x: Int, y: Int) {
        move(x, y)
        texture = if (isCollideWith(enemy)) {
            move(-x, -y)
            Textures.rocketCollided
        }
        else {
            Textures.rocket
        }
    }

    override fun render(configuration: Configuration) {
        texture.draw(configuration.graphics, x, y)
    }
}