<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
	<h1>index.jsp</h1>
	<div style="border: 1px black solid;">
		<form id="indexFormId" action="${pageContext.request.contextPath}/GetFileServlet" method="post" enctype="multipart/form-data">
			<input id="indexFile" name="indexFile" type="file" />
			<br />
			<br />
			<input type="submit" />
			<br />
			<br />
			<input type="button" id="test1" value="test1" />
		</form>
	</div>
	<script type="text/javascript">
        let test1Obj = document.getElementById('test1');
        test1Obj.addEventListener('click', function() {
            console.log('form表單submit');
            let formIdObj = document.getElementById('indexFormId');
            formIdObj.submit();
        });
    </script>
</body>
</html>