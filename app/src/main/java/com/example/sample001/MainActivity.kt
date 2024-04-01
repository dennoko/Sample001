package com.example.sample001

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sample001.ui.theme.Sample001Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val vm : AppViewModel by viewModels()

        setContent {
            Sample001Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(vm)
                }
            }
        }
    }
}

@Composable
fun MainScreen(vm: AppViewModel) {
    Column{
        Row {
            Button(onClick = { vm.increaseMenu() }) {
                Text(text = "Add Menu")
            }
            Button(onClick = { vm.hideDetail() }) {
                Text(text = "Hide Detail")
            }
            Button(onClick = { vm.resetMenu() }) {
                Text(text = "Reset Menu")
            }
        }

        for (i in 1..vm.numOfMenu.value) {
            if(i == vm.openedMenu.value) {
                Menu(i, isShowDetail = true) {
                    // メニューの詳細表示を切り替える
                    vm.showDetail(i)
                }
            } else {
                Menu(i, isShowDetail = false) {
                    // メニューの詳細表示を切り替える
                    vm.showDetail(i)
                }
            }
        }
    }
}