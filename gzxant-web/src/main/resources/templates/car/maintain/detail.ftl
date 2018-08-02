<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>车牌号：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.carLnumber}</p></div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>车辆型号：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
            <p><#list carTypeDict as dict><#if (dict.jkey == entity.carType)>${dict.jvalue}</#if></#list></p>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>车辆所属：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
            <p><#list companyList as company><#if (company.id == entity.belongstoId)>${company.name}</#if></#list></p>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>保养级别：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
            <p><#list levelDict as dict><#if (dict.jkey == entity.maintainLevel)>${dict.jvalue}</#if></#list></p>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>保养门店：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.maintainStore}</p></div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>保养费用：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.maintainCost}</p></div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>保养日期：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.maintainDate}</p></div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>保养里程：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.maintainMileage}</p></div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>经办人：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.agent}</p></div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>保养单号：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.maintainNo}</p></div>
    </div>
</div>

<script type="text/javascript">
	action = "${action}";
</script>
