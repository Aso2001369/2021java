package SubmarineGame;
import java.util.Scanner;

public class Game {
    private Submarine[] Submarines;
    private static int turn = 1;
    private static int inputX;
    private static int inputY;
    private int LoseSubmarines=0;
    Scanner sc = new Scanner(System.in);
    //ゲームタイトルを表示
    public void gameTitle(){
        System.out.println("************************");
        System.out.println("弾道ミサイル潜水艦ゲーム");
        System.out.println("************************");
    }
    //潜水艦インスタンスを作り、初期位置を決定した後に配列へインスタンスを入れる
    public void gameStart(){
        Submarine sub1 = new Submarine();
        sub1.setFirstPosition();
        Submarine sub2 = new Submarine();
        sub2.setFirstPosition();
        Submarine sub3 = new Submarine();
        sub3.setFirstPosition();
        //作った潜水艦の数を取得
        int SubmarineCount=sub3.getSubmarineCount();
        //作ったインスタンスは配列に入れる
        Submarines = new Submarine[SubmarineCount];
        Submarines[0] = sub1;
        Submarines[1] = sub2;
        Submarines[2] = sub3;
    }
    //潜水艦の状態の表示
    public void gameStatus(){
        System.out.printf("---------ターン%d--------\n",turn);
        System.out.printf("%s:%s\n",Submarines[0].getSubmarineName(),Submarines[0].getCondition());
        System.out.printf("%s:%s\n",Submarines[1].getSubmarineName(),Submarines[1].getCondition());
        System.out.printf("%s:%s\n",Submarines[2].getSubmarineName(),Submarines[2].getCondition());
    }
    //座標入力を促す
    public void positionSet(){
        System.out.println("爆弾のx座標を入力してください(1-5)");
        inputX = sc.nextInt();
        System.out.println("爆弾のy座標を入力してください(1-5)");
        inputY = sc.nextInt();
        //1~5以外の座標を指定した場合は再度入力させる
        while(inputX>5||inputX<1 || inputY>5||inputY<1){
            System.out.println("再度爆弾のx座標を入力してください(1-5)");
            inputX = sc.nextInt();
            System.out.println("再度爆弾のy座標を入力してください(1-5)");
            inputY = sc.nextInt();
        }
    }
    //結果を表示
    public void gameResult(){
        System.out.println(gameResultDetail(Submarines, 0));
        System.out.println(gameResultDetail(Submarines, 1));
        System.out.println(gameResultDetail(Submarines, 2));
        turn++;
    }
    //結果の判定を行う

    //ここでif(Submarines[number].setCondition().equals("撃沈"))みたいな感じで撃沈した船を省いていく
    public String gameResultDetail(Submarine[] submarines,int number){
        if(Submarines[number].getCondition().equals("撃沈済み")){
            return "撃沈済み";
        }
        //爆弾が命中した場合
        if(Submarines[number].getX()==inputX && Submarines[number].getY()==inputY){
            //命中したらHPを１減らす
            Submarines[number].setHp();
            //残りHPによって表示文章を変える
            if(Submarines[number].getHp()==0){
                //潜水艦の状態を生きてるから撃沈済みに変更
                Submarines[number].setCondition();
                LoseSubmarines++;
                return "撃沈！";
            }else{
                Submarines[number].changePosition(number);
                return "命中だがまだ沈まない　移動します";
            }
        }else if(Submarines[number].getX()==inputX-1 && Submarines[number].getY()==inputY){
            return "波高し";
        }else if(Submarines[number].getX()==inputX+1 && Submarines[number].getY()==inputY){
            return "波高し";
        }else if(Submarines[number].getX()==inputX && Submarines[number].getY()==inputY-1){
            return "波高し";
        }else if(Submarines[number].getX()==inputX && Submarines[number].getY()==inputY+1){
            return "波高し";
        }else{
            return "はずれ";
        }
    }
    public int getLoseSubmarines(){
        return this.LoseSubmarines;
    }
}
