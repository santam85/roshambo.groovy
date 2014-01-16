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
class Player1 {
	static ROCK = 0
	static PAPER = 1
	static SCISSORS = 2
	static descr = '[[this is you!]]'

	static beat = { hand ->
		(hand + 1) % 3
	}

	static hand = { myhands, yourhands ->
		// TODO: add brilliant strategy here
		SCISSORS
	}
}
