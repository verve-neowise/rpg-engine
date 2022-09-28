package io.neowise.rpgengine.engine

import java.util.Timer
import java.util.TimerTask

class FrameRate(private val engine: Engine)  {

    private val timer = Timer()

    private val task = object : TimerTask() {
        override fun run() {
            engine.update()
            engine.render()
        }
    }

    fun start() {
        engine.init()
        timer.scheduleAtFixedRate(task, 0, 20)
    }

    fun stop() {
        task.cancel()
    }
}