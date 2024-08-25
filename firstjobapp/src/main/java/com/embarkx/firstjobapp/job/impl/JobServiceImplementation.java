package com.embarkx.firstjobapp.job.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.embarkx.firstjobapp.job.Job;
import com.embarkx.firstjobapp.job.JobRepository;
import com.embarkx.firstjobapp.job.JobService;

@Service
public class JobServiceImplementation implements JobService {

	// private List<Job> jobs = new ArrayList<>();
	private Integer nextid = 1;
	JobRepository jobrepo;

	public JobServiceImplementation(JobRepository jobrepo) {
		this.jobrepo = jobrepo;
	}

	@Override
	public List<Job> findAll() {

		return jobrepo.findAll();

	}

	@Override
	public void createJob(Job job) {
		job.setId(nextid++);
		jobrepo.save(job);
	}

	@Override
	public Job findJob(Integer id) {
		return jobrepo.findById(id).orElse(null);
	}

	@Override
	public boolean deleteJobById(Integer id) {
		jobrepo.deleteById(id);
		return true;
	}

	@Override
	public boolean updateById(Integer id, Job updatejob) {
		Optional<Job> joboptional = jobrepo.findById(id);
			if (joboptional.isPresent()) {
				Job job = joboptional.get(); 
				job.setTitle(updatejob.getTitle());
				job.setDescription(updatejob.getDescription());
				job.setMinsalary(updatejob.getMinsalary());
				job.setMaxsalary(updatejob.getMaxsalary());
				job.setLocation(updatejob.getLocation());
				jobrepo.save(job);
				return true;
			}
			return false;
		

	}

}
