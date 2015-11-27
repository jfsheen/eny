<#-- @ftlvariable name="users" type="java.util.List<cc.aisc.platform.auth.user.entity.User>" -->
<#import "/spring.ftl" as spring>
<#include "tmpl/tmp1.ftl" />
<@htmlHead title="User Details">
</@htmlHead>
<@htmlBody projectName="ENY">
<h1>List of Users</h1>
<table>
    <thead>
    <tr>
        <th>E-mail</th>
        <th>Role</th>
    </tr>
    </thead>
    <tbody>
        <#list users as user>
        <tr>
            <td><a href="/user/${user.id}">${user.email}</a></td>
            <td>${user.role}</td>
        </tr>
        </#list>
    </tbody>
</table>
</@htmlBody>