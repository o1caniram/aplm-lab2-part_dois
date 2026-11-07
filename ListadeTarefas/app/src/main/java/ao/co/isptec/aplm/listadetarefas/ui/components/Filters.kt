package ao.co.isptec.aplm.listadetarefas.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Arrangement
import ao.co.isptec.aplm.listadetarefas.enum.TaskFilter
import androidx.compose.ui.unit.dp
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text

@Composable
fun Filters(
    selectedFilter : TaskFilter,
    onFilterChange : (TaskFilter) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        FilterChip(
            selected = selectedFilter == TaskFilter.ALL,
            onClick = {
                onFilterChange(TaskFilter.ALL)
            },
            label = { Text("Todas") }
        )

        FilterChip(
            selected = selectedFilter == TaskFilter.PENDING,
            onClick = {
                onFilterChange(TaskFilter.PENDING)
            },
            label = { Text("Pendentes") }
        )

        FilterChip(
            selected = selectedFilter == TaskFilter.COMPLETED,
            onClick = {
                onFilterChange(TaskFilter.COMPLETED)
            },
            label = { Text("Concluídas") }
        )
    }
}