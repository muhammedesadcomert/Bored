package com.muhammedesadcomert.bored.ui.home

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.muhammedesadcomert.bored.R
import com.muhammedesadcomert.bored.ui.component.BoredActivityCard
import com.talhafaki.composablesweettoast.util.SweetToastUtil.SweetError

@Composable
fun Home(viewModel: HomeViewModel = hiltViewModel()) {
    val boredActivity by viewModel.boredActivity.collectAsState(initial = HomeUiState.Initial)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (val result = boredActivity) {
            HomeUiState.Initial -> {
                Text(text = stringResource(R.string.are_you_bored))
            }
            HomeUiState.Loading -> {
                CircularProgressIndicator()
            }
            is HomeUiState.Success -> {
                BoredActivityCard(
                    activity = result.data.activity.orEmpty(),
                    type = result.data.type.orEmpty(),
                    link = result.data.link.orEmpty(),
                )
            }
            is HomeUiState.Error -> {
                SweetError(
                    message = result.errorMessage,
                    duration = Toast.LENGTH_SHORT,
                    padding = PaddingValues(bottom = 16.dp),
                    contentAlignment = Alignment.BottomCenter
                )
            }
        }

        Button(
            modifier = Modifier.padding(32.dp),
            onClick = { viewModel.getBoredActivity() }
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = stringResource(R.string.yes_i_am_bored),
                fontWeight = FontWeight.Bold
            )
        }
    }
}