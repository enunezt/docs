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

public void logout() {
  ExternalContext ctx = 
      FacesContext.getCurrentInstance().getExternalContext();
  String ctxPath = 
      ((ServletContext) ctx.getContext()).getContextPath();

  try {
    // Usar el contexto de JSF para invalidar la sesión,
    // NO EL DE SERVLETS (nada de HttpServletRequest)
    ((HttpSession) ctx.getSession(false)).invalidate();

    // Redirección de nuevo con el contexto de JSF,
    // si se usa una HttpServletResponse fallará.
    // Sin embargo, como ya está fuera del ciclo de vida 
    // de JSF se debe usar la ruta completa -_-U
    ctx.redirect(ctxPath + "/faces/index.xhtml");
  } catch (IOException ex) {
    ex.printStackTrace();
  }
}

