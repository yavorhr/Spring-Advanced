package bg.softuni.student;

import java.util.List;

public class StudentService implements StudentServiceIfc{

  @Cacheable("students")
  @Override
  public List<Student> getAllStudents() {
    System.out.println("Calculating students....");

    try {
      // in reality do something slow and complicated here,
      // e.g. pull the students via REST from a remote service.
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      Thread.interrupted();
    }

    return List.of(
        new Student("Pehso", 21),
        new Student("Anna", 31)
    );
  }
}
