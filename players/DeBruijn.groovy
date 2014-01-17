package players

class DeBruijn {
	static len = 7
	static descr = 'So unpredictable it becomes predictable'

	static hand = { myhands, yourhands ->
		if (myhands.size() < len) 0 else {
			// almost DeBruijn - no 2222222
			(myhands[-len] + myhands[-1] + 1) % 3
		}
	};
};
