<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<form id="Login" name="Login" action="/first/sample/openSampleBoardList.do" >
 <table border="1">
  <tr>
   <td>ID :</td>
   <td><input type="text" id="IdText" name="IdText" size="50" /></td>
  </tr>
  <tr>
   <td>PW :</td>
   <td><input type="password" id="PwText" name="PwText" size="50" /></td>
  </tr>
  <tr>
   <td colspan="2" align="center">
   <input type="button" id="Ok" name="Ok" value="로그인" onclick="Logsubmit();" />  
   </td>
  </tr>   
 </table>
 
</form>
</body>

<script type="text/javascript">
 function Logsubmit(){
  var formId=document.Login;
  if (formId.IdText.value==''){    //아이디 적는 텍스트박스에 공백 또는 null값확인
   alert("아이디를 입력하세요.");  //null값이면 알럿창을 띄움
   formId.IdText.focus();      // 확인을 누르면 커서를 아이디 텍스트박스에 위치
   return;          
  }
  
  if (formId.PwText.value==''){       //비밀번호적는 텍스트박스에 공백 또는 null값 확인
   alert("비밀번호를 입력하세요.");  //null값이면 알럿창 
   formId.PwText.focus();            // 확인을 누르면 커서를 패스워드에 위치
   return;          
  }
  if (formId.PwText.value!==formId.IdText.value){       //비밀번호적는 텍스트박스에 공백 또는 null값 확인
   alert("비밀번호가 틀렸습니다.");  //null값이면 알럿창 
   formId.PwText.focus();            // 확인을 누르면 커서를 패스워드에 위치
   return;          
  }
  if (formId.PwText.value==formId.IdText.value){       //비밀번호적는 텍스트박스에 공백 또는 null값 확인
	  formId.submit();         
   }  
	  



 }
</script>
</html> 
