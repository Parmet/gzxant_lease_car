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
    #returnCompany, #returnCompany {
        margin-right: 10px;
    }
    #nextIsSave, #nextIsDrive, #nextIsContact {
        visibility: hidden;
    }
</style>

<!-------------------- 日期控件样式 ---------------------->
<link href="${rc.contextPath}/css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="${rc.contextPath}/css/animate.css" rel="stylesheet">
<script src="${rc.contextPath}/js/plugins/layer/laydate/laydate.js"></script>
<script>
    //外部js调用
    laydate({
        elem: '#iIssueDate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
        event: 'focus' //响应事件。如果没有传入event，则按照默认的click
    });
</script>
<!-------------------- end ---------------------->

<link href="${rc.contextPath}/css/plugins/dropzone/dropzone.css" rel="stylesheet">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins" >
                <div class="ibox-content">
                    <ul id="myTab" class="nav nav-tabs">
                        <li id="companytab" class="active">
                            <a href="#company" data-toggle="tab">
                            <#--<a>-->
                                公司客户基本信息
                            </a>
                        </li>
                    </ul>

                        <div id="myTabContent" class="tab-content">
                            <!-- company tab -->
                            <div class="tab-pane fade in active" id="company">
                                <form class="form-horizontal form-bordered" id="gzxantForm">
                                    <input type="hidden" name="id" value="${company.id}"/>
                                    <div class="form-horizontal form-bordered">

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">公司名称：<span class="required">*</span></label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" name="name" maxlength="10"
                                                       value="${company.name}" placeholder="请输入公司名称"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">简称：<span class="required">*</span></label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" name="abbreviation"
                                                       value="${company.abbreviation}" placeholder="请输入公司简称" maxlength="10"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">公司性质：<span class="required">*</span></label>
                                            <div class="col-sm-8">
                                                <select name="property" class="form-control">
                                                    <option value="">请选择</option>
                                                    <#list propertyList as property>
                                                        <option value="${property.jkey}" <#if property.jkey==company.property>selected</#if>>
                                                            ${property.jvalue}
                                                        </option>
                                                    </#list>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">公司类别：<span class="required">*</span></label>
                                            <div class="col-sm-8">
                                                <select name="category" class="form-control">
                                                    <option value="">请选择</option>
                                                    <#list categoryList as category>
                                                        <option value="${category.jkey}" <#if category.jkey==company.category>selected</#if>>
                                                            ${category.jvalue}
                                                        </option>
                                                    </#list>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">所属组织：<span class="required">*</span></label>
                                            <div class="col-sm-8">
                                                <select name="belongsto" class="form-control">
                                                    <option value="">请选择</option>
                                                    <#list belongstoList as belongsto>
                                                        <option value="${belongsto.id}" <#if belongsto.id==company.belongsto>selected</#if>>
                                                            ${belongsto.name}
                                                        </option>
                                                    </#list>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">备注：<span class="required">*</span></label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" name="remark"
                                                       value="${company.remark}" placeholder="备注"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">公司地址：<span class="required">*</span></label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" name="address"
                                                       value="${company.address}" placeholder="请输入公司地址"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">注册资金：<span class="required">*</span></label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" name="registeredCapital"
                                                       value="${company.registeredCapital}" placeholder="请输入注册资金"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">注册日期：<span class="required">*</span></label>
                                            <div class="col-sm-8">
                                                <input id="iIssueDate" value="${company.registeredDate}" type="text" readonly
                                                       class="laydate-icon form-control layer-date" name="registeredDate">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">法人代表：<span class="required">*</span></label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" name="legalRepresentative"
                                                       value="${company.legalRepresentative}" placeholder="法人代表"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">邮箱地址：<span class="required">*</span></label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" name="email"
                                                       value="${company.email}" placeholder="输入公司邮件地址"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">营业执照号：<span class="required">*</span></label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" name="licenseNumber"
                                                       value="${company.licenseNumber}" placeholder="输入营业执照号"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">营业执照：<span class="required">*</span></label>
                                            <input type="hidden" name="attachmentUrl" id="company_photo"
                                                   value="${company.attachmentUrl}"/>
                                            <input type="hidden" name="sAttachmentUrl" id="s_company_photo"
                                                   value="${company.sAttachmentUrl}"/><!-- 缩略图 -->
                                            <div class="col-sm-3">
                                                <div id="localImag" style="margin-left:15px;">
                                                    <div class="img_box" id="imgBox">
                                                        <img id="imgshowdiv" style="width: 120px" src="${company.sAttachmentUrl}"
                                                             onerror="javascript:errimg()" class="img_file img-rounded"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <#if action!="detail">
                                                <div class="col-sm-4">
                                                    <div id="mydropzone" class="dropzone"></div>
                                                </div>
                                            </#if>

                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">客户状态：<span class="required">*</span></label>
                                            <div class="col-sm-8">
                                                <select name="status" class="form-control">
                                                    <option value="">请选择</option>
                                                    <#list statusList as status>
                                                        <option value="${status.jkey}" <#if status.jkey==company.status>selected</#if>>
                                                            ${status.jvalue}
                                                        </option>
                                                    </#list>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-horizontal form-bordered operate">
                                            <button type="button" onclick="submitCompany()" class="btn btn-success">
                                                保存
                                            </button>
                                            <a id="nextIsContact" href="#contact" data-toggle="tab" class="btn btn-success"></a>
                                        </div>
                                    </div>
                                </form>
                            </div>

                            <#--<!-- contact tab &ndash;&gt;
                            <div class="tab-pane fade" id="contact">
                                <div class="form-horizontal form-bordered">

                                    <table class="table table-bordered table-hover">
                                        <tr>
                                            <td colspan="5" class="danger"><button class="btn btn-primary btn-sm">增加</button></td>
                                        </tr>
                                    </table>
                                    <div class="form-horizontal form-bordered operate">
                                        <!-- returnCompany &ndash;&gt;
                                        <a id="returnCompany" href="#company" data-toggle="tab" class="btn btn-success">
                                            <#if action != "detail">
                                                上一步
                                            <#else>
                                                上一页
                                            </#if>
                                        </a>
                                        <button type="button" onclick="checkContact()" class="btn btn-success">
                                            <#if action != "detail">
                                                下一步
                                            <#else>
                                                下一页
                                            </#if>
                                        </button>
                                        <!-- nextIsSave &ndash;&gt;
                                        <a id="nextIsSave" href="#save" data-toggle="tab" class="btn btn-success"></a>
                                    </div>
                                </div>
                            </div>
                            <#if action!="detail">
                                <!-- save tab &ndash;&gt;
                                <div class="tab-pane fade" id="save">
                                    <div class="form-horizontal form-bordered">
                                        <div class="form-actions row">
                                            <label class="col-sm-3 control-label">
                                                点击`提交`完成
                                                <#if action=="insert">
                                                    添加
                                                <#else>
                                                    保存
                                                </#if>
                                                ：<span class="required">*</span></label>
                                            <div class="col-sm-8">
                                                <button type="submit" onclick="infoNextStep()" class="btn btn-success">提交</button>
                                            </div>
                                        </div>
                                        <div class="form-horizontal form-bordered operate">
                                            <!-- returnContact &ndash;&gt;
                                            <a id="returnContact" href="#contact" data-toggle="tab" class="btn btn-success">上一步</a>
                                        </div>
                                    </div>
                                </div>
                            </#if>-->
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

    action = "${action}";
    function  cusFunction() {
        console.info("提交之前，最后执行自定义的函数");
    }

    //回显图片
    $("#imgshowdiv").attr("src","${rc.contextPath}/file/image?path="+encodeURIComponent("${company.sAttachmentUrl?replace('\\', '\\\\')}"));

    /**
     * 错误图片的默认处理
     */
    function errimg() {
        $("#imgshowdiv").attr('src', "${rc.contextPath}/img/log9.png");
    }


    function infoNextStep() {
        //info_validate.form();
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

    //营业执政好验证
    $.validator.addMethod("isSocialCreditCodeOrg", function (value, element){
        return this.optional(element) || isValidBusCode(value);
    },"请正确输入营业执政号");

    // $.validator.addMethod("isTel", function(value, element) {
    //     var length = value.length;
    //     var phone = /(^(\d{3,4}-)?\d{6,8}$)|(^(\d{3,4}-)?\d{6,8}(-\d{1,5})?$)|(\d{11})/;
    //     return this.optional(element) || (phone.test(value));
    // }, "请填写正确的固定电话");//可以自定义默认提示信息


    //  ---------------------   通过点击下一步来判断，如果校验成功，则用js去触发a标签的点击事件（a标签用来跳转标签页的）    ---------------------
    function checkContact() {
        <#if action != "detail">
            if (info_validate.valid()) {
                document.getElementById("nextIsSave").click();
            }
        <#else>
            document.getElementById("nextIsSave").click();
        </#if>
    }
    function submitCompany() {
        <#if action != "detail">
            if (info_validate.valid()) {
                //使用ajax异步添加数据，返回id
                $.ajax({
                    cache: true,
                    type: "POST",
                    url: url + action,
                    data: $('#gzxantForm').serialize(),// 你的formid
                    async: false,
                    dataType: "json",
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        layer.alert(XMLHttpRequest.responseJSON.error);
                    },
                    beforeSend: function () {
                        start_request_load();
                    }, complete: function () {
                        stop_request_load();
                    },
                    success: function (data) {
                        //将返回的id添加到input标签中
                        alert(data.message);
                        var id = $("input[name=id]").val();
                        if (data.code == 200) {
                            layer.msg("操作成功");
                            if (id == "") {
                                var flag = true;
                                //跳转到联系人页面，带个标记参数过去，让页面一加载就弹出添加联系人框
                                location.href = url + "contact/" + data.message + "?flag=" + flag;
                            } else {
                                //跳转到联系人列表
                                location.href = url + "contact/" + id;
                            }
                        } else {
                            layer.alert(data.error);
                        }
                    }
                });
            }
        </#if>
    }


    var info_validate = $('#gzxantForm');
    var error = $('.alert-danger', info_validate);
    info_validate.validate({
        errorElement: 'span',
        errorClass: 'error',
        focusInvalid: true,
        rules: {
            name:{
                required: true,
            },
            abbreviation:{
                required: true
            },
            property:{
                required: true,
            },
            category:{
                required: true
            },
            address:{
                required: true
            },
            registeredCapital:{
                required: true
            },
            registeredDate:{
                required: true
            },
            status:{
                required: true
            },
            legalRepresentative:{
                required: true,
            },
            email:{
                required: true,
                email:true
            },
            licenseNumber:{
                required: true,
                // isSocialCreditCodeOrg: true //4403036208652
            },
            belongsto:{
                required: true
            },
            /*contactName:{
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
            }*/
        }
    });





    // --------------------------图片上传-------------------------------------------------- //
    Dropzone.autoDiscover = false;
    //  id
    <#if action != "detail">
        var myDropzone = createDropzone("mydropzone","company_photo","imgshowdiv");
    </#if>
    function createDropzone(mydropzone,id,imgdivid) {
        var myDropzone = new Dropzone("div#"+mydropzone, {
            url: "/gzxant/web/file/upload/certificates_photo",  //调用上传图片的接口
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
                    $("#"+id).val(result.message[0].url);
                    $("#s_"+id).val(result.message[0].s_url);   //缩略图       s_contact_photo
                    $("#"+imgdivid).attr('src', "${rc.contextPath}${sysUser.photo}");
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
                    $("#"+id).val("${rc.contextPath}${sysUser.photo}");
                    $("#"+imgdivid).attr('src', "${rc.contextPath}${sysUser.photo}");
                    layer.alert('删除成功');
                });

            }
        });
        return myDropzone;
    }

    $(function() {
        $("#nextIsContact").click(function() {
            $("#contacttab").prop("class","active");
            $("#companytab").removeAttrs("class");
        });
        $("#nextIsSave").click(function() {
            $("#savetab").prop("class","active");
            $("#contacttab").removeAttrs("class");
        });
        $("#returnCompany").click(function() {
            $("#contacttab").removeAttrs("class");
            $("#companytab").prop("class","active");
        });
        $("#returnContact").click(function() {
            $("#savetab").removeAttrs("class");
            $("#contacttab").prop("class","active");
        });
    });

</script>
