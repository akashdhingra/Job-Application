package com.example.Job.Application.Job.impl;

import com.example.Job.Application.Job.Job;
import com.example.Job.Application.Job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs = new ArrayList<>();
    private Long id = 1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(id++);
        jobs.add(job);
    }

    @Override
    public Job getJobById(long id) {
        for (Job job:
             jobs) {
            if(job.getId() == id){
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean deleteJobById(long id) {
        Iterator<Job> iterator = jobs.iterator();
        while(iterator.hasNext()){
            Job job = iterator.next();
            if(job.getId().equals(id)){
                iterator.remove();
                return true;
            }
        }
        for (Job job:
             jobs) {
            if(job.getId().equals(id)){
                jobs.remove(job);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean UpdateJob(long id, Job updatedJob) {
        Iterator<Job> iterator = jobs.iterator();
        while(iterator.hasNext()){
            Job job = iterator.next();
            if(job.getId().equals(id)){
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setLocation(updatedJob.getLocation());
                return true;
            }

        }
        return false;
    }
}
