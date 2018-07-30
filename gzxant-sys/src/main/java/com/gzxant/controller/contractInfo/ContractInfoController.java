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
import com.gzxant.entity.ContractCarInfo;
import com.gzxant.entity.ContractInfo;
import com.gzxant.enums.ContractType;
import com.gzxant.enums.HttpCodeEnum;
import com.gzxant.exception.SlifeException;
import com.gzxant.service.IContractCarInfoService;
import com.gzxant.service.IContractInfoService;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.vo.ContractInfoVO;

import io.swagger.annotations.ApiOperation;

/**
 * Describe:合同管理
 * @author ZCRONG
 *   
 */
@Controller
@RequestMapping(value = "/contractInfo/manager")
public class ContractInfoController extends BaseController{
	
	@Autowired
    private IContractInfoService contractInfoService;
	@Autowired
	IContractCarInfoService contractCarInfoService;
    
	
    @RequiresPermissions("contractInfo:list")
    @SLog("进入合同列表界面")
    @ApiOperation(value = "进入合同列表界面", notes = "进入合同列表界面")
    @GetMapping(value = "")
    public String list(Model model, HttpServletRequest request) {
        model.addAttribute("url", request.getContextPath() + "/contractInfo/list/");
        model.addAttribute("contractInfoList", contractInfoService.selectList(null));
        return "contractInfo/list";
    }
    
    /**
     * 对合同对象数据分页显示
     *
     * @param dt
     * @param request
     * @return
     */
    @SLog("合同管理导出数据")
    @ApiOperation(value = "导出数据")
    @GetMapping(value = "/leadingOut")
    public void leadingOut(HttpServletResponse response) throws Exception  {
    	 List<ContractInfo> contractInfos = contractInfoService.selectList(null);

         //导出数据
         String excelTitle = "车辆管理列表";
         String[] headerTitle = new String[]{"id", "年审日期", "资产所属", "资产编号", "资产状态", "购买日期", "车牌号", "颜色"};
         List<String[]> arrayList = new ArrayList<>();
         arrayList.add(headerTitle); //列头
         if (null != contractInfos && contractInfos.size() > 0) {
             for (ContractInfo contractInfo : contractInfos) {
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
    @SLog("获取合同列表数据")
    @ApiOperation(value = "获取合同列表数据", notes = "获取合同列表:使用约定的DataTable")
    @PostMapping(value = "/list")
    @ResponseBody
    public DataTable<ContractInfo> list(@RequestBody DataTable dt, ServletRequest request) {
        return contractInfoService.pageSearch(dt);
    }
    
    /**
     * 进入更新合同界面
     *
     * @param id
     * @return
     */
    @GetMapping(value = "update/{id}")
    public String update(@PathVariable("id") Long id, Model model,HttpServletRequest request) {
        model.addAttribute("action", "update");
        model.addAttribute("url", request.getContextPath() + "/car/manager/");
        ContractInfo contractInfo = contractInfoService.selectContractInfoAllInfoById(id);
        List<ContractCarInfo> ContractCarInfoList = contractCarInfoService.queryContractCarBycontractId(id);
        if(ContractCarInfoList==null&&ContractCarInfoList.isEmpty()){
        	 throw new SlifeException(HttpCodeEnum.INTERNAL_SERVER_ERROR);
        }
        logger.info(JSON.toJSONString(contractInfo));
        model.addAttribute("contractInfo", contractInfo);
        model.addAttribute("contractCarInfo", ContractCarInfoList.get(0));
        model.addAttribute("contractTypes", getcontractTypeEnum());
        return "contractInfo/detail";
    }
    
    /**
     * 查看合同详情界面
     *
     * @param id
     * @param model
     * @return
     */
    @SLog("查看合同详情界面")
    @GetMapping(value = "/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model, HttpServletRequest request) {
        model.addAttribute("action", "detail");
        ContractInfo contractInfo = contractInfoService.selectContractInfoAllInfoById(id);
        List<ContractCarInfo> ContractCarInfoList = contractCarInfoService.queryContractCarBycontractId(contractInfo.getId());
        model.addAttribute("contractInfo", contractInfo);
        model.addAttribute("contractCarInfo", ContractCarInfoList.get(0));
        model.addAttribute("url", request.getContextPath() + "/contractInfo/manager/");
        model.addAttribute("contractTypes", getcontractTypeEnum());
        return "contractInfo/detail";
    }
    
    @SLog("创建合同对象操作")
    @ApiOperation(value = "创建合同对象操作", notes = "创建合同对象操作")
    @PostMapping(value = "/insert")
    @ResponseBody
    public ReturnDTO create(ContractInfoVO contractInfoVO) {
        return contractInfoService.insertContractAndCar(contractInfoVO) == true ? ReturnDTOUtil.success() : ReturnDTOUtil.fail();
    }
    
    @SLog("进入创建合同对象界面")
    @ApiOperation(value = "进入创建合同对象界面", notes = "进入创建合同对象界面")
    @GetMapping(value = "/insert")
    public String create(Model model, HttpServletRequest request) {
        model.addAttribute("action", "insert");
        ContractInfo contractInfo = new ContractInfo();
        contractInfo.setId(0L);
        model.addAttribute("contractInfo", contractInfo);
        model.addAttribute("url", request.getContextPath() + "/contractInfo/manager/");
        model.addAttribute("contractTypes", getcontractTypeEnum());
        return "contractInfo/detail";
    }
    
    @SLog("更新合同")
    @ApiOperation(value = "更新合同", notes = "更新合同")
    @PostMapping(value = "/update")
    @ResponseBody
    public ReturnDTO update(ContractInfoVO contractInfoVO) {
    	//查询合同对象是否存在
    	ContractInfo contractInfoOld = contractInfoService.selectContractInfoAllInfoById(contractInfoVO.getContractInfoId());
        if (ObjectUtils.isEmpty(contractInfoOld)) {
            throw new SlifeException(HttpCodeEnum.NOT_FOUND);
        }
        //查询合同车辆对象是否存在
        ContractCarInfo ContractCarInfoList = contractCarInfoService.selectContractCarInfoAllInfoById(contractInfoVO.getContractCarInfoId());
        if (ObjectUtils.isEmpty(ContractCarInfoList)) {
        	throw new SlifeException(HttpCodeEnum.NOT_FOUND);
        }
        return contractInfoService.updateContractAndCar(contractInfoVO) == true ? ReturnDTOUtil.success() : ReturnDTOUtil.fail();
    }
    
    @SLog("批量删除合同对象")
    @ApiOperation(value = "批量删除合同对象", notes = "批量删除合同对象")
    @PostMapping(value = "/delete")
    @ResponseBody
    public ReturnDTO delete(@RequestParam("ids") List<Long> ids, ServletRequest request) {
        return contractInfoService.deleteContractAndCarBatchIds(ids) == true ? ReturnDTOUtil.success() : ReturnDTOUtil.fail();

    }
    
    @SLog("根据id删除合同对象")
    @ApiOperation(value = "根据id删除合同对象", notes = "根据id删除合同对象")
    @PostMapping(value = "/deleteById")
    @ResponseBody
    public ReturnDTO deleteById(@RequestParam("id") Long id, ServletRequest request) {
    	return contractInfoService.deleteContractAndCar(id) == true ? ReturnDTOUtil.success() : ReturnDTOUtil.fail();
    	
    }
    
    /**
     * 获取合同类型
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
