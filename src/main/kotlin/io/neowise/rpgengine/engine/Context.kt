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

    inline fun <reified T> findOne(): T {
        return engine.components.find {
            it is T
        } as T
    }

    inline fun <reified T> findAll(): List<T> {
        return engine.components
            .filter { it is T }.map { it as T }
    }

}

