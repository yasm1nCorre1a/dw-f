<%-- 
    Document   : sexo
    Created on : 13/09/2018, 23:21:36
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

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
            <h1 id="textoCabecalho" class="fa-4x"> Floricultura Pedacinho do Céu </h1>
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
                        Cliente 
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <table id="customers" width="200%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                            <thead>
                                <tr>
                                    <th>Id Cliente</th>
                                    <th>Nome </th>
                                    
                                    <th>Telefone</th>
                                    <th>Celular</th>
                                    <th>E-mail</th>
                                    <th>Endereço </th>
                                    <th>Cidade</th>
                                    <th>Cep</th>
                                    <th>Bairro</th>
                                    <th>Sexo</th>
                                </tr>
                            </thead>
                            <tbody> <!--JSTL-->
                                <jsp:useBean id="dao" class="DAOs.DAOCliente"/>
                                <c:forEach var="t" items="${dao.listInOrderIdCliente()}">
                                    <tr> 
                                        <td>${t.getIdCliente()}</td>
                                        <td>${t.getNomeCliente()}</td>
                                        <td>${t.getTelefone()}</td>
                                        <td>${t.getCelular()}</td>
                                        <td>${t.getEMail()}</td>
                                        <td>${t.getEndereco()}</td>
                                        <td>${t.getCidade()}</td>
                                        <td>${t.getCep()}</td>
                                        <td>${t.getBairro()}</td>
                                        <td>${t.getSexoIdSexo()}</td>
                                    </tr>    
                                </c:forEach>
                            </tbody>
                        </table>
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
