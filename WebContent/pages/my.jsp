<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<HTML>
<HEAD>
<TITLE>北京出租房</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">

<link href="style/mycss.css" rel="stylesheet" type="text/css" />
<link href="style/texts.css" rel="stylesheet" type="text/css" />
<link href="style/btn.css" rel="stylesheet" type="text/css" />

</HEAD>
<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0>

<table width="780" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td colspan="5"><img src="images/top.jpg" width="780" height="170"></td>
  </tr>
  <tr>
    <td colspan="5"><img src="images/middle1.jpg" width="780" height="47"></td>
  </tr>
  <tr>
    <td width="38" background="images/middle2.jpg">&nbsp;</td>
    <td width="172" valign="top">

<script language="javascript">
<!--
	function login(){
		if( document.myForm.uname.value =="" ){
			alert("用户名不能为空");
			return false;
		}else if(document.myForm.upass.value == ""){
			alert("密码不能为空");
			return false;
		} else {
			return true;
		}
	}
-->
</script>

	<table align="center">
	<tr>
		<td width=''><font color='red'>当前用户：

			一度</font>
		</td>
	</tr>
	<tr>
		<td width='150'><a href="my.jsp">管理我的租房信息</a></td>
	</tr>
	<tr>
		<td width='100'><a href="post.jsp">发布租房信息</a></td>
	</tr>
	<tr>
		<td width='100'><a href="login.jsp">返回首页</a></td>
	</tr>
	<tr>
		<td width='100'><a href="index.jsp">[注销]</a></td>
	</tr>
	</table>
</td>
    <td width="35" background="images/layout_24.gif">&nbsp;</td>
    <td width="495">
	<table>
		<tr>
			<td width="3%">&nbsp;</td>
			<td width="97%">
			
			
			<table width='450' border='0'>
				<tr>
					<TD>标题</TD>
					<TD width='100' align='center'>月租金</TD>
					<TD width='110'align='center'>发布日期</TD>
					<TD width='50'>&nbsp;</TD>
					<TD width='50'>&nbsp;</TD>
				</tr>
				<tr>
					<td colspan='5'><hr/></td>
				</tr>
				
				<c:forEach items="${sessionScope.RENMESS_DATA}" var="renmess" varStatus="row">
					<tr>
						<td><a href='../selectRenmessOnea?rmid=${renmess.rmId}'>${renmess.tiTle}</a></td>
						<td align='center' style='height:30px;'>${renmess.reNtal}元</td>
						<td align='center'>${renmess.creTime}</td>
						<td align='center' style='height:30px;'><a href='../deleteRenmessa?rmid=${renmess.rmId}'>[删除]</a></td>
						<td align='center' style='height:30px;'><a href='../selectRenmessOneas?rmid=${renmess.rmId}'>[修改]</a></td>
					</tr>
				</c:forEach>
				
				<tr>
					<td colspan='5'><hr/></td>
				</tr>
			</table>
			
			</td>
		</tr>
		<tr>
			<td colspan="2"></td>
		</tr>
	</table>
	</td>
    <td width="40" background="images/middle4.jpg">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="5"><img src="images/bottom.jpg" width="780" height="82"></td>
  </tr>
</table>
<P align="center">一度教育 版权所有</P>
<br/>
</BODY>
</HTML>