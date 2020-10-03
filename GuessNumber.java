import java.util.Scanner;
public class GuessNumber {
    private int[] answear;
    private int guesstimes;
    private GuessNumber(){
        guesstimes = 0;
        answear = new int[4];
        boolean[] numberPool = new boolean[10];
        for (int i = 0; i < 4; i++){
            int randIndex = (int)(Math.random()*10);
            while(numberPool[randIndex]){//don't have repeat
                randIndex = (int)(Math.random()*10);
            }
            answear[i] = randIndex;
            numberPool[randIndex] = true;
        }
    }
    private boolean checkInput(String guess){//check input method
        boolean[] numberPool = new boolean[10];
        for (int i = 0; i < 4; i++){
            if (numberPool[Character.getNumericValue(guess.charAt(i))]){
                return false;
            }
            numberPool[Character.getNumericValue(guess.charAt(i))] = true;
        }
        return true;
    }
    private boolean checkWin(String guess){//check win method
        int countA = 0, countB = 0;//A is number and place right and then B is number right but wrong place
        for (int i = 0; i < 4; i++){
            if (answear[i] == Character.getNumericValue(guess.charAt(i))){
                countA++;
            }
            for (int j = 0; j < 4; j++){
                if (i == j){
                    continue;
                }
                if (answear[i] == Character.getNumericValue(guess.charAt(j))){
                    countB++;
                }
            }
        }
        System.out.println(countA+"A"+countB+"B");
        return countA == 4;
    }
    private void play(){
        Scanner input = new Scanner(System.in);
        String guess;

        while (true) {
            System.out.println("Your Input : ");
            guess = input.next();
            if (guess.length() != 4 || !checkInput(guess)){//check for 4 digits only
                System.out.println("wrong input! input again");
                continue;
            }
            guesstimes++;//guess many times
            if (checkWin(guess)){
                break;
            }
        }
        System.out.println("Congratulation! guessed "+guesstimes+" times");
    }
    public static void main(String[] args){
        GuessNumber game = new GuessNumber();
        game.play();
    }
}
