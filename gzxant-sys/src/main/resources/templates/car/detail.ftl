<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
   
                    <form class="form-horizontal form-bordered" id="gzxantForm" >
                        <input type="hidden" name="id" value="${car.id}"/>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">服务城市<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <select class="form-control"  id="serviceCity" name="serviceCity" >
                                    <#list cityName as name>
                                        <option value="${name}">${name}</option>
                                    </#list>                                	
                                </select>                            	
                            </div>
                            <label class="col-sm-2 control-label">车系名称<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <select class="form-filter form-control _search" id="carTrainName" name="carTrainName" value="${car.carTrainName}">
                                	<option value = "">请选择</option>
                                    <#list trainName as name>
                                        <option value="${name}">${name}</option>
                                    </#list>                                	
                                </select>                            	
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-sm-2 control-label">车牌号码<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <input name="carNumber" type="text" class="form-control" value="${car.carNumber}"
                                       placeholder="车牌号码">                         	
                            </div>
                            
                            <label class="col-sm-2 control-label">车场<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <input name="carPark" type="text" class="form-control" value="${car.carPark}"
                                       placeholder="车场">                         	
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-sm-2 control-label">网点<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <input name="onlineStore" type="text" class="form-control" value="${car.onlineStore}"
                                       placeholder="网点">                         	
                            </div>
                            
                            <label class="col-sm-2 control-label">车辆颜色<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <input name="carColor" type="text" class="form-control" value="${car.carColor}"
                                       placeholder="车辆颜色">      	
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-sm-2 control-label">车辆全名<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <input name="carName" type="text" class="form-control" value="${car.carName}"
                                       placeholder="车辆全名">                         	
                            </div>
                            
                            <label class="col-sm-2 control-label">所属城市<span class="required">*</span></label>
                            <div class="col-sm-4">
                               <select class="form-filter form-control _search" id="belongCity" name="belongCity" value="${car.belongCity}">
                                    <#list cityName as name>
                                        <option value="${name}">${name}</option>
                                    </#list> 
                                </select>   	
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">续航里程<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <input name="mileage" type="text" class="form-control" value="${car.mileage}"
                                       placeholder="续航里程">                         	
                            </div>
                            
                            <label class="col-sm-2 control-label">发动机号<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <input name="motorNumber" type="text" class="form-control" value="${car.motorNumber}"
                                       placeholder="发动机号">      	
                            </div>
                        </div>
                        
  <!--                         <div class="form-group">
                         <label class="col-sm-2 control-label">保险到期时间<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <input name="insuranceDate" type="text" class="form-control" value="${car.insuranceDate}"
                                       placeholder="保险到期时间">                         	
                            </div>
                           
                            <label class="col-sm-2 control-label">年检时间<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <input name="annualSurveyDate" type="text" class="form-control" value="${car.annualSurveyDate}"
                                       placeholder="年检时间">      	
                            </div>
                        </div>
  -->                      
                        <div class="form-group">
                            <label class="col-sm-2 control-label">VIN<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <input name="vin" type="text" class="form-control" value="${car.vin}"
                                       placeholder="VIN">                         	
                            </div>
                            
                            <label class="col-sm-2 control-label">车龄<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <input name="carAge" type="text" class="form-control" value="${car.carAge}"
                                       placeholder="车龄">      	
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-sm-2 control-label">SN<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <input name="sn" type="text" class="form-control" value="${car.sn}"
                                       placeholder="SN">                         	
                            </div>
                            
                            <label class="col-sm-2 control-label">CODE<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <input name="code" type="text" class="form-control" value="${car.code}"
                                       placeholder="CODE">      	
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-sm-2 control-label">机车类型<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <input name="ecar_type" type="text" class="form-control" value="${car.ecarType}"
                                       placeholder="机车类型">                         	
                            </div>
                            
                            <label class="col-sm-2 control-label">车辆来源<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <input name="carSource" type="text" class="form-control" value="${car.carSource}"
                                       placeholder="车辆来源">      	
                            </div>
                        </div>
  <!--                     
                        <div class="form-group">
                            <label class="col-sm-2 control-label">蓝牙模式<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <select class="form-filter form-control _search" id="bluetoothMode" name="bluetoothMode" value="${car.bluetoothMode}">
                                	<option value = "">请选择</option>
                                	<option value = "0">开启</option>
                                	<option value = "1">关闭</option>
                                </select>                    	
                            </div>
                            
                            <label class="col-sm-2 control-label">寻车模式<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <select class="form-filter form-control _search" id="findCarType" name="findCarType" value="${car.findCarType}">
                                	<option value = "">请选择</option>
                                	<option value = "0">开启</option>
                                	<option value = "1">关闭</option>
                                </select>                   	
                            </div>
                        </div>
   -->                     
                        <div class="form-group">
                            <label class="col-sm-2 control-label">百公里耗油<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <input name="oilWear" type="text" class="form-control" value="${car.oilWear}"
                                       placeholder="百公里耗油">            	
                            </div>
                            
                            <label class="col-sm-2 control-label">车型名称<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <select class="form-filter form-control _search" id="carSizeName" name="carSizeName" value="${car.carSizeName}">
                                	<option value = "">请选择</option>
                                    <#list sizeName as name>
                                        <option value="${name}">${name}</option>
                                    </#list>                                	
                                </select>                            	
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
    $("select[name=belongCity] option[value='${car.belongCity}']").attr("selected", "selected");
	$("select[name=serviceCity] option[value='${car.serviceCity}']").attr("selected", "selected");
	$("select[name=carTrainName] option[value='${car.carTrainName}']").attr("selected", "selected");
	$("select[name=carSizeName] option[value='${car.carSizeName}']").attr("selected", "selected");
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
