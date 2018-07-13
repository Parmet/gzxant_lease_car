package com.gzxant.controller.car;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.gzxant.annotation.SLog;
import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.entity.CarSet;
import com.gzxant.enums.CarSizeNameEnums;
import com.gzxant.enums.CarTrainNameEnums;
import com.gzxant.enums.HttpCodeEnum;
import com.gzxant.exception.SlifeException;
import com.gzxant.service.ICarSetService;
import com.gzxant.shiro.GzxantSysUser;
import com.gzxant.util.FileUtils;
import com.gzxant.util.ReturnDTOUtil;

import io.swagger.annotations.ApiOperation;

/**
 * Describe:车辆设置
 * @author ZCRONG
 *  
 */
@Controller
@RequestMapping(value = "/car/set")
public class CarSetController extends BaseController {
	
    @Autowired
    private ICarSetService carSetService;
	
    @RequiresPermissions("car:set")
    @SLog("进入车辆设置列表界面")
    @ApiOperation(value = "进入车辆设置列表界面", notes = "进入车辆设置列表界面")
    @GetMapping(value = "")
    public String list(Model model, HttpServletRequest request) {
        model.addAttribute("url", request.getContextPath() + "/car/set/");
        model.addAttribute("trainName", CarTrainNameEnums.values());
        model.addAttribute("sizeName", CarSizeNameEnums.values());
        return "carSet/list";
    }
    
    /**
     * 对车辆设置数据分页显示
     *
     * @param dt
     * @param request
     * @return
     */
    @SLog("获取车辆设置列表数据")
    @ApiOperation(value = "获取车辆设置列表数据", notes = "获取车辆设置列表:使用约定的DataTable")
    @PostMapping(value = "/list")
    @ResponseBody
    public DataTable<CarSet> list(@RequestBody DataTable dt, ServletRequest request) {
        return carSetService.pageSearch(dt);
    }
    
    /**
     * 更新汽车界面
     *
     * @param id
     * @return
     */
    @GetMapping(value = "update/{id}")
    public String update(@PathVariable("id") Long id, Model model,HttpServletRequest request) {
        model.addAttribute("action", "update");
        model.addAttribute("url", request.getContextPath() + "/car/set/");
        CarSet carSet = carSetService.selectCarSetAllInfoById(id);
        logger.info(JSON.toJSONString(carSet));
        model.addAttribute("carSet", carSet);
        model.addAttribute("trainName", CarTrainNameEnums.values());
        model.addAttribute("sizeName", CarSizeNameEnums.values());
        return "carSet/detail";
    }
    
    /**
     * 查看汽车详情界面
     *
     * @param id
     * @param model
     * @return
     */
    @SLog("查看车辆设置对象详情界面")
    @GetMapping(value = "/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model, HttpServletRequest request) {
        model.addAttribute("action", "detail");
        CarSet carSet = carSetService.selectCarSetAllInfoById(id);
        model.addAttribute("carSet", carSet);
        model.addAttribute("url", request.getContextPath() + "/car/set/");
        model.addAttribute("trainName", CarTrainNameEnums.values());
        model.addAttribute("sizeName", CarSizeNameEnums.values());
        return "carSet/detail";
    }
    
    @SLog("创建车辆设置操作")
    @ApiOperation(value = "创建车辆设置操作", notes = "创建车辆设置操作")
    @PostMapping(value = "/insert")
    @ResponseBody
    public ReturnDTO create(CarSet carSet) {
        return carSetService.insertCarSet(carSet) == true ? ReturnDTOUtil.success() : ReturnDTOUtil.fail();
    }
    
    @ApiOperation(value = "进入创建车辆对象界面", notes = "进入创建车辆设置对象界面")
    @GetMapping(value = "/insert")
    public String create(Model model, HttpServletRequest request) {
        model.addAttribute("action", "insert");
        CarSet carSet = new CarSet();
        carSet.setId(0L);
        model.addAttribute("carSet", carSet);
        model.addAttribute("url", request.getContextPath() + "/car/set/");
        model.addAttribute("trainName", CarTrainNameEnums.values());
        model.addAttribute("sizeName", CarSizeNameEnums.values());
        return "carSet/detail";
    }
    
    @SLog("更新车辆设置信息")
    @ApiOperation(value = "更新车辆设置信息", notes = "更新车辆设置信息")
    @PostMapping(value = "/update")
    @ResponseBody
    public ReturnDTO update(CarSet carSetNew) {

        CarSet carSetOld = carSetService.selectCarSetAllInfoById(carSetNew.getId());
        if (ObjectUtils.isEmpty(carSetOld)) {
            throw new SlifeException(HttpCodeEnum.NOT_FOUND);
        }
        return carSetService.updateCarSet(carSetNew) == true ? ReturnDTOUtil.success() : ReturnDTOUtil.fail();
    }
    
    @SLog("批量删除车辆设置对象")
    @ApiOperation(value = "批量删除车辆设置对象", notes = "批量删除车辆设置对象")
    @PostMapping(value = "/delete")
    @ResponseBody
    public ReturnDTO delete(@RequestParam("ids") List<Long> ids, ServletRequest request) {
        return carSetService.deleteBatchIds(ids) == true ? ReturnDTOUtil.success() : ReturnDTOUtil.fail();

    }
    
    @SLog("根据id删除车辆设置对象")
    @ApiOperation(value = "根据id删除车辆设置对象", notes = "根据id删除车辆设置对象")
    @PostMapping(value = "/deleteById")
    @ResponseBody
    public ReturnDTO deleteById(@RequestParam("id") Long id, ServletRequest request) {
    	return carSetService.deleteById(id) == true ? ReturnDTOUtil.success() : ReturnDTOUtil.fail();
    	
    }
    
    
    @ApiOperation(value = "删除头像", notes = "删除头像")
    @PostMapping(value = "/delete/photo")
    public ReturnDTO deletePhoto(@RequestParam("name") String name) {

        String defaluePhoto = "/img/log9.png";
        if (defaluePhoto.equals(name)) {
            logger.info("默认头像不可删除！");
            return ReturnDTOUtil.custom(HttpCodeEnum.DELETE_DEFAULT_PHOTO_ERR);
        }
        Long userId = GzxantSysUser.id();
        CarSet carSet = carSetService.selectById(userId);
        if (ObjectUtils.isEmpty(carSet)) {
            return ReturnDTOUtil.notFound();
        }
        carSet.setPhoto(defaluePhoto);
        carSetService.updateById(carSet);

        FileUtils.deleteFile(name);//删除文件
        return ReturnDTOUtil.success();
    }
    
}
