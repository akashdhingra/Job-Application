package com.example.Job.Application.Job;

import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> findAll(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job Added", HttpStatus.CREATED);
    }
    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> findJobById(@PathVariable long id){
        Job job = jobService.getJobById(id);
        if(job!=null){
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
