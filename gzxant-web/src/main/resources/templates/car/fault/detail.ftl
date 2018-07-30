<div class="wrapper wrapper-content animated fadeInRight">
    <form class="form-horizontal form-bordered" id="gzxantForm">
        <input type="hidden" name="id" value="${entity.id}"/>
        <div class="form-group">
            <label class="col-sm-3 control-label">车牌号：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="carNumber" id="carNumber" readonly
                       value="${entity.carNumber}" placeholder="请输入车牌号"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">故障时间：</label>
            <div class="col-sm-8">
                <input type="date" class="form-control" name="time" id="time" readonly
                       value="${entity.time}" placeholder="请输入故障时间"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">故障地点：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="place" id="place" readonly
                       value="${entity.place}" placeholder="请输入故障地点"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">故障责任人：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="personLiable" id="personLiable" readonly
                       value="${entity.personLiable}" placeholder="请输入故障责任人"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">故障详情：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="etails" id="etails" readonly
                       value="${entity.etails}" placeholder="请输入故障详情"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">故障时里程（km）：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="mileageTimeFailure" id="mileageTimeFailure" readonly
                       value="${entity.mileageTimeFailure}" placeholder="请输入故障时里程（km）"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">登记人：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="registrant" id="registrant" readonly
                       value="${entity.registrant}" placeholder="请输入登记人"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">登记时间：</label>
            <div class="col-sm-8">
                <input type="date" class="form-control" name="registerDate" id="registerDate" readonly
                       value="${entity.registerDate}" placeholder="请输入登记时间"/>
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
            time: {
                required: true
            },
            place: {
                required: true
            },
            personLiable: {
                required: true
            },
            etails: {
                required: true
            },
            mileageTimeFailure: {
                required: true
            },
            registrant: {
                required: true
            },
            registerDate: {
                required: true
            },
            updateId: {
                required: true
            },
        },
        messages: {
            carNumber: "请输入车牌号",
            belongstoId: "请输入车辆所属 引用",
            time: "请输入故障时间",
            place: "请输入故障地点",
            personLiable: "请输入故障责任人",
            etails: "请输入故障详情",
            mileageTimeFailure: "请输入故障时里程（km）",
            registrant: "请输入登记人",
            registerDate: "请输入登记时间",
            updateId: "请输入修改者id",
        }
    });
</script>
