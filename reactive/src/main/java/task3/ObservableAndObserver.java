package task3;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;

public class ObservableAndObserver {

    public static void main(String[] args) {

        Observable<Integer> source = new ObservableCreate<>(emitter -> {
            try {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            } catch (Throwable t) {
                emitter.onError(t);
            }
        });

        Observer<Integer> observer = new Observer<>() {

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("Subscribed!");
            }

            @Override
            public void onNext(@NonNull Integer num) {
                System.out.println("On Next: " + num);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("Completed!");

            }
        };

        source.subscribe(observer);

    }

}
