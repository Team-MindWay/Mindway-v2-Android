package com.chobo.presentation.view.component.icon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.chobo.presentation.R

@Composable
fun LogoIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_mindway),
        contentDescription = "MindWay Main Icon",
        modifier = Modifier.size(25.dp),
    )
}

@Composable
fun ChevronDownIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_chevron_down),
        contentDescription = "MindWay Down Arrow",
        modifier = Modifier.size(24.dp),
    )
}

@Composable
fun ChevronLeftIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_chevron_left),
        contentDescription = "MindWay Left Arrow",
        modifier = Modifier.size(24.dp),
    )
}
@Composable
fun ChevronRightIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_chevron_right),
        contentDescription = "MindWay Right Arrow",
        modifier = Modifier.size(24.dp),
    )
}
@Composable
fun ChevronTopIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_chevron_top),
        contentDescription = "MindWay Top Arrow",
        modifier = Modifier.size(24.dp),
    )
}

@Composable
fun EditIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_edit),
        contentDescription = "MindWay Edit Icon",
        modifier = Modifier.size(24.dp),
    )
}

@Composable
fun InfoIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_info),
        contentDescription = "MindWay Info Icon",
        modifier = Modifier.size(24.dp),
    )
}

@Composable
fun OptionIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_option),
        contentDescription = "MindWay Option Icon",
        modifier = Modifier.size(24.dp),
    )
}

@Composable
fun PlusIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_plus),
        contentDescription = "MindWay Add Icon",
        modifier = Modifier.size(24.dp),
    )
}

@Composable
fun SuccessIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_success),
        contentDescription = "MindWay Success Icon",
        modifier = Modifier.size(24.dp),
    )
}

@Composable
fun FailIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_fail),
        contentDescription = "MindWay Fail Icon",
        modifier = Modifier.size(24.dp),
    )
}

@Composable
fun TrashCanIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_trash_can),
        contentDescription = "MindWay TrashCan Icon",
        modifier = Modifier.size(24.dp),
    )
}

@Composable
fun HomeIcon(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false
){
    Image(
        painter = painterResource(id = if (isSelected) R.drawable.ic_home_selected else R.drawable.ic_home),
        contentDescription = "Show Home Icon",
        modifier = modifier
    )
}

@Composable
fun HeartIcon(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false
){
    Image(
        painter = painterResource(id = if (isSelected) R.drawable.ic_heart_selected else R.drawable.ic_heart),
        contentDescription = "Show Heart Icon",
        modifier = modifier
    )
}

@Composable
fun ProfileIcon(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false
){
    Image(
        painter = painterResource(id = if (isSelected) R.drawable.ic_profile_selected else R.drawable.ic_profile),
        contentDescription = "Show Profile Icon",
        modifier = modifier
    )
}

@Composable
fun BookIcon(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false
){
    Image(
        painter = painterResource(id = if (isSelected) R.drawable.ic_book_selected else R.drawable.ic_book),
        contentDescription = "Show Book Icon",
        modifier = modifier
            .width(18.dp)
            .height(14.dp)
    )
}