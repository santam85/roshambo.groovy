package players

class Foxtrot {
	static descr = 'Quick quick slow'

	static rnd = new Random();

	static hand = { myhands, yourhands ->
		def turn = myhands.size() + 1
		if (turn % 2 == 1) rnd.nextInt(3) else
		(myhands.last() + turn) % 3
	};
};
