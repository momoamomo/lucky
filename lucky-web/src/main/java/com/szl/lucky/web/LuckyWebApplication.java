package com.szl.lucky.web;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author sunzhilin
 * @date 2019/12/21  22:26
 */
@SpringBootApplication(scanBasePackages = "com.szl")
@ComponentScan("com.szl.lucky")
@MapperScan("com.szl.lucky.dao")
public class LuckyWebApplication {
    public static void main(String[] args) {

        SpringApplication.run(LuckyWebApplication.class, args);
    }
//    public static void main(String[] args) {
////        SpringApplication.run(LuckyWebApplication.class, args);
//        LocalDateTime time1 = LocalDateTime.now().minusHours(1);
//        LocalDateTime time2 = LocalDateTime.now().minusDays(1);
//        String sd = "asfas";
//
////        Locale locale = new Locale();
//    }
    /*public static void main(String[] args) throws IOException {
        String contens = new String(Files.readAllBytes(Paths.get("C:\\Users\\72898\\Desktop\\tryStream.txt")),
                StandardCharsets.UTF_8);
        String[] wordArray = contens.split("\\PL+");
        List<String> wordList = Arrays.asList(wordArray);

        Stream<String> words = Stream.of(wordArray);
        show("words", words);
        Stream<String> silence = Stream.empty();
        show("silence", silence);
        Stream<String> echos = Stream.generate(()->"Echo");
        show("echos", echos);
    }*/

//    public static void main(String[] args) throws IOException {
//        Iterator<Integer> iter = Stream.iterate(0, n -> n+1).limit(10).iterator();
//        while (iter.hasNext()){
//            System.out.println(iter.next());
//        }
//
//        Object[] numbers = Stream.iterate(0, n -> n+1).limit(10).toArray();
//        System.out.println("Object array:" + numbers[6]);
//        Integer[] numbers3 = Stream.iterate(0, n -> n+1).limit(10).toArray(Integer[]::new);
//        Integer iner = numbers3[7];
//
//    }
//
//
//    private static <T> void show(String title, Stream<T> stream) {
//        final int SIZE = 10;
//        List<T> firstElements = stream.limit(SIZE+1).collect(Collectors.toList());
//        System.out.println(title +":");
//        for (int i = 0; i < firstElements.size() ; i++) {
//            if (i > 0) {
//                System.out.println(",");
//            }
//            if(i<SIZE){
//                System.out.println(firstElements.get(i));
//            }else {
//                System.out.println("...");
//            }
//        }
//        System.out.println();
//    }
}
