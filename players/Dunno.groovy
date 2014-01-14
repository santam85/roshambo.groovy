package players

class Dunno {
        static descr = 'What were we doing again?'

	static rnd = new Random()

        static hand = { myhands, yourhands ->
		rnd.nextInt(3)
	};
};
