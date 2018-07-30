<div class="wrapper wrapper-content animated fadeInRight">
    <form class="form-horizontal form-bordered" id="gzxantForm">
        <input type="hidden" name="id" value="${entity.id}">
        <div class="form-group">
            <label class="col-sm-3 control-label">车牌号：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="carNumber" id="carNumber" value="${entity.carNumber}"
                       placeholder="请输入车牌号"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">事故日期：</label>
            <div class="col-sm-8">
                <input type="date" class="form-control" name="date" id="date" value="${entity.date}"
                       placeholder="请输入事故日期"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">驾驶员：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="driver" id="driver" value="${entity.driver}"
                       placeholder="请输入驾驶员"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">事故地址：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="place" id="place" value="${entity.place}"
                       placeholder="请输入事故地址"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">事故详情：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="detail" id="detail" value="${entity.detail}"
                       placeholder="请输入事故详情"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">使用性质</label>
            <div class="col-sm-8">
                <select name="usePropertyId" class="form-control">
                    <option value="usePropertyId">请选择</option>
                    <#list usePropertyList as u>
                        <option value="${u.jkey}" <#if entity.usePropertyId == u.jkey>selected</#if>>${u.jvalue}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">事故性质</label>
            <div class="col-sm-8">
                <select class="form-control" name="nature" id="nature">
                    <option value="">请选择</option>
                    <#list accidentNatureList as a>
                        <option value="${a.jkey}" <#if entity.nature == a.jkey>selected</#if>>${a.jvalue}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">责任划分</label>
            <div class="col-sm-8">
                <select type="text" class="form-control" name="responsibility" id="responsibility">
                    <option value="">请选择</option>
                    <#list responsibilityList as r>
                        <option value="${r.jkey}" <#if entity.responsibility == r.jkey>selected</#if>>${r.jvalue}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">车辆类型</label>
            <div class="col-sm-8">
                <select type="text" class="form-control" name="carType" id="carType">
                    <option value="">请选择</option>
                    <#list carTypeList as c>
                        <option value="${c.jkey}" <#if entity.carType == c.jkey>selected</#if>>${c.jvalue}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">轻伤（人）：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="minorWound" id="minorWound" value="${entity.minorWound}"
                       placeholder="请输入轻伤（人）"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">重伤（人）：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="seriousInjury" id="seriousInjury" value="${entity.seriousInjury}"
                       placeholder="请输入重伤（人）"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">死亡（人）：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="death" id="death" value="${entity.death}"
                       placeholder="请输入死亡（人）"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">我方经济损失：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="ourLosses" id="ourLosses" value="${entity.ourLosses}"
                       placeholder="请输入我方经济损失"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">我方医疗费用：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="ourExpenses" id="ourExpenses" value="${entity.ourExpenses}"
                       placeholder="请输入我方医疗费用"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">三者经济损失：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="threeLosses" id="threeLosses" value="${entity.threeLosses}"
                       placeholder="请输入三者经济损失"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">三者医疗费用：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="threeExpenses" id="threeExpenses" value="${entity.threeExpenses}"
                       placeholder="请输入三者医疗费用"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">已赔付金额：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="amountPaid" id="amountPaid" value="${entity.amountPaid}"
                       placeholder="请输入已赔付金额"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">事故等级</label>
            <div class="col-sm-8">
                <select type="text" class="form-control" name="grade" id="grade">
                    <option value="">请选择</option>
                    <#list accidentGradeList as a>
                        <option value="${a.jkey}" <#if entity.grade == a.jkey>selected</#if>>${a.jvalue}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">处理状态</label>
            <div class="col-sm-8">
                <select type="text" class="form-control" name="processingState" id="processingState">
                    <option value="">请选择</option>
                    <#list processingStateList as p>
                        <option value="${p.jkey}" <#if entity.processingState == p.jkey>selected</#if>>${p.jvalue}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">事故处理进度</label>
            <div class="col-sm-8">
                <select type="text" class="form-control" name="handlingProgress" id="handlingProgress">
                    <option value="">请选择</option>
                    <#list accidentHandlingProgressList as a>
                        <option value="${a.jkey}" <#if entity.handlingProgress == a.jkey>selected</#if>>${a.jvalue}</option>
                    </#list>
                </select>
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
            belongstoId: {
                required: true
            },
            date: {
                required: true
            },
            driver: {
                required: true
            },
            place: {
                required: true
            },
            detail: {
                required: true
            },
            usePropertyId: {
                required: true
            },
            nature: {
                required: true
            },
            responsibility: {
                required: true
            },
            minorWound: {
                required: true
            },
            seriousInjury: {
                required: true
            },
            death: {
                required: true
            },
            ourLosses: {
                required: true
            },
            ourExpenses: {
                required: true
            },
            threeLosses: {
                required: true
            },
            threeExpenses: {
                required: true
            },
            amountPaid: {
                required: true
            },
            grade: {
                required: true
            },
            processingState: {
                required: true
            },
            handlingProgress: {
                required: true
            },
            updateId: {
                required: true
            },
        },
        messages: {
            carNumber: "请输入车牌号",
            belongstoId: "请输入车辆所属 引用",
            date: "请输入事故日期",
            driver: "请输入驾驶员",
            place: "请输入事故地址",
            detail: "请输入事故详情",
            usePropertyId: "请输入使用性质 引用",
            nature: "请输入事故性质 字典 单方事故、双方事故、多方事故",
            responsibility: "请输入责任划分 字典 全责、无责、次责、不详、同等、主责",
            minorWound: "请输入轻伤（人）",
            seriousInjury: "请输入重伤（人）",
            death: "请输入死亡（人）",
            ourLosses: "请输入我方经济损失",
            ourExpenses: "请输入我方医疗费用",
            threeLosses: "请输入三者经济损失",
            threeExpenses: "请输入三者医疗费用",
            amountPaid: "请输入已赔付金额",
            grade: "请输入事故等级 字典 轻微事故、一般事故、重大事故、特大事故",
            processingState: "请输入处理状态 字典 未处理 处理中 已处理",
            handlingProgress: "请输入事故处理进度 Y：已结案 N：待定损",
            updateId: "请输入修改者id",
        }
    });
</script>
