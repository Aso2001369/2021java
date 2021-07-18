package SubmarineGame;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.gameTitle();
        game.gameStart();
        game.gameStatus();
        game.positionSet();
        game.gameResult();
        while(game.getLoseSubmarines()<3){
            game.gameStatus();
            game.positionSet();
            game.gameResult();
        }
        System.out.println("ゲーム終了です！遊んでくれてありがとう！");
    }
}
