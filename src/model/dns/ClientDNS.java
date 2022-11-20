package model.dns;

import java.util.Scanner;

public class ClientDNS {
  static Scanner sc;
  static boolean up;

  public static void init() {
    sc = new Scanner(System.in);

    while (up) {
      String key = sc.nextLine();
      ServerDNS.search(key);
    }
  }
}
