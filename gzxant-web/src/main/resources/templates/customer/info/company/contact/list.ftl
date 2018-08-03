<style>
    .bootstrap-table .table {
        width: 1250px;
    }
</style>
<script>
    $(function() {
       var flag = "${flag}";
       if (flag == "true") {
           //弹出添加框
           dt_insert();
       }
    });
</script>
<div class="wrapper wrapper-content animated fadeInRight">


    <div class="col-sm-12">
        <div class="ibox">
            <div class="ibox-body">
                <div id="exampleToolbar" role="group">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <span class="panel-title" style="font-weight: bold; margin-right:20px; font-size: large">企业编号: ${company.enterpriseNumber}</span>
                            <span class="panel-title" style="font-weight: bold; font-size: large">公司名称: ${company.name}</span>
                        </div>
                        <div class="panel-heading">
                            <h3 class="panel-title">查询条件</h3>
                        </div>
                        <#-- TODO: bind new search criteria -->
                        <div class="panel-body">
                            <div class="row">

                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                    <label for="name" class="control-label">联系人：</label>
                                    <input type="text" class="form-filter form-control _search"  name="search_like_name"  />
                                </div>
                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                    <label for="tel" class="control-label">手机号码：</label>
                                    <input type="text" class="form-filter form-control _search"  name="search_like_tel"  />
                                </div>
                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                    <label for="idNum" class="control-label">身份证号码：</label>
                                    <input type="text" class="form-filter form-control _search"  name="search_like_id_num"  />
                                </div>
                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                    <label for="email" class="control-label">邮箱：</label>
                                    <input id="email" class="form-control _search"
                                           name="search_like_email">
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

    var id = "${id}";       //公司id

    /**
     * 联系人页面 按钮
     * @returns {string}
     */
    function dt_contact_button(row) {
        var contactO = '<a class="btn btn-warning btn-sm" href="#" title="联系人"  mce_href="#" ' +
                'onclick="toContactPage(\'' + row.id + '\')"><i class="fa fa-remove"></i></a> ';

        return contactO;

    }

    function toContactPage(id) {
        location.href = url + "toContactPage";
    }
    
    function getcolumns() {
        var c = [
            {
                checkbox: true
            },
            {
                field: 'name',
                title: '联系人',
                width: 100
            },
            {
                field: 'tel',
                title: '电话',
                width: 100
            },
            {
                field: 'idNum',
                title: '身份证号码',
                width: 130
            },
            {
                field: 'position',
                title: '职务',
                width: 80
            },
            {
                field: 'email',
                title: '邮箱',
                width: 100
            },
            {
                field: 'remark',
                title: '备注',
                width: 100
            },
            {
                title: '操作',
                field: 'id',
                align: 'center',
                width: 120,
                formatter: function (value, row, index) {

                    return dt_edit_button(row)+dt_detail_button(row)+dt_delete_button(row);
                }
            }];

        return c;
    }

    load_data( getcolumns(), {"createDate": "desc"});


</script>