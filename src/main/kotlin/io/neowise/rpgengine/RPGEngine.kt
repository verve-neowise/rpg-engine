package io.neowise.rpgengine

import io.neowise.rpgengine.backgrounds.Background
import io.neowise.rpgengine.engine.Configuration
import io.neowise.rpgengine.engine.Context
import io.neowise.rpgengine.engine.Engine
import io.neowise.rpgengine.engine.components.Component
import io.neowise.rpgengine.engine.event.EventEmitter
import io.neowise.rpgengine.sprites.Enemy
import io.neowise.rpgengine.sprites.Player

class RPGEngine(
    screenWidth: Int,
    screenHeight: Int,
    _eventEmitter: EventEmitter
) : Engine(screenWidth, screenHeight) {

    init {
        add(Background())
        add(Player())
        add(Enemy(300, 50))
    }

    override val context: Context by lazy {

        object : Context(this) {
            override val eventEmitter get() = _eventEmitter
        }
    }

    override val configuration: Configuration by lazy {
        Configuration(graphics, screenWidth, screenHeight)
    }
}