package com.embarx.FirstSpring.job;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {
    private JobService jobService;

    // this constructor links the service and the controller
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    //private List<Job> jobs = new ArrayList<>();
    // @GetMapping("/jobs")
    // public List<Job> findAll(){
    //     return jobService.findAll();
    //         // return jobs;

    // }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
            // return jobs;

    }

    // @PostMapping("/jobs")
    // public String createJob(@RequestBody Job job){
    //     jobService.createJob(job);
    //     //jobs.add(job);
    //     return "job created successfully";

    // }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        //jobs.add(job);
        return new ResponseEntity<>("job created successfully", HttpStatus.OK);

    }

    // @GetMapping("/jobs/{id}")
    // public Job getJobById(@PathVariable Integer id){
    //     Job job = jobService.getJobById(id);
    //     if (job != null) {
    //         return job; 
    //     }
    //     else {
    //         return new Job(12, "ic2", "this is ic2 role", "hyderabad");
    //     }
        

    // }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Integer id){
        Job job = jobService.getJobById(id);
        if (job != null) {
            return new ResponseEntity<>(job, HttpStatus.OK); 
        }
        return new ResponseEntity<>(job, HttpStatus.NOT_FOUND); 
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> destroyJob(@PathVariable Integer id){
        boolean deleted = jobService.deleteJobById(id);
        if (deleted) {
            return new ResponseEntity<>("Destroyed Successfully", HttpStatus.OK); 
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Integer id, @RequestBody Job updateJob){
        boolean updated = jobService.updateJob(id, updateJob);
        if (updated) {
            return new ResponseEntity<>("Updated Successfully", HttpStatus.OK); 
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
    }
    
}
