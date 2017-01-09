<%@page import="daomain.Publish"%>
<%@page import="dao.AuthorDao"%>
<%@page import="daomain.Author"%>
<%@page import="dao.PublishDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
	PublishDao publishDao = new PublishDao();
	List<Publish> publishs = publishDao.getAll();
	
	AuthorDao authorDao = new AuthorDao();
	List<Author> authors = authorDao.getAll();
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>图书管理-增加图书</title>
     <link rel="stylesheet" type="text/css" href="css/main.css">
	<style type="text/css">
		table select{
			width:200px;
		}
		
		.head_color{
			background:  #DDDDFF;
		}
	
	</style>
	<script type="text/javascript">
	//fromSel: 源选择框， toSel:目标选择框
	function moveitem(fromSel, toSel) {
		var fromOpts = fromSel.options; //源选择项列表数组
		var toOpts = toSel.options;  //目标选择项列表数组
		var idx = 0; //当前索引
		var toLen = toOpts.length; // 目标选择框已有的项数
		//遍历所有的源选择项列表数组
		for(var i=fromOpts.length-1; i>=0; i--) {
			if(fromOpts[i].selected){ //如果选中
				toOpts[toLen+idx] = new Option(fromOpts[i].text, fromOpts[i].value);//添加到目标选择框中
				fromOpts[i] = null; //删除源选择框中的选中项
				idx++;
			}
		}
	}
	
		//表单提交
		function checkForm(myform) {
			var authorOpts = myform.authorIds.options;
			if(authorOpts != null) {
			
				for(var i=0; i<authorOpts.length; i++) {
					authorOpts[i].selected = true;
				}
			}
			
			if(myform.isbn.value == "") {
				alert('isbn必须输入！');
				myform.isbn.focus();
				return false;
			}
			if(myform.title.value == "") {
				alert('书名必须输入！');
				myform.title.focus();
				return false;
			}
			if(myform.publisherId.value == "") {
				alert('出版社必须选择！');
				myform.publisherId.focus();
				return false;
			}
			var price = parseFloat(myform.price.value);
			if(isNaN(price)){
				alert('价格必须为数字！');
				myform.price.focus();
				return false;
			}
			var copyright = myform.copyright.value;
			if(copyright.length != 4 || isNaN(parseInt(copyright))){
				alert('出版年份必须为4位数字!');
				myform.copyright.focus();
				return false;
			}
			var editionNumber = parseInt(myform.editionNumber.value);
			if(isNaN(editionNumber)) {
				alert('版本号必须为数字！');
				myform.editionNumber.focus();
				return false;
			}
			
			return true;
		}
		
		function checkIsbn() {
			if(form1.isbn.value == "") {
				alert('请先输入ISBN');
				form1.isbn.focus();
				return;
			}
			
			window.open('books/checkIsbn.jsp?isbn='+form1.isbn.value, 'checkwin', 'width=500,height=400,scrollbar=yes,resizable=no,status=yes' );
		}
	</script>
  </head>
  
  <body>
  	<%@include file="/inc/head.jsp" %>
   
	 <br />
	<form  action="books/do_addBook.jsp" method="post" name="form1" onsubmit="return checkForm(this)">
		<table align="center" width="980">
			<caption>增加图书</caption>
			<tr>
				<td width="250" class="head_color">图书的ISBN</td>
				<td width="730">
					<input type="text" size="30" name="isbn">*
					<input type="button" value="检查ISBN是否存在" onclick="checkIsbn()">
				</td>
			</tr>
			<tr>
				<td class="head_color">书名</td>
				<td>
					<input type="text" name="title">*
				</td>
			</tr>
			<tr>
				<td class="head_color">出版社</td>
				<td>
					<select name="publishId">
						<option>
							请选择...
						</option>
						<%
						for(Publish publish : publishs) {
						%>
						<option value="<%=publish.getPublisherID()%>">
							<%=publish.getPublisherNam() %>
						</option>
						<%
						}
						%>
					</select>
				<td>
			</tr>
			<tr>
				<td class="head_color">价格</td>
				<td>
					<input type="text" name="price">*
				</td>
			</tr>
			<tr>
				<td class="head_color">出版年份</td>
				<td>
					<input type="text" name="copyright">*
				</td>
			</tr>
			<tr>
				<td class="head_color">版本号</td>
				<td>
					<input type="text" name="editionNumber">
				</td>
			</tr>
			<tr>
				<td class="head_color">作者</td>
				<td>
				<table>
					<tr>
						<td>
							<select name="allauthors" multiple="multiple" size="8">
								<%
								for(Author author : authors) {
								%>
								<option value="<%=author.getAuthorID()%>">
									<%=author.getFirstName()%>
									&nbsp;
									<%=author.getLastName()%>
								</option>
								<%
								}
								%>
							</select>
						</td>
						<td>
							<input type="button" value="增加>>"
								onclick="javascript:moveitem(form1.allauthors, form1.authorIds);">
							<br>
							<input type="button" value="<<删除"
								onclick="javascript:moveitem( form1.authorIds, form1.allauthors);">
						</td>
						<td>
							<select name="authorIds" multiple="multiple" size="8">
							</select>
						</td>
					</tr>
				</table>
			</tr>
			<tr>
				<td colspan="2" align="center" class="head_color">
					<input type="submit" value="增加">
					<input type="reset" value="清空">
				</td>
			</tr>
		</table>
	</form>
  </body>
</html>