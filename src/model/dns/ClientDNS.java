package model.dns;

import java.util.Scanner;

public class ClientDNS {
  static Scanner sc;

  public static void init() {
    sc = new Scanner(System.in);

    while (true) {
      String key = sc.nextLine();
      ServerDNS.search(key);
    }
  }
}
