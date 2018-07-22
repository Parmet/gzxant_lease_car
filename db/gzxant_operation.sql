CREATE TABLE `oper_transgress` (
  `id` int(25) NOT NULL,
  `plate_num` varchar(15) DEFAULT NULL COMMENT '车牌号',
  `type` varchar(10) DEFAULT NULL COMMENT '车牌类型',
  `brand` varchar(20) DEFAULT NULL COMMENT '品牌',
  `deduction` int(1) DEFAULT NULL COMMENT '扣分',
  `fine` int(255) DEFAULT NULL COMMENT '罚款',
  `asset_company` varchar(255) DEFAULT NULL COMMENT '资产公司',
  `operate_company` varchar(255) DEFAULT NULL COMMENT '经营公司',
  `customer` varchar(255) DEFAULT NULL COMMENT '客户',
  `tg_time` datetime DEFAULT NULL COMMENT '违章时间',
  `place` varchar(255) DEFAULT NULL COMMENT '违章地点',
  `reason` varchar(255) DEFAULT NULL COMMENT '违章原因',
  `department` varchar(255) DEFAULT NULL COMMENT '采集机关',
  `commisson` varchar(1) DEFAULT NULL COMMENT '是否可以代办',
  `code` int(50) DEFAULT NULL COMMENT '违章代码',
  `tg_num` int(50) DEFAULT NULL COMMENT '违章项文书编号',
  `status` int(1) DEFAULT NULL COMMENT '状态',
  `query_time` datetime DEFAULT NULL COMMENT '数据查询时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新为已处理时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

