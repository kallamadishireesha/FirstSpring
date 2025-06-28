package com.embarx.FirstSpring.job.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.embarx.FirstSpring.job.Job;
import com.embarx.FirstSpring.job.JobRepository;
import com.embarx.FirstSpring.job.JobService;

@Service
public class JobServiceImpl implements JobService{

    // private List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
        
    }

    @Override
    public List<Job> findAll() {
        // TODO Auto-generated method stub
        return jobRepository.findAll();
    }

    @Override
    public Job getJobById(Integer id) {
        // TODO Auto-generated method stub
        
                return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Integer id) {
        try { jobRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateJob(Integer id, Job updateJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
            if(jobOptional.isPresent()) {
                Job job = jobOptional.get();
                job.setName(updateJob.getName());
                job.setDescription(updateJob.getDescription());
                job.setLocation(updateJob.getLocation());
                return true;
            }
        return false;
    }
    
}
