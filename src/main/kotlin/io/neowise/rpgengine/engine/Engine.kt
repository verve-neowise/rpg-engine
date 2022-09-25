package io.neowise.rpgengine.engine

import io.neowise.rpgengine.components.Component
import io.neowise.rpgengine.event.EventEmitter
import java.awt.Graphics
import java.awt.image.BufferedImage
import javax.swing.JComponent

abstract class Engine : JComponent() {

    protected val components = mutableListOf<Component>()

    protected val eventEmitter = EventEmitter()

    protected var isInitialized = false
        private set

    private val buffer = BufferedImage()

    fun add(component: Component) {
        components += component
    }

    fun findByName(name: String): Component? {
        return components.find { it.name == name }
    }

    fun update() {
        for (component in components) {
            component.update(context())
        }
    }

    fun render() {

    }

    private fun init() {
        for (component in components) {
            component.init(context(), configuration())
        }
    }

    override fun paintChildren(g: Graphics) {
        for (component in components) {
            component.init(context(), configuration())
        }
    }

    abstract fun context(): Context
    abstract fun configuration() : Configuration
}