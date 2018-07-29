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
                <div id="accidentToolbar" role="group">
                    <div class="row">
                        <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                            <label for="userUnit" class="control-label">所属组织：</label>
                            <select name="search_eq_user_unit" id="userUnit" class="form-filter form-control _search">
                                <option value="">请选择</option>
                                <#list companyList as company>
                                <option value="${company.id}">
                                    ${company.name}
                                </option>
                            </#list>
                            </select>
                        </div>
                        <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                            <label for="modelNum" class="control-label">车辆型号：</label>
                            <select name="search_eq_model_num" id="modelNum" class="form-filter form-control _search">
                                <option value="">请选择</option>
                                <#list carTypeDict as type>
                                <option value="${type.jkey}">
                                    ${type.jvalue}
                                </option>
                            </#list>
                            </select>
                        </div>
                        <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                            <label for="plateNum" class="control-label">车牌号：</label>
                            <input type="text" class="form-filter form-control _search" id="plateNum" name="search_like_plate_num" />
                        </div>
                        <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                            <label for="grade" class="control-label">事故等级：</label>
                            <select name="search_eq_grade" id="grade" class="form-filter form-control _search">
                                <option value="">请选择</option>
                                <#list levelDict as dict>
                                <option value="${dict.jkey}">
                                    ${dict.jvalue}
                                </option>
                            </#list>
                            </select>
                        </div>
                        <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                            <label for="status" class="control-label">处理状态：</label>
                            <select name="search_eq_status" id="status" class="form-filter form-control _search">
                                <option value="">请选择</option>
                                <#list statusDict as dict>
                                <option value="${dict.jkey}">
                                    ${dict.jvalue}
                                </option>
                            </#list>
                            </select>
                        </div>
                    </div>
                </div>

                <table class="table" id="accidentTable" data-mobile-responsive="true">
                </table>
            </div>
        </div>
    </div>
</div>

	
</div>
<script src="${rc.contextPath}/js/plugins/jsTree/jstree.min.js" type="text/javascript"></script>
<script src="${rc.contextPath}/js/plugins/iTable/iTable.js" type="text/javascript"></script>
<script type="text/javascript">
    var carType = {},
        operNature = {},
        useNature = {},
        responsibilityDivide = {},
        grade = {},
        status = {},
        schedule = {};
    <#list carTypeDict as dict>
    carType["${dict.jkey}"] = "${dict.jvalue}";
    </#list>
    <#list operNatureDict as dict>
    operNature["${dict.jkey}"] = "${dict.jvalue}";
    </#list>
    <#list useNatureDict as dict>
    useNature["${dict.jkey}"] = "${dict.jvalue}";
    </#list>
    <#list responsibilityDivideDict as dict>
    responsibilityDivide["${dict.jkey}"] = "${dict.jvalue}";
    </#list>
    <#list levelDict as dict>
    grade["${dict.jkey}"] = "${dict.jvalue}";
    </#list>
    <#list statusDict as dict>
    status["${dict.jkey}"] = "${dict.jvalue}";
    </#list>
    <#list scheduleDict as dict>
    schedule["${dict.jkey}"] = "${dict.jvalue}";
    </#list>

	function getColumns() {
	    var c = [
	        {
	            checkbox: true
	        },
	        {
	            field: 'plateNum',
	            title: '车牌号'
	        },
	        {
	            field: 'modelNum',
	            title: '车型',
	            formatter: function (value, row, index) {
	                return carType[value];
				}
	        },
	        {
	            field: 'accidentTime',
	            title: '事故日期'
	        },
	        {
	            field: 'driver',
	            title: '驾驶员'
	        },
	        {
	            field: 'accidentPlace',
	            title: '事故地点'
	        },
	        {
	            field: 'operNature',
	            title: '事故性质',
	            formatter: function (value, row, index) {
	                return operNature[value];
				}
	        },
	        {
	            field: 'useNature',
	            title: '使用性质',
	            formatter: function (value, row, index) {
	                return useNature[value];
				}
	        },
	        {
	            field: 'responsibilityDivide',
	            title: '责任划分',
	            formatter: function (value, row, index) {
	                return responsibilityDivide[value];
				}
	        },
	        {
	            field: 'grade',
	            title: '事故等级',
	            formatter: function (value, row, index) {
	                return grade[value];
				}
	        },
	        {
	            field: 'status',
	            title: '处理状态',
	            formatter: function (value, row, index) {
	                return status[value];
				}
	        },
	        {
	            field: 'schedule',
	            title: '事故处理进度',
	            formatter: function (value, row, index) {
	                return schedule[value];
				}
	        },
	        {
	            field: 'id',
	            title: '操作',
	            align: 'center',
	            formatter: function (value, row, index) {
	                return dt_detail_button(row)+dt_edit_button(row)+dt_delete_button(row);
				}
	        }];
	
	    return c;
	}
	
	var standardTable = $("#accidentTable").iTable({
		toolbar : {
			id : "accidentToolbar",
			auto : true
		},
		data : {
			columns : getColumns()
		},
		url : {
		    load_data: "/oper/accident/"
		}
	});
    
</script>

