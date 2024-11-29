package com.jobs.firstjobapp.Job;

import java.util.List;

public interface JobService {

    public List<Job> findAll();

    public boolean addJob(Job job);

    public Job findJobById(int id);

    public boolean deleteJobById(int id);

    boolean updateJobById(int id, Job updatedJob);
}
