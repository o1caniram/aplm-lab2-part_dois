package ao.co.isptec.aplm.listadetarefas.ui.components

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text

@Composable
fun PrimaryButton(
    onClick: () -> Unit
) {
    Button(
        onClick = onClick
    ) {
        Text(
            text = "+ Adicionar Tarefa",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}