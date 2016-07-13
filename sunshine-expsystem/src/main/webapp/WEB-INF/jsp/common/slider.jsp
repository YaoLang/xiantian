<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--sidebar-menu-->
<div id="sidebar"><a href="#" class="visible-phone"><i class="icon icon-home"></i>统计信息</a>
  <ul>
    <li class="active"><a href="/"><i class="icon icon-home"></i> <span>统计信息</span></a> </li>
    <%--<li> <a href="/ill"><i class="icon icon-signal"></i> <span>辅助诊断系统</span></a> </li>--%>
    <li class="submenu"> <a href="#"><i class="icon icon-inbox"></i> <span>知识库</span></a>
      <ul>
        <c:forEach items="${essay.data}" var="essayitem">
          <li><a href="/essay/${essayitem.id}" >${essayitem.name}</a> </li>
        </c:forEach>
      </ul>
    </li>
    <li class="submenu"><a href="#"><i class="icon icon-th-list"></i> <span>问题列表</span><span class="label label-important">3</span></a>
        <ul>
          <c:forEach items="${note.data}" var="noteitem">
            <li><a href="/leavemessage/${noteitem.id}" >${noteitem.name}</a> </li>
          </c:forEach>
        </ul>

    </li>

    <li><a href="/additem"><i class="icon icon-pencil"></i> <span>个人编写</span></a></li>
    <li class="submenu"> <a href="#"><i class="icon icon-file"></i> <span>日程安排</span></a>

    </li>

    <li class="content"> <span>云盘空间</span>
      <div class="progress progress-mini progress-danger active progress-striped">
        <div style="width: 77%;" class="bar"></div>
      </div>
      <span class="percent">77%</span>
      <div class="stat">21419.94 / 14000 MB</div>
    </li>
    <li class="content"> <span>硬盘空间使用</span>
      <div class="progress progress-mini active progress-striped">
        <div style="width: 87%;" class="bar"></div>
      </div>
      <span class="percent">87%</span>
      <div class="stat">604.44 / 4000 MB</div>
    </li>
  </ul>
</div>
<!--sidebar-menu-->