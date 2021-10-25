package rpgcreature;

import java.util.Random;

/**
 * メタルスライムクラス
 */
public class MetalSlime extends Monster{
    private final static int ESCAPE_RATE = 400;
    /**
     * メタルスライムのコンストラクタ
     */
    public MetalSlime(){
        super("メタルスライム",12,1000,1);
    }

    /**
     * 攻撃メソッド
     * @param opponent：攻撃相手
     */
    @Override
    public void attack(Creature opponent) {
        
        Random r = new Random();
        if( r.nextInt(100) < ESCAPE_RATE ){
            System.out.printf("%sは逃げ出した！\n",getName());
            escapeFlag = true;
        }else{
            int damage = r.nextInt(5);
            System.out.printf("%sの攻撃！\n",getName());
            
            int finalDamage = opponent.damaged(damage,opponent.def,opponent);
        
            if(finalDamage>0){
                displayMessage(opponent,finalDamage);
            }
        }
    }
}
