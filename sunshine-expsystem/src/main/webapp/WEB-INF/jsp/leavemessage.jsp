<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kong
  Date: 16/6/10
  Time: 下午6:25
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
  <link rel="stylesheet" href="/css/fullcalendar.css" />
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
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i>首页</a> <a href="#" class="current">问题列表</a> </div>
  </div>

  <div class="container-fluid">
    <div class="row-fluid">

      <div class="span12">
        <div class="widget-box">
          <div class="widget-title">
            <ul class="nav nav-tabs">
              <li class="active"><a data-toggle="tab" href="#tab1">未解决</a></li>
              <li><a data-toggle="tab" href="#tab2">已解决</a></li>
              <li><a data-toggle="tab" href="#tab3">疑难杂症</a></li>
            </ul>
          </div>
          <div class="widget-content tab-content">
            <div id="tab1" class="tab-pane active">

              <div class="row-fluid">


                <c:forEach items="${noteed.data}" var="i">
                  <div class="span4">
                    <div class="widget-box">
                      <div class="widget-title"> <span class="icon"> <i class="icon-list"></i> </span>
                        <h5>${i.title}</h5><span class="label label-important">${i.authername}</span>
                      </div>
                      <div class="widget-content">
                        ${i.subtitle}
                      </div>
                      <div class="widget-plain">
                        <div class="form-actions" style="margin-top: 0px;border-bottom: 1px solid #cdcdcd">
                          <button type="submit" class="btn btn-success">答复</button>
                        </div>
                      </div>
                    </div>
                  </div>
                </c:forEach>

                <%--<div class="span4">--%>
                  <%--<div class="widget-box">--%>
                    <%--<div class="widget-title"> <span class="icon"> <i class="icon-list"></i> </span>--%>
                      <%--<h5>仓鼠咬人</h5><span class="label label-important">孔耀烺</span>--%>
                    <%--</div>--%>
                    <%--<div class="widget-content">--%>
                      <%--刚刚被金丝熊（家养的养5个多月了）咬到无名指头，很疼，然后我用手挤出很多血，像掉水珠一样挤出来好几滴血，之后又抹上了好多次碘酒，然后我又拿肥皂用清水洗了几遍，然后又抹了碘酒，我会不会有事啊，我该怎么办啊？我看别人说的是先洗后抹，而我是先抹后洗啊，我几个月之前也被金丝熊咬到过的，不过不是现在这只，是一个母的，内次以后我就把内母的卖了，现在就剩这公的了。大家帮我出出注意啊，别是复制的，要真心说的啊。--%>
                    <%--</div>--%>
                    <%--<div class="widget-plain">--%>
                      <%--<div class="form-actions" style="margin-top: 0px;border-bottom: 1px solid #cdcdcd">--%>
                        <%--<button type="submit" class="btn btn-success">答复</button>--%>
                      <%--</div>--%>
                    <%--</div>--%>
                  <%--</div>--%>
                <%--</div>--%>

                <%--<div class="span4">--%>
                  <%--<div class="widget-box">--%>
                    <%--<div class="widget-title"> <span class="icon"> <i class="icon-list"></i> </span>--%>
                      <%--<h5>仓鼠咬人</h5><span class="label label-important">孔耀烺</span>--%>
                    <%--</div>--%>
                    <%--<div class="widget-content">--%>
                      <%--刚刚被金丝熊（家养的养5个多月了）咬到无名指头，很疼，然后我用手挤出很多血，像掉水珠一样挤出来好几滴血，之后又抹上了好多次碘酒，然后我又拿肥皂用清水洗了几遍，然后又抹了碘酒，我会不会有事啊，我该怎么办啊？我看别人说的是先洗后抹，而我是先抹后洗啊，我几个月之前也被金丝熊咬到过的，不过不是现在这只，是一个母的，内次以后我就把内母的卖了，现在就剩这公的了。大家帮我出出注意啊，别是复制的，要真心说的啊。--%>
                    <%--</div>--%>
                    <%--<div class="widget-plain">--%>
                      <%--<div class="form-actions" style="margin-top: 0px;border-bottom: 1px solid #cdcdcd">--%>
                        <%--<button type="submit" class="btn btn-success">答复</button>--%>
                      <%--</div>--%>
                    <%--</div>--%>
                  <%--</div>--%>
                <%--</div>--%>

                <%--<div class="span4">--%>
                  <%--<div class="widget-box">--%>
                    <%--<div class="widget-title"> <span class="icon"> <i class="icon-list"></i> </span>--%>
                      <%--<h5>仓鼠咬人</h5><span class="label label-important">孔耀烺</span>--%>
                    <%--</div>--%>
                    <%--<div class="widget-content">--%>
                      <%--刚刚被金丝熊（家养的养5个多月了）咬到无名指头，很疼，然后我用手挤出很多血，像掉水珠一样挤出来好几滴血，之后又抹上了好多次碘酒，然后我又拿肥皂用清水洗了几遍，然后又抹了碘酒，我会不会有事啊，我该怎么办啊？我看别人说的是先洗后抹，而我是先抹后洗啊，我几个月之前也被金丝熊咬到过的，不过不是现在这只，是一个母的，内次以后我就把内母的卖了，现在就剩这公的了。大家帮我出出注意啊，别是复制的，要真心说的啊。--%>
                    <%--</div>--%>
                    <%--<div class="widget-plain">--%>
                      <%--<div class="form-actions" style="margin-top: 0px;border-bottom: 1px solid #cdcdcd">--%>
                        <%--<button type="submit" class="btn btn-success">答复</button>--%>
                      <%--</div>--%>
                    <%--</div>--%>
                  <%--</div>--%>
                <%--</div>--%>

              </div>

              </div>
            <div id="tab2" class="tab-pane">
                <p>未有问题</p>

            </div>
            <div id="tab3" class="tab-pane">
                <p>未有问题</p>

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
  <!--end-Footer-part-->
  <script src="/js/excanvas.min.js"></script>
  <script src="/js/jquery.min.js"></script>
  <script src="/js/jquery.ui.custom.js"></script>
  <script src="/js/bootstrap.min.js"></script>
  <script src="/js/jquery.flot.min.js"></script>
  <script src="/js/jquery.flot.resize.min.js"></script>
  <script src="/js/jquery.peity.min.js"></script>
  <script src="/js/matrix.js"></script>
  <script src="/js/fullcalendar.min.js"></script>
  <script src="/js/matrix.calendar.js"></script>
  <script src="/js/matrix.chat.js"></script>
  <script src="/js/jquery.validate.js"></script>
  <script src="/js/matrix.form_validation.js"></script>
  <script src="/js/jquery.wizard.js"></script>
  <script src="/js/jquery.uniform.js"></script>
  <script src="/js/select2.min.js"></script>
  <script src="/js/matrix.popover.js"></script>
  <script src="/js/jquery.dataTables.min.js"></script>
  <script src="/js/matrix.tables.js"></script>
  <script src="/js/matrix.interface.js"></script>
</body>
</html>
