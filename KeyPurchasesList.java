package keys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class KeyPurchasesList implements Serializable {

    @Column(name = "student_name", updatable = false, insertable = false, nullable = true)
    private String students;

    @Column(name = "course_name", updatable = false, insertable = false, nullable = true)
    private String curses;

    public KeyPurchasesList() {}

    public KeyPurchasesList(String students, String curses) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyPurchasesList that = (KeyPurchasesList) o;
        return Objects.equals(students, that.students) && Objects.equals(curses, that.curses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(students, curses);
    }
}
