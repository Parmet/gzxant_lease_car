<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
   
                    <form class="form-horizontal form-bordered" id="gzxantForm" enctype="multipart/form-data" method="post">
                        <input type="hidden" name="contractInfoId" value="${contractInfo.id}"/>
                        <input type="hidden" name="contractCarInfoId" value="${contractCarInfo.id}"/>
                        <input type="hidden" name="enclosure" value="${contractInfo.enclosure}" id="enclosure"/>
                        <input type="hidden" name="enclosureName" value="${contractInfo.enclosureName}" id="enclosureName"/>
                        <ul id="myTab" class="nav nav-tabs">
							<li class="active">
								<a href="#contractInfo" data-toggle="tab">合同基本信息</a>
							</li>
							<li>
								<a href="#carContractInfo" data-toggle="tab">合同车型信息</a>
							</li>
							<li>
								<a href="#contractInfo-enclosure" data-toggle="tab">合同附件信息</a>
							</li>
						</ul>
						
						<div id="myTabContent" class="tab-content">
							<div class="tab-pane fade in active" id="contractInfo">
									<font size="6">甲方(出租方)</font>                        
			                        <div class="form-group">
			                            <label class="col-sm-2 control-label">公司名<span class="required">*</span></label>
			                            <div class="col-sm-4">
			                                <select class="form-filter form-control _search" id="companyName" name="companyName" value="${contractInfo.companyName}">
			                                	<option value = "">请选择</option>
			                                	<option value = "广州小蚂蚁科技有限公司">广州小蚂蚁科技有限公司</option>
			                                </select>                    	
			                            </div>
			                            <label class="col-sm-2 control-label">合同编号<span class="required">*</span></label>
			                            <div class="col-sm-4">
			                                <input name="contractNo" type="text" class="form-control" value="${contractInfo.contractNo}">                       	
			                            </div>
			                        </div>
			                        
			                        <div class="form-group">
			                            <label class="col-sm-2 control-label">经办人<span class="required">*</span></label>
			                            <div class="col-sm-4">
			                                <input name="agent" type="text" class="form-control" value="${contractInfo.agent}">                       	
			                            </div>
			                            
										<label class="col-sm-2 control-label">合同类型<span class="required">*</span></label>
			                            <div class="col-sm-4">
				                            <select class=" form-control _search" id="nameInput" name="contractType" value="${contractInfo.contractType} >
						                        <option value = "">请选择</option>
				                            	<#list contractTypes as contractType>
						                            <option value="${contractType}">${contractType}</option>
						                        </#list>
				                            </select>                       	
			                            </div>
			                        </div>
			                        
			                        <div class="form-group">
			                            <label class="col-sm-2 control-label">商机编号<span class="required">*</span></label>
			                            <div class="col-sm-4">
			                                <input name="businessNumber" type="text" class="form-control" value="${contractInfo.businessNumber}">                       	
			                            </div>
			                            
			                            <label class="col-sm-2 control-label">合同状态<span class="required">*</span></label>
			                            <div class="col-sm-4">
				                            <select class=" form-control _search" id="contractStatus"  name="contractStatus" value="${contractInfo.contractStatus}>
			                                	<option value = "已完成">已完成</option>
			                                	<option value = "未执行">未执行</option>
			                                	<option value = "执行中">执行中</option>
			                                	<option value = "已终止">已终止</option>
			                                	<option value = "挂起">挂起</option>
			                                </select>                          	
			                            </div>
			                        </div>
			
									<font size="6">乙方(承租方)</font>                        
			                        <div class="form-group">
			                            <label class="col-sm-2 control-label">客户类型<span class="required">*</span></label>
			                            <div class="col-sm-4">
			                                <select class="form-filter form-control _search" id="customerTypeB" name="customerTypeB" value="${contractInfo.customerTypeB}">
			                                	<option value = "">请选择</option>
			                                	<option value = "不详">不详</option>
			                                </select>                    	
			                            </div>
			                            <label class="col-sm-2 control-label">退还押金账号<span class="required">*</span></label>
			                            <div class="col-sm-4">
			                                <input name="refundsAccountB" type="text" class="form-control" value="${contractInfo.refundsAccountB}">                       	
			                            </div>
			                        </div>
			                        
			                        <div class="form-group">
			                            <label class="col-sm-2 control-label">客户名称<span class="required">*</span></label>
			                            <div class="col-sm-4">
			                                <input name="customerNameB" type="text" class="form-control" value="${contractInfo.customerNameB}">                       	
			                            </div>
			                            <label class="col-sm-2 control-label">退还押金户名<span class="required">*</span></label>
			                            <div class="col-sm-4">
			                                <input name="refundsNameB" type="text" class="form-control" value="${contractInfo.refundsNameB}">                       	
			                            </div>
			                        </div>
			                        
			                        <div class="form-group">
			                            <label class="col-sm-2 control-label">退还押金开户行<span class="required">*</span></label>
			                            <div class="col-sm-4">
			                                <input name="refundsBankB" type="text" class="form-control" value="${contractInfo.refundsBankB}">                       	
			                            </div>
			                            <label class="col-sm-2 control-label">客户联系方式<span class="required">*</span></label>
			                            <div class="col-sm-4">
			                                <input name="customerPhoneB" type="text" class="form-control" value="${contractInfo.customerPhoneB}">                       	
			                            </div>
			                        </div>
			                        
			                        <div class="form-group">
			                            <label class="col-sm-2 control-label">车牌号<span class="required">*</span></label>
			                            <div class="col-sm-4">
			                                <input name="carNumber" type="text" class="form-control" value="${contractInfo.carNumber}">                       	
			                            </div>
			                        </div>
			                        
									<font size="6">丙方</font>                        
			                        <div class="form-group">
			                            <label class="col-sm-2 control-label">客户类型</label>
			                            <div class="col-sm-4">
			                                <select class="form-filter form-control _search" id="customerTypeC" name="customerTypeC" value="${contractInfo.customerTypeC}">
			                                	<option value = "">请选择</option>
			                                	<option value = "不详">不详</option>
			                                </select>                    	
			                            </div>
			                            <label class="col-sm-2 control-label">退还押金账号</label>
			                            <div class="col-sm-4">
			                                <input name="refundsAccountC" type="text" class="form-control" value="${contractInfo.refundsAccountC}">                       	
			                            </div>
			                        </div>
			                        
			                        <div class="form-group">
			                            <label class="col-sm-2 control-label">客户名称</label>
			                            <div class="col-sm-4">
			                                <input name="customerNameC" type="text" class="form-control" value="${contractInfo.customerNameC}">                       	
			                            </div>
			                            <label class="col-sm-2 control-label">退还押金户名</label>
			                            <div class="col-sm-4">
			                                <input name="refundsNameC" type="text" class="form-control" value="${contractInfo.refundsNameC}">                       	
			                            </div>
			                        </div>
			                        
			                        <div class="form-group">
			                            <label class="col-sm-2 control-label">退还押金开户行</label>
			                            <div class="col-sm-4">
			                                <input name="refundsBankC" type="text" class="form-control" value="${contractInfo.refundsBankC}">                       	
			                            </div>
			                        </div>
			                        
			                        <font size="6">租金</font>                        
			                        <div class="form-group">
			                            <label class="col-sm-2 control-label">租车押金<span class="required">*</span></label>
			                            <div class="col-sm-4">
			                                <input name="carRentalDeposit" type="text"  onkeyup="clearNoNum(this)" class="form-control" value="${contractInfo.carRentalDeposit}">                       	
			                            </div>
			                            <label class="col-sm-2 control-label">收款方账号<span class="required">*</span></label>
			                            <div class="col-sm-4">
			                                <input name="receivableAccount" onkeyup="inputNumberOnKeyUp(this)" onafterpaste="inputNumberOnAfterPaste(this)" type="text" class="form-control" value="${contractInfo.receivableAccount}">                       	
			                            </div>
			                        </div>
			                        
			                        <div class="form-group">
			                            <label class="col-sm-2 control-label">违章押金<span class="required">*</span></label>
			                            <div class="col-sm-4">
			                                <input name="violationDeposit" type="text"  onkeyup="clearNoNum(this)" class="form-control" value="${contractInfo.violationDeposit}">                       	
			                            </div>
			                            <label class="col-sm-2 control-label">收款方户名<span class="required">*</span></label>
			                            <div class="col-sm-4">
			                                <input name="receivableName"  type="text" class="form-control" value="${contractInfo.receivableName}">                       	
			                            </div>
			                        </div>
			                        
			                        <div class="form-group">
			                            <label class="col-sm-2 control-label">合同金额</label>
			                            <div class="col-sm-4">
			                                <input name="contractAmount" type="text"  onkeyup="clearNoNum(this)" class="form-control" value="${contractInfo.contractAmount}">                       	
			                            </div>
			                            <label class="col-sm-2 control-label">收款方开户行</label>
			                            <div class="col-sm-4">
			                                <input name="contractBank"  type="text" class="form-control" value="${contractInfo.contractBank}">                       	
			                            </div>
			                        </div>
			                        
			                        <div class="form-group">
			                            <label class="col-sm-2 control-label">租赁开始时间</label>
			                            <div class="col-sm-4">
			                                <input name="leaseBeginDate" type="date"   class="form-control" value="${contractInfo.leaseBeginDate}">                       	
			                            </div>
			                            <label class="col-sm-2 control-label">租赁结束时间</label>
			                            <div class="col-sm-4">
			                                <input name="leaseEndDate"  type="date" class="form-control" value="${contractInfo.leaseEndDate}">                       	
			                            </div>
			                        </div>
			                        
			                        <div class="form-group">
			                            <label class="col-sm-2 control-label">付款方式</label>
			                            <div class="col-sm-4">
			                                <select class="form-filter form-control _search" id="paymentMethod" name="paymentMethod" value="${contractInfo.paymentMethod}">
			                                	<option value = "">请选择</option>
			                                	<option value = "现金">现金</option>
			                                	<option value = "微信">微信</option>
			                                	<option value = "支付宝">支付宝</option>
			                                	<option value = "刷卡">刷卡</option>
			                                </select>                                                           	
			                            </div>
			                        </div>
							</div>
							
							
							
							<div class="tab-pane fade" id="carContractInfo">
			                     <div class="form-group">
			                         <label class="col-sm-2 control-label">车型</label>
			                         <div class="col-sm-4">
			                             <input name="vehicleType" type="text"   class="form-control" value="${contractCarInfo.vehicleType}">                       	
			                         </div>
			                         <label class="col-sm-2 control-label">数量</label>
			                         <div class="col-sm-4">
			                             <input name="number"  type="number" class="form-control" value="${contractCarInfo.number}">                       	
			                         </div>
			                     </div>
			                     <div class="form-group">
			                         <label class="col-sm-2 control-label">单价(元)</label>
			                         <div class="col-sm-4">
			                             <input name="price" type="text"  onkeyup="clearNoNum(this)" class="form-control" value="${contractCarInfo.price}">			                         
			                         </div>
			                         <label class="col-sm-2 control-label">合计(元)</label>
			                         <div class="col-sm-4">
			                             <input name="total_price" type="text"  onkeyup="clearNoNum(this)" class="form-control" value="${contractCarInfo.total_price}">			                         
			                         </div>
			                     </div>
			                     
			                     <div class="form-group">
			                         <label class="col-sm-2 control-label">备注</label>
			                         <div class="col-sm-4">
			                             <input name="remark1" type="text"   class="form-control" value="${contractCarInfo.remark1}">			                         
			                         </div>
			                     </div>
			                     							
							</div>
							<div class="tab-pane fade" id="contractInfo-enclosure">
							    
					                    <script src="${rc.contextPath}/js/plugins/dropzone/dropzone.min.js"></script>
					                    <link href="${rc.contextPath}/css/plugins/dropzone/dropzone.css" rel="stylesheet">
					                    <div class="col-sm-4">
					                        	<div id="zone" name="zone" class="dropzone" onclick="downLoadDoc()">
					                        		<div class="dz-default dz-message">
					                        			<span>请点击下载</span>
					                        		</div>
					                        	</div>
					                        	<div id="mydropzone" name="mydropzone" class="dropzone"></div>
					                    </div>
					                    <script type="text/javascript">
						                    // --------------------------文件上传--------------00------------------------------------ //
						                    
						                    
						                <#if step =='upload'>
						                	$('#zone').attr("hidden","hidden")
						                    Dropzone.autoDiscover = false;
										    var myDropzone = new Dropzone("div#mydropzone", {
										        url: base_url+"/file/upload/avatar",
										        filesizeBase: 1024,//定义字节算法 默认1000
										        maxFiles: 2,//最大文件数量
										        maxFilesize: 100, //MB
										        fallback: function () {
										            layer.alert('暂不支持您的浏览器上传!');
										        },
										        uploadMultiple: false,
										        addRemoveLinks: true,
										        dictFileTooBig: '您的文件超过' + 100 + 'MB!',
										        dictInvalidInputType: '不支持您上传的类型',
										        dictMaxFilesExceeded: '您的文件超过1个!',
										        init: function () {
										            this.on('queuecomplete', function (files) {
										                // layer.alert('上传成功');
										            });
										            this.on('success', function (uploadimfo, result) {
										                console.info(result);
										                $("#enclosure").val(result.message[0].url);
										                $("#enclosureName").val(result.message[0].docName);
										                layer.alert('上传成功');
										                
										            });
										            this.on('error', function (a, errorMessage, result) {
										                if (!result) {
										                    layer.alert(result.error || '上传失败');
										                }
										            });
										            this.on('maxfilesreached', function () {
										                this.removeAllFiles(true);
										                layer.alert('文件数量超出限制');
										            });
										            this.on('removedfile', function () {
										                layer.alert('删除成功');
										            });
										
										        }
										    });
				               	</#if>
				               	<#if step =='download'>
				               		$('#mydropzone').attr("hidden","hidden")
				               	</#if>
				               	
					                	</script>
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

    <#if step =='download'>
		function downLoadDoc(){
			var docUrl = '${contractInfo.enclosure?replace("\\", "\\\\")?replace("/", "//")}';
		    docUrl = url + "/download?docUrl=" + encodeURIComponent(docUrl) 
		         + "&name=" + encodeURIComponent("${contractInfo.enclosureName}");
		    window.open(docUrl);
		}
	</#if>
	$(function () {
		$('#contractInfo li:eq(1) a').tab('show');
	});

	//输入金额，只能输入数字和小数点
	function clearNoNum(obj){
        obj.value = obj.value.replace(/[^\d.]/g,"");  //清除“数字”和“.”以外的字符
        obj.value = obj.value.replace(/^\./g,"");  //验证第一个字符是数字而不是.
        obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的.
        obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");

    }
	
	//只能输入数字OnKeyUp
	function inputNumberOnKeyUp(obj){
		if(obj.value.length==1){
			obj.value=obj.value.replace(/[^1-9]/g,'')
		}else{
			obj.value=obj.value.replace(/\D/g,'')
		}
	}
	//只能输入数字onafterpaste
	function inputNumberOnAfterPaste(obj){
		if(obj.value.length==1){
			obj.value=obj.value.replace(/[^1-9]/g,'')
		}else{
			obj.value=obj.value.replace(/\D/g,'')
		}
	
	}



	action = "${action}";
	step = "${step}";
    function  cusFunction() {
        console.info("提交之前，最后执行自定义的函数");
    }

	 /**
     * 删除头像
     */
    function doDeleteImg() {
        var name = $("#photo").val();
        layer.confirm('确定要删除头像吗？', {
            btn: ['确定', '取消']
        }, function () {
            $.ajax({
                url: url + "delete/photo",
                type: "POST",
                data: {
                    'name': name
                },
                success: function (r) {
                    if (r.code == 200) {
                        errimg();

                    } else {
                        layer.msg(r.error);
                    }
                }
            });
        })

    }

    var select = $(".select").select2();
    <#if action !='insert'>
    var data = [];
    select.select2("data", data);
	$("select[name=companyName] option[value='${contractInfo.companyName}']").attr("selected", "selected");
	$("select[name=contractType] option[value='${contractInfo.contractType}']").attr("selected", "selected");
	$("select[name=contractStatus] option[value='${contractInfo.contractStatus}']").attr("selected", "selected");
	$("select[name=customerTypeB] option[value='${contractInfo.customerTypeB}']").attr("selected", "selected");
	$("select[name=customerTypeC] option[value='${contractInfo.customerTypeC}']").attr("selected", "selected");
	$("select[name=paymentMethod] option[value='${contractInfo.paymentMethod}']").attr("selected", "selected");
    </#if>
    var form = $('#gzxantForm');
    var error = $('.alert-danger', form);
    form.validate({
        errorElement: 'span',
        errorClass: 'error',
        focusInvalid: true,
        messages: {
        },
        rules: {
            companyName: {
                required: true
            },
            agent: {
                required: true
            },
            contractNo: {
                required: true
            },
            contractType: {
                required: true
            }
        }
    });
    
    
</script>
