package io.neowise.rpgengine.engine.components

import io.neowise.rpgengine.engine.Configuration
import io.neowise.rpgengine.engine.texture.Texture
import io.neowise.rpgengine.util.isCollisionDetected

abstract class Sprite(
    override var name: String = "sprite",
    var x: Int = 0,
    var y: Int = 0
) : Component() {

    protected abstract val texture: Texture

    protected abstract val bounds: Bounds

    fun translate(x: Int, y: Int) {
        this.x = x
        this.y = y
    }

    fun move(x: Int, y: Int) {
        this.x += x
        this.y += y
    }

    override fun render(configuration: Configuration) {
        texture.draw(configuration.graphics, x, y)
    }

    fun isCollideWith(other: Sprite): Boolean {
        val b1 = bounds
        val b2 = other.bounds

        return isCollisionDetected(b1, b2)
    }
}