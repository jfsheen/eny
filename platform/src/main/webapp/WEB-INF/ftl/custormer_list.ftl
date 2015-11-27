<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="cc.aisc.platform.eny.customer.entity.Customer" -->
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
        <#if categories??>
            <#list categories as category>
            <tr>
                <td>${category.id}</td>
                <td>${category.name}</td>
                <td>
                    <#if category.parent??>
                    ${category.parent.id?default("")}
                    <#else>root
                    </#if>
                </td>
                <td>${category.level?default("0")}</td>
                <td>${category.description}</td>
            </tr>
            </#list>
        </#if>
    </tbody>
</table>
</@htmlBody>