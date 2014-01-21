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
class Yakko {
	static ROCK = 0
	static PAPER = 1
	static SCISSORS = 2
	static descr = 'Hellooooo nurse!!!!!'

	static rnd = new Random()



	static hand = { myhands, yourhands ->
		// TODO: Not so brilliant yet...

        if (myhands.size() == 0) rnd.nextInt(3) else {
            def CountRock = yourhands.count { it == ROCK }
            def CountPaper =  yourhands.count { it == PAPER }
            def CountScissors =  yourhands.count { it == SCISSORS }

            switch( yourhands.size() ) {
                case CountRock:
                    PAPER
                    break
                case CountPaper:
                    SCISSORS
                    break
                case CountScissors:
                    ROCK
                    break
                default:
                    if ( CountRock > CountPaper ) {
                        PAPER
                    }  else if ( CountPaper > CountScissors ) {
                        SCISSORS
                    }   else if ( CountScissors > CountRock ) {
                        ROCK
                    }   else {
                        (myhands.last() + 1 + rnd.nextInt(2)) % 3
                    }
            }
        }
	}
}
