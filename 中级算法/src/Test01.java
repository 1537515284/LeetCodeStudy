import java.util.*;
import java.util.stream.Collectors;

public class Test01 {
    public static void main(String[] args) {
        Set<Integer> intsSet = new LinkedHashSet<>();
        intsSet.add(10);
        intsSet.add(20);
        intsSet.add(30);
        intsSet.add(40);
        intsSet.add(5);
        intsSet.add(15);
        intsSet.add(25);
        System.out.println(intsSet);

        List<Integer> list = intsSet.stream().sorted().collect(Collectors.toList());
        System.out.println(list);

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(66);
        treeSet.add(33);
        treeSet.add(22);
        treeSet.add(55);
        System.out.println(treeSet);

        TreeSet<Book> booksSet = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });

        booksSet.add(new Book("三国演义","罗贯中",66));
        booksSet.add(new Book("红楼梦","曹雪芹",70.5));
        booksSet.add(new Book("水浒传","施耐庵",50));
        booksSet.add(new Book("西游记","吴承恩",67));
        System.out.println(booksSet);

    }
}

class Book{
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
