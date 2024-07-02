import java.util.Date;

class Book implements Comparable<Book> {
    private int id;
    private String name;
    private int pageNumber;
    private String writer;
    private String  publishDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public Book(int id, String name, int pageNumber, String writer, String publishDate) {
        this.id = id;
        this.name = name;
        this.pageNumber = pageNumber;
        this.writer = writer;
        this.publishDate = publishDate;
    }

    @Override
    public int compareTo(Book o) {
        // if the string are not equal
        if (this.name.compareTo(o.name) != 0) {
            return this.name.compareTo(o.name);
        }
        else {
            // we compare int values
            // if the strings are equal
//            System.out.println("Yok");
            return 0;
        }
    }
}