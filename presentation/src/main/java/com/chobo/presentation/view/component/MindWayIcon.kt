package com.chobo.presentation.view.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.chobo.presentation.R



@Composable
fun LogoIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_mindway),
        contentDescription = "Chevron Down Icon",
        modifier = Modifier.size(25.dp),
    )
}

@Composable
fun ChevronDownIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_chevron_down),
        contentDescription = "Chevron Down Icon",
        modifier = Modifier.size(24.dp),
    )
}

@Composable
fun ChevronLeftIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_chevron_left),
        contentDescription = "Chevron Left Icon",
        modifier = Modifier.size(24.dp),
    )
}
@Composable
fun ChevronRightIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_chevron_right),
        contentDescription = "Chevron Right Icon",
        modifier = Modifier.size(24.dp),
    )
}
@Composable
fun ChevronTopIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_chevron_top),
        contentDescription = "Chevron Top Icon",
        modifier = Modifier.size(24.dp),
    )
}

@Composable
fun EditIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_edit),
        contentDescription = "Edit Icon",
        modifier = Modifier.size(24.dp),
    )
}

@Composable
fun FailIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_fail),
        contentDescription = "More Info Icon",
        modifier = Modifier.size(24.dp),
    )
}

@Composable
fun InfoIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_info),
        contentDescription = "More Info Icon",
        modifier = Modifier.size(24.dp),
    )
}

@Composable
fun OptionIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_info),
        contentDescription = "Option Icon",
        modifier = Modifier.size(24.dp),
    )
}

@Composable
fun PlusIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_plus),
        contentDescription = "Add Icon",
        modifier = Modifier.size(24.dp),
    )
}

@Composable
fun SuccessIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_success),
        contentDescription = "More Info Icon",
        modifier = Modifier.size(24.dp),
    )
}

@Composable
fun TrashCanIcon(){
    Image(
        painter = painterResource(id = R.drawable.ic_trash_can),
        contentDescription = "More Info Icon",
        modifier = Modifier.size(24.dp),
    )
}
