public class MyList <T>{
    int capacity;
    T[] list;
    T[] listTemp;
    int listSize=0;

    //constructor 1
    public MyList() {
        this.capacity = 10;
        this.setList();
    }
    //constructor 2
    public MyList(int capacity) {
        this.capacity = capacity;
        this.setList();
    }
    public int getCapacity(){
        return capacity;
    }
    public int size(){
        return this.listSize;
    }
    public void sizeCount(){
        int count=0;
        for(int i=0;i<this.list.length;i++){
            if(this.list[i]!=null) count++;
        }
        this.listSize=count;
    }
    public void pCapacity(){
        this.listTemp = (T[]) new Object[this.capacity];
        for (int i = 0; i < this.list.length; i++){
            this.listTemp[i] = this.list[i];
        }
        this.list = this.listTemp;
    }
    public void add(T data){
        if(this.size() < this.capacity){
            list[this.listSize]=data;
            this.sizeCount();
        }else{
            this.capacity=this.capacity*2;
            this.pCapacity();
            this.add(data);
        }
    }


    public void setList(){
        this.list=(T[]) new Object[this.capacity];
    }
    public T get(int index){
    T myListElement=this.list[index];
    return myListElement;
    }
    public void remove(int index){
 int tempIndex=-1;
        if(index>=0 && index<=this.listSize) {
            //find index
            for (int i = 0; i < this.listSize; i++) {
                   if (this.list[i]==(this.list[index])){
                     tempIndex=index;
                     break;
                   }
            }
            if(tempIndex!=-1){
                for(int j=tempIndex;j<this.listSize;j++){
                    this.list[j]=this.list[j+1];
                }
            }

            this.listSize--;
        }  else{
            System.out.println("Geçersiz dizin");
        }

    }
    //set(int index, T data) : verilen indisteki veriyi yenisi ile değiştirme işlemini yapmalıdır.
    // Geçersiz indis girilerse null döndürür.
    public void set(int index,T data){
        if(index>=0 && index<=this.listSize) {
        this.list[index]=data;
        }else {
            System.out.println("Geçersiz index");
        }
    }
    //String toString() : Sınıfa ait dizideki elemanları listeleyen bir metot.

    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < this.listSize; i++) {
            result.append(this.list[i]);
            if (i < this.listSize - 1) {
                result.append(",");
            }
        }
        result.append("]");
        return result.toString();
    }
    //int indexOf(T data) : Parametrede verilen nesnenin listedeki indeksini verir.
    // Nesne listede yoksa -1 değerini verir.
    public int indexOf(T data){
        int indexNumber=-1;
        for(int i=0;i < this.listSize;i++) {
            if(this.list[i]==data){
                indexNumber=i;
                break;
            }
        }
        return indexNumber;
    }
    //int lastIndexOf(T data) : Belirtilen öğenin listedeki son indeksini söyler.
    // Nesne listede yoksa -1 değerini verir.
public int lastIndexOf(T data){
        int lastIndex=-1;
        for(int i=0;i < this.listSize;i++) {
            if(this.list[i]==data){
                lastIndex=i;
            }
        }
        return lastIndex;
}
//boolean isEmpty() : Listenin boş olup olmadığını söyler.
    public boolean isEmpty(){
        if(this.size()==0)return true;
        else return false;
    }
    //T[] toArray() : Listedeki öğeleri, aynı sırayla bir array haline getirir.
    public Object[] toArray(){
        Object[] dizi = new Object[this.listSize];
        for(int i=0;i < this.listSize ;i++) {
            dizi[i]=this.list[i];
        }
        return dizi;
    }
    //clear() : Listedeki bütün öğeleri siler, boş liste haline getirir.
    public void clear(){
        for (int i = 0; i < this.list.length; i++) {

            this.list[i] = null;

        }


    }
    //MyList<T> sublist(int start,int finish) : Parametrede verilen indeks aralığına ait bir liste döner.
    public MyList<T> subList(int start,int finish){
        MyList<T> myTemp=new MyList<>(finish-start+1);
        for(int i=start;i<=finish;i++){
             myTemp.add((T)this.list[i]);
        }
        return myTemp;
    }
   // boolean contains(T data) : Parametrede verilen değerin dizide olup olmadığını söyler.
  public boolean contains(T data){
      for(int i=0;i < this.listSize;i++) {
          if(this.list[i]==data){
             return true;
          }
      }
      return false;
  }
}
