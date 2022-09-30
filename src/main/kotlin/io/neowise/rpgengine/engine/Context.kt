package io.neowise.rpgengine.engine

import io.neowise.rpgengine.engine.components.Component
import io.neowise.rpgengine.engine.event.EventEmitter

abstract class  Context(val engine: Engine) {

    abstract val eventEmitter: EventEmitter
    fun <T> findByName(name: String): T {
        return engine.components.find {
            it.name == name
        } as T
    }

    inline fun <reified T> find(): T {
        return engine.components.find {
            it is T
        } as T
    }
}

