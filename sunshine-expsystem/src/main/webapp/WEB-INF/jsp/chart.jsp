<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Matrix Admin</title>
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
    <div id="breadcrumb"><a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">Charts &amp; graphs</a></div>
    <h1>Charts &amp; graphs</h1>
  </div>

    <div class="container-fluid">
        <hr>
        <div class="row-fluid">
            <div class="span12">
                <div class="widget-box">
                    <div class="widget-title"> <span class="icon"> <i class="icon-signal"></i> </span>
                        <h5>Real Time chart</h5>
                    </div>
                    <div id="graphic">
                        <div id="main" class="main"></div>
                        <div>
                            <button type="button" class="btn btn-sm btn-success" onclick="refresh(true)">刷 新</button>
                            <span class="text-primary">切换主题</span>
                            <select id="theme-select"></select>

                            <span id='wrong-message' style="color:red"></span>
                        </div>
                    </div><!--/span-->
                </div>
            </div>
        </div>
    </div>

</div>



<!--Footer-part-->
<jsp:include page="/common/footer"></jsp:include>

<!--end-Footer-part-->
<script src="/js/jquery.min.js"></script> 
<script src="/js/bootstrap.min.js"></script> 
<script src="/js/jquery.flot.min.js"></script> 
<script src="/js/jquery.flot.pie.min.js"></script> 
<script src="/js/matrix.charts.js"></script> 
<script src="/js/jquery.flot.resize.min.js"></script> 
<script src="/js/matrix.js"></script> 
<script src="/js/jquery.peity.min.js"></script> 
<!--Real-time-chart-js-->


<!--Turning-series-chart-js-->
<script src="js/matrix.dashboard.js"></script>
        <script type="text/javascript" src="js/chart.js"></script>
</body>
</html>
