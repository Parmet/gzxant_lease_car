package com.gzxant.controller.contractInfo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.gzxant.entity.CarExchangeInfo;
import com.gzxant.enums.ContractType;
import com.gzxant.enums.HttpCodeEnum;
import com.gzxant.exception.SlifeException;
import com.gzxant.service.ICarExchangeInfoService;
import com.gzxant.service.IContractInfoService;
import com.gzxant.util.ReturnDTOUtil;

import io.swagger.annotations.ApiOperation;

/**
 * Describe:车辆申请交换
 * @author ZCRONG
 *   
 */
@Controller
@RequestMapping(value = "/carExchangeInfo/manager")
public class CarExchangeInfoController extends BaseController{
	@Autowired
    private ICarExchangeInfoService carExchangeInfoService;
	@Autowired
    private IContractInfoService contractInfoService;
    
	
    @RequiresPermissions("contractInfo:carexchange:list")
    @SLog("进入车辆申请交换列表界面")
    @ApiOperation(value = "进入车辆申请交换列表界面", notes = "进入车辆申请交换列表界面")
    @GetMapping(value = "")
    public String list(Model model, HttpServletRequest request) {
        model.addAttribute("url", request.getContextPath() + "/carExchangeInfo/list/");
        model.addAttribute("carExchangeInfoList", carExchangeInfoService.selectList(null));
        return "carExchangeInfo/list";
    }
    
    /**
     * 对车辆申请交换对象数据分页显示
     *
     * @param dt
     * @param request
     * @return
     */
    @SLog("车辆申请交换管理导出数据")
    @ApiOperation(value = "导出数据")
    @GetMapping(value = "/leadingOut")
    public void leadingOut(HttpServletResponse response) throws Exception  {
    	 List<CarExchangeInfo> carExchangeInfos = carExchangeInfoService.selectList(null);

         //导出数据
         String excelTitle = "车辆管理列表";
         String[] headerTitle = new String[]{"id", "年审日期", "资产所属", "资产编号", "资产状态", "购买日期", "车牌号", "颜色"};
         List<String[]> arrayList = new ArrayList<>();
         arrayList.add(headerTitle); //列头
         if (null != carExchangeInfos && carExchangeInfos.size() > 0) {
             for (CarExchangeInfo carExchangeInfo : carExchangeInfos) {
                 arrayList.add(
                         new String[]{
//                        		 contractInfo.getId().toString(),
//                        		 contractInfo.getAnnualTrialDate(),
//                        		 contractInfo.getAssetsBelong(),
//                        		 contractInfo.getAssetsNumber(),
//                                 contractInfo.getAssetsState(),
//                                 contractInfo.getBuyDate(),
//                                 contractInfo.getCarNumber(),
//                                 contractInfo.getColor()
                         });
             }
         }
         ExceptInfo(response, excelTitle, arrayList);
    }
    
    /**
     *
     * @param dt
     * @param request
     * @return
     */
    @SLog("获取车辆申请交换列表数据")
    @ApiOperation(value = "获取车辆申请交换列表数据", notes = "获取车辆申请交换列表:使用约定的DataTable")
    @PostMapping(value = "/list")
    @ResponseBody
    public DataTable<CarExchangeInfo> list(@RequestBody DataTable dt, ServletRequest request) {
        return carExchangeInfoService.pageSearch(dt);
    }
    
    /**
     * 更新车辆申请交换界面
     *
     * @param id
     * @return
     */
    @GetMapping(value = "update/{id}")
    public String update(@PathVariable("id") Long id, Model model,HttpServletRequest request) {
    	DataTable dt = new DataTable();
        dt.setPageNumber(0);
        dt.setPageSize(10);
        model.addAttribute("action", "update");
        model.addAttribute("url", request.getContextPath() + "/car/manager/");
        CarExchangeInfo carExchangeInfo = carExchangeInfoService.selectCarExchangeInfoAllInfoById(id);
        logger.info(JSON.toJSONString(carExchangeInfo));
        model.addAttribute("carExchangeInfo",carExchangeInfo);
        model.addAttribute("contractInfoNews",contractInfoService.selectContractListByIsOver("new"));
        return "carExchangeInfo/detail";
    }
    
