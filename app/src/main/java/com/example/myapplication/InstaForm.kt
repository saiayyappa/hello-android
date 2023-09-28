package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class InstaForm : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyApplicationTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
          InstaFormScreen()
        }
      }
    }
  }
}

@Composable
fun HyperlinkText(
  modifier: Modifier = Modifier,
  fullText: String,
  hyperLinks: Map<String, String>,
  textStyle: TextStyle = TextStyle.Default,
  linkTextColor: Color = Color.Blue,
  linkTextFontWeight: FontWeight = FontWeight.Normal,
  linkTextDecoration: TextDecoration = TextDecoration.None,
  fontSize: TextUnit = TextUnit.Unspecified
) {
  val annotatedString = buildAnnotatedString {
    append(fullText)

    for ((key, value) in hyperLinks) {

      val startIndex = fullText.indexOf(key)
      val endIndex = startIndex + key.length
      addStyle(
        style = SpanStyle(
          color = linkTextColor,
          fontSize = fontSize,
          fontWeight = linkTextFontWeight,
          textDecoration = linkTextDecoration
        ),
        start = startIndex,
        end = endIndex
      )
      addStringAnnotation(
        tag = "URL",
        annotation = value,
        start = startIndex,
        end = endIndex
      )
    }
    addStyle(
      style = SpanStyle(
        fontSize = fontSize
      ),
      start = 0,
      end = fullText.length
    )
  }

  val uriHandler = LocalUriHandler.current

  ClickableText(
    modifier = modifier,
    text = annotatedString,
    style = textStyle,
    onClick = {
      annotatedString
        .getStringAnnotations("URL", it, it)
        .firstOrNull()?.let { stringAnnotation ->
          uriHandler.openUri(stringAnnotation.item)
        }
    }
  )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InstaFormScreen(modifier: Modifier = Modifier) {
  var email by remember {
    mutableStateOf("")
  }
  var fullName by remember {
    mutableStateOf("")
  }
  var username by remember {
    mutableStateOf("")
  }
  var password by remember {
    mutableStateOf("")
  }
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Top,
    modifier = Modifier
      .padding(top = 20.dp, bottom = 20.dp, start = 50.dp, end = 50.dp)
      .fillMaxSize()
  ) {
    Image(painterResource(id = R.drawable.instalogo), contentDescription = "insta logo")
    Text(
      text = "Sign up to see photos and videos from your friends.",
      textAlign = TextAlign.Center,
      fontWeight = FontWeight.Bold,
      modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)
    )
    Button(
      onClick = { /*TODO*/ },
      colors = ButtonDefaults.buttonColors(Color(0xFF2290EE)),
      modifier = Modifier
        .padding(bottom = 20.dp)
        .fillMaxWidth(),
      shape = RoundedCornerShape(8.dp)
    ) {
      Image(painterResource(id = R.drawable.fblogo), contentDescription = "fb logo")
      Text(
        text = "Log in with Facebook",
        fontSize = 16.sp,
        modifier = Modifier.padding(start = 8.dp)
      )
    }
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center,
      modifier = Modifier.padding(bottom = 20.dp)
    ) {
//      Text(text = "OR")
      Divider()
    }
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Top,
      modifier = Modifier.padding(bottom = 20.dp)
    ) {
      OutlinedTextField(
        value = email, onValueChange = { email = it },
        placeholder = {
          Text(text = "Mobile number or Email")
        },
        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
      )
      OutlinedTextField(
        value = fullName, onValueChange = { fullName = it },
        placeholder = {
          Text(text = "Full Name")
        },
        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
//        colors = TextFieldColors.textColor(Color(0xFFFAFAFA))
      )
      OutlinedTextField(
        value = username, onValueChange = { username = it },
        placeholder = {
          Text(text = "Username")
        },
        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
      )
      OutlinedTextField(
        value = password, onValueChange = { password = it },
        placeholder = {
          Text(text = "Password")
        },
        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
      )
      HyperlinkText(
        fullText = "People who use our service may have uploaded your contact information to Instagram. Learn More",
        hyperLinks = mutableMapOf(
          "Learn More" to "https://www.facebook.com/help/instagram/261704639352628"
        ),
        textStyle = TextStyle(
          textAlign = TextAlign.Center,
          color = Color(0xFF737373)
        ),
        linkTextColor = Color(0xFF01376A),
        fontSize = 14.sp,
        modifier = Modifier.padding(top = 5.dp, bottom = 10.dp)
      )
      HyperlinkText(
        fullText = "By signing up, you agree to our Terms, Privacy Policy and Cookies Policy.",
        hyperLinks = mutableMapOf(
          "Terms" to "https://help.instagram.com/581066165581870/?locale=en_US",
          "Privacy Policy" to "https://www.facebook.com/privacy/policy",
          "Cookies Policy" to "https://help.instagram.com/1896641480634370/"
        ),
        textStyle = TextStyle(
          textAlign = TextAlign.Center,
          color = Color(0xFF737373)
        ),
        linkTextColor = Color(0xFF01376A),
        fontSize = 14.sp,
        modifier = Modifier.padding(top = 5.dp, bottom = 10.dp)
      )
    }
    Button(
      onClick = { /*TODO*/ },
      colors = ButtonDefaults.buttonColors(Color(0xFF68B5FA)),
      modifier = Modifier.fillMaxWidth(),
      shape = RoundedCornerShape(8.dp)
    ) {
      Text(
        text = "Sign up",
        fontSize = 16.sp
      )
    }

  }
}

@Preview(showBackground = true)
@Composable
fun InstaFormScreenPreview() {
  MyApplicationTheme {
    InstaFormScreen()
  }
}