package io.neowise.rpgengine

import io.neowise.rpgengine.backgrounds.Background
import io.neowise.rpgengine.engine.Configuration
import io.neowise.rpgengine.engine.Context
import io.neowise.rpgengine.engine.Engine
import io.neowise.rpgengine.engine.event.EventEmitter
import io.neowise.rpgengine.sprites.Enemy
import io.neowise.rpgengine.sprites.Player

class RPGEngine(
    screenWidth: Int,
    screenHeight: Int,
    _eventEmitter: EventEmitter
) : Engine(screenWidth, screenHeight) {

    protected override val eventEmitter = _eventEmitter

    init {
        add(Background())
        add(Player())
        add(Enemy(50, 50))
    }

    override val context: Context by lazy {
        Context(_eventEmitter, this)
    }

    override val configuration: Configuration by lazy {
        Configuration(graphics, screenWidth, screenHeight)
    }
}