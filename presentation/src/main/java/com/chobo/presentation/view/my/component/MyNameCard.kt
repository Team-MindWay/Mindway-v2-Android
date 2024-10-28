package com.chobo.presentation.view.my.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.domain.model.my.MyDataModel
import com.chobo.presentation.R
import com.chobo.presentation.view.component.icon.OptionIcon
import com.chobo.presentation.view.component.modifier.multipleEventsCutterManager.clickableSingle
import com.chobo.presentation.view.component.modifier.padding.paddingHorizontal
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.my.uiState.GetMyInformationUiState

@Stable
@Composable
fun MyNameCard(
    modifier: Modifier = Modifier,
    uiState: GetMyInformationUiState,
    onClick: () -> Unit
) {
    MindWayAndroidTheme { colors, typography ->
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
            modifier = modifier
                .fillMaxWidth()
                .paddingHorizontal(
                    horizontal = 24.dp,
                    top = 60.dp,
                    bottom = 40.dp
                )
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = stringResource(R.string.greeting),
                    style = typography.headlineSmall,
                    fontWeight = FontWeight.Normal,
                    color = colors.Black,
                )
                when (uiState) {
                    is GetMyInformationUiState.Success -> {
                        Row {
                            Text(
                                text = uiState.data.name,
                                style = typography.headlineSmall,
                                fontWeight = FontWeight.SemiBold,
                                color = colors.Black,
                            )
                            Text(
                                text = stringResource(R.string.sir),
                                style = typography.headlineSmall,
                                fontWeight = FontWeight.SemiBold,
                                color = colors.MAIN,
                            )
                        }
                    }

                    GetMyInformationUiState.Fail ->
                        Text(
                            text = "통신이 원활하지 않습니다.",
                            style = typography.headlineSmall,
                            fontWeight = FontWeight.SemiBold,
                            color = colors.Black,
                        )

                    GetMyInformationUiState.Loading ->
                        Text(
                            text = "로딩중 ..",
                            style = typography.headlineSmall,
                            fontWeight = FontWeight.SemiBold,
                            color = colors.Black,
                        )
                }
            }
            OptionIcon(modifier = Modifier.clickableSingle(onClick = onClick))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyNameCardPreview() {
    MyNameCard(
        uiState = GetMyInformationUiState.Success(MyDataModel(name = "함재형", authority = "학생")),
        onClick = { }
    )
}