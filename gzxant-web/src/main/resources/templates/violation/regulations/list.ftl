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
            width: 3800px;
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
                                <label for="assetCompany" class="control-label">资产公司</label>
                                <select class="form-filter form-control _search" name="search_like_asset_company">
                                    <option value="">请选择</option>
                                    <#list companyList as c>
                                        <option value="${c.id}">${c.name}</option>
                                    </#list>
                                </select>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                <label for="businessCompany" class="control-label">经营公司</label>
                                <select class="form-filter form-control _search" name="search_like_business_company">
                                    <option value="">请选择</option>
                                    <#list companyList as c>
                                        <option value="${c.id}">${c.name}</option>
                                    </#list>
                                </select>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                <label for="customer" class="control-label">客户名称</label>
                                <input type="text" class="form-filter form-control _search" id="customer"
                                       name="search_like_customer"/>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                <label for="carNumber" class="control-label">车牌号</label>
                                <input type="text" class="form-filter form-control _search" id="carNumber"
                                       name="search_like_car_number"/>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                <label for="violationDate" class="control-label">违章时间</label>
                                <input type="date" class="form-filter form-control _search" id="violationDate"
                                       name="search_like_violation_date"/>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                <label for="finishDate" class="control-label">处理时间</label>
                                <input type="date" class="form-filter form-control _search" id="finishDate"
                                       name="search_like_finish_date"/>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                <label for="status" class="control-label">状态</label>
                                <select class="form-filter form-control _search" name="search_like_status">
                                    <option value="">请选择</option>
                                    <#list statusList as s>
                                        <option value="${s.jkey}">${s.jvalue}</option>
                                    </#list>
                                </select>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                <label for="belongstoId" class="control-label">所在库</label>
                                <select class="form-filter form-control _search" name="search_like_belongsto_id">
                                    <option value="">请选择</option>
                                    <#list companyList as c>
                                        <option value="${c.id}">${c.name}</option>
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
    var assetCompany = {}, businessCompany = {}, theStatus = {}, is = {}, carType = {};

    <#list statusList as s>
        theStatus["${s.jkey}"]="${s.jvalue}";
    </#list>
    <#list companyList as s>
        assetCompany["${s.id}"]="${s.name}"
        businessCompany["${s.id}"]="${s.name}"
    </#list>
    <#list isList as is>
        is["${is.jkey}"]="${is.jvalue}";
    </#list>
    <#list carTypeList as c>
        carType["${c.jkey}"] = "${c.jvalue}";
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
                title: '车辆类型',
                formatter: function(value, row, index) {
                    return carType[value];
                }
            },
            {
                field: 'deduction',
                title: '扣分'
            },
            {
                field: 'fine',
                title: '罚款'
            },
            {
                field: 'assetCompany',
                title: '资产公司',
                formatter: function (value, row, index) {
                    return assetCompany[value];
                }
            },
            {
                field: 'businessCompany',
                title: '经营公司',
                formatter: function (value, row, index) {
                    return businessCompany[value];
                }
            },
            {
                field: 'customer',
                title: '客户'
            },
            {
                field: 'violationDate',
                title: '违章时间'
            },
            {
                field: 'violationPlace',
                title: '违章地点'
            },
            {
                field: 'violationReason',
                title: '违章原因'
            },
            {
                field: 'collectionOffice',
                title: '违章采集机关'
            },
            {
                field: 'isRepresentative',
                title: '是否可以代表',
                formatter: function (value, row, index) {
                    return is[value];
                }
            },
            {
                field: 'violationCode',
                title: '违章代码'
            },
            {
                field: 'bookNumber',
                title: '违章项文书编号'
            },
            {
                field: 'status',
                title: '状态',
                formatter: function (value, row, index) {
                    return theStatus[value];
                }
            },
            {
                field: 'dataQueryDate',
                title: '数据查询时间'
            },
            {
                field: 'finishDate',
                title: '更新为已处理时间'
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