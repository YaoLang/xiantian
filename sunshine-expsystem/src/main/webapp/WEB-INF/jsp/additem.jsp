<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="/css/uniform.css" />
<link rel="stylesheet" href="/css/select2.css" />
<link rel="stylesheet" href="/css/matrix-style.css" />
<link rel="stylesheet" href="/css/matrix-media.css" />
<link href="/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href='http://fonts.useso.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>

</head>
<body>

<!--Header-part-->
	<jsp:include page="/common/header"></jsp:include>
<!--close-top-serch-->
<!--sidebar-menu-->
	<jsp:include page="/common/slider"></jsp:include>
<!--sidebar-menu-->


<div id="content">
  	<div id="content-header">
  <div id="breadcrumb"> <a href="index.html" title="前往首页" class="tip-bottom"><i class="icon-home"></i> 首页</a> <a href="#" class="tip-bottom">商品管理</a> <a href="#" class="current">添加商品</a> </div>
  <h1>添加文档</h1>
</div>
<div class="container-fluid">
  <hr>
  <div class="row-fluid">
    <div class="span12">
      <div class="widget-box">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          <h5>知识基本信息</h5>
        </div>
        <div class="widget-content nopadding">
          <form action="/essay" method="post" id="itemform" class="form-horizontal">
            <div class="control-group">
              <label class="control-label">标题 :</label>
              <div class="controls">
                <input type="text" name="title" class="span11" placeholder="标题" />
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">副标题 :</label>
              <div class="controls">
                <input type="text" name="subtitle" class="span11" placeholder="副标题" />
              </div>
            </div>

            <div class="control-group">
              <label class="control-label">所属分类  :</label>
              <div class="controls">
                <select id="select-1" name="cid">
                  <c:forEach items="${parent}" var="node">
                  	<option value="${node.id }">${node.text}</option>
                  </c:forEach>
             
                </select>
              </div>
              <%--<div class="controls">--%>
                <%--<select name="cid" id="select-2">--%>
                  <%--<option value="5">二级分类</option>--%>
                  <%----%>
                <%--</select>--%>
              <%--</div>--%>
            </div>

          	<div class="control-group">
          		<label class="control-label">正文 :</label>
                <div class="controls" class="span11">
                  <jsp:include page="/common/eueditor"></jsp:include>
                </div>
            </div>
          
            <div class="form-actions">
              <button type="submit" id="submititem" class="btn btn-success">添加</button>
            </div>
          </form>
        </div>
      </div>

  	
</div>
</div>
</div>
<!--Footer-part-->
<jsp:include page="/common/footer"></jsp:include>
<!--end-Footer-part-->
<script src="/js/jquery.min.js"></script> 
<script src="/js/jquery.ui.custom.js"></script> 
<script src="/js/bootstrap.min.js"></script> 
<script src="/js/bootstrap-colorpicker.js"></script> 
<script src="/js/bootstrap-datepicker.js"></script> 
<script src="/js/jquery.toggle.buttons.html"></script> 
<script src="/js/masked.js"></script> 
<script src="/js/jquery.uniform.js"></script> 
<script src="/js/select2.min.js"></script> 
<script src="/js/matrix.js"></script> 
<script src="/js/matrix.form_common.js"></script> 
<script src="/js/wysihtml5-0.3.0.js"></script> 
<script src="/js/jquery.peity.min.js"></script> 
<script src="/js/bootstrap-wysihtml5.js"></script>


<script>
	$('.textarea_editor').wysihtml5();
	
</script>
</body>
<script type="text/javascript">
	$("#select-1").change(function(data){
		var id = $("#select-1").val();
		var select2 = $("#select-2");
		select2.html("");
		select2.attr("value","");
		$.get("/item/cat/list?id="+id,function(data){
			$.each(data,function(index,info){
				var selection = $("<option></option>");
				selection.html(info['text']);
				selection.attr("value",info['id']);
				select2.append(selection);
			})
		})
		
	})
	$("#submititem").click(function(){
		alert(11);
		var content = UE.getEditor('editor').getContent();
		alert(content);
	})
</script>

</html>
