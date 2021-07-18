package SubmarineGame;
import java.util.Random;

public class Submarine {
    private static int SubmarineCount=0;
    private String SubmarineName;
    private String condition="生きてる";
    private int x;
    private int y;
    private int hp =3;
    //潜水艦の初期位置を保存する配列。これを使って初期位置の重複をなくす。
    private int[][] num = new int[3][2];
    Random r = new Random();
    
    public Submarine(){
        SubmarineCount++;
        SubmarineName="潜水艦"+SubmarineCount;
    }
    //潜水艦の初期位置を重複無く決定する
    public void setFirstPosition(){
        this.x=r.nextInt(5)+1;
        this.y=r.nextInt(5)+1;
        if(SubmarineCount==1){
            num[SubmarineCount-1][0]=this.x;
            num[SubmarineCount-1][1]=this.y;
        }else{
            for(int i=SubmarineCount-1;i>0;i--){
                while(this.x==num[SubmarineCount-1][0]&&this.y==num[SubmarineCount-1][1]){
                    this.x=r.nextInt(5)+1;
                    this.y=r.nextInt(5)+1;
                }
            }
        }
    }
    //爆撃された潜水艦を移動させる
    public void changePosition(int number){
        //ここ本当にthisでいいのか？
        this.x=r.nextInt(5)+1;
        this.y=r.nextInt(5)+1;
        //他の潜水艦と位置が被らないようにする
        for(int i=0;i<=2;i++){
            if(i==number){
                continue;
            }
            if(this.x==num[i][0]&&this.y==num[i][1]){
                while(this.x==num[i][0]&&this.y==num[i][1]){
                    this.x=r.nextInt(5)+1;
                    this.y=r.nextInt(5)+1;
                }
            }
        }
    }
    public int getSubmarineCount(){
        return Submarine.SubmarineCount;
    }
    public String getSubmarineName(){
        return this.SubmarineName;
    }
    public String getCondition(){
        return this.condition;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getHp(){
        return this.hp;
    }
    public void setHp(){
        this.hp-=1;
    }
    public void setCondition(){
        this.condition="撃沈済み";
    }

}