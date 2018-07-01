<script src="${rc.contextPath}/js/plugins/dropzone/dropzone.min.js"></script>
<link href="${rc.contextPath}/css/plugins/dropzone/dropzone.css" rel="stylesheet">
<div class="col-sm-4">
    <div id="mydropzone" class="dropzone"></div>
</div>
<script type="text/javascript">
// --------------------------图片上传-------------------------------------------------- //
// 图片上传插件识别 <div class="img_box" id="imgBox">
// 下的input标签，将上传图片在服务器保存的路径存放到input的value属性中
// type：上传文件的业务类型
// default_img：默认图片
function initFileUpload (type, default_img) {
	 Dropzone.autoDiscover = false;
	 var myDropzone = new Dropzone("div#mydropzone", {
	     url: base_url + "/file/upload/" + type,
	     filesizeBase: 1024,//定义字节算法 默认1000
	     maxFiles: 2,//最大文件数量
	     maxFilesize: 100, //MB
	     fallback: function () {
	         layer.alert('暂不支持您的浏览器上传!');
	     },
	     uploadMultiple: false,
	     addRemoveLinks: true,
	     dictFileTooBig: '您的文件超过' + 100 + 'MB!',
	     dictInvalidInputType: '不支持您上传的类型',
	     dictMaxFilesExceeded: '您的文件超过1个!',
	     init: function () {
	         this.on('queuecomplete', function (files) {
	             // layer.alert('上传成功');
	         });
	         this.on('success', function (uploadimfo, result) {
	             console.info(result);
	             $("#imgBox input").val(result.message[0].s_url);
	             $("#imgshowdiv").attr('src', base_url + result.message[0].s_url);
	             layer.alert('上传成功');
	         });
	         this.on('error', function (a, errorMessage, result) {
	             if (!result) {
	                 layer.alert(result.error || '上传失败');
	             }
	         });
	         this.on('maxfilesreached', function () {
	             this.removeAllFiles(true);
	             layer.alert('文件数量超出限制');
	         });
	         this.on('removedfile', function () {
	             $("#imgBox input").val(default_img);
	             $("#imgshowdiv").attr('src', base_url + default_img);
	             layer.alert('删除成功');
	         });
	     }
	 });
 }
 
</script>