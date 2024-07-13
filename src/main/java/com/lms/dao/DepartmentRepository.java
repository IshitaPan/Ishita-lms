package com.lms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lms.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

    @Query(value= "Select * from department where name=:name",nativeQuery  =true)
    public Department findByName(@Param("name") String name);
    

   

    

    

}
