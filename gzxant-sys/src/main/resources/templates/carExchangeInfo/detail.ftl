<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
   
                    <form class="form-horizontal form-bordered" id="gzxantForm" >
                        <input type="hidden" name="id" value="${carExchangeInfo.id}"/>
                        <font size="6">车辆申请更换信息</font>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">合同号<span class="required">*</span></label>
                            <div class="col-sm-3">
					             <select class=" form-control _search" id="nameInput" name="contractNo" value="${carExchangeInfo.contractNo} >
						          <option value = "">请选择</option>
					             	<#list contractInfos as contractInfo>
						              <option value="${contractInfo.contractNo}">${contractInfo.contractNo}</option>
						          </#list>
					             </select>                                  
                            </div>
                            <label class="col-sm-3 control-label">车牌号<span class="required">*</span></label>
                            <div class="col-sm-3">
                                <input name="carNumber" type="text" class="form-control" value="${carExchangeInfo.carNumber}">                           	
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-sm-3 control-label">预申请车牌号<span class="required">*</span></label>
                            <div class="col-sm-3">
                                <input name="applyCarNumber" type="text" class="form-control" value="${carExchangeInfo.applyCarNumber}">                         	
                            </div>
                            
                            <label class="col-sm-3 control-label">申请日期</label>
                            <div class="col-sm-3">
                                <input name="applyDate" type="date" class="form-control" value="${carExchangeInfo.applyDate}">                         	
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
	action = "${action}";
    function  cusFunction() {
        console.info("提交之前，最后执行自定义的函数");
    }

    var select = $(".select").select2();
    <#if action !='insert'>
    $("select[name=assetsState] option[value='${car.assetsState}']").attr("selected", "selected");
    
    var data = [];
        <#list car.sysRoles as r>
        data.push({id:${r.id}, text: '${r.name}'});
        </#list>
    select.select2("data", data);
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
