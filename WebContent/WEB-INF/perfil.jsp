<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="modelo.cliente"%>

<!DOCTYPE html>
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<%		
		cliente cli= (cliente)session.getAttribute("datos");
HttpSession sesion=request.getSession(); 
		
		
	%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
    <div class="row">
<br>
<br>
    	<div class="span3 well">
       
        <a href="#aboutModal" data-toggle="modal"><img src="/DeportesIsmael/DecodificarImagen?correo=<%=cli.getCorreo() %>" name="aboutme" width="140" height="140" class="img-circle"></a>
         <h3><%=cli.getNombre()%></h3>
         <h4><%=cli.getApell() %></h4>
         <em>Email <%=cli.getCorreo() %></em>
         <p>ID de cliente=<%=cli.getString_cliente() %><br><a target="_blank" href="http://bootsnipp.com/TXTCLASS/snippets/25zz">Eliminar cuenta</a></p>
         <p><a href="/Blossomb/index">Ir a Inicio</a></p>
         <p><%out.print("<p><button class='tn btn-primary'><a class='color' href='subir?email="+cli.getCorreo()+"'>Cambiar imagen de perfil</a></button>"); %></p>
		
            <div class="modal hide" id="aboutModal">
			    <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal">✕</button>
			        <h3>About Joe</h3>
			    </div>
			        <div class="modal-body" style="text-align:center;">
			        <div class="row-fluid">
			            <div class="span10 offset1">
			                <div id="modalTab">
			                    <div class="tab-content">
			                        <div class="tab-pane active" id="about">
    <a><img src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRbezqZpEuwGSvitKy3wrwnth5kysKdRqBW54cAszm_wiutku3R" name="aboutme" width="140" height="140" border="0" class="img-circle"></a>
      <h3 class="media-heading">Joe Sixpack <small> USA</small></h3>
                <span><strong>Skills: </strong></span>
                <span class="label label-warning"></span>
                <span class="label label-info">Adobe CS 5.5</span>
                <span class="label label-info">Microsoft Office</span>
                <span class="label label-success">Windows XP, Vista, 7</span>
   
    <hr>
   
    <p class="text-left"><strong>Bio: </strong><br>
     Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut sem dui, tempor sit amet commodo a, vulputate vel tellus.</p>
      <br>
     
      </div>
	</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</body>
</html>