package players

class Bait {
	static descr = 'Truly random'

	static rnd = new Random()

	static hand = { myhands, yourhands ->
		if (myhands.size() == 0) rnd.nextInt(3) else
		(myhands.last() + 1 + rnd.nextInt(2)) % 3
	};
};
