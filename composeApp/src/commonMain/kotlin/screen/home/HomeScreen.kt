package screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen

class HomeScreen : Screen {

    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { HomeViewModel() }

        HomeScreenBody(viewModel)
    }
}

@Composable
fun HomeScreenBody(viewModel: HomeViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "ToDo App",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily.Default
                        )
                    )
                },
                backgroundColor = Color.Black,
                elevation = 5.dp,
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                backgroundColor = Color.Black,
                onClick = {
                    viewModel.addRandomToList()
                }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "add button",
                    tint = Color.White
                )
            }
        }
    ) {
        ContentList(viewModel)
    }
}


@Composable
fun ContentList(viewModel: HomeViewModel) {
    val mList = remember {
        mutableStateOf(viewModel.getList())
    }

    LazyColumn {
        items(mList.value) {
            SingleItem(it)
        }
    }
}

@Composable
fun SingleItem(title: String) {
    Card(
        modifier = Modifier.fillMaxWidth()
            .height(50.dp)
            .padding(all = 5.dp),
        backgroundColor = Color.LightGray,
        shape = RoundedCornerShape(3.dp)
    ) {
        Column {
            Text(
                title,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.Default
                )
            )
        }
    }
}

val fakeList = listOf("M1", "M2", "M3")