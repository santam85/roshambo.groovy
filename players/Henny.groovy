package players

// brilliantly simple almost one-liner - surprisingly strong
// see http://webdocs.cs.ualberta.ca/~darse/rsbpc.html
// see http://advogato.org/person/Bram/diary/10.html
class Henny {
	static descr = 'Learn from the past'

	static rnd = new Random();

	static hand = { myhands, yourhands ->
		if (yourhands.size() == 0) rnd.nextInt(3) else
		(yourhands[rnd.nextInt(yourhands.size())] + 1) % 3
	};
};
