package task8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Buffering {

    public static void main(String[] args) throws InterruptedException {

        Observable.range(1, 30)
                .buffer(4, 7)
                .subscribe(System.out::println);

//        Observable.interval(500, TimeUnit.MILLISECONDS)
//                .buffer(1, TimeUnit.SECONDS, 2)
//                .subscribe(System.out::println);

        @NonNull
        Observable<Long> interval = Observable.interval(500, TimeUnit.MILLISECONDS);

        Observable.interval(1000, TimeUnit.MILLISECONDS)
                .window(interval)
                .subscribe(System.out::println);

        Thread.sleep(10000);

    }

}
