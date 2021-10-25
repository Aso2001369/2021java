package rpgcreature;
import java.util.Random;

//ゴーレムクラス
public class Golem extends Monster{
    private final static int CRITICAL_HIT_RATE = 5;
    /**
     * protected int gold=100;
     * これだと親クラスのgoldを上書きしてるから親クラスのgetgold（）から取れない
     */
    

    /**
     * ゴーレムクラスのコンストラクタ
     * @param ゴーレムのHPは100！
     */
    public Golem(){
        super("ゴーレム",100,100);
    }

    /**
     * 攻撃メソッド
     * @param min：通常ダメージは5~10
     */
    @Override
    public void attack(Creature opponent){
        Random r = new Random();
        int min = 5;
        int damage = 0;
        System.out.printf("%sの攻撃！\n",getName());
         //クリティカルヒットかのチェック
         if( r.nextInt(100) < CRITICAL_HIT_RATE ){
            //クリティカルヒット
            damage = 30;
            System.out.printf("%sのクリティカルヒット！\n",getName());
        }else{
            damage = r.nextInt(min)+min;
            
        }
        opponent.damaged(damage);
        
        displayMessage(opponent,damage);
    }
}
