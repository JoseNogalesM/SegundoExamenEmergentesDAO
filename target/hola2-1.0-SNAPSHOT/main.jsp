<%
    String opcion = request.getParameter("opcion");
    %> 

<ul class="nav">
  <li class="nav-item">
      <a class="nav-link <%=(opcion.equals("libros")? "active":"")%>" aria-current="page" href="libros.jsp">Libros</a>
  </li>
  <li class="nav-item">
      <a class="nav-link" href="categorias.jsp">Categorias</a>
  </li>
 
   <li class="nav-item">
    <a class="nav-item" href="#">Nuevo</a>
  </li>
</ul>