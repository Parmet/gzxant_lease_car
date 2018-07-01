// ==========================================================================
// iTable
// iTable.js v0.0.1
// License: The MIT License (MIT)
// ==========================================================================

(function() {
	'auto table';

	var pluginName = 'iTable';

	var _element, _elementId;

	var _default = {
		toolbar : {
			id : "gzxantToolbar", // 查询框id
			auto : false, // 是否自动美化查询框，拿取查询条件框下的元素，直接填充到 panel-body 下
			
			// 不生成的按钮 ["re_load", "reset", "batch_remove", "dt_insert"]
			// re_load：查询；reset：重置；batch_remove：删除；dt_insert：添加
			exclude_btn : [],
			
			// 自定义按钮，默认按顺序放在最后面
			/*
			 * 示例：
			 {
			   id : "btn_re_load",
			   className : "btn-success",
			   icon : "fa fa-search",
			   title : "查询",
			   click: function() {
			     alert("do somthing...");
			   }
			 }
			 
			 * 结果：
			 * <button type="button" id="btn_re_load" class="btn btn-success" style="margin-left: 10px;">
			 * <i class="fa fa-search" aria-hidden="true"></i> 查询
			 * </button>
			 */ 
			include_btn : []
		},
		page : {
			pageNumber : 1, //第几页
			pageSize : 32, //每页显示多少条记录数据
			searchParams : '',
			sorts : {} // 排序
		},
		data : {
			columns : [] // 字段
		},
		url : {
			remove : url + "delete",
			batch_remove : url + "delete",
			load_data : url + "list",
			export_data : url + "exportList"
		}
	};

	var _options = {};

	var iTable = function(element, options) {

		this._element = $(element);
		this._elementId = element.id;

		this.init(options);
		this.load_data();

		return {

			// Options (public access)
			options : _options,

			// Initialize / destroy methods
			init : $.proxy(this.init, this),
			batch_remove : $.proxy(this.batch_remove, this),
			remove : $.proxy(this.remove, this),
			reset : $.proxy(this.reset, this),
			re_load : $.proxy(this.re_load, this),
			export_data : $.proxy(this.export_data, this),
			load_data : $.proxy(this.load_data, this),
			dt_delete_button : $.proxy(this.dt_delete_button, this),
			dt_edit_button : $.proxy(this.dt_edit_button, this),
			dt_detail_button : $.proxy(this.dt_detail_button, this),
			dt_insert : $.proxy(this.dt_insert, this),
			dt_update : $.proxy(this.dt_update, this),
			dt_detail : $.proxy(this.dt_detail, this)

		};
	};

	iTable.prototype.init = function(options) {
		_options = $.extend(true, {}, _default, options);

		this.bulidHtml();
		this.listen();
	};

	iTable.prototype.bulidHtml = function() {
		var html = [];
		if (_options.toolbar.auto) {
			html = ['<div class="panel panel-default">',
					'<div class="panel-heading">',
					'<h3 class="panel-title">查询条件</h3>', 
					'</div>',
					'<div class="panel-body">'];
			html.push($("#" + _options.toolbar.id).html());
			html.push('</div>', '<div class="panel-footer">');
			// ["re_load", "reset", "batch_remove", "dt_insert"]
			if ($.inArray("re_load", _options.toolbar.exclude_btn) < 0) {
				html
						.push(
								'<button type="button" id="btn_re_load" class="btn btn-success" style="margin-left: 10px;">',
								'<i class="fa fa-search" aria-hidden="true"></i> 查询',
								'</button>');
			}

			if ($.inArray("reset", _options.toolbar.exclude_btn) < 0) {
				html
						.push(
								'<button type="button" id="btn_reset" class="btn btn-primary" style="margin-left: 10px;">',
								'<i class="fa fa-circle-thin" aria-hidden="true"></i> 重置',
								'</button>');
			}

			if ($.inArray("batch_remove", _options.toolbar.exclude_btn) < 0) {
				html
						.push(
								'<button type="button" id="btn_batch_remove" class="btn btn-danger" style="margin-left: 10px;">',
								'<i class="fa fa-trash" aria-hidden="true"></i> 删除',
								'</button>');
			}

			if ($.inArray("dt_insert", _options.toolbar.exclude_btn) < 0) {
				html
						.push(
								'<button type="button" id="btn_dt_insert" class="btn btn-info" style="margin-left: 10px;">',
								'<i class="fa fa-plus-square" aria-hidden="true"></i> 添加',
								'</button>');
			}
			
			var _include_btn = _options.toolbar.include_btn;
			for (var i = 0; i < _include_btn.length; i++) {
				var btn = _include_btn[i];
				html.push(
						'<button type="button" id="' + btn.id + '" class="btn ' + btn.className + '" style="margin-left: 10px;">',
						'<i class="' + btn.icon + '" aria-hidden="true"></i>',
						' ' + btn.title,
						'</button>');
			}

			html.push('</div>', '</div>');

			$("#" + _options.toolbar.id).children().remove();
			$("#" + _options.toolbar.id).html(html.join(''));
			html = [];
		}
	};

	iTable.prototype.listen = function() {
		var _this = this;
		if ($.inArray("re_load", _options.toolbar.exclude_btn) < 0) {
			$("#" + _options.toolbar.id).find("#btn_re_load").bind("click",
					function() {
						_this.re_load();
					});
		}

		if ($.inArray("reset", _options.toolbar.exclude_btn) < 0) {
			$("#" + _options.toolbar.id).find("#btn_reset").bind("click",
					function() {
						_this.reset();
					});
		}

		if ($.inArray("batch_remove", _options.toolbar.exclude_btn) < 0) {
			$("#" + _options.toolbar.id).find("#btn_batch_remove").bind(
					"click", function() {
						_this.batch_remove();
					});
		}

		if ($.inArray("dt_insert", _options.toolbar.exclude_btn) < 0) {
			$("#" + _options.toolbar.id).find("#btn_dt_insert").bind("click",
					function() {
						_this.dt_insert();
					});
		}
		
		var _include_btn = _options.toolbar.include_btn;
		for (var i = 0; i < _include_btn.length; i++) {
			var btn = _include_btn[i];
			$("#" + _options.toolbar.id).find("#" + btn.id)
				.bind("click", btn.click);
		}
	}

	iTable.prototype.dataTable_rep_message = function(r) {
		if (r.code == 200) {
			layer.msg(r.message);
			this.re_load();
		} else {
			layer.msg(r.error);
		}
	};

	iTable.prototype.remove = function(id) {
		var _this = this;
		layer.confirm('确定要删除选中的记录？', {
			btn : [ '确定', '取消' ]
		}, function() {
			$.ajax({
				url : _options.url.remove,
				type : "POST",
				data : {
					'ids' : id
				},
				success : function(r) {
					_this.dataTable_rep_message(r);
				}
			});
		})
	}

	iTable.prototype.batch_remove = function() {
		var _this = this;
		var rows = _this._element.bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
		if (rows.length == 0) {
			layer.msg("请选择要删除的数据");
			return;
		}

		layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
			btn : [ '确定', '取消' ]
		// 按钮
		}, function() {
			/*var ids = new Array();*/
			var ids = '';
			//遍历所有选择的行数据，取每条数据对应的ID
			$.each(rows, function(i, row) {
				ids = ids + row['id'] + ",";
			});

			ids = ids.substr(0, ids.length - 1);
			$.ajax({
				type : 'POST',
				data : {
					"ids" : ids
				},
				url : _options.url.batch_remove,
				success : function(r) {
					_this.dataTable_rep_message(r)
				}
			});
		}, function() {

		});
	};

	iTable.prototype.reset = function() {
		$("#" + _options.toolbar.id + " ._search").each(function () {
	        $(this).val(""); 
	    });
		
	    this.re_load();
	}
	
	iTable.prototype.re_load = function() {
		this._element.bootstrapTable('refresh');
	}

	iTable.prototype.load_data = function() {
		var option = _options;
		this._element.bootstrapTable({
			method : 'post', // 服务器数据的请求方式 get or post
			url : option.url.load_data, // 服务器数据的加载地址
			//showRefresh : true,
			//showToggle : true,
			//showColumns : true,
			iconSize : 'outline',
			toolbar : '#' + option.toolbar.id,
			striped : true, // 设置为true会有隔行变色效果
			dataType : "json", // 服务器返回的数据类型
			pagination : true, // 设置为true会在底部显示分页条
			// queryParamsType : "limit",
			// //设置为limit则会发送符合RESTFull格式的参数
			singleSelect : false, // 设置为true将禁止多选
			// contentType : "application/x-www-form-urlencoded",
			// //发送到服务器的数据编码类型
			pageSize : option.page.pageSize, // 如果设置了分页，每页数据条数
			pageNumber : option.page.pageNumber, // 如果设置了分布，首页页码
			//search : true, // 是否显示搜索框
			//showColumns : true, // 是否显示内容下拉框（选择显示的列）
			sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者  "server"
			queryParams : function(params) {

				var searchParams = {};
				$("#" + option.toolbar.id + " ._search").each(function() {
					searchParams[$(this).attr('name')] = $(this).val();
				});

				var p = {
					"pageNumber" : option.page.pageNumber,
					"pageSize" : option.page.pageSize,
					"searchParams" : searchParams,
					"sorts" : option.page.sorts
				};

				return p;

			},
			// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
			// queryParamsType = 'limit' ,返回参数必须包含
			// limit, offset, search, sort, order 否则, 需要包含:
			// pageSize, pageNumber, searchText, sortName,
			// sortOrder.
			// 返回false将会终止请求
			columns : option.data.columns
		});
	}

	iTable.prototype.export_data = function() {
		var option = _options;
		var searchParams = {};
		$("#" + option.toolbar.id + " ._search").each(function() {
			searchParams[$(this).attr('name')] = $(this).val();
		});

		var d = {
			"pageNumber" : 1,
			"pageSize" : 99999,
			"searchParams" : searchParams,
			"sorts" : option.page.sorts
		};
		$.ajax({
			type : "POST", //提交方式
			url : option.url.export_data, // 服务器数据的加载地址
			dataType : "json",
			contentType : "application/json; charset=utf-8",//(可以)
			data : JSON.stringify(d),//数据，这里使用的是Json格式进行传输
			success : function(result) {//返回数据根据结果进行相应的处理

			}

		});
	};

	iTable.prototype.dt_delete_button = function(row) {
		var deleteO = '<a class="btn btn-warning btn-sm" href="#" title="删除"  mce_href="#" '
				+ 'onclick="iTable.remove(\''
				+ row.id
				+ '\')"><i class="fa fa-remove"></i></a> ';
		return deleteO;
	};

	iTable.prototype.dt_edit_button = function(row) {
		var editO = '<a class="btn btn-primary btn-sm" href="#" mce_href="#" title="编辑" onclick="iTable.dt_update(\''
				+ row.id + '\')"><i class="fa fa-edit"></i></a> ';
		return editO;
	};

	iTable.prototype.dt_detail_button = function(row) {
		var detailO = '<a class="btn btn-success btn-sm" href="#" title="详情"  mce_href="#" onclick="iTable.dt_detail(\''
				+ row.id + '\')"><i class="fa fa-info-circle"></i></a> ';
		return detailO;
	};

	iTable.prototype.dt_insert = function() {
		this.dt_action("新增", "insert");
	};

	iTable.prototype.dt_update = function(id) {
		this.dt_action("编辑", "update/" + id);
	};

	iTable.prototype.dt_update = function(id) {
		this.dt_action("详情", "detail/" + id);
	};

	iTable.prototype.dt_action = function(title, action) {
		// var btn = "";
		// if (action.indexOf("insert") >= 0
		//     || action.indexOf("update") >= 0) {
		//     btn = "保存";
		// } else if (action.indexOf("detail") >= 0) {
		//     btn = "确定";
		// } else {
		//     btn = "关闭";
		// }

		var initSelect2 = "<script type='text/javascript'>$('.select2').select2();</script>";
		$.get(url + action, {}, function(html) {
			layer.open({
				type : 1,
				title : title,
				// btn: btn,
				id : 'layer' + action,
				btnAlign : 'c',
				maxmin : true,
				shadeClose : false, // 点击遮罩关闭层
				area : [ '800px', '520px' ],
				content : html + initSelect2,
				yes : function() {
					layer.closeAll();
				}
			});
		}, "html");
	};

	var logError = function(message) {
		if (window.console) {
			window.console.error(message);
		}
	};

	$.fn[pluginName] = function(options, args) {

		var result;

		this.each(function() {
			var _this = $.data(this, pluginName);
			if (typeof options === 'string') {
				if (!_this) {
					logError('Not initialized, can not call method : '
							+ options);
				} else if (!$.isFunction(_this[options])
						|| options.charAt(0) === '_') {
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
				result = $.data(this, pluginName, new iTable(this, $.extend(
						true, {}, options)));
			}
		});

		return result || this;
	};

})(jQuery, window, document);