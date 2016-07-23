package hu.schonherz.training.jdbc;

import hu.schonherz.training.jdbc.dao.StudentDao;
import hu.schonherz.training.jdbc.records.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ikant on 2016. 07. 23..
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-config.xml");
        StudentDao dao = applicationContext.getBean("JDBCTempateStudentDAOImpl", StudentDao.class);
//        StudentDao dao = applicationContext.getBean("studentDaoImpl", StudentDao.class);
        dao.addStudent(new Student(1, "rwar", "2342342"));

        Student student = dao.getStudent("rwar");

        System.out.println(student);
    }
}
