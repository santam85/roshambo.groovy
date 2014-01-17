package players

class Beatfreak {
	static descr = 'Rhythm is everything'

	static freq = [0, 0, 0]

	static hand = { myhands, yourhands ->
		if (yourhands.size() == 0) {
			// reset counters
			freq = [0, 0, 0]
			0
		} else {
			freq[yourhands.last()] += 1

			if (freq[0] > freq[1] & freq[0] > freq[2]) 1 else
			if (freq[1] > freq[0] & freq[1] > freq[2]) 2 else
			0
		}
	};
};
