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
class Fubar {
    static ROCK = 0
    static PAPER = 1
    static SCISSORS = 2
    static descr = 'fubar'

    static rnd = new Random()
    static freq = [0, 0, 0]

    static beat = { hand ->
        (hand + 1) % 3
    }

    static freqWinner = 0
    static freqWinnerRatio = []
	
    //static testLoopValue = 1000

    static hand = { myhands, yourhands ->

        if (yourhands.size() == 0) {
            // reset counters
            freq = [0, 0, 0]
            0
        } else {
            freq[yourhands.last()] += 1


            //println("fo:" + freq[0] + "f1:" + freq[1] + "f2:" + freq[2])

			

            freqWinnerRatio[0] = freq[0] / yourhands.size() * 100
            freqWinnerRatio[1] = freq[1] / yourhands.size() * 100
            freqWinnerRatio[2] = freq[2] / yourhands.size() * 100
            
            if (freqWinnerRatio[0] > freqWinnerRatio[1] & freqWinnerRatio[0] > freqWinnerRatio[2])
                freqWinner = 0
            else if (freqWinnerRatio[1] > freqWinnerRatio[0] & freqWinnerRatio[1] > freqWinnerRatio[2])
                freqWinner = 1
            else if (freqWinnerRatio[2] > freqWinnerRatio[0] & freqWinnerRatio[2] > freqWinnerRatio[1])
                freqWinner = 2
            

            //println("ratio was:" + freqWinnerRatio[freqWinner] + ", " + freqWinner)


            if (freqWinnerRatio[freqWinner] > 35) {
				    //println("beat " + this.beat(freqWinner))
        
				this.beat(freqWinner) }
			else if (myhands.size() == 0) {
				//println("beat scissors")
		
					return this.beat(SCISSORS)
			} else if (freqWinnerRatio[0] > 32 & freqWinnerRatio[0] < 35 &
						freqWinnerRatio[1] > 32 & freqWinnerRatio[1] < 35 &
						freqWinnerRatio[2] > 32 & freqWinnerRatio[2] < 35 ) {
					(yourhands.last() + 2) % 3
			
			} else {
				return rnd.nextInt(3)
			}
			

        }

        
       
    }
}
