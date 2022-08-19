package database;
import keys.KeyLinkedPurchaseList;

import javax.persistence.*;

@Entity
@Table(name = "linked_purchase_list")
public class LinkedPurchaseList {

    @EmbeddedId
    private KeyLinkedPurchaseList id;

    @Column(name = "student_id", updatable = false, insertable = false, nullable = true)
    private int students;

    @Column(name = "course_id", updatable = false, insertable = false, nullable = true)
    private int courses;

    public LinkedPurchaseList() {}

    public LinkedPurchaseList(int students, int courses) {
        this.students = students;
        this.courses = courses;
    }

    public KeyLinkedPurchaseList getId() {
        return id;
    }

    public void setId(KeyLinkedPurchaseList id) {
        this.id = id;
    }

    public int getStudents() {
        return students;
    }

    public void setStudents(int students) {
        this.students = students;
    }

    public int getCourses() {
        return courses;
    }

    public void setCourses(int courses) {
        this.courses = courses;
    }
}
