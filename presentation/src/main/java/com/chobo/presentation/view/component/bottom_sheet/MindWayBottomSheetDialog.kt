package com.chobo.presentation.view.component.bottom_sheet

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MindWayBottomSheetDialog(
    modifier: Modifier = Modifier,
    sheetShape: Shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
    sheetContent: @Composable ColumnScope.() -> Unit,
    content: @Composable (sheetState: ModalBottomSheetState) -> Unit
) {
    MindWayAndroidTheme { colors, _ ->
        val sheetBackgroundColor = colors.WHITE
        val sheetState = rememberModalBottomSheetState(
            initialValue = ModalBottomSheetValue.Hidden,
            skipHalfExpanded = true
        )

        ModalBottomSheetLayout(
            modifier = modifier,
            sheetState = sheetState,
            sheetContent = sheetContent,
            sheetBackgroundColor = sheetBackgroundColor,
            sheetShape = sheetShape
        ) {
            content(sheetState)
        }
    }
}