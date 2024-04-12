package screen.home

import androidx.compose.runtime.mutableStateListOf
import cafe.adriel.voyager.core.model.ScreenModel
import local.DataSource
import kotlin.random.Random

class HomeViewModel(private val dataSource: DataSource): ScreenModel {

    private val dataList = mutableStateListOf<String>()


    fun addRandomToList(value:String) = dataSource.addRandomToList(value)

    fun getList() = dataSource.fetchData()

    override fun onDispose() {
        super.onDispose()
    }
}