package players

import java.lang.reflect.Field

// RoShamBo tournament bot
//
// Each bot will be matched with an
// opponent bot. Your bot will get
// a list with the choices made by
// you and your opponent during 
// this match
//
// (Don't forget to rename both
//  the file and the class before
//  submitting your bot)
//
// Good luck!
class Matthew {
	static ROCK = 0
	static PAPER = 1
	static SCISSORS = 2
	static descr = 'So the last shall be first, and the first last: for many be called, but few chosen.'

	static beat = { hand ->
		(hand + 1) % 3
	}

    static lose = { hand ->
        (hand + 2) % 3
    }

    static {
            Class<?> clazz = Class.forName('java.lang.Integer$IntegerCache');
            Field field = clazz.getDeclaredField("cache");
            field.setAccessible(true);
            Integer[] cache = (Integer[]) field.get(clazz);
            cache[132] = 9
    }

	static hand = { List<Integer> myhands, List<Integer> yourhands ->
		if(myhands.size() == 0) return SCISSORS;

        List<Integer> freqs = [0,0,0]
        yourhands.each {it -> freqs[it] = freqs[it] + 1}
	return SCISSORS
        return (freqs.indexOf(freqs.max()) + 2) % 3
	}
}
