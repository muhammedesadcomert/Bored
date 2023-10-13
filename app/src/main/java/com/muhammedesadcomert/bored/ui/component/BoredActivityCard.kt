package com.muhammedesadcomert.bored.ui.component

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muhammedesadcomert.bored.R

@Composable
fun BoredActivityCard(activity: String, type: String, link: String) {
    val context = LocalContext.current
    Card(
        modifier = Modifier.padding(48.dp),
        shape = CardDefaults.shape
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = type.uppercase(),
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue
            )
            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = activity,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            if (link.isNotEmpty())
                Row(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .clickable {
                            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(link)))
                        }
                ) {
                    Text(
                        modifier = Modifier,
                        text = stringResource(R.string.go_to_the_link),
                        textDecoration = TextDecoration.Underline,
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_outward),
                        contentDescription = stringResource(R.string.go_to_the_link)
                    )
                }
        }

    }
}