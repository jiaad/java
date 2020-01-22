import java.*;

import javax.print.DocFlavor.STRING;

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

  public static char customIntToChar(int n){
  //int a=1;
  char res;
  res = (char)(n+'0');
  return res;
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
    // System.out.println("voici les lignes que vous avez le droit de supprimer");
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
        System.out.print(", ");
      }
      i++;
    }
    System.out.print("]\n");

  }

  public static void if_one_then(String[] classes, String[] price, String names, int arrLen, double prix_double, int current_sec_index) {
    System.out.print("Ecrivez le nom de la ligne : ");
    names = Terminal.lireString();
    arrLen = StringArrayLength(classes);
    classes[arrLen] = (Integer.toString(current_sec_index)+names);
    System.out.print("Ecrivez le prix de la ligne : ");
    prix_double = Terminal.lireDouble();
    arrLen = StringArrayLength(price);
    price[arrLen] = (Integer.toString(current_sec_index)+":"+Double.toString(prix_double));
    showArray(price);
    showArray(classes);
  }

  public static String[] delete_classes(String[] classes, int num){
    String[] res = new String[100];
    int i = 0;
    while (classes[i] != null) {
      if (i != num) {
        res[i] = classes[i];
      }
      i++;
    }
    return res;
  }

  public static String[] delete_price(String[] price, int num){
    String[] res = new String[100];
    int i = 0;
    while (price[i] != null) {
      if (i != num) {
        res[i] = price[i];
      }
      i++;
    }
    return res;
  }

  // public static void if_two_then(String[] classes, String[] price) {
  //   int num;
  //   showArrayWithDetails(classes);
  //   System.out.print("choisissez un numero : ");
  //   num = Terminal.lireInt();
  //   classes = delete_classes(classes, num);
  //   price = delete_price(price, num);
  // }

  public static void if_three_then(String names, int arrLen, String[] sections) {
    System.out.print("Ecrivez le nom de la section : ");
    names = Terminal.lireString();
    arrLen = StringArrayLength(sections);
    sections[arrLen] = names;
    showArray(sections);
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



public static String[] price_total_per_section(String[] price, String[] sections){
//  String[] price = {"0:25.90","0:90.0", "1:89.9", "1:66.5" };
  String[] totals = new String[100];
  int i = 0;
  int j = 0;
  int len = 0;
  double sum = 0;
  int sec_len = StringArrayLength(sections);

  while (i < sec_len ) {//Sections
    sum = 0;

    // System.out.println("price is :::: " + price[i]);
    j = 0;
    while (price[j] != null) {
      // System.out.println("first char price is :::: " + price[j].charAt(0));

      if (price[j].charAt(0) == customIntToChar(i)) {
        sum += Double.parseDouble(price[j].substring(2));
        // System.out.println(" -- : " + price[j]);
        // System.out.println(" sum is -- : " + sum);
      }
      j++;
    }
    totals[i] = Double.toString(sum);
    // System.out.println("total is :: " + sum);

    i++;
  }
  // int m = 0;
  // while(totals[m] != null){
  // System.out.println("___ : "+ totals[m]);
  //   m++;
  // }
  return totals;
}

public static double sum_total(String[] totals){
  double res = 0;
  int i = 0;
  while(totals[i] != null){
   res += Double.parseDouble(totals[i]);
    i++;
  }
//  System.out.println("the total is " + res);
  return res;
}


public static void space_cals(String str){
  System.out.print(str);
  if (str.length() < 25) {
    for (int i = str.length() ; i < 25  ;i++ ) {
      System.out.print(" ");
    }
  }

  // System.out.println();
}

public static void showDevis(String[] classes, String[] price, String[] sections){
  int i, j, k, l;
  double sum = 0;
  boolean a = false;
  i = 0;
  j = 0;
  k = 0;
  l = 0;
  String[] totals = new String[100];
System.out.println("\n\n ==============================================\n\n");

totals = price_total_per_section(price, sections);

  while(sections[i] != null){
    System.out.println("Sections " + i + ": " + sections[i]);

      j = 0;

      while(classes[j] != null){
        if (classes[j].charAt(0) ==  customIntToChar(i) ) {
          // System.out.println("     " + classes[j].substring(1) + "     " + price[j].substring(2));

         System.out.print("     ");
         space_cals(classes[j].substring(1));
         System.out.println(price[j].substring(2));

        }
        j++;
      }
      System.out.println("---------------------------------------");
      System.out.println("Sous-Total : " + totals[i]);
      System.out.println("\n");

    i++;
  }

 sum = sum_total(totals);
 System.out.println("---------------------------------------");
 System.out.println("the sum is ::  " + sum);

  System.out.println("\n\n ==============================================");

} // show devis


  public static void main(String[] args) {
    String[] sections = new String[100];
    String[] price = new String[100];
    String[] classes = new String[100];
    double prix_double = 0;
    int loop_num;
    String names = "";
    boolean i = false;
    int arrLen = 0;
    int current_sec_index = 0;
//    String[] totals = new String[100];
    loop_num = '5';
    // if_three_then(names, arrLen, sections);

    while (i != true) {
      // afficher_text();

      if (StringArrayLength(sections) == 1) {
        current_sec_index = 0;
      }else if (loop_num == 4) {
        System.out.println("voici la liste des sections : ");
        showArrayWithDetails(sections);
        System.out.print("choisissez une section :  ");
        loop_num = Terminal.lireInt();
        current_sec_index = loop_num;
      }else{
        current_sec_index = StringArrayLength(sections) - 1;
      }
      afficher_text();
      System.out.print("put the number here : ");
      loop_num = Terminal.lireInt();
      System.out.println("it   : " + loop_num);
      if (loop_num == 1) {
        if_one_then(classes, price, names, arrLen, prix_double, current_sec_index);
      } else if (loop_num == 2) {
        System.out.println("voici les lignes que vous avez le droit de supprimer");
        int num;
        showArrayWithDetails(classes);
        System.out.print("choisissez un numero : ");
        num = Terminal.lireInt();
        classes = delete_classes(classes, num);
        price = delete_price(price, num);

      } else if (loop_num == 3) {
        if_three_then(names, arrLen, sections);
      // } else if (loop_num == 4) {
      //   System.out.println("voici la liste des sections : ");
      //   showArrayWithDetails(sections);
      //   System.out.print("choisissez une section :  ");
      //   loop_num = Terminal.lireInt();
      //   current_sec_index = loop_num;
      } else if (loop_num == 5) {
        //price_total_per_section(price, sections);
        showDevis(classes, price, sections);
      } else if (loop_num == 6) {
        // i = true;
        //System.out.println("c ici en (IF): " + loop_num);
        showDevis(classes, price, sections);
        System.out.println("AU REVOIR à BIENTOT");
        i = true;
      } else if (loop_num == 7) {
        System.out.println("c izi en (ELSE) : " + loop_num);
        i = true;
        //afficher_text();
        // loop_num = "6";

      }else if (loop_num == 8) {
        showArray(price);
        showArray(classes);
        showArray(sections);
      }
    }

    showArray(price);
    showArray(classes);
    showArray(sections);

  }// MAIN

}
