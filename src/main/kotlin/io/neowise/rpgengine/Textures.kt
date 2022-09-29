package io.neowise.rpgengine

import io.neowise.rpgengine.engine.texture.TextureLoader

object Textures {

    private val textureLoader = TextureLoader()

    val rocket by lazy {
        textureLoader.loadImageTexture("/resources/player.png")
    }

    val rocketCollided by lazy {
        textureLoader.loadImageTexture("/resources/player_collided.png")
    }

    val enemy by lazy {
        textureLoader.loadImageTexture("/resources/enemy.png")
    }
}