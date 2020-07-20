package task7;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class IOScheduler {

	public static void main(String[] args) throws InterruptedException {

		Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
				.subscribeOn(Schedulers.io());

		src.subscribe(e -> ioOperation());

		Thread.sleep(6000);

		src.subscribe(e -> ioOperation());
		src.subscribe(e -> ioOperation());
		src.subscribe(e -> ioOperation());
		src.subscribe(e -> ioOperation());

		Thread.sleep(500000);
	}

	public static void ioOperation() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("Computation Done By : " + Thread.currentThread().getName());
	}

}

