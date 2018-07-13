<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">

                    <form class="form-horizontal form-bordered" id="gzxantForm" >
                        <input type="hidden" name="id" value="${carArea.id}"/>
                        
                        <div class="form-group">
                            <label class="col-sm-2 control-label">所属城市<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <select class="form-filter form-control _search" id="belongCity" name="belongCity" value="${car.belongCity}">
                                	<option value = "">请选择</option>
                                    <#list cityName as name>
                                        <option value="${name}">${name}</option>
                                    </#list>                                	
                                </select>                    	
                            </div>
                            <label class="col-sm-2 control-label">车区名<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <input name="carAreaName" type="text" class="form-control" value="${carArea.carAreaName}"
                                       placeholder="车区名">                       	
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-sm-2 control-label">联系人<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <input name="contactPerson" type="text" class="form-control" value="${carArea.contactPerson}"
                                       placeholder="联系人">                       	
                            </div>
                            
                            <label class="col-sm-2 control-label">联系电话<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <input name="contactNumber" type="text" class="form-control" value="${carArea.contactNumber}"
                                       placeholder="联系电话">                       	
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
	$("select[name=belongCity] option[value='${carArea.belongCity}']").attr("selected", "selected");
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
            belongCity: {
                required: true
            },
            carAreaName: {
                required: true
            },
            contactPerson: {
                required: true
            },
            contactNumber: {
                required: true
            }
        }
    });
    
    
</script>
