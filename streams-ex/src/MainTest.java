import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MainTest {

	public static void main(String[] args) {
		List<String> list1 = Arrays.asList("루피","조로","나미","상디");
		for(String s : list1) {
			System.out.println(s);
		}
		
		list1.stream().forEach(System.out::println);	// 메소드 참조
		
		// Math, Arrays, Collections
		List<Integer> list2 = Arrays.asList(1,2,3,4,5);
		// 형식 추론
		list2.stream().filter(n -> n%2 == 0).forEach(System.out::println);
		
		list1.stream().map(s -> s.length()).forEach(System.out::println);
		
		List<Integer> list3 = Arrays.asList(0,1,2,3,4,5,6,7,8,9,9,9,5,5,5);
		list3.stream().distinct().sorted().forEach(System.out::println);
		
		List<Integer> list4 = Arrays.asList(25,22,30,27,31,21);
		Optional<Integer> result = list4.stream().reduce((x,y) -> x+y);
		System.out.println(result.get());
	}

}
