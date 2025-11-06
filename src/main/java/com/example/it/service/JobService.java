package com.example.it.service;

import com.example.it.entity.Job;

import java.util.List;
import java.util.Optional;

/**
 * 岗位管理业务逻辑接口
 */
public interface JobService {

    /**
     * 添加新岗位
     */
    Job addJob(Job job);

    /**
     * 获取所有岗位列表
     */
    List<Job> getAllJobs();

    /**
     * 根据ID获取岗位
     */
    Optional<Job> getJobById(Integer id);

    /**
     * 更新岗位信息
     */
    Job updateJob(Integer id, Job job);

    /**
     * 删除岗位
     */
    void deleteJob(Integer id);

    /**
     * 根据企业名称查询岗位
     */
    List<Job> getJobsByCompanyName(String companyName);

    /**
     * 根据岗位名称查询岗位
     */
    List<Job> getJobsByPositionName(String positionName);

    /**
     * 根据状态查询岗位
     */
    List<Job> getJobsByStatus(String status);

    /**
     * 搜索岗位（按企业名称或岗位名称模糊查询）
     */
    List<Job> searchJobs(String keyword);

    /**
     * 根据工作地点查询岗位
     */
    List<Job> getJobsByLocation(String location);
}