    /**
     * 查看车辆申请交换详情界面
     *
     * @param id
     * @param model
     * @return
     */
    @SLog("查看车辆申请交换详情界面")
    @GetMapping(value = "/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model, HttpServletRequest request) {
    	DataTable dt = new DataTable();
        dt.setPageNumber(0);
        dt.setPageSize(10);
        model.addAttribute("action", "detail");
        CarExchangeInfo carExchangeInfo = carExchangeInfoService.selectCarExchangeInfoAllInfoById(id);
        model.addAttribute("carExchangeInfo", carExchangeInfo);
        model.addAttribute("url", request.getContextPath() + "/carExchangeInfo/manager/");
        model.addAttribute("contractInfoNews",contractInfoService.selectContractListByIsOver("new"));
        return "carExchangeInfo/detail";
    }
    
    @SLog("创建车辆申请交换对象操作")
    @ApiOperation(value = "创建车辆申请交换对象操作", notes = "创建车辆申请交换对象操作")
    @PostMapping(value = "/insert")
    @ResponseBody
    public ReturnDTO create(CarExchangeInfo carExchangeInfo) {
        return carExchangeInfoService.insertCarExchangeInfo(carExchangeInfo) == true ? ReturnDTOUtil.success() : ReturnDTOUtil.fail();
    }
    
    @SLog("进入创建车辆申请交换对象界面")
    @ApiOperation(value = "进入创建车辆申请交换对象界面", notes = "进入创建车辆申请交换对象界面")
    @GetMapping(value = "/insert")
    public String create(Model model, HttpServletRequest request) {
    	DataTable dt = new DataTable();
        dt.setPageNumber(0);
        dt.setPageSize(10);
        model.addAttribute("action", "insert");
        CarExchangeInfo carExchangeInfo = new CarExchangeInfo();
        carExchangeInfo.setId(0L);
        model.addAttribute("carExchangeInfo", carExchangeInfo);
        model.addAttribute("url", request.getContextPath() + "/carExchangeInfo/manager/");
        model.addAttribute("contractInfoNews",contractInfoService.selectContractListByIsOver("new"));
        return "carExchangeInfo/detail";
    }
    
    @SLog("更新车辆申请交换对象")
    @ApiOperation(value = "更新车辆申请交换", notes = "更新车辆申请交换")
    @PostMapping(value = "/update")
    @ResponseBody
    public ReturnDTO update(CarExchangeInfo carExchangeInfoNew) {

    	CarExchangeInfo carExchangeInfoOld = carExchangeInfoService.selectCarExchangeInfoAllInfoById(carExchangeInfoNew.getId());
        if (ObjectUtils.isEmpty(carExchangeInfoOld)) {
            throw new SlifeException(HttpCodeEnum.NOT_FOUND);
        }
        return carExchangeInfoService.updateCarExchangeInfo(carExchangeInfoNew) == true ? ReturnDTOUtil.success() : ReturnDTOUtil.fail();
    }
    
    @SLog("批量删除车辆申请交换对象")
    @ApiOperation(value = "批量删除车辆申请交换对象", notes = "批量删除车辆申请交换对象")
    @PostMapping(value = "/delete")
    @ResponseBody
    public ReturnDTO delete(@RequestParam("ids") List<Long> ids, ServletRequest request) {
        return carExchangeInfoService.deleteBatchIds(ids) == true ? ReturnDTOUtil.success() : ReturnDTOUtil.fail();

    }
    
    @SLog("根据id删除车辆申请交换对象")
    @ApiOperation(value = "根据id删除车辆申请交换对象", notes = "根据id删除车辆申请交换对象")
    @PostMapping(value = "/deleteById")
    @ResponseBody
    public ReturnDTO deleteById(@RequestParam("id") Long id, ServletRequest request) {
    	return carExchangeInfoService.deleteById(id) == true ? ReturnDTOUtil.success() : ReturnDTOUtil.fail();
    	
    }
    
    /**
     * 获取车辆申请交换类型
     * @return
     */
    public static List<String> getcontractTypeEnum(){
    	List<String> contractTypeList = new ArrayList<String>();
    	ContractType[] contractTypes = ContractType.values();
    	for (ContractType contractType : contractTypes) {
    		contractTypeList.add(contractType.getContractType());
		}
		return contractTypeList;
    }
}
