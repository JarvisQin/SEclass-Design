package ssm.dao;

import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Repository
public interface StudentDao {
    List<Student> getAllStudentList(StudentSearch search);
    Student getStudentBySIdAndDId(@Param("studentId") Integer studentId,
                                  @Param("dormitoryId") Integer dormitoryId);
    List<Student> getAllStudent();
    Student getStudentByStudentname(String username);
    void addStudent(Student student);
    List<Student> getStudentByClassId(Integer classId);
    List<Student> getStudentByDormitoryId(Integer dormitoryId);
    void deleteStudentById(int studentId);
    Student getStudentById(int studentId);
    void updateStudent(Student student);
}
