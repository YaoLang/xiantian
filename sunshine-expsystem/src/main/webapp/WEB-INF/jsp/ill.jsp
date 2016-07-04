<%--
  Created by IntelliJ IDEA.
  User: kong
  Date: 16/6/10
  Time: 下午7:57
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
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i>首页</a> <a href="#" class="current">鸡病诊断</a> </div>
    <h1>鸡病诊断</h1>
  </div>
  <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span12">

        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>鸡病诊断</h5>
            <span class="label label-info">主要症状诊断法</span> </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered table-striped">
              <thead>
              <tr>
                <th>请选择症状分组</th>
                <th>请选择观察到的主要症状</th>
                <th>症状图片</th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td class="span4">
                  <div class="row-fluid">
                    <div class="span12 btn-icon-pg">
                      <ul class="center-align">
                        <li><i class="icon-chevron-right"></i>头颈症状</li>
                        <li><i class="icon-chevron-right"></i>眼症状</li>
                        <li><i class="icon-chevron-right"></i>皮肤羽毛</li>
                        <li><i class="icon-chevron-right"></i>解剖</li>
                      </ul>
                    </div>
                  </div>
                </td>
                <td class="span4">
                  <%--<select multiple="true">--%>
                    <%--<option>患病比例大于10%</option>--%>
                    <%--<option>患病比例小于10%</option>--%>
                    <%--<option>体温升高</option>--%>
                    <%--<option>体温正常</option>--%>
                    <%--<option>体温下降</option>--%>
                    <%--<option>无症状突然死亡</option>--%>
                    <%--<option>精神萎靡不振</option>--%>
                    <%--<option>采食减少或不食</option>--%>
                  <%--</select>--%>

                  <div class="widget-content nopadding" style="max-height: 200px;overflow: scroll">
                    <table class="table table-bordered">
                      <tbody>
                      <tr>
                        <td>Chrome</td>
                      </tr>
                      <tr>
                        <td>Firefox</td>
                      </tr>
                      <tr>
                        <td>Internet Explorer</td>
                      </tr>
                      <tr>
                        <td>Opera</td>
                      </tr>
                      <tr>
                        <td>Safari</td>
                      </tr>
                      </tbody>
                    </table>
                  </div>

                </td>
                <td class="span4">
                  <div class="widget-content">
                    <ul class="thumbnails">
                      <li class="span12"><a><img src="img/gallery/imgbox3.jpg" alt="" > </a>
                        <div class="actions"> <a title="" class="" href="#"><i class="icon-pencil"></i></a> <a class="lightbox_trigger" href="img/gallery/imgbox3.jpg"><i class="icon-search"></i></a> </div>
                      </li>
                    </ul>
                  </div>
                </td>
              </tr>
              </tbody>
            </table>
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
<script src="/js/jquery.uniform.js"></script>
<script src="/js/select2.min.js"></script>
<script src="/js/jquery.dataTables.min.js"></script>
<script src="/js/matrix.js"></script>
<script src="/js/matrix.tables.js"></script>
</body>
</html>
