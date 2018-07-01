// ==========================================================================
// Icon
// Icon.js v0.0.1
// License: The MIT License (MIT)
// ==========================================================================

(function () {
    'sys icon select';
    
    var pluginName = 'iIcon';
    
    var _element, _elementId;

    var _default = {
        currentPage : 1, //第几页
        pageCount : 32, //每页显示多少条记录数据
        totalPages : 0,
        defaultIcon: 'glyphicon glyphicon-zoom-in'
    };

    var _options = {};

    var Icon = function (element, options) {

        this._element = $(element);
        this._elementId = element.id;

        this.init(options);

        return {

            // Options (public access)
            options: _options,

            // Initialize / destroy methods
            init: $.proxy(this.init, this),
            editIcon: $.proxy(this.editIcon, this)
            
        };
    };
    
    Icon.prototype.init = function (options) {
        _options = $.extend({}, _default, options);
        
        this.destory();

        this.buildControls();

        //初始化列表
        this.queryByPage();
        
        // 初始化监听器
        this.listen();
        
    };

    Icon.prototype.buildControls = function () {
        // Open and add the progress and seek elements
    	var select_btn = [
    		'<span class="' + _options.defaultIcon + '"></span>',
    		'<input type="hidden" id="' + this._elementId + '" name="' + $(this._element).attr("name") + '" value="' + _options.defaultIcon + '" />'
    	];
    	$(this._element).append(select_btn.join(''));
    	
        var html = [
            '<div id="icon_add_div" class="modal fade" tabindex="-1" aria-hidden="true" style="height: 1000px">',
            '<div class="modal-dialog" style="width:900px;">',
                '<div class="modal-content">',
                    '<div class="modal-header" style="border-bottom:none;">',
                        '<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>',
                    '</div>',
                    '<div class="modal-body">',
                        '<div class="row" id="roletableDatas">',
                            '<div class="col-md-12">',
                                '<div class="portlet">',
                                    '<div class="portlet-title">',
                                        '<div class="caption"><i class="fa fa-cogs"></i>图标列表</div>',
                                        '<div class="actions">',
                                            '<div class="btn-group">',
                                                '<select class="form-control  input-small select2me" id="_dlgCheckIcon">',
                                                    '<option value="glyphiconsIcons">Glyphicons Icons</option>',
                                                    '<option value="newIcons">10 New Icons in 4.0</option>',
                                                    '<option value="webappIcons">Web Application Icons</option>',
                                                    '<option value="formIcons">Form Control Icons</option>',
                                                    '<option value="currencyIcons">Currency Icons</option>',
                                                    '<option value="textIcons">Text Editor Icons</option>',
                                                    '<option value="directIcons">Directional Icons</option>',
                                                    '<option value="videoIcons">Video Player Icons</option>',
                                                    '<option value="brandIcons">Brand Icons</option>',
                                                    '<option value="medicalIcons">Medical Icons</option>',
                                                    '<option value="simpleLineIcons">Simple Line Icons</option>',
                                                '</select>',
                                            '</div>',
                                        '</div>',
                                    '</div>',
                                    '<div class="portlet-body">',
                                        // 必须加上row样式,不然高度为1px,不能显示边框
                                        '<div id="tab_1_2" class="tab-pane glyphicons-demo active">',
                                            '<ul id="iconTable" class="bs-glyphicons bs-glyphicons-list">',
                                            '</ul>',
                                        '</div>',
                                        '<div class="row">',
                                            '<table id="iconPageBar" class="col-md-8" style="text-align: center; width: 100%;">',
                                                '<tr>',
                                                    '<td class="form-inline">',
                                                        '<div class="pagination" id="iconPager" style="font-size: 18px; text-align: center; vertical-align: middle;"></div>',
                                                        '<span style="margin-top: 0px; size: 12px; color: #8a8a8a">跳转到</span>',
                                                        '<input type="text" id="toMPage" style="font-size: 18px; width: 50px; height: 30px;" class="input-inline page_input" onkeyup="if(isNaN(value))execCommand("undo");if(event.keyCode==32)execCommand("undo");" onafterpaste="if(isNaN(value))execCommand("undo"));if(event.keyCode==32)execCommand("undo");">',
                                                        '<button style="width: 40px; height: 30px;" id="gotoMPage" class="btn">GO</button>',
                                                    '</td>',
                                                '</tr>',
                                            '</table>',
                                            '<div class="col-md-2"></div>',
                                        '</div>',
                                    '</div>',
                                '</div>',
                            '</div>',
                        '</div>',
                    '</div>',
                '</div>',
            '</div>',
        '</div>'];

        $("body").append(html.join(''));
        return html.join('');
    };

    Icon.prototype.listen = function() {
    	var _this = this;
    	$(_this._element).bind("click", function () {
    		_this.showIconModul();
    	});
    	
    	$("#_dlgCheckIcon").bind("change", function () {
    		_this.checkIcon();
    	});
    	
        $("#gotoMPage").bind("click", function () {
            if ($("#toMPage").val() == null || "" == $("#toMPage").val()) {
                layer.msg("请输入跳转页码");
                return;
            }

            var thisPage = parseInt($("#toMPage").val());
            if (!( thisPage > 0 && thisPage <= _options.totalPages)) {
                layer.msg("请输入正确跳转页码");
                return;
            }

            //$('#iconPager').bootstrapPaginator("show", thisPage);
            _options.currentPage = thisPage;
            _this.queryByPage();
        });
    };

    Icon.prototype.queryByPage = function () {
    	var _this = this;
        $.ajax({
            dataType: "json",
            cache: true,
            type: "GET",
            url: base_url + "/js/plugins/iIcon/icon.json",
            traditional: true,
            success: function (data) {
              //  stop_request_load();
                var checkIcon = $("#_dlgCheckIcon").val();
                data = data[checkIcon];
                //删除所有子项
                $("#iconTable").empty();
                var total = 0, str = '';
                $.each(data, function (i, n) {
                    str += '<li icon-data="' + n + '"><span class="' + n + '" style="font-size:24px;margin:5px auto 10px;display:block"></span><span>' + n + ' </span></li>';
                    total++;
                });
                if (data == null || data == undefined || total == 0) {
                    return;
                }
                if (total <= _options.pageCount) {
                    $("#iconPageBar").css({visibility: "hidden"});
                } else {
                    $("#iconPageBar").css({visibility: "visible"});
                    str = '';
                    var start = (_options.currentPage - 1) * _options.pageCount;
                    var k = 0;
                    $.each(data, function (i, n) {
                        if (i >= start) {
                            str += '<li icon-data="' + n + '"><span class="' + n + '" style="font-size:24px;margin:5px auto 10px;display:block"></span><span>' + n + ' </span></li>';
                            k++;
                        }
                        if (_options.pageCount == k) {
                            return false;
                        }
                    });
                }
                $("#iconTable").append(str);
                
                $("#iconTable li").bind("click", function () {
            		var data = $(this).attr("icon-data");
            		_this.editIcon(data);
                    $('#icon_add_div').modal('hide');
            	});
                
                //总页数
                if (total % _options.pageCount != 0) {
                	_options.totalPages = parseInt(total / _options.pageCount) + 1;
                } else {
                	_options.totalPages = total / _options.pageCount;
                }
                
                var options = {
                    currentPage: _options.currentPage,
                    totalPages: _options.totalPages,
                    onPageClicked: function (event, originalEvent, type, page) {
                    	_options.currentPage = page;
                        _this.queryByPage();
                    }
                }

            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                layer.msg("网络异常,数据不能成功返回");
            }
        });
    };

    Icon.prototype.showIconModul = function () {
        $('#icon_add_div').modal('show');
    };
    
    Icon.prototype.hideIconModul = function () {
        $('#icon_add_div').modal('hide');
    };
    
    Icon.prototype.checkIcon = function () {
        _options.currentPage = 1; //第几页
        _options.pageCount = 32; //每页显示多少条记录数据
        _options.totalPages = 0;
        $('#toMPage').val('');
        queryByPage();
    };
    
    Icon.prototype.editIcon = function (data) {
    	$(this._element).val(data);	
    	$("input[name=" + $(this._element).attr("name") + "]").val(data);
		this._element.children("span").html("");
		this._element.children("span").attr("class", data);
    };
    
    Icon.prototype.destory = function () {
    	this.hideIconModul();
    	this.editIcon("");
    	this._element.children("span").remove();
    	this._element.children("input").remove();
    	$("#icon_add_div").remove();
    };

    var logError = function (message) {
        if (window.console) {
            window.console.error(message);
        }
    };

    $.fn[pluginName] = function (options, args) {

        var result;

        this.each(function () {
            var _this = $.data(this, pluginName);
            if (typeof options === 'string') {
                if (!_this) {
                    logError('Not initialized, can not call method : ' + options);
                } else if (!$.isFunction(_this[options]) || options.charAt(0) === '_') {
                    logError('No such method : ' + options);
                } else {
                    if (!(args instanceof Array)) {
                        args = [ args ];
                    }

                    result = _this[options].apply(_this, args);
                }
            } else if (typeof options === 'boolean') {
                result = _this;
            } else {
            	result = $.data(this, pluginName, new Icon(this, $.extend(true, {}, options)));
            }
        });

        return result || this;
    };

})(jQuery, window, document);