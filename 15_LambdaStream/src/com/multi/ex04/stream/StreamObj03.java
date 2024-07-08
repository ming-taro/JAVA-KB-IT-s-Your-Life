package com.multi.ex04.stream;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;


class StreamObj03 {
	public static void main(String[] args) {
		Student3[] stuArr = {
			new Student3("나자바", true,  1, 1, 300),	
			new Student3("김지미", false, 1, 1, 250),	
			new Student3("김자바", true,  1, 1, 200),	
			new Student3("이지미", false, 1, 2, 150),	
			new Student3("남자바", true,  1, 2, 100),	
			new Student3("안지미", false, 1, 2,  50),	
			new Student3("황지미", false, 1, 3, 100),	
			new Student3("강지미", false, 1, 3, 150),	
			new Student3("이자바", true,  1, 3, 200),	

			new Student3("나자바", true,  2, 1, 300),	
			new Student3("김지미", false, 2, 1, 250),	
			new Student3("김자바", true,  2, 1, 200),	
			new Student3("이지미", false, 2, 2, 150),	
			new Student3("남자바", true,  2, 2, 100),	
			new Student3("안지미", false, 2, 2,  50),	
			new Student3("황지미", false, 2, 3, 100),	
			new Student3("강지미", false, 2, 3, 150),	
			new Student3("이자바", true,  2, 3, 200)	
		};

		System.out.printf("1. 단순분할(성별로 분할)%n");
		Map<Boolean, List<Student3>> stuByGender =  Stream.of(stuArr)
				.collect(partitioningBy(Student3::isMale));

		List<Student3> maleStudent   = stuByGender.get(true);
		List<Student3> femaleStudent = stuByGender.get(false);

		for(Student3 s : maleStudent)   System.out.println(s);
		for(Student3 s : femaleStudent) System.out.println(s);

		System.out.printf("%n2. 단순분할 + 통계(성별 학생수)%n");
		Map<Boolean, Long> stuNumByGender = Stream.of(stuArr)
				.collect(partitioningBy(Student3::isMale, counting()));

		System.out.println("남학생 수 :"+ stuNumByGender.get(true));
		System.out.println("여학생 수 :"+ stuNumByGender.get(false));


		System.out.printf("%n3. 단순분할 + 통계(성별 1등)%n");
		Map<Boolean, Optional<Student3>> topScoreByGender = Stream.of(stuArr)
				.collect(partitioningBy(Student3::isMale, 
					maxBy(comparingInt(Student3::getScore))
				));
		System.out.println("남학생 1등 :"+ topScoreByGender.get(true));
		System.out.println("여학생 1등 :"+ topScoreByGender.get(false));

		Map<Boolean, Student3> topScoreByGender2 = Stream.of(stuArr)
			.collect(partitioningBy(Student3::isMale, 
				collectingAndThen(
					maxBy(comparingInt(Student3::getScore)), Optional::get
				)
			));
		System.out.println("남학생 1등 :"+ topScoreByGender2.get(true));
		System.out.println("여학생 1등 :"+ topScoreByGender2.get(false));

		System.out.printf("%n4. 다중분할(성별 불합격자, 100점 이하)%n");

		Map<Boolean, Map<Boolean, List<Student3>>> failedStuByGender = 
			Stream.of(stuArr).collect(partitioningBy(Student3::isMale, 
				partitioningBy(s -> s.getScore() <= 100))
			); 
		List<Student3> failedMaleStu   = failedStuByGender.get(true).get(true);
		List<Student3> failedFemaleStu = failedStuByGender.get(false).get(true);

		for(Student3 s : failedMaleStu)   System.out.println(s);
		for(Student3 s : failedFemaleStu) System.out.println(s);
	}
}


class Student3 {
	String name;
	boolean isMale; // 성별
	int hak;		    // 학년
	int ban;		    // 반
	int score;

	Student3(String name, boolean isMale, int hak, int ban, int score) { 
		this.name	= name;
		this.isMale	= isMale;
		this.hak	= hak;
		this.ban	= ban;
		this.score  = score;
	}
	String	getName()  { return name;}
	boolean isMale()    { return isMale;}
	int		getHak()   { return hak;}
	int		getBan()   { return ban;}
	int		getScore() { return score;}

	public String toString() { 
		return String.format("[%s, %s, %d학년 %d반, %3d점]",
			name, isMale ? "남":"여", hak, ban, score); 
	}
   // groupingBy()에서 사용
	enum Level { HIGH, MID, LOW }  // 성적을 상, 중, 하 세 단계로 분류
}

