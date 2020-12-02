package com.example.StudentSpringBoot.repository;

import com.example.StudentSpringBoot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface StudentRepo extends JpaRepository<Student,Integer>
{
    public Student findByStdIdAndStdPass(int stdId,String stdPa);
    @Transactional
    @Modifying   //write these two annotation whenever your data in the db will change
    @Query("update Student s set s.stdPass=:pass where s.stdId=:id")
    public void changePassword(@Param("id")int id,@Param("pass")String pass);
    //name of parameter must match with name of local variable
}
//html form data is to be read and use in controller use  @RequestParam
// from controller to repo we use @Param