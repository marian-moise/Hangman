import java.io.File;
import java.util.*;

public class HangmanRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean playng = true;

        File file = new File("G:\\JAVA\\Hangman\\words");
        List<Words> wordsList = WordsToListMethod.readFileToWordsList(file);
        String magicWord = getRandomWord(wordsList);
        StringBuilder hideWord = new StringBuilder(magicWord.length());
        List<Character> tempWord = new ArrayList<>(magicWord.length());
        HangmanGraphic graphh = new HangmanGraphic();

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
                    for (int i = 0; i < magicWord.length(); i++) {
                        hideWord.append('*');
                    }

                    while (j < 10) {
                        System.out.println("Type a letter:");
                        String input2 = scanner.next();
                        for (int i = 0; i < magicWord.length(); i++) {
                            if (input2.charAt(0) == magicWord.charAt(i)) {
                                if (i == 0) {
                                    counter = counter + 1 - 1;
                                }
                                hideWord.replace(i, i + 1, String.valueOf(input2.charAt(0)));
                                counter++;
                            }
                            if (magicWord.equalsIgnoreCase(String.valueOf(hideWord))) {
                                System.out.println("Congratulations you won!");
                                return;
                            }
                        }
                        System.out.println("You guessed : " + hideWord);
                        counter--;
                        graphh.lifes(counter);
                        System.out.println("You have " + counter + " lives");
                        j++;
                    }
                    System.out.println("===GAME OVER!!!=== ");
                    System.out.println("      ______   ");
                    System.out.println("     |      |  ");
                    System.out.println("     |      |  ");
                    System.out.println("     |     ( ) / ");
                    System.out.println("     |   / | | ");
                    System.out.println("     |    /   /  ");
                    System.out.println("     |         ");
                    System.out.println("     |         ");
                    System.out.println("_____|_________");
                    playng = false;
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

    public static String getRandomWord(List<Words> words) {
        Words word = words.get(new Random().nextInt(words.size()));
        return word.getWord();
    }
}



