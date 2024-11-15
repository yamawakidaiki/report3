package jp.ac.uryukyu.ie.e235221;

/**
 * 敵クラス。
 * String name; //敵の名前
 * int hitPoint; //敵のHP
 * int attack; //敵の攻撃力
 * boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Enemy {
	// public String name;
	// public int hitPoint;
	// public int attack;
	// public boolean dead;
	private String name;
	private int hitPoint;
	private int attack;
	private boolean dead;

	public String getName() {
		return name;
	}

	public int getHitPoint() {
		return hitPoint;
	}

	public int getAttack() {
		return attack;
	}

	public boolean isDead() {
		return dead;
	}

	/**
	 * コンストラクタ。名前、最大HP、攻撃力を指定する。
	 * 
	 * @param name      モンスター名
	 * @param maximumHP モンスターのHP
	 * @param attack    モンスターの攻撃力
	 */
	public Enemy(String name, int maximumHP, int attack) {
		this.name = name;
		hitPoint = maximumHP;
		this.attack = attack;
		dead = false;
		System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
	}

	/**
	 * Heroへ攻撃するメソッド。
	 * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
	 * 
	 * @param hero 攻撃対象
	 */
	// public void attack(Hero hero) {
	// int damage = (int) (Math.random() * attack);
	// System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, hero.name, damage);
	// hero.wounded(damage);
	// }

	public void attack(Hero hero) {
		// 敵が生きているなら
		if (!this.dead) {
			// ダメージを計算
			int damage = (int) (Math.random() * attack);
			System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, hero.getName(), damage);

			// 相手にダメージを与える
			hero.wounded(damage);
		} else {
			// 敵が死んでいるとき
			System.out.printf("%sは既に死亡しているため、攻撃できない。\n", name);
		}
	}

	/**
	 * 自身へ攻撃されたときのダメージ処理をするメソッド。
	 * 指定されたダメージを hitPoint から引き、死亡判定を行う。
	 * 
	 * @param damage 受けたダメージ
	 */
	public void wounded(int damage) {
		hitPoint -= damage;
		if (hitPoint < 0) {
			dead = true;
			System.out.printf("モンスター%sは倒れた。\n", name);
		}
	}

}
