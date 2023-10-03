import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class myViewModel : ViewModel() {
  var count by mutableStateOf(65)

  fun increaseCount() {
    count++
  }
}