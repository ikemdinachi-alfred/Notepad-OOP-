package notepad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NotePadManagement {
    static Scanner sc = new Scanner(System.in);
  private static List<NotePad> notePads = new ArrayList<>();
  private static List<Entry> entries = new ArrayList<>();

  public static void register(){
    String firstName = input("Enter first name: ");
    String lastName = input("Enter last name: ");
    String email = input("Enter email: ");
    String password = input("Enter password: ");
    NotePad notePad = new NotePad(firstName, lastName, email, password);
    notePads.add(notePad);
      System.out.println("Registration successful.....");
      System.out.println(notePad);
      display();

  }

  public static void  makeEntry(){
    String email = input("Enter email: ");
    String password = input("Enter password: ");
    userVerification(email, password);
    String title = input("Enter title: ");
    String content= input("Enter content: ");
    Entry entry =  new Entry(title,content);
    entries.add(entry);
        System.out.println("entry added successfully");
        display();
    }

  private static void userVerification(String email, String password) {
      for (NotePad notePad : notePads) {
          if (!notePad.getEmail().equals(email) && notePad.getPassword().equals(password)) {
              System.out.println("You have entered the wrong details");
          }
      }
  }

     public static void display(){
          String in = input("""
            1 -> Register
            2 -> Make Entry
            3 -> Exit
            
            """);
          switch (in){
              case "1" -> register();
              case "2" -> makeEntry();
              case "3" -> System.out.println("bye_bye");
              default -> System.out.println("Invalid entry");
          }
      }

  private static String input(String userInput){
      System.out.println(userInput);
      return sc.nextLine();
  }

}
