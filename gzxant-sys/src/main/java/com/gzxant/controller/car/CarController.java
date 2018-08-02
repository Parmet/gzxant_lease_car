package com.gzxant.controller.car;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
import com.gzxant.entity.Car;
import com.gzxant.enums.CarSizeNameEnums;
import com.gzxant.enums.CarTrainNameEnums;
import com.gzxant.enums.CityNameEnums;
import com.gzxant.enums.HttpCodeEnum;
import com.gzxant.exception.SlifeException;
import com.gzxant.service.ICarAreaService;
import com.gzxant.service.ICarService;
import com.gzxant.shiro.GzxantSysUser;
import com.gzxant.util.ReturnDTOUtil;

import io.swagger.annotations.ApiOperation;

/**
 * Describe:汽车管理
 * @author ZCRONG
 *   
 */
@Controller
@RequestMapping(value = "/cars/manager")
public class CarController extends BaseController {
	
    @Autowired
    private ICarService carService;
    
    @Autowired
    private ICarAreaService carAreaService;
	
    @RequiresPermissions("cars:list")
    @SLog("进入汽车列表界面")
    @ApiOperation(value = "进入用户列表界面", notes = "进入用户列表界面")
    @GetMapping(value = "")
    public String list(Model model, HttpServletRequest request) {
        model.addAttribute("carAreaList", carAreaService.selectList(null));
        model.addAttribute("url", request.getContextPath() + "/car/list/");
        model.addAttribute("carList", carService.selectList(null));
        return "car/list";
    }
    
    /**
     * 对车场数据分页显示
     *
     * @param dt
     * @param request
     * @return
     */
//    @SLog("车辆管理导出数据")
//    @ApiOperation(value = "导出数据")
//    @GetMapping(value = "/leadingOut")
//    public ReturnDTO leadingOut(HttpServletResponse response) throws Exception  {
//    	 List<Car> cars = carService.selectList(null);
//         response.setContentType("application/vnd.ms-excel;charset=utf-8");
//         String[] fields = {"订单号","押金应收流水ID", "应收金额"};
//         ExcelExport excelExport = new ExcelExport();
//         HSSFWorkbook wb = excelExport.generateExcel();
//         wb = excelExport.generateOrderDepositVOSheet(wb, "押金订单信息", fields, cars);
//         excelExport.export("押金订单信息", wb, response);
//
//         return ReturnDTOUtil.success();
//    }
//
    /**
     * 对汽车数据分页显示
     *
     * @param dt
     * @param request
     * @return
     */
    @SLog("获取汽车列表数据")
    @ApiOperation(value = "获取汽车列表数据", notes = "获取汽车列表:使用约定的DataTable")
    @PostMapping(value = "/list")
    @ResponseBody
    public DataTable<Car> list(@RequestBody DataTable dt, ServletRequest request) {
        return carService.pageSearch(dt);
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
        model.addAttribute("step", "upload");
        model.addAttribute("url", request.getContextPath() + "/car/manager/");
        Car car = carService.selectCarAllInfoById(id);
        logger.info(JSON.toJSONString(car));
        model.addAttribute("car", car);
        model.addAttribute("cityName", CityNameEnums.values());
        model.addAttribute("trainName", CarTrainNameEnums.values());
        model.addAttribute("sizeName", CarSizeNameEnums.values());
        return "car/detail";
    }
    
    /**
     * 查看汽车详情界面
     *
     * @param id
     * @param model
     * @return
     */
    @SLog("查看汽车详情界面")
    @GetMapping(value = "/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model, HttpServletRequest request) {
        model.addAttribute("action", "detail");
        model.addAttribute("step", "download");
        Car car = carService.selectCarAllInfoById(id);
        model.addAttribute("car", car);
        model.addAttribute("url", request.getContextPath() + "/car/manager/");
        model.addAttribute("cityName", CityNameEnums.values());
        model.addAttribute("trainName", CarTrainNameEnums.values());
        model.addAttribute("sizeName", CarSizeNameEnums.values());
        return "car/detail";
    }
    
    @SLog("创建汽车操作")
    @ApiOperation(value = "创建汽车操作", notes = "创建汽车操作")
    @PostMapping(value = "/insert")
    @ResponseBody
    public ReturnDTO create(Car car) {
    	Long companyId = GzxantSysUser.companyId();
    	car.setCompanyId(companyId);
        return carService.insertCar(car) == true ? ReturnDTOUtil.success() : ReturnDTOUtil.fail();
    }
    
    @SLog("进入创建汽车对象界面")
    @ApiOperation(value = "进入创建汽车对象界面", notes = "进入创建汽车对象界面")
    @GetMapping(value = "/insert")
    public String create(Model model, HttpServletRequest request) {
        model.addAttribute("action", "insert");
        model.addAttribute("step", "upload");
        Car car = new Car();
        car.setId(0L);
        model.addAttribute("car", car);
        model.addAttribute("cityName", CityNameEnums.values());
        model.addAttribute("trainName", CarTrainNameEnums.values());
        model.addAttribute("sizeName", CarSizeNameEnums.values());
        model.addAttribute("url", request.getContextPath() + "/car/manager/");
        return "car/detail";
    }
    
    @SLog("更新汽车")
    @ApiOperation(value = "更新汽车", notes = "更新汽车")
    @PostMapping(value = "/update")
    @ResponseBody
    public ReturnDTO update(Car carNew) {

        Car carOld = carService.selectCarAllInfoById(carNew.getId());
        if (ObjectUtils.isEmpty(carOld)) {
            throw new SlifeException(HttpCodeEnum.NOT_FOUND);
        }
        return carService.updateCar(carNew) == true ? ReturnDTOUtil.success() : ReturnDTOUtil.fail();
    }
    
    @SLog("批量删除汽车对象")
    @ApiOperation(value = "批量删除汽车对象", notes = "批量删除汽车对象")
    @PostMapping(value = "/delete")
    @ResponseBody
    public ReturnDTO delete(@RequestParam("ids") List<Long> ids, ServletRequest request) {
        return carService.deleteBatchIds(ids) == true ? ReturnDTOUtil.success() : ReturnDTOUtil.fail();

    }
    
    @SLog("根据id删除汽车对象")
    @ApiOperation(value = "根据id删除汽车对象", notes = "根据id删除汽车对象")
    @PostMapping(value = "/deleteById")
    @ResponseBody
    public ReturnDTO deleteById(@RequestParam("id") Long id, ServletRequest request) {
    	return carService.deleteById(id) == true ? ReturnDTOUtil.success() : ReturnDTOUtil.fail();
    	
    }
    
}
