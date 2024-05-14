package com.example.Job.Application.Job;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public List<Job> findAll(){
        return jobService.findAll();
    }

    @PostMapping("/jobs")
    public String findAll(@RequestBody Job job){
        jobService.createJob(job);
        return "Job Added";
    }
    @GetMapping("/jobs/{id}")
    public Job findJobById(@PathVariable long id){
        Job job = jobService.getJobById(id);
        if(job!=null){
            return job;
        }
        return new Job(1L,"Dummy title","Dummy Description",
                "20000","30000","Dummy Location");

    }
}
