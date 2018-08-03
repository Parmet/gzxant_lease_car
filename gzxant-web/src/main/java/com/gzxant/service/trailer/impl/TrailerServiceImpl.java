package com.gzxant.service.trailer.impl;

import com.gzxant.base.service.impl.BaseService;
import com.gzxant.base.vo.DataTable;
import com.gzxant.constant.Global;
import com.gzxant.dao.trailer.TrailerDao;
import com.gzxant.dto.TrailerDTO;
import com.gzxant.dto.TrailerFormDTO;
import com.gzxant.entity.trailer.Trailer;
import com.gzxant.enums.LeaseCarEnum;
import com.gzxant.exception.LeaseCatException;
import com.gzxant.service.trailer.ITrailerService;
import com.gzxant.shiro.GzxantSysUser;
import org.assertj.core.util.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Date;
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
            throw new LeaseCatException(LeaseCarEnum.REQUEST_PARAMETER_ERROR);
        }
        DataTable<Trailer> trailerDataTable = pageSearch(dt);
        List<Trailer> rows = trailerDataTable.getRows();
        List<TrailerDTO> list = Lists.newArrayList();
        if (rows != null && rows.size() > 0) {
            for (Trailer trailer : rows) {
                list.add(TrailerDTO.convertBackEntity(trailer));
            }
        }
        DataTable<TrailerDTO> dataTable = new DataTable<>();
        BeanUtils.copyProperties(trailerDataTable, dataTable);
        dataTable.setRows(list);
        return dataTable;
    }

    @Override
    @Transactional(readOnly = false)
    public Long insertOrUpdate(TrailerFormDTO trailerFormDTO) {
        if (trailerFormDTO == null) {
            throw new LeaseCatException(LeaseCarEnum.REQUEST_PARAMETER_ERROR);
        }
        Trailer trailer = TrailerDTO.convert4Entity(trailerFormDTO);
        trailer.setUpdateId(GzxantSysUser.id());
        trailer.setUpdateDate(new Date());
        insertOrUpdate(trailer);
        if (trailer != null) {
            return trailer.getId();
        }
        return trailer.getId();
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteTheBatchIds(List<? extends Serializable> list) {
        if (list != null && list.size() > 0) {
            for (Serializable id : list) {
                Trailer trailer = new Trailer();
                trailer.setUpdateId(GzxantSysUser.id());
                trailer.setUpdateDate(new Date());
                trailer.setId((Long) id);
                trailer.setDelFlag(Global.DEL_FLAG_DELETE);
                updateById(trailer);
            }
        } else {
            throw new LeaseCatException(LeaseCarEnum.TRAILER_DELETE_FAIL);
        }
    }

}
