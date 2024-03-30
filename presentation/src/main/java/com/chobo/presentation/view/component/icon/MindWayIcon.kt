package com.chobo.presentation.view.component.icon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.chobo.presentation.R



@Composable
fun MindWayLogoIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_mindway),
        contentDescription = "Chevron Down Icon",
        modifier = Modifier.size(25.dp),
    )
}

@Composable
fun MindWayChevronDownIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_chevron_down),
        contentDescription = "Chevron Down Icon",
        modifier = Modifier.size(24.dp),
    )
}

@Composable
fun MindWayChevronLeftIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_chevron_left),
        contentDescription = "Chevron Left Icon",
        modifier = Modifier.size(24.dp),
    )
}
@Composable
fun MindWayChevronRightIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_chevron_right),
        contentDescription = "Chevron Right Icon",
        modifier = Modifier.size(24.dp),
    )
}
@Composable
fun MindWayChevronTopIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_chevron_top),
        contentDescription = "Chevron Top Icon",
        modifier = Modifier.size(24.dp),
    )
}

@Composable
fun MindWayEditIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_edit),
        contentDescription = "Edit Icon",
        modifier = Modifier.size(24.dp),
    )
}

@Composable
fun MindWayFailIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_fail),
        contentDescription = "More Info Icon",
        modifier = Modifier.size(24.dp),
    )
}

@Composable
fun MindWayInfoIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_info),
        contentDescription = "More Info Icon",
        modifier = Modifier.size(24.dp),
    )
}

@Composable
fun MindWayOptionIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_info),
        contentDescription = "Option Icon",
        modifier = Modifier.size(24.dp),
    )
}

@Composable
fun MindWayPlusIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_plus),
        contentDescription = "Add Icon",
        modifier = Modifier.size(24.dp),
    )
}

@Composable
fun MindWaySuccessIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_success),
        contentDescription = "More Info Icon",
        modifier = Modifier.size(24.dp),
    )
}

@Composable
fun MindWayTrashCanIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_trash_can),
        contentDescription = "More Info Icon",
        modifier = Modifier.size(24.dp),
    )
}
