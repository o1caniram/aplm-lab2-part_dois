package ao.co.isptec.aplm.listadetarefas.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp
import ao.co.isptec.aplm.listadetarefas.ui.theme.Purple
import androidx.compose.ui.graphics.Color

@Composable
fun TextField(text : String, onTextChange: (String) -> Unit) {
    OutlinedTextField(
        value = text,
        onValueChange = { onTextChange(it)},
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            Text("O que precisas fazer?")
        },
        singleLine = true,
        shape = RoundedCornerShape(16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Purple,
            unfocusedBorderColor = Color(0xFFE3E0F0),
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White

        )
    )
}