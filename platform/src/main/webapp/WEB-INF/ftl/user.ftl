<#-- @ftlvariable name="user" type="cc.aisc.platform.commons.auth.user.entity.User" -->
<#include "tmpl/tmp1.ftl" />
<@htmlHead title="User Details">
</@htmlHead>
<@htmlBody projectName="ENY">
<h1>User Details</h1>
<p>E-mail: ${user.username}</p>
<p>Role: ${user.roleEnum}</p>
</@htmlBody>
