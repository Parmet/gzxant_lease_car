<div class="wrapper wrapper-content animated fadeInRight">
    <form class="form-horizontal form-bordered" id="gzxantForm">
        <input type="hidden" name="id" value="${entity.id}" />
        <div class="form-group">
            <label class="col-sm-3 control-label">车牌号：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="carNumber" id="carNumber" value="${entity.carNumber}"
                       <#if action == "detail">readonly</#if>placeholder="请输入车牌号" />
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">车辆类型</label>
            <div class="col-sm-8">
                <select class="form-control" name="carType" id="carType" <#if action == "detail">disabled</#if>>
                    <option value="">请选择</option>
                    <#list carTypeList as c>
                        <option value="${c.jkey}" <#if c.jkey == entity.carType>selected</#if>>${c.jvalue}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">扣分：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="deduction" id="deduction" value="${entity.deduction}"
                       <#if action == "detail">readonly</#if> placeholder="请输入扣分"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">罚款：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="fine" id="fine" value="${entity.fine}"
                      <#if action == "detail">readonly</#if> placeholder="请输入罚款"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">资产公司：</label>
            <div class="col-sm-8">
                <select class=" form-control" name="assetCompany" <#if action == "detail">disabled</#if>>
                    <option value="">请选择</option>
                    <#list companyList as c>
                        <option value="${c.id}" <#if c.id == entity.assetCompany>selected</#if>>${c.name}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">经营公司：</label>
            <div class="col-sm-8">
                <select  class="form-control" name="businessCompany" id="businessCompany" <#if action == "detail">disabled</#if>>
                    <option value="">请选择</option>
                    <#list companyList as c>
                        <option value="${c.id}" <#if c.id == entity.businessCompany>selected</#if>>${c.name}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">客户：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="customer" id="customer" value="${entity.customer}"
                       <#if action == "detail">readonly</#if> placeholder="请输入客户"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">违章时间：</label>
            <div class="col-sm-8">
                <input type="date" class="form-control" name="violationDate" id="violationDate" value="${entity.violationDate}"
                       <#if action == "detail">readonly</#if> placeholder="请输入违章时间"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">违章地点：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="violationPlace" id="violationPlace" value="${entity.violationPlace}"
                        <#if action == "detail">readonly</#if> placeholder="请输入违章地点"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">违章原因：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="violationReason" id="violationReason" value="${entity.violationReason}"
                       <#if action == "detail">readonly</#if> placeholder="请输入违章原因"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">违章采集机关：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="collectionOffice" id="collectionOffice" value="${entity.collectionOffice}"
                      <#if action == "detail">readonly</#if>  placeholder="请输入违章采集机关"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">是否可以代表</label>
            <div class="col-sm-8">
                <select  class="form-control" name="isRepresentative" id="isRepresentative" <#if action == "detail">disabled</#if>>
                <option value="">请选择</option>
                    <#list isList as s>
                        <option value="${s.jkey}" <#if s.jkey == entity.isRepresentative>selected</#if>>${s.jvalue}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">违章代码：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="violationCode" id="violationCode" value="${entity.violationCode}"
                      <#if action == "detail">readonly</#if>  placeholder="请输入违章代码"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">违章项文书编号：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="bookNumber" id="bookNumber" value="${entity.bookNumber}"
                       <#if action == "detail">readonly</#if> placeholder="请输入违章项文书编号"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">状态</label>
            <div class="col-sm-8">
                <select class="form-control"  name="status" id="status" <#if action == "detail">disabled</#if>>
                    <option value="">请选择</option>
                    <#list statusList as s>
                        <option value="${s.jkey}" <#if s.jkey == entity.status>selected</#if>>${s.jvalue}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">数据查询时间：</label>
            <div class="col-sm-8">
                <input type="date" class="form-control" name="dataQueryDate" id="dataQueryDate" value="${entity.dataQueryDate}"
                       <#if action == "detail">readonly</#if> placeholder="请输入数据查询时间"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">更新为已处理时间：</label>
            <div class="col-sm-8">
                <input type="date" class="form-control" name="finishDate" id="finishDate" value="${entity.finishDate}"
                       <#if action == "detail">readonly</#if> placeholder="请输入更新为已处理时间"/>
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
            deduction: {
                required: true
            },
            fine: {
                required: true
            },
            assetCompany: {
                required: true
            },
            businessCompany: {
                required: true
            },
            customer: {
                required: true
            },
            violationDate: {
                required: true
            },
            violationPlace: {
                required: true
            },
            violationReason: {
                required: true
            },
            collectionOffice: {
                required: true
            },
            isRepresentative: {
                required: true
            },
            violationCode: {
                required: true
            },
            bookNumber: {
                required: true
            },
            status: {
                required: true
            },
            dataQueryDate: {
                required: true
            },
            finishDate: {
                required: true
            },
            updateId: {
                required: true
            },
        },
        messages: {
            carNumber: "请输入车牌号",
            belongstoId: "请输入车辆所属 引用",
            deduction: "请输入扣分",
            fine: "请输入罚款",
            assetCompany: "请输入资产公司",
            businessCompany: "请输入经营公司",
            customer: "请输入客户",
            violationDate: "请输入违章时间",
            violationPlace: "请输入违章地点",
            violationReason: "请输入违章原因",
            collectionOffice: "请输入违章采集机关",
            isRepresentative: "请输入是否可以代表 Y可以 N不可以",
            violationCode: "请输入违章代码",
            bookNumber: "请输入违章项文书编号",
            status: "请输入状态 字典 未处理 已处理 处理中",
            dataQueryDate: "请输入数据查询时间",
            finishDate: "请输入更新为已处理时间",
            updateId: "请输入修改者id",
        }
    });
</script>
