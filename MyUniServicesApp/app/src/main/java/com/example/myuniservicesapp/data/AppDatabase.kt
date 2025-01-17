import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myuniservicesapp.data.RoomBookingDAO
import com.example.myuniservicesapp.data.entity.Booking

/**
 * Database class with a singleton Instance object.
 */
@Database(entities = [Room::class, Booking::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun roomBookingDAO(): RoomBookingDAO

    companion object {
        @Volatile
        private var Instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, AppDatabase::class.java, "app_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}