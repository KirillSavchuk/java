package task2;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;


public class RxJavaSynchronous {

	public static void main(String[] args) {

		Observable<String> source = Observable.create(
				e -> {
					e.onNext("{1}");
					e.onNext("{2}");
				}
		);

		Disposable subscribe1 = source.subscribe(e ->
				System.out.println("Observer 1: " + e + " for thread: " + getCurrentThreadName())
		);

		Disposable subscribe2 = source.subscribe(e ->
				System.out.println("Observer 2: " + e + " for thread: "+ getCurrentThreadName())
		);

	}

	private static String getCurrentThreadName() {
		return Thread.currentThread().getName();
	}

}
