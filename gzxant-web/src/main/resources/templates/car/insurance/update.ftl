<div class="wrapper wrapper-content animated fadeInRight">
    <form class="form-horizontal form-bordered" id="gzxantForm">
        <input id="id" name="id" type="hidden" value="${entity.id}" />
        <div class="form-group">
            <label class="col-sm-3 control-label">车牌号：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="carNumber" id="carNumber"
                       value="${entity.carNumber}" placeholder="请输入车牌号"/>
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
            <label class="col-sm-3 control-label">购买组织：</label>
            <div class="col-sm-8">
                <select class="form-control" name="organizationId" id="organizationId">
                    <option value="">请选择</option>
                    <#list companyList as company>
                    <option value="${company.id}" <#if (company.id == entity.organizationId)>selected="selected"</#if>>
                        ${company.name}
                    </option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">保单编号：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="insuranceNo" id="insuranceNo"
                       value="${entity.insuranceNo}" placeholder="请输入保单编号"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">保单类型：</label>
            <div class="col-sm-8">
                <select class="form-control" name="noType" id="noType">
                    <option value="">请选择</option>
                    <#list insuranceTypeDict as dict>
                    <option value="${dict.jkey}" <#if (dict.jkey == entity.noType)>selected="selected"</#if>>
                        ${dict.jvalue}
                    </option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">车辆年限：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="fixedYears" id="fixedYears"
                       value="${entity.fixedYears}" placeholder="请输入车辆年限"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">保险公司：</label>
            <div class="col-sm-8">
                <select class="form-control" name="companyId" id="companyId">
                    <option value="">请选择</option>
                    <#list insuranceCompanyDict as dict>
                    <option value="${dict.jkey}" <#if (dict.jkey == entity.companyId)>selected="selected"</#if>>
                        ${dict.jvalue}
                    </option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">起效日期：</label>
            <div class="col-sm-8">
                <input type="date" class="form-control" name="startDate" id="startDate"
                       value="${entity.startDate}" placeholder="请输入起效日期"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">失效日期：</label>
            <div class="col-sm-8">
                <input type="date" class="form-control" name="expirationDate" id="expirationDate"
                       value="${entity.expirationDate}" placeholder="请输入失效日期"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">保险状态：</label>
            <div class="col-sm-8">
                <select class="form-control" name="status" id="status">
                    <option value="">请选择</option>
                    <#list insuranceStatusDict as dict>
                    <option value="${dict.jkey}" <#if (dict.jkey == entity.status)>selected="selected"</#if>>
                        ${dict.jvalue}
                    </option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">总保费：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="costTotal" id="costTotal"
                       value="${entity.costTotal}" placeholder="请输入总保费"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">经办人：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="agent" id="agent"
                       value="${entity.agent}" placeholder="请输入经办人"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">保险专员：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="specialist" id="specialist"
                       value="${entity.specialist}" placeholder="请输入保险专员"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">理赔电话：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="claimTelephone" id="claimTelephone"
                       value="${entity.claimTelephone}" placeholder="请输入理赔电话"/>
            </div>
        </div>
        <table class="table" id="typeTable">
            <thead>
            <tr>
                <th></th>
                <th>保险细项</th>
                <th>费率%</th>
                <th>被保金额</th>
                <th>保费</th>
            </tr>
            </thead>
            <tbody>
            <#if types?? && (types?size > 0)>
            <#list types as type>
            <tr>
                <td style="text-align:center;">
                    <#if (type_index == types?size - 1)>
                    <a onclick="tr.add(this)"><span class="glyphicon glyphicon-plus span_tip"></span></a>
                    <#else>
                    <a style="color:red;" onclick="tr.remove(this)"><span class="glyphicon glyphicon-remove"></span></a>
                    </#if>
                </td>
                <td>
                    <input type="text" class="form-filter form-control" id="term" name="term" value="${type.term}" placeholder="请输入保险细项" />
                </td>
                <td>
                    <input type="text" class="form-filter form-control" id="rate" name="rate" value="${type.rate}" placeholder="请输入费率%" />
                </td>
                <td>
                    <input type="text" class="form-filter form-control" id="beInsuranceCost" value="${type.beInsuranceCost}" name="beInsuranceCost" placeholder="请输入被保金额" />
                </td>
                <td>
                    <input type="text" class="form-filter form-control" id="insuranceCost" value="${type.insuranceCost}" name="insuranceCost" placeholder="请输入保费" />
                </td>
            </tr>
            </#list>
            <#else>
            <tr>
                <td style="text-align:center;">
                    <a onclick="tr.add(this)"><span class="glyphicon glyphicon-plus span_tip"></span></a>
                </td>
                <td>
                    <input type="text" class="form-filter form-control" id="term" name="term" placeholder="请输入保险细项" />
                </td>
                <td>
                    <input type="text" class="form-filter form-control" id="rate" name="rate" placeholder="请输入费率%" />
                </td>
                <td>
                    <input type="text" class="form-filter form-control" id="beInsuranceCost" name="beInsuranceCost" placeholder="请输入被保金额" />
                </td>
                <td>
                    <input type="text" class="form-filter form-control" id="insuranceCost" name="insuranceCost" placeholder="请输入保费" />
                </td>
            </tr>
            </#if>
            </tbody>
        </table>
        <div class="form-actions fluid">
            <div class="col-md-offset-3 col-md-9">
                <button type="button" onclick="submitData()" class="btn btn-success">保存</button>
            </div>
        </div>
    </form>
