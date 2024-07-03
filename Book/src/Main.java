import java.util.*;

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
        Book kitap5= new Book(5,"Ay Işığında Yasak Meyve ",1500,"Sevim Burak ","1899");


        List<Book> b=new ArrayList<>();
        b.add(kitap1);
        b.add(kitap2);
        b.add(kitap3);
        b.add(kitap4);
        b.add(kitap5);

        List<Book> bookByName=new ArrayList<>(b);
        List<Book> bookBypageNumber=new ArrayList<>(b);
// İsme göre sırala
        Collections.sort(bookByName,Comparator.comparing(Book::getName));
        System.out.println("Kitapların isme göre sıralanışı:--------------------");
        for(Book book:bookByName){
            System.out.println(book.getName());
        }


//Page compare

        Collections.sort(bookBypageNumber,Comparator.comparing(Book::getPageNumber));
        System.out.println("Kitapların sayfa sayısına  göre sıralanışı:-----------------------------");
        for(Book book:bookBypageNumber){
            System.out.println(book.getName()+","+book.getPageNumber());
        }
    }
}