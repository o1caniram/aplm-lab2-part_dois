package ao.co.isptec.aplm.listadetarefas.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ao.co.isptec.aplm.listadetarefas.ui.theme.Dark
import ao.co.isptec.aplm.listadetarefas.ui.theme.Muted
import ao.co.isptec.aplm.listadetarefas.ui.theme.Purple

@Composable
fun EmptyTasks() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 35.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "✒\uFE0F",
            fontSize = 40.sp,
            color = Purple
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Tudo tranquilo por aqui!",
            color = Dark,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Adiciona uma tarefa para começar.",
            color = Muted,
            fontSize = 13.sp
        )
    }
}