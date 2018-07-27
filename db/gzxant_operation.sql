
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

CREATE TABLE `oper_accident` (
`id`  int(50) NOT NULL AUTO_INCREMENT ,
`plate_num`  varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车牌号' ,
`brand`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌' ,
`accident_time`  date NULL DEFAULT NULL COMMENT '违章时间' ,
`accident_place`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '事故地点' ,
`model_num`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车型号' ,
`vin`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车架号' ,
`details`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '事故详情' ,
`user_unit`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '使用单位' ,
`driver`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '驾驶员' ,
`use_nature`  int(1) NULL DEFAULT NULL COMMENT '使用性质' ,
`responsibility_divide`  int(1) NULL DEFAULT NULL COMMENT '责任划分' ,
`minor_wound`  int(255) NULL DEFAULT NULL COMMENT '轻伤' ,
`serious_injury`  int(255) NULL DEFAULT NULL COMMENT '重伤' ,
`death`  int(255) NULL DEFAULT NULL COMMENT '死亡' ,
`myself_loss`  int(255) NULL DEFAULT NULL COMMENT '我方经济损失' ,
`myself_treatment_cost`  int(255) NULL DEFAULT NULL COMMENT '我方医疗费用' ,
`third_party_loss`  int(255) NULL DEFAULT NULL COMMENT '三者经济损失' ,
`third_party_treatment_cost`  int(255) NULL DEFAULT NULL COMMENT '三者医疗费用' ,
`reimbursement_cost`  int(255) NULL DEFAULT NULL COMMENT '已赔付费用' ,
`grade`  int(1) NULL DEFAULT NULL COMMENT '事故等级' ,
`status`  int(1) NULL DEFAULT NULL COMMENT '处理状态' ,
`
oper_nature`  int(1) NULL DEFAULT NULL COMMENT '事故性质' ,
`schedule`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '事故处理进度' ,
`remake`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
`attachment_path`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '事故附件信息' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1
ROW_FORMAT=COMPACT
;