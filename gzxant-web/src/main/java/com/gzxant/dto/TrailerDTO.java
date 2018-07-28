package com.gzxant.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gzxant.converter.Converter;
import com.gzxant.entity.trailer.Trailer;
import com.gzxant.vo.TrailerVO;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * TrailerDTO
 * @author: Fatal
 * @date: 2018/7/26 0026 16:50
 */
public class TrailerDTO {

    private Long id;

    /** 车牌号 */
    @NotNull
    @Length(min = 0, max = 18, message = "车牌号长度必须介于1和18之间")
    private String carNumber;

    /** 类型 */
    @NotNull
    private String type;

    /** 车辆所属 引用 */
    @NotNull
    private Long belongstoId;

    /** 执行人 */
    @NotNull
    @Length(min = 0, max = 5, message = "执行人姓名必须介于1和18之间")
    private String executor;

    /** 地址 */
    @NotNull
    private String place;

    /** 执行时间 */
    @NotNull
    private Date date;

    /** 状态 字典 未处理 已拖车 已缴费 */
    @NotNull
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
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

    private static Convert4Entity convert4Entity = new Convert4Entity();

    private static Convert4VO convert4VO = new Convert4VO();

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
            TrailerFormDTO formDTO = null;
            Trailer trailer = new Trailer();
            if (trailerDTO instanceof TrailerFormDTO) {
                formDTO = (TrailerFormDTO) trailerDTO;
                BeanUtils.copyProperties(formDTO, trailer);
            } else {
                BeanUtils.copyProperties(trailerDTO, trailer);
            }
            return trailer;
        }

        @Override
        protected TrailerDTO doBackward(Trailer trailer) {
            TrailerFormDTO formDTO = new TrailerFormDTO();
            BeanUtils.copyProperties(trailer, formDTO);
            return formDTO;
        }
    }
}
