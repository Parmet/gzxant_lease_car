package com.gzxant.service.trailer;

import com.gzxant.base.service.IBaseService;
import com.gzxant.base.vo.DataTable;
import com.gzxant.dto.CostInfoDTO;
import com.gzxant.entity.trailer.CostInformation;

import java.io.Serializable;
import java.util.List;

/**
 * @author: Fatal
 * @date: 2018/7/27 0027 14:28
 */
public interface ICostInformationService extends IBaseService<CostInformation> {

    DataTable<CostInfoDTO> pageSearchDTO(DataTable<CostInformation> dt);

    void insertOrUpdate(CostInfoDTO costInfoDTO);

    void deleteTheBatchIds(List<? extends Serializable> list);
}
