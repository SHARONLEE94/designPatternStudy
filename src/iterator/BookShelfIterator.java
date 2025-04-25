package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

// BookShelf의 검색을 실행하는 클래스
public class BookShelfIterator implements Iterator<Book> { 
    
    private BookShelf bookShelf;
    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }
    
    @Override
    public boolean hasNext() {
        return (index < bookShelf.getLength()) ? true : false;

    }

    @Override
    public Book next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }
        Book book = bookShelf.getBook(index);
        index++;

        return book;
    }
}
