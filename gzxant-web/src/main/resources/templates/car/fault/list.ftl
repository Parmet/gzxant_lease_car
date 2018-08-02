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
                                <label for="carType" class="control-label">车辆型号</label>
                                <select class="form-filter form-control _search" name="carType" id="carType">
                                    <option value="">请选择</option>
                                    <#list carTypeList as c>
                                        <option value="${c.jkey}">${c.jvalue}</option>
                                    </#list>
                                </select>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                <label for="time" class="control-label">故障时间</label>
                                <input type="date" class="form-filter form-control _search" id="time"
                                       name="search_like_time"/>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                <label for="registerDate" class="control-label">登记时间</label>
                                <input type="date" class="form-filter form-control _search" id="registerDate"
                                       name="search_like_register_date"/>
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
    var carType = {}, company = {};
    <#list carTypeList as c>
        carType["${c.jkey}"] = "${c.jvalue}";
    </#list>
    <#list companyList as b>
        company["${b.id}"] = "${b.name}";
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
                field: 'time',
                title: '故障时间'
            },
            {
                field: 'place',
                title: '故障地点'
            },
            {
                field: 'personLiable',
                title: '故障责任人'
            },
            {
                field: 'etails',
                title: '故障详情'
            },
            {
                field: 'mileageTimeFailure',
                title: '故障时里程（km）'
            },
            {
                field: 'registrant',
                title: '登记人'
            },
            {
                field: 'registerDate',
                title: '登记时间'
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