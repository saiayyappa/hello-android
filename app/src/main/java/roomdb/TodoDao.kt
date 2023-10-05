package roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {

  @Insert
  suspend fun d(item: TodoItem)

  @Query("SELECT * FROM todo")
  suspend fun getUsers(): List<TodoItem>

}