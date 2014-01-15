package players

class Beatfreak {
	static descr = 'Rhythm is everything'

	static hand = { myhands, yourhands ->
		if (yourhands.size() == 0) 0 else {
			def freq = [0, 1, 2].collect({ hand->
				yourhands
					.findAll({ x ->
						x == hand
					})
					.size()
			})

			if (freq[0] > freq[1] & freq[0] > freq[2]) 1 else
			if (freq[1] > freq[0] & freq[1] > freq[2]) 2 else
			0
		}
	};
};
