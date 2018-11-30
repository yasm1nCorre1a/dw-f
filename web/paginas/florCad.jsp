<%-- 
    Document   : florCad
    Created on : 13/09/2018, 22:49:06
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entidades.Tipo"%>
<%@page import="java.util.List"%>
<%@page import="DAOs.DAOTipo"%>

<%
    DAOTipo daoTipo = new DAOTipo();
    List<Tipo> tipo = daoTipo.listInOrderIdTipo();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


        <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <link href="../vendor/cabecalho.css" rel="stylesheet" type="text/css">

        <!-- Morris Charts CSS -->
        <link href="../vendor/morrisjs/morris.css" rel="stylesheet">

        <link href="../Estilos/arrumaMenuTabela.css" rel="stylesheet">



        <title>JSP Page</title>
    </head>
    <body>
        <div id="cabecalho">
            <h1 id="textoCabecalho" class="fa-4x"> Floricultura Pedacinho do Céu  </h1>
        </div>
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">

                <ul class="nav" id="side-menu">

                    <li>
                        <a><i class="fa fa-4x fa-fw"></i> Menu</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Floricultura <span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="menu.jsp">Menu Inicial</a></li>
                            <li><a href="flor.jsp">Flor</a></li>
                            <li><a href="florCad.jsp">Cadastro Flor</a></li>
                            <li><a href="cliente.jsp">Cliente</a></li>
                            <li><a href="clienteCad.jsp">Cadastro Cliente</a></li>
                            <li><a href="tipo.jsp">Tipo</a></li>
                            <li><a href="tipoCad.jsp">Cadastro Tipo</a></li>
                            <li><a href="sexo.jsp">Sexo</a></li>
                            <li><a href="sexoCad.jsp">Cadastro Sexo</a></li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                </ul>
            </div>
            <!-- /.sidebar-collapse -->
        </div>

        <div class="row" id="help">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Cadastro Sexo 
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <form action="${pageContext.request.contextPath}/cadFlor"> 
                            <p> 
                            <div class="form-group">
                                <label >Id </label>
                                <% DAOs.DAOFlores dAOFlor = new DAOs.DAOFlores();%>
                                <input name="id_flor"class="form-control" placeholder="" value="<%=dAOFlor.autoIdFlores()%>" readonly="">
                            </div>

                            <div class="form-group">
                                <label > Nome </label>
                                <input name="nome_flor" class="form-control" placeholder="">
                            </div>
                            <div class="form-group">
                                <label > Quantidade </label>
                                <input name="quantidade_flor" class="form-control" placeholder="">
                            </div>
                            <div class="form-group">
                                <label > Preço  </label>
                                <input name="preco_flor" class="form-control" placeholder="">
                            </div>

                            <div class="form-group">
                                <label > Tipo  </label>
                                <select class="form-control" name="tipo_id_tipo">
                                    <option value="">SELECIONE</option>
                                    <%
                                        for (Tipo i : tipo) {
                                    %>
                                    <option value="<%=i.getIdTipo()%>"><%=i.getNomeTipo()%></option>
                                    <%}%>

                                </select>
                            </div>



                            <input type="submit" value="Enviar" />
                            </p>
                        </form>    
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>


        <!-- jQuery -->
        <script src="../vendor/jquery/jquery.min.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

        <!-- Metis Menu Plugin JavaScript -->
        <script src="../vendor/metisMenu/metisMenu.min.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="../dist/js/sb-admin-2.js"></script> 

        <!-- DataTables JavaScript -->
        <script src="../vendor/datatables/js/jquery.dataTables.min.js"></script>
        <script src="../vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
        <script src="../vendor/datatables-responsive/dataTables.responsive.js"></script>

        <!-- Page-Level Demo Scripts - Tables - Use for reference -->
        <script>
            $(document).ready(function () {
                $('#dataTables-example').DataTable({
                    responsive: true
                });
            });
        </script>
    </body>
</html>

