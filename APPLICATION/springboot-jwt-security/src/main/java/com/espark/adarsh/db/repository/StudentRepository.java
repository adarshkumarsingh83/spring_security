package com.espark.adarsh.db.repository;

import com.espark.adarsh.db.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long>{
}
