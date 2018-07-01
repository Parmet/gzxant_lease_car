<div class="wrapper wrapper-content animated fadeInRight">
        <div class="col-sm-12">
            <div class="ibox">
                <div class="ibox-body">
                    <div id="exampleToolbar" role="group">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">查询条件</h3>
                            </div>
                            <div class="panel-body">
                                <div class="row">

                                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
                                        <label for="nameInput" class="control-label">登录名：</label>
                                        <input type="text" class="form-filter form-control _search" id="nameInput" name="search_eq_login_name"  />
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
                                        <label for="nameInput" class="control-label">工号：</label>
                                        <input type="text" class="form-filter form-control _search" id="nameInput" name="search_eq_no"  />
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
                                        <label for="nameInput" class="control-label">姓名：</label>
                                        <input type="text" class="form-filter form-control _search" id="nameInput" name="search_like_name"  />
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

    function getcolumns() {
        var c = [
            {
                checkbox: true
            },
            {
                title: '头像',
                field: 'photo',
                align: 'center',
                formatter: function (value, row, index) {
                    return '<img style="width:30px" src="${rc.contextPath}'+value+'"/>';
                }
            },
            {
                field: 'id', // 列字段名
                title: 'id' // 列标题
            },
            {
                field: 'loginName',
                title: '登陆名'
            },
            {
                field: 'name',
                title: '姓名'
            },
            {
                field: 'email',
                title: '邮箱'
            },
            {
                field: 'no',
                title: '工号'
            },
            {
                field: 'phone',
                title: '电话'
            },
            {
                field: 'mobile',
                title: '手机'
            },
            {
                field: 'remark',
                title: '描述'
            },

            {
                field : 'loginFlag',
                title : '状态',
                align : 'center',
                formatter : function(value, row, index) {
                    if (value == 'Y') {
                        return '<span class="label label-primary">正常</span>';
                    } else if (value == 'N') {
                        return '<span class="label label-danger">禁用</span>';
                    }
                }
            },
            {
                title: '操作',
                field: 'id',
                align: 'center',
                formatter: function (value, row, index) {

                    return dt_edit_button(row)+dt_detail_button(row)+dt_delete_button(row);
                }
            }];

        return c;
    }

    load_data( getcolumns(), {"createDate": "desc"});

    function dt_explort_buttont() {
        location.href=url + "excel";
    }
</script>