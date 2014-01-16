package players

class Goldfish {
	static descr = 'Three second memory'

	static hand = { myhands, yourhands ->
		if (yourhands.size() == 0) 1 else
		(yourhands.last() + 1) % 3
	};
};
