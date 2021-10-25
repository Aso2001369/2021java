package rpgcreature;

/**
 * 生物クラス
 * 勇者やモンスターの基本的な機能を持つクラス
 */
public abstract class Creature {
    private String name;
    protected int hp;
    protected int gold;
    protected int def;

    /**
     * コンストラクタ
     * @param name：名前
     * @param hp：最大HP
     */
    public Creature(String name,int hp,int gold,int def){
        this.name = name;
        this.hp = hp;
        this.gold = gold;
        this.def = def;
    }

    /**
     * 攻撃メソッド
     * @param opponent：攻撃相手
     */
    public abstract void attack(Creature opponent);

    /**
     * ダメージを受けるメソッド
     * @param damage：受けるダメージ数
     */
    public int damaged(int damage,int def,Creature Creature){
        int finalDamage=0;
        if(damage-def<=0){
            //ダメージが防御力を上回れなかった場合  
            System.out.printf("%sに攻撃は通じなかった！\n",Creature.getName());
        }else{
            //ダメージが防御力を上回った場合  
            hp -= damage-def;
            finalDamage = damage-def;
        }
        
        if( hp <0 ){
            hp = 0;
        }
        return finalDamage;
    }

    /**
     * 生きているかを確認するメソッド
     * @return true:生きている false:死んでいる
     */
    public boolean isAlive(){
        return (hp>0);
    }

    /**
     * 名前を取得する
     * @return 取得した名前
     */
    public String getName(){
        return name;
    }

    /**
     * 現在のHPを取得する
     * @return 現在のHP
     */
    public int getHp(){
        return hp;
    }

    /**
     * ダメージを与えた際に表示するメッセージ
     * @param opponent ダメージを与えた相手
     * @param damage　与えたダメージ数
     */
    protected void displayMessage(Creature opponent,int damage){
        System.out.printf("%sは%sに%dのダメージを与えた\n",name,opponent.getName(),damage);
    }
}
