package com.example.it.repository;

import com.example.it.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 岗位数据访问层，提供对jobs表的CRUD操作
 */
@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

    /**
     * 根据企业名称查询岗位列表
     */
    List<Job> findByCompanyName(String companyName);

    /**
     * 根据岗位名称查询岗位列表
     */
    List<Job> findByPositionName(String positionName);

    /**
     * 根据状态查询岗位列表
     */
    List<Job> findByStatus(String status);

    /**
     * 根据企业名称和岗位名称模糊查询
     */
    List<Job> findByCompanyNameContainingOrPositionNameContaining(String companyName, String positionName);

    /**
     * 根据工作地点查询岗位列表
     */
    List<Job> findByLocation(String location);
}