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
<% ArrayList<Categorie> categorie=(ArrayList<Categorie>) request.getAttribute("categorie") ;%>

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
                <h1> Liste des catégories</h1>

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
                    <div class="col-md-6" style="margin-left:200px">
                        <div class="card mb-4">
                            <div class="card-body">
                                <form action="categories" method="post">
                                    <label for="defaultFormControlInput" class="form-label">Nouvelle catégorie</label>
                                    <input type="text" name="designation" class="form-control" id="defaultFormControlInput">
                                    <br>
                                    <input type="submit" value="Ajouter" class="btn rounded-pill btn-success">
                                </form>
                            </div>
                        </div>
                    </div>
                    <table  border="1" class="table table-hover" style="text-align:center">
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Désignation</th>
                        </tr>
                        </thead>
                        <tbody  class="table-border-bottom-0">
                        <% for(int e=0;e<categorie.size();e++){
                            Categorie ench=categorie.get(e);
                        %>
                        <tr>
                            <td><%= ench.getIdcategorie()%></td>
                            <td><%= ench.getDesignation()%></td>
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
