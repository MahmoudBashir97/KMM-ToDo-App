package screen.Dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.mahmoudbashir.goscoreowner.ui.theme.AccentFont
import com.mahmoudbashir.goscoreowner.ui.theme.DarkColor
import com.mahmoudbashir.goscoreowner.ui.theme.YellowColor
import screen.FieldDesign.FieldDesign

@Composable
fun ShowInputDialog(
    title: String,
    message: String? = null,
    fieldInputValue: MutableState<String>,
    showDialog: MutableState<Boolean>,
    onConfirmClicked: () -> Unit = {},
) {
    if (showDialog.value) InputDialogContent(title, message, fieldInputValue, setShowDialog = {
        showDialog.value = it
    }) {
        onConfirmClicked()
        showDialog.value = false
    }
}

@Composable
fun InputDialogContent(
    title: String? = null,
    message: String? = null,
    fieldInputValue: MutableState<String>,
    setShowDialog: (Boolean) -> Unit = {},
    onConfirmClicked: () -> Unit = {},
) {

    Dialog(
        onDismissRequest = { setShowDialog(false) },
        properties = DialogProperties(
            dismissOnClickOutside = false
        ),
    ) {
        Surface(
            shape = RoundedCornerShape(13.dp), color = DarkColor
        ) {
            Spacer(Modifier.height(10.dp))
            Box(contentAlignment = Alignment.Center) {
                Column(
                    modifier = Modifier.width(280.dp).wrapContentHeight().padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
                        text = title ?: "",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 14.sp, fontWeight = FontWeight.W700, color = AccentFont
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
                        maxLines = 1,
                        textAlign = TextAlign.Center,
                        text = message ?: "",
                        style = TextStyle(
                            fontSize = 11.sp, fontWeight = FontWeight.W400, color = AccentFont
                        ),
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    FieldInputContent(title = fieldInputValue) {
                        fieldInputValue.value = it.text
                    }
                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = onConfirmClicked,
                        modifier = Modifier.height(50.dp).width(258.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = YellowColor
                        )
                    ) {
                        Text(
                            text = "Ok", style = TextStyle(
                                fontSize = 13.sp, fontWeight = FontWeight.W600, color = DarkColor
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    }
}

@Composable
fun FieldInputContent(
    title: MutableState<String>, onValueChanged: (value: TextFieldValue) -> Unit
) {
    var textValue by remember {
        mutableStateOf(TextFieldValue(title.value))
    }
    FieldDesign(modifier = Modifier.fillMaxWidth().height(60.dp),
        fieldValue = textValue,
        label = "",
        placeholder = "Enter your task",
        keyType = KeyboardType.Text,
        isError = false,
        trailingIcon = {},
        valueChanged = {
            title.value = it.text
            textValue = it
            onValueChanged(it)
        })

}