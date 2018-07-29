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
                            <input type="text" class="form-filter form-control _search" id="carNumber" name="search_like_car_number"  />
                        </div>
                                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                            <label for="belongstoId" class="control-label">车辆所属 引用</label>
                            <input type="text" class="form-filter form-control _search" id="belongstoId" name="search_like_belongsto_id"  />
                        </div>
                                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                            <label for="date" class="control-label">事故日期</label>
                            <input type="text" class="form-filter form-control _search" id="date" name="search_like_date"  />
                        </div>
                                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                            <label for="driver" class="control-label">驾驶员</label>
                            <input type="text" class="form-filter form-control _search" id="driver" name="search_like_driver"  />
                        </div>
                                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                            <label for="place" class="control-label">事故地址</label>
                            <input type="text" class="form-filter form-control _search" id="place" name="search_like_place"  />
                        </div>
                                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                            <label for="detail" class="control-label">事故详情</label>
                            <input type="text" class="form-filter form-control _search" id="detail" name="search_like_detail"  />
                        </div>
                                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                            <label for="usePropertyId" class="control-label">使用性质 引用</label>
                            <input type="text" class="form-filter form-control _search" id="usePropertyId" name="search_like_use_property_id"  />
                        </div>
                                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                            <label for="nature" class="control-label">事故性质 字典 单方事故、双方事故、多方事故</label>
                            <input type="text" class="form-filter form-control _search" id="nature" name="search_like_nature"  />
                        </div>
                                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                            <label for="responsibility" class="control-label">责任划分 字典 全责、无责、次责、不详、同等、主责</label>
                            <input type="text" class="form-filter form-control _search" id="responsibility" name="search_like_responsibility"  />
                        </div>
                                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                            <label for="minorWound" class="control-label">轻伤（人）</label>
                            <input type="text" class="form-filter form-control _search" id="minorWound" name="search_like_minor_wound"  />
                        </div>
                                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                            <label for="seriousInjury" class="control-label">重伤（人）</label>
                            <input type="text" class="form-filter form-control _search" id="seriousInjury" name="search_like_serious_injury"  />
                        </div>
                                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                            <label for="death" class="control-label">死亡（人）</label>
                            <input type="text" class="form-filter form-control _search" id="death" name="search_like_death"  />
                        </div>
                                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                            <label for="ourLosses" class="control-label">我方经济损失</label>
                            <input type="text" class="form-filter form-control _search" id="ourLosses" name="search_like_our_losses"  />
                        </div>
                                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                            <label for="ourExpenses" class="control-label">我方医疗费用</label>
                            <input type="text" class="form-filter form-control _search" id="ourExpenses" name="search_like_our_expenses"  />
                        </div>
                                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                            <label for="threeLosses" class="control-label">三者经济损失</label>
                            <input type="text" class="form-filter form-control _search" id="threeLosses" name="search_like_three_losses"  />
                        </div>
                                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                            <label for="threeExpenses" class="control-label">三者医疗费用</label>
                            <input type="text" class="form-filter form-control _search" id="threeExpenses" name="search_like_three_expenses"  />
                        </div>
                                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                            <label for="amountPaid" class="control-label">已赔付金额</label>
                            <input type="text" class="form-filter form-control _search" id="amountPaid" name="search_like_amount_paid"  />
                        </div>
                                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                            <label for="grade" class="control-label">事故等级 字典 轻微事故、一般事故、重大事故、特大事故</label>
                            <input type="text" class="form-filter form-control _search" id="grade" name="search_like_grade"  />
                        </div>
                                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                            <label for="processingState" class="control-label">处理状态 字典 未处理 处理中 已处理</label>
                            <input type="text" class="form-filter form-control _search" id="processingState" name="search_like_processing_state"  />
                        </div>
                                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                            <label for="handlingProgress" class="control-label">事故处理进度 Y：已结案 N：待定损</label>
                            <input type="text" class="form-filter form-control _search" id="handlingProgress" name="search_like_handling_progress"  />
                        </div>
                                                <div class="col-lg-3 col-md-6 col-sm-12 col-xs-12 form-group">
                            <label for="updateId" class="control-label">修改者id</label>
                            <input type="text" class="form-filter form-control _search" id="updateId" name="search_like_update_id"  />
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
                title: '车辆所属 引用'
            },
            	        {
                field: 'date',
                title: '事故日期'
            },
            	        {
                field: 'driver',
                title: '驾驶员'
            },
            	        {
                field: 'place',
                title: '事故地址'
            },
            	        {
                field: 'detail',
                title: '事故详情'
            },
            	        {
                field: 'usePropertyId',
                title: '使用性质 引用'
            },
            	        {
                field: 'nature',
                title: '事故性质 字典 单方事故、双方事故、多方事故'
            },
            	        {
                field: 'responsibility',
                title: '责任划分 字典 全责、无责、次责、不详、同等、主责'
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
                title: '事故等级 字典 轻微事故、一般事故、重大事故、特大事故'
            },
            	        {
                field: 'processingState',
                title: '处理状态 字典 未处理 处理中 已处理'
            },
            	        {
                field: 'handlingProgress',
                title: '事故处理进度 Y：已结案 N：待定损'
            },
            	        {
                field: 'updateId',
                title: '修改者id'
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