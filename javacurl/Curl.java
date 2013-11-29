import java.io.*;
public class Curl {

   public static void main(String[] args) {
       try {
           Process p = Runtime.getRuntime().exec("curl --user User:password http://myservice.com/merchants/f765e629d57125756a8bf85e7f9aa97169ea7741/merchant.json");
           BufferedReader in = new BufferedReader(
                               new InputStreamReader(p.getInputStream()));
           String line = null;
           while ((line = in.readLine()) != null) {
               System.out.println(line);
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

}
