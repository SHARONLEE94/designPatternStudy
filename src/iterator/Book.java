package iterator;

public class Book {
    // 데이터 보호를 위헤 제어자를 private로
    private String name;

    // 생성자
    public Book(String name) {
        this.name = name;
    }

    // getter
    public String getName() {
        return name;
    }
}
