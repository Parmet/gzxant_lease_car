package com.gzxant.service.customer.info.company;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.gzxant.base.vo.DataTable;
import com.gzxant.constant.Global;
import com.gzxant.constant.SearchParam;
import com.gzxant.dto.CompanyDTO;
import com.gzxant.entity.SysCompany;
import com.gzxant.enums.LeaseCarEnum;
import com.gzxant.exception.LeaseCatException;
import com.gzxant.service.ISysCompanyService;
import com.gzxant.util.ConvertUtil;
import com.gzxant.util.DateUtils;
import com.gzxant.vo.CompanyVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.customer.info.company.CustomerInfoCompany;
import com.gzxant.dao.customer.info.company.CustomerInfoCompanyDao;
import com.gzxant.service.customer.info.company.ICustomerInfoCompanyService;
import com.gzxant.base.service.impl.BaseService;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tecty
 * @since 2018-07-05
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CustomerInfoCompanyService extends BaseService<CustomerInfoCompanyDao, CustomerInfoCompany>
        implements ICustomerInfoCompanyService {

    private final String ENTERPRISE_NUMBER_PREFIX = "Q00";

    @Autowired
    private ISysCompanyService iSysCompanyService;

    @Override
    public DataTable<CompanyDTO> pageSearchDTO(DataTable<CustomerInfoCompany> dt) {
        dt.getSearchParams().put("search_like_del_flag",Global.DEL_FLAG_NORMAL);
        DataTable<CustomerInfoCompany> companyDataTable = super.pageSearch(dt);
        List<CustomerInfoCompany> rows = companyDataTable.getRows();
        if (rows != null && rows.size() != 0) {
            List<CompanyDTO> companyDTOS = ConvertUtil.convertEntitys2CompanyDTOS(rows);
            for (CompanyDTO companyDTO : companyDTOS) {
                SysCompany sysCompany = iSysCompanyService.selectById(companyDTO.getBelongsto());
                companyDTO.setBelongsto(sysCompany.getName());
            }
            DataTable<CompanyDTO> companyDTODateTable = new DataTable<>();
            BeanUtils.copyProperties(companyDataTable, companyDTODateTable);
            companyDTODateTable.setRows(companyDTOS);
            return companyDTODateTable;
        }
        return null;
    }

    @Override
    @Transactional
    public Long insertOrUpdate(CompanyVO companyVO) {
        if (companyVO == null) {
            throw new LeaseCatException(LeaseCarEnum.COMPANY_OR_UPDATE_ADD_FAIL);
        }
        CustomerInfoCompany company = new CustomerInfoCompany();
        BeanUtils.copyProperties(companyVO, company);
        if (companyVO.getId() == null) {
            Integer count = selectCount(null);
            count ++;
            company.setEnterpriseNumber(ENTERPRISE_NUMBER_PREFIX + count);
        }
        company.setRegisteredDate(DateUtils.convertStrToDate(companyVO.getRegisteredDate()));
        insertOrUpdate(company);
        Long id = company.getId();
        if (id != null) {
            return id;
        }
        return null;
    }

    @Override
    public CompanyVO selectById(Long id) {
        if (id != null) {
            CustomerInfoCompany company = super.selectById(id);
            CompanyVO companyVO = new CompanyVO();
            BeanUtils.copyProperties(company, companyVO);
            companyVO.setRegisteredDate(DateUtils.getDateTime("yyyy-MM-dd", company.getRegisteredDate()));
            return companyVO;
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteTheBatchIds(List<? extends Serializable> list) {
        if (list != null) {
            for (Serializable id : list) {
                CustomerInfoCompany company = new CustomerInfoCompany();
                company.setId((Long) id);
                company.setDelFlag(Global.DEL_FLAG_DELETE);
                updateById(company);
            }
        }
    }

    /**
     * 导出数据
     */
    @Override
    public List<CompanyDTO> selectList() {
        Map<String, Object> map = new HashMap<>();
        map.put("del_flag", Global.DEL_FLAG_NORMAL);
        List<CustomerInfoCompany> companies = selectByMap(map);
        List<CompanyDTO> companyDTOS = ConvertUtil.convertEntitys2CompanyDTOS(companies);
        return companyDTOS;
    }


}
