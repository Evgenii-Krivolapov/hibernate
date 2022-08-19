package database;
import keys.KeyPurchasesList;

import javax.persistence.*;

@Entity
@Table(name= "purchaselist")
public class Purchase {

    @EmbeddedId
    private KeyPurchasesList key;

    @Column(name = "student_name", updatable = false, insertable = false, nullable = true)
    private String students;

    @Column(name = "course_name", updatable = false, insertable = false, nullable = true)
    private String curses;

    public Purchase() {}

    public Purchase(String students, String curses) {
        this.students = students;
        this.curses = curses;
    }

    public String getStudents() {
        return students;
    }

    public void setStudents(String students) {
        this.students = students;
    }

    public String getCurses() {
        return curses;
    }

    public void setCurses(String curses) {
        this.curses = curses;
    }

    public KeyPurchasesList getKey() {
        return key;
    }

    public void setKey(KeyPurchasesList key) {
        this.key = key;
    }
}
