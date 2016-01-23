<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="cc.aisc.platform.commons.auth.dto.UserDto" -->
<#include "tmpl/tmp1.ftl" />
<@htmlHead title="Create a new user">
</@htmlHead>
<@htmlBody projectName="ENY">
    <h1>Create a new user</h1>
    <form role="form" name="form" action="" method="post">
        <#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
        <div>
            <label for="username">User name</label>
            <input type="text" name="username" id="username" value="${form.username}" required autofocus/>
        </div>
        <div>
            <label for="password">Password</label>
            <input type="password" name="password" id="password" required/>
        </div>
        <div>
            <label for="passwordRepeated">Repeat</label>
            <input type="password" name="passwordRepeated" id="passwordRepeated" required/>
        </div>
        <div>
            <label for="role">Role</label>
            <select name="role" id="role" required>
                <option <#if form.roleEnum == 'USER'>selected</#if>>USER</option>
                <option <#if form.roleEnum == 'ADMIN'>selected</#if>>ADMIN</option>
            </select>
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