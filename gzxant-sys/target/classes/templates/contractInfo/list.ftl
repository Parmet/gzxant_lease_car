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
                                        <label for="nameInput" class="control-label">合同编号：</label>
                                        <input type="text" class="form-filter form-control _search" id="nameInput" name="search_like_contract_no"  />
                                    </div>
                                    <!--<div class="col-lg-3 col-md-4 col-sm-12 col-xs-12 form-group">
                                        <label for="nameInput" class="control-label">甲方：</label>
                                        <select class="form-filter form-control _search" id="nameInput" name="search_eq_assets_state">
		                                    <option value = "">请选择</option>
		                                    <option value = "在库"></option>
		                                    <option value = "已租">已租</option>
		                                    <option value = "维修">维修</option>
                                        </select>                                       
                                    </div>-->
                                    
                                    <div class="col-lg-3 col-md-4 col-sm-12 col-xs-12 form-group">
                                        <label for="nameInput" class="control-label">合同状态：</label>
                                        <select class="form-filter form-control _search" id="nameInput" name="search_eq_contract_status">
		                                    <option value = "">请选择</option>
		                                    <option value = "已完成">已完成</option>
		                                    <option value = "未执行">未执行</option>
		                                    <option value = "执行中">执行中</option>
		                                    <option value = "已终止">已终止</option>
		                                    <option value = "挂起">挂起</option>
                                        </select>                                       
                                    </div>
                                    
                                    <!--<div class="col-lg-3 col-md-4 col-sm-12 col-xs-12 form-group">
                                        <label for="nameInput" class="control-label">租赁开始时间从：</label>
										<input type="date" class="form-filter form-control _search" id="nameInput" name="search_like_lease_beginDate"  />                                      
                                    </div>
                                    
                                    <div class="col-lg-3 col-md-4 col-sm-12 col-xs-12 form-group">
                                        <label for="nameInput" class="control-label">租赁开始时间至：</label>
                                        <input type="date" class="form-filter form-control _search" id="nameInput" name="search_like_lease_beginDate"  />                                      
                                    </div>
                                    <div class="col-lg-3 col-md-4 col-sm-12 col-xs-12 form-group">
                                        <label for="nameInput" class="control-label">租赁结束时间从：</label>
										<input type="date" class="form-filter form-control _search" id="nameInput" name="search_like_lease_endDate"  />                                      
                                    </div>
                                    <div class="col-lg-3 col-md-4 col-sm-12 col-xs-12 form-group">
                                        <label for="nameInput" class="control-label">租赁结束时间至：</label>
                                        <input type="date" class="form-filter form-control _search" id="nameInput" name="search_like_lease_endDate"  />                                      
                                    </div>-->
                                    
                                    <div class="col-lg-3 col-md-4 col-sm-12 col-xs-12 form-group">
                                        <label for="nameInput" class="control-label">车牌号：</label>
                                        <input type="text" class="form-filter form-control _search" id="nameInput" name="search_like_car_number"  />                                      
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
                field: 'id', // 列字段名
                title: '序号' // 列标题
            },
            {
                field: 'contractNo',
                title: '合同编号'
            },
            {
                field: 'companyName',
                title: '甲方'
            },
            {
                field: 'customerNameB',
                title: '乙方'
            },
            {
                field: 'customerNameC',
                title: '丙方'
            },
            {
                field: 'carNumber',
                title: '车牌号'
            },
            {
                field: 'leaseBeginDate',
                title: '租赁开始时间'
            },
            {
                field: 'leaseEndDate',
                title: '租赁结束时间'
            },
            {
                field: 'contractAmount',
                title: '合同金额(元)'
            },
            {
                field: 'contractStatus',
                title: '合同状态'
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