package ao.co.isptec.aplm.listadetarefas.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ao.co.isptec.aplm.listadetarefas.model.Task
import androidx.compose.foundation.layout.ColumnScope

@Composable
fun ColumnScope.TaskList(
    visibleTasks : List<Task>,
    onCheckedChange : (Task, Boolean) -> Unit,
    onDeleted: (Task) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth().weight(1f),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {

        if (visibleTasks.isEmpty()) {

            item {
                EmptyTasks()
            }

        } else {

            items(
                items = visibleTasks,
                key = { it.id }
            ) { task ->

                TaskItem(
                    task = task,
                    onCheckedChange = { checked ->
                        onCheckedChange(task, checked)
                    },
                    onDelete = {
                        onDeleted(task)
                    }
                )
            }
        }
    }
}