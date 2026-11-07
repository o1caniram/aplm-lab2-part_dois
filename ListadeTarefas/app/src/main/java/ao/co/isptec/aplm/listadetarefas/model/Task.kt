package ao.co.isptec.aplm.listadetarefas.model

data class Task(
    val id: Long,
    val title: String,
    val isDone: Boolean = false
)