package io.neowise.rpgengine.sprites

import io.neowise.rpgengine.Textures
import io.neowise.rpgengine.engine.Configuration
import io.neowise.rpgengine.engine.Context
import io.neowise.rpgengine.engine.components.Component

class Player(
    override val name: String,
    var x: Int,
    var y: Int
    ) : Component {

    private val texture = Textures.rocket

    override fun init(context: Context, configuration: Configuration) {
        println("INITIALIZE: Player[${name}]")
    }

    override fun update(context: Context) {
        x += 1
    }

    override fun render(configuration: Configuration) {
        texture.draw(configuration.graphics, x, y)
    }
}