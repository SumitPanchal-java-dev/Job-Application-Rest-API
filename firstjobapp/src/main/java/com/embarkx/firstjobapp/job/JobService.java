package com.embarkx.firstjobapp.job;

import java.util.List;

public interface JobService {

	List<Job> findAll();
	void createJob(Job job);
	Job findJob(Integer id);
	boolean deleteJobById(Integer id);
	boolean updateById(Integer id, Job updatejob);
	
}
