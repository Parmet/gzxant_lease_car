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
                                        <label for="nameInput" class="control-label">车牌号：</label>
                                        <input type="text" class="form-filter form-control _search" id="nameInput" name="search_like_car_number"  />
                                    </div>
                                    
                                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
                                        <label for="nameInput" class="control-label">车辆类型：</label>
                                        <select class=" form-control _search" id="nameInput" name="search_like_vehicle_type">
		                                    <option value = "">请选择</option>
                                        	<#list carList as car>
		                                        <option value="${car.vehicleType}">${car.vehicleType}</option>
		                                    </#list>
                                        </select>
                                    </div>
                                   <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
                                        <label for="nameInput" class="control-label">资产状态：</label>
                                        <select class="form-filter form-control _search" id="nameInput" name="search_eq_assets_state">
		                                    <option value = "">请选择</option>
		                                    <option value = "在库">在库</option>
		                                    <option value = "已租">已租</option>
		                                    <option value = "维修">维修</option>
                                        </select>
                                    </div>

                                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
                                        <label for="nameInput" class="control-label">使用组织：</label>
                                        <select class="form-filter form-control _search" id="nameInput" name="search_eq_used_organization">
                                        	<option value = "">请选择</option>
                                        	<#list carAreaList as carArea>
		                                        <option value="${carArea.belongOrganization}">${carArea.belongOrganization}</option>
		                                    </#list>
                                        </select>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
                                        <label for="nameInput" class="control-label">所在车区：</label>
                                        <select class="form-filter form-control _search" id="nameInput" name="search_eq_where_car_area">
                                            <option value = "">请选择</option>
                                        	<#list carAreaList as carArea>
		                                        <option value="${carArea.carAreaName}">${carArea.carAreaName}</option>
		                                    </#list>
                                        </select>
                                        
                                    </div>
                                    
                                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
                                        <label for="nameInput" class="control-label">购买日期：</label>
										<input type="date" class="form-filter form-control _search" id="nameInput" name="search_like_buy_date"  />
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
                                <!--<button type="button" class="btn btn-info" onclick="export_data()">
                                    <i class="fa fa-file-excel-o" aria-hidden="true"></i> 导出数据
                                </button>-->
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

	//导出数据到excel
	function export_data(columns, sorts) {
	    var searchParams = {};
	    $("#exampleToolbar ._search").each(function () {
	        searchParams[$(this).attr('name')] = $(this).val();
	    });
	
	    var  d={
	        "pageNumber": 1,
	        "pageSize": 99999,
	        "searchParams": searchParams,
	        "sorts": sorts
	
	    }
	  //  JSON.stringify(GetJsonData())
	    $.ajax({
	        type: "GET",  //提交方式
	        url: url + "leadingOut", // 服务器数据的加载地址
	        dataType: "json",
	        contentType: "application/json; charset=utf-8",//(可以)
	        //data:JSON.stringify(d) ,//数据，这里使用的是Json格式进行传输
	        success: function (result) {//返回数据根据结果进行相应的处理
	        	alert("导出成功");
	        }
	    });
	}



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
                field: 'assetsState',
                title: '资产状态 '
            },
           {
                field: 'eMNumber',
                title: '机电编号'
            },
            {
                field: 'carNumber',
                title: '车牌号'
            },
            {
                field: 'assetsBelong',
                title: '资产所属'
            },
          	{
                field: 'color',
                title: '颜色'
            },
            {
                field: 'frameNumber',
                title: '车架号'
            },
            {
                field: 'vehicleType',
                title: '车辆型号'
            },
            {
                field: 'registrationNumber',
                title: '登记证号'
            },
            {
                field: 'remark',
                title: '备注'
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