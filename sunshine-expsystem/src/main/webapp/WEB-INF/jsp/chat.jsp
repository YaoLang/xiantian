<%--
  Created by IntelliJ IDEA.
  User: kong
  Date: 16/6/8
  Time: 上午11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<hea<title>Matrix Admin</title>
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
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> 首页</a> <a href="#">在线解答</a> </div>
    <h1>在线解答</h1>
  </div>
  <div class="container-fluid"><hr>
    <div class="row-fluid">
      <div class="span12">
        <div class="widget-box widget-chat">
          <div class="widget-title"> <span class="icon"> <i class="icon-comment"></i> </span>
            <h5>Let's do a chat</h5>
          </div>
          <div class="widget-content nopadding">
            <div class="chat-users panel-right2">
              <div class="panel-title">
                <h5>房间</h5>
              </div>
              <div class="panel-content nopadding">
                <ul class="contact-list">
                  <li id="user-Alex" class="online"><a href="#"><img alt="" src="img/demo/av1.jpg" /> <span>柯文涛</span></a></li>
                  <li id="user-柯振旭"><a href="#"><img alt="" src="img/demo/av2.jpg" /> <span>柯振旭</span></a></li>
                </ul>
              </div>
            </div>
            <div class="chat-content panel-left2">
              <div class="chat-messages" id="chat-messages">
                <div id="chat-messages-inner"></div>
              </div>
              <div class="chat-message well">
                <button class="btn btn-success">发送</button>
                <span class="input-box">
                <input type="text" name="msg-box" id="msg-box" />
                </span> </div>
            </div>
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
<script src="/js/matrix.js"></script>
<script>
  $(document).ready(function(){

    var msg_template = '<p><span class="msg-block"><strong></strong><span class="time"></span><span class="msg"></span></span></p>';

    $('.chat-message button').click(function(){
      var input = $(this).siblings('span').children('input[type=text]');
      if(input.val() != ''){
        add_message('我','img/demo/av1.jpg',input.val(),true);
      }
    });

    $('.chat-message input').keypress(function(e){
      if(e.which == 13) {
        if($(this).val() != ''){
          add_message('我','img/demo/av1.jpg',$(this).val(),true);
        }
      }
    });

    setTimeout(function(){
      add_message('柯振旭','img/demo/av2.jpg','你好，我的鸡发疯了')
    },'1000');
    setTimeout(function(){
      add_message('柯文涛','img/demo/av3.jpg','我们家的鸡磨蹭地面好痛苦')
    },'4000');
    setTimeout(function(){
      remove_user('柯振旭','柯振旭')
    },'16000');
    var i = 0;
    function add_message(name,img,msg,clear) {
      i = i + 1;
      var  inner = $('#chat-messages-inner');
      var time = new Date();
      var hours = time.getHours();
      var minutes = time.getMinutes();
      if(hours < 10) hours = '0' + hours;
      if(minutes < 10) minutes = '0' + minutes;
      var id = 'msg-'+i;
      var idname = name.replace(' ','-').toLowerCase();
      inner.append('<p id="'+id+'" class="user-'+idname+'">'
              +'<span class="msg-block"><img src="'+img+'" alt="" /><strong>'+name+'</strong> <span class="time">- '+hours+':'+minutes+'</span>'
              +'<span class="msg">'+msg+'</span></span></p>');
      $('#'+id).hide().fadeIn(800);
      if(clear) {
        $('.chat-message input').val('').focus();
      }
      $('#chat-messages').animate({ scrollTop: inner.height() },1000);
    }
    function remove_user(userid,name) {
      i = i + 1;
      $('.contact-list li#user-'+userid).addClass('offline').delay(1000).slideUp(800,function(){
        $(this).remove();
      });
      var  inner = $('#chat-messages-inner');
      var id = 'msg-'+i;
      inner.append('<p class="offline" id="'+id+'"><span>用户 '+name+' 着草了</span></p>');
      $('#'+id).hide().fadeIn(800);
    }
  });

</script>
</body>
</html>
