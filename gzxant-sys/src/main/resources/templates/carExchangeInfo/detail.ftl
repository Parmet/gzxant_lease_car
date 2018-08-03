<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
   
                    <form class="form-horizontal form-bordered" id="gzxantForm" >
                        <input type="hidden" name="id" value="${carExchangeInfo.id}"/>
                        <font size="6">车辆申请更换信息</font>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">原合同号<span class="required">*</span></label>
                            <div class="col-sm-3">
					             <select class=" form-control _search" id="contractNoOld" name="contractNoOld" value="${carExchangeInfo.contractNoOld}"  onchange="gradeChangeOld()">
						          <option value = "">请选择</option>
					             	<#list contractInfoNews as contractInfoNew>
						              <option value="${contractInfoNew.contractNo}">${contractInfoNew.contractNo}</option>
						          </#list>
					             </select>                                  
                            </div>
                            <#if action =='insert'>
	                            <label class="col-sm-3 control-label">新合同号<span class="required">*</span></label>
	                            <div class="col-sm-3">
						             <select class=" form-control _search" id="contractNoNew" name="contractNoNew" value="${carExchangeInfo.contractNoNew}" onchange="gradeChangeNew()" >
							          <option value = " ">请选择</option>
						             	<#list contractInfoNews as contractInfoNew>
							              <option value="${contractInfoNew.contractNo}">${contractInfoNew.contractNo}</option>
							          </#list>
						             </select>                                  
	                            </div>
                            </#if>
   
                        </div>
                        
                        <div class="form-group">
                            <label class="col-sm-3 control-label">原车牌号<span class="required">*</span></label>
                            <div class="col-sm-3" readonly="readonly" >
                                <input name="carNumber" id="carNumber" readonly="readonly" type="text" class="form-control" value="${carExchangeInfo.carNumber}">                         	
                            </div>
                            
                            <label class="col-sm-3 control-label">预申请车牌号<span class="required">*</span></label>
                            <div class="col-sm-3"  >
                                <input name="applyCarNumber" id="applyCarNumber" readonly="readonly"   type="text" class="form-control" value="${carExchangeInfo.applyCarNumber}">                         	
                            </div>
                            
                        </div>
                        
                        <div class="form-group">
                            <label class="col-sm-3 control-label">申请人<span class="required">*</span></label>
                            <div class="col-sm-3">
                                <input name="applicant" type="text" class="form-control" value="${carExchangeInfo.applicant}">                         	
                            </div>
                            
                            <label class="col-sm-3 control-label">申请人身份证<span class="required">*</span></label>
                            <div class="col-sm-3">
                                <input name="applicantIDNum" type="text" class="form-control" value="${carExchangeInfo.applicantIDNum}">      	
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-sm-3 control-label">申请单位<span class="required">*</span></label>
                            <div class="col-sm-3">
                                <input name="applicationUnit" type="text" class="form-control" value="${carExchangeInfo.applicationUnit}">                   	
                            </div>
                            
                            <label class="col-sm-3 control-label">申请原因<span class="required">*</span></label>
                            <div class="col-sm-3">
                                <input name="applyReason" type="text" class="form-control" value="${carExchangeInfo.applyReason}">                   	
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-sm-3 control-label">申请日期</label>
                            <div class="col-sm-3">
                                <input name="applyDate" type="date" class="form-control" value="${carExchangeInfo.applyDate}">                         	
                            </div>
                        </div>

	                    <#if action !='detail'>
	                        <div class="form-actions fluid">
	                            <div class="col-md-offset-3 col-md-9">
	                                <button type="submit" class="btn-green">保存</button>
	                            </div>
	                        </div>
	                    </#if>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript">

	
		
	function gradeChangeOld(){
		var contractNoOld=$("#contractNoOld option:selected").val();
		console.log(contractNoOld)
		$("#contractNoNew option").each(function(i,no){
			if($(no).val() === contractNoOld){
				$(no).attr("hidden","hidden")
			}else{
				$(no).removeAttr("hidden")
			}
		})
		$.ajax({
                url: base_url +"/contractInfo/manager/queryCarNumByContractNo",
                type: "POST",
                data: {
                    'contractNo': contractNoOld
                },
                success: function (r) {
                	//查询的到车牌号就填充进输入框
                    if (r.code == 200) {
                    	$("#carNumber").val(r.data);
                    } else if(r.code == 1001) {
                    	//如果没查找到就隐藏掉这个合同号
                    	$("#contractNoOld option:selected").attr("hidden","hidden");
                    	$("#contractNoOld option:selected").text("");
                    	$("#carNumber").val(r.data);
                    	$("#contractNoNew option").each(function(i,no){
							if($(no).val() === contractNoOld){
								$(no).attr("hidden","hidden")
								$(no).text("")
							}
						})
                    }
                    
                    
                }
            });
		
	}
	
	function gradeChangeNew(){
		var contractNoNew=$("#contractNoNew option:selected").val();	
		console.log(contractNoNew)
		$("#contractNoOld option").each(function(i,no){
			if($(no).val() === contractNoNew){
				$(no).attr("hidden","hidden")
			}else{
				$(no).removeAttr("hidden")
			}
		})
		$.ajax({
                url: base_url +"/contractInfo/manager/queryCarNumByContractNo",
                type: "POST",
                data: {
                    'contractNo': contractNoNew
                },
                success: function (r) {
                	//查询的到车牌号就填充进输入框
                    if (r.code == 200) {
                    	$("#applyCarNumber").val(r.data);
                    } else if(r.code == 1001) {
                    	//如果没查找到就隐藏掉这个合同号
                    	$("#contractNoNew option:selected").attr("hidden","hidden");
                    	$("#contractNoNew option:selected").text("");
                    	$("#applyCarNumber").val("");
                    	$("#contractNoOld option").each(function(i,no){
							if($(no).val() === contractNoNew){
								$(no).attr("hidden","hidden")
								$(no).text("")
							}
						})
                    }
                    
                    
                }
            });
		
	}

	action = "${action}";
    function  cusFunction() {
        console.info("提交之前，最后执行自定义的函数");
    }

    var select = $(".select").select2();
    <#if action !='insert'>
	    $("select[name=contractNoOld] option[value='${carExchangeInfo.contractNoOld}']").attr("selected", "selected");
	    $("select[name=contractNoNew] option[value='${carExchangeInfo.contractNoNew}']").attr("selected", "selected");
	    
	    var data = [];
	        <#list car.sysRoles as r>
	        data.push({id:${r.id}, text: '${r.name}'});
	        </#list>
	    select.select2("data", data);
    	$("#contractNoOld").attr("disabled","disabled");
    </#if>

    var form = $('#gzxantForm');
    var error = $('.alert-danger', form);
    form.validate({
        errorElement: 'span',
        errorClass: 'error',
        focusInvalid: true,
        messages: {
        	carNumber: {rangelength: "车牌长度必须为7"}
        },
        rules: {
            contractNo: {
                required: true
            },
            carNumber: {
                required: true
            },
            applyCarNumber: {
            	required: true
            },
            applyDate: {
                required: true
            },
            applicant: {
                required: true
            },
            applicantIDNum: {
            	required: true
            },
            applicationUnit: {
                required: true
            },
            applyReason: {
            	required: true
            }
        }
    });
    
    
</script>
