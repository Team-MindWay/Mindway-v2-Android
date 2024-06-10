package com.chobo.presentation.view.event.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.domain.model.event.response.GetEventListResponseModel
import com.chobo.presentation.view.component.icon.ChevronRightIcon
import com.chobo.presentation.view.component.multipleEventsCutterManager.clickableSingle
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun Events(
    modifier: Modifier = Modifier,
    eventsData: GetEventListResponseModel,
    navigateToDetailEvent: (Long) -> Unit
) {
    MindWayAndroidTheme { colors, typography ->
        Spacer(modifier = modifier.height(28.dp))
        Surface(
            color = colors.WHITE,
            shape = RoundedCornerShape(8.dp),
            modifier = modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 20.dp,
                    spotColor = colors.CardShadow
                ),
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 24.dp,
                        vertical = 20.dp
                    )
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = eventsData.title,
                        style = typography.bodySmall,
                        color = colors.Black,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = modifier.weight(1f))
                    ChevronRightIcon(
                        modifier = Modifier.clickableSingle {
                            navigateToDetailEvent(eventsData.id)
                        }
                    )
                }
                Text(
                    text = eventsData.content,
                    style = typography.bodySmall,
                    color = colors.GRAY800,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = eventsData.content,
                    style = typography.labelLarge,
                    color = colors.GRAY400,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}

@Preview
@Composable
fun EventsPreview() {
    Events(
        eventsData = GetEventListResponseModel(
            id = 0,
            title = "adsf",
            content = "asDf",
            img_url = "asdf",
            started_at = "asdlf",
            ended_at = "asdfasd"
        ),
    ){}
}