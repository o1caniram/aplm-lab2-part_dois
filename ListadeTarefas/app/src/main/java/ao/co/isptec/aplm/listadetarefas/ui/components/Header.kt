package ao.co.isptec.aplm.listadetarefas.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ao.co.isptec.aplm.listadetarefas.ui.theme.Dark
import ao.co.isptec.aplm.listadetarefas.ui.theme.Muted
import ao.co.isptec.aplm.listadetarefas.ui.theme.Purple

@Composable
fun Header() {
    Text(
        text = "NTF TASK",
        color = Purple,
        fontSize = 13.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = 3.sp
    )
    Spacer(modifier = Modifier.height(10.dp))
    Text(
        text = "Organiza o teu dia",
        color = Dark,
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold
    )
    Text(
        text = "Pequenos passos, grandes conquistas",
        color = Muted,
        fontSize = 14.sp
    )
}