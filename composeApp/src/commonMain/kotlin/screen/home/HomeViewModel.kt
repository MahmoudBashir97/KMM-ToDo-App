package screen.home

import androidx.compose.runtime.mutableStateListOf
import cafe.adriel.voyager.core.model.ScreenModel
import kotlin.random.Random

class HomeViewModel : ScreenModel {

    private val dataList = mutableStateListOf<String>()


    fun addRandomToList(){
        val randomValue = Random.nextInt()
        val result = "M$randomValue"
        dataList.add(result)
        println("dataListSize : ${dataList.size}")
    }

    fun getList() = dataList

    override fun onDispose() {
        super.onDispose()
    }
}