<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>车牌号：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.carNumber!'-'}</p></div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>车辆型号：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
            <p><#if (entity.carType != '')><#list carTypeDict as dict><#if (dict.jkey == entity.carType)>${dict.jvalue}</#if></#list><#else>-</#if></p>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>车辆所属：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
            <p><#if (entity.belongstoId != '')><#list companyList as company><#if (company.id == entity.belongstoId)>${company.name}</#if></#list><#else>-</#if></p>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>购买组织：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
            <p><#if (entity.organizationId != '')><#list companyList as company><#if (company.id == entity.organizationId)>${company.name}</#if></#list><#else>-</#if></p>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>保单编号：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.insuranceNo!'-'}</p></div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>保单类型：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
            <p><#if (entity.noType != '')><#list insuranceTypeDict as dict><#if (dict.jkey == entity.noType)>${dict.jvalue}</#if></#list><#else>-</#if></p>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>车辆年限：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.fixedYears!'-'}</p></div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>保险公司：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
            <p><#if (entity.companyId != '')><#list insuranceCompanyDict as dict><#if (dict.jkey == entity.companyId)>${dict.jvalue}</#if></#list><#else>-</#if></p>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>起效日期：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.startDate!'-'}</p></div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>失效日期：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.expirationDate!'-'}</p></div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>保险状态：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
            <p><#if (entity.status != '')><#list insuranceStatusDict as dict><#if (dict.jkey == entity.status)>${dict.jvalue}</#if></#list><#else>-</#if></p>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>总保费：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.costTotal!'-'}</p></div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>经办人：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.agent!'-'}</p></div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>保险专员：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.specialist!'-'}</p></div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>理赔电话：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.claimTelephone!'-'}</p></div>
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
            <#list types as type>
            <tr>
                <td style="text-align:center;"></td>
                <td>${type.term}</td>
                <td>${type.rate}</td>
                <td>${type.beInsuranceCost}</td>
                <td>${type.insuranceCost}</td>
            </tr>
            </#list>
            </tbody>
        </table>
    </div>
</div>

<script type="text/javascript">
	action = "${action}";
</script>
