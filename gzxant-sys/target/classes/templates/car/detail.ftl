<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
   
                    <form class="form-horizontal form-bordered" id="gzxantForm" >
                        <input type="hidden" name="id" value="${car.id}"/>
                        <font size="6">车辆基本信息</font>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">车牌号<span class="required">*</span></label>
                            <div class="col-sm-3">
                                <input name="carNumber" type="text" class="form-control" value="${car.carNumber}"
                                       placeholder="请输入车牌号">                        	
                            </div>
                            <label class="col-sm-3 control-label">机电编号<span class="required">*</span></label>
                            <div class="col-sm-3">
                                <input name="EMNumber" type="text" class="form-control" value="${car.EMNumber}"placeholder="请输入机电编号">                           	
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-sm-3 control-label">车型名称<span class="required">*</span></label>
                            <div class="col-sm-3">
                                <input name="vehicleType" type="text" class="form-control" value="${car.vehicleType}"
                                       placeholder="车型名称">                         	
                            </div>
                            
                            <label class="col-sm-3 control-label">颜色</label>
                            <div class="col-sm-3">
                                <input name="color" type="text" class="form-control" value="${car.color}"
                                       placeholder="颜色">                         	
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-sm-3 control-label">车架号<span class="required">*</span></label>
                            <div class="col-sm-3">
                                <input name="frameNumber" type="text" class="form-control" value="${car.frameNumber}"
                                       placeholder="请输入车架号">                         	
                            </div>
                            
                            <label class="col-sm-3 control-label">车厂日期<span class="required">*</span></label>
                            <div class="col-sm-3">
                                <input name="productionDate" type="date" class="form-control" value="${car.productionDate}"
                                       placeholder="请输入车厂日期">      	
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-sm-3 control-label">发动机号<span class="required">*</span></label>
                            <div class="col-sm-3">
                                <input name="engine_number" type="text" class="form-control" value="${car.engine_number}"
                                       placeholder="请输入发动机号">                         	
                            </div>
                        </div>
                        
						<font size="6">车辆资产信息</font>
						
                        <div class="form-group">
                            <label class="col-sm-3 control-label">资产状态<span class="required">*</span></label>
                            <div class="col-sm-3">
                                <select class="form-filter form-control _search" id="assetsState" name="assetsState" value="${car.assetsState}">
                                	<option value = "">请选择</option>
                                	<option value = "在库">在库</option>
                                	<option value = "已租">已租</option>
                                	<option value = "维修">维修</option>
                                </select>                    	
                            </div>
                            
                            <label class="col-sm-3 control-label">资产所属<span class="required">*</span></label>
                            <div class="col-sm-3">
                                <input name="assetsBelong" type="text" class="form-control" value="${car.assetsBelong}"
                                       placeholder="请输入资产所属">                   	
                            </div>
                        </div>
                        
                        <div class="form-group">
                        	<label class="col-sm-3 control-label">所在库</label>
                            <div class="col-sm-3">
                                <select class="form-filter form-control _search" id="whereCarArea" name="whereCarArea" value="${car.whereCarArea}">
                                	<option value = "">待修改连接车区管理</option>
                                </select>                    	
                            </div>
                           
                            <label class="col-sm-3 control-label">使用组织<span class="required">*</span></label>
                            <div class="col-sm-3">
                                <select class="form-filter form-control _search" id="usedOrganization" name="usedOrganization" value="${car.usedOrganization}">
                                	<option value = "">二级联动</option>
                                </select>                    	
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-sm-3 control-label">登记证号<span class="required">*</span></label>
                            <div class="col-sm-3">
                                <input name="registrationNumber" type="text" class="form-control" value="${car.registrationNumber}"
                                       placeholder="请输入登记证号">                         	
                            </div>
                            
                            <label class="col-sm-3 control-label">购买日期<span class="required">*</span></label>
                            <div class="col-sm-3">
                                <input name="buyDate" type="date" class="form-control" value="${car.buyDate}">      	
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-sm-3 control-label">登记证登记日期</label>
                            <div class="col-sm-3">
                                <input name="registrationDeta" type="date" class="form-control" value="${car.registrationDeta}">                         	
                            </div>
                            
                            <label class="col-sm-3 control-label">上牌日期<span class="required">*</span></label>
                            <div class="col-sm-3">
                                <input name="onCardsDate" type="date" class="form-control" value="${car.onCardsDate}">      	
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-sm-3 control-label">登记证发证日期</label>
                            <div class="col-sm-3">
                                <input name="registrationCertificateDate" type="date" class="form-control" value="${car.registrationCertificateDate}">                         	
                            </div>
                            
                            <label class="col-sm-3 control-label">发票号<span class="required">*</span></label>
                            <div class="col-sm-3">
                                <input name="invoiceNumber" type="text" class="form-control" value="${car.invoiceNumber}"
                                       placeholder="请输入发票号">      	
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">行驶证注册日期</label>
                            <div class="col-sm-3">
                                <input name="DLRDate" type="date" class="form-control" value="${car.DLRDate}">      	
                            </div>
                            
                            <label class="col-sm-3 control-label">发票日期</label>
                            <div class="col-sm-3">
                                <input name="invoiceDate" type="date" class="form-control" value="${car.invoiceDate}">      	
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-sm-3 control-label">行驶证发证日期</label>
                            <div class="col-sm-3">
                                <input name="DLCDate" type="date" class="form-control" value="${car.DLCDate}">            	
                            </div>
                            
                            <label class="col-sm-3 control-label">备注</label>
                            <div class="col-sm-3">
                                <input name="remark" type="text" class="form-control" value="${car.remark}">            	
                            </div>
                        </div>

						<font size="6">车辆附件信息</font>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">证件类型</label>
                            <div class="col-sm-3">
                                <input name="documentType" type="text" class="form-control" value="${car.documentType}">            	
                            </div>
                            
                            <label class="col-sm-3 control-label">备注</label>
                            <div class="col-sm-3">
                                <input name="remark" type="text" class="form-control" value="${car.remark}">            	
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
            serviceCity: {
                required: true
            },
            carNumber: {
            	rangelength: [7,7],
                required: true
            },
            belongCity: {
            	required: true
            }
        }
    });
    
    
</script>
