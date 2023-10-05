package roomdbex

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_info")
data class User(
  @PrimaryKey(autoGenerate = true) val uid: Int = 0,
  @ColumnInfo(name = "name") val firstName: String?,
  @ColumnInfo(name = "blood_group") val bloodGroup: String?
)