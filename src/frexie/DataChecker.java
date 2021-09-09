
package frexie;

public class DataChecker {
    
  public static boolean verifyUser(String email,String password)
 { 
     for(int i=0;i<FileLoader.users.size();i++)
     {
         if(email.equalsIgnoreCase(FileLoader.users.get(i).getEmail()) && password.equals(FileLoader.users.get(i).getPassword()))
         {
             Controller.currentUsername=FileLoader.users.get(i).getUserName();
             Controller.currentUser=FileLoader.users.get(i);
             Controller.gender=FileLoader.users.get(i).getGender();
             Controller.status=FileLoader.users.get(i).getStatus();
             return true;
         }
     }
     return false;
 }
    
   public static boolean confirmPassword(String password,String confirmPassword)
   {if(password.equals(confirmPassword))return true;return false;}
   


public static boolean isUsedUsername(String username)
{
 for(int i=0;i<FileLoader.users.size();i++)
 {
     if(username.equalsIgnoreCase(FileLoader.users.get(i).getUserName()))
     return true;
     
 }
 return false;
}


public static boolean isUsedEmail(String username)
{
 for(int i=0;i<FileLoader.users.size();i++)
 {
     if(username.equalsIgnoreCase(FileLoader.users.get(i).getEmail()))
     return true;
     
 }
 return false;
}

public static boolean checkUser(String username)
{
    for(int i=0;i<FileLoader.users.size();i++)
    {
        if(!FileLoader.users.get(i).getUserName().equalsIgnoreCase(Controller.currentUser.getUserName()) && FileLoader.users.get(i).getUserName().equalsIgnoreCase(username) )
            return false;
        
    }
    
    return true;
}

}