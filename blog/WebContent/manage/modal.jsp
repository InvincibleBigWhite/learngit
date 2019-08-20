<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="bootstrap.min.css"/>
<script src="../js/jquery-1.9.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<title>模态框</title>
</head>
<body>
	<!-- 模态框（Modal） -->
<div id="static" class="modal hide fade" tabindex="-1" data-backdrop="static" data-keyboard="false" data-width="960">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
			
				<h4 class="modal-title" id="myModalLabel">
					模态框（Modal）标题
				</h4>
			</div>
			<form action="updateTextServlet" method="get">
			<div class="modal-body">
				
					<input id="a" name="textName" placeholder="请输入文章标题"/>
					<input type="submit"/>
				
			</div>
			
			<div class="modal-boyd">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary">
					提交更改
				</button>
			</div>
			</form>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
</body>
</html>