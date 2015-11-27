<#macro htmlHead title charset="utf-8" lang="zh-CN">
<#-- @ftlvariable name="currentUser" type="cc.aisc.platform.auth.currentuser.CurrentUser" -->
    <#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${title}</title>
    <link href="../../../resources/static/js/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../../resources/static/js/ztree/3.5/zTreeStyle.css" rel="stylesheet">
    <link href="../../../resources/static/css/starter-template.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="../../../resources/static/js/html5shiv.min.js"></script>
    <script src="../../../resources/static/js/respond.min.js"></script>
    <![endif]-->
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.4.min.js"></script>
    <script src="../../../resources/static/js/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="../../../resources/static/js/ie10-viewport-bug-workaround.js"></script>
    <script src="../../../resources/static/js/ztree/3.5/jquery.ztree.core-3.5.min.js"></script>
    <#nested>
</head>
</#macro>
<#macro htmlBody projectName>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">${projectName}</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav" role="navigation">
                <li<#-- class="active"-->><a href="/">Home</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">AGRICOLA<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/agricola/list/1">AGRICOLA list</a></li>
                        <li role="separator" class="divider"></li>
                        <li class="dropdown-header">CREATE</li>
                        <li><a href="/agricola/create">AGRICOLA create</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">COMPANY<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/factory/list/1">FACTORY list</a></li>
                        <li role="separator" class="divider"></li>
                        <li class="dropdown-header">Nav header</li>
                        <li><a href="#">Separated link</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">CATEGORY<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/category/list/1">CATEGORY list</a></li>
                        <li role="separator" class="divider"></li>
                        <li class="dropdown-header">CREATE</li>
                        <li><a href="/category/create">CATEGORY create</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">TRAIT<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/trait/list/1">TRAIT list</a></li>
                        <li role="separator" class="divider"></li>
                        <li class="dropdown-header">CREATE</li>
                        <li><a href="/trait/create">TRAIT create</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav pull-right" role="navigation">
                <#if currentUser??>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${currentUser.user.email} <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/user/${currentUser.id}">Details</a></li>
                            <li><a href="/user/${currentUser.id}">Manage</a></li>
                            <li role="separator" class="divider"></li>
                            <li><form id="formLogout" action="/logout" method="post">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </form>
                                <a href="#" onclick="document.getElementById('formLogout').submit();">Log out</a>
                            </li>
                            <li class="dropdown-header">Nav header</li>
                            <li><a href="#">Separated link</a></li>
                        </ul>
                    </li>
                <#else>
                    <li><a href="/login">Login</a></li>
                    <li><a href="/user/create">Sign in</a></li>
                </#if>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<div class="container">
    <div class="starter-template">
        <#nested>
    </div>
</div><!-- /.container -->
</body>
</html>
</#macro>