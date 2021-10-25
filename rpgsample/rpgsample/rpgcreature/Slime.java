package rpgcreature;

import java.util.Random;

/**
 * スライムクラス
 */
public class Slime extends Monster{
    /**
     * スライムクラスのコンストラクタ
     */
    public Slime(){
        super("スライム",12,10,1);
    }

    /**
     * 攻撃メソッド
     * @param opponent：攻撃相手
     */
    @Override
    public void attack(Creature opponent) {
        
        Random r = new Random();
        int damage = r.nextInt(5);
        System.out.printf("%sの攻撃！\n",getName());
        
        int finalDamage = opponent.damaged(damage,opponent.def,opponent);
        
        if(finalDamage>0){
            displayMessage(opponent,finalDamage);
        }

    }
    
}
