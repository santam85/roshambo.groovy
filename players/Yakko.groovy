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

        if ( myhands.size() == 0) rnd.nextInt(3) else {
            def CountRock = yourhands.count { it == ROCK }
            def CountPaper =  yourhands.count { it == PAPER }
            def CountScissors =  yourhands.count { it == SCISSORS }

            def map = [ROCK:CountRock, PAPER:CountPaper ,SCISSORS:CountScissors];
            def sortedByValue = map.sort { a,b -> a.value <=> b.value }
//            println(sortedByValue.size());

            if ( yourhands.size() >= 7  ) {

                def Route1 = ( yourhands.get(0));
                def Route2 = ( yourhands.get(3));

                if ( yourhands.size() == CountRock )     {
                    PAPER
                } else if ( yourhands.size() == CountPaper ) {
                    SCISSORS;
                } else if ( yourhands.size() == CountScissors ){
                    ROCK;
                } else if ( Route1 == Route2 ) {
                    def play = ( yourhands.size() +1 ) % 3
                    def Play = yourhands.get(play)
                    Play
                } else {
                    rnd.nextInt(3)
                }

            } else {
                rnd.nextInt(3)
            }
        }
	}
}
