package com.gzxant.service.trailer;

import com.gzxant.base.service.IBaseService;
import com.gzxant.base.vo.DataTable;
import com.gzxant.dto.TrailerDTO;
import com.gzxant.entity.trailer.Trailer;
import com.gzxant.vo.TrailerVO;

/**
 * Trailer 服务接口
 * @author: Fatal
 * @date: 2018/7/26 0026 16:32
 */
public interface ITrailerService extends IBaseService<Trailer> {


    DataTable<TrailerDTO> pageSearchVo(DataTable<Trailer> dt);
}
