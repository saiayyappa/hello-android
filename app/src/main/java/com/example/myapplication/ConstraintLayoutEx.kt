package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.layoutId
import com.example.myapplication.ui.theme.MyApplicationTheme

class ConstraintLayoutEx : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyApplicationTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          Greeting6("Android")
        }
      }
    }
  }
}

@Composable
fun Greeting6(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!",
    modifier = modifier
  )
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview6() {
//  MyApplicationTheme {
//    Greeting6("Android")
//  }
//}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ConstraintExample() {

  val constraintSet = ConstraintSet {
    val buttonLogin = createRefFor("buttonLogin")
    val buttonSignUp = createRefFor("buttonSignUp")
    val inputUsername = createRefFor("inputUsername")
    val inputPassword = createRefFor("inputPassword")
    val inputEmail = createRefFor("inputEmail")
    val inputFullName = createRefFor("inputFullName")
    val imageLogo = createRefFor("imageLogo")
    val textSignup = createRefFor("textSignup")
    val textContact = createRefFor("textContact")
    val textPrivacy = createRefFor("textPrivacy")
    val divider = createRefFor("divider")

    constrain(imageLogo) {
      top.linkTo(parent.top, 32.dp)
      start.linkTo(parent.start, 16.dp)
      end.linkTo(parent.end, 16.dp)
    }

    constrain(textSignup) {
      top.linkTo(imageLogo.top, 48.dp)
      start.linkTo(parent.start, 16.dp)
      end.linkTo(parent.end, 16.dp)
    }

    constrain(buttonLogin) {
      top.linkTo(textSignup.bottom, 16.dp)
      start.linkTo(parent.start, 32.dp)
      end.linkTo(parent.end, 32.dp)
    }

    constrain(divider) {
      top.linkTo(buttonLogin.top, 64.dp)
      start.linkTo(parent.start, 16.dp)
      end.linkTo(parent.end, 16.dp)
    }

    constrain(inputUsername) {
      top.linkTo(divider.bottom, 32.dp)
      start.linkTo(parent.start, 16.dp)
      end.linkTo(parent.end, 16.dp)
    }

    constrain(inputPassword) {
      top.linkTo(inputUsername.bottom, 8.dp)
      start.linkTo(parent.start, 16.dp)
      end.linkTo(parent.end, 16.dp)
    }

    constrain(inputEmail) {
      top.linkTo(inputPassword.bottom, 8.dp)
      start.linkTo(parent.start, 16.dp)
      end.linkTo(parent.end, 16.dp)
    }

    constrain(inputFullName) {
      top.linkTo(inputEmail.bottom, 8.dp)
      start.linkTo(parent.start, 16.dp)
      end.linkTo(parent.end, 16.dp)
    }

    constrain(textContact) {
      top.linkTo(inputFullName.bottom, 16.dp)
      start.linkTo(parent.start, 32.dp)
      end.linkTo(parent.end, 32.dp)
    }

    constrain(textPrivacy) {
      top.linkTo(textContact.bottom, 16.dp)
      start.linkTo(parent.start, 32.dp)
      end.linkTo(parent.end, 32.dp)
    }

    constrain(buttonSignUp) {
      top.linkTo(textPrivacy.bottom, 16.dp)
      start.linkTo(parent.start, 32.dp)
      end.linkTo(parent.end, 32.dp)
    }

  }
  ConstraintLayout(
    constraintSet, modifier = Modifier
      .fillMaxSize()
      .padding(16.dp)
  ) {
    val context = LocalContext.current
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

    Image(
      painterResource(id = R.drawable.instalogo), contentDescription = "insta logo",
      modifier = Modifier.layoutId("imageLogo")
    )

    Text(
      text = "Sign up to see photos and videos from your friends.",
      textAlign = TextAlign.Center,
      fontWeight = FontWeight.Bold,
      modifier = Modifier.layoutId("textSignup")
    )

    Button(
      onClick = { /*TODO*/ },
      colors = ButtonDefaults.buttonColors(Color(0xFF2290EE)),
      modifier = Modifier
        .layoutId("buttonLogin")
        .padding(bottom = 20.dp),
      shape = RoundedCornerShape(8.dp)
    ) {
      Image(painterResource(id = R.drawable.fblogo), contentDescription = "fb logo")
      Text(
        text = "Log in with Facebook",
        fontSize = 16.sp,
        modifier = Modifier.padding(start = 8.dp)
      )
    }

    Divider(modifier = Modifier.layoutId("divider"))

    OutlinedTextField(
      value = username,
      onValueChange = { username = it },
      label = { Text(text = ("Username")) },
      modifier = Modifier.layoutId("inputUsername")
    )

    OutlinedTextField(
      value = password,
      onValueChange = { password = it },
      label = { Text("Password") },
      visualTransformation = PasswordVisualTransformation(),
      modifier = Modifier.layoutId("inputPassword")
    )

    OutlinedTextField(
      value = email,
      onValueChange = { email = it },
      label = { Text(text = ("Email")) },
      modifier = Modifier.layoutId("inputEmail")
    )

    OutlinedTextField(
      value = fullName,
      onValueChange = { fullName = it },
      label = { Text(text = ("Full Name")) },
      modifier = Modifier.layoutId("inputFullName")
    )

    Button(
      onClick = {
        Toast.makeText(
          context,
          "Username $username , Password: $password ",
          Toast.LENGTH_SHORT
        ).show()
      },
      Modifier
        .layoutId("buttonSignUp"),
      colors = ButtonDefaults.buttonColors(Color(0xFF68B5FA)),
      shape = RoundedCornerShape(8.dp)
    ) {
      Text(text = "Sign up")
    }
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
      modifier = Modifier
        .padding(top = 5.dp, bottom = 10.dp)
        .layoutId("textContact")
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
      modifier = Modifier
        .padding(top = 5.dp, bottom = 10.dp)
        .layoutId("textPrivacy")
    )
  }
}