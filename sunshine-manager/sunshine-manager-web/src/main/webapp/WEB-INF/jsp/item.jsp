<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/uniform.css" />
<link rel="stylesheet" href="css/select2.css" />
<link rel="stylesheet" href="css/matrix-style.css" />
<link rel="stylesheet" href="css/matrix-media.css" />
<link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
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
    <div id="breadcrumb"> <a href="#" title="返回首页" class="tip-bottom"><i class="icon-home"></i>首页</a> <a href="#" class="tip-bottom">商品管理</a><a href="#" class="current">商品查询</a> </div>
    <h1>商品查询</h1>
  </div>
  <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span12">
        

        <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>商品信息</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th>商品编号</th>
                  <th>商品名</th>
                  <th>卖点</th>
                  <th>价格</th>
                  <th>库存</th>
                  <th>状态</th>
                  <th>图片</th>
                </tr>
              </thead>
              <tbody>
              	<c:if test="${items!=null}">
              		<c:forEach items="${items}" var="item">
              		<tr class="gradeX">
              			<td class="span1">${item.id}</td>
                 		 <td class="span3">${item.title}</td>
                 		 <td class="span4">${item.sellPoint}</td>
                  			<td class="taskStatus span1"><span class="pending">${item.price}￥</span></td>
                  		<td class="span1">${item.num}</td>
                  		<c:if test="${item.status==1}">
                  			<td class="taskStatus span1"><span class="done">上架</span></td>
                  		</c:if>
                  		<c:if test="${item.status==0}">
                  			<td class="taskStatus span1"><span class="pending">下架</span></td>
                  		</c:if>
                  		<td class="span1">
                			<div class="actions"><a class="lightbox_trigger" href="${item.image}"><i class="icon-search"></i>点击查看</a> </div>
                  		</td>
               	 	</tr>
              		</c:forEach>
              	</c:if>
              
             
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!--Footer-part-->
<jsp:include page="/common/footer"></jsp:include>
<!--end-Footer-part-->
<script src="js/jquery.min.js"></script> 
<script src="js/jquery.ui.custom.js"></script> 
<script src="js/bootstrap.min.js"></script> 
<script src="js/jquery.uniform.js"></script> 
<script src="js/select2.min.js"></script> 
<script src="js/jquery.dataTables.min.js"></script> 
<script src="js/matrix.js"></script> 
<script src="js/matrix.tables.js"></script>
</body>
</html>
