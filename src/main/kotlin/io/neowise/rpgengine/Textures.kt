package io.neowise.rpgengine

import io.neowise.rpgengine.engine.texture.TextureLoader

object Textures {

    private val textureLoader = TextureLoader()

    val rocket by lazy {
        textureLoader.loadImageTexture("/resources/rocket.png")
    }
}