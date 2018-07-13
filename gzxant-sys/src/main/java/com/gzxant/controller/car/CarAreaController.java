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
import com.gzxant.entity.CarArea;
import com.gzxant.enums.CarSizeNameEnums;
import com.gzxant.enums.CarTrainNameEnums;
import com.gzxant.enums.CityNameEnums;
import com.gzxant.enums.HttpCodeEnum;
import com.gzxant.exception.SlifeException;
import com.gzxant.service.ICarAreaService;
import com.gzxant.shiro.GzxantSysUser;
import com.gzxant.util.FileUtils;
import com.gzxant.util.ReturnDTOUtil;

import io.swagger.annotations.ApiOperation;

/**
 * Describe:车场
 * @author ZCRONG
 *  
 */
@Controller
@RequestMapping(value = "/car/area")
public class CarAreaController extends BaseController {
	
    @Autowired
    private ICarAreaService carAreaService;
	
    @RequiresPermissions("car:area")
    @SLog("进入车场列表界面")
    @ApiOperation(value = "进入车场列表界面", notes = "进入车场列表界面")
    @GetMapping(value = "")
    public String list(Model model, HttpServletRequest request) {
        model.addAttribute("url", request.getContextPath() + "/car/area/");
        model.addAttribute("cityName", CityNameEnums.values());
        return "carArea/list";
    }
    
    /**
     * 对车场数据分页显示
     *
     * @param dt
     * @param request
     * @return
     */
    @SLog("获取车场列表数据")
    @ApiOperation(value = "获取车场列表数据", notes = "获取车场列表:使用约定的DataTable")
    @PostMapping(value = "/list")
    @ResponseBody
    public DataTable<CarArea> list(@RequestBody DataTable dt, ServletRequest request) {
        return carAreaService.pageSearch(dt);
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
        model.addAttribute("url", request.getContextPath() + "/car/area/");
        CarArea carArea = carAreaService.selectCarAreaAllInfoById(id);
        logger.info(JSON.toJSONString(carArea));
        model.addAttribute("carArea", carArea);
        model.addAttribute("cityName", CityNameEnums.values());
        return "carArea/detail";
    }
    
    /**
     * 查看汽车详情界面
     *
     * @param id
     * @param model
     * @return
     */
    @SLog("查看车场对象详情界面")
    @GetMapping(value = "/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model, HttpServletRequest request) {
        model.addAttribute("action", "detail");
        CarArea carArea = carAreaService.selectCarAreaAllInfoById(id);
        model.addAttribute("carArea", carArea);
        model.addAttribute("url", request.getContextPath() + "/car/area/");
        model.addAttribute("cityName", CityNameEnums.values());
        return "carArea/detail";
    }
    
    @SLog("创建车场操作")
    @ApiOperation(value = "创建车场操作", notes = "创建车场操作")
    @PostMapping(value = "/insert")
    @ResponseBody
    public ReturnDTO create(CarArea carArea) {
        return carAreaService.insertCarArea(carArea) == true ? ReturnDTOUtil.success() : ReturnDTOUtil.fail();
    }
    
    @ApiOperation(value = "进入创建车辆对象界面", notes = "进入创建车场对象界面")
    @GetMapping(value = "/insert")
    public String create(Model model, HttpServletRequest request) {
        model.addAttribute("action", "insert");
        CarArea carArea = new CarArea();
        carArea.setId(0L);
        model.addAttribute("carArea", carArea);
        model.addAttribute("url", request.getContextPath() + "/car/area/");
        model.addAttribute("cityName", CityNameEnums.values());
        return "carArea/detail";
    }
    
    @SLog("更新车场信息")
    @ApiOperation(value = "更新车场信息", notes = "更新车场信息")
    @PostMapping(value = "/update")
    @ResponseBody
    public ReturnDTO update(CarArea carAreaNew) {

        CarArea carAreaOld = carAreaService.selectCarAreaAllInfoById(carAreaNew.getId());
        if (ObjectUtils.isEmpty(carAreaOld)) {
            throw new SlifeException(HttpCodeEnum.NOT_FOUND);
        }
        return carAreaService.updateCarArea(carAreaNew) == true ? ReturnDTOUtil.success() : ReturnDTOUtil.fail();
    }
    
    @SLog("批量删除车场对象")
    @ApiOperation(value = "批量删除车场对象", notes = "批量删除车场对象")
    @PostMapping(value = "/delete")
    @ResponseBody
    public ReturnDTO delete(@RequestParam("ids") List<Long> ids, ServletRequest request) {
        return carAreaService.deleteBatchIds(ids) == true ? ReturnDTOUtil.success() : ReturnDTOUtil.fail();

    }
    
    @SLog("根据id删除车场对象")
    @ApiOperation(value = "根据id删除车场对象", notes = "根据id删除车场对象")
    @PostMapping(value = "/deleteById")
    @ResponseBody
    public ReturnDTO deleteById(@RequestParam("id") Long id, ServletRequest request) {
    	return carAreaService.deleteById(id) == true ? ReturnDTOUtil.success() : ReturnDTOUtil.fail();
    	
    }
    
}
