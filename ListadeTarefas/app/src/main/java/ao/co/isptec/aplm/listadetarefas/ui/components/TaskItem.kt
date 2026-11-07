package ao.co.isptec.aplm.listadetarefas.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ao.co.isptec.aplm.listadetarefas.model.Task
import ao.co.isptec.aplm.listadetarefas.ui.theme.Dark
import ao.co.isptec.aplm.listadetarefas.ui.theme.Muted
import ao.co.isptec.aplm.listadetarefas.ui.theme.Purple

@Composable
fun TaskItem(
    task: Task,
    onCheckedChange: (Boolean) -> Unit,
    onDelete: () -> Unit
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = task.isDone,
                onCheckedChange = onCheckedChange,
                colors = CheckboxDefaults.colors(
                    checkedColor = Purple
                )
            )

            Text(
                text = task.title,
                modifier = Modifier.weight(1f),
                fontSize = 15.sp,
                color = if (task.isDone) Muted else Dark,
                textDecoration = if (task.isDone) {
                    TextDecoration.LineThrough
                } else {
                    TextDecoration.None
                }
            )

            TextButton(
                onClick = onDelete
            ) {
                Text(
                    text = "Eliminar",
                    color = Color(0xFFE36C79),
                    fontSize = 12.sp
                )
            }
        }
    }
}