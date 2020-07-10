<%@ page pageEncoding="utf-8"%>
<!-- 引入JSTL标签库 -->
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<title>新增订单</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<style type="text/css">
	body{ font-family: "微软雅黑"; background-color: #EDEDED; }
	h2{ text-align: center;font-size:26px; }
	table{ margin: 30px auto; text-align: center; border-collapse:collapse; width:50%; }
	td, th{ padding: 5px;font-size:18px;}
	hr{ margin-bottom:20px; border:1px solid #aaa; }
	input,select,textarea{ width:284px; height:30px; background:#EDEDED; border:1px solid #999; text-indent:5px; font-size:18px; }
	input[type='submit']{ width:130px; height:36px; cursor:pointer; border-radius:5px 5px 5px 5px; background:#ddd; }
	select{text-indent:0px;}
	textarea{height:100px;font-size:22px;}
</style>
</head>
<body><!-- body-start  -->

<h2>新增订单</h2>
<hr/>
<form action="orderAdd" method="POST">
	<table border="1">
		<tr>
			<td width="30%">所属门店</td>
			<td>
				<input type="text" name="door_id" value="1"/>
			</td>
		</tr>
		<tr>
			<td>订单编号</td>
			<td>
				<input type="text" name="order_no"/>
			</td>
		</tr>
		<tr>
			<td>订单类型</td>
			<td>
				<input type="text" name="order_type"
						value=""/>
			</td>
		</tr>
		<tr>
			<td>用餐人数</td>
			<td>
				<input type="text" name="pnum"
						value=""/>
			</td>
		</tr>
		<tr>
			<td>收银员</td>
			<td>
				<input type="text" name="cashier"/>
			</td>
		</tr>
		<tr>
			<td>订单时间</td>
			<td>
				<input type="text" format="yyyy-MM-dd HH:mm:ss" name="order_time"/>
			</td>
		</tr>
		<tr>
			<td>支付时间</td>
			<td>
				<input type="text" format="yyyy-MM-dd HH:mm:ss" name="pay_time"/>
			</td>
		</tr>
		<tr>
			<td>支付方式</td>
			<td>
				<input type="text" name="pay_type"
						value=""/>
				
			</td>
		</tr>
		<tr>
			<td>支付金额</td>
			<td>
				<input type="text" name="price"/>
				
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="提 	交"/>
			</td>
		</tr>
	</table>
</form>

</body><!-- body-end  -->
</html>



