package com.gzxant.service.trailer;

import com.gzxant.base.service.IBaseService;
import com.gzxant.base.vo.DataTable;
import com.gzxant.dto.TrailerDTO;
import com.gzxant.dto.TrailerFormDTO;
import com.gzxant.entity.trailer.Trailer;
import com.gzxant.vo.TrailerVO;

import java.io.Serializable;
import java.util.List;

/**
 * Trailer 服务接口
 * @author: Fatal
 * @date: 2018/7/26 0026 16:32
 */
public interface ITrailerService extends IBaseService<Trailer> {


    DataTable<TrailerDTO> pageSearchVo(DataTable<Trailer> dt);

    Long insertOrUpdate(TrailerFormDTO trailerFormDTO);

    void deleteTheBatchIds(List<? extends Serializable> list);
}
