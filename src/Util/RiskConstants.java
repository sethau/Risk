package Util;

import java.util.HashMap;
import java.util.Map;

import Map.Continent;

public class RiskConstants {
	public static int SEED = 0;
	
	public static final int NUM_WILD_CARDS = 2;
	public static final String[] REG_CARD_TYPES = {"HORSE", "SOLDIER", "CANNON"};
	public static final String WILD_CARD = "WILD";
	public static final int NUM_CARD_TURN_IN = 3;
	public static final int FORCE_TURN_IN = 5;
	
	public static final int MAX_ATK_DICE = 3;
	public static final int MAX_DFD_DICE = 2;
	
	public static final int MIN_PLAYERS = 2;
	public static final int MAX_PLAYERS = 6;
	
	public static final String DEFAULT_PLAYERS = "Easy,Normal,Hard";
	
	public static final int MAX_ROUNDS = 100000;
	
	public static final int INIT_ARMIES = 120;
	public static final int MIN_REINFORCEMENTS = 3;
	public static final int COUNTRY_ARMY_DIVISOR = 3;
	public static final int BONUS_COUNTRY_ARMIES = 2;
	public static final Map<Continent, Integer> CONTINENT_BONUSES;
	static {
		CONTINENT_BONUSES = new HashMap<Continent, Integer>();
		CONTINENT_BONUSES.put(Continent.ASIA, 7);
		CONTINENT_BONUSES.put(Continent.NORTHAMERICA, 5);
		CONTINENT_BONUSES.put(Continent.EUROPE, 5);
		CONTINENT_BONUSES.put(Continent.AFRICA, 3);
		CONTINENT_BONUSES.put(Continent.SOUTHAMERICA, 2);
		CONTINENT_BONUSES.put(Continent.AUSTRALIA, 2);
	};
	
	public static final int MAX_ATTEMPTS = 5;
	
	private static final int TURN_IN_START_A = 4;
	private static final int INC_A = 2;
	private static final int TURN_IN_SWITCH = 12;
	private static final int TURN_IN_START_B = 15;
	private static final int INC_B = 5;
	private static int LAST_TURN_IN = 0;
	
	private static int getNextTurnInValue() {
		if (LAST_TURN_IN == 0) {
			return TURN_IN_START_A;
		}
		else if (LAST_TURN_IN < TURN_IN_SWITCH) {
			return LAST_TURN_IN + INC_A;
		}
		else if (LAST_TURN_IN == TURN_IN_SWITCH) {
			return TURN_IN_START_B;
		}
		else {
			return LAST_TURN_IN + INC_B;
		}
	}
	
	public static int advanceTurnIn() {
		LAST_TURN_IN = getNextTurnInValue();
		return LAST_TURN_IN;
	}
	
	public static int peekNextTurnIn() {
		return getNextTurnInValue();
	}
	
	public static void resetTurnIn() {
		LAST_TURN_IN = 0;
	}
}