<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>订单详情</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/bootstrap-responsive.min.css" />
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
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> 首页</a> <a href="#">订单管理</a> <a href="#" class="current">订单详情</a> </div>
    <h1>a763741198</h1>
  </div>
  <div class="container-fluid"><hr>
    <div class="row-fluid">
      <div class="span12">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-briefcase"></i> </span>
            <h5 >订单信息</h5>
          </div>
          <div class="widget-content">
            <div class="row-fluid">
              <div class="span6">
                <table class="">
                  <tbody>
                    <tr>
                      <td><h4>发货人 : 孔耀烺</h4></td>
                    </tr>
                    <tr>
                      <td>发货地址  : 广州市番禺区沙湾镇</td>
                    </tr>
                    <tr>
                      <td>发货地 : 广东 广州</td>
                    </tr>
                    <tr>
                      <td>手机号码: +18814127386</td>
                    </tr>
                    <tr>
                      <td >邮箱  : 18814127386@163.com</td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <div class="span6">
                <table class="table table-bordered table-invoice">
                  <tbody>
               		<tr>
                      <td class="width30">收货人:</td>
                      <td class="width70"><strong>${shipping.receiverName }</strong></td>
                    </tr>
                    <tr>
                      <td class="width30">订单ID:</td>
                      <td class="width70"><strong>${order.orderId }</strong></td>
                    </tr>
                    <tr>
                      <td>下单日期:</td>
                      <td><strong>${order.createTime }</strong></td>
                    </tr>
                    <tr>
                      <td>付款日期:</td>
                      <td><strong>${order.paymentTime }</strong></td>
                    </tr>
                    <tr>
                      <td>邮政编码:</td>
                      <td><strong>${shipping.receiverZip }</strong></td>
                    </tr>
                    <tr>
                      <td>省市:</td>
                      <td><strong>${shipping.receiverState }   ${shipping.receiverCity }</strong></td>
                    </tr>
                  <tr>
                  	<td class="width30">收货地址:</td>
                    <td class="width70"><strong>${shipping.receiverDistrict }</strong> <br>
                    		  ${shipping.receiverAddress }, <br>
                      		联系电话: ${shipping.receiverPhone } <br>
                    	  邮箱: 18814127386@163.com </td>
                  </tr>
                    </tbody>
                  
                </table>
              </div>
            </div>
            <div class="row-fluid">
              <div class="span12">
                <table class="table table-bordered table-invoice-full">
                  <thead>
                    <tr>
                      <th class="head0">商品SKU</th>
                      <th class="head1" class="span4">商品名</th>
                      <th class="head0 right">数量</th>
                      <th class="head1 right">单价</th>
                      <th class="head0 right">总价</th>
                    </tr>
                  </thead>
                  <tbody>
                  	<c:forEach items="${orderitems }" var="item">
                  		<tr>
                      		<td>${item.itemId}</td>
		                     <td class="span4">${item.title }</td>
		                     <td class="right">${item.num }</td>
		                     <td class="right">${item.price }</td>
		                     <td class="right"><strong>${item.totalFee }</strong></td>
                    	</tr>
                  	</c:forEach>
             
                  </tbody>
                </table>
                
                <table class="table table-bordered table-invoice-full">
                  <thead>
                    <tr>
                      <th class="head0">买家留言</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>${order.buyerMessage }</td>
                    </tr>
                 
                  </tbody>
                </table>
                <table class="table table-bordered table-invoice-full">
                  <tbody>
                    <tr>
                      <td class="msg-invoice" width="85%"><h4>支付信息: </h4>
                        <a href="#" class="tip-bottom" title="Wire Transfer">微信支付</a> |  <a href="#" class="tip-bottom" title="Bank account">支付银行 #</a> |  <a href="#" class="tip-bottom" title="SWIFT code">流水号 </a>|  <a href="#" class="tip-bottom" title="IBAN Billing address">发票 </a></td>
                      <td class="right"><strong>实付金额</strong> <br>
                        <strong>物流</strong></td>
                      <td class="right"><strong>${order.payment}<br>
                        $50</strong></td>
                    </tr>
                  </tbody>
                </table>
                <div class="pull-right">
                  <h4><span>实付金额:</span>${order.payment}</h4>
                  <br>
                  <a class="btn btn-primary btn-large pull-right" href="#">发货</a> </div>
              </div>
            </div>
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
<script src="/js/matrix.js"></script>
</body>
</html>
