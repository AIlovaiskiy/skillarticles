package ru.skillbranch.skillarticles.ui.custom.behaviors

import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import ru.skillbranch.skillarticles.ui.custom.Bottombar

private const val SCROLL_UP = 1
private const val SCROLL_DOWN = 2

class BottombarBehavior : CoordinatorLayout.Behavior<Bottombar>() {

    private var lastY = 0
    private var direction = 0

    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: Bottombar,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int
    ): Boolean {
        return axes and ViewCompat.SCROLL_AXIS_VERTICAL != 0
    }

    override fun onNestedPreScroll(
        coordinatorLayout: CoordinatorLayout,
        child: Bottombar,
        target: View,
        dx: Int,
        dy: Int,
        consumed: IntArray,
        type: Int
    ) {
        val localDirection = if (dy > lastY) SCROLL_UP else SCROLL_DOWN
        if (localDirection == direction) return
        direction = localDirection
        when (direction) {
            SCROLL_UP -> child.animate().translationY(0F).start()
            SCROLL_DOWN -> child.animate().translationY(child.height.toFloat()).start()
        }
    }
}