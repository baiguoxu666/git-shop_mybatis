<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>管理中心</title>
			
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">


	<link rel="icon" href="${pageContext.request.contextPath}/back/img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/common.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/login.css" type="text/css"></link>
	<script type="text/javascript" src="${pageContext.request.contextPath}/back/script/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/back/script/common.js"></script>
	<script type="text/javascript">

		$(function(){

			var username=decodeURI("${cookie.username.value}","utf-8")
			$("#name").val(username)
			//点击更换验证码：
			$("#captchaImage").click(function(){//点击更换验证码
				$(this).prop("src","/shop/user/image?date="+new Date().getTime())
			});
			
			//  form 表单提交
			$("#loginForm").bind("submit",function(){

				$.ajax({
					type:"POST",
					url:"/shop/user/login",
					data:$("#loginForm").serialize(),
					dataType:"json",
					success:function (re) {

						if(re.success){
							$.message("success","登录成功")
							setTimeout(function () {
								location.href="/shop/back/index.html"
							},3000)

						}else {
							$.message("error",re.message)
						}
					}
				})
				return false;
			});
			
		});
	</script>
</head>
<body>
	
		<div class="login">
			<form id="loginForm" action="${pageContext.request.contextPath}/back/index.html" method="post" >
				
				<table>
					<tbody>
						<tr>
							<td width="190" rowspan="2" align="center" valign="bottom">
								<img src="img/header_logo.gif" alt="购物"/>
							</td>
							<th>
								用户名:
							</th>
							<td>
								<input type="text"  name="name" value="${cookie.username.value}" class="text"  maxlength="20"/>
							</td>
					  </tr>
					  <tr>
							<th>
								密&nbsp;&nbsp;&nbsp;码:
							</th>
							<td>
								<input type="password" name="password" class="text"  maxlength="20" autocomplete="off"/>
							</td>
					  </tr>
					
						<tr>
							<td>&nbsp;</td>
							<th>验证码:</th>
							<td>
								<input type="text" id="enCode" name="enCode" class="text captcha" maxlength="4" autocomplete="off"/>
								<img id="captchaImage" class="captchaImage" src="/shop/user/image" title="点击更换验证码"/>
							</td>
						</tr>					
					<tr>
						<td>
							&nbsp;
						</td>
						<th>
							&nbsp;
						</th>
						<td>
							<label>
								<input type="checkbox" checked="checked" id="isRememberUsername" name="isRememberUsername" value="true"/> 记住用户名
							</label>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<th>&nbsp;</th>
						<td>
							<input type="button" class="homeButton" value="" onclick="location.href='/'"><input type="submit" class="loginButton" value="登录">
						</td>
					</tr>
				</tbody></table>
				<div class="powered">COPYRIGHT © 2005-2013.</div>
				<div class="link">
					<a href="${pageContext.request.contextPath}/front/">前台首页</a> |
					<a href="">官方网站</a> |
					<a href="">交流论坛</a> |
					<a href="">关于我们</a> |
					<a href="">联系我们</a> |
					<a href="">授权查询</a>
				</div>
			</form>
		</div>
</body>
</html>