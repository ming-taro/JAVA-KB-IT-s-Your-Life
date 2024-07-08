package com.multi.ex04.stream;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

class Student4 {
	String name;
	boolean isMale; // 성별
	int hak;		// 학년
	int ban;		// 반
	int score;

	Student4(String name, boolean isMale, int hak, int ban, int score) { 
		this.name	= name;
		this.isMale	= isMale;
		this.hak	= hak;
		this.ban	= ban;
		this.score  = score;
	}

	String	getName()  { return name;}
	boolean isMale()   { return isMale;}
	int		getHak()   { return hak;}
	int		getBan()   { return ban;}
	int		getScore() { return score;}

	public String toString() { 
		return String.format("[%s, %s, %d학년 %d반, %3d점]", name, isMale ? "남":"여", hak, ban, score); 
	}

	enum Level {
		HIGH, MID, LOW
	}
}

class StreamObj04 {
	public static void main(String[] args) {
		Student4[] stuArr = {
			new Student4("나자바", true,  1, 1, 300),	
			new Student4("김지미", false, 1, 1, 250),	
			new Student4("김자바", true,  1, 1, 200),	
			new Student4("이지미", false, 1, 2, 150),	
			new Student4("남자바", true,  1, 2, 100),	
			new Student4("안지미", false, 1, 2,  50),	
			new Student4("황지미", false, 1, 3, 100),	
			new Student4("강지미", false, 1, 3, 150),	
			new Student4("이자바", true,  1, 3, 200),	

			new Student4("나자바", true,  2, 1, 300),	
			new Student4("김지미", false, 2, 1, 250),	
			new Student4("김자바", true,  2, 1, 200),	
			new Student4("이지미", false, 2, 2, 150),	
			new Student4("남자바", true,  2, 2, 100),	
			new Student4("안지미", false, 2, 2,  50),	
			new Student4("황지미", false, 2, 3, 100),	
			new Student4("강지미", false, 2, 3, 150),	
			new Student4("이자바", true,  2, 3, 200)	
		};

		System.out.printf("1. 단순그룹화(반별로 그룹화)%n");
		Map<Integer, List<Student4>> stuByBan = Stream.of(stuArr)
				                                     .collect(groupingBy(Student4::getBan));
		
		for(List<Student4> ban : stuByBan.values()) {
			for(Student4 s : ban) {
				System.out.println(s);
			}
		}

		System.out.printf("%n2. 단순그룹화(성적별로 그룹화)%n");
		Map<Student4.Level, List<Student4>> stuByLevel = Stream.of(stuArr)
				.collect(groupingBy(s-> {
						 if(s.getScore() >= 200) return Student4.Level.HIGH;
					else if(s.getScore() >= 100) return Student4.Level.MID;
					else                         return Student4.Level.LOW;
				}));

		TreeSet<Student4.Level> keySet = new TreeSet<>(stuByLevel.keySet());

		for(Student4.Level key : keySet) {
			System.out.println("["+key+"]");

			for(Student4 s : stuByLevel.get(key))
				System.out.println(s);
			System.out.println();
		}

		System.out.printf("%n3. 단순그룹화 + 통계(성적별 학생수)%n");
		Map<Student4.Level, Long> stuCntByLevel = Stream.of(stuArr)
				.collect(groupingBy(s-> {
						 if(s.getScore() >= 200) return Student4.Level.HIGH;
					else if(s.getScore() >= 100) return Student4.Level.MID;
					else                         return Student4.Level.LOW;
				}, counting()));

		for(Student4.Level key : stuCntByLevel.keySet())
			System.out.printf("[%s] - %d명, ", key, stuCntByLevel.get(key));
		System.out.println();
/*
		for(List<Student> level : stuByLevel.values()) {
			System.out.println();
			for(Student s : level) {
				System.out.println(s);
			}
		}
*/
		System.out.printf("%n4. 다중그룹화(학년별, 반별)%n");
		Map<Integer, Map<Integer, List<Student4>>> stuByHakAndBan =
          Stream.of(stuArr)
				.collect(groupingBy(Student4::getHak,
						 groupingBy(Student4::getBan)
				));

		for(Map<Integer, List<Student4>> hak : stuByHakAndBan.values()) {
			for(List<Student4> ban : hak.values()) {
				System.out.println();
				for(Student4 s : ban)
					System.out.println(s);
			}
		}

		System.out.printf("%n5. 다중그룹화 + 통계(학년별, 반별 1등)%n");
		Map<Integer, Map<Integer, Student4>> topStuByHakAndBan = Stream.of(stuArr)
				.collect(groupingBy(Student4::getHak,
						 groupingBy(Student4::getBan,
							collectingAndThen(
								maxBy(comparingInt(Student4::getScore)),
								Optional::get
							)
						)
				));

		for(Map<Integer, Student4> ban : topStuByHakAndBan.values())
			for(Student4 s : ban.values())
				System.out.println(s);
		System.out.println();
		
		System.out.printf("6. 다중그룹화 + 통계(학년별, 반별 성적그룹)%n");
		Map<String, Set<Student4.Level>> stuByScoreGroup = Stream.of(stuArr)
			.collect(groupingBy(s-> s.getHak() + "-" + s.getBan(),
					mapping(s-> {
						 if(s.getScore() >= 200) return Student4.Level.HIGH;
					else if(s.getScore() >= 100) return Student4.Level.MID;
						 else                    return Student4.Level.LOW;
					} , toSet())
			));

		 Set<String> keySet2 = stuByScoreGroup.keySet();

		for(String key : keySet2) {
			System.out.println("["+key+"]" + stuByScoreGroup.get(key));
		}
	}  // main의 끝
}

