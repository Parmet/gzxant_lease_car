package com.gzxant.dao.transgress;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.gzxant.controller.vo.TransgressVo;
import com.gzxant.entity.transgress.Transgress;

public interface TransgressMapper {
	
	@Select({"<script>",
			"select * from oper_transgress where 1=1 ",
			/*  资产公司  */
			"<if test=' assetCompany != null and assetCompany != \"\" '>",
			" and asset_company LIKE CONCAT('%',#{assetCompany},'%') ",
			"</if>",
			/*  经营公司 */
			"<if test=' operateCompany != null and operateCompany != \"\" '>",
			" and operate_company LIKE CONCAT('%',#{operateCompany},'%') ",
			"</if>",
			/*  客户 */
			"<if test=' customer != null and customer != \"\" '>",
			" and customer LIKE CONCAT('%',#{customer},'%') ",
			"</if>",
			/*  车牌号 */
			"<if test=' plateNum != null and plateNum != \"\" '>",
			" and plate_num LIKE CONCAT('%',#{plateNum},'%') ",
			"</if>",
			/*  状态 */
			"<if test=' status != null and status != \"\" '>",
			" and status = #{status} ",
			"</if>",
			/*  违章时间开始 */
			"<if test=' tgTimeStart != null and tgTimeStart != \"\" '>",
			" and plate_num &gt;= #{tgTimeStart} ",
			"</if>",
			/*  违章时间结束 */
			"<if test=' tgTimeEnd != null and tgTimeEnd != \"\" '>",
			" and plate_num &lt;= #{tgTimeEnd} ",
			"</if>",
			/*  处理时间开始 */
			"<if test=' updateTimeStart != null and updateTimeStart != \"\" '>",
			" and update_time &gt;= #{updateTimeStart} ",
			"</if>",
			/*  处理时间结束 */
			"<if test=' updateTimeEnd != null and updateTimeEnd != \"\" '>",
			" and update_time &lt;= #{updateTimeEnd} ",
			"</if>",
			"order by query_time desc",
			"</script>"})
	@Results({
		@Result(property = "plateNum", column = "plate_num"),
		@Result(property = "assetCompany", column = "asset_company"),
		@Result(property = "operateCompany", column = "operate_company"),
		@Result(property = "tgTime", column = "tg_time"),
		@Result(property = "tgNum", column = "tg_num"),
		@Result(property = "queryTime", column = "query_time"),
		@Result(property = "updateTime", column = "update_time")
	})
	List<Transgress> query(TransgressVo tgVo);

	@Insert("insert into oper_transgress(plate_num,type,brand,deduction,"
			+"fine,asset_company,operate_company,customer,tg_time,place,reason,"
			+"department,commisson,code,tg_num,status,query_time,update_time) values("
			+"#{plateNum},#{type},#{brand},#{deduction},"
			+"#{fine},#{assetCompany},#{operateCompany},#{customer},#{tgTime},#{place},"
			+"#{reason},#{department},#{commisson},#{code},#{tgNum},#{status},"
			+"#{queryTime},#{updateTime})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void add(Transgress tg);

	@Select({"<script>",
			"select count(1) from oper_transgress where 1=1 ",
			/*  所属组织|使用单位  */
			"<if test=' id != null and id != \"\" '>",
			" and asset_company = #{id} ",
			"</if>",
			"<if test=' beginDate != null and endDate != null '>",
			" and tg_time between #{beginDate} and #{endDate}",
			"</if>",
			"</script>"})
	int selectCount(Long id, Date beginDate, Date endDate);

}
