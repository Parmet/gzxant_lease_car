<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
                        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>车牌号：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.carNumber}</p></div>
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>车辆所属 引用：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.belongstoId}</p></div>
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>事故日期：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.date}</p></div>
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>驾驶员：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.driver}</p></div>
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>事故地址：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.place}</p></div>
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>事故详情：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.detail}</p></div>
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>使用性质：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.usePropertyId}</p></div>
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>事故性质：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.nature}</p></div>
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>责任划分：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.responsibility}</p></div>
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>轻伤（人）：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.minorWound}</p></div>
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>重伤（人）：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.seriousInjury}</p></div>
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>死亡（人）：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.death}</p></div>
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>我方经济损失：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.ourLosses}</p></div>
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>我方医疗费用：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.ourExpenses}</p></div>
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>三者经济损失：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.threeLosses}</p></div>
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>三者医疗费用：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.threeExpenses}</p></div>
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>已赔付金额：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.amountPaid}</p></div>
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>事故等级：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.grade}</p></div>
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>处理状态：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.processingState}</p></div>
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>事故处理进度：</p></div>
        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"><p>${entity.handlingProgress}</p></div>
            </div>
</div>

<script type="text/javascript">
	action = "${action}";
</script>
