package screen.FieldDesign

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.mahmoudbashir.goscoreowner.ui.theme.AccentFont
import com.mahmoudbashir.goscoreowner.ui.theme.SecondaryColor

@Composable
fun FieldDesign(
    modifier: Modifier,
    fieldValue: TextFieldValue,
    label: String,
    placeholder: String,
    keyType: KeyboardType,
    isError: Boolean,
    backgroundColor:Color = SecondaryColor,
    visualTransformation: VisualTransformation? = null,
    textStyle: TextStyle = TextStyle(),
    isFocusableRequired: Boolean = false,
    singleLine: Boolean = true,
    trailingIcon: @Composable() () -> Unit,
    valueChanged: (TextFieldValue) -> Unit
){
    OutlinedTextField(
        modifier = modifier,
        value = fieldValue,
        textStyle = textStyle,
        label = {
            Text(
                modifier = Modifier.height(10.dp),
                text = label, style = TextStyle(
                    color = AccentFont
                )
            )
        },
        singleLine = singleLine,
        placeholder = {
            Text(
                text = placeholder, style = TextStyle(
                    color = AccentFont
                )
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType =
            keyType
        ),
        visualTransformation = visualTransformation ?: VisualTransformation.None,
        trailingIcon = trailingIcon,
        onValueChange = { value ->
            valueChanged(value)
        },
        isError = isError,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = AccentFont,
            backgroundColor = backgroundColor,
            focusedBorderColor = if (!isFocusableRequired) AccentFont else
                Color.Unspecified,
            unfocusedBorderColor = if (!isFocusableRequired) AccentFont else
                Color.Unspecified
        )
    )
}