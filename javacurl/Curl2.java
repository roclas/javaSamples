import java.io.*;
import java.net.*;

import java.net.URLConnection;
public class Curl2 {

  public static void main(String[] args) {
      System.setProperty("http.proxyHost", "my.proxy");
      System.setProperty("http.proxyPort", "3128");
      Authenticator.setDefault(new Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication("user","pass".toCharArray());
        }
       });
      URL p;
      try {
          p = new URL("http://my.service.com/merchants/f765e629d57125756a8bf85e7f9aa97169ea7741/merchant.json");
          URLConnection conn = p.openConnection();
          BufferedReader in = new BufferedReader(
                              new InputStreamReader(conn.getInputStream()));
          String line = null;
          while ((line = in.readLine()) != null) {
              System.out.println(line);
          }
      } catch (IOException e) {
          e.printStackTrace();
      }
  }

}
