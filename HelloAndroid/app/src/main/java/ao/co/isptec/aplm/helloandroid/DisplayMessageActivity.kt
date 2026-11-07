
package ao.co.isptec.aplm.helloandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ao.co.isptec.aplm.helloandroid.ui.theme.HelloAndroidTheme
import ao.co.isptec.aplm.helloandroid.model.PalavraBundle
import ao.co.isptec.aplm.helloandroid.model.gerarResumo

class DisplayMessageActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Exceção
            var erro = 0/0

        // Recuperar a mensagem enviada pela MainActivity
        val message = intent.getStringExtra("EXTRA_MESSAGE") ?: ""


        val words = message?.split(" ") ?: listOf()
        val wordCount = words.size

        val summary = when {
            wordCount == 0 -> "Nenhuma palavra encontrada!"
            wordCount == 1 -> "Apenas uma palavra!"
            else -> "Foram digitadas $wordCount palavras."
        }

        val bundle = PalavraBundle(words)

        setContent {
            HelloAndroidTheme {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "Mensagem recebida:",
                        style = MaterialTheme.typography.titleLarge
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = message,
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = summary,
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = gerarResumo(bundle),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}




