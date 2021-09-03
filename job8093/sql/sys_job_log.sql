CREATE TABLE `sys_job_log` (
                               `job_log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
                               `job_name` varchar(64) NOT NULL COMMENT '任务名称',
                               `job_group` varchar(64) NOT NULL COMMENT '任务组名',
                               `invoke_target` varchar(500) NOT NULL COMMENT '调用目标字符串',
                               `job_message` varchar(500) DEFAULT NULL COMMENT '日志信息',
                               `status` char(1) DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
                               `exception_info` varchar(2000) DEFAULT '' COMMENT '异常信息',
                               `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                               `stop_time` datetime DEFAULT NULL COMMENT '停止时间',
                               `execution` bigint(20) DEFAULT NULL COMMENT '执行时间',
                               PRIMARY KEY (`job_log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1433736903534665730 DEFAULT CHARSET=utf8 COMMENT='定时任务调度日志表';