package Extensions

import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun ButtonDefaults.btnDefaults(
    backgroundColor: Color = Color.Unspecified,
    contentColor: Color = Color.Unspecified,
    disabledBackgroundColor: Color = Color.Unspecified,
    disabledContentColor: Color = Color.Unspecified,

    ): ButtonColors {
    return buttonColors(
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        disabledBackgroundColor = disabledBackgroundColor,
        disabledContentColor = disabledContentColor
    )
}