</div>

<script type="text/javascript">
	action = "${action}";

    function cusFunction() {
        console.info("提交之前，最后执行自定义的函数");
    }

    var tr = {
		add : function (obj) {
			var tr_dom = $(obj).parent("td").parent("tr");
			tr_dom = tr_dom.after(tr_dom.clone(true));
			var copy_tr_dom = tr_dom.next();
			copy_tr_dom.find("input").val("");
			$(obj).parent().html('<a style="color:red;" onclick="tr.remove(this)"><span class="glyphicon glyphicon-remove"></span></a>');
		},
		remove : function (obj) {
			$(obj).parent("td").parent("tr").remove();
		}
	}

	var info_validate = $('#gzxantForm');
    var error = $('.alert-danger', info_validate);
    var info_validate_obj = info_validate.validate({
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
                        belongstoId: {
                required: true
            },
                        organizationId: {
                required: true
            },
                        insuranceNo: {
                required: true
            },
                        noType: {
                required: true
            },
                        fixedYears: {
                required: true
            },
                        companyId: {
                required: true
            },
                        startDate: {
                required: true
            },
                        expirationDate: {
                required: true
            },
                        status: {
                required: true
            },
                        costTotal: {
                required: true
            },
                        agent: {
                required: true
            },
                        specialist: {
                required: true
            },
                        claimTelephone: {
                required: true
            }
                    },
        messages: {
                        carNumber: "请输入车牌号",
                        carType: "请输入车辆型号",
                        belongstoId: "请输入所属组织 ",
                        organizationId: "请输入购买组织",
                        insuranceNo: "请输入保单编号",
                        noType: "请输入保单类型",
                        fixedYears: "请输入车辆年限",
                        companyId: "请输入保险公司",
                        startDate: "请输入起效日期",
                        expirationDate: "请输入失效日期",
                        status: "请输入保险状态",
                        costTotal: "请输入总保费",
                        agent: "请输入经办人",
                        specialist: "请输入保险专员",
                        claimTelephone: "请输入理赔电话"
                    }
    });

    function getTypes() {
        var line = $("#typeTable tbody tr");
        var types = [];
        line.each(function(index, item){
            types.push({
                "term": $(item).find("#term").val(),
                "rate": $(item).find("#rate").val(),
                "beInsuranceCost": $(item).find("#beInsuranceCost").val(),
                "insuranceCost": $(item).find("#insuranceCost").val()
            });
        });

        return types;
    }

    function submitData() {
        if (!info_validate_obj.form()) {
            return false;
        }

        var data = {
            "info": {
                "id": $("#gzxantForm #id").val(),
                "carType": $("#gzxantForm #carType").val(),
                "carNumber": $("#gzxantForm #carNumber").val(),
                "organizationId": $("#gzxantForm #organizationId").val(),
                "insuranceNo": $("#gzxantForm #insuranceNo").val(),
                "noType": $("#gzxantForm #noType").val(),
                "fixedYears": $("#gzxantForm #fixedYears").val(),
                "companyId": $("#gzxantForm #companyId").val(),
                "startDate": $("#gzxantForm #startDate").val(),
                "expirationDate": $("#gzxantForm #expirationDate").val(),
                "status": $("#gzxantForm #status").val(),
                "costTotal": $("#gzxantForm #costTotal").val(),
                "agent": $("#gzxantForm #agent").val(),
                "specialist": $("#gzxantForm #specialist").val(),
                "claimTelephone": $("#gzxantForm #claimTelephone").val()
            },
            "types": getTypes()
        };

        console.log(data);
        data = JSON.stringify(data);

        $.ajax({
            type: "POST",
            url: url + action,
            data: {
                data: data
            },// 你的formid
            async: false,
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                layer.alert(XMLHttpRequest.responseJSON.error);
            },
            success: function (data) {
                if (data.code == 200) {
                    layer.msg("操作成功");
                    window.location.reload();
                } else {
                    layer.alert(data.error);
                }

            }
        });
    }

</script>
