package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class QuizApp : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyApplicationTheme {
        var feedback by remember {
          mutableStateOf("")
        }
        // Initialize the quiz
        val quiz = Quiz(
          "What is the capital of France?",
          "Paris"
        )

        // Display the quiz question and check the user's answer
        QuizScreen(quiz) { userAnswer ->
          val isCorrect = quiz.checkAnswer(userAnswer)
          feedback = if (isCorrect) "Correct! 🎉" else "Wrong! 😞"
        }


        Column(
          modifier = Modifier.padding(100.dp, 150.dp)
        ) {
          Text(text = feedback)

        }

      }
    }
  }
}

data class Quiz(val question: String, val correctAnswer: String) {
  fun checkAnswer(userAnswer: String?): Boolean {
    return userAnswer.equals(correctAnswer, ignoreCase = true)
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizScreen(quiz: Quiz, onAnswerSubmitted: (String?) -> Unit) {
  var userAnswer by remember { mutableStateOf<String?>(null) }

  Column {
    // Display the quiz question
    Text(text = quiz.question, style = MaterialTheme.typography.bodySmall)

    // Input field for the user's answer
    TextField(
      value = userAnswer.orEmpty(),
      onValueChange = {
        userAnswer = it
      },
      label = { Text("Your Answer") },
      keyboardOptions = KeyboardOptions.Default.copy(
        imeAction = ImeAction.Done
      ),
      keyboardActions = KeyboardActions(
        onDone = {
          // Callback to handle the user's answer when the keyboard is done
          onAnswerSubmitted(userAnswer)
        }
      )
    )

    // Button to submit the answer
    Button(
      onClick = {
        // Callback to handle the user's answer when the button is clicked
        onAnswerSubmitted(userAnswer)
      },
      modifier = Modifier.padding(16.dp)
    ) {
      Text("Submit Answer")
    }

    Text(text = "")
  }
}


@Preview(showBackground = true)
@Composable
fun PreviewQuizScreen() {
  MyApplicationTheme {
    // Preview of the QuizScreen
    QuizScreen(
      quiz = Quiz(
        question = "What is the capital of Germany?",
        correctAnswer = "Berlin"
      )
    ) {
      // Preview doesn't handle user input, so this is a dummy callback
      //ShowFeedback(feedback = "Preview Feedback")
    }
  }
}