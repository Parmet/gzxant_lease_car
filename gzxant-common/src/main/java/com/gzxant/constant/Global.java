package com.gzxant.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chen on 2017/7/14.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe: 全局常量
 */
public class Global {

    /**
     * 是/否
     */
    public static final String YES = "Y";
    public static final String NO = "N";
    
    /**
	 * 详情页面类型
	 */
    public static final String ACTION_DETAIL = "detail";
    public static final String ACTION_INSERT = "insert";
    public static final String ACTION_UPDATE = "update";
	public static final List<String> ACTION_TYPE = new ArrayList<>(Arrays.asList(ACTION_DETAIL, ACTION_INSERT, ACTION_UPDATE));

    /**
     * 删除标记（Y：正常；N：删除；A：审核；）
     */
    public static final String DEL_FLAG_NORMAL = "Y";
    public static final String DEL_FLAG_DELETE = "N";
    public static final String DEL_FLAG_AUDIT = "A";

    /**
     * 树的顶级 节点id
     */
    public static final Long TOP_TREE_NODE = 0L;
    /**
     * 管理员id
     */
    public static final Long ADMIN_ID =1L ;
}
