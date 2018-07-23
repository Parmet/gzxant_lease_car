<style>
    .bootstrap-table .table {
        width: 1450px;
    }
</style>
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
                                    <input type="text" class="form-filter form-control _search"  name="search_like_id"  />
                                </div>
                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                    <label for="name" class="control-label">姓名：</label>
                                    <input type="text" class="form-filter form-control _search"  name="search_like_name"  />
                                </div>
                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                    <label for="identityCard" class="control-label">身份证号码：</label>
                                    <input type="text" class="form-filter form-control _search"  name="search_like_identity_card"  />
                                </div>
                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                    <label for="tel" class="control-label">手机号码：</label>
                                    <input type="text" class="form-filter form-control _search"  name="search_like_tel"  />
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

    function getcolumns() {
        var c = [
            {
                checkbox: true
            },
            {
                field: 'customerId', // 列字段名
                title: '客户编码', // 列标题
                width: 140
            },
            {
                field: 'name',
                title: '姓名',
                width: 100
            },
            {
                field: 'gender',
                title: '性别',
                width: 80
            },
            {
                field: 'tel',
                title: '联系方式',
                width: 120
            },
            {
                field: 'identityNumber',
                title: '身份证号码',
                width: 170
            },
            {
                field: 'driveNumber',
                title: '驾驶证号码',
                width: 170
            },
            {
                field: 'address',
                title: '地址'
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