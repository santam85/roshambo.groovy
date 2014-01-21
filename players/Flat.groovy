package players

class Flat {
	static descr = '3x head! The next one must be tails.'

	static rnd = new Random()

	static hand = { myhands, yourhands ->
		if (myhands.size() == 0) rnd.nextInt(3) else {
			def freq = [0, 1, 2].collect({ hand->
				myhands
					.findAll({ x ->
						x == hand
					})
					.size()
			})

			if (freq[0] >= freq[1] + 3) 1 else
			if (freq[0] >= freq[2] + 3) 2 else
			if (freq[1] >= freq[0] + 3) 0 else
			if (freq[1] >= freq[2] + 3) 2 else
			if (freq[2] >= freq[0] + 3) 0 else
			if (freq[2] >= freq[1] + 3) 1 else
			rnd.nextInt(3)
		}
	};
};
