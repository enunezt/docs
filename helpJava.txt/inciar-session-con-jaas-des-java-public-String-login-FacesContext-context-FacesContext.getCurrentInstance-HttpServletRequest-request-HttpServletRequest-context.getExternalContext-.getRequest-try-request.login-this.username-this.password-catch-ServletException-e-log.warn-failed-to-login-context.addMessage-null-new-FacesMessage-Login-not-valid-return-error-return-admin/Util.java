// inciar session con jaas des java
public String login () {
FacesContext context = FacesContext.getCurrentInstance();
HttpServletRequest request = (HttpServletRequest)
context.getExternalContext().getRequest();
try {
request.login(this.username, this.password);
} catch (ServletException e) {
log.warn("failed to login");
context.addMessage(null, new FacesMessage("Login not valid"));
return "error";
}
return "admin/salery";
}

