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
                                <select class="form-filter form-control _search" name="carType" id="carType">
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
                                <label for="grade" class="control-label">事故等级</label>
                                <select class="form-filter form-control _search" name="search_like_grade" id="grade">
                                    <option value="">请选择</option>
                                    <#list accidentGradeList as a>
                                        <option value="${a.jkey}">${a.jvalue}</option>
                                    </#list>
                                </select>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                <label for="processingState" class="control-label">处理状态</label>
                                <select class="form-filter form-control _search" name="search_like_processing_state">
                                    <option value="">请选择</option>
                                    <#list processingStateList as p>
                                        <option value="${p.jkey}">${p.jvalue}</option>
                                    </#list>
                                </select>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                                <label for="date" class="control-label">事故日期从</label>
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
    var useProperty = {}, accidentNature = {}, responsibility = {},
            accidentGrade = {}, processingState = {}, accidentHandling = {},
            carType = {};
    <#list usePropertyList as u>
        useProperty["${u.jkey}"] = "${u.jvalue}";
    </#list>
    <#list accidentNatureList as a>
        accidentNature["${a.jkey}"] = "${a.jvalue}"
    </#list>
    <#list responsibilityList as r>
        responsibility["${r.jkey}"] = "${r.jvalue}"
    </#list>
    <#list accidentGradeList as a>
        accidentGrade["${a.jkey}"] = "${a.jvalue}"
    </#list>
    <#list processingStateList as p>
        processingState["${p.jkey}"] = "${p.jvalue}"
    </#list>
    <#list accidentHandlingProgressList as a>
        accidentHandling["${a.jkey}"] = "${a.jvalue}"
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
                field: 'date',
                title: '事故日期',
                width: 170
            },
            {
                field: 'driver',
                title: '驾驶员'
            },
            {
                field: 'place',
                title: '事故地址',
                width: 240
            },
            {
                field: 'detail',
                title: '事故详情'
            },
            {
                field: 'usePropertyId',
                title: '使用性质',
                formatter: function (value, row, index) {
                    return useProperty[value];
                }
            },
            {
                field: 'nature',
                title: '事故性质',
                formatter: function(value, row, index) {
                    return accidentNature[value];
                }
            },
            {
                field: 'responsibility',
                title: '责任划分',
                formatter: function(value, row, index) {
                    return responsibility[value];
                }
            },
            {
                field: 'minorWound',
                title: '轻伤（人）'
            },
            {
                field: 'seriousInjury',
                title: '重伤（人）'
            },
            {
                field: 'death',
                title: '死亡（人）'
            },
            {
                field: 'ourLosses',
                title: '我方经济损失'
            },
            {
                field: 'ourExpenses',
                title: '我方医疗费用'
            },
            {
                field: 'threeLosses',
                title: '三者经济损失'
            },
            {
                field: 'threeExpenses',
                title: '三者医疗费用'
            },
            {
                field: 'amountPaid',
                title: '已赔付金额'
            },
            {
                field: 'grade',
                title: '事故等级',
                formatter: function(value, row, index) {
                    return accidentGrade[value];
                }
            },
            {
                field: 'processingState',
                title: '处理状态',
                formatter: function(value, row, index) {
                    return processingState[value];
                }
            },
            {
                field: 'handlingProgress',
                title: '事故处理进度',
                formatter: function(value, row, index) {
                    return accidentHandling[value];
                }
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