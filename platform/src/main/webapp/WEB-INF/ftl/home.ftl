<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="currentUser" type="cc.aisc.platform.auth.currentuser.CurrentUser" -->
<#include "tmpl/tmp1.ftl" />
<@htmlHead title="HOME">
</@htmlHead>
<@htmlBody projectName="ENY">
    <h1>Bootstrap starter template</h1>
    <h3>首页</h3>
    <p class="lead">Use this document as a way to quickly start any new project.<br> All you get is this text and a mostly barebones HTML document.</p>
    <#if currentUser?? && currentUser.role == "ADMIN">
    <ul>
        <li><a href="/users">View all users</a></li>
    </ul>
    </#if>
</@htmlBody>