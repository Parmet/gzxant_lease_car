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
    #returnCustomer, #returnIdentity {
        margin-right: 10px;
    }
    #nextIsSave, #nextIsDrive, #nextIsIdentity {
        visibility: hidden;
    }
</style>
<link href="${rc.contextPath}/css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="${rc.contextPath}/css/animate.css" rel="stylesheet">
<link href="${rc.contextPath}/css/animate.css" rel="stylesheet">
<!-- layerDate plugin javascript -->
<script src="${rc.contextPath}/js/plugins/layer/laydate/laydate.js"></script>
<script>
    //外部js调用
    laydate({
        elem: '#iIssueDate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
        event: 'focus' //响应事件。如果没有传入event，则按照默认的click
    });
    laydate({
        elem: '#iValidityPeriod',
        event: 'focus'
    });
    laydate({
        elem: '#dIssueDate',
        event: 'focus'
    });
    laydate({
        elem: '#dValidityPeriod',
        event: 'focus'
    });
</script>


<link href="${rc.contextPath}/css/plugins/dropzone/dropzone.css" rel="stylesheet">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins" >
                <div class="ibox-content">
                    <ul id="myTab" class="nav nav-tabs">
                        <li id="customertab" class="active">
                            <a href="#customer" data-toggle="tab">
                            <#--<a>-->
                                个人客户基本信息
                            </a>
                        </li>
                        <li id="identitytab">
                            <a href="#identity" data-toggle="tab">
                            <#--<a>-->
                                身份证证件信息
                            </a>
                        </li>
                        <li id="drivetab">
                            <a href="#drive" data-toggle="tab">
                            <#--<a>-->
                                驾驶证证件信息
                            </a>
                        </li>
                        <#if action!="detail">
                            <li id="savetab">
                                <a href="#save" data-toggle="tab">
                                <#--<a>-->
                                    完成
                                </a>
                            </li>
                        </#if>
                    </ul>
                    <form class="form-horizontal form-bordered" id="gzxantForm">

                        <input type="hidden" name="id" value="${customer.id}"/>
                        <div id="myTabContent" class="tab-content">
                            <!-- customer tab -->
                            <div class="tab-pane fade in active" id="customer">
                                <div class="form-horizontal form-bordered">

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">姓名：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" name="name" maxlength="10"
                                                   value="${customer.name}" placeholder="输入姓名"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">性别：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <select name="gender" class="form-control">
                                                <option value="">请选择</option>
                                                <#list genderList as gender>
                                                    <option value="${gender.jkey}" <#if gender.jkey==customer.gender>selected</#if>>
                                                        ${gender.jvalue}
                                                    </option>
                                                </#list>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">电话：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" name="tel"
                                                   value="${customer.tel}" placeholder="输入手机号码"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">客户状态：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <select name="status" class="form-control">
                                                <option value="">请选择</option>
                                                <#list statusList as status>
                                                    <option value="${status.jkey}" <#if status.jkey==customer.status>selected</#if>>${status.jvalue}</option>
                                                </#list>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">地址：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" name="address"
                                                   value="${customer.address}" placeholder="输入客户地址"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">准驾车型：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <select name="driveCapability" class="form-control">
                                                <option value="">请选择</option>
                                                <#list capabilityList as c>
                                                    <option value="${c.jkey}" <#if c.jkey==customer.driveCapability>selected</#if>>${c.jvalue}</option>
                                                </#list>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">邮件地址：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" name="email"
                                                   value="${customer.email}" placeholder="输入客户邮件地址"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">紧急联络人：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" name="emergencyContact"
                                                   value="${customer.emergencyContact}" placeholder="输入紧急联络人" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">紧急联络人电话：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" name="emergencyContactTel"
                                                   value="${customer.emergencyContactTel}" placeholder="输入紧急联络人电话" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">与紧急联络人的关系：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <select name="emergencyContactRelationship" class="form-control">
                                                <option value="">请选择</option>
                                                <#list contactList as c>
                                                    <option value="${c.jkey}" <#if c.jkey==customer.emergencyContactRelationship>selected</#if>>${c.jvalue}</option>
                                                </#list>
                                                <option value="">自定义</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">备注：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" name="remark"
                                                   value="${customer.remark}" placeholder="输入客户备注" />
                                        </div>
                                    </div>
                                    <!-- nextIsIdentity -->
                                    <div class="form-horizontal form-bordered operate">
                                        <button type="button" onclick="checkCustomer()" class="btn btn-success">
                                            <#--<#if action != "detail">-->
                                                下一步
                                             <#--   <#else>
                                                下一页
                                            </#if>-->
                                        </button>
                                        <a id="nextIsIdentity" href="#identity" data-toggle="tab" class="btn btn-success"></a>
                                    </div>
                                </div>
                            </div>

                            <!-- identity tab -->
                            <div class="tab-pane fade" id="identity">
                                <div class="form-horizontal form-bordered">
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">证件图片：<span class="required">*</span></label>
                                        <input type="hidden" name="identityImageUrl" id="identity_photo"
                                            value="${customer.identityImageUrl}"/>
                                        <input type="hidden" name="sIdentityImageUrl" id="s_identity_photo"
                                            value="${customer.sIdentityImageUrl}"/>  <!-- 缩略图 -->
                                        <div class="col-sm-3">
                                            <div id="localImag" style="margin-left:15px;">
                                                <div class="img_box" id="imgBox">
                                                    <img id="identityImgshowdiv" style="width: 120px" src="${rc.contextPath}/file/image?path=${customer.sIdentityImageUrl}"
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
                                        <label class="col-sm-3 control-label">证件号码：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" name="identityNumber"
                                                   value="${customer.identityNumber}" placeholder="请输入身份证证件号码"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">发证日期：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <input id="iIssueDate" value="${customer.iIssueDate}" type="text" class="laydate-icon form-control layer-date" name="iIssueDate">
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">有效期至：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <input id="iValidityPeriod" value="${customer.iValidityPeriod}" type="text" class="laydate-icon form-control layer-date" name="iValidityPeriod">
                                        </div>
                                    </div>

                                    <div class="form-horizontal form-bordered operate">
                                        <!-- returnCustomer -->
                                        <a id="returnCustomer" href="#customer" data-toggle="tab" class="btn btn-success">
                                            <#if action != "detail">
                                                上一步
                                            <#else>
                                                上一页
                                            </#if>
                                        </a>
                                        <button type="button" onclick="checkIdentity()" class="btn btn-success">
                                            <#if action != "detail">
                                                下一步
                                            <#else>
                                                下一页
                                            </#if>
                                        </button>
                                        <!-- nextIsDrive  -->
                                        <a id="nextIsDrive" href="#drive" data-toggle="tab" class="btn btn-success"></a>
                                    </div>
                                </div>
                            </div>

                            <!-- drive tab -->
                            <div class="tab-pane fade" id="drive">
                                <div class="form-horizontal form-bordered">
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">证件图片：<span class="required">*</span></label>
                                        <input type="hidden" name="driveImageUrl" id="drive_photo"
                                            value="${customer.driveImageUrl}"/>
                                        <input type="hidden" name="sDriveImageUrl" id="s_drive_photo"
                                            value="${customer.sDriveImageUrl}"/><!-- 缩略图 -->
                                        <div class="col-sm-3">
                                            <div id="localImag" style="margin-left:15px;">
                                                <div class="img_box" id="imgBox">
                                                    <img id="driveImgshowdiv" style="width: 120px" src="${customer.sIdentityImageUrl}"
                                                         onerror="javascript:errimg()" class="img_file img-rounded"/>
                                                </div>
                                            </div>
                                        </div>
                                        <#if action!="detail">
                                            <div class="col-sm-4">
                                                <div id="mydropzone2" class="dropzone"></div>
                                            </div>
                                        </#if>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">证件号码：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" name="driveNumber" required
                                                   value="${customer.driveNumber}" placeholder="请输入驾驶证证件号码"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">发证日期：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <input id="dIssueDate" type="text" value="${customer.dIssueDate}" class="laydate-icon form-control layer-date" name="dIssueDate">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">有效期至：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <input id="dValidityPeriod" type="text" value="${customer.dValidityPeriod}" class="laydate-icon form-control layer-date" name="dValidityPeriod">
                                        </div>
                                    </div>
                                    <div class="form-horizontal form-bordered operate">
                                        <!-- returnIdentity -->
                                        <a id="returnIdentity" href="#identity" data-toggle="tab" class="btn btn-success">
                                            <#if action != "detail">
                                                上一步
                                            <#else>
                                                上一页
                                            </#if>
                                        </a>
                                        <button type="button" onclick="checkDrive()" class="btn btn-success">
                                            <#if action != "detail">
                                                下一步
                                            <#else>
                                                下一页
                                            </#if>
                                        </button>
                                        <!-- nextIsDrive -->
                                        <a id="nextIsSave" href="#save" data-toggle="tab" class="btn btn-success"></a>
                                    </div>
                                </div>
                            </div>
                            <#if action!="detail">
                                <!-- save tab -->
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
                                            <!-- returnDrive -->
                                            <a id="returnDrive" href="#drive" data-toggle="tab" class="btn btn-success">上一步</a>
                                        </div>
                                    </div>
                                </div>
                            </#if>
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

    //回显图片
    $("#driveImgshowdiv").attr("src","${rc.contextPath}/file/image?path="+encodeURIComponent("${customer.sDriveImageUrl?replace('\\', '\\\\')}"));
    $("#identityImgshowdiv").attr("src","${rc.contextPath}/file/image?path="+encodeURIComponent("${customer.sIdentityImageUrl?replace('\\', '\\\\')}"));

    /**
     * 错误图片的默认处理
     */
    function errimg() {
        $("#identityImgshowdiv").attr('src', "${rc.contextPath}/img/log9.png");
        $("#driveImgshowdiv").attr('src', "${rc.contextPath}/img/log9.png");
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
    // $.validator.addMethod("isTel", function(value, element) {
    //     var length = value.length;
    //     var phone = /(^(\d{3,4}-)?\d{6,8}$)|(^(\d{3,4}-)?\d{6,8}(-\d{1,5})?$)|(\d{11})/;
    //     return this.optional(element) || (phone.test(value));
    // }, "请填写正确的固定电话");//可以自定义默认提示信息


    //  ---------------------   通过点击下一步来判断，如果校验成功，则用js去触发a标签的点击事件（a标签用来跳转标签页的）    ---------------------
    function checkDrive() {
        <#if action != "detail">
            if (info_validate.valid()) {
                // alert("驾驶证信息校验通过");
                document.getElementById("nextIsSave").click();
            }
        <#else>
            document.getElementById("nextIsSave").click();
        </#if>
    }
    function checkIdentity() {
        <#if action != "detail">
            if (info_validate.valid()) {
                // alert("身份证信息校验通过");
                document.getElementById("nextIsDrive").click();
            }
        <#else>
            document.getElementById("nextIsDrive").click();
        </#if>
    }
    function checkCustomer() {
        <#if action != "detail">
            if (info_validate.valid()) {
                // alert("驾驶证信息校验通过");
                document.getElementById("nextIsIdentity").click();
            }
        <#else>
            document.getElementById("nextIsIdentity").click();
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
            gender:{
                required: true
            },
            tel:{
                required: true,
                isMobile:true
            },
            status:{
                required: true
            },
            address:{
                required: true
            },
            driveCapability:{
                required: true
            },
            email:{
                required: true,
                email:true
            },
            emergencyContact:{
                required: true
            },
            emergencyContactTel:{
                required: true,
                isMobile:true,
            },
            identityNumber:{
                required: true
            },
            iIssueDate:{
                required: true
            },
            iValidityPeriod:{
                required: true
            },
            identityImageUrl:{
                required: true
            },
            sIdentityImageUrl:{
                required: true
            },
            driveNumber:{
                required: true
            },
            dIssueDate:{
                required: true
            },
            dValidityPeriod:{
                required: true
            },
            driveImageUrl:{
                required: true
            },
            sDriveImageUrl:{
                required: true
            }
        }/*,
        messages: {
            // customer part
            name:"请填写客户姓名",
            gender:"请选择客户性别",
            tel:"请填写正确的联系方式",
            status:"请选择客户状态",
            address:"请填写客户地址",
            driveCapability:"请填写客户准驾类型",
            email:"请填写客户邮箱",
            emergencyContact:"请填写客户的紧急联系人",
            emergencyContactTel:"请填写客户的紧急联系人电话",
            //身份证
            identityNumber:"请填写证件号码",
            iIssueDate:"请填写发证日期",
            iValidityPeriod:"请填写证件有效截至日期",
            identityImageUrl:"请上传客户的证件照片",
            sIdentityImageUrl:"请上传客户的证件照片",
            //驾驶证
            driveNumber:"请填写证件号码",
            dIssueDate:"请填写发证日期",
            dValidityPeriod:"请填写证件有效截至日期",
            driveImageUrl:"请上传客户的证件照片",
            sDriveImageUrl:"请上传客户的证件照片",
        }*/
    });


    // --------------------------图片上传-------------------------------------------------- //
    Dropzone.autoDiscover = false;
    //  id
    <#if action != "detail">
        var myDropzone = createDropzone("mydropzone","identity_photo","identityImgshowdiv");
        var myDropzone2 = createDropzone("mydropzone2","drive_photo","driveImgshowdiv");
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
                    $("#s_"+id).val(result.message[0].s_url);   //缩略图       s_identity_photo
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
        $("#nextIsIdentity").click(function() {
            $("#identitytab").prop("class","active");
            $("#customertab").removeAttrs("class");
        });
        $("#nextIsDrive").click(function() {
            $("#drivetab").prop("class","active");
            $("#identitytab").removeAttrs("class");
        });
        $("#nextIsSave").click(function() {
            $("#savetab").prop("class","active");
            $("#drivetab").removeAttrs("class");
        });
        $("#returnCustomer").click(function() {
            $("#identitytab").removeAttrs("class");
            $("#customertab").prop("class","active");
        });
        $("#returnIdentity").click(function() {
            $("#drivetab").removeAttrs("class");
            $("#identitytab").prop("class","active");
        });
        $("#returnDrive").click(function() {
            $("#savetab").removeAttrs("class");
            $("#drivetab").prop("class","active");
        });
    });

</script>
