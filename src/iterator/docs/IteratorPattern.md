# 📚 Iterator Pattern 학습 정리

## ✅ 개념 요약
- **목적:** 컬렉션의 내부 구조를 노출하지 않고 순회할 수 있도록 하는 패턴
- **핵심 인터페이스:** Iterator (hasNext(), next())
- **주요 클래스:** Book, BookShelf, BookShelfIterator

## ❓ 궁금했던 부분
## ✅ 상황 정리
책에서는 아래와 같이 사용함:

```java
BookShelf bookShelf = new BookShelf(4); // ✅ 정상
```

그런데 아래처럼 제네릭을 사용하면 오류 발생:

```java
BookShelf<Book> bookShelf = new BookShelf<>(4); // ❌ 오류 발생
```

## ✅ 핵심 이유
BookShelf 클래스가 **제네릭이 아니기 때문!**

```java
// 책의 기본 구현 예시
public class BookShelf implements Iterable<Book> {
    private Book[] books;
    ...
}
```

- `BookShelf`는 고정된 `Book` 타입만 처리하도록 설계됨
- 따라서 `BookShelf<Book>` 처럼 **제네릭 타입으로 쓸 수 없음**


## ✅ 제네릭으로 만들고 싶다면?

```java
public class BookShelf<T> implements Iterable<T> {
    private List<T> items;

    public BookShelf(int size) {
        items = new ArrayList<>(size);
    }

    public void add(T item) {
        items.add(item);
    }

    public T get(int index) {
        return items.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        return items.iterator();
    }
}
```

이렇게 하면 아래와 같이 사용 가능:

```java
BookShelf<Book> bookShelf = new BookShelf<>(4); // ✅ 정상 작동
```

## ✅ 결론 요약

| 코드 예시 | 작동 여부 | 이유 |
|-----------|-----------|------|
| `BookShelf bookShelf = new BookShelf(4);` | ✅ | 클래스가 Book 고정이기 때문 |
| `BookShelf<Book> bookShelf = new BookShelf<>(4);` | ❌ | 제네릭 타입 선언이 없기 때문 |
| `BookShelf<T> implements Iterable<T>`로 변경 | ✅ | 제네릭으로 유연하게 설계됨 |

## ✅ 질문 요약

| 질문 | 내용 | 정리 or 답변 |
|------|------|---------------|
| 제네릭 사용 시 왜 `BookShelf<Book>` 안 되지? | 제네릭 클래스 구현이 안 되어 있음 | 클래스 정의에서 `<T>` 필요 |
| `BookShelf`는 Iterable을 구현 안 해도 되나? | `for-each` 사용하려면 구현 필요 | `implements Iterable<Book>` 추가 |
---
🔗 참고