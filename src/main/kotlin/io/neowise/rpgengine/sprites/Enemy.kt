package io.neowise.rpgengine.sprites

import io.neowise.rpgengine.Textures
import io.neowise.rpgengine.engine.Configuration
import io.neowise.rpgengine.engine.Context
import io.neowise.rpgengine.engine.components.Bounds
import io.neowise.rpgengine.engine.components.Component
import io.neowise.rpgengine.engine.components.Sprite
import io.neowise.rpgengine.engine.event.KeyState
import java.awt.event.KeyEvent

class Enemy(private val _x: Int, private val _y: Int): Sprite("enemy") {

    override var texture = Textures.enemy

    private val width = 100
    private val height = 200

    override val bounds = object : Bounds {
        override val minX get() = x
        override val minY get() = y
        override val maxX get() = x + width
        override val maxY get() = y + height
    }

    override fun init(context: Context, configuration: Configuration) {
        x = _x
        y = _y
    }

    override fun update(context: Context) {
    }

    override fun render(configuration: Configuration) {
        texture.draw(configuration.graphics, x, y)
    }
}