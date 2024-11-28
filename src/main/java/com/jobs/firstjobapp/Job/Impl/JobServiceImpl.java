package com.jobs.firstjobapp.Job.Impl;

import com.jobs.firstjobapp.Job.Job;
import com.jobs.firstjobapp.Job.JobService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<Job>();
    private int id = 1;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public String addJob(Job job) {
        job.setId(id++);
        jobs.add(job);
        return "Job added successfully!";
    }

    @Override
    public Job findJobById(int id) {
        for (Job job : jobs) {
            if (job.getId() == id) {
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean deleteJobById(int id) {
        for (Job job : jobs) {
            if (job.getId() == id) {
                jobs.remove(job);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateJobById(int id, Job updatedJob) {
        for (Job job : jobs) {
            if (job.getId() == id) {
//                BeanUtils.copyProperties(updatedJob, job);
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                return true;
            }
        }
        return false;
    }


}
