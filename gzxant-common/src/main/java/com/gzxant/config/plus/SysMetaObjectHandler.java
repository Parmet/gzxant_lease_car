package com.gzxant.config.plus;

import java.util.Date;

import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.gzxant.shiro.GzxantSysUser;

/**
 * mybatisplus自定义填充公共字段 ,即没有传的字段自动填充
 * @author chen
 */
@Component
public class SysMetaObjectHandler extends MetaObjectHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //新增填充
    @Override
    public void insertFill(MetaObject metaObject) {
        logger.debug("insert set createTime createBy updateTime updateBy param");
        Object createDate = metaObject.getValue("createDate");
        Object createId = metaObject.getValue("createId");
        Object updateDate = metaObject.getValue("updateDate");
        Object updateId = metaObject.getValue("updateId");
        
        if (null == createDate) {
            metaObject.setValue("createDate", new Date());
        }
        if (null == createId) {
            metaObject.setValue("createId", GzxantSysUser.id());
        }
        if (null == updateDate) {
            metaObject.setValue("updateDate", new Date());
        }
        if (null == updateId) {
            metaObject.setValue("updateId", GzxantSysUser.id());
        }
    }

    //更新填充
    @Override
    public void updateFill(MetaObject metaObject) {
        logger.debug("update set  updateTime updateBy param");

        metaObject.setValue("updateDate", new Date());

        metaObject.setValue("updateId", GzxantSysUser.id());


    }
}
