package ao.co.isptec.aplm.listadetarefas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ao.co.isptec.aplm.listadetarefas.enum.TaskFilter
import ao.co.isptec.aplm.listadetarefas.model.Task
import ao.co.isptec.aplm.listadetarefas.ui.components.Filters
import ao.co.isptec.aplm.listadetarefas.ui.components.Header
import ao.co.isptec.aplm.listadetarefas.ui.components.PrimaryButton
import ao.co.isptec.aplm.listadetarefas.ui.theme.*
import ao.co.isptec.aplm.listadetarefas.ui.components.ProgressCard
import ao.co.isptec.aplm.listadetarefas.ui.components.TaskList
import ao.co.isptec.aplm.listadetarefas.ui.components.TextField
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                ListaDeTarefasApp()
            }
        }
    }
}

@Composable
fun ListaDeTarefasApp() {

    val snackbarHostState = remember {
        SnackbarHostState()
    }
    val scope = rememberCoroutineScope()

    val taskList = remember {
        mutableStateListOf<Task>()
    }

    var text by remember {
        mutableStateOf("")
    }

    var nextId by remember {
        mutableLongStateOf(1L)
    }

    var selectedFilter by remember {
        mutableStateOf(TaskFilter.ALL)
    }

    var completed = taskList.count { it.isDone }
    val total = taskList.size

    val progress = if (total == 0) {
        0f
    } else {
        completed.toFloat() / total
    }

    val visibleTasks = when (selectedFilter) {
        TaskFilter.ALL -> taskList.toList()
        TaskFilter.PENDING -> taskList.filter { !it.isDone }
        TaskFilter.COMPLETED -> taskList.filter { it.isDone }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Background,
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Header()
            Spacer(modifier = Modifier.height(24.dp))
            ProgressCard(completed, total, progress)
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Nova tarefa",
                color = Dark,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(text) { text = it}
            Spacer(modifier = Modifier.height(10.dp))
            PrimaryButton(
                onClick = {
                    val newTask = text.trim()

                    if (newTask.isEmpty()) {
                        scope.launch {
                            snackbarHostState.currentSnackbarData?.dismiss()
                            snackbarHostState.showSnackbar(
                                message = "Por favor, escreve o nome da tarefa."
                            )
                        }
                    } else if (taskList.any { it.title.equals(newTask, ignoreCase = true) }) {
                        scope.launch {
                            snackbarHostState.currentSnackbarData?.dismiss()
                            snackbarHostState.showSnackbar(
                                message = "Esta tarefa já existe!"
                            )
                        }
                    } else {
                        taskList.add(
                            Task(
                                id = nextId++,
                                title = newTask
                            )
                        )
                        text = ""
                        scope.launch {
                            snackbarHostState.currentSnackbarData?.dismiss()
                            snackbarHostState.showSnackbar(
                                message = "Tarefa adicionada com sucesso!"
                            )
                        }
                    }
                }
            )
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "As minhas tarefas",
                    color = Dark,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold
                )

                TextButton(
                    onClick = {
                        if (taskList.isEmpty()) {
                            scope.launch {
                                snackbarHostState.currentSnackbarData?.dismiss()
                                snackbarHostState.showSnackbar(
                                    message = "Não há tarefas para limpar!"
                                )
                            }
                        } else {
                            taskList.clear()
                            scope.launch {
                                snackbarHostState.currentSnackbarData?.dismiss()
                                snackbarHostState.showSnackbar(
                                    message = "Todas as tarefas foram removidas!"
                                )
                            }
                        }
                    }
                ) {
                    Text(
                        text = "Limpar todas",
                        color = if (taskList.isNotEmpty()) Danger else Muted,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Filters(
                selectedFilter = selectedFilter,
                onFilterChange = { selectedFilter = it }
            )
            Spacer(modifier = Modifier.height(12.dp))
            TaskList(
                visibleTasks = visibleTasks,
                onCheckedChange = { task, checked ->
                    val index = taskList.indexOfFirst {
                        it.id == task.id
                    }

                    if(index != -1) {
                        taskList[index] = taskList[index].copy(
                            isDone = checked
                        )
                    }
                },
                onDeleted = { task ->
                    taskList.removeAll {
                        it.id == task.id
                    }
                    scope.launch {
                        snackbarHostState.currentSnackbarData?.dismiss()
                        snackbarHostState.showSnackbar(
                            message = "Tarefa removida com sucesso!"
                        )
                    }
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "codename o1caniram",
                color = Dark,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

