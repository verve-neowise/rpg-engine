package io.neowise.rpgengine.engine.event

open class EventEmitter {

    private val onKeyListeners = mutableListOf<(event: OnKeyEvent) -> Unit>()

    fun onKeyEvent(listener: (event: OnKeyEvent) -> Unit) {
        onKeyListeners += listener
    }

    fun emit(event: OnKeyEvent) {
        onKeyListeners.forEach { it(event) }
    }
}