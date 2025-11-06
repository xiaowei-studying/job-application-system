-- IT岗位求职记录系统 - MySQL创建表SQL语句

-- 创建jobs表（MySQL版本）
CREATE TABLE jobs (
    id INT NOT NULL AUTO_INCREMENT,
    company_name VARCHAR(255) NOT NULL COMMENT '企业名称',
    position_name VARCHAR(255) NOT NULL COMMENT '岗位名称',
    salary VARCHAR(100) NOT NULL COMMENT '薪资',
    requirements TEXT NOT NULL COMMENT '具体要求',
    location VARCHAR(255) COMMENT '工作地点',
    post_date VARCHAR(50) COMMENT '发布日期',
    status VARCHAR(50) DEFAULT '待投递' COMMENT '状态',
    notes TEXT COMMENT '备注',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (id)
);

-- 创建索引
CREATE INDEX idx_company_name ON jobs(company_name);
CREATE INDEX idx_position_name ON jobs(position_name);
CREATE INDEX idx_status ON jobs(status);

-- 插入示例数据
INSERT INTO jobs (company_name, position_name, salary, requirements, location, status, notes) VALUES
('科技有限公司A', '前端开发工程师', '15K-25K', '熟悉HTML/CSS/JavaScript，有React或Vue经验', '北京', '待投递', '重点关注'),
('互联网公司B', '后端开发工程师', '20K-30K', '精通Java或Python，熟悉Spring Boot或Django框架', '上海', '已投递', '等待回复'),
('软件公司C', '测试工程师', '12K-20K', '掌握自动化测试工具，有性能测试经验', '广州', '待面试', '下周面试');

-- 使用说明：
-- 1. 打开Navicat，连接到MySQL数据库
-- 2. 选择psychological_counseling数据库
-- 3. 执行本SQL脚本创建表并插入初始数据