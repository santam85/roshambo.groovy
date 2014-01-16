package players

class Rot {
        static descr = 'History repeating itself'

        static hand = { myhands, yourhands ->
		if (myhands.size() == 0) 0 else
		(myhands.last() + 1) % 3
	};
};
