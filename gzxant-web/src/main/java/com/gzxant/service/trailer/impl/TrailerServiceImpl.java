package com.gzxant.service.trailer.impl;

import com.gzxant.base.service.impl.BaseService;
import com.gzxant.base.vo.DataTable;
import com.gzxant.dao.trailer.TrailerDao;
import com.gzxant.dto.TrailerDTO;
import com.gzxant.entity.trailer.Trailer;
import com.gzxant.enums.SlifeEnum;
import com.gzxant.exception.SlifeException;
import com.gzxant.service.trailer.ITrailerService;
import com.gzxant.vo.TrailerVO;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *  Trailer 服务
 *
 * @author: Fatal
 * @date: 2018/7/26 0026 16:37
 */
@Service
@Transactional(readOnly = true,rollbackFor = Exception.class)
public class TrailerServiceImpl extends BaseService<TrailerDao, Trailer>
        implements ITrailerService {

    @Override
    public DataTable<TrailerDTO> pageSearchVo(DataTable<Trailer> dt) {
        if (dt == null) {
            throw new SlifeException(SlifeEnum.REQUEST_PARAMETER_ERROR);
        }
        DataTable<Trailer> trailerDataTable = pageSearch(dt);
        List<Trailer> rows = trailerDataTable.getRows();
        List<TrailerDTO> list = null;
        if (rows != null && rows.size() > 0) {
            for (Trailer trailer : rows) {
                list = Lists.newArrayList();
                list.add(TrailerDTO.convertBackEntity(trailer));
            }
        }
        DataTable<TrailerDTO> dataTable = new DataTable<>();
        dataTable.setRows(list);
        return dataTable;
    }

}
