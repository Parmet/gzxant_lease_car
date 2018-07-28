package com.gzxant.dto;

import com.gzxant.converter.Converter;
import com.gzxant.entity.trailer.CostInformation;
import com.gzxant.util.DateUtils;
import com.gzxant.vo.CostInfoVO;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author: Fatal
 * @date: 2018/7/27 0027 14:14
 */
public class CostInfoDTO {

    private Long id;

    /** 类型 */
    @NotNull(message = "类型 不能为空")
    private String type;

    /** 编号 */
    @NotNull(message = "编号 不能为空")
    private String trailerId;

    /** 费用 */
    @NotNull(message = "费用 不能为空")
    private BigDecimal cost;

    /** 日期 */
    @NotNull(message = "日期 不能为空")
    private String date;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTrailerId() {
        return trailerId;
    }

    public void setTrailerId(String trailerId) {
        this.trailerId = trailerId;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    /*---------------------------------     工具类    -------------------------------*/

    private static CostInfoDTO.Convert4Entity convert4Entity = new CostInfoDTO.Convert4Entity();

    private static CostInfoDTO.Convert4VO convert4VO = new CostInfoDTO.Convert4VO();

    /**
     * CostInfoDTO     ->     CostInfoVO
     * @param costInfoDTO
     * @return
     */
    public static CostInfoVO convert4VO(CostInfoDTO costInfoDTO) {
        return convert4VO.doForward(costInfoDTO);
    }


    /**
     * CostInfoDTO      ->      CostInformation
     * @param costInfoDTO
     * @return
     */
    public static CostInformation convert4Entity(CostInfoDTO costInfoDTO) {
        return convert4Entity.doForward(costInfoDTO);
    }


    /**
     * CostInformation      ->      CostInfoDTO
     * @param costInformation
     * @return
     */
    public static CostInfoDTO convertBackEntity(CostInformation costInformation) {
        return convert4Entity.doBackward(costInformation);
    }



    /*---------------------------------     封装的规范    -------------------------------*/

    /**
     * 私有的静态转换类
     */
    private static class Convert4VO extends Converter<CostInfoDTO, CostInfoVO> {
        @Override
        protected CostInfoVO doForward(CostInfoDTO costInfoDTO) {
            CostInfoVO costInfoVO = new CostInfoVO();
            BeanUtils.copyProperties(costInfoDTO, costInfoVO);
            return costInfoVO;
        }

        @Override
        protected CostInfoDTO doBackward(CostInfoVO costInfoVO) {
            throw new AssertionError("不支持逆向转化方法!");
        }
    }

    /**
     * 私有的静态转换类
     */
    private static class Convert4Entity extends Converter<CostInfoDTO, CostInformation> {

        @Override
        protected CostInformation doForward(CostInfoDTO costInfoDTO) {
            CostInformation costInformation = new CostInformation();
            BeanUtils.copyProperties(costInfoDTO, costInformation);
            costInformation.setDate(DateUtils.StrToDate(costInfoDTO.getDate()));
            return costInformation;
        }

        @Override
        protected CostInfoDTO doBackward(CostInformation costInformation) {
            CostInfoDTO costInfoDTO = new CostInfoDTO();
            BeanUtils.copyProperties(costInformation, costInfoDTO);
            costInfoDTO.setDate(DateUtils.getDateTime(costInformation.getDate()));
            return costInfoDTO;
        }
    }

    @Override
    public String toString() {
        return "CostInfoDTO{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", trailerId='" + trailerId + '\'' +
                ", cost=" + cost +
                ", date='" + date + '\'' +
                '}';
    }
}
