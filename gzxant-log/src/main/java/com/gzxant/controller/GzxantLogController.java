package com.gzxant.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.entity.GzxantLog;
import com.gzxant.service.IGzxantLogService;
import com.gzxant.util.ReturnDTOUtil;

import io.swagger.annotations.ApiOperation;

/**
 * Created by chen on 2017/9/19.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe: slife 日志 controller
 */
@Controller
@RequestMapping("/monitor/log")
public class GzxantLogController extends BaseController {

    @Autowired
    private IGzxantLogService gzxantLogService;


    @ApiOperation(value = "进入日志列表", notes = "进入日志列表")
    @GetMapping(value = "")
    public String list(Model model, HttpServletRequest request) {
        model.addAttribute("url", request.getContextPath()+"/monitor/log/");
        return "log/list";
    }

    @ApiOperation(value = "获取日志列表数据", notes = "获取日志列表数据:使用约定的DataTable")
    @PostMapping(value = "/list")
    @ResponseBody
    public DataTable<GzxantLog> list(@RequestBody DataTable dt, ServletRequest request) {
        return gzxantLogService.pageSearch(dt);
    }

    @ApiOperation(value = "批量删除日志记录", notes = "批量删除日志记录传入日志ids")
    @PostMapping(value = "/delete")
    @ResponseBody
    public ReturnDTO delete(@RequestParam("ids") List<Long> ids, ServletRequest request) {
        boolean success = gzxantLogService.deleteBatchIds(ids);
        if (success) {
            return ReturnDTOUtil.success();
        }
        return ReturnDTOUtil.fail();

    }


}
