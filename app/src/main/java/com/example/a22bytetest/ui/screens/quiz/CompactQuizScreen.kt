package com.example.a22bytetest.ui.screens.quiz

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.a22bytetest.R
import com.example.a22bytetest.ui.navigation.Screen
import com.example.a22bytetest.ui.theme.QuestionBackground
import com.example.a22bytetest.ui.theme.QuestionTextColor
import com.example.a22bytetest.ui.viewmodels.QuizScreenViewModel

@Composable
fun CompactQuizScreen(
    navHostController: NavHostController,
    quizScreenViewModel: QuizScreenViewModel,
    modifier: Modifier = Modifier
) {
    val quizData by quizScreenViewModel.uiState.collectAsState()
    if (quizData.totalQuestionsAnswered == quizScreenViewModel.QUESTION_CAP) {
        navHostController.navigate(Screen.ResultScreen.route.plus("/${quizScreenViewModel.correctAnswersAmount}/${quizScreenViewModel.QUESTION_CAP}"))
    }
    Box(modifier = modifier) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.quiz_task),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(20.dp))
            quizData.let { data ->
                Box(
                    modifier = Modifier
                        .padding(horizontal = 12.dp, vertical = 12.dp)
                        .fillMaxWidth()
                        .background(QuestionBackground)
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.stars),
                        contentDescription = null,
                        tint = QuestionTextColor,
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(12.dp),
                    )
                    Text(
                        text = "“".plus(stringResource(id = quizData.quizData!!.sentence))
                            .plus("”"),
                        modifier = Modifier
                            .padding(horizontal = 32.dp, vertical = 64.dp),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyMedium,
                        lineHeight = 30.sp
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    data.quizData!!.options.forEach { imageId ->
                        QuizCard(imageId = imageId) {
                            quizScreenViewModel.playerAnswer(imageId == quizData.quizData!!.correctImageIndex)
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
            }
        }
        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = stringResource(R.string.skip_question),
            Modifier
                .clickable {
                    quizScreenViewModel.playerAnswer(false)
                }
                .align(Alignment.BottomEnd)
                .size(75.dp)
                .padding(bottom = 32.dp, end = 20.dp),
            tint = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun QuizCard(
    imageId: Int,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .height(110.dp)
            .width(110.dp)
            .shadow(
                elevation = 20.dp,
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
