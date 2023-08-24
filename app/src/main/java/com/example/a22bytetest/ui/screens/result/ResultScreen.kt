package com.example.a22bytetest.ui.screens.result

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.a22bytetest.R

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ResultScreen(
    playerScore: Any?,
    totalAnswers: String?,
    playerAnswers: Map<Int, Boolean>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(start = 12.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(
                id = R.string.final_score,
                playerScore.toString(),
                totalAnswers ?: "error"
            ),
            style = MaterialTheme.typography.titleLarge
        )
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 20.dp)
        ) {
            items(playerAnswers.keys.toList()) { question ->
                FlowRow(modifier = Modifier.fillMaxWidth()) {
                    Text(text = stringResource(id = question))
                    Text(
                        text = stringResource(
                            id = R.string.is_correct,
                            playerAnswers[question].toString()
                        ),
                        color = Color.Red
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}
