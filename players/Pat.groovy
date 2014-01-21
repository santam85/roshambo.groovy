package players

class Pat {
	static descr = 'Simple pattern matcher'

	static rnd = new Random()

	static hand = { myhands, yourhands ->
		if (yourhands.size() < 6) rnd.nextInt(3) else {
			def str = yourhands.join('')

			// Rock/Lisa
			if (str ==~ /.*222/) 0 else
			if (str ==~ /.*000/) 1 else
			if (str ==~ /.*111$/) 2 else

			// Rot
			if (str ==~ /.*012012.*/) (yourhands.last() + 2) % 3 else

			// Bait
			if (str !=~ /.*(00|11|22).*/) (yourhands.last() + 2) % 3 else

			// Defensive
			rnd.nextInt(3)

		}
	};
};
