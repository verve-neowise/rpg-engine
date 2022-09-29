package io.neowise.rpgengine.backgrounds

import io.neowise.rpgengine.engine.Configuration
import io.neowise.rpgengine.engine.Context
import io.neowise.rpgengine.engine.components.Component
import java.awt.Color

class Background : Component() {

    override val name: String
        get() = "background"

    override fun init(context: Context, configuration: Configuration) { }

    override fun update(context: Context) {
    }

    override fun render(configuration: Configuration) {
        configuration.graphics.color = Color.ORANGE
        configuration.graphics.fillRect(0, 0, configuration.width, configuration.height)
    }
}