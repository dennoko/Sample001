package com.example.sample001

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Menu(
    id: Int,
    isShowDetail: Boolean = false,
    showMenuDetail: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                showMenuDetail()
            }
    ) {
        Text(
            "Menu:${id}  Click me",
        )

        if(isShowDetail) {
            for(i in 1..5) {
                Text("Detail $i")
            }
        }
    }
}