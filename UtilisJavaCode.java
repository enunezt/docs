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


public class Hash {

    public static void main(String[] args) throws Exception{

       String password = args[0];

       MessageDigest md = MessageDigest.getInstance("SHA-256");

       byte[] passwordBytes = password.getBytes();

       byte[] hash = md.digest(passwordBytes);

       String passwordHash =

            Base64.getEncoder().encodeToString(hash);

       System.out.println("password hash: "+passwordHash);

}


if(ipMaquina == null || ipMaquina.equals("")){
			ipMaquina = getRequest().getHeader("x-forwarded-for"); 
			if(ipMaquina == null || ipMaquina.length() == 0 || "unknown".equalsIgnoreCase(ipMaquina)) { 
				ipMaquina = getRequest().getHeader("Proxy-Client-IP"); 
			} 
			if(ipMaquina == null || ipMaquina.length() == 0 || "unknown".equalsIgnoreCase(ipMaquina)) { 
				ipMaquina = getRequest().getHeader("WL-Proxy-Client-IP"); 
			} 
			if(ipMaquina == null || ipMaquina.length() == 0 || "unknown".equalsIgnoreCase(ipMaquina)) { 
				ipMaquina = getRequest().getRemoteAddr(); 
			} 
}
	
	
Subject subject = org.jboss.security.SecurityContextAssociation.getSubject();
        Optional<Group> rolesGroup = subject.getPrincipals(Group.class).stream().filter(p -> "Roles".equals(p.getName()))
                .findFirst();
        if (rolesGroup.isPresent()) {
            List<String> roleNames = Collections.list(rolesGroup.get().members()).stream().map(p -> p.getName())
                    .collect(Collectors.toList());
            // ...
        }
	
static Subject getSubject() { 
       if (System.getSecurityManager() == null) { 
           return SecurityContextAssociation.getSubject(); 
       } 
        
       return AccessController.doPrivileged(new PrivilegedAction<Subject>() {  
           public Subject run() { 
               return SecurityContextAssociation.getSubject(); 
           } 
       });         
   } 
	
//https://github.com/kwart/secured-webapp-template.git
