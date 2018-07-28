<style>
    .bootstrap-table .table {
        width:1450px;
    }
</style>
<!-------------------- 日期控件样式 ---------------------->
<link href="${rc.contextPath}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="${rc.contextPath}/css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="${rc.contextPath}/css/animate.css" rel="stylesheet">
<link href="${rc.contextPath}/css/style.css?v=4.1.0" rel="stylesheet">
<script src="${rc.contextPath}/js/plugins/layer/laydate/laydate.js"></script>
<script>
    $(function() {
        //外部js调用
        laydate({
            elem: '#registeredDate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
            event: 'focus' //响应事件。如果没有传入event，则按照默认的click
        });
    });
</script>

<div class="wrapper wrapper-content animated fadeInRight">


    <div class="col-sm-12">
        <div class="ibox">
            <div class="ibox-body">
                <div id="exampleToolbar" role="group">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">查询条件</h3>
                        </div>
                    <#-- TODO: bind new search criteria -->
                        <div class="panel-body">
                            <div class="row">

                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                    <label for="id" class="control-label">编号：</label>
                                    <input type="text" class="form-filter form-control _search"  name="search_like_id"  />
                                </div>
                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                    <label for="carNumber" class="control-label">车牌号：</label>
                                    <input type="text" class="form-filter form-control _search"  name="search_like_car_number"  />
                                </div>
                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                    <label for="type" class="control-label">类型：</label>
                                    <select name="search_like_type" class="form-filter form-control _search">
                                        <option value="">请选择</option>
                                        <#list typeList as type>
                                            <option value="${type.jkey}">
                                                ${type.jvalue}
                                            </option>
                                        </#list>
                                    </select>
                                </div>
                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                    <label for="affiliatedOrganization" class="control-label">所属组织：</label>
                                    <select name="search_eq_belongsto_id" class="form-filter form-control _search">
                                        <option value="">请选择</option>
                                        <#list companyList as company>
                                            <option value="${company.id}">
                                                ${company.name}
                                            </option>
                                        </#list>
                                    </select>
                                </div>
                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                    <label for="executor" class="control-label">执行人：</label>
                                    <input type="text" class="form-filter form-control _search"  name="search_like_executor"  />
                                </div>
                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                    <label for="date" class="control-label">执行时间：</label>
                                    <input id="registeredDate" class="form-control _search"
                                           name="search_like_date">
                                </div>
                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                    <label for="status" class="control-label">状态：</label>
                                    <select name="search_like_status" class="form-filter form-control _search">
                                        <option value="">请选择</option>
                                        <#list statusList as status>
                                            <option value="${status.jkey}">
                                                ${status.jvalue}
                                            </option>
                                        </#list>
                                    </select>
                                </div>
                            </div>

                        </div>
                        <div class="panel-footer">
                            <button type="button" class="btn btn-success" onclick="re_load()">
                                <i class="fa fa-search" aria-hidden="true"></i> 查询
                            </button>
                            <button type="button" class="btn btn-primary" onclick="reset()">
                                <i class="fa fa-circle-thin" aria-hidden="true"></i> 重置
                            </button>
                            <button type="button" class="btn btn-danger" onclick="batch_remove()">
                                <i class="fa fa-trash" aria-hidden="true"></i> 删除
                            </button>
                            <button type="button" class="btn btn-info" onclick="dt_insert()">
                                <i class="fa fa-plus-square" aria-hidden="true"></i> 添加
                            </button>
                        </div>
                    </div>
                </div>

                <table class="table" id="exampleTable" data-mobile-responsive="true">
                </table>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">

    function dt_insert() {
        window.location.href = url + "tinsert";
    }

    /**
     * 编辑 按钮
     * @returns {string}
     */
    function dt_edit_button(row) {
        var editO = '<a class="btn btn-primary btn-sm" href="#" mce_href="#" title="编辑" onclick="dt_update(\''
                + row.id + '\')"><i class="fa fa-edit"></i></a> ';
        return editO;
    }

    function dt_update(id) {
        window.location.href = url + "tupdate/" + id;
    }


    function getcolumns() {
        var c = [
            {
                checkbox: true
            },
            {
                field: 'id', // 列字段名
                title: '编号', // 列标题
                width: 140
            },
            {
                field: 'carNumber',
                title: '车牌号',
                width: 170
            },
            {
                field: 'type',
                title: '类型',
                width: 100
            },
            {
                field: 'affiliatedOrganization',
                title: '所属组织',
                width: 300
            },
            {
                field: 'executor',
                title: '执行人',
                width: 120
            },
            {
                field: 'date',
                title: '执行时间',
                width: 120
            },
            {
                field: 'status',
                title: '状态',
                width: 100
            },
            {
                title: '操作',
                field: 'id',
                align: 'center',
                width: 140,
                formatter: function (value, row, index) {

                    return dt_edit_button(row)+dt_detail_button(row)+dt_delete_button(row);
                }
            }];

        return c;
    }

    load_data( getcolumns(), {"createDate": "desc"});
</script>