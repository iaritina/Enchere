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
<% ArrayList<Enchere> enchere=(ArrayList<Enchere>) request.getAttribute("enchere") ;%>

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
                <h1> Liste des enchères</h1>

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
                    <table  border="1" class="table table-hover" style="text-align:center">
                        <thead>
                        <tr>
                            <th>Id Enchère</th>
                            <th>Catégorie</th>
                            <th>Produit</th>
                            <th>Propriétaire</th>
                            <th>Date de mise</th>
                            <th>Description</th>
                            <th>Date de cloture</th>
                        </tr>
                        </thead>
                        <tbody  class="table-border-bottom-0">
                        <% for(int e=0;e<enchere.size();e++){
                            Enchere ench=enchere.get(e);
                        %>
                        <tr>
                            <td><%= ench.getIdenchere()%></td>
                            <td><%= ench.getCategorie().getDesignation()%></td>
                            <td><%= ench.getProduit()%></td>
                            <td><%= ench.getUser().getPrenom()+" "+ ench.getUser().getNom()%> </td>
                            <td><%= ench.getDateMise()%></td>
                            <td><%= ench.getDescription()%></td>
                            <td><%= ench.getFin()%></td>
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
