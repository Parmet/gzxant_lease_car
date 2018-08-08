<div class="wrapper wrapper-content animated fadeInRight">
    <form class="form-horizontal form-bordered" id="gzxantForm">
        <input id="id" name="id" type="hidden" value="${entity.id}" />
        <div class="form-group">
            <label class="col-sm-3 control-label">保养单号：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="maintainNo" id="maintainNo"
                       value="${entity.maintainNo}" placeholder="请输入保养单号"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">车牌号：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="carLnumber" id="carLnumber"
                       value="${entity.carLnumber}" placeholder="请输入车牌号"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">车辆型号：</label>
            <div class="col-sm-8">
                <select name="carType" id="carType" class="form-control">
                    <option value="">请选择</option>
                    <#list carTypeDict as dict>
                    <option value="${dict.jkey}" <#if (dict.jkey == entity.carType)>selected="selected"</#if>>
                        ${dict.jvalue}
                    </option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">保养级别：</label>
            <div class="col-sm-8">
                <select class="form-control" name="maintainLevel" id="maintainLevel" >
                    <option value="">请选择</option>
                    <#list levelDict as dict>
                    <option value="${dict.jkey}" <#if (dict.jkey == entity.maintainLevel)>selected="selected"</#if>>
                        ${dict.jvalue}
                    </option>
                </#list>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">保养门店：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="maintainStore" id="maintainStore"
                       value="${entity.maintainStore}" placeholder="请输入保养门店"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">保养费用：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="maintainCost" id="maintainCost"
                       value="${entity.maintainCost}" placeholder="请输入保养费用"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">保养日期：</label>
            <div class="col-sm-8">
                <input type="date" class="form-control" name="maintainDate" id="maintainDate"
                       value="${entity.maintainDate}" placeholder="请输入保养日期"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">保养里程：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="maintainMileage" id="maintainMileage"
                       value="${entity.maintainMileage}" placeholder="请输入保养里程"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">经办人：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="agent" id="agent"
                       value="${entity.agent}" placeholder="请输入经办人"/>
            </div>
        </div>
        <div class="form-actions fluid">
            <div class="col-md-offset-3 col-md-9">
                <button type="submit" class="btn btn-success">保存</button>
            </div>
        </div>
    </form>
</div>

<script type="text/javascript">
	action = "${action}";

    function cusFunction() {
        console.info("提交之前，最后执行自定义的函数");
    }

	var info_validate = $('#gzxantForm');
    var error = $('.alert-danger', info_validate);
    info_validate.validate({
        errorElement: 'span',
        errorClass: 'error',
        focusInvalid: true,
        rules: {
                        carLnumber: {
                required: true
            },
                        carType: {
                required: true
            },
                        belongstoId: {
                required: true
            },
                        insuranceNo: {
                required: true
            },
                        maintainLevel: {
                required: true
            },
                        maintainStore: {
                required: true
            },
                        maintainCost: {
                required: true
            },
                        maintainDate: {
                required: true
            },
                        maintainMileage: {
                required: true
            },
                        agent: {
                required: true
            },
                        maintainNo: {
                required: true
            }
                    },
        messages: {
                        carLnumber: "请输入车牌号",
                        carType: "请输入车辆型号",
                        belongstoId: "请输入车辆所属",
                        insuranceNo: "请输入保单编号",
                        maintainLevel: "请输入保养级别",
                        maintainStore: "请输入保养门店",
                        maintainCost: "请输入保养费用",
                        maintainDate: "请输入保养日期",
                        maintainMileage: "请输入保养里程",
                        agent: "请输入经办人",
                        maintainNo: "请输入保养单号"
                    }
    });


</script>
