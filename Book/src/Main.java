import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.TreeSet;

/*Book isminde bir sınıf tasarlayınız.
Bu sınıf Comparable interface'den kalıtım alıp "compareTo" metodunu override ediniz.
 Bu metodun içinde kitabı A'dan Z'ye isme göre sıralayan kodu yazınız.
  Bu sınıftan 5 tane nesne oluşturun ve nesneleri Set tipinde bir yapısında saklayınız.
   Sonra ikinci kez Set tipinden bir veri yapısı kullanın ve
   kitapları sayfa sayısına göre sıralamasını sağlayınız.


Book sınıfı kitap ismi, sayfa sayısı, yazarın ismi, yayın tarihi değişkenlerinden oluşmaktadır.*/


public class Main {
    public static void main(String[] args) {



// 1. Kitap nesnesi
        Book kitap1 = new Book(1, "Beyaz Gemi", 200, "Cengiz Aytmatov","2009"); // Yayın tarihi: 6 Ağustos 2009

// 2. Kitap nesnesi
        Book kitap2 = new Book(2, "Sineklerin Tanrısı", 300, "William Golding",  "2019"); // Yayın tarihi: 1 Eylül 2019

// 3. Kitap nesnesi
        Book kitap3 = new Book(3, "Suç ve Ceza", 500, "Fyodor Dostoyevski",  "1899"); // Yayın tarihi: Ocak–Temmuz arası (1866)

//4. Kitabı nesnesi
        Book kitap4= new Book(4,"Kürk Mantolu Madonna ",250,"Sabahattin Ali ","1943");

//5. Kitabı nesnesi
        Book kitap5= new Book(5,"Ay Işığında Yasak Meyve ",150,"Sevim Burak ","1899");


        TreeSet<Book> b=new TreeSet<>();
        b.add(kitap1);
        b.add(kitap2);
        b.add(kitap3);
        b.add(kitap4);
        b.add(kitap5);
// İsme göre sırala
        System.out.println("Kitapların isme göre sıralanışı:--------------------");
        for(Book book:b){
            System.out.println(book.getName());
        }

        TreeSet<Book> bPage=new TreeSet<>(new PageComperator());
        bPage.add(kitap1);
        bPage.add(kitap2);
        bPage.add(kitap3);
        bPage.add(kitap4);
        bPage.add(kitap5);
//Page compare
        System.out.println("Kitapların sayfa sayısına  göre sıralanışı:-----------------------------");
        for(Book book:bPage){
            System.out.println(book.getName()+","+book.getPageNumber());
        }
    }
}