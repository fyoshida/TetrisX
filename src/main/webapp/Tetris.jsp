<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ page import="java.util.LinkedList"%>
<%@ page import="model.*"%>

<%
	// Sessionからステージ、ブロックを取得
	Stage stage = (Stage) session.getAttribute("Stage");
	Block block = (Block) session.getAttribute("Block");
%>

<!doctype html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="1; URL=BlockDownServlet">
</head>
<body>
	<center>
		<table border="0" bordercolor="#000000">
			<%
				for (int y = 19; y >= 0; y--) {
			%>
			<TR>
				<%
					for (int x = 0; x < 10; x++) {
						int type = stage.getType(x, y);
						for(int i=0;i<block.getCellSize();i++){
							int cx = block.getCellX(i);
							int cy = block.getCellY(i);
							if(x == cx && y == cy){
								type = block.getType();
							}
						}
						String color = getColor(type);
				%>
				<td width="30" height="30" bgcolor="<%= color %>"></td>
				<%
					}
				%>
			<tr/>
			<%
				}
			%>
		</table>

		<form method="post" action="PlayServlet">
			<table>
				<tr>
					<td><input type="submit" name="Left" value="←" style ="width:100px;height:50px" /></td>
					<td><input type="submit" name="Turn" value="回転" style ="width:100px;height:50px" /></td>
					<td><input type="submit" name="Right" value="→"  style ="width:100px;height:50px" /></td>
				</tr>
				<tr>
					<td></td>
					<td align="center"><input type="submit" name="Down" value="↓" style ="width:100px;height:50px" /></td>
					<td></td>
				</tr>
			</table>
		</form>
		<a href="InitServlet"><font size="7">はじめから</font></a>
		<hr>
	</center>
</body>
</html>

<%!
	String getColor(int type) {
		if (type == 1) {
			return "BLUE";
		}
		if (type == 2) {
			return "RED";
		}
		if (type == 3) {
			return "CYAN";
		}
		if (type == 4) {
			return "ORANGE";
		}
		if (type == 5) {
			return "PINK";
		}
		if (type == 6) {
			return "MAGENTA";
		}
		return "BLACK";
	}
%>
