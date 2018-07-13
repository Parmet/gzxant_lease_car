<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
  
                    <form class="form-horizontal form-bordered" id="gzxantForm" >
                        <input type="hidden" name="id" value="${carSet.id}"/>
                        <input type="hidden" name="photo" value="${carSet.photo}" id="photo"/>
                        
                        <div class="form-group">
                            <label class="col-sm-2 control-label">里程阈值<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <input name="mileageThreshold" type="number" class="form-control" value="${carSet.mileageThreshold}"
                                       placeholder="里程阈值">                       	
                            </div>
                            <label class="col-sm-2 control-label">电量/油量阈值<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <input name="eoThreshold" type="number" class="form-control" value="${carSet.eoThreshold}"
                                       placeholder="电量/油量阈值">                       	
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-sm-2 control-label">车型名称<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <select class="form-filter form-control _search" id="carSizeName" name="carSizeName" value="${carSet.carSizeName}">
                                	<option value = "">请选择</option>
                                    <#list sizeName as name>
                                        <option value="${name}">${name}</option>
                                    </#list>                                          	
                                </select>                            	
                            </div>
                            
                            <label class="col-sm-2 control-label">车系名称<span class="required">*</span></label>
                            <div class="col-sm-4">
                                <select class="form-filter form-control _search" id="carTrainName" name="carTrainName" value="${carSet.carTrainName}">
                                	<option value = "">请选择</option>
                                    <#list trainName as name>
                                        <option value="${name}">${name}</option>
                                    </#list>                                          	
                                </select>                            	
                            </div>
                        </div>
                        
						<div class="form-group">
                            <label class="col-sm-2 control-label">图片</label>
                            <div class="col-sm-4">
                                <div id="localImag" style="margin-left:15px;">
                                    <div class="img_box" id="imgBox">
                                        <img id="imgshowdiv" style="width: 60px" src="${catSet.photo}"
                                             onerror="javascript:errimg()" class="img_file img-rounded"/>
										<!--
                                              <div class="img_edit_box">
                                                  <a class="img_desr" href="javascript:doDeleteImg()">删除</a>
                                              </div> -->
                                    </div>
                                </div>
                            </div>
                        <#if action !='detail'>
	                    <script src="${rc.contextPath}/js/plugins/dropzone/dropzone.min.js"></script>
	                    <link href="${rc.contextPath}/css/plugins/dropzone/dropzone.css" rel="stylesheet">
	                    <div class="col-sm-4">
	                        <div id="mydropzone" class="dropzone"></div>
	                    </div>
	                    <script type="text/javascript">
		                    // --------------------------图片上传-------------------------------------------------- //
		                    Dropzone.autoDiscover = false;
						    var myDropzone = new Dropzone("div#mydropzone", {
						        url: "/file/upload/avatar",
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
						                $("#photo").val(result.message[0].s_url);
						                $("#imgshowdiv").attr('src', result.message[0].s_url);
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
						                $("#photo").val("${rc.contextPath}${carSet.photo}");
						                $("#imgshowdiv").attr('src', "${rc.contextPath}${carSet.photo}");
						                layer.alert('删除成功');
						            });
						
						        }
						    });
	                    </script>
	               		</#if>
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
	$("select[name=carTrainName] option[value='${carSet.carTrainName}']").attr("selected", "selected");
	$("select[name=carSizeName] option[value='${carSet.carSizeName}']").attr("selected", "selected");
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
            carTrainName: {
                required: true
            },
            carSizeName: {
                required: true
            }
        }
    });
    
    
</script>
