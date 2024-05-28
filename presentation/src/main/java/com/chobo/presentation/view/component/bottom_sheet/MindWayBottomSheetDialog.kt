package com.chobo.presentation.view.component.bottom_sheet

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
    sheetState: ModalBottomSheetState,
    sheetContent: @Composable() (ColumnScope.() -> Unit),
    content: @Composable (sheetState: ModalBottomSheetState) -> Unit,
) {
    MindWayAndroidTheme { colors, _ ->
        ModalBottomSheetLayout(
            modifier = modifier,
            sheetState = sheetState,
            sheetContent = sheetContent,
            sheetBackgroundColor = colors.WHITE,
            sheetShape = sheetShape
        ) {
            content(sheetState)
        }
    }
}