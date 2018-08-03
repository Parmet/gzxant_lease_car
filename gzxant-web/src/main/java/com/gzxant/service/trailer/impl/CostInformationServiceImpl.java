package com.gzxant.service.trailer.impl;

import com.gzxant.base.service.impl.BaseService;
import com.gzxant.base.vo.DataTable;
import com.gzxant.constant.Global;
import com.gzxant.constant.SearchParam;
import com.gzxant.dao.trailer.CostInformationDao;
import com.gzxant.dto.CostInfoDTO;
import com.gzxant.entity.trailer.CostInformation;
import com.gzxant.enums.LeaseCarEnum;
import com.gzxant.enums.TrailerStatusEnum;
import com.gzxant.enums.TrailerTypeEnum;
import com.gzxant.exception.LeaseCatException;
import com.gzxant.service.ISysDictService;
import com.gzxant.service.trailer.ICostInformationService;
import com.gzxant.shiro.GzxantSysUser;
import org.assertj.core.util.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Fatal
 * @date: 2018/7/27 0027 14:29
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CostInformationServiceImpl extends BaseService<CostInformationDao, CostInformation>
        implements ICostInformationService {

    @Override
    public DataTable<CostInfoDTO> pageSearchDTO(DataTable<CostInformation> dt) {
        if (dt == null) {
            throw new LeaseCatException(LeaseCarEnum.REQUEST_PARAMETER_ERROR);
        }
        DataTable<CostInformation> costInformationDataTable = pageSearch(dt);
        List<CostInformation> rows = costInformationDataTable.getRows();
        List<CostInfoDTO> list = Lists.newArrayList();
        if (rows != null && rows.size() > 0) {
            for (CostInformation costInformation : rows) {
                CostInfoDTO costInfoDTO = CostInfoDTO.convertBackEntity(costInformation);
                String messageByCode = TrailerTypeEnum.getMessageByCode(costInfoDTO.getType());
                costInfoDTO.setType(messageByCode);
                list.add(costInfoDTO);
            }
        }
        DataTable<CostInfoDTO> dataTable = new DataTable<>();
        BeanUtils.copyProperties(dt, dataTable);
        dataTable.setRows(list);
        return dataTable;
    }

    @Override
    @Transactional(readOnly = false)
    public void insertOrUpdate(CostInfoDTO costInfoDTO) {
        if (costInfoDTO == null) {
            throw new LeaseCatException(LeaseCarEnum.REQUEST_PARAMETER_ERROR);
        }
        CostInformation costInformation = CostInfoDTO.convert4Entity(costInfoDTO);
        costInformation.setUpdateId(GzxantSysUser.id());
        costInformation.setUpdateDate(new Date());
        insertOrUpdate(costInformation);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteTheBatchIds(List<? extends Serializable> list) {
        if (list != null && list.size() > 0) {
            for (Serializable id : list) {
                CostInformation costInformation = new CostInformation();
                costInformation.setId((Long) id);
                costInformation.setUpdateId(GzxantSysUser.id());
                costInformation.setUpdateDate(new Date());
                costInformation.setDelFlag(Global.DEL_FLAG_DELETE);
                updateById(costInformation);
            }
        } else {
            throw new LeaseCatException(LeaseCarEnum.TRAILER_COST_DELETE_FAIL);
        }
    }
}
