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
class Santa {
	static ROCK = 0
	static PAPER = 1
	static SCISSORS = 2
	static descr = 'Santa'

	static rnd = new Random()
	
	static freq = [0, 0, 0]

	static beat = { hand ->
		(hand + 1) % 3
	}

	// 0   1   2   3
	// 1   2   3   4
	// r [1]+2 r  [3]+4 
	static isfoxtrot = { myhands, yourhands, progression ->
		progression = [progression,[myhands.size()-1,0].max()].min();
		def flag = true;
		def turn = myhands.size()+1;
		progression.times { i ->
			flag = flag & yourhands[2*i+1]  == (yourhands[2*i]+2*(i+1))%3
		}
		return flag;
	}

	static hand = { myhands, yourhands ->
		def balance = 0;
		if (yourhands.size() == 0) {
			// reset counters
			freq = [0, 0, 0]
			PAPER
		} else {
			def hand;
			def pattern = yourhands.join('');
			if(pattern ==~ /^11120.*/){ 
				def pie = [1,1,1,2,0,2,0,2,0,2,2,0,1,0,0];

				return hand = this.beat(pie[yourhands.size()%pie.size()]) 
			} else 
			if(pattern ==~ /^12211.*$/) {
				return hand = this.beat(myhands.last()+1);
			}else
			if(this.isfoxtrot(myhands,yourhands,1)){
				def turn = myhands.size() + 1;
				if(turn%2==0)
					return hand = this.beat((yourhands[turn-2]+turn)%3);
				else
					return hand = rnd.nextInt(3);
			} else
			if(pattern ==~ /.*000$/){ hand = this.beat(ROCK) } else
			if(pattern ==~ /.*111$/){ hand = this.beat(PAPER) } else
			if(pattern ==~ /.*222$/){ hand = this.beat(SCISSORS) } else
			if(pattern ==~ /.*012$/){ hand = this.beat(ROCK) } else
			if(pattern ==~ /.*120$/){ hand = this.beat(PAPER) } else
			if(pattern ==~ /.*201$/){ hand = this.beat(SCISSORS) } else 
			{
				freq[yourhands.last()] += 1
				if (freq[ROCK] > 1.1*freq[PAPER] & freq[ROCK] > 1.1*freq[SCISSORS]) hand = this.beat(ROCK) else
				if (freq[PAPER] > 1.1*freq[ROCK] & freq[PAPER] > 1.1*freq[SCISSORS]) hand = this.beat(PAPER) else
				if (freq[SCISSORS] > 1.1*freq[ROCK]) hand = this.beat(SCISSORS) else
				hand = this.beat(ROCK)
			}

			if(myhands.last() == this.beat(yourhands.last()))
				balance++;
			if(yourhands.last() == this.beat(myhands.last()))
				balance--;

			if (balance < -30) {
				hand = this.beat(hand);
			}

			return hand

		}
	}
}
