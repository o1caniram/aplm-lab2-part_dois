package ao.co.isptec.aplm.helloandroid

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ao.co.isptec.aplm.helloandroid.ui.theme.HelloAndroidTheme
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import android.content.Intent
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "Aplicação iniciada com sucesso.")
        Log.d("MainActivity", "Mensagem de Debug")
        Log.i("MainActivity", "Informação da aplicação")
        Log.e("MainActivity", "Mensagem de erro")

        try {
            val divisor = intent.getIntExtra("DIVISOR", 0)
            val resultado = 10 / divisor
            Log.d("MainActivity", "Resultado: $resultado")
        } catch (e: ArithmeticException) {
            Log.e("MainActivity", "Erro: divisão por zero!", e)
        }

        enableEdgeToEdge()
        setContent {
            HelloAndroidTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {

    val context = LocalContext.current

    // Guardar o texto introduzido pelo utilizador
    var text by remember {
        mutableStateOf("")
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = {
                Text("Digite a sua mensagem")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {

                // Mostrar Toast
                Toast.makeText(
                    context,
                    "Botão clicado!",
                    Toast.LENGTH_SHORT
                ).show()

                // Registar mensagem no Logcat
                Log.d(
                    "MainActivity",
                    "Utilizador digitou: $text"
                )

                // Criar Intent para abrir a segunda atividade
                val intent = Intent(
                    context,
                    DisplayMessageActivity::class.java
                )

                // Enviar mensagem para a segunda atividade
                intent.putExtra("EXTRA_MESSAGE", text)

                // Iniciar segunda atividade
                context.startActivity(intent)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Enviar")
        }
    }
}

@Composable
fun Toast(modifier: Modifier) {

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                Toast.makeText(context, "O botão foi clicado.", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text("Clique-me!")
        }
    }
}