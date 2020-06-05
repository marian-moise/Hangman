import java.io.File;
import java.util.*;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        //String magicWord = "Hangman";
        String input;
        boolean playng = true;

        File file = new File("G:\\JAVA\\Hangman\\words");
        List<Words> wordsList = HangmanUtils.readFileToWordsList(file);
        String magicWord =  getRandomWord(wordsList);
        System.out.println(magicWord);


        System.out.println("Wellcome!\nChoose an option:");
        System.out.println("=========================");
        System.out.println("1 - guess a single letter");
        System.out.println("2 - guess the whole word");
        System.out.println("0 - quit the game");
        System.out.println("=========================");
        System.out.println("Type an option:");

        do {
            input = scanner.next();
            switch (input) {

                case "1":
                    int j = 0;
                    int counter = 10;
                    while (j < 10) {
                        System.out.println("Type letter:");
                        StringBuilder temp = returnGuessed(magicWord);
                        List<String> buildWord = new ArrayList<>();
                        for (int i = 0; i < temp.length(); i++) {
                            buildWord.add(i, temp.substring(i, i + 1));
                        }
                        System.out.println(buildWord);
                        System.out.println("=========================");
                        if (buildWord.contains("_")) {
                            HangmanGraphic graphh = new HangmanGraphic();
                            counter--;
                            System.out.println("You have " + counter + " lives");
                            graphh.lifes(counter);
                        }
                        System.out.println("Type the word or any key to continue: ");
                        String input2 = scanner.next();
                        if (input2.equalsIgnoreCase(magicWord)) {
                            System.out.println("Congratulations you won!");
                            break;
                        }
                        if (counter == 1) {
                            System.out.println("You exceded the number of lives\nYou lose!!!");
                            System.out.println("===GAME OVER===");
                            System.out.println("      ______   ");
                            System.out.println("     |      |  ");
                            System.out.println("     |      |  ");
                            System.out.println("     |     ( ) / ");
                            System.out.println("     |   / | | ");
                            System.out.println("     |    /  /  ");
                            System.out.println("     |         ");
                            System.out.println("     |         ");
                            System.out.println("_____|_________");
                            break;
                        }
                        j++;
                    }
                    System.out.println("If you want to play again type 1");
                    System.out.println("If you want to exit type 0");
                    break;
                case "2":
                    System.out.println("Type the word!");
                    input = scanner.next();
                    if (input.equalsIgnoreCase(magicWord)) {
                        System.out.println("Congratulations you won!");
                        System.out.println("Goodbye!!!");
                        playng = false;
                    } else {
                        System.out.println("You lost!!!");
                        System.out.println("Goodbye!!!");
                        System.out.println("The correct word was: " + magicWord);
                    }
                    break;
                case "0":
                    System.out.println("Goodbye!!!");
                    playng = false;
                    break;
                default:
                    System.out.println("Type a valid input!!");
                    break;
            }
        } while (playng);
    }


    public static StringBuilder returnGuessed(String word) {

        StringBuilder wordTemp = new StringBuilder(word.length());
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        for (int i = 0; i < word.length(); i++) {
            wordTemp.append(word.charAt(i));
        }
        for (int i = 0; i < wordTemp.length(); i++) {
            if (word.substring(i, i + 1).equalsIgnoreCase(input)) {
                char curr = wordTemp.charAt(i);
                wordTemp.setCharAt(i, curr);
            } else {
                wordTemp.setCharAt(i, '_');
            }
        }
        return wordTemp;
    }

    public static String getRandomWord(List<Words> words) {
        Words word = words.get(new Random().nextInt(words.size()));
        return  word.getWord();
    }

}
