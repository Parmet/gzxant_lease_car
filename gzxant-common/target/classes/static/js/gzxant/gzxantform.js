$.validator.setDefaults({
    submitHandler: function () {
        saveForm();
    }
});

/**
 * 提交表单
 */
function saveForm(form_id) {
    cusFunction(); // 回调一个自定义方法，比如修改提交参数。每个form表单都必须定义
    var form;
    if (validate.isEmpty(form_id)) {
    	form = $('#' + form_id);
    } else {
    	form = $('#gzxantForm');
    }
    
    $.ajax({
        cache: true,
        type: "POST",
        url: url+action,
        data: form.serialize(),// 你的formid
        async: false,
        dataType : "json",
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            layer.alert(XMLHttpRequest.responseJSON.error);
        },
        beforeSend: function () {
            start_request_load();
        }, complete: function () {
            stop_request_load();
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