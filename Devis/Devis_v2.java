import java.*;

import javax.print.DocFlavor.STRING;

public class Devis_v2 {

  public static void afficher_text() {
    System.out.println("1: ajouter une ligne");
    System.out.println("2: Supprimer une ligne");
    System.out.println("3: ouvrir une nouvelle section");
    System.out.println("4: ouvrir une section existante");
    System.out.println("5: Afficher un apercu du devis");
    System.out.println("6: Editer le devis");
    System.out.println("7: Quitter sans editer");
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


  public static void showArrayWithDetailsClassesPrices(String[] arr, String[] arr2) {
    int i = 0;
    System.out.println("\n \n \n \n");
    // System.out.println("voici les lignes que vous avez le droit de supprimer");
    System.out.println("---------------------------------------");
    while (arr[i] != null) {
      System.out.print("ligne " + i + ": ");
      space_cals(arr[i].substring(1));
      System.out.println(arr2[i].substring(2));
      i++;
    }
    System.out.println("---------------------------------------");
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

  public static void if_one_then(String[] classes, String[] price, String names, int arrLen, double prix_double, int current_sec_index, String[] sections) {
    if (StringArrayLength(sections) == 0) {
      System.out.println("\nDesolé vous ne pouvez pas ajouter des classes sans sections");
      System.out.println("Appuyer sur 3 pour ajouter une section\n");
    }else{
      System.out.print("Ecrivez le nom de la ligne : ");
      names = Terminal.lireString();
      arrLen = StringArrayLength(classes);
      classes[arrLen] = (Integer.toString(current_sec_index)+names);
      System.out.print("Ecrivez le prix de la ligne : ");
      prix_double = Terminal.lireDouble();
      arrLen = StringArrayLength(price);
      price[arrLen] = (Integer.toString(current_sec_index)+":"+Double.toString(prix_double));
      // showArray(price);
      // showArray(classes);
    }
  }

  // public static String[] delete_classes(String[] classes, int num){
  //   String[] res = new String[100];
  //   int i = 0;
  //   while (classes[i] != null) {
  //     // System.out.println("the class being not supprimer : "+ classes[i]);
  //     if (classes[i] != classes[num]) {
  //       res[i] = classes[i];
  //     }
  //     i++;
  //   }
  //   showArray(res);
  //   return res;
  // }
  public static String[] delete_classes_price(String[] arr, int num){
    String[] res = new String[100];
    int i = 0;
    int j = 0;
    boolean f = true;
    while (arr[i] != null) {
      if (i != num) {
        res[j++] = arr[i];
       }
      i++;
    }
    return res;
  }

  // public static String[] delete_price(String[] price, int num){
  //   String[] res = new String[100];
  //   int i = 0;
  //   while (price[i] != null) {
  //     if (price[i] != price[num]) {
  //       res[i] = price[i];
  //     }
  //     i++;
  //   }
  //   showArray(res);
  //   return res;
  //
  // }

  // public static void if_two_then(String[] classes, String[] price, int num) {
  //   System.out.println("voici les lignes que vous avez le droit de supprimer");
  //   // int num = 0;
  //   showArrayWithDetails(classes);
  //   System.out.print("choisissez un numero : ");
  //   num = Terminal.lireInt();
  //   classes = delete_classes(classes, num);
  //   price = delete_price(price, num);
  //
  // //  return 0;
  // }

  public static void if_three_then(String names, int arrLen, String[] sections) {
    System.out.print("Ecrivez le nom de la section : ");
    names = Terminal.lireString();
    arrLen = StringArrayLength(sections);
    sections[arrLen] = names;
    //showArray(sections);
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
    j = 0;
    while (price[j] != null) {
      if (price[j].charAt(0) == customIntToChar(i)) {
        sum += Double.parseDouble(price[j].substring(2));
      }
      j++;
    }
    totals[i] = Double.toString(sum);
    i++;
  }

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



public static void showDevis(String[] classes, String[] price, String[] sections){
  int i, j, k, l;
  double sum = 0;
  boolean a = false;
  i = 0;
  j = 0;
  k = 0;
  l = 0;
  String[] totals = new String[100];
System.out.println("\n\n===============================================\n\n");

totals = price_total_per_section(price, sections);

  while(sections[i] != null){
    System.out.println(sections[i]);
      j = 0;
      while(classes[j] != null){
        if (classes[j].charAt(0) ==  customIntToChar(i) ) {
         System.out.print("     ");
         space_cals(classes[j].substring(1));
         System.out.println(price[j].substring(2));
        }
        j++;
      }
      System.out.println("---------------------------------------");
      System.out.println("Sous-Total :                  " + totals[i]);
      System.out.println("\n");

    i++;
  }
 sum = sum_total(totals);
 System.out.println("---------------------------------------");
 System.out.print("NET A PAYER ::                " + sum);
 System.out.println("\n\n==============================================");
} // show devis


public static int return_current_section_index(String[] sections, int current_sec_index, int loop_num){
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

  return current_sec_index;
}

public static void loop_that_contains_logic_of_function(String[] sections,String[] price, String[] classes, double prix_double, int loop_num, String names, boolean i, int arrLen, int current_sec_index){
  int num = 0;
  if_three_then(names, arrLen, sections);

      while (i != true) {
        current_sec_index = return_current_section_index(sections,current_sec_index, loop_num);
        afficher_text();
        System.out.print("put the number here : ");
        loop_num = Terminal.lireInt();
        System.out.println("it   : " + loop_num);
        if (loop_num == 1) {
          if_one_then(classes, price, names, arrLen, prix_double, current_sec_index, sections);
        } else if (loop_num == 2) {
          if(StringArrayLength(classes) == 0){
            System.out.println("\nDesolé vous ne pouvez pas supprimer des classes");
            System.out.println("Appuyer sur 1 pour ajouter une classe\n");
          }else{
            System.out.println("voici les lignes que vous avez le droit de supprimer");
          //  int num;
            showArrayWithDetailsClassesPrices(classes, price);
            System.out.print("choisissez un numero : ");
            num = Terminal.lireInt();
            classes = delete_classes_price(classes, num);
            price = delete_classes_price(price, num);
          }
        } else if (loop_num == 3) {
          if_three_then(names, arrLen, sections);
        }else if (loop_num == 5) {
          showDevis(classes, price, sections);
        } else if (loop_num == 6) {
          showDevis(classes, price, sections);
          // System.out.println("AU REVOIR à BIENTOT");
          i = true;
        } else if (loop_num == 7) {
          // System.out.println("c izi en (ELSE) : " + loop_num);
          i = true;
        }else if (loop_num == 8) {
          showArray(price);
          showArray(classes);
          showArray(sections);
        }
      }
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
    int current_sec_index = 0;
    loop_num = '5';

    loop_that_contains_logic_of_function(sections, price, classes, prix_double, loop_num, names, i, arrLen, current_sec_index);
  }// MAIN

}
