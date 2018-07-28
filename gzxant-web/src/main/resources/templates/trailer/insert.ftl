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
    #nextIsSave, #nextIsEnclosure, #nextIsCost {
        visibility: hidden;
    }
</style>

<!-------------------- 日期控件样式 ---------------------->
<link href="${rc.contextPath}/css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="${rc.contextPath}/css/animate.css" rel="stylesheet">
<script src="${rc.contextPath}/js/plugins/layer/laydate/laydate.js"></script>
<script>
    window.onload = function() {
        laydate({
            elem: '#trailerDate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
            event: 'focus' //响应事件。如果没有传入event，则按照默认的click
        });

        laydate({
            elem: '#costDate',
            event: 'focus'
        });
    };
</script>

<!-------------------- end ---------------------->

<link href="${rc.contextPath}/css/plugins/dropzone/dropzone.css" rel="stylesheet">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins" >
                <div class="ibox-content">
                    <ul id="myTab" class="nav nav-tabs">
                        <li id="trailertab" class="active">
                            <#--<a href="#trailer" data-toggle="tab">-->
                            <a>
                                基本信息
                            </a>
                        </li>
                        <li id="costtab">
                            <#--<a href="#cost" data-toggle="tab">-->
                            <a>
                                费用信息
                            </a>
                        </li>
                        <li id="enclosuretab">
                            <#--<a href="#enclosure" data-toggle="tab">-->
                            <a>
                                附件信息
                            </a>
                        </li>
                    </ul>



                    <div id="myTabContent" class="tab-content">
                        <!-- trailer tab -->
                        <div class="tab-pane fade in active" id="trailer">
                            <div class="form-horizontal form-bordered">
                                <form class="form-horizontal form-bordered" id="gzxantForm">
                                    <input type="hidden" id="id" name="id" value="${trailer.id}"/>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">⻋牌号：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" name="carNumber" maxlength="18" <#if action=="detail">readonly</#if>
                                                   value="${trailer.carNumber}" placeholder="输入⻋牌号"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">类型：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <select name="type" class="form-control">
                                                <option value="">请选择</option>
                                                <#list typeList as type>
                                                    <option value="${type.jkey}" <#if type.jkey==trailer.type>selected</#if>>
                                                        ${type.jvalue}
                                                    </option>
                                                </#list>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">所属组织：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <select name="belongstoId" class="form-control">
                                                <option value="">请选择</option>
                                                <#list companyList as company>
                                                    <option value="${company.id}" <#if company.id==trailer.belongstoId>selected</#if>>
                                                        ${company.name}
                                                    </option>
                                                </#list>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">执行人：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" name="executor" maxlength="4" <#if action=="detail">readonly</#if>
                                                   value="${trailer.executor}" placeholder="输入执行人"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">地点：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" name="place" <#if action=="detail">readonly</#if>
                                                   value="${trailer.place}" placeholder="输入客户地址"/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">执行时间：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <input id="trailerDate" value="${trailer.time}" type="text" <#if action=="detail">readonly</#if>
                                                   class="laydate-icon form-control layer-date" name="date">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">状态：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <select name="status" class="form-control">
                                                <option value="">请选择</option>
                                                <#list statusList as status>
                                                    <option value="${status.jkey}" <#if status.jkey==trailer.status>selected</#if>>
                                                        ${status.jvalue}
                                                    </option>
                                                </#list>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">拖车费用：<span class="required">*</span></label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" name="cost" <#if action=="detail">readonly</#if>
                                                   value="${trailer.cost}" placeholder="输入拖车费用" />
                                        </div>
                                    </div>
                                </form>
                                <div class="form-horizontal form-bordered operate">
                                    <button type="button" onclick="checkTrailer()" class="btn btn-success">
                                    <#if action != "detail">
                                        保存
                                       <#else>
                                       下一页
                                   </#if>
                                    </button>
                                    <a id="nextIsCost" href="#cost" data-toggle="tab" class="btn btn-success"></a>
                                </div>
                            </div>
                        </div>

                        <!-- cost tab -->
                        <div class="tab-pane fade" id="cost">
                            <div class="form-horizontal form-bordered">
                                <#if action != "detail">
                                    <div id="exampleToolbar" role="group">
                                        <button type="button" class="btn btn-danger" onclick="batch_remove()">
                                            <i class="fa fa-trash" aria-hidden="true"></i> 删除
                                        </button>
                                        <button type="button" class="btn btn-info" onclick="dt_insert()">
                                            <i class="fa fa-plus-square" aria-hidden="true"></i> 添加
                                        </button>
                                        <button type="button" class="btn btn-success" onclick="re_load()">
                                            <i class="fa fa-plus-square" aria-hidden="true"></i> 刷新
                                        </button>
                                    </div>
                                </#if>

                                <table class="table" id="exampleTable" data-mobile-responsive="true">
                                </table>

                                <!-- 费用列表 -->
                                <div class="form-horizontal form-bordered operate">
                                    <button type="button" onclick="checkCost()" class="btn btn-success">
                                        <#if action != "detail">
                                            保存
                                        <#else>
                                            下一页
                                        </#if>
                                    </button>
                                    <!-- nextIsEnclosure  -->
                                    <a id="nextIsEnclosure" href="#enclosure" data-toggle="tab" class="btn btn-success"></a>
                                </div>
                            </div>
                        </div>

                        <!-- enclosure tab -->
                        <div class="tab-pane fade" id="enclosure">
                            <div class="form-horizontal form-bordered">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">证件图片：<span class="required">*</span></label>
                                    <form id="enclosureForm">
                                        <input id="enclosureId" name="id" type="hidden" value="value="${enclosure.id}">
                                        <input type="hidden" name="url" id="photo"
                                               value="${enclosure.url}"/>
                                        <input type="hidden" name="thumbnail" id="s_photo"
                                               value="${enclosure.thumbnail}"/><!-- 缩略图 -->
                                        <input type="hidden" name="entityId" id="entityId"
                                               value="${enclosure.entityId}"/>
                                    </form>
                                        <div class="col-sm-3">
                                        <div id="localImag" style="margin-left:15px;">
                                            <div class="img_box" id="imgBox">
                                                <img id="imgShowdiv" style="width: 120px" src="${enclosure.thumbnail}"
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
                                <div class="form-horizontal form-bordered operate">
                                    <button type="button" onclick="checkEnclosure()" class="btn btn-success">
                                        <#if action != "detail">
                                            完成
                                        <#else>
                                            回到列表
                                        </#if>
                                    </button>
                                    <!-- nextIsSave -->
                                    <a id="nextIsSave" href="#save" data-toggle="tab" class="btn btn-success"></a>
                                </div>
                            </div>
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

    function dt_insert() {
        if (url.endsWith("cost/")) {
            url = clearUrl(url);
        }
        url += "cost/";
        var id = $("input[name='id']").val();
        alert("id" + id);
        dt_action("新增", "insert", "/"+id);

    }

    function dt_update(id) {
        if (url.endsWith("cost/")) {
            url = clearUrl(url);
        }
        url += "cost/";
        alert("url = " + url + "  id = " + id);
        dt_action("编辑", "update/" + id);
    }

    function dt_action(title, action, id) {
        var initSelect2 = "";
        if (id == undefined) {
            id = "";
        }
        $.get(url + action + id, {},function (html) {
            layer.open({
                type: 1,
                title: title,
    //	        btn: btn,
                id: 'layer' + action,
                btnAlign: 'c',
                maxmin: true,
                shadeClose: false, // 点击遮罩关闭层
                area: ['800px', '520px'],
                content: html + initSelect2,
                yes: function(){
                    layer.closeAll();
                },
            });
        }, "html");
    }

    // startup the datepicker
    $('.datepicker').datepicker();

    action = "${action}";
    function  cusFunction() {
        console.info("提交之前，最后执行自定义的函数");
    }

    //回显图片
    $("#imgShowdiv").attr("src","${rc.contextPath}/file/image?path="+encodeURIComponent("${enclosure.thumbnail?replace('\\', '\\\\')}"));

    /**
     * 错误图片的默认处理
     */
    function errimg() {
        $("#imgShowdiv").attr('src', "${rc.contextPath}/img/log9.png");
    }

    //  ---------------------   通过点击下一步来判断，如果校验成功，则用js去触发a标签的点击事件（a标签用来跳转标签页的）    ---------------------
    function checkEnclosure() {
        <#if action != "detail">
        var img = $("#photo").val();
        if (img == "") {
            layer.alert("请上传你的附件！");
        } else {
            var theUrl = "/gzxant/web/trailer/enclosure/insert";
            $.ajax({
                cache: true,
                type: "POST",
                url: theUrl,
                data: $('#enclosureForm').serialize(),// 你的formid
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
                        window.location.href = "http://localhost:8081/gzxant/web/trailer";
                    } else {
                        layer.alert(data.error);
                    }

                }
            });
        }

        <#else>
            window.location.href = "http://localhost:8081/gzxant/web/trailer";
        </#if>
    }
    function checkCost() {
        <#if action != "detail">
            url = clearUrl(url);
            if (info_validate.valid()) {
                // alert("身份证信息校验通过");
                document.getElementById("nextIsEnclosure").click();
            }
        <#else>
            document.getElementById("nextIsEnclosure").click();
        </#if>
    }
    function checkTrailer() {
        <#if action != "detail">
            if (info_validate.valid()) {
                if (url.endsWith("tupdate/")) {
                    url = clearUrl(url);
                }
                $.ajax({
                    cache: true,
                    type: "POST",
                    url: url+action,
                    data: $('#gzxantForm').serialize(),// 你的formid
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
                            $("input[name='id']").val(data.message);
                            $("input[name='entityId']").val(data.message);
                            load_data( getcolumns(), {"createDate": "desc"}, data.message);
                            document.getElementById("nextIsCost").click();
                        } else {
                            layer.alert(data.error);
                        }

                    }
                });
            }
        <#else>
            document.getElementById("nextIsCost").click();
            if (url.endsWith("tdetail/")) {
                url = clearUrl(url);
            }
            load_data( getcolumns(), {"createDate": "desc"}, $("input[name='id']").val());
        </#if>


    }


    var info_validate = $('#gzxantForm');
    var error = $('.alert-danger', info_validate);
    info_validate.validate({
        errorElement: 'span',
        errorClass: 'error',
        focusInvalid: true,
        rules: {
            carNumber:{
                required: true
            },
            type:{
                required: true
            },
            belongstoId:{
                required: true
            },
            executor:{
                required: true
            },
            place:{
                required: true
            },
            date:{
                required: true
            },
            status:{
                required: true
            },
            cost:{
                required: true
            }
        }
    });


    // --------------------------图片上传-------------------------------------------------- //
    Dropzone.autoDiscover = false;
    //  id
    <#if action != "detail">
        var myDropzone = createDropzone("mydropzone2","photo","imgShowdiv");
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
                    $("#s_"+id).val(result.message[0].s_url);   //缩略图       s_cost_photo
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

