package io.neowise.rpgengine.event

class EventEmitter {
    private val subscribers = mutableListOf<Subscriber<in Event>>()

    fun push(event: Event) {
        subscribers.forEach {
            if (it.type == event.type) {
                it.eventListener(event)
            }
        }
    }

    fun <T : Event> subscribe(type: String, listener: (event: T) -> Unit) {
        subscribers.add(Subscriber(type, listener))
    }

    class Subscriber<T>(
        val type: String,
        val eventListener: (event: T) -> Unit
    )
}