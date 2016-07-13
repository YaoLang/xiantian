
$(function(){
	var loginSubmit=true;
	var registerSubmit=true;
	//验证登陆账号
	var $user_name=$(".user_name");
	var $name_error=$("#name_error");

	$user_name.blur(function(){
		if($user_name.val()==""){

			$name_error.text("账号不能为空！").slideDown(500);
			loginSubmit=false;
		}else{
			$name_error.slideUp(500);
			loginSubmit=true;
		}

	});
	
	//验证登陆密码
	var $user_password=$(".user_password");
	var $psd_error=$("#psd_error");
	$user_password.blur(function(){
		checkpsd($user_password,$psd_error);
	});
	
	//验证邮箱函数
	var $email=$(".user_email");
	function checkEmail(){
		var $email_error=$("#email_error");
		var parten=/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
		if($email.val()==""){
			$email_error.text("邮箱不能为空！").slideDown(500);
			return false;
		}else if(!$email.val().match(parten)){
			$email_error.text("邮箱格式不正确！").slideDown(500);
			return false;
		}else{
			$email_error.slideUp(500);
			return true;
//			alert("邮箱正确");
		}
	}
	//验证邮箱
	$email.blur(function(){
		checkEmail();
	});
	
	//验证密码函数
	function checkpsd($psd,$psd_error){
		var parten=/^\w+$/;//密码只能由数字、字母或下划线组成
		if($psd.val()==""){
			$psd_error.text("密码不能为空！").slideDown(500);
			return false;
		}else if(!$psd.val().match(parten)){
			$psd_error.text("密码只能由数字、字母或下划线组成").slideDown(500);
			return false;
		}else{
			$psd_error.slideUp(500);
			return true;
		}
	}
	
	//验证注册密码
	var $psd1=$(".user_psd");
	var $psd1_error=$("#psd1_error");
	var $psd2=$(".user_againpsd");
	var $psd2_error=$("#psd2_error");
	$psd1.blur(function(){
		checkpsd($psd1,$psd1_error);
	})
	$psd2.blur(function(){
		checkpsd($psd2,$psd2_error);
		if($psd1.val()!=$psd2.val()){
			$psd2_error.text("与第一次密码不一致").slideDown(500);
		}
	})

	$(".register-btn").click(function(){
		checkEmail();
		checkpsd($psd1,$psd1_error);
		checkpsd($psd2,$psd2_error);
		if($psd1.val()!=$psd2.val()){
			$psd2_error.text("与第一次密码不一致").slideDown(500);
		}
		return false;
	})
})