</script>
<script type="text/javascript">
    $(function() {
        $("#nextIsCost").click(function() {
            $("#costtab").prop("class","active");
            $("#trailertab").removeAttrs("class");
        });
        $("#nextIsEnclosure").click(function() {
            $("#enclosuretab").prop("class","active");
            $("#costtab").removeAttrs("class");
        });
        $("#nextIsSave").click(function() {
            $("#savetab").prop("class","active");
            $("#enclosuretab").removeAttrs("class");
        });
    });

    url = clearUrl(url);        //  /gzxant/web/static/


    function clearUrl(url) {
        for (var i = 0 ;i < 2; i++) {
            url = url.substring(0,url.lastIndexOf("/"));
        }
        return url + "/";
    }



    function getcolumns() {
        var c = [
            {
                checkbox: true
            },
            {
                field: 'trailerId', // 列字段名
                title: '编号', // 列标题
                width: 140
            },
            {
                field: 'type',
                title: '类型',
                width: 100
            },
            {
                field: 'cost',
                title: '费用',
                width: 120
            },
            {
                field: 'date',
                title: '日期',
                width: 120
            },
            {
                title: '操作',
                field: 'id',
                align: 'center',
                width: 140
                /*,
                formatter: function (value, row, index) {
                    return dt_edit_button(row)+dt_detail_button(row)+dt_delete_button(row);
                }*/
                <#if action != "detail">
                    ,formatter: function (value, row, index) {
                        return dt_edit_button(row)+dt_detail_button(row)+dt_delete_button(row);
                    }
                <#else>
                    ,formatter: function (value, row, index) {
                        return dt_detail_button(row);
                    }
                </#if>
            }];

        return c;
    }

    function load_data(columns, sorts, id) {
        $('#exampleTable').bootstrapTable(
                {
                    method: 'post', // 服务器数据的请求方式 get or post
                    url: url + "cost/list/" + id, // 服务器数据的加载地址showColumns : true,
                    iconSize: 'outline',
                    toolbar: '#exampleToolbar',
                    striped: true, // 设置为true会有隔行变色效果
                    dataType: "json", // 服务器返回的数据类型
                    //showRefresh : true,
                    //showToggle : true,
                    //
                    pagination: true, // 设置为true会在底部显示分页条
                    // queryParamsType : "limit",
                    // //设置为limit则会发送符合RESTFull格式的参数
                    singleSelect: false, // 设置为true将禁止多选
                    // contentType : "application/x-www-form-urlencoded",
                    // //发送到服务器的数据编码类型
                    pageSize: 10, // 如果设置了分页，每页数据条数
                    pageNumber: 1, // 如果设置了分布，首页页码
                    //search : true, // 是否显示搜索框
                    //showColumns : true, // 是否显示内容下拉框（选择显示的列）
                    sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者
                    // "server"
                    queryParams: function (params) {

                        var searchParams = {};
                        $("#exampleToolbar ._search").each(function () {
                            searchParams[$(this).attr('name')] = $(this).val();
                        });

                        var p = {
                            "pageNumber": this.pageNumber,
                            "pageSize": this.pageSize,
                            "searchParams": searchParams,
                            "sorts": sorts

                        };
                        return p;

                    },
                    // //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
                    // queryParamsType = 'limit' ,返回参数必须包含
                    // limit, offset, search, sort, order 否则, 需要包含:
                    // pageSize, pageNumber, searchText, sortName,
                    // sortOrder.
                    // 返回false将会终止请求
                    columns: columns
                });
    }

</script>