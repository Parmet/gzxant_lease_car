<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
   
                    <form class="form-horizontal form-bordered" id="gzxantForm" >
                        <input type="hidden" name="id" value="${carArea.id}"/>
                        
                        <div class="form-group">
                            <label class="col-sm-2 control-label">车区名称<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <input name="carAreaName" type="text" class="form-control" value="${carArea.carAreaName}"
                                       placeholder="填写车区名称">                  	
                            </div>
                            <label class="col-sm-2 control-label">所属组织<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <input name="belongOrganization" type="text" class="form-control" value="${carArea.belongOrganization}"
                                       placeholder="填写所属组织">                       	
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-sm-2 control-label">地址<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <input name="address" type="text" class="form-control" value="${carArea.address}"
                                       placeholder="填写地址">                       	
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
