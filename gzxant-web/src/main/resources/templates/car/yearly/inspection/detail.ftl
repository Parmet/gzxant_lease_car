<div class="wrapper wrapper-content animated fadeInRight">
    <form class="form-horizontal form-bordered" id="gzxantForm">
        <input type="hidden" name="id" value="${entity.id}" />
        <div class="form-group">
            <label class="col-sm-3 control-label">车牌号：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="carNumber" id="carNumber" readonly
                       value="${entity.carNumber}" placeholder="请输入车牌号"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">办理日期：</label>
            <div class="col-sm-8">
                <input type="date" class="form-control" name="dateHandling" id="dateHandling" readonly
                       value="${entity.dateHandling}" placeholder="请输入办理日期"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">年检有效期至：</label>
            <div class="col-sm-8">
                <input type="date" class="form-control" name="effectiveDate" id="effectiveDate" readonly
                       value="${entity.effectiveDate}" placeholder="请输入年检有效期至"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">年检办理人：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="transactor" id="transactor" readonly
                       value="${entity.transactor}" placeholder="请输入年检办理人"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">年检单位：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="unit" id="unit" readonly
                       value="${entity.unit}" placeholder="请输入年检单位"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">年检费用：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="cost" id="cost" readonly
                       value="${entity.cost}" placeholder="请输入年检费用"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">年检结果</label>
            <div class="col-sm-8">
                <select class="form-control" name="result" id="result" disabled>
                    <option value="">请选择</option>
                    <#list resultList as r>
                        <option value="${r.jkey}" <#if r.jkey==entity.result>selected</#if>>${r.jvalue}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">年检记录：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="record" id="record" readonly
                       value="${entity.record}" placeholder="请输入年检记录"/>
            </div>
        </div>
        <#if action != "detail">
            <div class="form-actions fluid">
                <div class="col-md-offset-3 col-md-9">
                    <button type="submit" class="btn btn-success">保存</button>
                </div>
            </div>
        </#if>
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
            carNumber: {
                required: true
            },
            belongstoId: {
                required: true
            },
            dateHandling: {
                required: true
            },
            effectiveDate: {
                required: true
            },
            transactor: {
                required: true
            },
            unit: {
                required: true
            },
            cost: {
                required: true
            },
            result: {
                required: true
            },
            record: {
                required: true
            },
            updateId: {
                required: true
            },
        },
        messages: {
            carNumber: "请输入车牌号",
            belongstoId: "请输入车辆所属 引用",
            dateHandling: "请输入办理日期",
            effectiveDate: "请输入年检有效期至",
            transactor: "请输入年检办理人",
            unit: "请输入年检单位",
            cost: "请输入年检费用",
            result: "请输入年检结果 合格：Y不合格：N",
            record: "请输入年检记录",
            updateId: "请输入修改者id",
        }
    });
</script>
