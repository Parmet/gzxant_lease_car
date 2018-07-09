<style>
    .error{
        color:red;
    }
</style>
<link href="${rc.contextPath}/css/plugins/dropzone/dropzone.css" rel="stylesheet">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins" >
                <div class="">
                    <form class="form-horizontal form-bordered" id="gzxantForm">
                        <input type="hidden" name="id" value="${certificate.id}"/>

                        <div class="form-group">

                            <label class="col-sm-3 control-label">证件图片：</label>
                            <#-- photo location input -->
                            <input type="hidden" name="attachment" value="${sysUser.photo}" id="photo"/>

                            <#-- drop zone area -->
                            <div class="col-sm-4">
                                <div id="mydropzone" class="dropzone"></div>
                            </div>
                        </div>



                        <div class="form-group">
                            <label class="col-sm-3 control-label">证件类型：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <select name="type" class="form-control">
                                    <option value="">请选择</option>
                                    <#list typeList as type>
                                        <option value="${type.jvalue}">${type.jvalue}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">证件号码：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="number"
                                value="" placeholder="请输入证件号码"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">发证日期：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control datepicker" name="issueDate">

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">有效期至：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control datepicker" name="validityPeriod">
                            </div>

                        </div>

                        <div class="form-actions row">
                            <div class="col-sm-offset-3 col-sm-9">
                                <button type="submit" onclick="infoNextStep()" class="btn btn-success">提交</button>
                            </div>
                        </div>

                    </form>

                </div>
            </div>
        </div>
    </div>
</div>

<#--import dataPicker to support date pick-->
<script src="${rc.contextPath}/js/plugins/datapicker/bootstrap-datepicker.js"></script>
<#-- import the dropzone to support file upload -->
<script src="${rc.contextPath}/js/plugins/dropzone/dropzone.min.js"></script>
<script type="text/javascript">
    // startup the datepicker
    $('.datepicker').datepicker();

    action = "${action}";
    function  cusFunction() {
        console.info("提交之前，最后执行自定义的函数");
    }
    function infoNextStep() {
        info_validate.form();
    }




    var info_validate = $('#gzxantForm');
    var error = $('.alert-danger', info_validate);
    info_validate.validate({
        errorElement: 'span',
        errorClass: 'error',
        focusInvalid: true,
        rules: {
            type: {
                required: true,
            },
            number:{
                required: true
            },
            issueDate:{
                required: false
            },
            validityPeriod:{
                required: true
            },
            attachment:{
                required: true
            },
        },
        messages: {
            type:"请选择证件类型",
            number:"请填写证件号码",
            issueDate:"请填写发证日期",
            validityPeriod:"请填写证件有效截至日期",
        }
    });


    // --------------------------图片上传-------------------------------------------------- //
    Dropzone.autoDiscover = false;
    var myDropzone = new Dropzone("div#mydropzone", {
        url: "/gzxant/web/file/upload/id_img",
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
                $("#photo").val("${rc.contextPath}${sysUser.photo}");
                $("#imgshowdiv").attr('src', "${rc.contextPath}${sysUser.photo}");
                layer.alert('删除成功');
            });

        }
    });
</script>
