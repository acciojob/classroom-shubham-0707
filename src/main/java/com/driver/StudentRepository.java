package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Repository
public class StudentRepository {

    Map<String , Student> student_map = new HashMap<>();
    Map<String , Teacher> teacherMap = new HashMap<>();
    Map<String , List<String>> teacher_student_map = new HashMap<>();

    public void addStudentToDB(Student student){
        student_map.put(student.getName() , student);
    }

    public void addTeacherToDB(Teacher teacher){
        teacherMap.put(teacher.getName() , teacher);
    }

    public void addStudentTeacherToDB(String teacher , String student){
        List<String> temp = teacher_student_map.get(teacher);
        if(temp==null){
            temp = new ArrayList<>();
            temp.add(student);
            teacher_student_map.put(teacher , temp);
        }
        else{
            temp.add(student);
        }
    }

    public Student getStudentFromDB(String name){
        return student_map.get(name);
    }

    public Teacher getTeacherFromDB(String name){
        return teacherMap.get(name);
    }

    public List<String> getStudentsFromTeacherName(String name){
        List<String> ans = new ArrayList<>();
        if(teacherMap.containsKey(name)){
            return teacher_student_map.get(name);
        }
        return ans;
    }


    public List<String> getAllTheStudentsFromDb(){
        List<String> ans = new ArrayList<>();

        for(String name : student_map.keySet()){
            ans.add(name);
        }

        return ans;
    }

    public void deleteATeacherStudentsFromDB(String name){
        if(teacher_student_map.containsKey(name)){
            List<String> students = teacher_student_map.get(name);
            for(String names : students){
                if(student_map.containsKey(names)){
                    student_map.remove(names);
                }
            }
            teacher_student_map.remove(name);
        }

        if(teacherMap.containsKey(name)){
            teacherMap.remove(name);
        }
    }

    public void deleteAllStudentsOfAllTeachers(){
        for(String str : teacher_student_map.keySet()){
            List<String> temp = teacher_student_map.get(str);
            for(String st : temp){
                if(student_map.containsKey(st)){
                    student_map.remove(st);
                }
            }
        }
        teacher_student_map.clear();
        teacherMap.clear();
    }

}
