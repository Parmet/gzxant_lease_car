<div class="panel panel-default border">
    <div class="panel-heading"><h3>统计</h3></div>
    <div style="padding: 10px 0 20px 10px;">
        <div class="wrapper wrapper-content">
            <div class="row">
                <div class="col-sm-6 col-md-3">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <span class="label label-success pull-left">保险</span>
                        </div>
                        <div class="ibox-content">
                            <h4 id="insurance_accumulative"><small>累计： </small><span>40 886,200</span></h4>
                            <h4 id="insurance_today"><small>今日： </small><span>6,200</span></h4>
                        </div>
                    </div>
                </div>
                <div  class="col-sm-6 col-md-3">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <span class="label label-success pull-left">违章</span>
                        </div>
                        <div class="ibox-content">
                            <h4 id="transgress_accumulative"><small>累计： </small><span>40 886,200</span></h4>
                            <h4 id="transgress_today"><small>今日： </small><span>6,200</span></h4>
                        </div>
                    </div>
                </div>
                <div  class="col-sm-6 col-md-3">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <span class="label label-success pull-left">事故</span>
                        </div>
                        <div class="ibox-content">
                            <h4 id="accident_accumulative"><small>累计： </small><span>40 886,200</span></h4>
                            <h4 id="accident_today"><small>今日： </small><span>6,200</span></h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="panel panel-default border">
    <div class="panel-heading"><h3>财务</h3></div>
    <div style="padding: 10px 0 20px 10px;">
        <div class="wrapper wrapper-content">
            <div class="row">
                <div class="col-sm-6 col-md-3">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <span class="label label-info pull-left">车辆数量</span>
                        </div>
                        <div class="ibox-content">
                            <h4 id="insurance_accumulative"><small>数量： </small><span>40 886,200</span></h4>
                            <h4 id="insurance_today"><span></span></h4>
                        </div>
                    </div>
                </div>
                <div  class="col-sm-6 col-md-3">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <span class="label label-info pull-left">违章押金</span>
                        </div>
                        <div class="ibox-content">
                            <h4 id="transgress_accumulative"><small>累计： </small><span>40 886,200</span></h4>
                            <h4 id="transgress_today"><small>今日： </small><span>6,200</span></h4>
                        </div>
                    </div>
                </div>
                <div  class="col-sm-6 col-md-3">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <span class="label label-info pull-left">租车押金</span>
                        </div>
                        <div class="ibox-content">
                            <h4 id="accident_accumulative"><small>累计： </small><span>40 886,200</span></h4>
                            <h4 id="accident_today"><small>今日： </small><span>6,200</span></h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<style>
    .border {
        margin: 10px 10px 0px 10px
    }
    h4 span {
        font-size: larger;
        font-weight: 600;
    }
</style>
<script>
    $(function() {
        // 当天请求数据
        var todayData = {"beginDate":"2018-07-05","endDate":"2018-07-05"};
        // 保险统计
        loadData("insurance",{},"insurance_accumulative");
        loadData("insurance",todayData,"insurance_today");
        // 违章统计
        loadData("transgress",{},"transgress_accumulative");
        loadData("transgress",todayData,"transgress_today");
        // 事故统计
        loadData("accident",{},"accident_accumulative");
        loadData("accident",todayData,"accident_today");

    });
    function loadData(modular, data, id) {
        $.ajax({
            type: "GET",
            url: "/gzxant/web/count/" + modular,
            data: data,
            success: function(data){
                $("#" + id + " span").html(data.message);
            },
            dataType: "json"
        });
    }
</script>