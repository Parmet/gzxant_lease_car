<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>车辆类型：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
            <p><#list carTypeDict as dict><#if (dict.jkey == entity.carType)>${dict.jvalue}</#if></#list></p>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>车牌号：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.carNumber}</p></div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>车辆所属：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
                <p><#list companyList as company><#if (company.id == entity.belongstoId)>${company.name}</#if></#list></p>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>故障时间：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.time}</p></div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>故障地点：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.place}</p></div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>故障责任人：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.personLiable}</p></div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>故障详情：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.etails}</p></div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>故障时里程（km）：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.mileageTimeFailure}</p></div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>登记人：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.registrant}</p></div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>登记时间：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.registerDate}</p></div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>修改者id：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.updateId}</p></div>
    </div>
</div>

<script type="text/javascript">
	action = "${action}";

</script>
