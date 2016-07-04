<%--
  Created by IntelliJ IDEA.
  User: kong
  Date: 16/6/10
  Time: 下午4:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Matrix Admin</title>
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
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> 首页</a> <a href="#" class="current">知识库</a> </div>
    <h1>${essaytitle.data.title} (${essaytitle.data.authername})</h1>
  </div>
  <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span12">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-list"></i> </span>
            <h5>正文</h5>
          </div>
          <div class="widget-content">
            ${essaycontent.data.contentDesc}
          </div>
        </div>
      </div>
    </div>
</div>
</div>

<!--Footer-part-->
<jsp:include page="/common/footer"></jsp:include>

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
