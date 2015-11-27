<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="_r" type="cc.aisc.platform.eny.company.entity.Factory" -->
<#include "tmpl/tmp1.ftl" />
<@htmlHead title="Create a new CATEGORY">
</@htmlHead>
<@htmlBody projectName="ENY">
<#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
<h1>List of Category</h1>
<table class="table-bordered">
    <thead>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>PARENTID</th>
        <th>LEVLE</th>
        <th>DESCRIPTION</th>
    </tr>
    </thead>
    <tbody>
        <#if _rs??>
            <#list _rs as _r>
            <tr>
                <td>${_r.id}</td>
                <td>${_r.name}</td>
                <td>
                    <#if _r.parent??>
                    ${_r.parent.id?default()}
                    <#else>root
                    </#if>
                </td>
                <td>${_r.level?default("0")}</td>
                <td>${_r.description}</td>
            </tr>
            </#list>
        </#if>
    </tbody>
</table>
</@htmlBody>