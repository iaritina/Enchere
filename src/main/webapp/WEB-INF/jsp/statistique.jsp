<%--
  Created by IntelliJ IDEA.
  User: Mathieu
  Date: 14/01/2023
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*"%>
<%@ page import="publics.model.*"%>
<% Enchere bestSale=(Enchere) request.getAttribute("bestSale") ;%>
<% ArrayList<NbrCategorie> cat=(ArrayList<NbrCategorie>) request.getAttribute("categorie") ;%>
<% int nbr=(int) request.getAttribute("nombreVente") ;%>


<html>
<head>
    <title>Enchère</title>
    <%@ include file="header.jsp" %>
</head>
<nav
        class="layout-navbar container-xxl navbar navbar-expand-xl navbar-detached align-items-center bg-navbar-theme"
        id="layout-navbar"
>
    <div class="layout-menu-toggle navbar-nav align-items-xl-center me-3 me-xl-0 d-xl-none">
        <a class="nav-item nav-link px-0 me-xl-4" href="javascript:void(0)">
            <i class="bx bx-menu bx-sm"></i>
        </a>
    </div>

    <div class="navbar-nav-right d-flex align-items-center" id="navbar-collapse">
        <!-- Search -->
        <div class="navbar-nav align-items-center">
            <div class="nav-item d-flex align-items-center">
                <h1>Statistiques</h1>

                <!-- /Search -->


                </ul>
            </div>
</nav>

<div class="content-wrapper">
    <!-- Content -->

    <div class="container-xxl flex-grow-1 container-p-y">
        <div class="col-md-12" >
            <div class="card">
                <div class="card-body">
                    <strong>Nombre de vente total : </strong><%= nbr%> ventes
                <br>
                <br>
                    <h5>Meilleur enchère: </h5>
                    <table  border="1" class="table table-hover" style="text-align:center">
                        <thead>
                        <tr>
                            <th>Categorie</th>
                            <th>Produit</th>
                            <th>Propriétaire d'origine</th>
                        </tr>
                        </thead>
                        <tbody  class="table-border-bottom-0">

                        <tr>
                            <td><%= bestSale.getCategorie().getDesignation()%></td>
                            <td><%= bestSale.getProduit()%></td>
                            <td><%= bestSale.getUser().getPrenom()%> <%= bestSale.getUser().getNom()%></td>
                        </tr>
                        </tbody>
                    </table>
                </br>
                <h5>Nombre d'enchère par catégorie:</h5>
                    <table  border="1" class="table table-hover" style="text-align:center">
                        <thead>
                        <tr>
                            <th>Catégorie</th>
                            <th>nombre d'enchère</th>
                        </tr>
                        </thead>
                        <tbody  class="table-border-bottom-0">
                        <% for(int e=0;e<cat.size();e++){
                            NbrCategorie c=cat.get(e);
                        %>
                        <tr>
                            <td><%= c.getDesignation()%></td>
                            <td><%= c.getCount()%></td>
                        </tr>
                        <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
