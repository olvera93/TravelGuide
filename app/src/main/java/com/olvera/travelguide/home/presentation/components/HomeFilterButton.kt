package com.olvera.travelguide.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Tune
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeFilterButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    IconButton(
        onClick = onClick,
        modifier = modifier.background(color = Color.LightGray, shape = RoundedCornerShape(13.dp))
    ) {
        Icon(imageVector = Icons.Default.Tune, contentDescription = "filter", tint = Color.Gray)
    }

}

@Preview
@Composable
fun HomeFilterButtonPreview() {
    HomeFilterButton({})
}