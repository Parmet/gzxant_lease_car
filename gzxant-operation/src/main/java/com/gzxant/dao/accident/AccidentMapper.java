package com.gzxant.dao.accident;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gzxant.controller.vo.AccidentVo;
import com.gzxant.entity.accident.Accident;

public interface AccidentMapper {

	@Insert("insert into oper_accident(plate_num,brand,accident_time,accident_place,"
			+"model_num,vin,details,user_unit,driver,use_nature,responsibility_divide,"
			+"minor_wound,serious_injury,death,myself_loss,myself_treatment_cost,"
			+"third_party_loss,third_party_treatment_cost,reimbursement_cost,grade,status,"
			+"oper_nature,schedule,remake,attachment_path) values("
			+"#{plateNum},#{brand},#{accidentTime},#{accidentPlace},"
			+"#{modelNum},#{vin},#{details},#{userUnit},#{driver},#{useNature},#{responsibilityDivide},"
			+"#{minorWound},#{seriousInjury},#{death},#{myselfLoss},#{myselfTreatmentCost},"
			+"#{thirdPartyLoss},#{thirdPartyTreatmentCost},#{reimbursementCost},#{grade},#{status},"
			+"#{operNature},#{schedule},#{remake},#{attachmentPath})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void insert(Accident accident);

	
	@Select({"<script>",
		"select * from oper_accident where 1=1 ",
		/*  所属组织|使用单位  */
		"<if test=' userUnit != null and userUnit != \"\" '>",
		" and user_unit = #{userUnit} ",
		"</if>",
		/*  车型号 */
		"<if test=' modelNum != null and modelNum != \"\" '>",
		" and model_num = #{modelNum} ",
		"</if>",
		/*  车牌号 */
		"<if test=' plateNum != null and plateNum != \"\" '>",
		" and plate_num LIKE CONCAT('%',#{plateNum},'%') ",
		"</if>",
		/*  事故等级 */
		"<if test=' grade != null and grade != \"\" '>",
		" and grade &gt;= #{grade} ",
		"</if>",
		/*  状态 */
		"<if test=' status != null and status != \"\" '>",
		" and status = #{status} ",
		"</if>",
		/*  处理时间开始 */
		"<if test=' accidentTimeStart != null and accidentTimeStart != \"\" '>",
		" and accident_time &gt;= #{accidentTimeStart} ",
		"</if>",
		/*  处理时间结束 */
		"<if test=' accidentTimeEnd != null and accidentTimeEnd != \"\" '>",
		" and accident_time &lt;= #{accidentTimeEnd} ",
		"</if>",
		"order by accident_time desc",
		"</script>"})
	@Results({
		@Result(property = "plateNum", column = "plate_num"),
		@Result(property = "accidentTime", column = "accident_time"),
		@Result(property = "accidentPlace", column = "accident_place"),
		@Result(property = "modelNum", column = "model_num"),
		@Result(property = "userUnit", column = "user_unit"),
		@Result(property = "useNature", column = "use_nature"),
		@Result(property = "responsibilityDivide", column = "responsibility_divide"),
		@Result(property = "minorWound", column = "minor_wound"),
		@Result(property = "seriousInjury", column = "serious_injury"),
		@Result(property = "myselfLoss", column = "myself_loss"),
		@Result(property = "myselfTreatmentCost", column = "myself_treatment_cost"),
		@Result(property = "thirdPartyLoss", column = "third_party_loss"),
		@Result(property = "thirdPartyTreatmentCost", column = "third_party_treatment_cost"),
		@Result(property = "reimbursementCost", column = "reimbursement_cost"),
		@Result(property = "operNature", column = "oper_nature"),
		@Result(property = "attachmentPath", column = "attachment_path")
	})
	List<Accident> query(AccidentVo aVo);

	@Select("select * from oper_accident where id = #{id}")
	@Results({
		@Result(property = "plateNum", column = "plate_num"),
		@Result(property = "accidentTime", column = "accident_time"),
		@Result(property = "accidentPlace", column = "accident_place"),
		@Result(property = "modelNum", column = "model_num"),
		@Result(property = "userUnit", column = "user_unit"),
		@Result(property = "useNature", column = "use_nature"),
		@Result(property = "responsibilityDivide", column = "responsibility_divide"),
		@Result(property = "minorWound", column = "minor_wound"),
		@Result(property = "seriousInjury", column = "serious_injury"),
		@Result(property = "myselfLoss", column = "myself_loss"),
		@Result(property = "myselfTreatmentCost", column = "myself_treatment_cost"),
		@Result(property = "thirdPartyLoss", column = "third_party_loss"),
		@Result(property = "thirdPartyTreatmentCost", column = "third_party_treatment_cost"),
		@Result(property = "reimbursementCost", column = "reimbursement_cost"),
		@Result(property = "operNature", column = "oper_nature"),
		@Result(property = "attachmentPath", column = "attachment_path")
	})
	List<Accident> getAccidentById(Integer id);

	@Update("update oper_accident set plate_num = #{plateNum}, brand = #{brand}, accident_time = #{accidentTime},"
		+ " accident_place = #{accidentPlace}, model_num = #{modelNum}, vin = #{vin}, details = #{details},"
		+ " user_unit = #{userUnit}, driver = #{driver}, use_nature = #{useNature}, responsibility_divide = #{responsibilityDivide},"
		+ " minor_wound = #{minorWound}, serious_injury = #{seriousInjury}, death = #{death},"
		+ " myself_loss = #{myselfLoss}, myself_treatment_cost = #{myselfTreatmentCost},"
		+ " third_party_loss = #{thirdPartyLoss}, third_party_treatment_cost = #{thirdPartyTreatmentCost},"
		+ " reimbursement_cost = #{reimbursementCost}, grade = #{grade}, status = #{status},"
		+ " oper_nature = #{operNature}, schedule = #{schedule}, remake = #{remake}, attachment_path = #{attachmentPath}"
		+ " where id = #{id}")
	void update(Accident accident);

	@Delete("delete from oper_accident where id = #{id}")
	void delete(Integer id);

}
