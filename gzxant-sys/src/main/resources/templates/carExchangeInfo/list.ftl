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
                                	 <div class="col-lg-3 col-md-4 col-sm-12 col-xs-12 form-group">
                                        <label for="nameInput" class="control-label">原车牌号：</label>
                                        <input type="text" class="form-filter form-control _search" id="nameInput" name="search_like_car_number"  />
                                    </div>
                                    
                                    <div class="col-lg-3 col-md-4 col-sm-12 col-xs-12 form-group">
                                        <label for="nameInput" class="control-label">合同号：</label>
                                        <input type="text" class="form-filter form-control _search" id="nameInput" name="search_like_contract_no_new"  />                                      
                                    </div>
                                    
                                    <div class="col-lg-3 col-md-4 col-sm-12 col-xs-12 form-group">
                                        <label for="nameInput" class="control-label">申请时间：</label>
                                        <input type="date" class="form-filter form-control _search" id="nameInput" name="search_like_apply_date"  />                                      
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
                field: 'contractNoNew', // 列字段名
                title: '合同编号' // 列标题
            },
            {
                field: 'carNumber',
                title: '车牌号'
            },
            {
                field: 'applyCarNumber',
                title: '预申请车牌号'
            },
            {
                field: 'applyDate',
                title: '申请日期'
            },
            {
                field: 'applicant',
                title: '申请人'
            },
            {
                field: 'applicantIDNum',
                title: '申请人身份证号'
            },
            {
                field: 'applicationUnit',
                title: '申请单位'
            },
            {
                field: 'applyReason',
                title: '申请原因'
            },
            {
                field: 'contractAmount',
                title: '合同金额(元)'
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