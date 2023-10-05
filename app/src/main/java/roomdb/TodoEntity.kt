package roomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "todo")
data class TodoItem(
  @PrimaryKey(autoGenerate = true)
  var itemId: Int = 0,

  @ColumnInfo(name = "item_name")
  val itemName: String,

  @ColumnInfo(name = "item_desc")
  val itemDesc: String,

  @ColumnInfo(name = "is_completed")
  var isDone: Boolean = false
)