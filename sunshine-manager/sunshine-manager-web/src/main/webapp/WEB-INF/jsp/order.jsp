<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>订单查询</title>
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
    <div id="breadcrumb"> <a href="#" title="返回首页" class="tip-bottom"><i class="icon-home"></i>首页</a> <a href="#" class="tip-bottom">订单管理</a><a href="#" class="current">${comment}</a> </div>
    <h1>${comment }</h1>
  </div>
  <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span12">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>${comment }</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th>订单号</th>
                  <th>支付方式</th>
                  <th>实付</th>
                  <th>物流名称</th>
                  <th>物流编号</th>
                  <th>买家名</th>
                  <th>开始日期</th>
                  <th>结束日期</th>
                </tr>
              </thead>
              <tbody>
              	<c:if test="${orders!=null}">
              		<c:forEach items="${orders}" var="order">
              		<tr class="gradeX">
              			<td class="span1"><a href="/order/${order.orderId}">${order.orderId}</a></td>
                 		 <td class="span1">${order.paymentType}</td>
                 		 <td class="span1 taskStatus"><span class="pending">${order.payment}￥</span></td>
                  		<td class="span1">${order.shippingName}</td>
                  		<td class="span1">${order.shippingCode}</td>
                  		<td class="taskStatus span1">${order.buyerNick}</td>
                  		<td class="span1">${order.createTime}</td>
                  		<td class="span1">${order.closeTime}</td>
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
<script src="/js/jquery.min.js"></script> 
<script src="/js/jquery.ui.custom.js"></script> 
<script src="/js/bootstrap.min.js"></script> 
<script src="/js/jquery.uniform.js"></script> 
<script src="/js/select2.min.js"></script> 
<script src="/js/jquery.dataTables.min.js"></script> 
<script src="/js/matrix.js"></script> 
<script src="/js/matrix.tables.js"></script>
</body>
</html>
