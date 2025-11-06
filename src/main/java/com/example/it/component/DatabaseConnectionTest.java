package com.example.it.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 数据库连接测试组件，在应用启动时验证数据库连接
 */
@Component
public class DatabaseConnectionTest implements ApplicationRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            // 测试数据库连接，查询数据库中的表
            System.out.println("开始测试数据库连接...");
            
            // 查询数据库中的所有表名
            List<Map<String, Object>> tables = jdbcTemplate.queryForList(
                    "SHOW TABLES FROM psychological_counseling");
            
            System.out.println("数据库连接成功！psychological_counseling数据库中的表：");
            if (tables.isEmpty()) {
                System.out.println("数据库中暂无表");
            } else {
                for (Map<String, Object> table : tables) {
                    // MySQL中SHOW TABLES的结果列名格式为Tables_in_数据库名
                    for (String key : table.keySet()) {
                        System.out.println("- " + table.get(key));
                    }
                }
            }
            
        } catch (Exception e) {
            System.err.println("数据库连接失败：" + e.getMessage());
            e.printStackTrace();
        }
    }
}