<style>
    .bootstrap-table .table {
        width:1980px;
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
                                    <label for="id" class="control-label">客户编号：</label>
                                    <input type="text" class="form-filter form-control _search"  name="search_like_enterprise_number"  />
                                </div>
                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                    <label for="name" class="control-label">公司名称：</label>
                                    <input type="text" class="form-filter form-control _search"  name="search_like_name"  />
                                </div>
                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                    <label for="identityCard" class="control-label">公司类别：</label>
                                    <input type="text" class="form-filter form-control _search"  name="search_like_category"  />
                                </div>
                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                    <label for="tel" class="control-label">注册日期：</label>
                                    <input id="registeredDate" class="form-control _search" readonly
                                           name="search_like_registered_date">
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
                            <button type="button" class="btn btn-success" onclick="doExport()">
                                <i class="glyphicon glyphicon-export" aria-hidden="true"></i> 导出数据
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

    function doExport() {
        window.location.href = url + "exportXls";
    }

    /**
     * 联系人页面 按钮
     * @returns {string}
     */
    function dt_contact_button(row) {
        var contactO = '<a class="btn btn-info btn-sm" href="#" title="客户信息联系人"  mce_href="#" ' +
                'onclick="toContactPage(\'' + row.id + '\')"><i class="fa fa-phone"></i></a> ';

        return contactO;

    }
    
    function toContactPage(id) {
        location.href = url + "contact/" + id;
    }
    
    function getcolumns() {
        var c = [
            {
                checkbox: true
            },
            {
                field: 'enterpriseNumber', // 列字段名
                title: '企业编码', // 列标题
                width: 140
            },
            {
                field: 'name',
                title: '公司名称',
                width: 190
            },
            {
                field: 'abbreviation',
                title: '简称',
                width: 80
            },
            {
                field: 'property',
                title: '公司性质',
                width: 120
            },
            {
                field: 'category',
                title: '公司类别',
            },
            {
                field: 'belongsto',
                title: '所属组织',
                width: 190
            },
            {
                field: 'addressS',
                title: '公司地址',
                width: 200
            },
            {
                field: 'registeredCapital',
                title: '注册资金'
            },
            {
                field: 'registeredDate',
                title: '注册日期'
            },
            {
                field: 'legalRepresentative',
                title: '法人代表'
            },
            {
                field: 'email',
                title: '邮箱地址',
                width: 170
            },
            {
                field: 'licenseNumber',
                title: '营业执照号',
                width: 170
            },
            {
                field: 'status',
                title: '客户状态',
                width: 80
            },
            {
                title: '操作',
                field: 'id',
                align: 'center',
                width: 200,
                formatter: function (value, row, index) {

                    return dt_contact_button(row)+dt_edit_button(row)+dt_detail_button(row)+dt_delete_button(row);
                }
            }];

        return c;
    }

    load_data( getcolumns(), {"createDate": "desc"});
</script>