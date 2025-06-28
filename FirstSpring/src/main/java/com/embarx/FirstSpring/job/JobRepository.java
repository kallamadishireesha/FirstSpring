package com.embarx.FirstSpring.job;

import org.springframework.data.jpa.repository.JpaRepository;
// <Entity_type, primary_key>
public interface JobRepository extends JpaRepository<Job, Integer>{
    
}
