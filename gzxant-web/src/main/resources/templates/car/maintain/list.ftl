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
                                <label for="carLnumber" class="control-label">车牌号</label>
                                <input type="text" class="form-filter form-control _search" id="carLnumber"
                                       name="search_like_car_lnumber"/>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                <label for="carType" class="control-label">车辆型号</label>
                                <select name="search_like_car_type" id="carType" class="form-filter form-control _search">
                                    <option value="">请选择</option>
                                    <#list carTypeDict as type>
                                    <option value="${type.jkey}">
                                        ${type.jvalue}
                                    </option>
                                    </#list>
                                </select>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                <label for="belongstoId" class="control-label">车辆所属</label>
                                <select name="search_like_belongsto_id" id="belongstoId" class="form-filter form-control _search">
                                    <option value="">请选择</option>
                                    <#list companyList as company>
                                    <option value="${company.id}">
                                        ${company.name}
                                    </option>
                                    </#list>
                                </select>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                <label for="maintainNo" class="control-label">保养单号</label>
                                <input type="text" class="form-filter form-control _search" id="maintainNo"
                                       name="search_like_maintain_no"/>
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
    var company = {}, car_type = {}, level = {};
    <#list companyList as company>
    company["${company.id}"] = "${company.name}";
    </#list>

    <#list carTypeDict as dict>
    car_type["${dict.jkey}"] = "${dict.jvalue}";
    </#list>

    <#list levelDict as dict>
    level["${dict.jkey}"] = "${dict.jvalue}";
    </#list>

	function getColumns() {
	    var c = [
            {
	            checkbox: true
	        },
            {
                field: 'maintainNo',
                title: '保养单号'
            },
            {
                field: 'carLnumber',
                title: '车牌号'
            },
            {
                field: 'carType',
                title: '车辆型号',
	            formatter: function (value, row, index) {
	                return car_type[value];
				}
            },
            {
                field: 'belongstoId',
                title: '车辆所属',
	            formatter: function (value, row, index) {
	                return company[value];
				}
            },
            {
                field: 'maintainLevel',
                title: '保养级别',
	            formatter: function (value, row, index) {
	                return level[value];
				}
            },
            {
                field: 'maintainStore',
                title: '保养门店'
            },
            {
                field: 'maintainCost',
                title: '保养费用'
            },
            {
                field: 'maintainDate',
                title: '保养日期'
            },
            {
                field: 'maintainMileage',
                title: '保养里程'
            },
            {
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