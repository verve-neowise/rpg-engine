package io.neowise.rpgengine

import io.neowise.rpgengine.backgrounds.Background
import io.neowise.rpgengine.engine.Configuration
import io.neowise.rpgengine.engine.Context
import io.neowise.rpgengine.engine.Engine
import io.neowise.rpgengine.sprites.Player

class RPGEngine(
    screenWidth: Int,
    screenHeight: Int
) : Engine(screenWidth, screenHeight) {

    init {
        add(Background())
        add(Player("Vovan", 50, 40))
    }

    override val context: Context by lazy {
        Context()
    }

    override val configuration: Configuration by lazy {
        Configuration(graphics, screenWidth, screenHeight)
    }
}