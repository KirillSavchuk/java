package task3;

import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

public class CreatingObservable {

    public static void main(String[] args) {

        Observable<Integer> source = Observable.create(e -> {
            e.onNext(1);
            e.onNext(2);
            e.onNext(3);
            e.onComplete();
        });

        source.subscribe(System.out::println);

        Observable<Integer> just = Observable.just(1, 2, 3);

        just.subscribe(System.out::println);

        List<String> list = List.of("Ram", "Shyam", "Mike");

        @NonNull
        Observable<String> fromIterable = Observable.fromIterable(list);

        fromIterable.subscribe(System.out::println);

    }

}
