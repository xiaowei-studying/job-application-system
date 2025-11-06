package com.example.it.service.impl;

import com.example.it.entity.Job;
import com.example.it.repository.JobRepository;
import com.example.it.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 岗位管理业务逻辑实现类
 */
@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public Job addJob(Job job) {
        // 设置默认状态为"待投递"
        if (job.getStatus() == null || job.getStatus().isEmpty()) {
            job.setStatus("待投递");
        }
        return jobRepository.save(job);
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Optional<Job> getJobById(Integer id) {
        return jobRepository.findById(id);
    }

    @Override
    public Job updateJob(Integer id, Job job) {
        // 检查岗位是否存在
        Optional<Job> existingJob = jobRepository.findById(id);
        if (existingJob.isPresent()) {
            Job updatedJob = existingJob.get();
            // 更新字段
            updatedJob.setCompanyName(job.getCompanyName());
            updatedJob.setPositionName(job.getPositionName());
            updatedJob.setSalary(job.getSalary());
            updatedJob.setRequirements(job.getRequirements());
            updatedJob.setLocation(job.getLocation());
            updatedJob.setPostDate(job.getPostDate());
            updatedJob.setStatus(job.getStatus());
            updatedJob.setNotes(job.getNotes());
            return jobRepository.save(updatedJob);
        }
        return null;
    }

    @Override
    public void deleteJob(Integer id) {
        jobRepository.deleteById(id);
    }

    @Override
    public List<Job> getJobsByCompanyName(String companyName) {
        return jobRepository.findByCompanyName(companyName);
    }

    @Override
    public List<Job> getJobsByPositionName(String positionName) {
        return jobRepository.findByPositionName(positionName);
    }

    @Override
    public List<Job> getJobsByStatus(String status) {
        return jobRepository.findByStatus(status);
    }

    @Override
    public List<Job> searchJobs(String keyword) {
        return jobRepository.findByCompanyNameContainingOrPositionNameContaining(keyword, keyword);
    }

    @Override
    public List<Job> getJobsByLocation(String location) {
        return jobRepository.findByLocation(location);
    }
}