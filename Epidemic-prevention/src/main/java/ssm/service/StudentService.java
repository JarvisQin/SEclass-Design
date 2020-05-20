package ssm.service;

import ssm.util.ResultUtil;

public interface StudentService {

    ResultUtil getAllStudentList(Integer page, Integer limit, StudentSearch search);



    Student getStudentByStudentname(String username);
    void addStudent(Student student);


    ResultUtil deleteStudentById(int studentId);
    Student getStudentById(int studentId);
    ResultUtil updateStudent(Student student);
}
