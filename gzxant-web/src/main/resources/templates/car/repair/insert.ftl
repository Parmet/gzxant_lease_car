<div class="wrapper wrapper-content animated fadeInRight">
    <form class="form-horizontal form-bordered" id="gzxantForm">
        <input type="hidden" name="id" value="${entity.id}"/>
        <div class="form-group">
            <label class="col-sm-3 control-label">车牌号：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="carNumber" id="carNumber" value="${entity.carNumber}"
                       <#if action == "detail">readonly</#if> placeholder="请输入车牌号"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">车辆型号：</label>
            <div class="col-sm-8">
                <select type="text" class="form-control" name="carType" id="carType" <#if action == "detail">disabled</#if>>
                    <option value="">请选择</option>
                    <#list carTypeList as c>
                        <option value="${c.jkey}" <#if c.jkey== entity.carType>selected</#if>>${c.jvalue}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">车架号：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="frameNumber" id="frameNumber" value="${entity.frameNumber}"
                       <#if action == "detail">readonly</#if> placeholder="请输入车架号"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">维修开始时间：</label>
            <div class="col-sm-8">
                <input type="date" class="form-control" name="date" id="date" value="${entity.date}"
                       <#if action == "detail">readonly</#if> placeholder="请输入维修日期"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">维修结束时间：</label>
            <div class="col-sm-8">
                <input type="date" class="form-control" name="endTime" id="endTime" value="${entity.endTime}"
                       <#if action == "detail">readonly</#if> placeholder="请输入维修结束时间"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">维修跟进人：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="followupPerson" id="followupPerson" value="${entity.followupPerson}"
                       <#if action == "detail">readonly</#if> placeholder="请输入维修跟进人"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">维修类型：</label>
            <div class="col-sm-8">
                <select class="form-filter form-control _search" id="type" name="type" <#if action == "detail">disabled</#if>>
                    <option value="">请选择</option>
                    <#list repairTypeList as r>
                        <option value="${r.jkey}" <#if r.jkey== entity.type>selected</#if>>${r.jvalue}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">维修结果：</label>
            <div class="col-sm-8">
                <select class="form-filter form-control _search" id="result" name="result" <#if action == "detail">disabled</#if>>
                    <option value="">请选择</option>
                    <#list repairResultList as r>
                        <option value="${r.jkey}" <#if r.jkey== entity.result>selected</#if>>${r.jvalue}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">维修人员：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="repairman" id="repairman" value="${entity.repairman}"
                       <#if action == "detail">readonly</#if> placeholder="请输入维修人"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">维修单号：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="repairNo" id="repairNo" value="${entity.repairNo}"
                       <#if action == "detail">readonly</#if> placeholder="请输入维修单号"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">维修门店：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="repairShop" id="repairShop" value="${entity.repairShop}"
                       <#if action == "detail">readonly</#if> placeholder="请输入维修门店"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">维修时里程（km）：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="mileage" id="mileage" value="${entity.mileage}"
                       <#if action == "detail">readonly</#if> placeholder="请输入维修时里程（km）"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">维修总费用（元）：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="totalCost" id="totalCost" value="${entity.totalCost}"
                       <#if action == "detail">readonly</#if> placeholder="请输入总费用（元）"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">维修配件费（元）：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="accessoriesFee" id="accessoriesFee" value="${entity.accessoriesFee}"
                       <#if action == "detail">readonly</#if> placeholder="请输入维修配件费（元）"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">维修工时费（元）：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="timeFee" id="timeFee" value="${entity.timeFee}"
                       <#if action == "detail">readonly</#if> placeholder="请输入维修工时费（元）"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label">维修项目：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="repairProject" id="repairProject" value="${entity.repairProject}"
                       <#if action == "detail">readonly</#if> placeholder="请输入维修项目"/>
            </div>
        </div>


        <div class="form-group">
            <label class="col-sm-3 control-label">备注：</label>
            <div class="col-sm-8">
                <textarea class="form-control" name="remark" id="remark" value="${entity.remark}"
                       <#if action == "detail">readonly</#if> placeholder="备注"/>
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
            carNumber: {
                required: true
            },
            carType: {
                required: true
            },
            frameNumber: {
                required: true
            },
            belongstoId: {
                required: true
            },
            repairShop: {
                required: true
            },
            repairNo: {
                required: true
            },
            date: {
                required: true
            },
            type: {
                required: true
            },
            result: {
                required: true
            },
            mileage: {
                required: true
            },
            totalCost: {
                required: true
            },
            accessoriesFee: {
                required: true
            },
            timeFee: {
                required: true
            },
            repairman: {
                required: true
            },
            repairProject: {
                required: true
            },
            endTime: {
                required: true
            },
            followupPerson: {
                required: true
            },
            updateId: {
                required: true
            },
        },
        messages: {
            carNumber: "请输入车牌号",
            carType: "请输入车辆型号",
            frameNumber: "请输入车架号",
            belongstoId: "请输入车辆所属 引用",
            date: "请输入维修日期",
            type: "请输入维修类型 字典 正常维修 事故维修",
            result: "请输入维修结果 字典 未完成 已完成",
            mileage: "请输入维修时里程（km）",
            totalCost: "请输入总费用（元）",
            accessoriesFee: "请输入维修配件费（元）",
            timeFee: "请输入维修工时费（元）",
            repairman: "请输入维修人",
            repairProject: "请输入维修项目",
            endTime: "请输入维修结束时间",
            followupPerson: "请输入维修跟进人",
            updateId: "请输入修改者id",
        }
    });
</script>
