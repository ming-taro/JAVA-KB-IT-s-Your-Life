package com.multi.ex06.anotation_exam;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class _Run {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Service service = new Service();
        // 서비스의 어노테이션 정보 가져오기
        AnotaionBasic anotaionBasic = service.getClass().getAnnotation(AnotaionBasic.class);
        System.out.println("value = " + anotaionBasic.value());
        System.out.println("values = " + Arrays.toString(anotaionBasic.values()));
        System.out.println("number = " + anotaionBasic.number());
        System.out.println("-------------------------------------");

        Method[] declaredMethods = Service.class.getDeclaredMethods();
        for(Method method : declaredMethods) {
            //PrintAnnotation 얻기
            PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class);

            //설정 정보를 이용해서 선 출력
            printLine(printAnnotation);

            //메소드 호출
            method.invoke(new Service());

            //설정 정보 이용해서 선 출력
            printLine(printAnnotation);
        }
    }

    public static void printLine(PrintAnnotation printAnnotation) {
        if(printAnnotation != null) {
            //number 속성값 얻기
            int number = printAnnotation.number();
            for(int i=0; i<number; i++) {
                //value 속성값 얻기
                String value = printAnnotation.value();
                System.out.print(value);
            }
            System.out.println();
        }
    }
}
