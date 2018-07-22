package com.gzxant.dao.transgress;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.gzxant.controller.vo.TransgressVo;
import com.gzxant.entity.transgress.Transgress;

public interface TransgressMapper {
	
	@Select({"<script>",
			"select * from oper_transgress ",
			"<if test=' tgVo != null'>",
			" when ",
			"</if>",
			/*  资产公司  */
			"<if test=' asset_company != null and asset_company != \"\" '>",
			" and asset_company LIKE CONCAT('%',#{asset_company},'%') ",
			"</if>",
			/*  经营公司 */
			"<if test=' operate_company != null and operate_company != \"\" '>",
			" and operate_company LIKE CONCAT('%',#{operate_company},'%') ",
			"</if>",
			/*  客户 */
			"<if test=' customer != null and customer != \"\" '>",
			" and customer LIKE CONCAT('%',#{customer},'%') ",
			"</if>",
			/*  车牌号 */
			"<if test=' plate_num != null and plate_num != \"\" '>",
			" and plate_num LIKE CONCAT('%',#{plate_num},'%') ",
			"</if>",
			/*  状态 */
			"<if test=' status != null and status != \"\" '>",
			" and status = #{status} ",
			"</if>",
			/*  违章时间开始 */
			"<if test=' tg_time_status != null and tg_time_status != \"\" '>",
			" and plate_num &gt;= #{tg_time_status} ",
			"</if>",
			/*  违章时间结束 */
			"<if test=' tg_time_end != null and tg_time_end != \"\" '>",
			" and plate_num &lt;= #{tg_time_end} ",
			"</if>",
			/*  处理时间开始 */
			"<if test=' update_time_status != null and update_time_status != \"\" '>",
			" and update_time &gt;= #{update_time_status} ",
			"</if>",
			/*  处理时间结束 */
			"<if test=' update_time_end != null and update_time_end != \"\" '>",
			" and update_time &lt;= #{update_time_end} ",
			"</if>",
			"order by query_time",
			"</script>"})
	List<Transgress> query(TransgressVo tgVo);

	@Insert("insert into oper_transgress(user_id,plate_num,type,brand,deduction,"
			+"fine,asset_company,operate_company,customer,tg_time,place,reason,"
			+"department,commisson,code,tg_num,status,query_time,update_time) values("
			+"#{user_id},#{plate_num},#{type},#{brand},#{deduction},"
			+"#{fine},#{asset_company},#{operate_company},#{customer},#{tg_time},#{place},"
			+"#{reason},#{department},#{commisson},#{code},#{tg_num},#{status},"
			+"#{query_time},#{update_time})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void add(Transgress tg);

}
