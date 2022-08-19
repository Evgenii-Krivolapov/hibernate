import database.*;
import keys.KeyLinkedPurchaseList;
import org.hibernate.*;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Purchase> query = builder.createQuery(Purchase.class);
        Root<Purchase> root = query.from(Purchase.class);
        query.select(root);
        List<Purchase> purchase = session.createQuery(query).getResultList();
        newDatabase(session, sessionFactory, transaction, purchase);
    }

    public static void newDatabase(Session session, SessionFactory sessionFactory, Transaction transaction, List<Purchase> purchase) {
        List<Courses> coursesId = new ArrayList<>();
        List<Students> studentId = new ArrayList<>();
        for (Purchase purchaseList : purchase) {
            String idCourses = "From " + Courses.class.getSimpleName() + " Where name = '" + purchaseList.getCurses() + "'";
            String idStudents = "From " + Students.class.getSimpleName() + " Where name = '" + purchaseList.getStudents() + "'";
            List<Courses> courses = session.createQuery(idCourses).getResultList();
            List<Students> students = session.createQuery(idStudents).getResultList();
            coursesId.add(courses.get(0));
            studentId.add(students.get(0));
        }
        for (int i = 0; i < coursesId.size(); i++) {
            KeyLinkedPurchaseList key = new KeyLinkedPurchaseList();
            key.setCourseId(coursesId.get(i).getId());
            key.setStudentId(studentId.get(i).getId());
            LinkedPurchaseList list = new LinkedPurchaseList();
            list.setId(key);
            session.save(list);
        }
        transaction.commit();
        sessionFactory.close();
    }
}