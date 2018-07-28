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


<link href="${rc.contextPath}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="${rc.contextPath}/css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="${rc.contextPath}/css/animate.css" rel="stylesheet">
<link href="${rc.contextPath}/css/style.css?v=4.1.0" rel="stylesheet">
<script>
    $(function() {
        laydate({
            elem: '#date', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
            event: 'focus' //响应事件。如果没有传入event，则按照默认的click
        });
    });
</script>
<script src="${rc.contextPath}/js/plugins/layer/laydate/laydate.js"></script>

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
                               费用信息
                            </a>
                        </li>
                    </ul>
                    <div id="myTabContent" class="tab-content">
                        <!-- contact tab -->
                        <div class="tab-pane fade in active" id="contact">
                            <form class="form-horizontal form-bordered" id="form">
                                <input type="hidden" name="id" value="${costInfo.id}"/>
                                <input type="hidden" name="trailerId" value="${costInfo.trailerId}${trailerId}" />
                                <input type="hidden" name="test" value="1213"/>
                                <div class="form-horizontal form-bordered">
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">类型：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <select name="type" class="form-control">
                                                <option value="">请选择</option>
                                                <#list typeList as type>
                                                    <option value="${type.jkey}" <#if type.jkey==costInfo.type>selected</#if>>
                                                        ${type.jvalue}
                                                    </option>
                                                </#list>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">费用：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" name="cost" required
                                                   value="${costInfo.cost}" placeholder="请输入费用"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">日期：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <input id="date" value="${costInfo.date}" type="text"
                                                   class="laydate-icon form-control layer-date" name="date">
                                        </div>
                                    </div>



                                    <div class="form-horizontal form-bordered operate">
                                        <button type="button" onclick="infoNextStep()" class="btn btn-success">
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
<script type="text/javascript">

    // startup the datepicker
    $('.datepicker').datepicker();

    action = "${action}";
    function  cusFunction() {
        console.info("提交之前，最后执行自定义的函数");
    }

    alert("url = " + url + "  action = " + action);
    function infoNextStep() {
        if (info_validate.valid()) {
            $.ajax({
                cache: true,
                type: "POST",
                url: url+action,
                data: $('#form').serialize(),// 你的formid
                async: false,
                dataType : "json",
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    layer.alert(XMLHttpRequest.responseJSON.error);
                },
                beforeSend: function () {
                    start_request_load();
                }, complete: function () {
                    stop_request_load();
                },
                success: function (data) {
                    if (data.code == 200) {
                        layer.msg("操作成功");
                        layer.closeAll();
                        re_load();
                    } else {
                        layer.alert(data.error);
                    }
                }
            });
        }
    }

    var info_validate = $('#form');
    var error = $('.alert-danger', info_validate);
    info_validate.validate({
        errorElement: 'span',
        errorClass: 'error',
        focusInvalid: true,
        rules: {
            type:{
                required: true
            },
            trailerId:{
                required: true,
            },
            cost:{
                required: true,
            },
            time:{
                required: true
            },
        }
    });

</script>
