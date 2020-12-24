<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<html>
  <head>
    <title>商品类别添加</title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="icon" href="back/img/favicon.ico" type="image/x-icon" />
	<script type="text/javascript" src="back/script/jquery.js"></script>
	<link rel="stylesheet" href="back/css/common.css" type="text/css"></link>
	<script type="text/javascript" src="back/script/common.js"></script>
	<style type="text/css">
		*{font: 12px tahoma, Arial, Verdana, sans-serif;}
		.brands label {
			width: 150px;
			display: block;
			float: left;
			padding-right: 6px;
		}
	</style>
	<script type="text/javascript">
		$(function(){
		    var canSubmit=true;
		    /**
			$("#inputForm").bind("submit",function(){
				var pid=$("#pid").val();
				if(!canSubmit){
					$.message("warn","请选择顶级或一级");
					return false;
				}
				return true;
			});

			*/


		    $("#inputForm").bind("submit",function () {

		    	$.ajax({
					type:"post",
					url:"category/save",
					data:$("#inputForm").serialize(),
					success:function(){
						alert()
					}
				})

				return false;
			})


			$("#sb").click(function(){
				$.ajax({
					cache:false,
					type:"post",
					data:$("#inputForm").serialize(),
					url:"/back/saveCategory",
					success:function(){
						$.message("success","添加成功");
					},
					error:function(){
						$.message("error","添加失败，请稍后重试");
					}
				});
			});
			$("#pid").change(function(){
				var index=$(this).context.selectedIndex;
				var option=$(this).find("option").eq(index);
				if($(option).attr("label")==2){
					canSubmit=false;
					$("#pidValue").val(null);
					$.message("warn","请选择顶级或一级");
				}else{
					canSubmit=true;
					$("#pidValue").val($(this).val());
				}
			});
		});
	</script>
  </head>
  <body>
    <div class="path">
		<a href="">首页</a>  » 添加商品分类
	</div>
	<form id="inputForm"  novalidate="novalidate">
		<table class="input">
			<tbody>
				<tr>
					<th>
						<span class="requiredField">*</span>名称:
					</th>
					<td>
						<input type="text"  name="name" class="text" maxlength="200">
					</td>
				</tr>
				<tr>
					<th>
					上级分类:
				</th>
				<td>
					<select name="parentId">
						<option value="">顶级分类</option>
					</select>
				</td>
				</tr>
				<tr>
					<th>&nbsp;</th>
					<td>
						<input type="submit" id="sb" class="button" value="确&nbsp;&nbsp;定">
						<input type="button" class="button" value="返&nbsp;&nbsp;回" onclick="history.go(-1)">
					</td>
				</tr>
		</tbody></table>
	</form>

  </body>


</html>
