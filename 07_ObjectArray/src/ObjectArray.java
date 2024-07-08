import java.util.Arrays;

// 객체 배열
public class ObjectArray {
    public static void main(String[] args) {
        // 선언 및 초기화
        MemberVO[] mArray;
        MemberVO[] mArray1 = null;
        MemberVO[] mArray2 = new MemberVO[10]; // 표준적으로 배열을 초기화하는 문장
//        int[] intArray = { 1, 2, 3 };
        MemberVO[] mArray3 = /* new MemberVO[] */ {
                // 리터럴 선언법
                new MemberVO("test1", "홍길동", 21),
                new MemberVO("test1", "홍길동", 31),
                new MemberVO("test1", "홍길동", 41),
        };

//        mArray[0].setName("홍길동");  // 죽는 이유 : 지역변수를 초기화하지 않아서!
//        mArray1[0].setName("홍길동"); // 죽는 이유 : NullPointerException, null 초기화 이후 생성
//        mArray2[0].setName("홍길동"); // 죽는 이유 : 배열은 초기화 되었는데, MemberVO를 생성하지 않아서

        System.out.println(Arrays.toString(mArray2)); // [null, null, null, null, null, null, null, null, null, null]
        //-> 10개의 빈공간만 생성된 배열!
        mArray2[0] = new MemberVO(); // 0번 공간에서 Member 생성
//        System.out.println(mArray2[0].getName().contains("홍길동")); // 죽는 이유 : name 문자열을 초기화하지 않아서 죽는다!

        System.out.println(Arrays.toString(mArray3));
        System.out.println(mArray3[0].getName().contains("홍길동"));   // 정상적인 접근이 가능!
        System.out.println("----------------------------------------------------");

        // 객체 배열을 올바르게 초기화 하고 사용하는 방법
        // 1. 배열을 선언하고 배열의 알맞은 크기로 초기화
        // 2. 실제 사용할 객체를 new로 생성하여 배열에 채워 놓는다.
        // 3. 배열 빈 공간이 생길수 있음으로 항상 null 체크를 진행하고 해당 영역에 접근해야한다.
        MemberVO[] mArray4 = new MemberVO[10]; // 10개의 빈방
        mArray4[0] = new MemberVO("test1", "홍길동", 25);
        mArray4[1] = new MemberVO("test1", "이길동", 35);
        mArray4[2] = new MemberVO("test1", "최길동", 27);

        // null 체크하는 방법
        if (mArray4[0] != null) {
            System.out.println("mArray4[0]은 null이 아닙니다!");
        }
        // null 체크하는 방법
        // -> 안전하게 변수에 접근하는 방법!
        if (mArray4[3] != null) {
            mArray4[3].setName("박길동");
        }

        // 객체 배열로 초기화하는 방법
        // 1. 인자가 있는 생성자를 통해 초기화 하는 방법
        for (int i = 0; i < mArray4.length; i++) {
            mArray4[i] = new MemberVO("test" + i, "홍길동" + i, 25 + i);
        }
        System.out.println(Arrays.toString(mArray4));

        // 2. default 생성자를 통해 생성하고 setter로 초기화 하는 방법
        // -> 사용 이유는 라인을 아래로 늘리려고 사용은 하지만, 별로 추천하지 않음!!
        for (int i = 0; i < mArray4.length; i++) {
            mArray4[i] = new MemberVO();
            mArray4[i].setId("test" + i);
            mArray4[i].setName("홍길동" + i);
            mArray4[i].setAge(25 + i);
        }
        System.out.println(Arrays.toString(mArray4));

        // 3. 인자 있는 생성자를 사용하는데, 아래로 라인을 늘려야 하는 경우
        for (int i = 0; i < mArray4.length; i++) {
            String id = "test" + (i + 1);
            String name = "홍길동" + (i + 1);
            int age = 25 + i;
            mArray4[i] = new MemberVO(id, name, age);
        }
        System.out.println(Arrays.toString(mArray4));
        
        // 객체 배열 순회하는 방법
        
        // 1. 일반 반복문으로 순회하는 방법(index)
        System.out.println("---------------------------------------------");
        for (int i = 0; i < mArray4.length; i++) {
            System.out.println("변경 전");
            System.out.println(mArray4[i].toString());
            int age = mArray4[i].getAge() + 1;
            mArray4[i].setAge(age);
            System.out.println("변경 후");
            System.out.println(mArray4[i].toString());
        }
        System.out.println("---------------------------------------------");

        // 2. for each문으로 순회하는 방법
        // -> 일부러 type을 틀리고 alt + enter로 에러를 고쳐서 type을 맞출 수도 있다
        for (MemberVO m: mArray4) {
            System.out.println("변경 전");
            System.out.println(m);
            int age = m.getAge() + 2;
            m.setAge(age);
            System.out.println("변경 후");
            System.out.println(m);
        }

        // 3. print만 필요할 때 깔끔하게 치는 방법
        System.out.println(Arrays.toString(mArray4).replace("},", "},\n"));

        // 객체배열에서 빈공간 skip하는 방법
        mArray4[3] = null;
        for (MemberVO m: mArray4) {
            if (m == null) {
                continue;
            }
            System.out.println(m);
        }
    }
}
