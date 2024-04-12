package local

import androidx.compose.runtime.mutableStateListOf
import kotlin.math.absoluteValue
import kotlin.random.Random

class DataSource {

    private val dataList = mutableStateListOf<String>()

    fun addRandomToList(value:String){
       /* val randomValue = Random.nextInt().absoluteValue
        val result = "M$randomValue"*/
        dataList.add(value)
    }

    fun fetchData():MutableList<String>{
        return dataList
    }
}