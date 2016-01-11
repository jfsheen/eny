<#-- @ftlvariable name="_r" type="java.util.List<cc.aisc.platform.commons.auth.user.entity.User>" -->
<#import "/spring.ftl" as spring>
<#include "tmpl/tmp1.ftl" />
<@htmlHead title="User Details">
</@htmlHead>
<@htmlBody projectName="ENY">
<h1>List of Users</h1>
<table class="table table-hover">
    <thead>
    <tr>
        <th>#</th>
        <th>NAME</th>
        <th>USERNAME</th>
        <th>EMAIL</th>
        <th>ROLE</th>
    </tr>
    </thead>
    <tbody>
        <#if _rs??>
            <#list _rs as _r>
            <tr>
                <td>${_r.id}</td>
                <td><a href="/user/${_r.id}">
                    <#if _r.person??>
                    ${_r.person.username?default("user'S name")}
                    </#if>
                </a></td>
                <td>${_r.username?default("username")}</td>
                <td>${_r.email}</td>
                <td>${_r.roleEnum}</td>
            </tr>
            </#list>
        </#if>
    </tbody>
</table>
</@htmlBody>