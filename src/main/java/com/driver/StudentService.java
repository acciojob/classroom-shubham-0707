package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudentService(Student student){
        studentRepository.addStudentToDB(student);
    }

    public void addTeacherService(Teacher teacher){
        studentRepository.addTeacherToDB(teacher);
    }

    public void addStudentTeacherToDB(String teacher , String student){
        studentRepository.addStudentTeacherToDB(teacher , student);
    }

    public Student getStudentService(String name){
        return studentRepository.getStudentFromDB(name);
    }

    public Teacher getTeacherService(String name){
        return studentRepository.getTeacherFromDB(name);
    }

    public List<String> getStudentFromTeacherService(String name){
        return studentRepository.getStudentsFromTeacherName(name);
    }

    public List<String> getAllTheStudentsService(){
        return studentRepository.getAllTheStudentsFromDb();
    }

    public void deleteATeacherStudentsService(String name){
        studentRepository.deleteATeacherStudentsFromDB(name);
    }

    public void deleteAllTeachersWithStudentsService(){
        studentRepository.deleteAllStudentsOfAllTeachers();
    }

}
