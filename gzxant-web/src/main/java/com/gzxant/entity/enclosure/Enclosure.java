package com.gzxant.entity.enclosure;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 附件实体
 * @author: Fatal
 * @date: 2018/7/28 0028 13:20
 */
@TableName("enclosure")
public class Enclosure extends DataEntity<Enclosure> {

    /** 访问地址 */
    @NotNull
    private String url;

    /** 文件类型 */
    @TableField("file_type")
    private String fileType;

    /** 缩略图 */
    @NotNull
    private String thumbnail;

    /** 实体引用 */
    @NotNull
    @TableField("entity_id")
    private String entityId;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    @Override
    protected Serializable pkVal() {
        return super.id;
    }
}
