package com.gzxant.controller.trailer;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.gzxant.annotation.SLog;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.constant.Global;
import com.gzxant.constant.SearchParam;
import com.gzxant.dto.TrailerDTO;
import com.gzxant.dto.TrailerFormDTO;
import com.gzxant.entity.Car;
import com.gzxant.entity.enclosure.Enclosure;
import com.gzxant.entity.SysCompany;
import com.gzxant.entity.trailer.Trailer;
import com.gzxant.enums.LeaseCarEnum;
import com.gzxant.enums.TrailerStatusEnum;
import com.gzxant.enums.TrailerTypeEnum;
import com.gzxant.exception.LeaseCatException;
import com.gzxant.service.ICarService;
import com.gzxant.service.ISysCompanyService;
import com.gzxant.service.ISysDictService;
import com.gzxant.service.enclosure.IEnclosureService;
import com.gzxant.service.trailer.ITrailerService;
import com.gzxant.util.DateUtils;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.vo.TrailerVO;
import com.sun.org.apache.xpath.internal.operations.Mod;
import io.swagger.annotations.ApiOperation;
import org.assertj.core.util.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: Fatal
 * @date: 2018/7/26 0026 16:52
 */
@Controller
@RequestMapping("/trailer")
public class TrailerController {

    @Autowired
    private ISysDictService sysDictService;

    @Autowired
    private ISysCompanyService sysCompanyService;

    @Autowired
    private ICarService carService;

    @Autowired
    private IEnclosureService enclosureService;

    @Autowired
    private ITrailerService trailerService;

    private final String DEL_FLAG = "del_flag";
    private Enclosure enclosure;
    private BindingResult result;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @ApiOperation(value = "进入拖车管理列表界面", notes = "进入拖车管理列表界面")
    @GetMapping("")
    public String listPage(Model model) {
        setListModel(model);

        return "trailer/list";
    }

    @ApiOperation(value = "获取拖车信息列表数据", notes = "获取拖车信息列表数据:使用约定的DataTable")
    @PostMapping("/list")
    @ResponseBody
    public DataTable<TrailerVO> list(@RequestBody DataTable<Trailer> dt) {
        if (dt == null) {
            throw new LeaseCatException(LeaseCarEnum.REQUEST_PARAMETER_ERROR);
        }
        dt.getSearchParams().put(SearchParam.SEARCH_EQ + DEL_FLAG, Global.DEL_FLAG_NORMAL);
        DataTable<TrailerDTO> trailerDTODataTable = trailerService.pageSearchVo(dt);
        List<TrailerDTO> rows = trailerDTODataTable.getRows();
        List<TrailerVO> list = Lists.newArrayList();
        if (rows != null && rows.size() > 0) {
            for (TrailerDTO trailerDTO : rows) {
                TrailerVO trailerVO = TrailerDTO.convert4VO(trailerDTO);
                trailerVO.setType(TrailerTypeEnum.getMessageByCode(trailerDTO.getType()));
                trailerVO.setStatus(TrailerStatusEnum.getMessageByCode(trailerDTO.getStatus()));
                trailerVO.setDate(DateUtils.getDateTime(trailerDTO.getDate()));
                SysCompany sysCompany = sysCompanyService.selectById(trailerDTO.getBelongstoId());
                if (sysCompany != null) {
                    trailerVO.setAffiliatedOrganization(sysCompany.getName());
                }
                list.add(trailerVO);
            }
        }
        DataTable<TrailerVO> dataTable = new  DataTable<TrailerVO>();
        BeanUtils.copyProperties(dt, dataTable);
        dataTable.setRows(list);
        return dataTable;
    }

    @ApiOperation(value = "进入添加拖车信息页面", notes = "进入添加拖车信息页面")
    @GetMapping(value = "/tinsert")
    public String toInsertPage(Model model) {
        model.addAttribute("action","insert");
        setBaseModel(model);

        return "trailer/insert";
    }

    @ApiOperation(value = "进入修改拖车信息页面", notes = "进入修改拖车信息页面")
    @GetMapping(value = "/tupdate/{id}")
    public String toUpdatePage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("action","insert");
        echo(id, model);

        return "trailer/insert";
    }

    @ApiOperation(value = "进入拖车信息详情页面", notes = "进入拖车信息详情页面")
    @GetMapping(value = "/tdetail/{id}")
    public String toDetailPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("action","detail");
        echo(id, model);
        return "trailer/insert";
    }

    @ApiOperation(value = "添加/编辑拖车信息", notes = "添加/编辑拖车信息")
    @PostMapping(value = "/insert")
    @ResponseBody
    public ReturnDTO create(@Valid TrailerFormDTO trailerFormDTO, BindingResult result){
        if (result.hasErrors()) {
            throw new LeaseCatException(result.getFieldError().getDefaultMessage());
        }
        Long id = trailerService.insertOrUpdate(trailerFormDTO);
        if (id == null) {
            throw new LeaseCatException(LeaseCarEnum.TRAILER_ADD_FAIL);
        }
        return ReturnDTOUtil.success(id);
    }

    @SLog("批量删除拖车数据")
    @ApiOperation(value = "批量删除数据", notes = "批量删除数据")
    @PostMapping(value = "/delete")
    @ResponseBody
    public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
        if (ids == null || ids.size() == 0) {
            return ReturnDTOUtil.fail();
        }
        trailerService.deleteTheBatchIds(ids);
        return ReturnDTOUtil.success();
    }


    @ApiOperation(value = "添加/编辑拖车附件信息", notes = "添加/编辑拖车附件信息")
    @PostMapping(value = "enclosure/insert")
    @ResponseBody
    public ReturnDTO addEnclosure(@Valid Enclosure enclosure, BindingResult result){
        if (result.hasErrors()) {
            throw new LeaseCatException(result.getFieldError().getDefaultMessage());
        }
        enclosureService.insert(enclosure);
        return ReturnDTOUtil.success();
    }


    /**
     * 下拉框需要的数据
     * @param model
     */
    private void setListModel(Model model) {
        setBaseModel(model);
        List<Car> cars = carService.selectList(null);
        if (cars != null) {
            List<String> carNumberList = cars.stream()
                    .map(e -> e.getCarNumber())
                    .collect(Collectors.toList());
            model.addAttribute("carNumberList", "");
        }

    }

    /**
     * 下拉框需要的数据
     * @param model
     */
    private void setBaseModel(Model model) {
        model.addAttribute("statusList", sysDictService.getDictTree("TRAILER_STATE"));
        model.addAttribute("typeList", sysDictService.getDictTree("TRAILER_TYPE"));
        model.addAttribute("companyList", sysCompanyService.selectList(null));
    }

    /**
     * 回显
     */
    public void echo(Long id, Model model) {
        EntityWrapper<Enclosure> ew = new EntityWrapper<>();
        ew.where("entity_id={0}",id);
        List<Enclosure> enclosures = enclosureService.selectList(ew);
        if (enclosures != null) {
            model.addAttribute("enclosure", enclosures.get(0));
        }
        Trailer trailer = trailerService.selectById(id);
        TrailerDTO trailerDTO = TrailerDTO.convertBackEntity(trailer);
        TrailerFormDTO trailerFormDTO = new TrailerFormDTO();
        BeanUtils.copyProperties(trailerDTO, trailerFormDTO);
        trailerFormDTO.setTime(DateUtils.getDateTime(trailerDTO.getDate()));
        model.addAttribute("trailer", trailerFormDTO);
        setBaseModel(model);
    }

}
