
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>


<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<!-- 新 Bootstrap 核心 CSS 文件 -->
		<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet" />

		<!-- 可选的Bootstrap主题文件（一般不使用） -->

		<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.css" rel="stylesheet" />
		<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
		<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.js"></script>

		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
		<title></title>
		<style type="text/css" media="screen">
			#pagination-digg li {
				border: 0;
				margin: 0;
				padding: 0;
				font-size: 11px;
				list-style: none;
				/* savers */
				float: left;
			}
			
			#pagination-digg a {
				border: solid 1px #9aafe5;
				margin-right: 2px;
			}
			
			#pagination-digg .previous-off,
			#pagination-digg .next-off {
				border: solid 1px #DEDEDE;
				color: #888888;
				display: block;
				float: left;
				font-weight: bold;
				margin-right: 2px;
				padding: 3px 4px;
			}
			
			#pagination-digg .next a,
			#pagination-digg .previous a {
				font-weight: bold;
			}
			
			#pagination-digg .active {
				background: #2e6ab1;
				color: #FFFFFF;
				font-weight: bold;
				display: block;
				float: left;
				padding: 4px 6px;
				/* savers */
				margin-right: 2px;
			}
			
			#pagination-digg a:link,
			#pagination-digg a:visited {
				color: #0e509e;
				display: block;
				float: left;
				padding: 3px 6px;
				text-decoration: none;
			}
			
			#pagination-digg a:hover {
				border: solid 1px #0e509e;
			}
			
			body {
				font-family: Arial, Helvetica, sans-serif;
				font-size: 12px;
			}
			
			h2 {
				clear: both;
				border: 0;
				margin: 0;
				padding-top: 30px;
				font-size: 13px;
			}
			
			p {
				border: 0;
				margin: 0;
				padding: 0;
				padding-bottom: 20px;
			}
			
			ul {
				border: 0;
				margin: 0;
				padding: 0;
			}

		</style>


	</head>

	<body>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">
					<h3>
				欢迎你:${user.user_name}
			</h3>
					<shiro:hasAnyRoles name="员工,经理">
					<button id="qiandao" class="btn btn-block btn-info" type="button"><a href="../add.do">签到</a></button>
					</shiro:hasAnyRoles>

					<table class="table table-bordered">
						<thead>
							<tr>
								<th>
									员工
								</th>
								<th>
									打卡时间
								</th>
								<th>
									状态
								</th>
								<th>
								</th>
							</tr>
						</thead>
						<tbody>
						<%--	<tr>
								<td>
									TB - Monthly
								</td>
								<td>
									01/04/2012
								</td>
								<td>
									迟到
								</td>
								<td>
									<a href="http://delete">删除</a>
								</td>
							</tr>
							<tr class="success">
								<td>
									TB - Monthly
								</td>
								<td>
									01/04/2012
								</td>
								<td>
									未打卡
								</td>
								<td>
									<a href="http://delete">删除</a>
								</td>
							</tr>
							<tr class="error">
								<td>
									TB - Monthly
								</td>
								<td>
									02/04/2012
								</td>
								<td>
									正常打卡
								</td>
								<td>
									<a href="http://delete">删除</a>
								</td>
							</tr>
							<tr class="warning">
								<td>
									TB - Monthly
								</td>
								<td>
									03/04/2012
								</td>
								<td>
									Pending
								</td>
								<td>
									<a href="http://delete">删除</a>
								</td>
							</tr>
							<tr class="info">
								<td>
									TB - Monthly
								</td>
								<td>
									04/04/2012
								</td>
								<td>
									Call in to confirm
								</td>
								<td>
									<a href="http://delete">删除</a>
								</td>
							</tr>
						</tbody>--%>
						<c:forEach items="${list}" var="it">

						<tr class="info">
							<td>
								${it.user_name}
							</td>
							<td>
								${it.q_time}
							</td>
							<td>
								${it.state}
							</td>
							<td>
								<shiro:hasRole name="root">
								<a href="delete.do?qid=${it.qid}">删除</a>
								</shiro:hasRole>
							</td>
						</tr>
						</c:forEach>
					</table>

				</div>
<ul id="pagination-digg">
    <li class="previous-off">&laquo;Previous</li>
      <li class="active">1</li>
      <li><a href="">2</a></li>
      <li><a href="">3</a></li>
      <li><a href="">4</a></li>
      <li><a href="">5</a></li>
      <li><a href="">6</a></li>
      <li><a href="">7</a></li>
      <li class="next"><a href="">Next &raquo;</a></li>
  </ul>
			</div>
		</div>

	</body>

</html>