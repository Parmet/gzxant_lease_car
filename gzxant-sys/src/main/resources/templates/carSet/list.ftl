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
								<!-- 高级查询查询条件等查看页面在补充 -->
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
                field: 'id', // 列字段名
                title: 'id' // 列标题
            },
            {
                field: 'mileageThreshold',
                title: '里程阈值'
            },
            {
                field: 'eoThreshold',
                title: '电量/油量阈值'
            },
            {
                field: 'carTrainName',
                title: '车系名称'
            },
            {
                field: 'carSizeName',
                title: '车型名称'
            },
            {
                field: 'photo',
                title: '照片'
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

    load_data( getcolumns(), null);

    function dt_explort_buttont() {
        location.href=url + "excel";
    }
</script>