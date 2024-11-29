package com.jobs.firstjobapp.Job.Impl;

import com.jobs.firstjobapp.Company.CompanyRepository;
import com.jobs.firstjobapp.Job.Job;
import com.jobs.firstjobapp.Job.JobRepository;
import com.jobs.firstjobapp.Job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
//    private List<Job> jobs = new ArrayList<Job>();
//    private int id = 1;

    JobRepository jobRepository;

    CompanyRepository companyRepository;

    public JobServiceImpl(JobRepository jobRepository, CompanyRepository companyRepository) {
        this.jobRepository = jobRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public boolean addJob(Job job) {
        if (companyRepository.existsById(job.getCompany().getId())) {
            jobRepository.save(job);
            return true;
        }
        return false;
    }

    @Override
    public Job findJobById(int id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(int id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJobById(int id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
                Job job = jobOptional.get();
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                jobRepository.save(job);
                return true;
        }
        return false;
    }


}
