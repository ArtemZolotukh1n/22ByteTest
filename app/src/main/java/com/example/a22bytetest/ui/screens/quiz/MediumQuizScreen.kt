package com.example.a22bytetest.ui.screens.quiz

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.a22bytetest.R
import com.example.a22bytetest.ui.navigation.Screen
import com.example.a22bytetest.ui.screen_size.WindowInfo
import com.example.a22bytetest.ui.screens.common.MediumTopPart
import com.example.a22bytetest.ui.screens.start_game.SpacerForPortraitMode
import com.example.a22bytetest.ui.viewmodels.QuizScreenViewModel

@Composable
fun MediumQuizScreen(
    quizScreenViewModel: QuizScreenViewModel,
    navHostController: NavHostController,
    windowInfo: WindowInfo,
    modifier: Modifier = Modifier
) {
    val quizData by quizScreenViewModel.uiState.collectAsState()
    if (quizData.totalQuestionsAnswered == quizScreenViewModel.QUESTION_CAP) {
        navHostController.navigate(Screen.ResultScreen.route.plus("/${quizScreenViewModel.correctAnswersAmount}/${quizScreenViewModel.QUESTION_CAP}"))
    }
    Column(
        modifier = modifier
    ) {
        MediumTopPart(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(), windowInfo = windowInfo
        )
        SpacerForPortraitMode(20.dp)
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            item {
                quizData.let { data ->
                    Text(
                        text = "“".plus(stringResource(id = quizData.quizData!!.sentence))
                            .plus("”"),
                        modifier = Modifier.padding(horizontal = 32.dp),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodySmall,
                    )
                    SpacerForPortraitMode(32.dp)
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(18.dp)) {
                        items(data.quizData!!.options) { imageId ->
                            MediumQuizCard(
                                imageId = imageId
                            ) {
                                quizScreenViewModel.playerAnswer(imageId == quizData.quizData!!.correctImageIndex)
                            }
                        }
                    }

                }
            }
        }
    }

}

@Composable
fun MediumQuizCard(
    imageId: Int, onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .height(160.dp)
            .width(103.dp)
            .shadow(
                elevation = 4.dp,
                ambientColor = MaterialTheme.colorScheme.onSurface,
                spotColor = MaterialTheme.colorScheme.onSurface,
                shape = MaterialTheme.shapes.large
            )
            .clickable { onClick() },
        shape = MaterialTheme.shapes.large,
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = stringResource(R.string.quiz_answer_variant),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )
    }
}
