package 结构型.享元模式;

import java.util.HashMap;
import java.util.Map;

/***
 * 一个图书馆的图书管理系统。假设有许多图书，每本图书都有一个唯一的标识号（ISBN），但它们可能属于相同的作者、相同的出版社等。
 *
 * 通过享元模式，相同ISBN的书籍对象得以共享，节省了内存。在客户端代码中，虽然我们创建了两个相同ISBN的书籍对象，但它们实际上是同一个对象。这种方式可以在处理大量相似对象时提高性能和降低内存占用。
 */
// 享元接口
interface Book {
    void displayInfo();
}

// 具体享元类，表示图书
class ConcreteBook implements Book {
    private String title;
    private String author;
    private String publisher;
    
    public ConcreteBook(String title, String author, String publisher) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Book: " + title + " by " + author + ", published by " + publisher);
    }
}

// 享元工厂类
class BookFactory {
    private Map<String, Book> bookMap = new HashMap<>();
    
    Book getBook(String ISBN, String title, String author, String publisher) {
        // 如果已存在相同的ISBN的书籍对象，则直接返回，否则创建并缓存
        return bookMap.computeIfAbsent(ISBN, k -> new ConcreteBook(title, author, publisher));
    }
}

// 客户端代码
public class Client {
    public static void main(String[] args) {
        BookFactory bookFactory = new BookFactory();
        
        // 获取并共享书籍对象
        Book book1 = bookFactory.getBook("978-0-13-708107-3", "Clean Code", "Robert C. Martin", "Prentice Hall");
        Book book2 = bookFactory.getBook("978-0-13-708107-3", "Clean Code", "Robert C. Martin", "Prentice Hall");
        
        // 显示书籍信息
        book1.displayInfo();
        book2.displayInfo();
        
        // 检查是否为同一对象
        System.out.println("book1 == book2: " + (book1 == book2));
    }
}
