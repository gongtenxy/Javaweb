<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 <%@page import="Dao.teacher" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
     <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
     <script>
        $(function(){
        	$("a").click(function(){
        		var $trObj=$(this).parent().parent();
    			var id=$trObj.find("td:first").text();
        		if(confirm("你确定投给["+id+"]吗？")){
        			window.location.href="/Vote/addvote?id="+id
        		}
        	})
        })
        
        function jump(){
               window.location.href="/Vote/addteacher.jsp";
         }
     </script>
</head>
<body>

  <table border="1" align="center">
  <tr>
    <td>编号：</td>
    <td>姓名：</td>
    <td>票数：</td>
    <td>投票:</td>
  </tr>
	<%teacher teach=new teacher();
	  ArrayList<teacher> al= new ArrayList<teacher>();
	  al=(ArrayList<teacher>)session.getAttribute("al");
	   for(int i=0;i<al.size();i++){
		   teach=al.get(i);
		  // System.out.println(teach);
	%>
     	<tr>
     	  <td><%=teach.getId()%></td>
     	  <td><%=teach.getName()%></td>
     	  <td id="vote"><%=teach.getNumber()%></td>
     	  <td><a>投票</a></td>
     	</tr>
      <% }%>

      <tr><td style="border:0" colspan="4" align="center"> 
      <button onclick=jump()>添加</button>
      </td>  
      </tr>
    </table> 
    
</body>
</html>