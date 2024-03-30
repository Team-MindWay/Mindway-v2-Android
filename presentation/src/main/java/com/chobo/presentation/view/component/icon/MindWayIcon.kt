package com.chobo.presentation.view.component.icon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.chobo.presentation.R

@Composable
fun LogoIcon(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_mindway),
        contentDescription = "MindWay Main Icon",
        modifier = modifier.size(24.dp)
    )
}

@Composable
fun ChevronDownIcon(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_chevron_down),
        contentDescription = "MindWay Down Arrow",
        modifier = modifier.size(24.dp)
    )
}

@Composable
fun ChevronLeftIcon(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_chevron_left),
        contentDescription = "MindWay Left Arrow",
        modifier = modifier.size(24.dp)
    )
}

@Composable
fun ChevronRightIcon(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_chevron_right),
        contentDescription = "MindWay Right Arrow",
        modifier = modifier.size(24.dp)
    )
}

@Composable
fun ChevronTopIcon(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_chevron_top),
        contentDescription = "MindWay Top Arrow",
        modifier = modifier.size(24.dp)
    )
}

@Composable
fun EditIcon(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_edit),
        contentDescription = "MindWay Edit Icon",
        modifier = modifier.size(24.dp)
    )
}

@Composable
fun InfoIcon(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_info),
        contentDescription = "MindWay Info Icon",
        modifier = modifier.size(24.dp)
    )
}

@Composable
fun OptionIcon(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_option),
        contentDescription = "MindWay Option Icon",
        modifier = modifier.size(24.dp)
    )
}

@Composable
fun PlusIcon(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_plus),
        contentDescription = "MindWay Add Icon",
        modifier = modifier.size(24.dp)
    )
}

@Composable
fun SuccessIcon(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_success),
        contentDescription = "MindWay Success Icon",
        modifier = modifier.size(24.dp)
    )
}

@Composable
fun FailIcon(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_fail),
        contentDescription = "MindWay Fail Icon",
        modifier = modifier.size(24.dp)
    )
}

@Composable
fun TrashCanIcon(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_trash_can),
        contentDescription = "MindWay TrashCan Icon",
        modifier = modifier.size(24.dp)
    )
}

@Composable
fun HomeIcon(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false
) {
    Image(
        painter = painterResource(
            id =
            if (isSelected) R.drawable.ic_home_selected
            else R.drawable.ic_home
        ),
        contentDescription = "Show Home Icon",
        modifier = modifier.size(24.dp)
    )
}

@Composable
fun HeartIcon(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false
) {
    Image(
        painter = painterResource(
            id =
            if (isSelected) R.drawable.ic_heart_selected
            else R.drawable.ic_heart
        ),
        contentDescription = "Show Heart Icon",
        modifier = modifier.size(24.dp)
    )
}

@Composable
fun ProfileIcon(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false
) {
    Image(
        painter = painterResource(
            id =
            if (isSelected) R.drawable.ic_profile_selected
            else R.drawable.ic_profile
        ),
        contentDescription = "Show Profile Icon",
        modifier = modifier.size(24.dp)
    )
}

@Composable
fun BookIcon(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false
) {
    Image(
        painter = painterResource(
            id =
            if (isSelected) R.drawable.ic_book_selected
            else R.drawable.ic_book
        ),
        contentDescription = "Show Book Icon",
        modifier = modifier.size(24.dp)
    )
}