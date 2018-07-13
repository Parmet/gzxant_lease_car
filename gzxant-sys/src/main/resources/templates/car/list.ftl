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
                                        <label for="nameInput" class="control-label">所属城市：</label>
                                        <select class="form-filter form-control _search" id="nameInput" name="search_like_belong_city">
		                                    <option value = "">请选择</option>
                                        	<#list cityName as name>
		                                        <option value="${name}">${name}</option>
		                                    </#list>
                                        </select>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
                                        <label for="nameInput" class="control-label">服务城市：</label>
                                        <select class=" form-control _search" id="nameInput" name="search_like_service_city">
		                                    <option value = "">请选择</option>
                                        	<#list cityName as name>
		                                        <option value="${name}">${name}</option>
		                                    </#list>
                                        </select>
                                    </div>
                                   <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
                                        <label for="nameInput" class="control-label">车系名称：</label>
                                        <select class="form-filter form-control _search" id="nameInput" name="search_like_car_train_name">
		                                    <option value = "">请选择</option>
                                        	<#list trainName as name>
		                                        <option value="${name}">${name}</option>
		                                    </#list>
                                        </select>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
                                        <label for="nameInput" class="control-label">车牌号：</label>
                                        <input type="text" class="form-filter form-control _search" id="nameInput" name="search_like_car_number"  />
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
                                        <label for="nameInput" class="control-label">车辆状态：</label>
                                        <select class="form-filter form-control _search" id="nameInput" name="search_eq">
                                        	<option>全部</option>
                                        	<option>可用</option>
                                        	<option>已租</option>
                                        	<option>任务中</option>
                                        	<option>可用(待分配)</option>
                                        	<option>维修中</option>
                                        	<option>已禁用</option>
                                        </select>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
                                        <label for="nameInput" class="control-label">限号：</label>
                                        <select class="form-filter form-control _search" id="nameInput" name="search_eq">
                                        	<option value="">全部</option>
                                        	<option value="有">有</option>
                                        	<option value="无">无</option>
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

	<!--$("select[name=serviceCity] option[value='${car.serviceCity}']").attr("selected", "selected");-->
	
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
                field: 'serviceCity',
                title: '服务城市'
            },
            {
                field: 'carNumber',
                title: '车牌号码 '
            },
            {
                field: 'carPark',
                title: '车场'
            },
            {
                field: 'onlineStore',
                title: '网点'
            },
            {
                field: 'carColor',
                title: '车辆颜色'
            },
            {
                field: 'carName',
                title: '车辆全名'
            },
            {
                field: 'belongCity',
                title: '所属城市'
            },
            {
                field: 'mileage',
                title: '续航里程'
            },
            {
                field: 'motorNumber',
                title: '发动机号'
            },
            {
                field: 'insuranceDate',
                title: '保险到期时间'
            },
            {
                field: 'annualSurveyDate',
                title: '年检时间'
            },
            {
                field: 'vin',
                title: '车架号'
            },
            {
                field: 'carAge',
                title: '车龄'
            },
            {
                field: 'sn',
                title: 'SN'
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