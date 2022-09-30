package io.neowise.rpgengine.util

import io.neowise.rpgengine.engine.components.Bounds

fun isCollisionDetected(b1: Bounds, b2: Bounds): Boolean {
    return b1.minX < b2.maxX &&
            b1.maxX > b2.minX &&
            b1.minY < b2.maxY &&
            b1.maxY > b2.minY
}
