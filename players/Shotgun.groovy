package players

class Shotgun {
        static descr = 'Rock paper shotgun!'

	static rnd = new Random()

        static hand = { myhands, yourhands ->
		def hand = rnd.nextInt(5)
		hand > 2 ? 2 : hand
	};
};
