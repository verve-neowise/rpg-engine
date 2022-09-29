package io.neowise.rpgengine.engine.event

class OnKeyEvent(
    val state: KeyState,
    val key: Int
) : Event {
    override val type = "key-event"
}

