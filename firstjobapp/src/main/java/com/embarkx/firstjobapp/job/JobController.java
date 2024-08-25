package com.embarkx.firstjobapp.job;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {

	private JobService jobService;

	public JobController(JobService jobService) {
		this.jobService = jobService;
	}

	@GetMapping("/jobs")
	public List<Job> findAll() {
		return jobService.findAll();
	}

	@GetMapping("/jobs/{id}")
	public Job findJob(@PathVariable Integer id) {
		return jobService.findJob(id);
	}

	@PostMapping("/jobs")
	public String createJob(@RequestBody Job job) {
		jobService.createJob(job);
		return "Created successfully";
	}

	@PutMapping("/jobs/{id}")
	public String updateJobById(@PathVariable Integer id, @RequestBody Job updatejob) {
		jobService.updateById(id, updatejob);

		return "Success";

	}

	@DeleteMapping("/jobs/{id}")
	public String deleteJobById(@PathVariable Integer id) {
		jobService.deleteJobById(id);
		return "Success";

	}
}
