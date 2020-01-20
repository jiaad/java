import java.*;

public class Devis {

  public static void afficher_text() {
    System.out.println("1: ajouter une ligne");
    System.out.println("2: Supprimer une ligne");
    System.out.println("3: ouvrir une nouvelle section");
    System.out.println("4: ouvrir une section existante");
    System.out.println("5: Afficher un apercu du devis");
    System.out.println("6: Editer le devis");
    System.out.println("7: Quitter sans editer");
  }

  public static int StringArrayLength(String[] arr) {
    int len = 0;
    int i = 0;
    while (arr[i] != null)
      i++;
    len = i;
    return len;
  }

  public static void showArrayWithDetails(String[] arr) {
    int i = 0;
    System.out.println("\n \n \n \n");
    System.out.println("voici les lignes que vous avez le droit de supprimer");
    System.out.println("-----------------------------");
    while (arr[i] != null) {
      System.out.println("ligne " + i + ": " + arr[i]);
      i++;
    }
    System.out.println("-----------------------------");
    System.out.println("\n \n \n \n");

  }

  public static void showArray(String[] arr) {
    int i = 0;
    System.out.print("[");

    while (arr[i] != null) {
      System.out.print(arr[i]);
      if (i != '0' || i != 0) {
        System.out.print(",");
      }
      i++;
    }
    System.out.print("]\n");

  }

  public static void if_one_then(String[] classes, String[] price, String names, int arrLen, double prix_double) {
    System.out.print("Ecrivez le nom de la ligne : ");
    names = Terminal.lireString();
    arrLen = StringArrayLength(classes);
    classes[arrLen] = names;
    System.out.print("Ecrivez le prix de la ligne : ");
    prix_double = Terminal.lireDouble();
    arrLen = StringArrayLength(price);
    price[arrLen] = Double.toString(prix_double);
    showArray(price);
    showArray(classes);
  }

  public static String[] addX(int n, String arr[], String x) {
    int i;

    // create a new array of size n+1
    String newarr[] = new String[n + 1];

    // insert the elements from
    // the old array into the new array
    // insert all elements till n
    // then insert x at n+1
    for (i = 0; i < n; i++)
      newarr[i] = arr[i];

    newarr[n] = x;

    return newarr;
  }

  public static void main(String[] args) {
    String[] sections = new String[100];
    String[] price = new String[100];
    String[] classes = new String[100];
    double prix_double = 0;
    int loop_num;
    String names = "";
    boolean i = false;
    int arrLen = 0;
    loop_num = '5';
    while (i != true) {
      afficher_text();
      System.out.print("put the number here : ");
      loop_num = Terminal.lireInt();
      System.out.println("it is : " + loop_num);

      if (loop_num == 1) {
        // System.out.print("Ecrivez le nom de la ligne : ");
        // names = Terminal.lireString();
        // arrLen = StringArrayLength(classes);
        // classes[arrLen] = names;
        // System.out.print("Ecrivez le prix de la ligne : ");
        // prix_double = Terminal.lireDouble();
        // arrLen = StringArrayLength(price);
        // price[arrLen] = Double.toString(prix_double);
        // showArray(price);
        // showArray(classes);
        // if_one_then(classes, price, names, arrLen, prix_double);
        if_one_then(classes, price, names, arrLen, prix_double);

      } else if (loop_num == 2) {
        showArrayWithDetails(classes);
      } else if (loop_num == 3) {
        System.out.print("Ecrivez le nom de la section : ");
        names = Terminal.lireString();
        arrLen = StringArrayLength(sections);
        sections[arrLen] = names;
        showArray(sections);
      } else if (loop_num == 4) {

      } else if (loop_num == 5) {

      } else if (loop_num == 6) {
        // i = true;
        System.out.println("c ici en (IF): " + loop_num);

      } else if (loop_num == 7) {
        System.out.println("c izi en (ELSE) : " + loop_num);
        i = true;
        afficher_text();
        // loop_num = "6";

      }
    }

         showArray(price);
        showArray(classes);
  }// MAIN

}
