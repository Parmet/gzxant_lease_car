package com.gzxant.dto;

import com.gzxant.converter.Converter;
import com.gzxant.entity.trailer.Trailer;
import com.gzxant.vo.TrailerVO;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * TrailerDTO
 * @author: Fatal
 * @date: 2018/7/26 0026 16:50
 */
public class TrailerDTO {

    /** 车牌号 */
    private String carNumber;

    /** 类型 */
    private String type;

    /** 车辆所属 引用 */
    private Long belongstoId;

    /** 执行人 */
    private String executor;

    /** 地址 */
    private String place;

    /** 执行时间 */
    private Date date;

    /** 状态 字典 未处理 已拖车 已缴费 */
    private String status;

    private static Convert4Entity convert4Entity = new Convert4Entity();

    private static Convert4VO convert4VO = new Convert4VO();

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getBelongstoId() {
        return belongstoId;
    }

    public void setBelongstoId(Long belongstoId) {
        this.belongstoId = belongstoId;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    /*---------------------------------     工具类    -------------------------------*/

    /**
     *  TrailerDTO   ->   TrailerVO
     * @param trailerDTO
     * @return
     */
    public static TrailerVO convert4VO(TrailerDTO trailerDTO) {
        return convert4VO.doForward(trailerDTO);
    }


    /**
     * TrailerDTO   ->   Trailer
     * @param trailerDTO
     * @return
     */
    public static Trailer convert4Entity(TrailerDTO trailerDTO) {
        return convert4Entity.doForward(trailerDTO);
    }

    /**
     * Trailer  ->   TrailerDTO
     * @param trailer
     * @return
     */
    public static TrailerDTO convertBackEntity(Trailer trailer) {
        return convert4Entity.doBackward(trailer);
    }


    /*---------------------------------     封装的规范    -------------------------------*/

    /**
     * 私有的静态转换类
     */
    private static class Convert4VO extends Converter<TrailerDTO, TrailerVO> {
        @Override
        protected TrailerVO doForward(TrailerDTO trailerDTO) {
            TrailerVO trailerVO = new TrailerVO();
            BeanUtils.copyProperties(trailerDTO, trailerVO);
            return trailerVO;
        }

        @Override
        protected TrailerDTO doBackward(TrailerVO trailerVO) {
            throw new AssertionError("不支持逆向转化方法!");
        }
    }

    /**
     * 私有的静态转换类
     */
    private static class Convert4Entity extends Converter<TrailerDTO, Trailer> {

        @Override
        protected Trailer doForward(TrailerDTO trailerDTO) {
            Trailer trailer = new Trailer();
            BeanUtils.copyProperties(trailerDTO, trailer);
            return trailer;
        }

        @Override
        protected TrailerDTO doBackward(Trailer trailer) {
            TrailerDTO trailerDTO = new TrailerDTO();
            BeanUtils.copyProperties(trailer, trailerDTO);
            return trailerDTO;
        }
    }
}
