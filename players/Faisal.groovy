package players

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
class Faisal {
	static ROCK = 0
	static PAPER = 1
	static SCISSORS = 2
	static descr = '[[this is you!]]'

	static rnd = new Random()

	static beat = { hand ->
		(hand + 1) % 3
	}

	static hand = { myhands, yourhands ->
		if (yourhands.size() == 0) { rnd.nextInt(3) }
		else if (yourhands.size() > 6) {
				def str = yourhands.join('')

			// Rock/Lisa
			if (str ==~ /.*222/) 0 else
			if (str ==~ /.*000/) 1 else
			if (str ==~ /.*111$/) 2 else

			if (str ==~ /.*012012.*/) this.beat (yourhands.last() + 1 % 3) else
			
			if (yourhands.last() == (myhands.last() + 2 % 3)) myhands.last() + 2 % 3 else

			rnd.nextInt(3)
		} else {
			rnd.nextInt(3)
		}
	}
}
