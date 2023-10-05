package roomdbex

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
  @Query("SELECT * FROM user_info")
  suspend fun getUserInfo(): List<User>?

  @Insert
  suspend fun insertUserInfo(user: User)

  @Update
  suspend fun updateUserInfo(user: User)

  @Query("DELETE FROM user_info WHERE uid = :uid")
  suspend fun deleteUserInfo(uid: Int)

}