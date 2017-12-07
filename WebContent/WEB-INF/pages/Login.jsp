<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Login</title>
        <!-- Mobile specific metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <!-- Force IE9 to render in normal mode -->
        <!--[if IE]><meta http-equiv="x-ua-compatible" content="IE=9" /><![endif]-->
        <meta name="author" content="SuggeElson" />
        <meta name="description" content=""
        />
        <meta name="keywords" content=""
        />
        <meta name="application-name" content="sprFlat admin template" />
        <!-- Import google fonts - Heading first/ text second -->
        <!-- 
        <link rel='stylesheet' type='text/css' href='http://fonts.googleapis.com/css?family=Open+Sans:400,700|Droid+Sans:400,700' />
         -->
        <!--[if lt IE 9]>
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400" rel="stylesheet" type="text/css" />
<link href="http://fonts.googleapis.com/css?family=Open+Sans:700" rel="stylesheet" type="text/css" />
<link href="http://fonts.googleapis.com/css?family=Droid+Sans:400" rel="stylesheet" type="text/css" />
<link href="http://fonts.googleapis.com/css?family=Droid+Sans:700" rel="stylesheet" type="text/css" />
<![endif]-->
        <!-- Css files -->
        <c:url value="/resources/assets/css/icons.css" var="iconsCSS"/>
        <c:url value="/resources/assets/css/sprflat-theme/jquery.ui.all.css" var="jqueryUiAllCSS"/>
        <c:url value="/resources/assets/css/bootstrap.css" var="bootstrapCSS"/>
        <c:url value="/resources/assets/css/plugins.css" var="pluginsCSS"/>
        <c:url value="/resources/assets/css/main.css" var="mainCSS"/>
        <c:url value="/resources/assets/css/custom.css" var="customCSS"/>
        <c:url value="/resources/assets/img/ico/apple-touch-icon-144-precomposed.png" var="icon144IMG"/>
        <c:url value="/resources/assets/img/ico/apple-touch-icon-114-precomposed.png" var="icon114IMG"/>
        <c:url value="/resources/assets/img/ico/apple-touch-icon-72-precomposed.png" var="icon72IMG"/>
        <c:url value="/resources/assets/img/ico/apple-touch-icon-57-precomposed.png" var="icon57IMG"/>
        <c:url value="/resources/assets/img/ico/favicon.ico" var="faviconICO"/>
        <c:url value="/resources/assets/img/logo.gif" var="logoIMG"/>
        <!-- Icons -->
        <link href="${iconsCSS}" rel="stylesheet" type="text/css"/>
        <!-- jQueryUI -->
        <link href="${jqueryUiAllCSS}" rel="stylesheet" type="text/css"/>
        <!-- Bootstrap stylesheets (included template modifications) -->
        <link href="${bootstrapCSS}" rel="stylesheet" type="text/css"/>
        <!-- Plugins stylesheets (all plugin custom css) -->
        <link href="${pluginsCSS}" rel="stylesheet" type="text/css"/>
        <!-- Main stylesheets (template main css file) -->
        <link href="${mainCSS}" rel="stylesheet" type="text/css"/>
        <!-- Custom stylesheets ( Put your own changes here ) -->
        <link href="${customCSS}" rel="stylesheet" type="text/css"/>
        <!-- Fav and touch icons -->
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${icon144IMG}">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${icon114IMG}">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${icon72IMG}">
        <link rel="apple-touch-icon-precomposed" href="${icon57IMG}">
        <link rel="icon" href="${faviconICO}" type="image/png">
        <!-- Windows8 touch icon ( http://www.buildmypinnedsite.com/ )-->
        <meta name="msapplication-TileColor" content="#3399cc" />
    </head>
    <body class="login-page">
        <!-- Start #login -->
        <div id="login" class="animated bounceIn">
            <img id="logo" src="${logoIMG}"  width="210" height="50" alt="sprFlat Logo">
            <!-- Start .login-wrapper -->
            <div class="login-wrapper">
                <ul id="myTab" class="nav nav-tabs nav-justified bn">
                    <li>
                        <a href="#log-in" data-toggle="tab">Login</a>
                    </li>
                    <li class="">
                        <a href="#register" data-toggle="tab">Register</a>
                    </li>
                </ul>
                <div id="myTabContent" class="tab-content bn">
                    <div class="tab-pane fade active in" id="log-in">                     
                        <form id="loginForm" class="form-horizontal mt10" action="<c:url value='/Login' />" role="form" method="POST">                          
                            <div class="form-group">
                                <div class="col-lg-12">
                                    <input type="text" name="username" id="username" class="form-control left-icon"  placeholder="Your account ...">
                                    <i class="ec-user s16 left-input-icon"></i>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-12">
                                    <input type="password" name="password" id="password" class="form-control left-icon" placeholder="Your password">
                                    <i class="ec-locked s16 left-input-icon"></i>
                                    <span class="help-block"><a href="#"><small>Forgout password ?</small></a></span> 
                                </div>
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />  
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">                               
                            	<c:if test="${not empty error}">
                            		<div class="error" style="color:#FF0000">${error}</div>
                           		 </c:if>
                           		 <c:if test="${not empty msg}">
                            		<div class="msg">${msg}</div>
                           		 </c:if>				
                            </div>
                            <div class="form-group">
                                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                    <button class="btn btn-success pull-right" type="submit">Login</button>
                                </div>
                            </div>
                            
                        </form>
                    </div>
                    <div class="tab-pane fade" id="register">
                        <form class="form-horizontal mt20" action="#" id="register-form" role="form">
                            <div class="form-group">
                                <div class="col-lg-12">
                                    <!-- col-lg-12 start here -->
                                    <input id="email1" name="email" type="email" class="form-control left-icon" placeholder="Type your account">
                                    <i class="ec-mail s16 left-input-icon"></i> 
                                </div>
                                <!-- col-lg-12 end here -->
                            </div>
                            <div class="form-group">
                                <div class="col-lg-12">
                                    <!-- col-lg-12 start here -->
                                    <input type="password" class="form-control left-icon" id="password1" name="password" placeholder="Enter your password">
                                    <i class="ec-locked s16 left-input-icon"></i> 
                                </div>
                                <!-- col-lg-12 end here -->
                                <div class="col-lg-12 mt15">
                                    <!-- col-lg-12 start here -->
                                    <input type="password" class="form-control left-icon" id="confirm_password" name="confirm_passowrd" placeholder="Repeat password">
                                    <i class="ec-locked s16 left-input-icon"></i> 
                                </div>
                                <!-- col-lg-12 end here -->
                            </div>
                            <div class="form-group">
                                <div class="col-lg-12">
                                    <!-- col-lg-12 start here -->
                                    <button class="btn btn-success btn-block">Register</button>
                                </div>
                                <!-- col-lg-12 end here -->
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- End #.login-wrapper -->
        </div>
        <!-- End #login -->
        
        <c:url value="/resources/assets/plugins/core/pace/pace.min.js" var="paceJS"/>
        <c:url value="/resources/assets/js/jquery-1.8.3.min.js" var="jqueryJS"/>
        <c:url value="/resources/assets/js/libs/jquery-2.1.1.min.js" var="jqueryLibJS"/>
        <c:url value="/resources/js/bootstrap.js" var="bootstrapJS"/>
        <c:url value="/resources/assets/js/libs/jquery-ui-1.10.4.min.js" var="jqueryUiLibsJS"/>
        <c:url value="/resources/js/jquery.validate.min.js" var="jqueryValidate"/>
        <c:url value="/resources/js/offcanvas.js" var="offcanvas"/>
        <!-- Javascripts -->
        <script src="${paceJS}"></script>
        <!-- Important javascript libs(put in all pages) -->
        <script src="${jqueryJS}" type="text/javascript"></script>
        <script src="${bootstrapJS}" type="text/javascript"></script>
        <script src="${jqueryValidate}" type="text/javascript"></script>
        <script src="${offcanvas}" type="text/javascript"></script>
        <script>
        window.jQuery || document.write('<script src="${jqueryLibJS}">\x3C/script>')
        </script>
        <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
		<script>
        window.jQuery || document.write('<script src="${jqueryUiLibsJS}">\x3C/script>')
        </script>
     <%--    [if lt IE 9]>
        <c:url value="assets/js/libs/respond.min.js" var="respondJS"/>
        <script type="text/javascript" src="${paceJS}"></script>
        <script type="text/javascript" src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <script type="text/javascript" src="${respondJS}"></script>
    <![endif] --%>
        <script>
		$(document).ready(function(){
			$('#loginForm').validate();
		});
	</script>
	<c:if test="${not empty executeResult }">
		<script>alert('${executeResult}');</script>
	</c:if>
    </body>
</html>