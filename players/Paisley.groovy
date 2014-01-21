package players

class Paisley {
	static descr = 'Polka dots!'

	static hand = { myhands, yourhands ->
		if (yourhands.size() < 2) 0 else {
			def str = yourhands.join('')
			def search = yourhands[-1].toString() +
				yourhands[-2].toString()
			def counts = [0, 1, 2]
				.collect({ hand ->
					str.count(search + hand)
				})

			if (counts[0] > counts[1] & counts[0] > counts[2]) 1 else
			if (counts[1] > counts[0] & counts[1] > counts[2]) 2 else
			0
		}
	};
};
