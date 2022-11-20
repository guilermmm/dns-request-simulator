package model.dns;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import model.table.MyHashTable;
import terminal.Terminal;
import terminal.Terminal.Color;

public class ServerDNS {
  static MyHashTable<String, String> hashTable;
  static Timer timer;
  static int timerCount;
  static Scanner fileScanner;
  static Scanner userScanner;

  public static void init(int size) throws FileNotFoundException {
    File file = new File("src/sites.txt");
    timer = new Timer();
    fileScanner = new Scanner(file);
    userScanner = new Scanner(System.in);
    hashTable = new MyHashTable<>(size);

    timer.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        if (fileScanner.hasNextLine()) {
          insertSites();
        } else {
          timer.cancel();
        }
      }
    }, 0, 10000);

  }

  static void insertSites() {
    for (int i = 0; i < 25; i++) {
      if (fileScanner.hasNextLine()) {
        String[] line = fileScanner.nextLine().split("\t");
        hashTable.insert(line[0], line[1]);
        Terminal.println(Color.YELLOW, "Inserted " + line[0] + " " + line[1]);
      }
    }
  }

  public static void search(String key) {
    String value = hashTable.search(key);

    if (value == null) {
      Terminal.println(Color.RED, "Not found " + key);
    } else {
      Terminal.println(Color.GREEN, "Found " + key + "!\n" + "IP: " + value);
    }
  }
}
