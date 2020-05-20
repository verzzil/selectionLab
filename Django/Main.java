

import java.io.IOException;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {

    	// Данный файл открывать строго в командной строке

    	// Чтобы не было проблем с кодировками надо сначала 
    	//   командой chcp 65001 перевести кодировку своей командной
    	//   строки в UTF-8, а затем скомпилировать файл командой
    	//   javac -d . -cp . -encoding UTF-8 Main.java


        String consoleEncoding = System.getProperty("consoleEncoding");
        if (consoleEncoding != null) {
            try {
                System.setOut(new PrintStream(System.out, true, consoleEncoding));
            } catch (java.io.UnsupportedEncodingException ex) {
                System.err.println("Unsupported encoding set for console: "+consoleEncoding);
            }
        }
        System.setOut(new PrintStream(System.out, true, "UTF-8"));

        String[] introd = {"Максимум внимания ->","Готовы:?","3","2","1","0","-1",":)","Поехали!"};
        String[] phrases = {"Привет","Меня","Зовут","Альберт","Чем","Же","Я","Могу","Вас","Удивить",":?","Ну","Сейчас",
        "Вы","Читаете","Текст","Со","Скоростью","50","км/ч", "Шутка","!","На","Самом","Деле","Я","Не","Знаю","С","Какой",
        "Скоростью","Вы","Читаете","Данный","Текст","Но","Я","Знаю","Что","Вы","Сейчас","Улыбнулись","Иначе","Вы",
        "Грустная","Какашка",":(","Продолжим","Мой","Друг","Посоветовал","Мне","Написать","Это",
        "Я Альберт, хожу на бокс, если не хотите чтобы я вас встретил в темном переулке, то рад нашему будущему сотрудничеству",
        "*Все орфографические и пунктуационные ошибки сохранены*","И","Он","Прав","До свидания","ШУТКА","Точнее","50%","Из","Этого","Шутка",":)",
        "Чувствую","Не","Хватает","Эпичной","Музыки","Да",":?"};
        String[] end = {"И правда, на самом деле меня зовут Альберт, и 50% правды из той шутки является то, что я заниамюсь боксом :-) Хотя...",
        "C 6 лет я занимаюсь боксом и имею разряд КМС. До безпамятства люблю программирование и увлекаюсь им с 6 класса. 6 и 6... Совпадение:? Не думаю!",
        "Также я люблю изучать что-то новое и работать над сложными проектами",
        "Ну и как вы могли заметить, люблю пошутить))))",
    	"На этом всё, я проголодался... :(",
    	"И да, на код лучше не смотрите, я торопился...",
    	"Время красивых цитат!",
    	"Главная цитата большинства азиатов :) :",
    	"Главное - не количество(языков программирования, которые ты знаешь), а качество(владения одним языком)",
    	"",
    	"Также Брюс Ли сказал:",
    	"Я не боюсь того, кто знает 1000 ударов, я боюсь того, кто 1000 раз изучает один удар",
    	"",
    	"Всё!",
    	"Вжух!"
    };

        for(int i = 0; i < introd.length; i++) {
        	clearConsole();
        	System.out.print(introd[i]);
        	if(i != introd.length-1) Thread.sleep(1200);
        	else Thread.sleep(400);
        }
        for(int i = 0; i < phrases.length; i++) {
        	clearConsole();
        	for(int j = 0; j < 10; j++) System.out.print(" ");
        	System.out.print(phrases[i]);
        	Thread.sleep(180);
        	if(phrases[i].equals("Альберт") || phrases[i].equals(":?") || phrases[i].equals("км/ч") || phrases[i].equals("Но") || 
        		phrases[i].equals(":(") || phrases[i].equals(":)") || phrases[i].equals("Продолжим") || phrases[i].equals("Пока") ||
        		phrases[i].equals("ШУТКА") || phrases[i].equals("Прав")) {
        		Thread.sleep(800);
       	 	}
        	else if(phrases[i].equals("Я Альберт, хожу на бокс, если не хотите чтобы я вас встретил в темном переулке, то рад нашему будущему сотрудничеству")) {
        		Thread.sleep(7000);
        	}
        	else if(phrases[i].equals("*Все орфографические и пунктуационные ошибки сохранены*")) {
        		Thread.sleep(2222);
        	}

        }
        clearConsole();
        for(int i = 0; i < end.length; i++) {
        	String[] temp = end[i].split(" ");
        	for(int j = 0; j < temp.length; j++) {
        		for(int symb = 0; symb < temp[j].length(); symb++) {
        			System.out.print(temp[j].charAt(symb));
        			Thread.sleep(50);
        		}
        		if(j % getRandomInteger(2,5) == 0) Thread.sleep(150);
        		System.out.print(" ");
        	}
       		System.out.println();
        	if(i != end.length) Thread.sleep(800);
        	else Thread.sleep(200);
        }
        colophon();

        
    }
    public static void clearConsole() throws IOException,InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
    public static int getRandomInteger(int a, int b) {
        return (int)(Math.random()*(b-a+1))+a;
    }
    public static void colophon() throws IOException,InterruptedException {
    	clearConsole();
        for(int i = 0; i < 800; i++) {
            for(int j = 0; j < getRandomInteger(0,10); j++) System.out.print(" ");
            System.out.print("#");
        }
        clearConsole();
        int spaces = 800,SP = 800;
        int denu = 10;
        for(int i = denu; i >= 0; i--) {
      	 	for(int x = spaces; x >= 0; x--) {
        		for(int j = 0; j < getRandomInteger(0,10); j++) System.out.print(" ");
       			System.out.print("#");
        	}
        	spaces -= SP/denu;
        	Thread.sleep(80);
        	clearConsole();
        }
    }
}
