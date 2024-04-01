package com.example.sample001

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AppViewModel: ViewModel() {
    var numOfMenu = mutableStateOf(1)
    // 詳細が開かれたメニューの番号
    var openedMenu = mutableStateOf<Int?>(null)

    // メニューの数を増やす
    fun increaseMenu() {
        numOfMenu.value++
    }

    // 番号のメニューの詳細の表示を切り替える
    fun showDetail(menuNum: Int) {
        if(menuNum == openedMenu.value) {
            // 既に開かれているメニューを再度クリックした場合は非表示にする
            openedMenu.value = null
        }else{
            // メニュー番号を設定
            openedMenu.value = menuNum
        }
    }

    // メニュー非表示
    fun hideDetail() {
        openedMenu.value = null
    }

    // メニューの数をリセット
    fun resetMenu() {
        numOfMenu.value = 1
    }
}