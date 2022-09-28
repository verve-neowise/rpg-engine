package io.neowise.rpgengine.engine.texture

import javax.imageio.ImageIO

class TextureLoader {

    fun loadImageTexture(path: String): Texture {
        val resource = TextureLoader::class.java.getResource(path)
        return ImageTexture(ImageIO.read(resource))
    }
}