package io.neowise.rpgengine.engine.components

import io.neowise.rpgengine.engine.Configuration
import io.neowise.rpgengine.engine.Context

abstract class Component {

    abstract val name: String

    abstract fun init(context: Context, configuration: Configuration)

    abstract fun update(context: Context)

    abstract fun render(configuration: Configuration)
}