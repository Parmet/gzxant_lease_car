<style>
    .error{
        color:red;
    }
</style>
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins" >
                <div class="">
                    <form class="form-horizontal form-bordered" id="gzxantForm">
                        <input type="hidden" name="id" value="${equipmentSupplier.id}"/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">证件类型：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <#--<input type="text" class="form-control" name="emial"-->
                                       <#--value="" placeholder="请输入注册邮箱"/>-->
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
                                <#--<input type="text" class="form-control" name="issueDate"-->
                                       <#--value="" placeholder="请输入发证日期"/>-->
                                <#--<div class="input-group date" >-->
                                    <#--<input type="text" class="input-small" name="issueDate" />-->
                                    <#--<input class="datepicker" type="text" name="issueDate" data-date-format="mm/dd/yyyy">-->
                                    <#--<input type="text" class="form-control datepicker" name="issueDate" value="12-02-2012">-->
                                <#--</div>-->
                                <input type="text" class="form-control datepicker" name="issueDate">

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">有效期至：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <#--<input type="text" class="form-control" name="validityPeriod"-->
                                       <#--value="" placeholder="请输入有效期"/>-->
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
    // // 手机号码验证
    // $.validator.addMethod("isMobile", function(value, element) {
    //     var length = value.length;
    //     var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
    //     return this.optional(element) || (length == 11 && mobile.test(value));
    // }, "请正确填写您的手机号码");
    // $.validator.addMethod("isTel", function(value, element) {
    //     var length = value.length;
    //     var phone = /(^(\d{3,4}-)?\d{6,8}$)|(^(\d{3,4}-)?\d{6,8}(-\d{1,5})?$)|(\d{11})/;
    //     return this.optional(element) || (phone.test(value));
    // }, "请填写正确的固定电话");//可以自定义默认提示信息




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
</script>
