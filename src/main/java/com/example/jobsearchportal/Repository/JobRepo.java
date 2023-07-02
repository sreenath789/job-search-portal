package com.example.jobsearchportal.Repository;

import com.example.jobsearchportal.Model.Job;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends CrudRepository<Job,Long> {
    @Query(value = "select * from Job where title=?1 and description=?2",nativeQuery = true)
    Iterable<Job> searchJobs(String title, String description);

    @Query("select al from Job al where al.salary=?1")
    Iterable<Job> searchJobsBySalary(Double salary);

    @Query("select al from Job al where al.location=?1")
    Iterable<Job> searchJobsByLocation(String location);

    @Modifying
    @Transactional
    @Query("update Job al set al.title=?2 where al.id=?1")
    void updateJob(Long id, String title);

    @Modifying
    @Transactional
    @Query("delete from Job al where al.id=?1")
    void deleteJobById(Long id);
}
