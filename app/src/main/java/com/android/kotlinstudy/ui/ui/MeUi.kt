package com.android.kotlinstudy.ui.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.kotlinstudy.R

@Preview(showBackground = true)
@Composable
fun MeUi() {
    Column {
        Row {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.b),
                    contentDescription = null,
                    Modifier.size(40.dp)
                )
            }
            Column {
                Text(text = "张三", fontWeight = FontWeight.Bold)
                Text(text = "微信号:12345")
            }
            Column(verticalArrangement = Arrangement.Bottom) {
                Image(
                    painter = painterResource(id = R.drawable.c),
                    contentDescription = null,
                    Modifier.size(15.dp)
                )
            }
            Column(verticalArrangement = Arrangement.Center) {
                Image(
                    painter = painterResource(id = R.drawable.a),
                    contentDescription = null,
                    Modifier.size(15.dp)
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.give_service_to),
                contentDescription = null,
                Modifier.size(40.dp)
            )
            Text(text = "服务")
            Image(
                painter = painterResource(id = R.drawable.a),
                contentDescription = null,
                Modifier.size(15.dp)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.z),
                contentDescription = null,
                Modifier.size(40.dp)
            )
            Text(text = "朋友圈")
            Image(
                painter = painterResource(id = R.drawable.a),
                contentDescription = null,
                Modifier.size(15.dp)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(id = R.drawable.d),
                contentDescription = null,
                Modifier.size(40.dp)
            )
            Text(text = "设置")
            Image(
                painter = painterResource(id = R.drawable.a),
                contentDescription = null,
                Modifier.size(15.dp)
            )
        }
    }
}