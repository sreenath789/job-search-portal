# Job-Search-Portal
## Frameworks and languages used
###### SpringBoot

## Data Flow

### Controller
##### Job Controller
###### Iterable<Job> getAllJobs() --> get all getAllJobs ,String addMultipleJobs(List<Job> jobs) ---> add multiple jobs , Job SearchJobBySalary(Double salary) --> search get Job by salary , Job SearchJobByTitleAndDescription(String title,String description) --> search Job by title,description , Job SearchJobByLocation(String location) --> search job by location,String updateJob(int id,String location)-->update the job by location,deleteJobById(int id)-->delete the job


### Service
###### Job Service it is autowired in Controller so that it can perform required business logic

### Repository
###### 1.Job Repo this interface will extends crudRepository , It is autowired in Service application , it will save the data to database
###### It Contains Queries
###### @Query(value = "select * from Job where title=?1 and description=?2",nativeQuery = true) Iterable<Job> searchJobs(String title, String description);
###### @Query("select al from Job al where al.salary=?1") Iterable<Job> searchJobsBySalary(Double salary);
###### @Query("select al from Job al where al.location=?1") Iterable<Job> searchJobsByLocation(String location);
###### @Modifying @Transactional @Query("update Job al set al.title=?2 where al.id=?1") void updateJob(Long id, String title);
###### @Modifying @Transactional @Query("delete from Job al where al.id=?1") void deleteJobById(Long id);
### Model
###### Job Model
###### @Id private Long id;
###### private String title;
###### private String description;
###### private String location;
###### @Min(value=20001,message = "the salary should be greater than 20000") private Double salary;
###### private String companyEmail;
###### private String companyName;
###### private String employerName;
###### @Enumerated(EnumType.STRING) private JobType jobType;

##### JobType(Enum) which will have job types

#### application.properties
###### this contains properties which will connect the h2 database
###### spring.datasource.url=jdbc:h2:mem:h2db
###### spring.datasource.driverClassName=org.h2.Driver
###### spring.datasource.username=root
###### spring.datasource.password=7878
###### spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
###### spring.h2.console.enabled=true
###### spring.jpa.properties.hibernate.show_sql=true
###### spring.jpa.properties.hibernate.use_sql_comments=true
###### spring.jpa.properties.hibernate.format_sql=true


## Summary
###### Performing CRUD operations on Job Search Portal by using h2-Database
