package task3;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class ObservableVariants {

    public static void main(String[] args) {

        Observable<String> source1 = Observable.just("First Name", "Second Name", "Third Name");
        Observable<String> source2 = Observable.empty();

        source1
                .first("Name")
                .subscribe(System.out::println);

        Single.just("Just Name")
                .subscribe(System.out::println);

        source2
                .firstElement()
                .subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Completed!"));

        Completable completable = Completable.complete();

        System.out.println();

        completable.subscribe(() -> System.out.println("Completable is completed!"));

        System.out.println();

        Completable
                .fromRunnable(() -> System.out.println("Some process is executing from Runnable..."))
                .subscribe(() -> System.out.println("The process executed successfully!"));

    }

}
