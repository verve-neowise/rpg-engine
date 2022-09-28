package io.neowise.rpgengine.engine.texture

import java.awt.Graphics

interface Texture {
    fun draw(graphics2D: Graphics, x: Int, y: Int)
}