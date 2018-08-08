    <link rel="stylesheet" type="text/css" href="${rc.contextPath}/css/plugins/jsTree/style.min.css"/>
    <style>
        #dict_edit_table .control-label {
            text-align: left !important;
        }

        #dict_edit_table input ,#dict_edit_table select{
            margin-left: -45px;
        }
        #dict_edit_table .row{
          margin-top: 15px!important;
        }

    </style>
<div class="wrapper wrapper-content animated fadeInRight">
<!--数据列表-->
<div class="row" style="margin-right: 0!important;">

    <div class="col-sm-2">
        <div class="portlet box green-haze" style="padding: 15px">
            <div class="portlet-body" id="categoryTree"></div>
        </div>
    </div>

    <div class="col-sm-10">
    	<div class="col-sm-12">
	        <div class="ibox">
	            <div class="ibox-body">
			    	<div id="standardToolbar" role="group">
			    		<input type="hidden" class="form-filter form-control _search" id="path" name="search_like_category_path" value="0." />
			    		<input type="hidden" class="form-filter form-control _search" id="del-flag" name="search_eq_del_flag" value="Y"  />
			    		<div class="row">
                            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group">
                                <label for="numberInput" class="control-label">国家编号</label>
                                <input type="text" class="form-filter form-control _search" id="numberInput" name="search_like_number"  />
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group">
                                <label for="nameInput" class="control-label">名称</label>
                                <input type="text" class="form-filter form-control _search" id="nameInput" name="search_like_name"  />
                            </div>
                        </div>
			    	</div>
			    	
			    	<table class="table" id="standardTable" data-mobile-responsive="true">
					</table>
			    </div>
		    </div>
	    </div>
    </div>
</div>

	
</div>
<script src="${rc.contextPath}/js/plugins/jsTree/jstree.min.js" type="text/javascript"></script>
<script src="${rc.contextPath}/js/plugins/iTable/iTable.js" type="text/javascript"></script>
<script type="text/javascript">
	function getColumns() {
	    var c = [
	        {
	            checkbox: true
	        },
	        {
	            field: 'name',
	            title: '名称'
	        },
	        {
	            field: 'number',
	            title: '国家编号',
	            width: '130px'
	        },
	        {
	            field: 'categoryName',
	            title: '标准大类'
	        },
	        {
	            field: 'typeName',
	            title: '标准类别'
	        },
	        {
	            field: 'publishDate',
	            title: '发布时间',
	            width: '100px'
	        },
	        {
	            field: 'implementDate',
	            title: '实施时间',
	            width: '100px'
	        },
	        {
	            field: 'uploadDate',
	            title: '上传时间',
	            width: '100px'
	        },
	        {
	            field: 'id',
	            title: '操作',
	            align: 'center',
	            width: '130px',
	            formatter: function (value, row, index) {
	            	var edit_btn = '<a class="btn btn-primary btn-sm" href="#" mce_href="#" title="编辑" onclick="updateStandard(\''
	    				+ row.id + '\')"><i class="fa fa-edit"></i></a> ';
	                return dt_detail_button(row)+edit_btn+dt_delete_button(row);
				}
	        }];
	
	    return c;
	}
	
	function updateStandard(id) {
		window.location.href = url + "jupdate/" + id;
	}
	
	var standardTable = $("#standardTable").iTable({
		toolbar : {
			id : "standardToolbar",
			auto : true,
			exclude_btn : ["dt_insert"],
			include_btn : [
				{
					id : "btn_import",
					className : "btn-info",
					icon : "glyphicon glyphicon-cloud-upload",
					title : "导入",
					click: function() {
						window.location.href = url + "jcreate";
				    }
				}
			]
		},
		data : {
			columns : getColumns()
		}
	});

    $("#categoryTree").jstree({
        "core": {
            "animation": 0,
            "themes": {
                theme: "classic",
                "dots": true,
                "icons": true
            },
            "check_callback": true,
            'data': ${categoryTrees!''}
        },
        "types": {
            "default": {
                "valid_children": ["default", "file"]
            }
        },
        "plugins": ["types", "wholerow"]
    }).on("select_node.jstree", function (node, selectd) {
        id = selectd.node.id;
        pid = selectd.node.parent;
        text = selectd.node.text;
        $('#path').val(id + ".");
        standardTable.re_load();
    });
    
</script>

