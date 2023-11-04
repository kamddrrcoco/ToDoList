@file:OptIn(ExperimentalMaterial3Api::class)

package com.android.kotlinstudy.ui.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.kotlinstudy.R
import com.android.kotlinstudy.ui.theme.KotlinStudyTheme

@Preview(showBackground = true)
@Composable
fun ChatUi() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "标题")
                },
                actions = {
                    IconButton(onClick = { }) {     //跳转搜索页面
                        Icon(
                            painter = painterResource(R.drawable.search_for),
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        ChatInterface(Modifier.padding(innerPadding))
    }
    /*Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { }) {
                Text(text = "点击")
            }
            Text(text = "测试")
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "名字")
            Checkbox(checked = true, onCheckedChange = {})
        }
    }*/
}

@Preview
@Composable
fun ChatInterface(modifier: Modifier = Modifier) {
    KotlinStudyTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(70.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.chat),
                    contentDescription = null,
                    Modifier.size(50.dp)
                )
                Column {
                    Text(text = "张三", fontWeight = FontWeight.Bold)
                    Text(text = "聊天内容111")
                }
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    Modifier.size(50.dp)
                )
                Column {
                    Text(text = "李四", fontWeight = FontWeight.Bold)
                    Text(text = "聊天内容222")
                }
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = androidx.core.R.drawable.ic_call_answer),
                    contentDescription = null,
                    Modifier.size(50.dp)
                )
                Column {
                    Text(text = "王五", fontWeight = FontWeight.Bold)
                    Text(text = "聊天内容333")
                }
            }
        }
    }
}






