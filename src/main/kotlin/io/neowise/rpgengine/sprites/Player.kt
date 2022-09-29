package io.neowise.rpgengine.sprites

import io.neowise.rpgengine.Textures
import io.neowise.rpgengine.engine.Configuration
import io.neowise.rpgengine.engine.Context
import io.neowise.rpgengine.engine.components.Bounds
import io.neowise.rpgengine.engine.components.Component
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

    override fun init(context: Context, configuration: Configuration) {
        context.eventEmitter.onKeyEvent {
            val state = it.state == KeyState.PRESSED
            when(it.key) {
                KeyEvent.VK_A -> moveLeft = state
                KeyEvent.VK_D -> moveRight = state
            }
        }
    }

    override fun update(context: Context) {

        val enemy = context.engine.findByName("enemy") as Sprite

        texture = if (!isCollideWith(enemy)) {
            if (moveRight) {
                move(5, 0)
            }
            if (moveLeft) {
                move(-5, 0)
            }
            Textures.rocket
        } else {
            Textures.rocketCollided
        }
    }

    override fun render(configuration: Configuration) {
        texture.draw(configuration.graphics, x, y)
    }
}