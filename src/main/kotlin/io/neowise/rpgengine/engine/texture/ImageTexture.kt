package io.neowise.rpgengine.engine.texture

import java.awt.Graphics
import java.awt.image.BufferedImage

class ImageTexture(private val image: BufferedImage) : Texture {

    override fun draw(graphics2D: Graphics, x: Int, y: Int) {
        graphics2D.drawImage(image, x, y, null)
    }
}