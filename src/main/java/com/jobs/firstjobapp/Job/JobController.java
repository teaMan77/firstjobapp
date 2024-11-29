package com.jobs.firstjobapp.Job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    /*
    * get all jobs
    * */
    @GetMapping
    public ResponseEntity<List<Job>> findAll() {
        return ResponseEntity.ok(jobService.findAll());
    }

    /*
    create a job
     */
    @PostMapping
    public ResponseEntity<String> addJob(@RequestBody Job job) {
        return new ResponseEntity<>(jobService.addJob(job), HttpStatus.CREATED);
    }

    /*
    get job by specific id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Job> findJobById(@PathVariable int id) {
        Job job = jobService.findJobById(id);

        if (job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*
    delete a job by specific id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable int id) {
        boolean isDeleted = jobService.deleteJobById(id);

        if (isDeleted)
            return new ResponseEntity<>("Job deleted successfully!", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*
    update a job by specific id
     */
    @PutMapping("/{id}")
//    @RequestMapping(value = "/jobs/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateJobById(@PathVariable int id, @RequestBody Job updatedJob) {
        boolean isUpdated = jobService.updateJobById(id, updatedJob);

        if (isUpdated)
            return new ResponseEntity<>("Job Updated Successfully!", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
