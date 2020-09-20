package platformpbp.uajy.yehezkielyoel.ugd4_9802_e;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Employee implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "full_name")
    public String fullName;
    @ColumnInfo(name = "number")
    public int number;
    @ColumnInfo(name = "age")
    public int age;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int number){
        this.number=number;
    }

    public String getStringNumber(){
        return String.valueOf(number);
    }

    public void setStringNumber(String number){
        this.number= Integer.parseInt(number);
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age=age;
    }

    public String getStringAge() {
        return String.valueOf(age);
    }

    public void setStringAge(String age) {
        if(!age.isEmpty()){
            this.age = Integer.parseInt(age);
        }else{
            this.age = 0;
        }
    }
}
