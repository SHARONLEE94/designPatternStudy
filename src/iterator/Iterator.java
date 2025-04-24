package iterator;

// main
public class Iterator {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("Around the World in 80 Days"));

        // todo
        // 메인 클래스 미완성
        System.out.println(bookShelf.getBook(0).getName());

        String str = new String();
    }
}
