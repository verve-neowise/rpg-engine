package io.neowise.rpgengine

import io.neowise.rpgengine.engine.event.EventEmitter
import io.neowise.rpgengine.engine.event.KeyState
import io.neowise.rpgengine.engine.event.OnKeyEvent
import java.awt.event.KeyEvent
import java.awt.event.KeyListener

class JFrameEventEmitter : EventEmitter(), KeyListener {
    override fun keyTyped(e: KeyEvent?) {
    }

    override fun keyPressed(e: KeyEvent) {
        emit(OnKeyEvent(KeyState.PRESSED, e.keyCode))
    }

    override fun keyReleased(e: KeyEvent) {
        emit(OnKeyEvent(KeyState.RELEASED, e.keyCode))
    }
}