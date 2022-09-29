package io.neowise.rpgengine.engine

import io.neowise.rpgengine.engine.event.EventEmitter

class Context(
    val eventEmitter: EventEmitter,
    val engine: Engine
) {

}