package platformpbp.uajy.yehezkielyoel.ugd4_9802_e;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EmployeeDAO {
    @Query("SELECT * FROM employee")
    List<Employee> getAll();

    @Insert
    void insert(Employee employee);

    @Update
    void update(Employee employee);

    @Delete
    void delete(Employee employee);
}
