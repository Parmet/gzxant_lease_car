package com.gzxant.controller.trailer;

import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.constant.Global;
import com.gzxant.constant.SearchParam;
import com.gzxant.dto.CostInfoDTO;
import com.gzxant.entity.trailer.CostInformation;
import com.gzxant.enums.LeaseCarEnum;
import com.gzxant.exception.LeaseCatException;
import com.gzxant.service.ISysDictService;
import com.gzxant.service.trailer.ICostInformationService;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.vo.CostInfoVO;
import io.swagger.annotations.ApiOperation;
import org.assertj.core.util.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @author: Fatal
 * @date: 2018/7/27 0027 14:08
 */
@Controller
@RequestMapping("/trailer/cost")
public class CostInfoController {

    @Autowired
    private ICostInformationService costInfoService;

    @Autowired
    private ISysDictService sysDictService;

    private final String TRAILER_ID = "trailer_id";

    private final String DEL_FLAG = "del_flag";

    @PostMapping("/list/{id}")
    @ResponseBody
    public DataTable<CostInfoVO> toCostPage(@RequestBody DataTable<CostInformation> dt, @PathVariable("id") Long id) {
        if (dt == null) {
            throw new LeaseCatException(LeaseCarEnum.REQUEST_PARAMETER_ERROR);
        }
        Map<String, Object> searchParams = dt.getSearchParams();
        if (searchParams != null) {
            searchParams.put(SearchParam.SEARCH_EQ + TRAILER_ID, id);
            searchParams.put(SearchParam.SEARCH_EQ + DEL_FLAG , Global.DEL_FLAG_NORMAL);
        }
        DataTable<CostInfoDTO> costInfoDTODataTable = costInfoService.pageSearchDTO(dt);
        List<CostInfoDTO> rows = costInfoDTODataTable.getRows();
        List<CostInfoVO> list = Lists.newArrayList();;
        if (rows != null && rows.size() > 0) {
            for (CostInfoDTO costInfoDTO : rows) {
                CostInfoVO costInfoVO = CostInfoDTO.convert4VO(costInfoDTO);
                list.add(costInfoVO);
            }
        }
        DataTable<CostInfoVO> dataTable = new DataTable<>();
        BeanUtils.copyProperties(costInfoDTODataTable, dataTable);
        dataTable.setRows(list);
        return dataTable;
    }

    @ApiOperation(value = "进入添加拖车消费信息页面", notes = "进入添加拖车消费信息页面")
    @GetMapping(value = "/insert/{id}")
    public String toInsertPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("action","insert");
        model.addAttribute("trailerId",id);
        model.addAttribute("typeList", sysDictService.getDictTree("TRAILER_TYPE"));
        return "trailer/cost/insert";
    }

    @ApiOperation(value = "进入编辑拖车消费信息页面", notes = "进入编辑拖车消费信息页面")
    @GetMapping(value = "/update/{id}")
    public String toUpdatePage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("action","insert");
        model.addAttribute("typeList", sysDictService.getDictTree("TRAILER_TYPE"));
        CostInformation costInformation = costInfoService.selectById(id);
        CostInfoDTO costInfoDTO = CostInfoDTO.convertBackEntity(costInformation);
        model.addAttribute("costInfo",costInfoDTO);
        return "trailer/cost/insert";
    }

    @ApiOperation(value = "添加/编辑拖车花费信息", notes = "添加/编辑拖车花费信息")
    @PostMapping(value = "/insert")
    @ResponseBody
    public ReturnDTO create(@Valid CostInfoDTO costInfoDTO, BindingResult result){
        if (result.hasErrors()) {
            throw new LeaseCatException(result.getFieldError().getDefaultMessage());
        }
        costInfoService.insertOrUpdate(costInfoDTO);
        return ReturnDTOUtil.success();
    }

    @ApiOperation(value = "批量删除花费数据", notes = "批量删除花费数据")
    @PostMapping(value = "/delete")
    @ResponseBody
    public ReturnDTO delete(@RequestParam("ids") List<Long> ids, ServletRequest request) {
        if (ids == null || ids.size() == 0) {
            return ReturnDTOUtil.fail();
        }
        costInfoService.deleteTheBatchIds(ids);
        return ReturnDTOUtil.success();
    }

}
