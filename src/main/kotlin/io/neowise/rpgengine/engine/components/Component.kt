package io.neowise.rpgengine.engine.components

import io.neowise.rpgengine.engine.Configuration
import io.neowise.rpgengine.engine.Context

interface Component {

    val name: String

    fun init(context: Context, configuration: Configuration)

    fun update(context: Context)

    fun render(configuration: Configuration)
}