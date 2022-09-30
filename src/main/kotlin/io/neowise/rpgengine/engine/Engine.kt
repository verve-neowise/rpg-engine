package io.neowise.rpgengine.engine

import io.neowise.rpgengine.engine.components.Component
import io.neowise.rpgengine.engine.event.EventEmitter
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.image.BufferedImage
import javax.swing.JComponent

abstract class Engine(
    private val screenWidth: Int,
    private val screenHeight: Int
) : JComponent() {

    val components = mutableListOf<Component>()

    protected var isInitialized = false
        private set

    private val buffer = BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_ARGB)

    protected val graphics: Graphics2D = buffer.createGraphics()

    fun add(component: Component) {
        components += component
    }

    fun findByName(name: String): Component? {
        return components.find { it.name == name }
    }

    fun update() {
        for (component in components) {
            component.update(context)
        }
    }

    fun render() {
        for (component in components) {
            component.render(configuration)
        }
        repaint()
    }

    fun init() {
        for (component in components) {
            component.init(context, configuration)
        }
    }

    override fun paintChildren(g: Graphics) {
        g.drawImage(buffer, 0, 0, null)
    }

    abstract val context: Context
    abstract val configuration : Configuration
}