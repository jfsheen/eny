<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="cc.aisc.platform.commons.auth.dto.RoleDto" -->
<#include "tmpl/tmp1.ftl" />
<@htmlHead title="Create a new user">
</@htmlHead>
<@htmlBody projectName="ENY">
<h1>Create a new ROLE</h1>
<form role="form" name="form" action="" method="post">
<#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
    <div>
        <label for="rolename">Role name</label>
        <input type="text" name="role" id="rolename" value="${form.rolename}" required autofocus/>
    </div>
    <div>
        <label for="role">Role</label>

    </div>
    <button type="submit">Create</button>
</form>

    <@spring.bind "form" />
    <#if spring.status.error>
    <ul>
        <#list spring.status.errorMessages as error>
            <li>${error}</li>
        </#list>
    </ul>
    </#if>
</@htmlBody>