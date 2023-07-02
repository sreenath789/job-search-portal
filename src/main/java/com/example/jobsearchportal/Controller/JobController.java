package com.example.jobsearchportal.Controller;

import com.example.jobsearchportal.Model.Job;
import com.example.jobsearchportal.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("job")
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping("getAllJobs")
    public Iterable<Job> getAllJobs(){
        return jobService.getAllJobs();
    }

    @GetMapping("searchJobs/{title}/{description}")
    public Iterable<Job> searchJobs(@PathVariable String title,@PathVariable String description){
        return jobService.searchJobs(title,description);
    }

    @GetMapping("searchJobsBySalary/{salary}")
    public Iterable<Job> searchJobsBySalary(@PathVariable Double salary){
        return jobService.searchJobsBySalary(salary);
    }

    @GetMapping("searchJobsByLocation/{location}")
    public Iterable<Job> searchJobsByLocation(@PathVariable String location){
        return jobService.searchJobsByLocation(location);
    }

    @PostMapping("addAllJobs")
    public String addAllJobs(@RequestBody List<Job> listOfJobs){
        return jobService.addAllJobs(listOfJobs);
    }

    @PutMapping("updateJob/{id}/{title}")
    public String updateJob(@PathVariable Long id,@PathVariable String title){
        return jobService.updateJob(id,title);
    }

    @DeleteMapping("deleteJob/{id}")
    public String deleteJob(@PathVariable Long id){
        return jobService.deleteJob(id);
    }



}
