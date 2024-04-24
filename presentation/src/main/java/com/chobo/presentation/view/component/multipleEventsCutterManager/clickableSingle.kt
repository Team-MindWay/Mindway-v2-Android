package com.chobo.presentation.view.component.multipleEventsCutterManager

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.debugInspectorInfo

@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.clickableSingle(
    enabled: Boolean = true,
    onClick: () -> Unit
): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = "clickable"
        properties["enabled"] = enabled
        properties["onClick"] = onClick
    }
) {
    multipleEventsCutter { manager ->
        clickable(
            enabled = enabled,
            onClick = { manager.processEvent { onClick() } },
            indication = null,
            interactionSource = remember { MutableInteractionSource() }
        )
    }
}