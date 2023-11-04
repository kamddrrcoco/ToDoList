package com.android.kotlinstudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.kotlinstudy.ui.ui.ChatUi
import com.android.kotlinstudy.ui.ui.MeUi
class MainActivity : ComponentActivity() {
    var selectedTab by mutableStateOf(0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
            // ChatUi()
           // MeUi()
            WeBottomBar(selectedTab)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainUi() {

    Column {
        Row {
           // MeUi()
        }
    }
}

@Composable
private fun WeBottomBar(selected: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        ) {
        TabItem(if (selected == 0) R.drawable.d else R.drawable.a, "聊天")
        TabItem(if (selected == 1) R.drawable.p else R.drawable.a, "通讯录")
        TabItem(if (selected == 2) R.drawable.d else R.drawable.a, "发现")
        TabItem(if (selected == 3) R.drawable.d else R.drawable.a, "我")
    }
}

@Composable
private fun TabItem(@DrawableRes iconId: Int, title: String) {
    Column(modifier = Modifier.padding(1.dp),
    ) {
        Icon(painterResource(iconId), title, Modifier.size(30.dp))
        Text(title)
    }
}




