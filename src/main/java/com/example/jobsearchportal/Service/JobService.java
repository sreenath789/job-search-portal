package com.example.jobsearchportal.Service;

import com.example.jobsearchportal.Model.Job;
import com.example.jobsearchportal.Repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    JobRepo jobRepo;

    public Iterable<Job> getAllJobs() {
        return jobRepo.findAll();
    }

    public Iterable<Job> searchJobs(String title, String description) {
        return jobRepo.searchJobs(title,description);
    }

    public Iterable<Job> searchJobsBySalary(Double salary) {
        return jobRepo.searchJobsBySalary(salary);
    }

    public Iterable<Job> searchJobsByLocation(String location) {
        return jobRepo.searchJobsByLocation(location);
    }

    public String addAllJobs(List<Job> listOfJobs) {
        jobRepo.saveAll(listOfJobs);
        return "Multiple Jobs Added";
    }

    public String updateJob(Long id, String title) {
        Optional<Job> optionalJob = jobRepo.findById(id);
        if(optionalJob.isPresent()){
            jobRepo.updateJob(id,title);
            return "Updated";
        }
        else{
            return "Id not found";
        }
    }

    public String deleteJob(Long id) {
        Optional<Job> optionalJob = jobRepo.findById(id);
        if(optionalJob.isPresent()){
            jobRepo.deleteJobById(id);
            return "Deleted";
        }
        else{
            return "Id not found";
        }
    }
}
