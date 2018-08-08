<link rel="stylesheet" type="text/css" href="${rc.contextPath}/css/plugins/jsTree/style.min.css"/>
<style>
        #dict_edit_table .control-label {
            text-align: left !important;
        }

        #dict_edit_table input ,#dict_edit_table select{
            margin-left: -45px;
        }
        #dict_edit_table .row{
          margin-top: 15px!important;
        }


</style>
<div class="wrapper wrapper-content animated fadeInRight">
    <!--数据列表-->
    <div class="row" style="margin-right: 0!important;">
        <div class="col-sm-12">
            <div class="ibox">
                <div class="ibox-body">
                    <div id="gzxantToolbar" role="group">
                        <div class="row">
                            <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                <label for="carType" class="control-label">车辆类型</label>
                                <input type="text" class="form-filter form-control _search" id="carType"
                                       name="search_like_car_type"/>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                <label for="carNumber" class="control-label">车牌号</label>
                                <input type="text" class="form-filter form-control _search" id="carNumber"
                                       name="search_like_car_number"/>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                <label for="belongstoId" class="control-label">车辆所属</label>
                                <input type="text" class="form-filter form-control _search" id="belongstoId"
                                       name="search_like_belongsto_id"/>
                            </div>
                        </div>
                    </div>

                    <table class="table" id="gzxantTable" data-mobile-responsive="true">
                    </table>
                </div>
            </div>
        </div>
    </div>


</div>
<script src="${rc.contextPath}/js/plugins/iTable/iTable.js" type="text/javascript"></script>
<script type="text/javascript">
    var company = {}, car_type = {};
    <#list companyList as company>
    company["${company.id}"] = "${company.name}";
    </#list>

    <#list carTypeDict as dict>
    car_type["${dict.jkey}"] = "${dict.jvalue}";
    </#list>

	function getColumns() {
	    var c = [
	        {
	            checkbox: true
	        },{
                field: 'carType',
                title: '车辆类型',
	            formatter: function (value, row, index) {
	                return car_type[value];
				}
            },{
                field: 'carNumber',
                title: '车牌号'
            },{
                field: 'belongstoId',
                title: '车辆所属',
	            formatter: function (value, row, index) {
	                return company[value];
				}
            },{
                field: 'time',
                title: '故障时间'
            },{
                field: 'place',
                title: '故障地点'
            },{
                field: 'personLiable',
                title: '故障责任人'
            },{
                field: 'etails',
                title: '故障详情'
            },{
                field: 'registrant',
                title: '登记人'
            },{
                field: 'registerDate',
                title: '登记时间'
            },{
	            field: 'id',
	            title: '操作',
	            align: 'center',
	            width: '130px',
	            formatter: function (value, row, index) {
	                return dt_detail_button(row)+dt_edit_button(row)+dt_delete_button(row);
				}
	        }];

	    return c;
	}

	var standardTable = $("#gzxantTable").iTable({
		toolbar : {
			id : "gzxantToolbar",
			auto : true
		},
		data : {
			columns : getColumns()
		}
	});


</script>