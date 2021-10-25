package rpgcreature;

import java.util.Random;

/**
 * 勇者クラス
 */
public class Braver extends Creature{
    private final static int MAX_HP = 100;
    private final static int RECOVERY_POINT = 20;
    private final static int CRITICAL_HIT_RATE = 10;
    private static int gold = 0;
    private static int def = 20;

    /**
     * 勇者クラスのコンストラクタ
     */
    public Braver(String name){
        super(name,MAX_HP,gold,def);
    }
    
    /**
     * 攻撃メソッド
     * @param opponent：攻撃相手
     */
    @Override
    public void attack(Creature opponent){
        Random r = new Random();
        int damage = 0;
        System.out.printf("%sの攻撃！\n",getName());

        //クリティカルヒットかのチェック
        if( r.nextInt(100) < CRITICAL_HIT_RATE ){
            //クリティカルヒット
            damage = 50;
            System.out.printf("%sのクリティカルヒット！\n",getName());
        }else{
            //敵が防御力を得て堅くなったので勇者も強くしました
            damage = r.nextInt(5)+5;
            
        }
        int finalDamage = opponent.damaged(damage,opponent.def,opponent);
        
        if(finalDamage>0){
            displayMessage(opponent,finalDamage);
        }
    }

    /**
     * HP回復処理
     */
    public void recovery(){
        System.out.printf("%sはHPを回復した！\n",getName());
        hp += RECOVERY_POINT;
        if( hp > MAX_HP ){
            hp = MAX_HP;
        }
    }

    public int getTOTAL_GOLD(){
        return gold;
    }

    public void setTOTAL_GOLD(int TOTAL_GOLD){
        gold+=TOTAL_GOLD;
    }
}
