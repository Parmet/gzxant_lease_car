<link rel="stylesheet" type="text/css" href="${rc.contextPath}/css/plugins/jsTree/style.min.css"/>
    <style>
        #dict_edit_table .control-label {
            text-align: left !important;
        }

        #dict_edit_table input, #dict_edit_table select {
            margin-left: -45px;
        }

        #dict_edit_table .row {
            margin-top: 15px !important;
        }

        .bootstrap-table .table {
            width: 2000px;
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
                                <label for="belongstoId" class="control-label">所属组织</label>
                                <select type="text" class="form-filter form-control _search" name="search_like_belongsto_id" id="belongstoId">
                                    <option value="">请选择</option>
                                    <#list companyList as c>
                                        <option value="${c.id}">${c.name}</option>
                                    </#list>
                                </select>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                <label for="carType" class="control-label">车辆型号</label>
                                <select type="text" class="form-filter form-control _search" name="search_like_car_type" id="carType">
                                    <option value="">请选择</option>
                                    <#list carTypeList as c>
                                        <option value="${c.jkey}">${c.jvalue}</option>
                                    </#list>
                                </select>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                <label for="carNumber" class="control-label">车牌号</label>
                                <input type="text" class="form-filter form-control _search" id="carNumber"
                                       name="search_like_car_number"/>
                            </div>

                            <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                <label for="type" class="control-label">维修类型</label>
                                <select class="form-filter form-control _search" id="type" name="search_like_type">
                                    <option value="">请选择</option>
                                    <#list repairTypeList as r>
                                        <option value="${r.jkey}">${r.jvalue}</option>
                                    </#list>
                                </select>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                <label for="result" class="control-label">维修结果</label>
                                <select class="form-filter form-control _search" id="result" name="search_like_result">
                                    <option value="">请选择</option>
                                    <#list repairResultList as r>
                                        <option value="${r.jkey}">${r.jvalue}</option>
                                    </#list>
                                </select>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                <label for="totalCost" class="control-label">总费用（元）</label>
                                <input type="text" class="form-filter form-control _search" id="totalCost"
                                       name="search_like_total_cost"/>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                <label for="date" class="control-label">维修日期</label>
                                <input type="date" class="form-filter form-control _search" id="date"
                                       name="search_like_date"/>
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
    var carType = {}, company = {}, type = {}, result = {};
    <#list carTypeList as c>
        carType["${c.jkey}"] = "${c.jvalue}";
    </#list>
    <#list companyList as c>
        company["${c.id}"] = "${c.name}";
    </#list>
    <#list repairTypeList as r>
        type["${r.jkey}"] = "${r.jvalue}";
    </#list>
    <#list repairResultList as r>
        result["${r.jkey}"] = "${r.jvalue}";
    </#list>
    function getColumns() {
        var c = [
            {
                checkbox: true
            },
            {
                field: 'carNumber',
                title: '车牌号'
            },
            {
                field: 'carType',
                title: '车辆型号',
                formatter: function(value, row, index) {
                    return carType[value];
                }
            },
            {
                field: 'belongstoId',
                title: '车辆所属',
                formatter: function(value, row, index) {
                    return company[value];
                }
            },
            {
                field: 'frameNumber',
                title: '车架号'
            },
            {
                field: 'date',
                title: '维修日期'
            },
            {
                field: 'type',
                title: '维修类型',
                formatter: function(value, row, index) {
                    return type[value];
                }
            },
            {
                field: 'result',
                title: '维修结果',
                formatter: function(value, row, index) {
                    return result[value];
                }
            },
            {
                field: 'mileage',
                title: '维修时里程（km）'
            },
            {
                field: 'totalCost',
                title: '总费用（元）'
            },
            {
                field: 'accessoriesFee',
                title: '维修配件费（元）'
            },
            {
                field: 'timeFee',
                title: '维修工时费（元）'
            },
            {
                field: 'repairman',
                title: '维修人'
            },
            {
                field: 'remark',
                title: '备注',
                width: '170px'
            },
            {
                field: 'id',
                title: '操作',
                align: 'center',
                width: '130px',
                formatter: function (value, row, index) {
                    return dt_detail_button(row) + dt_edit_button(row) + dt_delete_button(row);
                }
            }];

        return c;
    }

    var standardTable = $("#gzxantTable").iTable({
        toolbar: {
            id: "gzxantToolbar",
            auto: true
        },
        data: {
            columns: getColumns()
        }
    });

</script>