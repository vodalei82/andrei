import javax.management.relation.Role;

public class Usser {
   private String login;
  private   String pasword;
   private Role role;

   public Usser(String login,String pasword,Role role){
       this.login = login;
       this.pasword = pasword;
       this.role = role;

   }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasword(){return  pasword;}
    public  void setPasword(String pasword) {this.pasword = pasword;}

    public  Role getRole(){return  role;}
    public  void setRole(Role role){this.role = role;}


   @Override
    public String toString(){
       return "current user " + login;
   }



    }

