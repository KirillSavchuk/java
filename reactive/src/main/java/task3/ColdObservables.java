package task3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import io.reactivex.rxjava3.core.Observable;

public class ColdObservables {

	public static void main(String[] args) {
		
		List<Integer> list = IntStream.rangeClosed(1, 4).boxed().collect(Collectors.toList());

		Observable<Integer> source = Observable.fromIterable(list);
		
		source.subscribe(System.out::println);

		System.out.println("-----------------");

		list = updateListData(list, 5);
		
		source.subscribe(System.out::println);
		
	}

	private static List<Integer> updateListData(List<Integer> list, Integer newValue) {
		list.add(newValue);
		return list;
	}

}