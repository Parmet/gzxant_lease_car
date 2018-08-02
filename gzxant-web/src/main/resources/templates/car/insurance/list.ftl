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
                                <label for="carNumber" class="control-label">车牌号</label>
                                <input type="text" class="form-filter form-control _search" id="carNumber"
                                       name="search_like_car_number"/>
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
                                <label for="insuranceNo" class="control-label">保单编号</label>
                                <input type="text" class="form-filter form-control _search" id="insuranceNo"
                                       name="search_like_insurance_no"/>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                <label for="status" class="control-label">保险状态</label>
                                <select name="search_eq_status" id="status" class="form-filter form-control _search">
                                    <option value="">请选择</option>
                                    <#list insuranceStatusDict as dict>
                                    <option value="${dict.jkey}">
                                        ${dict.jvalue}
                                    </option>
                                    </#list>
                                </select>
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
    var companyList = {},
        carTypeDict = {},
        insuranceTypeDict = {},
        insuranceCompanyDict = {},
        insuranceStatusDict = {};
    <#list companyList as company>
    companyList["${company.id}"] = "${company.name}";
    </#list>
    <#list carTypeDict as dict>
    carTypeDict["${dict.jkey}"] = "${dict.jvalue}";
    </#list>
    <#list insuranceTypeDict as dict>
    insuranceTypeDict["${dict.jkey}"] = "${dict.jvalue}";
    </#list>
    <#list insuranceCompanyDict as dict>
    insuranceCompanyDict["${dict.jkey}"] = "${dict.jvalue}";
    </#list>
    <#list insuranceStatusDict as dict>
    insuranceStatusDict["${dict.jkey}"] = "${dict.jvalue}";
    </#list>


	function getColumns() {
	    var c = [
	        {
	            checkbox: true
	        },{
                field: 'carNumber',
                title: '车牌号'
            },{
                field: 'carType',
                title: '车辆型号',
	            formatter: function (value, row, index) {
	                return carTypeDict[value];
				}
            },{
                field: 'belongstoId',
                title: '车辆所属',
	            formatter: function (value, row, index) {
	                return companyList[value];
	            }
            },{
                field: 'organizationId',
                title: '购买组织',
	            formatter: function (value, row, index) {
	                return companyList[value];
	            }
            },{
                field: 'insuranceNo',
                title: '保单编号'
            },{
                field: 'noType',
                title: '保单类型',
	            formatter: function (value, row, index) {
	                return insuranceTypeDict[value];
	            }
            },{
                field: 'fixedYears',
                title: '车辆年限'
            },{
                field: 'companyId',
                title: '保险公司',
	            formatter: function (value, row, index) {
	                return insuranceCompanyDict[value];
	            }
            },{
                field: 'startDate',
                title: '起效日期'
            },{
                field: 'expirationDate',
                title: '失效日期'
            },{
                field: 'status',
                title: '保险状态',
	            formatter: function (value, row, index) {
	                return insuranceStatusDict[value];
	            }
            },{
                field: 'costTotal',
                title: '总保费'
            },{
                field: 'claimTelephone',
                title: '理赔电话'
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