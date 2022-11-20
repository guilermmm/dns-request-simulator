import model.dns.ClientDNS;
import model.dns.ServerDNS;

public class App {
  public static void main(String[] args) throws Exception {
    ServerDNS.init(100);
    ClientDNS.init();
  }
}
