package platformpbp.uajy.yehezkielyoel.ugd4_9802_e;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Employee.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract EmployeeDAO userDao();
}
