<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>	

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>������</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<meta http-equiv="imagetoolbar" content="no" />
<!-- <link href="/Web//cartAction/css/contents.css" rel="stylesheet" type="text/css" /> -->
<link href="/Web/cartAction/css/default.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/Web//cartAction/js/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="/Web//cartAction/js/design.js">
</script>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
<script>
   
</script>
</head>
<body>

	<div id="wrap">
	

		<div id="sub_container">
			<div id="contentsWrap" class="sub_con5">
				<div class="board_form">   
		            <div class="con_title">
		               <p>��ٱ��� ����Ʈ</p>   
		            </div>
					<div class="contents">
					
					<div class="btnSet clfix mgb15">
						<span class="fr"> <span class="button"><a href="/web/clientList.do">���</a></span>
						</span>
					</div>

					<table class="bbsWrite mgb35">
						<caption></caption>
						<colgroup>
							<col width="95" />
							<col width="395" />
							<col width="95" />
							<col />
						</colgroup>
						<tbody>
							<tr>
								<th>��ü��</th>
								<td><select style="border:1px solid #ddd; height:20px; width:200px;">
										<option>�����ϼ���</option>
								</select></td>
								<th>��ǰ��</th>
								<td><input type="text" name="" class="" size="30" style="border:1px solid #ddd; height:20px;"/>
									<span class="button"><a href="#">�˻�</a></span></td>
							</tr>
						</tbody>
					</table>
							<table class="bbsList">
								<colgroup>
									<col width="80" />
									<col width="170" />
									<col width="170" />
									<col width="170" />
									<col width="170" />
									<col width="170" />
									<col width="170" />
									<col width="170" />
								</colgroup>
								<thead>								
								
									<tr>
										<th scope="col">NO.</th>																				
										<th scope="col">��ǰ��</th>
										<th scope="col">�̹���</th>
										<th scope="col">������</th>
										<th scope="col">����</th>
										<th scope="col">����</th>
										<th scope="col">��¥</th>
										<th scope="col">����</th>									
									</tr>
								</thead>
								<tbody>
								
									<tr>
									   
										<td></td>
										<td></td>
										<td>
										<a href="#"><img src="/web/upload/" width="50" height="50"></img></a></td>
										<td></td>
										<td>
										
										
										</td>
										<td></td>
										<td></td>
										<td>
										<span class="buttonFuc"><a href="#">����</a>
										</span>
										<span class="buttonFuc">
										
										<a href="/web/cartDelete.do?pk">����</a></span>
										</td>										
									</tr>									
								</tbody>
							</table>
							<table class="bbsList" align="right">
							<tr align="right">
								<th align="right">���հ� &nbsp; <input type="text" name="total" id="total" class="inputText" size="30"  align="right" value="0"/></th>
								</tr>	
							</table>	
						</div>
					</div>
					</div>
				</div>
   	
   </div>
	
</body>
</html>