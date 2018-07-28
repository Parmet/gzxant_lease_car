<style>
    .error{
        color:red;
    }
    .form-bordered {
        margin-top: 30px;
    }
    .operate {
        text-align: center;
    }
</style>

<link href="${rc.contextPath}/css/plugins/dropzone/dropzone.css" rel="stylesheet">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins" >
                <div class="ibox-content">
                    <ul id="myTab" class="nav nav-tabs">
                        <li id="contacttab" class="active">
                            <a href="#contact" data-toggle="tab">
                            <#--<a>-->
                                公司联系人基本信息
                            </a>
                        </li>
                    </ul>
                    <div id="myTabContent" class="tab-content">
                        <!-- contact tab -->
                        <div class="tab-pane fade in active" id="contact">
                            <form class="form-horizontal form-bordered" id="gzxantForm">
                                <input type="hidden" name="id" value="${contact.id}"/>
                                <input type="hidden" name="companyId" value="${id}"/>
                                <div class="form-horizontal form-bordered">

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">联系人：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" name="name" required
                                                   value="${contact.name}" placeholder="请输入联系人姓名"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">电话：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" name="tel" required
                                                   value="${contact.tel}" placeholder="请输入联系人电话"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">身份证号码：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" name="idNum" required
                                                   value="${contact.idNum}" placeholder="请输入身份证号码"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">职务：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" name="position" required
                                                   value="${contact.position}" placeholder="请输入联系人职务"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">邮箱：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" name="email" required
                                                   value="${contact.email}" placeholder="请输入联系人邮箱"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">备注：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" name="remark" required
                                                   value="${contact.remark}" placeholder="备注"/>
                                        </div>
                                    </div>

                                    <div class="form-horizontal form-bordered operate">
                                        <button type="submit" onclick="infoNextStep()" class="btn btn-success">
                                            保存
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<#--import dataPicker to support date pick-->
<script src="${rc.contextPath}/js/plugins/datapicker/bootstrap-datepicker.js"></script>
<#-- import the dropzone to support file upload -->
<script src="${rc.contextPath}/js/plugins/dropzone/dropzone.min.js"></script>
<!-- 引入身份证校验插件 -->
<script src="${rc.contextPath}/js/identity.js"></script>
<!-- 引入可编辑表格插件 -->
<script src="${rc.contextPath}/js/table.js"></script>
<script type="text/javascript">

    // startup the datepicker
    $('.datepicker').datepicker();

    var id = "${id}";

    url = clearCompanyId(url);

    function clearCompanyId() {
        for (var i = 0; i < 2; i++) {
            url = url.substring(0, url.lastIndexOf("/"));
        }
        return url + "/";
    }

    action = "${action}";
    function  cusFunction() {
        console.info("提交之前，最后执行自定义的函数");
    }

    function infoNextStep() {
        info_validate.form();
    }
    // 手机号码验证
    $.validator.addMethod("isMobile", function(value, element) {
        var length = value.length;
        var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
        return this.optional(element) || (length == 11 && mobile.test(value));
    }, "请正确填写您的手机号码");

    //身份证号码验证
    $.validator.addMethod("isIdCardNo", function (value, element){
        return this.optional(element) || IdCardValidate(value);
    },"请正确输入您的身份证号码");

    var info_validate = $('#gzxantForm');
    var error = $('.alert-danger', info_validate);
    info_validate.validate({
        errorElement: 'span',
        errorClass: 'error',
        focusInvalid: true,
        rules: {
            contactName:{
                required: true
            },
            tel:{
                required: true,
                isMobile: true
            },
            idNum:{
                required: true,
                isIdCardNo: true
            },
            position:{
                required: true
            },
            status:{
                required: true
            },
            contactEmail:{
                required: true,
                email:true
            },
            contactRemark:{
                required: true
            }
        }
    });

</script>
