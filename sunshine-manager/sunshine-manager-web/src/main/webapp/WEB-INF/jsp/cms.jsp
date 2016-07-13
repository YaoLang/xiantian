<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>前台CMS管理</title>
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
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> 首页</a> <a href="#">内容管理</a> <a href="#" class="current">首页广告</a> </div>
    <h1>首页广告管理</h1>
  </div>
  <div class="container-fluid"><hr>
    <div class="row-fluid">
      <div class="span12">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-picture"></i> </span>
            <h5>幻灯片</h5>
          </div>
          <div class="widget-content">
            <ul class="thumbnails">
              <li class="span2"> <a> <img src="/img/gallery/imgbox3.jpg" alt="" > </a>
                <div class="actions"> <a title="" class="" href="#"><i class="icon-pencil"></i></a> <a class="lightbox_trigger" href="img/gallery/imgbox3.jpg"><i class="icon-search"></i></a></div>
              </li>
              <li class="span2"> <a> <img src="/img/gallery/imgbox4.jpg" alt="" > </a>
                <div class="actions"> <a title="" href="#"><i class="icon-pencil"></i></a> <a class="lightbox_trigger" href="img/gallery/imgbox3.jpg"><i class="icon-search"></i></a> </div>
              </li>
              <li class="span2"> <a > <img src="/img/gallery/imgbox5.jpg" alt="" > </a>
                <div class="actions"> <a title="" href="#"><i class="icon-pencil"></i></a> <a class="lightbox_trigger" href="img/gallery/imgbox3.jpg"><i class="icon-search"></i></a> </div>
              </li>
              <li class="span2"> <a> <img src="/img/gallery/imgbox1.jpg" alt="" > </a>
                <div class="actions"> <a title="" href="#"><i class="icon-pencil"></i></a> <a class="lightbox_trigger" href="img/gallery/imgbox3.jpg"><i class="icon-search"></i></a> </div>
              </li>
              <li class="span2"> <a > <img src="/img/gallery/imgbox2.jpg" alt="" > </a>
                <div class="actions"> <a title="" href="#"><i class="icon-pencil"></i></a> <a class="lightbox_trigger" href="img/gallery/imgbox3.jpg"><i class="icon-search"></i></a> </div>
              </li>
              <li class="span2"> <a> <img src="/img/gallery/imgbox3.jpg" alt="" > </a>
                <div class="actions"> <a title="" href="#"><i class="icon-pencil"></i></a> <a class="lightbox_trigger" href="img/gallery/imgbox3.jpg"><i class="icon-search"></i></a> </div>
              </li>
            </ul>
          	<ul class="thumbnails">
              <li class="span2 taskStatus"><span class="done">轮播1</span></li>
              <li class="span2 taskStatus"><span class="done">轮播2</span></li>
              <li class="span2 taskStatus"><span class="done">轮播3</span></li>
              <li class="span2 taskStatus"><span class="done">轮播4</span></li>
              <li class="span2 taskStatus"><span class="done">轮播5</span></li>
              <li class="span2 taskStatus"><span class="done">轮播6</span></li>
            
            </ul>
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
