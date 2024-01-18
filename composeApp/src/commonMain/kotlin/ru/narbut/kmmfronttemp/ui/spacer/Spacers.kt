package ru.narbut.kmmfronttemp.ui.spacer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun VerticalSpacer(margin: Int){
    Spacer(modifier = Modifier.height(margin.dp))
}

@Composable
fun HorizontalSpacer(margin: Int){
    Spacer(modifier = Modifier.width(margin.dp))
}