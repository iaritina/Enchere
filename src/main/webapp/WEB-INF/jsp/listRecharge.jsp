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
<% ArrayList<Recharge> rh=(ArrayList<Recharge>) request.getAttribute("recharge") ;%>

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
                <h1> Liste des demandes de rechargement</h1>

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
                            <th>Id User</th>
                            <th>Nom</th>
                            <th>Prénom</th>
                            <th>Somme</th>
                            <th>Date</th>
                        </tr>
                        </thead>
                        <tbody  class="table-border-bottom-0">
                        <% for(int e=0;e<rh.size();e++){
                            Recharge recharge=rh.get(e);
                        %>
                        <tr>
                            <td><%= recharge.getUtilisateur().getIduser()%></td>
                            <td><%= recharge.getUtilisateur().getNom()%></td>
                            <td><%= recharge.getUtilisateur().getPrenom()%></td>
                            <td><%= recharge.getSomme()%></td>
                            <td><%= recharge.getPeriode()%></td>
                            <td>
                                <form action="soldes" method="post">
                                    <input type="hidden" value="<%=recharge.getIddm()%>" name="iddm">
                                    <input type="hidden" value="<%=recharge.getUtilisateur().getIduser()%>" name="iduser">
                                    <input type="hidden" value="<%=recharge.getSomme()%>" name="somme">
                                    <input type="submit" value="Valider" class="btn rounded-pill btn-success">
                                </form>
                            </td>
                            <td>
                                <form action="creditRefus" method="post">
                                    <input type="hidden" value="<%=recharge.getIddm()%>" name="iddm">
                                    <input type="hidden" value="<%=recharge.getUtilisateur().getIduser()%>" name="iduser">
                                    <input type="hidden" value="<%=recharge.getSomme()%>" name="somme">
                                    <input type="submit" value="Refuser" class="btn rounded-pill btn-danger">
                                </form>
                            </td>
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
