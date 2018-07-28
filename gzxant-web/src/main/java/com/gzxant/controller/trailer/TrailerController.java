package com.gzxant.controller.trailer;

import com.google.common.collect.Maps;
import com.gzxant.base.vo.DataTable;
import com.gzxant.dto.TrailerDTO;
import com.gzxant.entity.Car;
import com.gzxant.entity.SysCompany;
import com.gzxant.entity.trailer.Trailer;
import com.gzxant.enums.SlifeEnum;
import com.gzxant.exception.SlifeException;
import com.gzxant.service.ICarService;
import com.gzxant.service.ISysCompanyService;
import com.gzxant.service.ISysDictService;
import com.gzxant.service.trailer.ITrailerService;
import com.gzxant.vo.TrailerVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Fatal
 * @date: 2018/7/26 0026 16:52
 */
@Controller
@RequestMapping("/trailer")
public class TrailerController {

    @Autowired
    private ISysDictService iSysDictService;

    @Autowired
    private ISysCompanyService iSysCompanyService;

    @Autowired
    private ICarService iCarService;

    @Autowired
    private ITrailerService iTrailerService;


    @ApiOperation(value = "进入拖车管理列表界面", notes = "进入拖车管理列表界面")
    @GetMapping("")
    public String listPage(Model model) {
        setListModel(model);
        return "trailer/list";
    }

    @GetMapping("/info")
    public DataTable<TrailerVO> list(@RequestBody DataTable<Trailer> dt) {
        if (dt == null) {
            throw new SlifeException(SlifeEnum.REQUEST_PARAMETER_ERROR);
        }
        DataTable<TrailerDTO> trailerDTODataTable = iTrailerService.pageSearchVo(dt);
        return null;
    }



    /**
     * 下拉框需要的数据
     * @param model
     */
    private void setListModel(Model model) {
        setBaseModel(model);
        List<Car> cars = iCarService.selectList(null);
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
        model.addAttribute("statusList", iSysDictService.getDictTree("TRAILER_STATE"));
        model.addAttribute("typeList", iSysDictService.getDictTree("TRAILER_TYPE"));

        List<SysCompany> sysCompanies = iSysCompanyService.selectList(null);
        if (sysCompanies != null && sysCompanies.size() > 0) {
            //TODO 不知道能不能用map map在ftl怎么取值
            HashMap<Object, Object> map = Maps.newHashMap();
            sysCompanies.stream()
                    .map(e -> map.put(e.getId(), e.getName()));
            model.addAttribute("companyMap", map);
        }
    }

}
