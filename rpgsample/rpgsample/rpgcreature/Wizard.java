package rpgcreature;

import java.util.Random;

/**
 * 魔法使いクラス
 */
public class Wizard extends Monster{
    /**
     * 魔法使いのコンストラクタ
     */
    public Wizard(){
        super("魔法使い",30,20,3);
    }

    /**
     * 攻撃メソッド
     * @param opponent：攻撃相手
     */
    @Override
    public void attack(Creature opponent) {
        
        Random r = new Random();
        int damage = 0;
        if( r.nextInt(100) < 70){
            System.out.printf("%sは上級魔法を唱えた！\n",getName());
            damage = r.nextInt(20)+20;
        }else{
            System.out.printf("%sの攻撃！\n",getName());
            damage = r.nextInt(5)+1;
        }

        int finalDamage = opponent.damaged(damage,opponent.def,opponent);
        
        if(finalDamage>0){
            displayMessage(opponent,finalDamage);
        }
    }
}
