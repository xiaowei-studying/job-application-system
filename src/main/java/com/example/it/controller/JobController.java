package com.example.it.controller;

import com.example.it.entity.Job;
import com.example.it.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 岗位管理控制器，提供RESTful API接口
 */
@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    /**
     * 添加新岗位
     */
    @PostMapping
    public ResponseEntity<Job> addJob(@RequestBody Job job) {
        Job savedJob = jobService.addJob(job);
        return ResponseEntity.ok(savedJob);
    }

    /**
     * 获取所有岗位列表
     */
    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        List<Job> jobs = jobService.getAllJobs();
        return ResponseEntity.ok(jobs);
    }

    /**
     * 根据ID获取岗位详情
     */
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Integer id) {
        return jobService.getJobById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * 更新岗位信息
     */
    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Integer id, @RequestBody Job job) {
        Job updatedJob = jobService.updateJob(id, job);
        if (updatedJob != null) {
            return ResponseEntity.ok(updatedJob);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * 删除岗位
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Integer id) {
        jobService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * 根据企业名称查询岗位
     */
    @GetMapping("/by-company/{companyName}")
    public ResponseEntity<List<Job>> getJobsByCompanyName(@PathVariable String companyName) {
        List<Job> jobs = jobService.getJobsByCompanyName(companyName);
        return ResponseEntity.ok(jobs);
    }

    /**
     * 根据岗位名称查询岗位
     */
    @GetMapping("/by-position/{positionName}")
    public ResponseEntity<List<Job>> getJobsByPositionName(@PathVariable String positionName) {
        List<Job> jobs = jobService.getJobsByPositionName(positionName);
        return ResponseEntity.ok(jobs);
    }

    /**
     * 根据状态查询岗位
     */
    @GetMapping("/by-status/{status}")
    public ResponseEntity<List<Job>> getJobsByStatus(@PathVariable String status) {
        List<Job> jobs = jobService.getJobsByStatus(status);
        return ResponseEntity.ok(jobs);
    }

    /**
     * 根据工作地点查询岗位
     */
    @GetMapping("/by-location/{location}")
    public ResponseEntity<List<Job>> getJobsByLocation(@PathVariable String location) {
        List<Job> jobs = jobService.getJobsByLocation(location);
        return ResponseEntity.ok(jobs);
    }

    /**
     * 搜索岗位（按企业名称或岗位名称模糊查询）
     */
    @GetMapping("/search")
    public ResponseEntity<List<Job>> searchJobs(@RequestParam String keyword) {
        List<Job> jobs = jobService.searchJobs(keyword);
        return ResponseEntity.ok(jobs);
    }
}