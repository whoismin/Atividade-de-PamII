package com.example.notaapp

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notaapp.ui.theme.DebugButtonColors
import com.example.notaapp.ui.theme.ErrorButtonColors
import com.example.notaapp.ui.theme.InfoButtonColors
import com.example.notaapp.ui.theme.NotaAppTheme
import com.example.notaapp.ui.theme.WarningButtonColors

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotaAppTheme{
                // A surface container using the 'background' color from the theme
                App()
            }
        }
    }
}
@Composable
private fun App() {
    var nome by remember { mutableStateOf("") }
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val image = painterResource(R.drawable.logoetec)
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop, modifier = Modifier
                    .width(150.dp)
                    .height(100.dp)
            )
            Greeting("NOTA BIMESTRAL -  PAM II")
            Row(
                Modifier
                    .fillMaxWidth(),
                Arrangement.Center

            ) {
                TextField(
                    value = nome, onValueChange = { novoValor -> nome = novoValor },
                    label = { Text("Digite seu nome completo:") },
                )
            }
            ActionButton(
                text = "Nota I",
                buttonColors = DebugButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Log.w(ContentValues.TAG, "App: A sua nota é I!")
            }
            ActionButton(
                text = "Nota R",
                buttonColors = WarningButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Log.w(ContentValues.TAG, "App: A sua nota é R!")
            }
            ActionButton(
                text = "Nota B",
                buttonColors = ErrorButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Log.w(ContentValues.TAG, "App: A sua nota é B!")
            }
            ActionButton(
                text = "Nota MB",
                buttonColors = InfoButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Log.w(ContentValues.TAG, "App: A sua nota é MB!")
            }
        }
    }
}
@Composable
fun ActionButton(
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit
){
    ElevatedButton(
        onClick = block,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors,
        modifier = modifier
    ) {
        Text(text = text)
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Atividade: $name!",
        style = MaterialTheme.typography.bodyLarge.copy(
            fontWeight = FontWeight.Bold
        ),
        color = MaterialTheme.colorScheme.secondary
    )
}

@Preview(showBackground = true, widthDp = 150, heightDp = 200)
@Composable
fun AppPreview(){
    NotaAppTheme{
        App()
    }
}
@Preview(showBackground = true, widthDp = 120)
@Composable
fun ActionButtonPreview(){
    ActionButton(text = "Cadastrar") {
    }
}