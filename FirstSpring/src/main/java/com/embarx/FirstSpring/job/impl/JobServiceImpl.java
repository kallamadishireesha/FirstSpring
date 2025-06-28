package com.embarx.FirstSpring.job.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.embarx.FirstSpring.job.Job;
import com.embarx.FirstSpring.job.JobService;

@Service
public class JobServiceImpl implements JobService{

    private List<Job> jobs = new ArrayList<>();
    @Override
    public void createJob(Job job) {
        jobs.add(job);
        
    }

    @Override
    public List<Job> findAll() {
        // TODO Auto-generated method stub
        return jobs;
    }

    @Override
    public Job getJobById(Integer id) {
        // TODO Auto-generated method stub
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                return job;
                
            }
        }
        return null;
    }

    @Override
    public boolean deleteJobById(Integer id) {
        Iterator<Job> iterator = jobs.iterator();
        while(iterator.hasNext()) {
            Job job = iterator.next();
            if(job.getId().equals(id)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateJob(Integer id, Job updateJob) {
        for(Job job: jobs){
            if(job.getId().equals(id)) {
                job.setName(updateJob.getName());
                job.setDescription(updateJob.getDescription());
                job.setLocation(updateJob.getLocation());
                return true;
            }
        }
        return false;
    }
    
}
