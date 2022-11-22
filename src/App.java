import model.dns.ClientDNS;
import model.dns.ServerDNS;

public class App {
  public static void main(String[] args) throws Exception {
    ServerDNS.init("src/sites.txt");
    ClientDNS.init();
  }
}
