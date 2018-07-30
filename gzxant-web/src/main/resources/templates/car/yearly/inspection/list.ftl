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
            width: 2800px;
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
                                <label for="carNumber" class="control-label">车牌号</label>
                                <input type="text" class="form-filter form-control _search" id="carNumber"
                                       name="search_like_car_number"/>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                <label for="dateHandling" class="control-label">办理日期</label>
                                <input type="date" class="form-filter form-control _search" id="dateHandling"
                                       name="search_like_date_handling"/>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                <label for="effectiveDate" class="control-label">年检有效期至</label>
                                <input type="date" class="form-filter form-control _search" id="effectiveDate"
                                       name="search_like_effective_date"/>
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
    var carType = {}, company = {}, result = {};
    <#list carTypeList as c>
        carType["${c.jkey}"] = "${c.jvalue}";
    </#list>
    <#list companyList as b>
        company["${b.id}"] = "${b.name}";
    </#list>
    <#list resultList as r>
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
                field: 'belongstoId',
                title: '车辆所属',
                formatter: function (value, row, index) {
                    return company[value];
                }
            },
            {
                field: 'carType',
                title: '车辆型号',
                formatter: function (value, row, index) {
                    return carType[value];
                }
            },
            {
                field: 'frameNumber',
                title: '车架号'
            },
            {
                field: 'dateHandling',
                title: '办理日期'
            },
            {
                field: 'effectiveDate',
                title: '年检有效期至'
            },
            {
                field: 'transactor',
                title: '年检办理人'
            },
            {
                field: 'unit',
                title: '年检单位'
            },
            {
                field: 'cost',
                title: '年检费用'
            },
            {
                field: 'result',
                title: '年检结果',
                formatter: function (value, row, index) {
                    return result[value];
                }
            },
            {
                field: 'record',
                title: '年检记录'
            },
            {
                field: 'remark',
                title: '备注'
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